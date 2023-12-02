package com.example.yatra;

import static android.content.Context.MODE_PRIVATE;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.yatra.Adapter.ImageSliderAdapter;
import com.example.yatra.Adapter.Popularbikeadapter;
import com.example.yatra.Adapter.SliderAdapter;
import com.example.yatra.JSONSchemas.Bike;
import com.example.yatra.JSONSchemas.BikesRespose;
import com.example.yatra.JSONSchemas.SliderImage.AdapterSlider;
import com.example.yatra.Models.ImageSliderModel;
import com.example.yatra.Models.PopularBikeList;
import com.example.yatra.Models.SliderData;
import com.example.yatra.Models.favoriteslist;
import com.example.yatra.activity.ChangePasswordActivity;
import com.example.yatra.activity.CityBikeActivity;
import com.example.yatra.activity.LoginActivity;
import com.example.yatra.activity.RoadBikeActivity;
import com.example.yatra.activity.TouringBikeActivity;
import com.example.yatra.activity.forgotPasswordActivity;
import com.example.yatra.retrofit.ApiService;
import com.example.yatra.retrofit.ApiUtil;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.slider.Slider;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
TextView Uname;
    private View view;

    RecyclerView popularBikes,recycle1;
    Popularbikeadapter popularBikesAdapter;
    AdapterSlider adapterSlider;
    List<PopularBikeList> items;
    List<Slider> data;
    ImageSliderAdapter imageSliderAdapter;
    Context mContext , Context;
    LinearLayoutManager linearLayoutManager;
    ShapeableImageView scooter,bike,road;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // initRecycleView(view);
        // initData();
        view = inflater.inflate(R.layout.fragment_home, container, false);


//        ArrayList<PopularBikeList> popBikes = new ArrayList<>();
//        popBikes.add(new PopularBikeList(1,"fghbj","fghbj","fghbj","fghbj","fghbj","fghbj","fghbj"));
//        popBikes.add(new PopularBikeList(1,"fghbj","fghbj","fghbj","fghbj","fghbj","fghbj","fghbj"));
//        popBikes.add(new PopularBikeList(1,"fghbj","fghbj","fghbj","fghbj","fghbj","fghbj","fghbj"));
//        popBikes.add(new PopularBikeList(1,"fghbj","fghbj","fghbj","fghbj","fghbj","fghbj","fghbj"));
//        popBikes.add(new PopularBikeList(1,"fghbj","fghbj","fghbj","fghbj","fghbj","fghbj","fghbj"));
//
//        popularBikes=view.findViewById(R.id.popularBikesView);
//        popularBikesAdapter= new Popularbikeadapter(popBikes,mContext);
//        linearLayoutManager = new LinearLayoutManager(mContext);
//        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
//        popularBikes.setLayoutManager(linearLayoutManager);
//        popularBikes.setAdapter(popularBikesAdapter);




        //imageSlider
//                ArrayList<ImageSliderModel> slideimage = new ArrayList<>();
//        slideimage.add(new ImageSliderModel("https://i.ytimg.com/vi/KQT9tf9JgGM/maxresdefault.jpg","image"));
//        slideimage.add(new ImageSliderModel("https://i.ytimg.com/vi/KQT9tf9JgGM/maxresdefault.jpg","image"));
//
//        recycle1=view.findViewById(R.id.recycle1);
//        imageSliderAdapter= new ImageSliderAdapter(slideimage,Context);
//        linearLayoutManager = new LinearLayoutManager(Context);
//        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
//        recycle1.setLayoutManager(linearLayoutManager);
//        recycle1.setAdapter(popularBikesAdapter);
//     final  int interval_time=3000;
//        Handler handler=new Handler();
//        Runnable runnable=new Runnable() {
//            int count=0;
//            @Override
//            public void run() {
//if(count == slideimage.size()){
//recycle1.scrollToPosition(count++);
//handler.postDelayed(this,interval_time);
//if(count==slideimage.size()) {
//    count=0;
//}
//}
//            }
//        };
//        handler.postDelayed(runnable,interval_time);



        /*scooter = rootView.findViewById(R.id.scooter);
        scooter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(requireContext(), CityBikeActivity.class));
            }
        });*/


        // for setting username in home fragment user
        Uname = view.findViewById(R.id.Uname);
        SharedPreferences sh = getActivity().getSharedPreferences("MySharedPref",MODE_PRIVATE);
        String s1 = sh.getString("username", "");
        String user_name = sh.getString("name", "");

        Uname.setText(user_name);
        initSlider(view);

