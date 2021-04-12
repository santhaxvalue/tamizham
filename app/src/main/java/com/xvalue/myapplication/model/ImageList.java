package com.xvalue.myapplication.model;

import com.google.gson.annotations.SerializedName;

public class ImageList {

    @SerializedName("name")
    private String name;
    @SerializedName("imageurl")
    private String imageurl;

    public ImageList(String name, String imageurl) {
        this.name = name;
        this.imageurl = imageurl;
    }

    public String getName() {
        return name;
    }

    public String getImageurl() {
        return imageurl;
    }
}
