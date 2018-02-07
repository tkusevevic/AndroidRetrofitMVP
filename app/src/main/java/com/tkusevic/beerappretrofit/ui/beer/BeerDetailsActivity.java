package com.tkusevic.beerappretrofit.ui.beer;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.tkusevic.beerappretrofit.R;
import com.tkusevic.beerappretrofit.commons.Constants;
import com.tkusevic.beerappretrofit.data.model.Beer;
import com.tkusevic.beerappretrofit.data.response.BeerResponse;
import com.tkusevic.beerappretrofit.networking.BackendFactory;
import com.tkusevic.beerappretrofit.networking.BeersApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by tkusevic on 05.02.2018..
 */

public class BeerDetailsActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String API_KEY = "5f56eec4b4406fa4c371e708dbf96f06";
    private ImageView image;
    private TextView style;
    private TextView description;
    private String beerId ;
    private BeersApiService service;
    private Beer beer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beer_details);
        service = BackendFactory.getService();
        initUi();
        getBeerData();
        showData();
    }

    private void showData() {
        image.setImageResource(R.drawable.no_picture);
        if (beer != null) {
            if (beer.getLabels() != null) {
                Picasso.with(this)
                        .load(beer.getLabels().getLarge())
                        .resize(Constants.PICTURE_WIDTH, Constants.PICTURE_HEIGHT)
                        .centerCrop()
                        .into(image);
            }
            style.setText(beer.getStyle().getName());
            description.setText(beer.getDescription());
        }
    }

    private void getBeerData() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            beerId = extras.getString(Constants.BEER_ID);
        }
        service.getBeerById(beerId, API_KEY).enqueue(new Callback<BeerResponse>() {
            @Override
            public void onResponse(Call<BeerResponse> call, Response<BeerResponse> response) {
                if (response.isSuccessful()) {
                    if(response.code() == Constants.RESPONSE_OK) {
                        beer = response.body().getBeer();
                        showData();
                    }
                } else {
                    Toast.makeText(BeerDetailsActivity.this, R.string.no_data_found, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<BeerResponse> call, Throwable t) {
                Toast.makeText(BeerDetailsActivity.this, R.string.something_went_wrong, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initUi() {
        image = findViewById(R.id.image_details);
        style = findViewById(R.id.style_details);
        description = findViewById(R.id.description_details);
        ImageView back = findViewById(R.id.backDetails);
        back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case (R.id.backDetails):
                finish();
                break;
        }
    }
}
