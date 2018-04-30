package com.example.ljwang.dashlite.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Provides a Java model class of Restaurant used by Gson to serialize and deserialize the JSON objects
 */
public class Restaurant implements Serializable {

    @SerializedName("id") public int id;
    @SerializedName("name") public String name;
    @SerializedName("description") public String description;
    @SerializedName("cover_img_url") public String cover_image_url;
    @SerializedName("status") public String status;
    @SerializedName("menus") public List<Menu> menus;
    @SerializedName("average_rating") public String average_rating;
    @SerializedName("number_of_ratings") public int number_of_ratings;
}
