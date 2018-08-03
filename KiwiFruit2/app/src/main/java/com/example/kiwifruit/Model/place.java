package com.example.kiwifruit.Model;

import android.media.Image;

/**
 * Created by 邓经纬 on 2018/8/3.
 */

public class place {
    private String place_name;
    private String place_introduce;
    private Image place_image;
    public Image getPlace_image() {
        return place_image;
    }

    public void setPlace_image(Image place_image) {
        this.place_image = place_image;
    }

    public String getPlacename() {
        return place_name;
    }

    public String getPlaceintroduce() {
        return place_introduce;
    }
    public void setPlace_name(String product_name) {
        this.place_name = product_name;
    }

    public void setPlace_introduce(String product_introduce) {
        this.place_introduce = product_introduce;
    }
}