//initSlider(view);
        init(view);
        initPopBikes(view);
        return view;
    }

//    private SharedPreferences getSharedPreferences(String mySharedPref, int modePrivate) {
//        return null;
//    }

    private void init(View view) {
        scooter=view.findViewById(R.id.scooter);
        scooter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mContext, CityBikeActivity.class));
            }
        });
        bike=view.findViewById(R.id.bike);
        bike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mContext, TouringBikeActivity.class));
            }
        });

       road=view.findViewById(R.id.road);
      road.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mContext, RoadBikeActivity.class));
            }
        });



    }


    private void initSlider(View view) {
        ApiService apiService = ApiUtil.getApiService();
        apiService.getSliderImage().enqueue(new Callback<AdapterSlider>() {
            @Override
            public void onResponse(Call<AdapterSlider> call, Response<AdapterSlider> response) {
                if (response.isSuccessful()) {
                    AdapterSlider adapterSlider = response.body();

                    if (adapterSlider != null) {

                        // Initialize the slider view.
                        SliderView sliderView = view.findViewById(R.id.slider);

                        // Create an adapter and set it to the slider view.
                        SliderAdapter adapter = new SliderAdapter(getActivity(), adapterSlider.getSlider());
                        sliderView.setAutoCycleDirection(SliderView.LAYOUT_DIRECTION_LTR);
                        sliderView.setSliderAdapter(adapter);
                        sliderView.setScrollTimeInSec(3);
                        sliderView.setAutoCycle(true);
                        sliderView.startAutoCycle();




                    }
                }

            }

            @Override
            public void onFailure(Call<AdapterSlider> call, Throwable t) {

            }
        });
    }
//
//    private void initSlider() {
//        String url1 = "https://www.geeksforgeeks.org/wp-content/uploads/gfg_200X200-1.png";
//        String url2 = "https://qphs.fs.quoracdn.net/main-qimg-8e203d34a6a56345f86f1a92570557ba.webp";
//        String url3 = "https://bizzbucket.co/wp-content/uploads/2020/08/Life-in-The-Metro-Blog-Title-22.png";
//
//        // Create an array list for storing image URLs.
//        ArrayList<SliderData> sliderDataArrayList = new ArrayList<>();
//
//        // Initialize the slider view.
//        SliderView sliderView = view.findViewById(R.id.slider);
//
//        // Add the URLs to the array list.
//        sliderDataArrayList.add(new SliderData(url1));
//        sliderDataArrayList.add(new SliderData(url2));
//        sliderDataArrayList.add(new SliderData(url3));
//
//        // Create an adapter and set it to the slider view.
//        SliderAdapter adapter = new SliderAdapter(getActivity(), sliderDataArrayList);
//        sliderView.setAutoCycleDirection(SliderView.LAYOUT_DIRECTION_LTR);
//        sliderView.setSliderAdapter(adapter);
//        sliderView.setScrollTimeInSec(3);
//        sliderView.setAutoCycle(true);
//        sliderView.startAutoCycle();
//
//
//    }





    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    private void initPopBikes(View view) {

        ApiService apiService = ApiUtil.getApiService();
        apiService.getPopularBikes().enqueue(new Callback<BikesRespose>() {
            @Override
            public void onResponse(Call<BikesRespose> call, Response<BikesRespose> response) {
                if (response.isSuccessful()) {
                    BikesRespose bikesResponse = response.body();
                    popularBikes = view.findViewById(R.id.popularBikesView);
                    popularBikesAdapter = new Popularbikeadapter(bikesResponse.getBike(), mContext);
                    linearLayoutManager = new LinearLayoutManager(mContext);
                    linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                    popularBikes.setLayoutManager(linearLayoutManager);
                    popularBikes.setAdapter(popularBikesAdapter);
                    popularBikesAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<BikesRespose> call, Throwable t) {

            }
        });

    }


}