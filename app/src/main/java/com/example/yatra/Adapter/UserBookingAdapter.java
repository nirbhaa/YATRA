package com.example.yatra.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.yatra.JSONSchemas.BookingDelete;
import com.example.yatra.JSONSchemas.BookingUpdate.BookingUpdate;
import com.example.yatra.JSONSchemas.Contact;
import com.example.yatra.JSONSchemas.Offer.Offer;
import com.example.yatra.JSONSchemas.UserBokingModel.Booking;
import com.example.yatra.JSONSchemas.UserDetails.UserLoginDetails;
import com.example.yatra.R;
import com.example.yatra.activity.BikedetailsActivity;
import com.example.yatra.activity.EditBooking;
import com.example.yatra.activity.HomeMainActivity;
import com.example.yatra.activity.LoginActivity;
import com.example.yatra.activity.MyBookingDetailsActivity;
import com.example.yatra.retrofit.ApiService;
import com.example.yatra.retrofit.ApiUtil;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserBookingAdapter extends RecyclerView.Adapter<UserBookingAdapter.myviewholder> {

    private List<Booking> lists;
    Context context;

    public UserBookingAdapter(List<Booking> lists, Context context) {

        this.lists = lists;
        this.context = context;
    }

    @NonNull
    @Override
    public UserBookingAdapter.myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_booking_details, parent, false);
        return new UserBookingAdapter.myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserBookingAdapter.myviewholder holder, int position) {
        final Booking temp = lists.get(position);
        String image = lists.get(position).getBike().getProductImage();
        holder.bikeCompany.setText(lists.get(position).getBike().getProductName());
        holder.bikemodel.setText(lists.get(position).getBike().getModel());
        holder.redate.setText(lists.get(position).getBookingEndTime());
        holder.date.setText(lists.get(position).getBookingStartTime());

        Glide.with(context)
                .asBitmap()
                .load(image)
                .into(holder.photo);
//        holder.edit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i = new Intent(context, EditBooking.class);
//                i.putExtra("abc", temp.getBookingId().toString());
//
//                i.putExtra("bikename", temp.getBike().getProductName());
//                i.putExtra("bikeid", temp.getBike().getId());
//                // i.putExtra("bikeimage", temp.get());
//                i.putExtra("priceperday", temp.getBike().getRentalPrice());
//                i.putExtra("startdate", temp.getBookingStartTime());
//                i.putExtra("enddate", temp.getBookingEndTime());
//                i.putExtra("days", temp.getNoOfDays());
//                i.putExtra("totalAmount", temp.getTotalCost());
//                //  i.putExtra("totalAmount", temp.getTotalCost());
//                i.setFlags((Intent.FLAG_ACTIVITY_NEW_TASK));
//                context.startActivity(i);
//            }
//        });
        holder.cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = getIntent();
                String id = temp.getBookingId().toString();
                ApiService apiService = ApiUtil.getApiService();
                Call<BookingDelete> responseBodyCall = apiService.getdelete(id);
                responseBodyCall.enqueue(new Callback<BookingDelete>() {
                    @Override
                    public void onResponse(Call<BookingDelete> call, Response<BookingDelete> response) {
                        if (response.code() == 200) {
                            Toast.makeText(context, "Booking  Cancelled Successfully", Toast.LENGTH_SHORT).show();
//                            Intent i = new Intent(context, MyBookingDetailsActivity.class);
//                            context.startActivity(i);
                            Intent intent = new Intent(context, MyBookingDetailsActivity.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            context.startActivity(intent);
                        } else {
                            Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<BookingDelete> call, Throwable t) {

                    }
                });

            }

            private Intent getIntent() {
                return null;
            }
        });


    }

    @Override
    public int getItemCount() {
        return lists.size();
    }

    public class myviewholder extends RecyclerView.ViewHolder {

        TextView bikeCompany, bikemodel, date, redate;
        ImageView photo;
        Button  cancel;

        public myviewholder(@NonNull View itemView) {
            super(itemView);

            bikeCompany = (TextView) itemView.findViewById(R.id.bikeCompany);
            bikemodel = (TextView) itemView.findViewById(R.id.bikemodel);
            redate = (TextView) itemView.findViewById(R.id.redate);
            date = (TextView) itemView.findViewById(R.id.date);
            photo = (ImageView) itemView.findViewById(R.id.photo);
          //  edit = (Button) itemView.findViewById(R.id.edit);
            cancel = (Button) itemView.findViewById(R.id.cancel);

        }
    }
}