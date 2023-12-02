package com.example.yatra.activity;

import static android.view.View.GONE;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.Toast;

import com.example.yatra.Adapter.Citybikeadapter;
import com.example.yatra.Adapter.RecommendedAdapter;
import com.example.yatra.Adapter.UserBookingAdapter;
import com.example.yatra.JSONSchemas.CategoryBikes.CategoryModel;
import com.example.yatra.JSONSchemas.RecommdedBike.RecoomendedModel;
import com.example.yatra.JSONSchemas.UserBokingModel.UserBookingModel;
import com.example.yatra.ProfileFragment;
import com.example.yatra.R;
import com.example.yatra.retrofit.ApiService;
import com.example.yatra.retrofit.ApiUtil;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyBookingDetailsActivity extends AppCompatActivity {
    RecyclerView BookingView;
    UserBookingAdapter userBookingAdapter;
    LinearLayoutManager linearLayoutManager;
    ImageView arrowbooking;
    ScrollView hideAbout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_booking_details);
        arrowbooking=findViewById(R.id.arrowbooking);


        arrowbooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //activity to fragment

                // Fragment fragment=new ProfileFragment();
                // FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
                //  fragmentTransaction.replace(R.id.aboutYatra,fragment).commit();
                //     hideAbout.setVisibility(View.GONE);
                ProfileFragment fragment=new ProfileFragment();
                FragmentManager manager=getSupportFragmentManager();
                FragmentTransaction transaction=manager.beginTransaction();
                transaction.replace(R.id.aboutBooking,fragment);
                transaction.addToBackStack(null);
                hideAbout.setVisibility(GONE);
                transaction.commit();
            }


        });




















        SharedPreferences sharedPreferences = getSharedPreferences("USER", MODE_PRIVATE);
        // SharedPreferences.Editor sh = sharedPreferences.edit();
        String token = sharedPreferences.getString("TOKENLOGIN", "");
        // Log.v("token",token);
        // fetchPosts(token = "Bearer ${sessionManager.fetchAuthToken()}")
        ApiService apiService = ApiUtil.getApiService();
        apiService.getUserBooking(token = "Bearer " + token).enqueue(new Callback<UserBookingModel>() {
            @Override
            public void onResponse(Call <UserBookingModel> call, Response<UserBookingModel> response) {
                if (response.code() == 200) {
                    UserBookingModel userBookingModel = response.body();
                    BookingView = findViewById(R.id.BookingView);
                    userBookingAdapter = new UserBookingAdapter(userBookingModel.getBookings(), getApplicationContext());
                    linearLayoutManager = new LinearLayoutManager(getApplicationContext());
                    linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                    BookingView.setLayoutManager(linearLayoutManager);
                    BookingView.setAdapter(userBookingAdapter);
                    userBookingAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<UserBookingModel> call, Throwable t) {
                Toast.makeText(MyBookingDetailsActivity.this, "Fail", Toast.LENGTH_SHORT).show();
            }
        });







}
}