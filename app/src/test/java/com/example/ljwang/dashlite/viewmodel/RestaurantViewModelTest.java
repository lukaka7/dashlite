package com.example.ljwang.dashlite.viewmodel;


import com.example.ljwang.dashlite.data.FakeFetchRestaurantsAPI;
import com.example.ljwang.dashlite.data.RestaurantService;
import com.example.ljwang.dashlite.model.Restaurant;
import io.reactivex.Observable;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.mockito.Mockito.doReturn;

public class RestaurantViewModelTest {

    @Mock private RestaurantService restaurantService;

    private RestaurantViewModel restaurantViewModel;

    @Before
    public void setupTest() {
        MockitoAnnotations.initMocks(this);
        restaurantViewModel = new RestaurantViewModel();
    }

    @Test
    public void simulateGetRestaurantListFromApi() throws Exception {
        List<Restaurant> restaurants = FakeFetchRestaurantsAPI.getRestaurants();
        doReturn(Observable.just(restaurants)).when(restaurantService).fetchRestaurants(RestaurantViewModel.DEFAULT_LAT,
                                                                                        RestaurantViewModel.DEFAULT_LNG,
                                                                                        RestaurantViewModel.DEFAULT_OFFSET,
                                                                                        RestaurantViewModel.DEFAULT_LIMIT);
    }

}