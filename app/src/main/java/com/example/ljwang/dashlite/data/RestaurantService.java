package com.example.ljwang.dashlite.data;

import com.example.ljwang.dashlite.model.Restaurant;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.List;

/**
 * RestaurantService is an interface to declare all the Restaurant related API requests
 */
public interface RestaurantService {

    @GET("restaurant")
    Observable<List<Restaurant>> fetchRestaurants(@Query("lat") String lat,
                                                  @Query("lng") String lng,
                                                  @Query("offset") int offset,
                                                  @Query("limit") int limit);
}
