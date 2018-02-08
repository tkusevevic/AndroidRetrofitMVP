package com.tkusevic.beerappretrofit.interaction;

import com.tkusevic.beerappretrofit.data.response.BeerResponse;

import retrofit2.Callback;

/**
 * Created by tkusevic on 08.02.2018..
 */

public interface BeerDetailsInteractor {

    void getBeerById(String beerId, Callback<BeerResponse> beerResponseCallback);
}
