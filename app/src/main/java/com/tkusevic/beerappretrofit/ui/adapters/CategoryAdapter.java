package com.tkusevic.beerappretrofit.ui.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tkusevic.beerappretrofit.R;
import com.tkusevic.beerappretrofit.data.model.Category;
import com.tkusevic.beerappretrofit.ui.listener.CategoryListener;
import com.tkusevic.beerappretrofit.ui.holders.CategoryViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tkusevic on 02.02.2018..
 */

public class CategoryAdapter extends RecyclerView.Adapter<CategoryViewHolder> {

    private List<Category> categories = new ArrayList<>();
    private CategoryListener listener;

    public void setOnCategoryClickListener(CategoryListener listener){
        this.listener = listener;
    }

    public void setCategories(List<Category> categories){
        this.categories.clear();
        this.categories.addAll(categories);
        notifyDataSetChanged();
    }

    public void removeCategory(Category category){
        int position = categories.indexOf(category);
        if(position != -1){
            categories.remove(category);
            notifyItemChanged(position);
        }
    }

    @Override
    public CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_holder,parent,false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CategoryViewHolder holder, int position) {
        final Category category = categories.get(position);
        holder.setCategory(category);
        holder.setCategoryListener(listener);
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }
}
