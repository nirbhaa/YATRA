package com.example.yatra.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yatra.Models.Bookingdetailslist;

import com.example.yatra.R;


import java.util.List;

public class BookingdetailsAdapter extends RecyclerView.Adapter<BookingdetailsAdapter.myviewholder> {
    private List<Bookingdetailslist> lists;
    public BookingdetailsAdapter(List<Bookingdetailslist> lists) {
        this.lists = lists;
    }
    @NonNull
    @Override
    public BookingdetailsAdapter.myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_booking_details, parent, false);
        return new BookingdetailsAdapter.myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookingdetailsAdapter.myviewholder holder, int position) {
        final Bookingdetailslist temp=lists.get(position);

        holder.bikeCompany.setText(lists.get(position).getBikeCompany());
        holder.bikemodel.setText(lists.get(position).getBikemodel());
        holder.bikephoto.setImageResource(lists.get(position).getPhoto());
        holder.date.setText(lists.get(position).getDate());
        holder.redate.setText(lists.get(position).getRedate());
    }

    @Override
    public int getItemCount() {
        return lists.size();
    }
    public class myviewholder extends RecyclerView.ViewHolder  {

        ImageView bikephoto;
        TextView bikeCompany,bikemodel,date,redate;
        Button edit,cancel;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            bikephoto=(ImageView)itemView.findViewById(R.id.photo);
            bikeCompany=(TextView)itemView.findViewById(R.id.bikeCompany);
            bikemodel=(TextView)itemView.findViewById(R.id.bikemodel);
            date=(TextView)itemView.findViewById(R.id.date);
            redate=(TextView)itemView.findViewById(R.id.redate);
            edit=(Button) itemView.findViewById(R.id.edit);
            cancel=(Button) itemView.findViewById(R.id.cancel);

        }
    }
}
