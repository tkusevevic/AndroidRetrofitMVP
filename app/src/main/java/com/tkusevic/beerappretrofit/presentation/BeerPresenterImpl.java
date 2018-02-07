package com.tkusevic.beerappretrofit.presentation;

import com.tkusevic.beerappretrofit.data.model.Beer;
import com.tkusevic.beerappretrofit.data.response.BeersResponse;
import com.tkusevic.beerappretrofit.interaction.BeerInteractor;
import com.tkusevic.beerappretrofit.ui.beer.BeerView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by tkusevic on 06.02.2018..
 */

public class BeerPresenterImpl implements BeerPresenter {

    private final BeerInteractor interactor;

    private BeerView beerView;

    private int styleId;

    public BeerPresenterImpl(BeerInteractor interactor) {
        this.interactor = interactor;
    }

    @Override
    public void setBaseView(BeerView baseView) {
        this.beerView = baseView;
    }

    @Override
    public void setStyleId(int styleId) {
        this.styleId = styleId;
    }

    @Override
    public void getBeersByStyle() {
        interactor.getBeersByStyle(styleId, getBeersCallback());
    }

    @Override
    public void onBeerClicked(Beer beer) {
        if (beer != null)
            beerView.startDetails(beer);
    }

    @Override
    public void loadNextPage(int page) {
        interactor.loadNextPage(styleId, page, addBeersCallback());
    }

    private Callback<BeersResponse> getBeersCallback() {
        return new Callback<BeersResponse>() {

            @Override
            public void onResponse(Call<BeersResponse> call, Response<BeersResponse> response) {
                if (response.isSuccessful()) {
                    beerView.setBeers(response.body().getBeers());
                }
            }

            @Override
            public void onFailure(Call<BeersResponse> call, Throwable t) {

            }
        };
    }

    private Callback<BeersResponse> addBeersCallback() {
        return new Callback<BeersResponse>() {
            @Override
            public void onResponse(Call<BeersResponse> call, Response<BeersResponse> response) {
                if (response.isSuccessful()) {
                    beerView.addBeers(response.body().getBeers());
                }
            }

            @Override
            public void onFailure(Call<BeersResponse> call, Throwable t) {

            }
        };
    }
}
