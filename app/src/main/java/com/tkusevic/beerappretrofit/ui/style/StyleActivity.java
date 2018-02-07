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
import com.tkusevic.beerappretrofit.presentation.StylePresenter;
import com.tkusevic.beerappretrofit.presentation.StylePresenterImpl;
import com.tkusevic.beerappretrofit.ui.adapters.CategoryAdapter;
import com.tkusevic.beerappretrofit.ui.adapters.StyleAdapter;
import com.tkusevic.beerappretrofit.ui.beer.BeerActivity;
import com.tkusevic.beerappretrofit.ui.listener.EndlessScrollListener;
import com.tkusevic.beerappretrofit.ui.listener.StyleListener;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by tkusevic on 05.02.2018..
 */

public class StyleActivity extends AppCompatActivity implements StyleListener, StyleView{

    private static final String API_KEY = "5f56eec4b4406fa4c371e708dbf96f06";
    private StyleAdapter adapter = new StyleAdapter();

    private StylePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_style);
        initPresenter();
        initAdapter();
        initList();
        loadStyles();
    }

    private void loadStyles() {
        presenter.getStyles();
    }

    private void initPresenter() {
        presenter = new StylePresenterImpl(BackendFactory.getStyleInteractor());
        presenter.setBaseView(this);
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


    @Override
    public void onStyleClick(Style style) {
        Intent intent = new Intent(this, BeerActivity.class);
        intent.putExtra("styleId",style.getId());
        startActivity(intent);
    }

    @Override
    public void setStyles(List<Style> styles) {
        adapter.setStyles(styles);
    }
}
