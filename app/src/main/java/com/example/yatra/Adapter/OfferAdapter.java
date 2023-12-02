package com.example.yatra.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.yatra.JSONSchemas.Offer.Offer;
import com.example.yatra.Models.Offerlist;
import com.example.yatra.Models.favoriteslist;
import com.example.yatra.R;

import java.util.List;

public class OfferAdapter extends RecyclerView.Adapter<OfferAdapter.myviewholder>{

    private List<Offer> lists;
    Context context;
    public OfferAdapter(List<Offer> lists,Context context) {

        this.lists = lists;
        this.context = context;
    }

    @NonNull
    @Override
    public OfferAdapter.myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_offer, parent, false);
        return new OfferAdapter.myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OfferAdapter.myviewholder holder, int position) {
        final Offer temp=lists.get(position);
        String image = lists.get(position).getOfferImage();

        holder.describe.setText(lists.get(position).getOfferDescription());
        //holder.offerphoto.setImageResource(lists.get(position).getOfferphoto());
        Glide.with(context)
                .asBitmap()
                .load(image)
                .into(holder.offerphoto);
    }

    @Override
    public int getItemCount() {
        return lists.size();
    }

    public class myviewholder extends RecyclerView.ViewHolder  {
        ImageView offerphoto;
        TextView describe;

        public myviewholder(@NonNull View itemView) {
            super(itemView);
            offerphoto=(ImageView)itemView.findViewById(R.id.offerphoto);
            describe=(TextView)itemView.findViewById(R.id.describe);

        }
    }
}
