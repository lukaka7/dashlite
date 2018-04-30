package com.example.ljwang.dashlite.view;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.example.ljwang.dashlite.R;
import com.example.ljwang.dashlite.databinding.ItemRestaurantBinding;
import com.example.ljwang.dashlite.model.Restaurant;

import java.util.Collections;
import java.util.List;

/**
 * RestaurantListAdapter class provides a binding from the data set of Restaurant to views that are displayed within
 * a RecyclerView using DataBinding
 */
public class RestaurantListAdapter extends RecyclerView.Adapter<RestaurantViewHolder> {
    private List<Restaurant> restaurantList;

    public RestaurantListAdapter() {
        this.restaurantList = Collections.emptyList();
    }

    @NonNull
    @Override
    public RestaurantViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemRestaurantBinding
            itemRestaurantBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_restaurant,
                                                            parent, false);
        return new RestaurantViewHolder(itemRestaurantBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull RestaurantViewHolder holder, int position) {
        holder.bindRestaurant(restaurantList.get(position));
    }

    @Override
    public int getItemCount() {
        return restaurantList.size();
    }

    /**
     * Registers a list of Restaurant items to display in RecyclerView.
     * Notify the registered observer that the data set has changed.
     * @param restaurantList  the restaurant list to display
     */
    public void setRestaurantList(List<Restaurant> restaurantList) {
        this.restaurantList = restaurantList;
        notifyDataSetChanged();
    }
}
