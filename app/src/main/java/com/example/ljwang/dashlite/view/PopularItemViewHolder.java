package com.example.ljwang.dashlite.view;

import android.support.v7.widget.RecyclerView;
import com.example.ljwang.dashlite.databinding.PopularItemBinding;
import com.example.ljwang.dashlite.model.PopularItem;
import com.example.ljwang.dashlite.viewmodel.PopularItemViewModel;

/**
 * PopularItemViewHolder is a class to hold each PopularItem object's views within a RecyclerView
 * Use the binding class which is automatically generated from the layout file
 */
public class PopularItemViewHolder extends RecyclerView.ViewHolder {

    PopularItemBinding popularItemBinding;

    public PopularItemViewHolder(PopularItemBinding popularItemBinding) {
        super(popularItemBinding.getRoot());
        this.popularItemBinding = popularItemBinding;
    }

    /**
     * Provides a method for the RecyclerView adapter to bind the data with the ViewHolder
     *
     * @param popularItem PopularItem object for the view holder
     */
    public void bindPopularItem(final PopularItem popularItem) {
        if (popularItemBinding.getViewModel() == null) {
            popularItemBinding.setViewModel(
                new PopularItemViewModel(popularItem));
        } else {
            popularItemBinding.getViewModel().setPopularItem(popularItem);
        }
    }
}
