package com.example.ljwang.dashlite.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Provides a Java model class of Menu used by Gson to serialize and deserialize the JSON objects
 */
public class Menu implements Serializable {

    @SerializedName("popular_items") public List<PopularItem> popularItems;
    @SerializedName("is_catering") public boolean is_catering;
    @SerializedName("subtitle") public String subtitle;
    @SerializedName("id") public int id;
    @SerializedName("name") public String name;
}
