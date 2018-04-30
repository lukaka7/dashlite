package com.example.ljwang.dashlite.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Provides a Java model class of PopularItem used by Gson to serialize and deserialize the JSON objects
 */
public class PopularItem implements Serializable {

    @SerializedName("id") public int id;
    @SerializedName("price") public int price;
    @SerializedName("name") public String name;
    @SerializedName("description") public String description;
    @SerializedName("img_url") public String img_url;
}
