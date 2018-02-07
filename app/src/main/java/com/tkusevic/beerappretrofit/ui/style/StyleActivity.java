package com.tkusevic.beerappretrofit.ui.style;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.tkusevic.beerappretrofit.R;
import com.tkusevic.beerappretrofit.data.model.Style;
import com.tkusevic.beerappretrofit.data.response.CategoriesResponse;
import com.tkusevic.beerappretrofit.data.response.StyleResponse;
import com.tkusevic.beerappretrofit.networking.BackendFactory;
import com.tkusevic.beerappretrofit.networking.BeersApiService;
import com.tkusevic.beerappretrofit.ui.adapters.CategoryAdapter;
import com.tkusevic.beerappretrofit.ui.adapters.StyleAdapter;
import com.tkusevic.beerappretrofit.ui.beer.BeerActivity;
import com.tkusevic.beerappretrofit.ui.listener.EndlessScrollListener;
import com.tkusevic.beerappretrofit.ui.listener.StyleListener;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by tkusevic on 05.02.2018..
 */

public class StyleActivity extends AppCompatActivity implements StyleListener{

    int categoryId=-1;
    private static final String API_KEY = "5f56eec4b4406fa4c371e708dbf96f06";
    private StyleAdapter adapter = new StyleAdapter();
    private BeersApiService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_style);
        service = BackendFactory.getService();
        getCategoryId();
        initAdapter();
        initList();
        loadAnswers();
    }

    private void getCategoryId() {
        Bundle extras = getIntent().getExtras();
        if(extras!=null){
            categoryId = extras.getInt("categoryId");
        }
    }

    private void initList() {
        RecyclerView recyclerView = findViewById(R.id.recycler_view_style);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

    }

    private void initAdapter() {
        adapter.setOnStyleClickListener(this);
    }

    private void loadAnswers() {
        service.getStyles(API_KEY).enqueue(new Callback<StyleResponse>() {
            @Override
            public void onResponse(Call<StyleResponse> call, Response<StyleResponse> response) {
                if (response.isSuccessful()) {
                    adapter.setStyles(response.body().getStyles());
                    Log.d("MainActivity", "Styles loaded!");
                } else {
                    int statusCode = response.code();
                }
            }

            @Override
            public void onFailure(Call<StyleResponse> call, Throwable t) {
                Log.d("MainActivity", "Styles loading failed!");
            }
        });
    }

    @Override
    public void onStyleClick(Style style) {
        Intent intent = new Intent(this, BeerActivity.class);
        intent.putExtra("styleId",style.getId());
        startActivity(intent);
    }
}
