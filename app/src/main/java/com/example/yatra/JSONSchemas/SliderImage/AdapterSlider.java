package com.example.yatra.JSONSchemas.SliderImage;
import android.content.Context;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.smarteist.autoimageslider.SliderViewAdapter;

public class AdapterSlider  {
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("slider")
    @Expose
    private List<com.example.yatra.JSONSchemas.SliderImage.Slider> slider;



    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<com.example.yatra.JSONSchemas.SliderImage.Slider> getSlider() {
        return slider;
    }

    public void setSlider(List<Slider> slider) {
        this.slider = slider;
    }

}

