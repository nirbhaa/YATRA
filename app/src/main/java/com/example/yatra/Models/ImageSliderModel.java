package com.example.yatra.Models;

public class ImageSliderModel {
    private  String Imageurl;
    private  String text;

    public ImageSliderModel(String imageurl, String text) {
        Imageurl = imageurl;
        this.text = text;
    }

    public String getImageurl() {
        return Imageurl;
    }

    public void setImageurl(String imageurl) {
        Imageurl = imageurl;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
