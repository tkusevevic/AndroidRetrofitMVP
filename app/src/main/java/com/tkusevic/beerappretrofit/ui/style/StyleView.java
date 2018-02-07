package com.tkusevic.beerappretrofit.ui.style;

import com.tkusevic.beerappretrofit.base.BaseView;
import com.tkusevic.beerappretrofit.data.model.Style;

import java.util.List;

/**
 * Created by tkusevic on 07.02.2018..
 */

public interface StyleView extends BaseView{

    void setStyles(List<Style> styles);

}
