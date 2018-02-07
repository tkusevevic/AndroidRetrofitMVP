package com.tkusevic.beerappretrofit.presentation;

import com.tkusevic.beerappretrofit.base.BasePresenter;
import com.tkusevic.beerappretrofit.data.model.Beer;
import com.tkusevic.beerappretrofit.ui.beer.BeerView;

/**
 * Created by tkusevic on 06.02.2018..
 */

public interface BeerPresenter extends BasePresenter<BeerView> {

    void setStyleId(int styleId);

    void getBeersByStyle();

    void onBeerClicked(Beer beer);

    void loadNextPage(int page);
}
