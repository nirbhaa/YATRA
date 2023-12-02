package com.example.yatra.JSONSchemas.UserBokingModel;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class UserBookingModel {
    @Expose
    private String status;
    @SerializedName("bookings")
    @Expose
    private List<Booking> bookings;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }



}
