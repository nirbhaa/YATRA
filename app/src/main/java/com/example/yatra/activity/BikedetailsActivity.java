package com.example.yatra.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.yatra.JSONSchemas.FavoriteBike;
import com.example.yatra.JSONSchemas.UserRegister;
import com.example.yatra.R;
import com.example.yatra.retrofit.ApiService;
import com.example.yatra.retrofit.ApiUtil;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BikedetailsActivity extends AppCompatActivity {
    ImageView img;
    ImageView bikedetails;
    TextView bikemodel1, mileage1, engine1, fuelcapacity1, fueltype1, price1, bikename1;
    Button btBook;
   // Integer bike1_id;
    String bike_id,bike1_id;
    ImageView favIcon;

    private boolean isFavorite = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bikedetails);

        bikename1=findViewById(R.id.bikeName);
        bikemodel1=findViewById(R.id.modelBike);
        mileage1=findViewById(R.id.kmpl);
        engine1=findViewById(R.id.CC);
        fuelcapacity1=findViewById(R.id.liters);
        fueltype1=findViewById(R.id.petrol);
        price1=findViewById(R.id.Price);
        img=findViewById(R.id.ImageBike);
        bikedetails=findViewById(R.id.bikedetails);
        btBook=findViewById(R.id.btBook);
       favIcon=findViewById(R.id.favIcon);
     //   bikes_id=getIntent().getIntExtra("bikeid",0);
        bike_id=getIntent().getStringExtra("bikeid");


        final boolean[] isFavorite = {false}; // Track the favorite state
        favIcon.setImageResource(R.drawable.boder_heart);
        favIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isFavorite[0]) {

                   // Log.v("bikeid",bikes_id.toString());
                    favIcon.setImageResource(R.drawable.boder_heart);
                    isFavorite[0] = false;
//                    initfavbike();

                    Toast.makeText(BikedetailsActivity.this, "Bike Removed From Favourite Successfully", Toast.LENGTH_SHORT).show();

                } else {
                    favIcon.setImageResource(R.drawable.love);
                    isFavorite[0] = true;
//                    Toast.makeText(BikedetailsActivity.this, "Bike Removed From Favourite Successfully", Toast.LENGTH_SHORT).show();
                    initfavbike();
                }
            }

            private void initfavbike() {
                //Log.v("xyz",bikes_id.toString());
                SharedPreferences sharedPreferences1 = getSharedPreferences("MySharedPref", MODE_PRIVATE);
                SharedPreferences.Editor sh = sharedPreferences1.edit();

                String user_id = sharedPreferences1.getString("userid", "");
                //Log.v("useridd",user_id);
                ApiService apiService = ApiUtil.getApiService();
               // Call<FavoriteBike> responseBodyCall = apiService.storefavouritebike(String.valueOf(bikes_id),user_id);
                Call<FavoriteBike> responseBodyCall = apiService.storefavouritebike(bike_id,user_id);
                responseBodyCall.enqueue(new Callback<FavoriteBike>() {

                    @Override
                    public void onResponse(Call<FavoriteBike> call, Response<FavoriteBike> response) {
                        if (response.code() == 201) {
                            Toast.makeText(BikedetailsActivity.this, "Bike Added to Favourite Successfully", Toast.LENGTH_SHORT).show();
                            FavoriteBike responseBody = response.body();


                        } else if (response.code() == 400) {

                            Toast.makeText(BikedetailsActivity.this, "Error on Server", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call< FavoriteBike> call, Throwable t) {
                        Toast.makeText(BikedetailsActivity.this, "Fail", Toast.LENGTH_SHORT).show();
                    }

                });



            }
        });






        // Intent i =getIntent();

   //     String bikename = i.getStringExtra("bikename");
    //    String bikemodel = i.getStringExtra("bikemodel");
    //    String mileage = i.getStringExtra("mileage");
    //    String engine = i.getStringExtra("engine");
    //    String fuelcapacity = i.getStringExtra("fuelcapacity");
    //    String fueltype = i.getStringExtra("fueltype");
      //  String price = i.getStringExtra("price");
       // String image = i.getStringExtra("image");
        // image= i.getIntExtra("imagename",0);


      //  bikemodel1.setText(bikemodel);
      //   bikename1.setText(bikename);
      //   mileage1.setText(mileage);
     //   engine1.setText(engine);
       //  price1.setText(price);
      //    fuelcapacity1.setText(fuelcapacity);
       //  fueltype1.setText(fueltype);
      //  img.setImageResource(Integer.parseInt(image));









        ///today
       // bike_id=getIntent().getIntExtra("bikeid");
        bike1_id=getIntent().getStringExtra("bikeid");
        String bike_name=getIntent().getStringExtra("bikename");
        String price_per_day=getIntent().getStringExtra("price");
       // Log.v("abc",String.valueOf(bike_id));

      //  img.setImageResource(getIntent().getStringExtra("bikeimage"));
        Glide.with(getApplicationContext())
                .asBitmap()
                .load(getIntent().getStringExtra("bikeimage"))
                .into(img);
        bikemodel1.setText(getIntent().getStringExtra("bikemodel"));
        bikename1.setText(getIntent().getStringExtra("bikename"));
        mileage1.setText(getIntent().getStringExtra("mileage"));
        fuelcapacity1.setText(getIntent().getStringExtra("fuelcapacity"));
        fueltype1.setText(getIntent().getStringExtra("fueltype"));
        price1.setText(getIntent().getStringExtra("price"));
        engine1.setText(getIntent().getStringExtra("engine"));

        bikedetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BikedetailsActivity.this, HomeMainActivity.class));
            }
        });

        btBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startActivity(new Intent(BikedetailsActivity.this, BookingActivity.class));

            // putting bike id in intent for booking
                Intent intent = new Intent(BikedetailsActivity.this, BookingActivity.class);
                intent.putExtra("bikeid",bike1_id);
                intent.putExtra("bikename",bike_name);
                intent.putExtra("price",price_per_day);
                //Log.v("abc",bike_name);
                startActivity(intent);
            }
        });
    }

}