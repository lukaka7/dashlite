package com.example.ljwang.dashlite.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;
import com.example.ljwang.dashlite.data.RestaurantFactory;
import com.example.ljwang.dashlite.data.RestaurantService;
import com.example.ljwang.dashlite.model.Restaurant;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

import java.util.List;

/**
 * RestaurantViewModel retrieves the restaurant data set using RestaurantService and expose to the view.
 */
public class RestaurantViewModel extends ViewModel {

    public final static String DEFAULT_LAT = "37.422740";
    public final static String DEFAULT_LNG = "-122.139956";
    public final static int DEFAULT_OFFSET = 0;
    public final static int DEFAULT_LIMIT = 50;

    private final static String TAG = RestaurantViewModel.class.getName();
    private MutableLiveData<List<Restaurant>> restaurantList;
    private RestaurantService restaurantService;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    public LiveData<List<Restaurant>> getRestaurantList() {
        if (restaurantList == null) {
            restaurantList = new MutableLiveData<>();
            fetchRestaurantList();
        }
        return restaurantList;
    }

    /**
     * This is the method to actual send HTTP request via RestaurantService and handle the response back.
     */
    private void fetchRestaurantList() {
        if (restaurantService == null) {
            restaurantService = RestaurantFactory.create();
        }

        Disposable disposable =
            restaurantService.fetchRestaurants(DEFAULT_LAT, DEFAULT_LNG, DEFAULT_OFFSET, DEFAULT_LIMIT)
                             .subscribeOn(Schedulers.io())
                             .observeOn(AndroidSchedulers.mainThread())
                             .subscribe(new Consumer<List<Restaurant>>() {
                                 @Override
                                 public void accept(List<Restaurant> restaurants) {
                                     restaurantList.setValue(restaurants);
                                 }
                             }, new Consumer<Throwable>() {
                                 @Override
                                 public void accept(Throwable throwable) {
                                     Log.e(TAG, "Failed to fetch restaurant list from API");
                                     // Notify the view to display an error page
                                 }
                             });

        compositeDisposable.add(disposable);
    }
}
