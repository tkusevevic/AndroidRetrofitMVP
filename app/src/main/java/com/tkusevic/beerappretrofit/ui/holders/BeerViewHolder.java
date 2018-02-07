package com.tkusevic.beerappretrofit.ui.holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.tkusevic.beerappretrofit.R;
import com.tkusevic.beerappretrofit.data.model.Beer;
import com.tkusevic.beerappretrofit.ui.listener.BeerListener;

/**
 * Created by tkusevic on 05.02.2018..
 */

public class BeerViewHolder extends RecyclerView.ViewHolder {

    private ImageView image;
    private TextView name;

    private BeerListener listener;

    public BeerViewHolder(View itemView) {
        super(itemView);
        image = itemView.findViewById(R.id.image);
        name = itemView.findViewById(R.id.beer_name);
    }

    public void setBeerListener(BeerListener beerListener) {
        this.listener = beerListener;
    }

    public void setBeer(final Beer beer) {
        image.setImageResource(R.drawable.no_picture);
        if (beer.getLabels() != null) {
            Picasso.with(itemView.getContext())
                    .load(beer.getLabels().getIcon())
                    .resize(90, 90)
                    .centerCrop()
                    .into(image);

        }
        name.setText(beer.getName());
        itemView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onBeerClick(beer);
            }
        });
    }
}
