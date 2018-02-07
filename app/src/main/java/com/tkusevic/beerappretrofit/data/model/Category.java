package com.tkusevic.beerappretrofit.data.model;

/**
 * Created by tkusevic on 02.02.2018..
 */

public class Category {

    private int id;
    private String name;
    private String createDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
}
