package com.example.yatra.JSONSchemas.RecommdedBike;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class RecoomendedModel {
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("Bikes")
    @Expose
    private List<Bike> bikes;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Bike> getBikes() {
        return bikes;
    }

    public void setBikes(List<Bike> bikes) {
        this.bikes = bikes;
    }


}
