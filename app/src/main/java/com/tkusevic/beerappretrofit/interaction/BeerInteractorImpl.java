package com.tkusevic.beerappretrofit.interaction;

import com.tkusevic.beerappretrofit.data.response.BeersResponse;
import com.tkusevic.beerappretrofit.networking.BeersApiService;

import retrofit2.Callback;

/**
 * Created by tkusevic on 06.02.2018..
 */

public class BeerInteractorImpl implements BeerInteractor {

    private final BeersApiService apiService;

    private static final String API_KEY = "5f56eec4b4406fa4c371e708dbf96f06";

    public BeerInteractorImpl(BeersApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public void getBeersByStyle(int styleId, Callback<BeersResponse> beersCallback) {
        apiService.getBeersByStyle(styleId, API_KEY).enqueue(beersCallback);
    }

    @Override
    public void loadNextPage(int styleId,int page, Callback<BeersResponse> beersResponseCallback) {
        apiService.getBeerByPage(styleId,page,API_KEY).enqueue(beersResponseCallback);
    }

}
