package com.tkusevic.beerappretrofit.ui.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tkusevic.beerappretrofit.R;
import com.tkusevic.beerappretrofit.data.model.Style;
import com.tkusevic.beerappretrofit.ui.holders.StyleViewHolder;
import com.tkusevic.beerappretrofit.ui.listener.StyleListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tkusevic on 05.02.2018..
 */

public class StyleAdapter extends RecyclerView.Adapter<StyleViewHolder> {

    private List<Style> styles = new ArrayList<>();
    private StyleListener listener;

    public void setOnStyleClickListener(StyleListener listener) {
        this.listener = listener;
    }

    public void setStyles(List<Style> styles) {
        this.styles.clear();
        this.styles.addAll(styles);
        notifyDataSetChanged();
    }

    @Override
    public StyleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.style_holder, parent, false);
        return new StyleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(StyleViewHolder holder, int position) {
        final Style style = styles.get(position);
        holder.setStyle(style);
        holder.setStyleListener(listener);
    }

    @Override
    public int getItemCount() {
        return styles.size();
    }
}
