package com.example.ljwang.dashlite.viewmodel;

import android.content.Intent;
import android.test.mock.MockContext;
import android.view.View;
import com.example.ljwang.dashlite.R;
import com.example.ljwang.dashlite.data.FakeFetchRestaurantsAPI;
import com.example.ljwang.dashlite.model.Restaurant;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class ItemRestaurantViewModelTest {

    private Restaurant restaurant;
    private ItemRestaurantViewModel itemRestaurantViewModel;

    @Mock private MockContext context;
    @Mock private View view;
    @Mock private Intent intent;

    @Before
    public void setupTest() {
        MockitoAnnotations.initMocks(this);
        restaurant = FakeFetchRestaurantsAPI.getRestaurant();
        itemRestaurantViewModel = new ItemRestaurantViewModel(restaurant, context);
    }

    @Test
    public void shouldGetImageUrl() {
        assertEquals(restaurant.cover_image_url, itemRestaurantViewModel.getImageUrl());
    }

    @Test
    public void shouldGetName() {
        assertEquals(restaurant.name, itemRestaurantViewModel.getName());
    }

    @Test
    public void shouldGetDescription() {
        assertEquals(restaurant.description, itemRestaurantViewModel.getDescription());
    }

    @Test
    public void shouldGetStatus() {
        assertEquals(restaurant.status, itemRestaurantViewModel.getStatus());
    }

    @Test
    public void shouldGetMetadataRating() {
        doReturn(FakeFetchRestaurantsAPI.METADATA_RATING).when(context)
                                                         .getString(R.string.metadata_rating,
                                                                    restaurant.average_rating,
                                                                    restaurant.number_of_ratings);
        assertEquals(FakeFetchRestaurantsAPI.METADATA_RATING, itemRestaurantViewModel.getMetadataRating());
    }

    @Test
    public void shouldStartRestaurantDetailActivityOnItemClick() {
        itemRestaurantViewModel.onCardClick(view);
        verify(context, times(1)).startActivity(any(Intent.class));
    }
}