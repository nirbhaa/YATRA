package com.example.yatra.JSONSchemas.UserBokingModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class Booking {
    @SerializedName("booking_id")
    @Expose
    private Integer bookingId;
    @SerializedName("user_id")
    @Expose
    private Integer userId;
    @SerializedName("bike_id")
    @Expose
    private Integer bikeId;
    @SerializedName("booking_start_time")
    @Expose
    private String bookingStartTime;
    @SerializedName("booking_end_time")
    @Expose
    private String bookingEndTime;
    @SerializedName("total_cost")
    @Expose
    private String totalCost;
    @SerializedName("no_of_days")
    @Expose
    private Integer noOfDays;
    @SerializedName("booking_status")
    @Expose
    private String bookingStatus;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("bike")
    @Expose
    private Bike bike;

    public Integer getBookingId() {
        return bookingId;
    }

    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getBikeId() {
        return bikeId;
    }

    public void setBikeId(Integer bikeId) {
        this.bikeId = bikeId;
    }

    public String getBookingStartTime() {
        return bookingStartTime;
    }

    public void setBookingStartTime(String bookingStartTime) {
        this.bookingStartTime = bookingStartTime;
    }

    public String getBookingEndTime() {
        return bookingEndTime;
    }

    public void setBookingEndTime(String bookingEndTime) {
        this.bookingEndTime = bookingEndTime;
    }

    public String getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(String totalCost) {
        this.totalCost = totalCost;
    }

    public Integer getNoOfDays() {
        return noOfDays;
    }

    public void setNoOfDays(Integer noOfDays) {
        this.noOfDays = noOfDays;
    }

    public String getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
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

    public Bike getBike() {
        return bike;
    }

    public void setBike(Bike bike) {
        this.bike = bike;
    }


}
