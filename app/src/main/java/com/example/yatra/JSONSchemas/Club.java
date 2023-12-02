package com.example.yatra.JSONSchemas;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Club {

    @SerializedName("clubs")
    @Expose
    private List<Club__1> clubs;

    public List<Club__1> getClubs() {
        return clubs;
    }

    public void setClubs(List<Club__1> clubs) {
        this.clubs = clubs;
    }


}
