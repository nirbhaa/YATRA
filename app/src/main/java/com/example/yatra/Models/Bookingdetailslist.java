package com.example.yatra.Models;

public class Bookingdetailslist {
    private int photo;
    private  String bikeCompany;
    private String bikemodel;
    private String date;
    private String redate;

    public Bookingdetailslist(int photo, String bikeCompany, String bikemodel, String date, String redate) {
        this.photo = photo;
        this.bikeCompany = bikeCompany;
        this.bikemodel = bikemodel;
        this.date = date;
        this.redate = redate;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public String getBikeCompany() {
        return bikeCompany;
    }

    public void setBikeCompany(String bikeCompany) {
        this.bikeCompany = bikeCompany;
    }

    public String getBikemodel() {
        return bikemodel;
    }

    public void setBikemodel(String bikemodel) {
        this.bikemodel = bikemodel;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getRedate() {
        return redate;
    }

    public void setRedate(String redate) {
        this.redate = redate;
    }
}
