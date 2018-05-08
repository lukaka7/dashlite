package com.example.ljwang.dashlite.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;

public class SharedPrefsUtils {

    private SharedPreferences sharedPreferences;

    private static final String MY_SHARED_PREFS = "Favorite";

    public void storeRestaurantFavorite(@NonNull Context context, int restaurantId, boolean favorited) {
        if (sharedPreferences == null) {
            sharedPreferences = context.getSharedPreferences(MY_SHARED_PREFS, Context.MODE_PRIVATE);
        }
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(String.valueOf(restaurantId), favorited);
        editor.commit();
    }

    public boolean getRestaurantFavorite(@NonNull Context context, int restaurantId) {
        if (sharedPreferences == null) {
            sharedPreferences = context.getSharedPreferences(MY_SHARED_PREFS, Context.MODE_PRIVATE);
        }
        return sharedPreferences.getBoolean(String.valueOf(restaurantId), false);
    }

}
