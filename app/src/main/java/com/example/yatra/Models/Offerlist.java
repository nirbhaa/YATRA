package com.example.yatra.Models;

public class Offerlist {
    private int offerphoto;
    private String describe;

    public Offerlist(int offerphoto, String describe) {
        this.offerphoto = offerphoto;
        this.describe = describe;
    }

    public int getOfferphoto() {
        return offerphoto;
    }

    public void setOfferphoto(int offerphoto) {
        this.offerphoto = offerphoto;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
}
