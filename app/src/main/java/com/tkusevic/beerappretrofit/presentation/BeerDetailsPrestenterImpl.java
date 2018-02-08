package com.tkusevic.beerappretrofit.presentation;

import com.tkusevic.beerappretrofit.commons.Constants;
import com.tkusevic.beerappretrofit.data.model.Beer;
import com.tkusevic.beerappretrofit.data.response.BeerResponse;
import com.tkusevic.beerappretrofit.interaction.BeerDetailsInteractor;
import com.tkusevic.beerappretrofit.ui.beer.BeerDetailsView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by tkusevic on 08.02.2018..
 */

public class BeerDetailsPrestenterImpl  implements BeerDetailsPresenter{

    private final BeerDetailsInteractor interactor;

    private BeerDetailsView beerDetailsView;

    private String beerId;

    public BeerDetailsPrestenterImpl(BeerDetailsInteractor interactor) {
        this.interactor = interactor;
    }

    public void setBeerId(String beerId){
        this.beerId = beerId;
    }

    @Override
    public void getBeerById( ) {
        interactor.getBeerById(beerId,getBeerCallback());
    }

    private Callback<BeerResponse> getBeerCallback(){
        return new Callback<BeerResponse>() {
            @Override
            public void onResponse(Call<BeerResponse> call, Response<BeerResponse> response) {
                if(response.isSuccessful()){
                    if(response.code() == Constants.RESPONSE_OK){
                        beerDetailsView.setBeer(response.body().getBeer());
                    }
                }
            }

            @Override
            public void onFailure(Call<BeerResponse> call, Throwable t) {

            }
        };
    }


    @Override
    public void setBaseView(BeerDetailsView beerDetailsView) {
        this.beerDetailsView = beerDetailsView;
    }
}
