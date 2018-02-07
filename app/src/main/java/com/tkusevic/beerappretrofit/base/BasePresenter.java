package com.tkusevic.beerappretrofit.base;

/**
 * Created by tkusevic on 06.02.2018..
 */

public interface BasePresenter<T extends BaseView> {

    void setView(T view);
}
