package com.example.ljwang.dashlite.data;

import com.example.ljwang.dashlite.model.Menu;
import com.example.ljwang.dashlite.model.PopularItem;
import com.example.ljwang.dashlite.model.Restaurant;

import java.util.ArrayList;
import java.util.List;

public class FakeFetchRestaurantsAPI {

    private static final int RESTAURANT_ID = 1;
    private static final String RESTAURANT_NAME = "Happy Cafe";
    private static final String DESCRIPTION = "Boba, Snacks";
    private static final String COVER_IMAGE_URL = "https://cdn.test.com/media/restaurant/cover/The-Old-Pro.png";
    private static final String STATUS = "Open";
    private static final String AVERAGE_RATING = "4.5";
    private static final int NUMBER_OF_RATINGS = 1100;

    private static final boolean IS_CATERING = false;
    private static final String SUBTITLE = "All Day";
    private static final int MENU_ID = 120;
    private static final String MENU_NAME = "Happy Cafe (All Day) (Sunnyvale)";

    private static final int POPULAR_ITEM_ID = 2993;
    private static final int POPULAR_ITEM_PRICE = 450;
    private static final String POPULAR_ITEM_NAME = "Matcha Milk Tea";
    private static final String POPULAR_ITEM_DESCRIPTION = "Yunnan Black Tea, Matcha, Boba";
    private static final String POPULAR_ITEM_IMAGE =
        "https://res.cloudinary.com/test/image/fetch/c_scale,w_1200,h_564,q_auto,f_auto/https://doordash-static.s3.amazonaws.com/media/photos/34bc98bf-6a3f-44a8-a8ac-eff5f6fefc99-retina-large.jpg";

    public static final String POPULAR_ITEM_DISPLAY_PRICE = "$4.50";
    public static final String METADATA_RATING = "4.5/5 · 1100 ratings";

    public static List<Restaurant> getRestaurants() {
        List<Restaurant> restaurants = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            restaurants.add(getRestaurant());
        }
        return restaurants;
    }

    public static Restaurant getRestaurant() {
        Restaurant restaurant = new Restaurant();
        restaurant.id = RESTAURANT_ID;
        restaurant.name = RESTAURANT_NAME;
        restaurant.description = DESCRIPTION;
        restaurant.cover_image_url = COVER_IMAGE_URL;
        restaurant.status = STATUS;
        restaurant.average_rating = AVERAGE_RATING;
        restaurant.number_of_ratings = NUMBER_OF_RATINGS;
        List<Menu> menus = new ArrayList<>();
        menus.add(getMenu());
        restaurant.menus = menus;
        return restaurant;
    }

    public static Menu getMenu() {
        Menu menu = new Menu();
        menu.id = MENU_ID;
        menu.name = MENU_NAME;
        menu.subtitle = SUBTITLE;
        menu.is_catering = IS_CATERING;
        List<PopularItem> popularItems = new ArrayList<>();
        popularItems.add(getPopularItem());
        menu.popularItems = popularItems;
        return menu;
    }

    public static PopularItem getPopularItem() {
        PopularItem popularItem = new PopularItem();
        popularItem.id = POPULAR_ITEM_ID;
        popularItem.name = POPULAR_ITEM_NAME;
        popularItem.description = POPULAR_ITEM_DESCRIPTION;
        popularItem.price = POPULAR_ITEM_PRICE;
        popularItem.img_url = POPULAR_ITEM_IMAGE;
        return popularItem;
    }


}
