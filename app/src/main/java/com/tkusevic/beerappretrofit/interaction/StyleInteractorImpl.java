package com.tkusevic.beerappretrofit.interaction;

import com.tkusevic.beerappretrofit.data.response.StyleResponse;
import com.tkusevic.beerappretrofit.networking.BeersApiService;

import retrofit2.Callback;


/**
 * Created by tkusevic on 07.02.2018..
 */

public class StyleInteractorImpl implements StyleInteractor{


    private final BeersApiService apiService;

    private static final String API_KEY = "5f56eec4b4406fa4c371e708dbf96f06";

    public StyleInteractorImpl(BeersApiService apiService) {
        this.apiService = apiService;
    }


    @Override
    public void getStyles(Callback<StyleResponse> styleCallback) {
        apiService.getStyles(API_KEY).enqueue(styleCallback);
    }
}
