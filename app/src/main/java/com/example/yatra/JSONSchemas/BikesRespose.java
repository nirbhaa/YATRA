package com.example.yatra.JSONSchemas;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class BikesRespose {
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("bike")
    @Expose
    private List<Bike> bike;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Bike> getBike() {
        return bike;
    }

    public void setBike(List<Bike> bike) {
        this.bike = bike;
    }


}
