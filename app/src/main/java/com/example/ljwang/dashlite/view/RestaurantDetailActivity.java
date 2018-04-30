package com.example.ljwang.dashlite.view;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.example.ljwang.dashlite.R;
import com.example.ljwang.dashlite.databinding.ActivityRestaurantDetailBinding;
import com.example.ljwang.dashlite.model.Restaurant;
import com.example.ljwang.dashlite.viewmodel.ItemRestaurantViewModel;

/**
 * The detail activity of the restaurant which is started by clicking on the restaurant item on the main activity
 */
public class RestaurantDetailActivity extends AppCompatActivity {

    private static final String EXTRA_RESTAURANT = "EXTRA_RESTAURANT";
    private Restaurant restaurant;
    private ActivityRestaurantDetailBinding activityRestaurantDetailBinding;
    private ItemRestaurantViewModel itemRestaurantViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getExtrasFromIntent();
        initDataBinding();
        setupPopularItemListView(activityRestaurantDetailBinding.popularItemList);
        displayHomeAsUpEnabled();
    }

    public static Intent launchDetail(Context context, Restaurant restaurant) {
        Intent intent = new Intent(context, RestaurantDetailActivity.class);
        intent.putExtra(EXTRA_RESTAURANT, restaurant);
        return intent;
    }

    /**
     * This is a method to initialize the dataBinding object, viewModel object and bind the data to viewModel
     */
    private void initDataBinding() {
        activityRestaurantDetailBinding = DataBindingUtil.setContentView(this, R.layout.activity_restaurant_detail);
        itemRestaurantViewModel = new ItemRestaurantViewModel(restaurant, this);
        if (activityRestaurantDetailBinding.getViewModel() == null) {
            activityRestaurantDetailBinding.setViewModel(itemRestaurantViewModel);
        } else {
            activityRestaurantDetailBinding.getViewModel().setRestaurant(restaurant);
        }
    }

    private void displayHomeAsUpEnabled() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle(restaurant.name);
        }
    }

    /**
     * This is a method to initialize relevant objects for RecyclerView, such as recyclerview adapter, set adapter to
     * the view and config layout manager
     *
     * @param popularItemList RecyclerView object
     */
    private void setupPopularItemListView(RecyclerView popularItemList) {
        PopularItemListAdapter adapter = new PopularItemListAdapter();
        popularItemList.setAdapter(adapter);
        popularItemList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        if (restaurant != null && restaurant.menus.size() > 0) {
            // We only display the popular items of the first menu
            // Ideally we should show the correct menu to users for the cooresponding time when they browse the menu
            adapter.setPopularItemList(restaurant.menus.get(0).popularItems);
        }
    }

    private void getExtrasFromIntent() {
        restaurant = (Restaurant) getIntent().getSerializableExtra(EXTRA_RESTAURANT);
    }
}
