package com.example.yatra.Adapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.yatra.FavoriteFragment;
import com.example.yatra.JSONSchemas.FavoriteBike;
import com.example.yatra.JSONSchemas.FavouriteDelete;
import com.example.yatra.JSONSchemas.favoriteBikeByUser.Bike;
import com.example.yatra.JSONSchemas.favoriteBikeByUser.Favorite;
import com.example.yatra.R;
import com.example.yatra.activity.BikedetailsActivity;
import com.example.yatra.activity.HomeMainActivity;
import com.example.yatra.activity.MyBookingDetailsActivity;
import com.example.yatra.retrofit.ApiService;
import com.example.yatra.retrofit.ApiUtil;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class favoritesAdapter extends RecyclerView.Adapter<favoritesAdapter.myviewholder> {

    private List<Favorite> lists;
    Context context;

    public favoritesAdapter(List<Favorite> lists, Context context) {
        this.lists = lists;
        this.context = context;
    }

    @NonNull
    @Override
    public favoritesAdapter.myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_favorites, parent, false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull favoritesAdapter.myviewholder holder, int position) {
        final Favorite temp = lists.get(position);
        String image = lists.get(position).getBike().getProductImage();
        holder.favIcon.setImageResource(R.drawable.love);
        holder.bikeCompany.setText(lists.get(position).getBike().getProductName());
        holder.bikemodel.setText(lists.get(position).getBike().getModel());
        //holder.bikephoto.setImageResource(lists.get(position).getBikePhoto2());
        Glide.with(context)
                .asBitmap()
                .load(image)
                .into(holder.bikephoto);
        holder.booknow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, BikedetailsActivity.class);
                i.putExtra("bikename", temp.getBike().getProductName());
                i.putExtra("bikeid", temp.getId());
                i.putExtra("bikeimage", temp.getBike().getProductImage());
                i.putExtra("bikemodel", temp.getBike().getModel());
                i.putExtra("mileage", temp.getBike().getMileage());
                i.putExtra("engine", temp.getBike().getEngine());
                i.putExtra("fuelcapacity", temp.getBike().getFuelCapacity());
                i.putExtra("fueltype", temp.getBike().getFuelCapacity());
                i.putExtra("price", temp.getBike().getRentalPrice());
                i.setFlags((Intent.FLAG_ACTIVITY_NEW_TASK));
                context.startActivity(i);
            }
        });


        final boolean[] isFavorite = {false}; // Track the favorite state

        holder.favIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initfavbikedelete();
            }

            private void initfavbikedelete() {
                String id = temp.getId().toString();
                ApiService apiService = ApiUtil.getApiService();

                Call<FavouriteDelete> responseBodyCall = apiService.getFavouriteDelete(id);
                responseBodyCall.enqueue(new Callback<FavouriteDelete>() {

                    @Override
                    public void onResponse(Call<FavouriteDelete> call, Response<FavouriteDelete> response) {
                        if (response.code() == 200) {
                            Toast.makeText(context, "Favourite Bike Deleted Successfully", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(context, HomeMainActivity.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            context.startActivity(intent);


                        } else if (response.code() == 400) {

                            Toast.makeText(context, "Error on Server", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<FavouriteDelete> call, Throwable t) {
                        Toast.makeText(context, "Fail", Toast.LENGTH_SHORT).show();
                    }

                });
            }


        });

    }

    @Override
    public int getItemCount() {
        return lists.size();
    }

    public class myviewholder extends RecyclerView.ViewHolder {
        ImageView bikephoto, favIcon;
        TextView bikeCompany, bikemodel;
        Button booknow;

        public myviewholder(@NonNull View itemView) {
            super(itemView);
            bikephoto = (ImageView) itemView.findViewById(R.id.bikePhoto2);
            favIcon = (ImageView) itemView.findViewById(R.id.favIcon);
            bikeCompany = (TextView) itemView.findViewById(R.id.bikeCompany2);
            bikemodel = (TextView) itemView.findViewById(R.id.bikemodel2);
            booknow = (Button) itemView.findViewById(R.id.booknow2);
        }
    }
}
