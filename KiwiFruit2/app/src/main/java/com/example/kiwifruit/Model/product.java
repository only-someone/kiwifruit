package com.example.kiwifruit.Model;

import android.media.Image;

/**
 * Created by 邓经纬 on 2018/8/3.
 */

public class product {
    private String product_name;
    private String product_introduce;
    private Image product_image;
    public Image getProduct_image() {
        return product_image;
    }

    public void setProduct_image(Image product_image) {
        this.product_image = product_image;
    }

    public String getProductname() {
        return product_name;
    }

    public String getProductintroduce() {
        return product_introduce;
    }
    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public void setProduct_introduce(String product_introduce) {
        this.product_introduce = product_introduce;
    }
}
