package com.tkusevic.beerappretrofit.presentation;

import com.tkusevic.beerappretrofit.base.BasePresenter;
import com.tkusevic.beerappretrofit.data.model.Beer;
import com.tkusevic.beerappretrofit.ui.beer.BeerDetailsView;

/**
 * Created by tkusevic on 08.02.2018..
 */

public interface BeerDetailsPresenter extends BasePresenter<BeerDetailsView>{

    void setBeerId(String beerId);

    void getBeerById( );
}
