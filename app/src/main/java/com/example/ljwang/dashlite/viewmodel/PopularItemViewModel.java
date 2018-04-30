package com.example.ljwang.dashlite.viewmodel;

import android.databinding.BindingAdapter;
import android.widget.ImageView;
import com.example.ljwang.dashlite.model.PopularItem;
import com.example.ljwang.dashlite.utils.RoundedTransformation;
import com.squareup.picasso.Picasso;

import java.util.Locale;

import static com.example.ljwang.dashlite.utils.RoundedTransformation.ROUNDED_CORNER_MARGIN;
import static com.example.ljwang.dashlite.utils.RoundedTransformation.ROUNDED_CORNER_RADIUS;

/**
 * PopularItemViewModel provides all the relevant data and actions for the view to consume.
 * It includes the logic to retrieve the necessary from the Model layer and expose to the view.
 */
public class PopularItemViewModel {

    private PopularItem popularItem;

    public PopularItemViewModel(final PopularItem popularItem) {
        this.popularItem = popularItem;
    }

    public String getPrice() {
        return String.format(Locale.ENGLISH, "$%1$.2f", (float) popularItem.price / 100);
    }

    public String getName() {
        return popularItem.name;
    }

    public String getImageUrl() {
        return popularItem.img_url;
    }

    @BindingAdapter("popularItemImage")
    public static void loadImage(ImageView view, String imageUrl) {
        Picasso picasso = new Picasso.Builder(view.getContext()).build();
        picasso.load(imageUrl)
               .transform(new RoundedTransformation(ROUNDED_CORNER_RADIUS, ROUNDED_CORNER_MARGIN))
               .into(view);
    }

    public void setPopularItem(final PopularItem popularItem) {
        this.popularItem = popularItem;
    }
}
