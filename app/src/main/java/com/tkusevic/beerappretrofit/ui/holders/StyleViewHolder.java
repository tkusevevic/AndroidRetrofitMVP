package com.tkusevic.beerappretrofit.ui.holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.tkusevic.beerappretrofit.R;
import com.tkusevic.beerappretrofit.data.model.Style;
import com.tkusevic.beerappretrofit.ui.listener.StyleListener;

/**
 * Created by tkusevic on 05.02.2018..
 */

public class StyleViewHolder extends RecyclerView.ViewHolder{

    private TextView name;

    private StyleListener listener;

    public StyleViewHolder (View view){
        super(view);
        name = itemView.findViewById(R.id.style_name);
    }

    public void setStyleListener(StyleListener styleListener){
        this.listener = styleListener;
    }

    public void setStyle(final Style style){
        name.setText(style.getName());
        itemView.setOnClickListener(v -> {
            if(listener != null){
                listener.onStyleClick(style);
            }
        });
    }
}
