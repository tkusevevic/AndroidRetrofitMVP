package com.tkusevic.beerappretrofit.interaction;

import com.tkusevic.beerappretrofit.data.response.BeersResponse;

import retrofit2.Callback;

/**
 * Created by tkusevic on 06.02.2018..
 */

public interface BeerInteractor {

    void getBeersByStyle(int styleId, Callback<BeersResponse> beersCallback);

    void loadNextPage(int styleId,int page, Callback<BeersResponse> beersResponseCallback);
}
