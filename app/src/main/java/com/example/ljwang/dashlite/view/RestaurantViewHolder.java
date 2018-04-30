package com.example.ljwang.dashlite.view;

import android.support.v7.widget.RecyclerView;
import com.example.ljwang.dashlite.databinding.ItemRestaurantBinding;
import com.example.ljwang.dashlite.model.Restaurant;
import com.example.ljwang.dashlite.viewmodel.ItemRestaurantViewModel;

/**
 * RestaurantViewHolder is a class to hold each Restaurant object's views within a RecyclerView
 * Use the binding class which is automatically generated from the layout file
 */
public class RestaurantViewHolder extends RecyclerView.ViewHolder {

    ItemRestaurantBinding itemRestaurantBinding;

    public RestaurantViewHolder(ItemRestaurantBinding itemRestaurantBinding) {
        super(itemRestaurantBinding.getRoot());
        this.itemRestaurantBinding = itemRestaurantBinding;
    }

    /**
     * Provides a method for the RecyclerView adapter to bind the data with the ViewHolder
     * @param restaurant  Restaurant object for the view holder
     */
    public void bindRestaurant(Restaurant restaurant) {
        if (itemRestaurantBinding.getViewModel() == null) {
            itemRestaurantBinding.setViewModel(
                new ItemRestaurantViewModel(restaurant, itemView.getContext()));
        } else {
            itemRestaurantBinding.getViewModel().setRestaurant(restaurant);
        }
    }
}
