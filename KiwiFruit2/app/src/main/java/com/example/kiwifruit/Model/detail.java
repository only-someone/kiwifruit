package com.example.kiwifruit.Model;

/**
 * Created by 邓经纬 on 2018/8/6.
 */

public class detail {
    private String detail_name;
    private String detail_introduce;
    private int detail_image;
    public detail(String detail_name, String detail_introduce,int detail_image){
        this.detail_name=detail_name;
        this.detail_introduce=detail_introduce;
        this.detail_image=detail_image;
    }
    public int getdetail_image() {
        return detail_image;
    }

    public void setdetail_image(int detail_image) {
        this.detail_image = detail_image;
    }

    public String getdetailname() {
        return detail_name;
    }

    public String getdetailintroduce() {
        return detail_introduce;
    }
    public void setdetail_name(String product_name) {
        this.detail_name = product_name;
    }

    public void setdetail_introduce(String product_introduce) {
        this.detail_introduce = product_introduce;
    }
}
