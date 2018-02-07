package com.tkusevic.beerappretrofit.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by tkusevic on 03.02.2018..
 */

public class Beer {

    @SerializedName("labels")
    private Labels labels;

    @SerializedName("style")
    private Style style;

    @SerializedName("name")
    private String name;

    @SerializedName("id")
    private String id;

    @SerializedName("styleId")
    private int styleId;

    @SerializedName("available")
    private Available available;

    @SerializedName("description")
    private String description;


    public Labels getLabels() {
        return labels;
    }

    public void setLabels(Labels labels) {
        this.labels = labels;
    }

    public Style getStyle() {
        return style;
    }

    public void setStyle(Style style) {
        this.style = style;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getStyleId() {
        return styleId;
    }

    public void setStyleId(Integer styleId) {
        this.styleId = styleId;
    }

    public Available getAvailable() {
        return available;
    }

    public void setAvailable(Available available) {
        this.available = available;
    }

    public String getDescription() {
        return description;
    }

}


