package com.tkusevic.beerappretrofit.interaction;

import com.tkusevic.beerappretrofit.data.response.StyleResponse;

import retrofit2.Callback;


/**
 * Created by tkusevic on 07.02.2018..
 */

public interface StyleInteractor {

    void getStyles(Callback<StyleResponse> stylesCallBack);
}
