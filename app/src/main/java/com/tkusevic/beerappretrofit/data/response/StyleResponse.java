package com.tkusevic.beerappretrofit.data.response;

import com.google.gson.annotations.SerializedName;
import com.tkusevic.beerappretrofit.data.model.Category;
import com.tkusevic.beerappretrofit.data.model.Style;

import java.util.List;

/**
 * Created by tkusevic on 05.02.2018..
 */

public class StyleResponse {

    @SerializedName("data")
    private List<Style> styles;

    public List<Style> getStyles() {
        return styles;
    }

    public void setStyles(List<Style> styles) {
        this.styles = styles;
    }
}
