package com.example.yatra.activity;

import static android.view.View.GONE;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;

import com.example.yatra.Adapter.Citybikeadapter;
import com.example.yatra.Adapter.RecommendedAdapter;
import com.example.yatra.HomeFragment;
import com.example.yatra.JSONSchemas.BikesRespose;
import com.example.yatra.JSONSchemas.CategoryBikes.CategoryModel;
import com.example.yatra.JSONSchemas.RecommdedBike.RecoomendedModel;
import com.example.yatra.R;
import com.example.yatra.retrofit.ApiService;
import com.example.yatra.retrofit.ApiUtil;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CityBikeActivity extends AppCompatActivity {
    private View view;
    ImageView movecontact;
    ScrollView scrollView2;
    Citybikeadapter cityBikesAdapter;
    RecommendedAdapter recommendedAdapter;

    LinearLayoutManager linearLayoutManager;


    RecyclerView cityBikeView,recommended2,cityBikes;
    Context mContext ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_bike);
        movecontact = findViewById(R.id.city);
     //  initCityBikes();
        initCityBike();
        initRecommended();

        movecontact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //arrow activity to fragment

                // Fragment fragment=new ProfileFragment();
                // FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
                //  fragmentTransaction.replace(R.id.aboutYatra,fragment).commit();
                //     hideAbout.setVisibility(View.GONE);
                HomeFragment fragment = new HomeFragment();
                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.replace(R.id.contact, fragment);
                transaction.addToBackStack(null);
                scrollView2.setVisibility(GONE);
                transaction.commit();
            }


        });




    }

//  private void initCityBikes() {
//        ApiService apiService = ApiUtil.getApiService();
//          apiService.getPopularBikes().enqueue(new Callback<BikesRespose>() {
//              @Override
//              public void onResponse(Call<BikesRespose> call, Response<BikesRespose> response) {
//                  if (response.isSuccessful()) {
//                      BikesRespose bikesResponse = response.body();
//                      cityBikes = findViewById(R.id.cityBikeView);
//                      cityBikesAdapter = new Citybikeadapter(bikesResponse.getBike(), getApplicationContext());
//                      linearLayoutManager = new LinearLayoutManager(getApplicationContext());
//                      linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
//                      cityBikes.setLayoutManager(linearLayoutManager);
//                      cityBikes.setAdapter(cityBikesAdapter);
//                      cityBikesAdapter.notifyDataSetChanged();
//                  }
//              }
//
//              @Override
//              public void onFailure(Call<BikesRespose> call, Throwable t) {
//
//              }
//          });
//      }

//      private void initCityBikes(View view){
//          ApiService apiService = ApiUtil.getApiService();
//          apiService.getPopularBikes().enqueue(new Callback<BikesRespose>() {
//              @Override
//              public void onResponse(Call<BikesRespose> call, Response<BikesRespose> response) {
//                  if (response.isSuccessful()) {
//                      BikesRespose bikesResponse = response.body();
//                      cityBikes = view.findViewById(R.id.cityBikeView);
//                      cityBikesAdapter = new Citybikeadapter(bikesResponse.getBike(), mContext);
//                      linearLayoutManager = new LinearLayoutManager(mContext);
//                      linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
//                      cityBikes.setLayoutManager(linearLayoutManager);
//                      cityBikes.setAdapter(cityBikesAdapter);
//                      cityBikesAdapter.notifyDataSetChanged();
//                  }
//              }
//
//              @Override
//              public void onFailure(Call<BikesRespose> call, Throwable t) {
//
//            }
//         });
//      }
private void initRecommended() {
    ApiService apiService = ApiUtil.getApiService();
    apiService.getRecommended().enqueue(new Callback<RecoomendedModel>() {
        @Override
        public void onResponse(Call<RecoomendedModel> call, Response<RecoomendedModel> response) {
            if (response.isSuccessful()) {
                RecoomendedModel recoomendedModel = response.body();
                recommended2 = findViewById(R.id.recommended2);
                recommendedAdapter = new RecommendedAdapter(recoomendedModel.getBikes(), getApplicationContext());
                linearLayoutManager = new LinearLayoutManager(getApplicationContext());
                linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                recommended2.setLayoutManager(linearLayoutManager);
                recommended2.setAdapter(recommendedAdapter);
                recommendedAdapter.notifyDataSetChanged();
            }
        }

        @Override
        public void onFailure(Call<RecoomendedModel> call, Throwable t) {

        }
    });
}


private void initCityBike(){
//    SharedPreferences sh = getSharedPreferences("MySharedPref",MODE_PRIVATE);
//    String s1 = sh.getString("id", "");
    String s1 = "1";
    ApiService apiService = ApiUtil.getApiService();
    apiService.getCategory(s1).enqueue(new Callback<CategoryModel>() {
        @Override
        public void onResponse(Call<CategoryModel> call, Response<CategoryModel> response) {
            if (response.isSuccessful()) {
                CategoryModel categoryModel = response.body();
                cityBikeView = findViewById(R.id.cityBikeView);
                cityBikesAdapter = new Citybikeadapter(categoryModel.getBikes(), getApplicationContext());
                linearLayoutManager = new LinearLayoutManager(getApplicationContext());
                linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                cityBikeView.setLayoutManager(linearLayoutManager);
                cityBikeView.setAdapter(cityBikesAdapter);
                cityBikesAdapter.notifyDataSetChanged();
            }
        }

        @Override
        public void onFailure(Call<CategoryModel> call, Throwable t) {

        }
    });

}

}