package com.tkusevic.beerappretrofit.data.response;

import com.google.gson.annotations.SerializedName;
import com.tkusevic.beerappretrofit.data.model.Category;

import java.util.List;

/**
 * Created by tkusevic on 02.02.2018..
 */

public class CategoriesResponse {

    private String message;

    @SerializedName("data")
    private List<Category> categories;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
