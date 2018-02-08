package com.tkusevic.beerappretrofit.interaction;

import com.tkusevic.beerappretrofit.data.response.BeerResponse;
import com.tkusevic.beerappretrofit.networking.BeersApiService;

import retrofit2.Callback;

/**
 * Created by tkusevic on 08.02.2018..
 */

public class BeerDetailsInteractorImpl implements BeerDetailsInteractor {

    private final BeersApiService apiService;

    private static final String API_KEY = "5f56eec4b4406fa4c371e708dbf96f06";

    public BeerDetailsInteractorImpl(BeersApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public void getBeerById(String beerId, Callback<BeerResponse> getBeerCallback) {
        apiService.getBeerById(beerId, API_KEY).enqueue(getBeerCallback);
    }
}
