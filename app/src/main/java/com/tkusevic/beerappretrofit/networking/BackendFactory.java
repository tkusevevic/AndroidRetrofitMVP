package com.tkusevic.beerappretrofit.networking;

import com.tkusevic.beerappretrofit.interaction.BeerInteractor;
import com.tkusevic.beerappretrofit.interaction.BeerInteractorImpl;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by tkusevic on 02.02.2018..
 */

public class BackendFactory {

    private static final String BASE_URL = "http://api.brewerydb.com/v2/";

    private static Retrofit retrofit = null;

    private static Retrofit getClient(String baseUrl) {

        if (retrofit == null) {
            Interceptor ceptor = new HttpLoggingInterceptor()
                    .setLevel(HttpLoggingInterceptor.Level.BODY);

            OkHttpClient client = new OkHttpClient.Builder()
                    .addInterceptor(ceptor)
                    .build();

            retrofit = new Retrofit.Builder()
                    .client(client)
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public static BeersApiService getService() {
        return getClient(BASE_URL).create(BeersApiService.class);
    }

    public static BeerInteractor getBeerInteractor() {
        return new BeerInteractorImpl(getService());
    }
}
