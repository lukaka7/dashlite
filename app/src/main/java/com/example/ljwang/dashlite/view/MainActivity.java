package com.example.ljwang.dashlite.view;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.example.ljwang.dashlite.R;
import com.example.ljwang.dashlite.databinding.ActivityMainBinding;
import com.example.ljwang.dashlite.model.Restaurant;
import com.example.ljwang.dashlite.viewmodel.RestaurantViewModel;

import java.util.List;

/**
 * The first activity of the app
 */
public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding activityMainBinding;
    private RestaurantListAdapter restaurantListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDataBinding();
        setupListRestaurantView(activityMainBinding.restaurantList);
    }

    /**
     * This is a method to initialize the dataBinding object, viewModel object and subscribe to the
     * data set retrieved by viewModel
     */
    private void initDataBinding() {
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        RestaurantViewModel restaurantViewModel = ViewModelProviders.of(this).get(RestaurantViewModel.class);
        restaurantViewModel.getRestaurantList().observe(this,
                                                        new android.arch.lifecycle.Observer<List<Restaurant>>() {
                                                            @Override
                                                            public void onChanged(@Nullable List<Restaurant> restaurants) {
                                                                if (restaurants != null) {
                                                                    if (restaurantListAdapter == null) {
                                                                        setupListRestaurantView(activityMainBinding.restaurantList);
                                                                    } else {
                                                                        restaurantListAdapter.setRestaurantList(
                                                                            restaurants);
                                                                    }
                                                                }
                                                            }
                                                        });
    }

    /**
     * This is a method to initialize relevant objects for RecyclerView, such as recyclerview adapter, set adapter to
     * the view and config layout manager
     *
     * @param listRestaurant RecyclerView object
     */
    private void setupListRestaurantView(RecyclerView listRestaurant) {
        restaurantListAdapter = new RestaurantListAdapter();
        listRestaurant.setAdapter(restaurantListAdapter);
        listRestaurant.setLayoutManager(new LinearLayoutManager(this));
    }
}
