package com.tkusevic.beerappretrofit.ui.adapters;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tkusevic.beerappretrofit.R;
import com.tkusevic.beerappretrofit.data.model.Beer;
import com.tkusevic.beerappretrofit.data.model.Category;
import com.tkusevic.beerappretrofit.ui.holders.BeerViewHolder;
import com.tkusevic.beerappretrofit.ui.holders.CategoryViewHolder;
import com.tkusevic.beerappretrofit.ui.listener.BeerListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tkusevic on 05.02.2018..
 */

public class BeerAdapter extends RecyclerView.Adapter<BeerViewHolder> {

    private final List<Beer> beers = new ArrayList<>();
    private BeerListener listener;

    public void setOnBeerClickListener(BeerListener listener) {
        this.listener = listener;
    }

    public void setBeers(List<Beer> beers) {
        if (beers != null) {
            this.beers.clear();
            this.beers.addAll(beers);
            notifyDataSetChanged();
        }
    }

    public void addBeers(List<Beer> beers) {
        Log.d("loggg","CALL!");
        if (beers != null) {
            int start = this.beers.size();
            this.beers.addAll(beers);
            notifyItemRangeInserted(start, beers.size());
        }
    }

    @Override
    public BeerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.beer_holder, parent, false);
        return new BeerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BeerViewHolder holder, int position) {
        final Beer beer = beers.get(position);
        holder.setBeer(beer);
        holder.setBeerListener(listener);
    }

    @Override
    public int getItemCount() {
        return beers.size();
    }
}
