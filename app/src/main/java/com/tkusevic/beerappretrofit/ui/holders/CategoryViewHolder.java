package com.tkusevic.beerappretrofit.ui.holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.tkusevic.beerappretrofit.R;
import com.tkusevic.beerappretrofit.data.model.Category;
import com.tkusevic.beerappretrofit.ui.listener.CategoryListener;

/**
 * Created by tkusevic on 02.02.2018..
 */

public class CategoryViewHolder extends RecyclerView.ViewHolder{

    private TextView name;
    private TextView date;

    private CategoryListener listener;

    public CategoryViewHolder(View itemView) {
        super(itemView);
        name= itemView.findViewById(R.id.name);
        date= itemView.findViewById(R.id.date);
    }

    public void setCategoryListener(CategoryListener categoryListener){
        this.listener = categoryListener;
    }

    public void setCategory(final Category category){
        name.setText(category.getName());
        date.setText(category.getCreateDate());
        itemView.setOnClickListener(v -> {
            if(listener != null){
                listener.onCategoryClick(category);
            }
        });
    }

}
