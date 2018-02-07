package com.tkusevic.beerappretrofit.networking;

import com.tkusevic.beerappretrofit.data.response.BeersResponse;
import com.tkusevic.beerappretrofit.data.response.BeerResponse;
import com.tkusevic.beerappretrofit.data.response.CategoriesResponse;
import com.tkusevic.beerappretrofit.data.response.StyleResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by tkusevic on 02.02.2018..
 */

public interface BeersApiService {
    //categories
    @GET("categories/")
    Call<CategoriesResponse> getCategories(@Query("key") String apiKey);

    //styles
    @GET("styles/")
    Call<StyleResponse> getStyles(
            @Query("key") String ApiKey
    );
    //beers

    @GET("beer/{id}/")
    Call<BeerResponse> getBeerById(@Path("id") String id, @Query("key") String apiKey);

    @GET("beers/")
    Call<BeersResponse> getBeerByPage(@Query("styleId") int styleId, @Query("p") int p, @Query("key") String apiKey);

    @GET("beers/")
    Call<BeersResponse> getBeersByStyle(
            @Query("styleId") int styleId,
            @Query("key") String apiKey
    );
}
