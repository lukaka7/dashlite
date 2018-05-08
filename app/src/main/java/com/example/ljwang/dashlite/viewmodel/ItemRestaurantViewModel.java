package com.example.ljwang.dashlite.viewmodel;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.view.View;
import android.widget.ImageView;
import com.example.ljwang.dashlite.BR;
import com.example.ljwang.dashlite.R;
import com.example.ljwang.dashlite.model.Restaurant;
import com.example.ljwang.dashlite.utils.RoundedTransformation;
import com.example.ljwang.dashlite.utils.SharedPrefsUtils;
import com.example.ljwang.dashlite.view.RestaurantDetailActivity;
import com.squareup.picasso.Picasso;

import static com.example.ljwang.dashlite.utils.RoundedTransformation.ROUNDED_CORNER_MARGIN;
import static com.example.ljwang.dashlite.utils.RoundedTransformation.ROUNDED_CORNER_RADIUS;


/**
 * ItemRestaurantViewModel provides all the relevant data and actions for the item restaurant view to consume.
 * It includes the logic to retrieve the necessary from the Model layer and expose to the view as well.
 */
public class ItemRestaurantViewModel extends BaseObservable {

    private Restaurant restaurant;
    private Context context;
    private SharedPrefsUtils sharedPrefsUtils;

    public ItemRestaurantViewModel(Restaurant restaurant, Context context) {
        this.restaurant = restaurant;
        this.context = context;
        sharedPrefsUtils = new SharedPrefsUtils();
    }

    public String getImageUrl() {
        return restaurant.cover_image_url;
    }

    public String getName() {
        return restaurant.name;
    }

    public String getDescription() {
        return restaurant.description;
    }

    public String getStatus() {
        return restaurant.status;
    }

    public void onCardClick(View view) {
        context.startActivity(RestaurantDetailActivity.launchDetail(view.getContext(), restaurant));
    }

    public String getMetadataRating() {
        return context.getString(R.string.metadata_rating, restaurant.average_rating, restaurant.number_of_ratings);
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
        notifyChange();
    }

    @Bindable
    public boolean getIsFavorited() {
        boolean isFavorited = sharedPrefsUtils.getRestaurantFavorite(context, restaurant.id);
        return isFavorited || restaurant.isFavorited;
    }

    public void onFavoriteClick(View view) {
        restaurant.isFavorited = !restaurant.isFavorited;
        sharedPrefsUtils.storeRestaurantFavorite(context, restaurant.id, restaurant.isFavorited);
        notifyPropertyChanged(BR.isFavorited);
    }

    @BindingAdapter({ "imageUrl" })
    public static void loadImage(ImageView view, String imageUrl) {
        Picasso picasso = new Picasso.Builder(view.getContext()).build();
        picasso.load(imageUrl)
               .transform(new RoundedTransformation(ROUNDED_CORNER_RADIUS, ROUNDED_CORNER_MARGIN))
               .resizeDimen(R.dimen.restaurant_thumbnail_width, R.dimen.restaurant_thumbnail_height)
               .into(view);
    }

    private void fetchIsFavorited() {
        // fetch isFavorited value from API
        restaurant.isFavorited = false;
    }
}
