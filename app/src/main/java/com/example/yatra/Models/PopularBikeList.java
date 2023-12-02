package com.example.yatra.Models;

public class PopularBikeList {
    private int bikePhoto1;
    private String bikeCompany;
    private String bikemodel;
    private String mileage;
    private String engine;
    private String fuelcapacity;
    private String fueltype;
    private String price;

    public PopularBikeList(int bikePhoto1, String bikeCompany, String bikemodel, String mileage, String engine, String fuelcapacity, String fueltype, String price) {
        this.bikePhoto1 = bikePhoto1;
        this.bikeCompany = bikeCompany;
        this.bikemodel = bikemodel;
        this.mileage = mileage;
        this.engine = engine;
        this.fuelcapacity = fuelcapacity;
        this.fueltype = fueltype;
        this.price = price;
    }

    public PopularBikeList() {
        this.bikePhoto1 = bikePhoto1;
        this.bikeCompany = bikeCompany;
        this.bikemodel = bikemodel;
        this.mileage = mileage;
        this.engine = engine;
        this.fuelcapacity = fuelcapacity;
        this.fueltype = fueltype;
        this.price = price;
    }

    public int getBikePhoto1() {
        return bikePhoto1;
    }

    public void setBikePhoto1(int bikePhoto1) {
        this.bikePhoto1 = bikePhoto1;
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

    public String getMileage() {
        return mileage;
    }

    public void setMileage(String mileage) {
        this.mileage = mileage;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getFuelcapacity() {
        return fuelcapacity;
    }

    public void setFuelcapacity(String fuelcapacity) {
        this.fuelcapacity = fuelcapacity;
    }

    public String getFueltype() {
        return fueltype;
    }

    public void setFueltype(String fueltype) {
        this.fueltype = fueltype;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}