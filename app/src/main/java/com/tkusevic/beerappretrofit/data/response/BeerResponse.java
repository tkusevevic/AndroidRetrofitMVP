package com.tkusevic.beerappretrofit.data.response;

import com.google.gson.annotations.SerializedName;
import com.tkusevic.beerappretrofit.data.model.Beer;

import java.util.List;

/**
 * Created by tkusevic on 05.02.2018..
 */

public class BeerResponse {

    private String message;

    @SerializedName("data")
    private Beer beer;

    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Beer getBeer() {
        return beer;
    }

    public void setBeer(Beer beer) {
        this.beer = beer;
    }
}
