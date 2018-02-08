package com.tkusevic.beerappretrofit.ui.beer;

import com.tkusevic.beerappretrofit.data.model.Beer;

import java.util.List;

/**
 * Created by tkusevic on 06.02.2018..
 */

public interface BeerView
{

    void setBeers(List<Beer> beers);

    void startDetails(Beer beer);

    void addBeers(List<Beer> beers);
}
