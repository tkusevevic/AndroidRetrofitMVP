package com.tkusevic.beerappretrofit.ui.beer;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.tkusevic.beerappretrofit.R;
import com.tkusevic.beerappretrofit.data.model.Beer;
import com.tkusevic.beerappretrofit.networking.BackendFactory;
import com.tkusevic.beerappretrofit.presentation.BeerPresenter;
import com.tkusevic.beerappretrofit.presentation.BeerPresenterImpl;
import com.tkusevic.beerappretrofit.ui.adapters.BeerAdapter;
import com.tkusevic.beerappretrofit.ui.listener.BeerListener;
import com.tkusevic.beerappretrofit.ui.listener.EndlessScrollListener;

import java.util.List;


public class BeerActivity extends AppCompatActivity implements BeerListener, BeerView {

    private BeerAdapter adapter = new BeerAdapter();

    private BeerPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beer);
        presenter = new BeerPresenterImpl(BackendFactory.getBeerInteractor());
        presenter.setBaseView(this);
        getStyleId();
        initAdapter();
        initList();
        loadBeers();
    }

    private void loadBeers() {
        presenter.getBeersByStyle();
    }

    private void getStyleId() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            presenter.setStyleId(extras.getInt("styleId"));
        }
    }

    private void initList() {
        RecyclerView recyclerView = findViewById(R.id.recycler_view_beer);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        EndlessScrollListener scrollListener = new EndlessScrollListener(linearLayoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                presenter.loadNextPage(page);
            }
        };
        recyclerView.addOnScrollListener(scrollListener);
    }

    private void initAdapter() {
        adapter.setOnBeerClickListener(this);
    }

    @Override
    public void onBeerClick(Beer beer) {
        presenter.onBeerClicked(beer);
    }

    @Override
    public void setBeers(List<Beer> beers) {
        adapter.setBeers(beers);
    }

    @Override
    public void startDetails(Beer beer) {
            Intent intent = new Intent(this, BeerDetailsActivity.class);
            intent.putExtra("beerId", beer.getId());
            startActivity(intent);
    }

    @Override
    public void addBeers(List<Beer> beers) {
        adapter.addBeers(beers);
    }
}
