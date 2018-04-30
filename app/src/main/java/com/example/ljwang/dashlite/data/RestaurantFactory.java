package com.example.ljwang.dashlite.data;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * RestaurantFactory is a class to initialize Retrofit object for RestaurantService, configure it to use Gson converter
 * to handle data (de)serialization, extend it by RxJava adapter to return RxJava types.
 */
public class RestaurantFactory {
    private final static String BASE_URL = "http://api.doordash.com/v2/";

    public static RestaurantService create() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                                                  .addConverterFactory(GsonConverterFactory.create())
                                                  .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                                                  .build();
        return retrofit.create(RestaurantService.class);
    }
}
