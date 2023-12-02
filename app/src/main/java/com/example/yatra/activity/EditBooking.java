package com.example.yatra.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yatra.JSONSchemas.BookingModel;
import com.example.yatra.JSONSchemas.BookingUpdate.BookingUpdate;
import com.example.yatra.JSONSchemas.Contact;
import com.example.yatra.JSONSchemas.UserDetails.UserLoginDetails;
import com.example.yatra.R;
import com.example.yatra.retrofit.ApiService;
import com.example.yatra.retrofit.ApiUtil;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditBooking extends AppCompatActivity {
    EditText  NameBike, RentDate, ReturnDate, autoDaysText, priceperday, totalamount;
    Button btnbook,deletebook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_booking);


//        Name = findViewById(R.id.Name);
//        Email = findViewById(R.id.Email);
//        PhoneNumber = findViewById(R.id.PhoneNumber);
//        Address = findViewById(R.id.Address);

        RentDate = findViewById(R.id.RentDate);
        ReturnDate = findViewById(R.id.ReturnDate);
        autoDaysText = findViewById(R.id.autoDaysText);
        priceperday = findViewById(R.id.priceperday);
        totalamount = findViewById(R.id.totalamount);
        btnbook = findViewById(R.id.btnbook);



        RentDate.setText(getIntent().getStringExtra("startdate"));
        ReturnDate.setText(getIntent().getStringExtra("enddate"));
        Integer abc =  getIntent().getIntExtra("days", 0);
    Integer bikeid = getIntent().getIntExtra("bikeid",0);
        autoDaysText.setText(abc.toString());


       // totalamount.setText(getIntent().getStringExtra("totalAmount"));
      totalamount.setText(getIntent().getStringExtra("totalAmount"));
        priceperday.setText(getIntent().getStringExtra("priceperday"));




        btnbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                String abc = totalamount.getText().toString();
//                Log.v("test",abc);
                String id = intent.getStringExtra("abc");
//                Log.v("xyz", id);

                SharedPreferences sharedPreferences1 = getSharedPreferences("MySharedPref", MODE_PRIVATE);
                String user_id = sharedPreferences1.getString("userid", "");

                ApiService apiService = ApiUtil.getApiService();
               // Integer.parseInt(autoDaysText.getText().toString());
            Call<BookingUpdate> responseBodyCall = apiService.getUpdateBooking(id,user_id,bikeid.toString(), RentDate.getText().toString(), ReturnDate.getText().toString(),
                    Double.parseDouble(abc),Integer.parseInt(autoDaysText.getText().toString()));
                responseBodyCall.enqueue(new Callback<BookingUpdate>() {


                    @Override
                    public void onResponse(Call<BookingUpdate> call, Response<BookingUpdate> response) {

                        try {
                            Log.v("sab",response.errorBody().string());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        if (response.code()==200) {
                            Toast.makeText(EditBooking.this, "Booking details updated Successfully", Toast.LENGTH_SHORT).show();
                            BookingUpdate responseBody = response.body();
                            startActivity(new Intent(EditBooking.this, MyBookingDetailsActivity.class));

                        } else {

                            Toast.makeText(EditBooking.this, "update failed", Toast.LENGTH_LONG).show();
                            //startActivity(new Intent(EditBooking.this, MyBookingDetailsActivity.class));
                        }
                    }

                    @Override
                    public void onFailure(Call<BookingUpdate> call, Throwable t) {
                        Toast.makeText(EditBooking.this, "Error" + t.getMessage(), Toast.LENGTH_LONG).show();
                    }

                });
            }
        });
//    }
//
//    private TextView autoDaysText() {
//        return null;
//    }



    }

}