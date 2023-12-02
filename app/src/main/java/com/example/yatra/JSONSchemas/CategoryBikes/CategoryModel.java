package com.example.yatra.JSONSchemas.CategoryBikes;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class CategoryModel {
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("category")
    @Expose
    private Category category;
    @SerializedName("bikes")
    @Expose
    private List<Bikes> bikes;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Bikes> getBikes() {
        return bikes;
    }

    public void setBikes(List<Bikes> bikes) {
        this.bikes = bikes;
    }


}
