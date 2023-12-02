package com.example.yatra.activity;

import static com.example.yatra.R.*;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.yatra.FavoriteFragment;
import com.example.yatra.HomeFragment;
import com.example.yatra.OfferFragment;
import com.example.yatra.ProfileFragment;
import com.example.yatra.R;
import com.example.yatra.retrofit.ApiService;
import com.example.yatra.retrofit.ApiUtil;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.json.JSONObject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_home_main);


//for checking login status
//        SharedPreferences sh1 = getSharedPreferences("MySharedPref", MODE_PRIVATE);
//        Boolean b1 = sh1.getBoolean("isLoggedIn", false);



        //getSupportFragmentManager().beginTransaction().replace(R.id.frameContainer,new HomeFragment()).commit();
        BottomNavigationView bottom_nav = findViewById(R.id.bottom_nav);
        bottom_nav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
           @Override
          public boolean onNavigationItemSelected(@NonNull MenuItem item) {
               int id = item.getItemId();
          if (id ==R. id.nav_profile){
            loadfrag(new ProfileFragment(),false);
         }
          else if (id == R.id.nav_fav) {
                  loadfrag(new FavoriteFragment(),false);
           }
          else if (id == R.id.nav_offer) {
                 loadfrag(new OfferFragment(),false);
               }
          else {
                  loadfrag(new HomeFragment(),false);
             }

            return true;
    }
       });
        bottom_nav.setSelectedItemId(R.id.nav_home);

   }
   public void loadfrag(Fragment fragment,boolean flag){
       FragmentManager fragmentManager=getSupportFragmentManager();
       FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
       if(flag)
       fragmentTransaction.add (R.id.frameContainer,fragment);
       else
           fragmentTransaction.replace (R.id.frameContainer,fragment);
      fragmentTransaction.commit();




    }
//for getting user details
//    private void getUserDetails() {
//        SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);
//        String UserId = sh.getString("id", "");
//
//        ApiService apiService = ApiUtil.getApiService();
//        apiService.userDetailsGet(UserId).enqueue(new Callback<ResponseBody>() {
//            @Override
//            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//
//
//
//                if (response.isSuccessful()) {
//                    try {
//                        String val = response.body().string();
//                        JSONObject obj = new JSONObject(val);
//                        String username = obj.getString("username");
//                        String phone = obj.getString("phone");
//                        String address = obj.getString("addres");
//                        String gender = obj.getString("gender");
//                        String image = obj.getString("image");
//
//
//
//
//                        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
//                        SharedPreferences.Editor loginPreferences = sharedPreferences.edit();
//                        loginPreferences.putString("username", username);
//                        loginPreferences.putString("phone", phone);
//                        loginPreferences.putString("address", address);
//                        loginPreferences.putString("gender", gender);
//                        loginPreferences.putString("image", image);
//                        //loginPreferences.putString("id", id);
//                        loginPreferences.apply();
//
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//
//
//                }
//
//
//
//            @Override
//            public void onFailure(Call<ResponseBody> call, Throwable t) {
//                Toast.makeText(MainActivity.this, "Error" + t.getMessage(), Toast.LENGTH_SHORT).show();
//
//            }
//        });
//
//
//    }

}