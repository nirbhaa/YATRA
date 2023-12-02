package com.example.yatra.Models;

public class favoriteslist {
    private int bikePhoto2;
    private String bikeCompany2;
    private String bikemodel2;

    public favoriteslist(int bikePhoto2, String bikeCompany2, String bikemodel2) {
        this.bikePhoto2 = bikePhoto2;
        this.bikeCompany2 = bikeCompany2;
        this.bikemodel2 = bikemodel2;
    }

    public int getBikePhoto2() {
        return bikePhoto2;
    }

    public void setBikePhoto2(int bikePhoto2) {
        this.bikePhoto2 = bikePhoto2;
    }

    public String getBikeCompany2() {
        return bikeCompany2;
    }

    public void setBikeCompany2(String bikeCompany2) {
        this.bikeCompany2 = bikeCompany2;
    }

    public String getBikemodel2() {
        return bikemodel2;
    }

    public void setBikemodel2(String bikemodel2) {
        this.bikemodel2 = bikemodel2;
    }


}
