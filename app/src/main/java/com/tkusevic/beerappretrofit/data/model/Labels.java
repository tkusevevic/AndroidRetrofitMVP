package com.tkusevic.beerappretrofit.data.model;

/**
 * Created by tkusevic on 05.02.2018..
 */

import com.google.gson.annotations.SerializedName;

import com.google.gson.annotations.Expose;

public class Labels {

    @SerializedName("medium")
    @Expose
    private String medium;
    @SerializedName("large")
    @Expose
    private String large;
    @SerializedName("icon")
    @Expose
    private String icon;

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public String getLarge() {
        return large;
    }

    public void setLarge(String large) {
        this.large = large;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

}
