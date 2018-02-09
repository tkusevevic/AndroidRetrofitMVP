package com.tkusevic.beerappretrofit.ui.beer;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.tkusevic.beerappretrofit.R;
import com.tkusevic.beerappretrofit.commons.Constants;
import com.tkusevic.beerappretrofit.commons.Utils.CircleTransform;
import com.tkusevic.beerappretrofit.data.model.Beer;
import com.tkusevic.beerappretrofit.networking.BackendFactory;
import com.tkusevic.beerappretrofit.networking.BeersApiService;
import com.tkusevic.beerappretrofit.presentation.BeerDetailsPresenter;
import com.tkusevic.beerappretrofit.presentation.BeerDetailsPrestenterImpl;


/**
 * Created by tkusevic on 05.02.2018..
 */

public class BeerDetailsActivity extends AppCompatActivity implements View.OnClickListener, BeerDetailsView {

    private ImageView image;
    private TextView style;
    private TextView description;

    private BeerDetailsPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beer_details);
        presenter = new BeerDetailsPrestenterImpl(BackendFactory.getBeerDetailsInteractor());
        presenter.setBaseView(this);
        initUi();
        getBeerData();
    }

    private void initUi() {
        image = findViewById(R.id.image_details);
        style = findViewById(R.id.style_details);
        description = findViewById(R.id.description_details);
        ImageView back = findViewById(R.id.backDetails);
        back.setOnClickListener(this);
    }

    private void getBeerData() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            presenter.setBeerId(extras.getString(Constants.BEER_ID));
        }
        presenter.getBeerById();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case (R.id.backDetails):
                finish();
                break;
        }
    }

    @Override
    public void setBeer(Beer beer) {
        image.setImageResource(R.drawable.no_picture);
        if (beer != null) {
            if (beer.getLabels() != null) {
                Picasso.with(this).
                        load(beer.getLabels().getLarge()).
                        transform(new CircleTransform()).into(image);
            }
            style.setText(beer.getStyle().getName());
            description.setText(beer.getDescription());
        }
    }
}
