package com.tkusevic.beerappretrofit.presentation;

import com.tkusevic.beerappretrofit.data.response.StyleResponse;
import com.tkusevic.beerappretrofit.interaction.StyleInteractor;
import com.tkusevic.beerappretrofit.ui.style.StyleView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by tkusevic on 07.02.2018..
 */

public class StylePresenterImpl implements StylePresenter {

    private final StyleInteractor interactor;

    private StyleView styleView;

    @Override
    public void setBaseView(StyleView styleView) {
        this.styleView = styleView;
    }
    
    public StylePresenterImpl(StyleInteractor interactor){
        this.interactor = interactor;
    }


    @Override
    public void getStyles() {
        interactor.getStyles(getStylesCallBack());
    }

     private Callback<StyleResponse> getStylesCallBack(){
        return new Callback<StyleResponse>() {
            @Override
            public void onResponse(Call<StyleResponse> call, Response<StyleResponse> response) {
                styleView.setStyles(response.body().getStyles());
            }

            @Override
            public void onFailure(Call<StyleResponse> call, Throwable t) {

            }
        };
     }

}
