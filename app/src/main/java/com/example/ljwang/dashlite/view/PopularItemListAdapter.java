package com.example.ljwang.dashlite.view;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.example.ljwang.dashlite.R;
import com.example.ljwang.dashlite.databinding.PopularItemBinding;
import com.example.ljwang.dashlite.model.PopularItem;

import java.util.List;

/**
 * PopularItemListAdapter class provides a binding from the data set of PopularItem to views that are displayed within
 * a RecyclerView using DataBinding
 */
public class PopularItemListAdapter extends RecyclerView.Adapter<PopularItemViewHolder> {

    private List<PopularItem> popularItemList;

    @NonNull
    @Override
    public PopularItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        PopularItemBinding popularItemBinding =
            DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.popular_item,
                                    parent, false);
        return new PopularItemViewHolder(popularItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull PopularItemViewHolder holder, int position) {
        holder.bindPopularItem(popularItemList.get(position));
    }

    @Override
    public int getItemCount() {
        return popularItemList.size();
    }

    /**
     * Registers a list of PopularItem items to display in RecyclerView.
     * Notify the registered observer that the data set has changed.
     *
     * @param popularItemList the PopularItem list to display
     */
    public void setPopularItemList(List<PopularItem> popularItemList) {
        this.popularItemList = popularItemList;
        notifyDataSetChanged();
    }
}
