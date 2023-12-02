package com.example.yatra.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.yatra.JSONSchemas.Bike;
import com.example.yatra.R;
import com.example.yatra.activity.BikedetailsActivity;

import java.util.List;

public class RecommendedAdapter extends RecyclerView.Adapter<RecommendedAdapter.myviewholder> {
    //List<Bike> items;
    List<com.example.yatra.JSONSchemas.RecommdedBike.Bike>items;
    Context context;



    public RecommendedAdapter(List<com.example.yatra.JSONSchemas.RecommdedBike.Bike> items, Context context) {
        this.items = items;
        this.context = context;
    }


    @NonNull
    @Override
    public RecommendedAdapter.myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_popular, parent, false);
        return new RecommendedAdapter.myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecommendedAdapter.myviewholder holder, int position) {
        final com.example.yatra.JSONSchemas.RecommdedBike.Bike temp = items.get(position);
        String image = items.get(position).getProductImage();
        holder.bikeCompany.setText(items.get(position).getProductName());
        holder.bikemodel.setText(items.get(position).getModel());
        // holder.bikephoto.setImageResource(items.get(position).getProductImage());
        Glide.with(context)
                .asBitmap()
                .load(image)
                .into(holder.bikephoto);
        holder.booknow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, BikedetailsActivity.class);
                i.putExtra("bikename", temp.getProductName());
                i.putExtra("bikeid", temp.getId());
                i.putExtra("bikeimage", temp.getProductImage());
                i.putExtra("bikemodel", temp.getModel());
                i.putExtra("mileage", temp.getMileage());
                i.putExtra("engine", temp.getEngine());
                i.putExtra("fuelcapacity", temp.getFuelCapacity());
                i.putExtra("fueltype", temp.getFuelCapacity());
                i.putExtra("price", temp.getRentalPrice());
                i.setFlags((Intent.FLAG_ACTIVITY_NEW_TASK));
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }



    public class myviewholder extends RecyclerView.ViewHolder {
        ImageView bikephoto;
        TextView bikeCompany, bikemodel;
        Button booknow;

        public myviewholder(@NonNull View itemView) {
            super(itemView);
            bikephoto = (ImageView) itemView.findViewById(R.id.bikePhoto1);
            bikeCompany = (TextView) itemView.findViewById(R.id.bikeCompany);
            bikemodel = (TextView) itemView.findViewById(R.id.bikemodel);
            booknow = (Button) itemView.findViewById(R.id.booknow);
        }
    }
}