package com.example.yatra.JSONSchemas.Offer;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class OfferModel {
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("data")
    @Expose
    private List<Offer> data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Offer> getData() {
        return data;
    }

    public void setData(List<Offer> data) {
        this.data = data;
    }


}
