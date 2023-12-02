package com.example.yatra.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.yatra.JSONSchemas.Bike;
import com.example.yatra.JSONSchemas.SliderImage.Slider;
import com.example.yatra.Models.SliderData;
import com.example.yatra.R;
import com.smarteist.autoimageslider.SliderViewAdapter;


import java.util.List;

public class SliderAdapter extends SliderViewAdapter<SliderAdapter.SliderAdapterViewHolder> {

    // list for storing urls of images.
    Context context;
    List<com.example.yatra.JSONSchemas.SliderImage.Slider> mSliderItems;

    // Constructor
    public SliderAdapter(Context context, List<com.example.yatra.JSONSchemas.SliderImage.Slider> sliderDataArrayList) {
        this.mSliderItems = sliderDataArrayList;
        this.context = context;
    }

    // We are inflating the slider_layout
    // inside on Create View Holder method.
    @Override
    public SliderAdapterViewHolder onCreateViewHolder(ViewGroup parent) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_slider, null);
        return new SliderAdapterViewHolder(inflate);
    }

    // Inside on bind view holder we will
    // set data to item of Slider View.
    @Override
    public void onBindViewHolder(SliderAdapterViewHolder viewHolder, final int position) {

        final Slider sliderItem = mSliderItems.get(position);


        // Glide is use to load image
        // from url in your imageview.
        Glide.with(viewHolder.itemView)
                .load(sliderItem.getUrl())
                .fitCenter()
                .into(viewHolder.imageViewBackground);


//        String image = mSliderItems.get(position);
//
//        Glide.with(context)
//                .asBitmap()
//                .load(image)
//                .into(viewHolder.imageViewBackground);
//    }


    }


    // this method will return
    // the count of our list.
    @Override
    public int getCount() {
        return mSliderItems.size();
    }

    static class SliderAdapterViewHolder extends SliderViewAdapter.ViewHolder {
        // Adapter class for initializing
        // the views of our slider view.
        View itemView;
        ImageView imageViewBackground;

        public SliderAdapterViewHolder(View itemView) {
            super(itemView);
            imageViewBackground = itemView.findViewById(R.id.myimage);
           this.itemView = itemView;
        }
    }
}
