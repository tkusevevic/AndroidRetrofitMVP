package com.tkusevic.beerappretrofit.ui.categories;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.tkusevic.beerappretrofit.R;
import com.tkusevic.beerappretrofit.data.model.Category;
import com.tkusevic.beerappretrofit.data.response.CategoriesResponse;
import com.tkusevic.beerappretrofit.networking.BackendFactory;
import com.tkusevic.beerappretrofit.networking.BeersApiService;
import com.tkusevic.beerappretrofit.ui.adapters.CategoryAdapter;
import com.tkusevic.beerappretrofit.ui.beer.BeerActivity;
import com.tkusevic.beerappretrofit.ui.listener.CategoryListener;
import com.tkusevic.beerappretrofit.ui.style.StyleActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryActivity extends AppCompatActivity implements CategoryListener {

    private static final String API_KEY = "5f56eec4b4406fa4c371e708dbf96f06";
    private CategoryAdapter adapter = new CategoryAdapter();
    private BeersApiService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        service = BackendFactory.getService();
        initAdapter();
        initList();
        loadAnswers();
    }

    private void loadAnswers() {
        service.getCategories(API_KEY).enqueue(new Callback<CategoriesResponse>() {
            @Override
            public void onResponse(Call<CategoriesResponse> call, Response<CategoriesResponse> response) {
                if (response.isSuccessful()) {
                    adapter.setCategories(response.body().getCategories());
                    Log.d("MainActivity", "Category loaded!");
                } else {
                    int statusCode = response.code();
                }
            }

            @Override
            public void onFailure(Call<CategoriesResponse> call, Throwable t) {
                Log.d("MainActivity", "Category loading failed!");
            }
        });
    }


    private void initList() {
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void initAdapter() {
        adapter.setOnCategoryClickListener(this);
    }

    @Override
    public void onCategoryClick(Category category) {
        Intent intent = new Intent(this, StyleActivity.class);
        intent.putExtra("categoryId", category.getId());
        startActivity(intent);
    }
}
