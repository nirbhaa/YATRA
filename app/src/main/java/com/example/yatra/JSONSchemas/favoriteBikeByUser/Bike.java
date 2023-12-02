package com.example.yatra.JSONSchemas.favoriteBikeByUser;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class Bike {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("product_name")
    @Expose
    private String productName;
    @SerializedName("category_id")
    @Expose
    private Integer categoryId;
    @SerializedName("rental_price")
    @Expose
    private String rentalPrice;
    @SerializedName("product_image")
    @Expose
    private String productImage;
    @SerializedName("is_popular")
    @Expose
    private Integer isPopular;
    @SerializedName("model")
    @Expose
    private String model;
    @SerializedName("mileage")
    @Expose
    private String mileage;
    @SerializedName("fuel_capacity")
    @Expose
    private String fuelCapacity;
    @SerializedName("engine")
    @Expose
    private String engine;
    @SerializedName("recommended")
    @Expose
    private Integer recommended;
    @SerializedName("product_status")
    @Expose
    private String productStatus;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getRentalPrice() {
        return rentalPrice;
    }

    public void setRentalPrice(String rentalPrice) {
        this.rentalPrice = rentalPrice;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public Integer getIsPopular() {
        return isPopular;
    }

    public void setIsPopular(Integer isPopular) {
        this.isPopular = isPopular;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMileage() {
        return mileage;
    }

    public void setMileage(String mileage) {
        this.mileage = mileage;
    }

    public String getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(String fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public Integer getRecommended() {
        return recommended;
    }

    public void setRecommended(Integer recommended) {
        this.recommended = recommended;
    }

    public String getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(String productStatus) {
        this.productStatus = productStatus;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }


}
