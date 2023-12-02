package com.example.yatra.JSONSchemas.Offer;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class Offer {
    @SerializedName("offer_id")
    @Expose
    private Integer offerId;
    @SerializedName("offer_title")
    @Expose
    private String offerTitle;
    @SerializedName("offer_description")
    @Expose
    private String offerDescription;
    @SerializedName("offer_image")
    @Expose
    private String offerImage;
    @SerializedName("offer_startdate")
    @Expose
    private Integer offerStartdate;
    @SerializedName("offer_enddate")
    @Expose
    private Integer offerEnddate;
    @SerializedName("offer_status")
    @Expose
    private String offerStatus;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;

    public Integer getOfferId() {
        return offerId;
    }

    public void setOfferId(Integer offerId) {
        this.offerId = offerId;
    }

    public String getOfferTitle() {
        return offerTitle;
    }

    public void setOfferTitle(String offerTitle) {
        this.offerTitle = offerTitle;
    }

    public String getOfferDescription() {
        return offerDescription;
    }

    public void setOfferDescription(String offerDescription) {
        this.offerDescription = offerDescription;
    }

    public String getOfferImage() {
        return offerImage;
    }

    public void setOfferImage(String offerImage) {
        this.offerImage = offerImage;
    }

    public Integer getOfferStartdate() {
        return offerStartdate;
    }

    public void setOfferStartdate(Integer offerStartdate) {
        this.offerStartdate = offerStartdate;
    }

    public Integer getOfferEnddate() {
        return offerEnddate;
    }

    public void setOfferEnddate(Integer offerEnddate) {
        this.offerEnddate = offerEnddate;
    }

    public String getOfferStatus() {
        return offerStatus;
    }

    public void setOfferStatus(String offerStatus) {
        this.offerStatus = offerStatus;
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

