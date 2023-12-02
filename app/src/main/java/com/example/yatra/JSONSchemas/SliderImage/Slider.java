package com.example.yatra.JSONSchemas.SliderImage;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class Slider {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("slider_title")
    @Expose
    private String sliderTitle;
    @SerializedName("slider_description")
    @Expose
    private String sliderDescription;
    @SerializedName("slider_image")
    @Expose
    private String sliderImage;
    @SerializedName("slider_status")
    @Expose
    private String sliderStatus;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("url")
    @Expose
    private String url;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSliderTitle() {
        return sliderTitle;
    }

    public void setSliderTitle(String sliderTitle) {
        this.sliderTitle = sliderTitle;
    }

    public String getSliderDescription() {
        return sliderDescription;
    }

    public void setSliderDescription(String sliderDescription) {
        this.sliderDescription = sliderDescription;
    }

    public String getSliderImage() {
        return sliderImage;
    }

    public void setSliderImage(String sliderImage) {
        this.sliderImage = sliderImage;
    }

    public String getSliderStatus() {
        return sliderStatus;
    }

    public void setSliderStatus(String sliderStatus) {
        this.sliderStatus = sliderStatus;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}

