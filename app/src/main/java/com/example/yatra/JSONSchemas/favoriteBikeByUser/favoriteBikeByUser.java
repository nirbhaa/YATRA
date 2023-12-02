package com.example.yatra.JSONSchemas.favoriteBikeByUser;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class favoriteBikeByUser {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("favorites")
    @Expose
    private List<Favorite> favorites;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Favorite> getFavorites() {
        return favorites;
    }

    public void setFavorites(List<Favorite> favorites) {
        this.favorites = favorites;
    }

}