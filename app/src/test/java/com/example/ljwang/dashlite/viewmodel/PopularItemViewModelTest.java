package com.example.ljwang.dashlite.viewmodel;

import com.example.ljwang.dashlite.data.FakeFetchRestaurantsAPI;
import com.example.ljwang.dashlite.model.PopularItem;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PopularItemViewModelTest {

    private PopularItem popularItem;
    private PopularItemViewModel popularItemViewModel;

    @Before
    public void setupTest() {
        popularItem = FakeFetchRestaurantsAPI.getPopularItem();
        popularItemViewModel = new PopularItemViewModel(popularItem);
    }

    @Test
    public void shouldGetPrice() {
        assertEquals(FakeFetchRestaurantsAPI.POPULAR_ITEM_DISPLAY_PRICE, popularItemViewModel.getPrice());
    }

    @Test
    public void shouldGetName() {
        assertEquals(popularItem.name, popularItemViewModel.getName());
    }

    @Test
    public void shouldGetImageUrl() {
        assertEquals(popularItem.img_url, popularItemViewModel.getImageUrl());
    }
}