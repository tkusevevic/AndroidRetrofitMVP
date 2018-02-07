package com.tkusevic.beerappretrofit.data.response;

import com.google.gson.annotations.SerializedName;
import com.tkusevic.beerappretrofit.data.model.Beer;

import java.util.List;

/**
 * Created by tkusevic on 03.02.2018..
 */

public class BeersResponse {

    private int numberOfPages;

    @SerializedName("data")
    private List<Beer> beers;

    private int currentPage;

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public List<Beer> getBeers() {
        return beers;
    }

    public void setBeers(List<Beer> beers) {
        this.beers = beers;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
}
