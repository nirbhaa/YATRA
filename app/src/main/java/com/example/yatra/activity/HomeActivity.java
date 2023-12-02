package com.example.yatra.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.yatra.Adapter.Popularbikeadapter;
import com.example.yatra.FavoriteFragment;
import com.example.yatra.HomeFragment;
import com.example.yatra.Models.PopularBikeList;
import com.example.yatra.OfferFragment;
import com.example.yatra.ProfileFragment;
import com.example.yatra.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    RecyclerView rcv;
    Popularbikeadapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        //rcv = (RecyclerView) findViewById(R.id.view);
        //  rcv.setLayoutManager(new LinearLayoutManager(this));


        //rcv = (RecyclerView) findViewById(R.id.view);
       // adapter = new Popularbikeadapter(dataqueue(), getApplicationContext());
      //  rcv.setAdapter(adapter);
       // LinearLayoutManager layoutManager = new LinearLayoutManager(this,
         //       LinearLayoutManager.HORIZONTAL, false);
      //  rcv.setLayoutManager(layoutManager);

        //GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
       //  rcv.setLayoutManager(gridLayoutManager);
    }
    public ArrayList<PopularBikeList> dataqueue() {
        ArrayList<PopularBikeList> items = new ArrayList<>();
        PopularBikeList ob1 = new PopularBikeList();
        ob1.setBikeCompany("ktm");
        ob1.setBikemodel("Duke");
        ob1.setMileage("3");
        ob1.setEngine("66");
        ob1.setFuelcapacity("89");
        ob1.setFueltype("petrol");
        ob1.setPrice("300");
        items.add(ob1);

        PopularBikeList ob2 = new PopularBikeList();
        ob2.setBikeCompany("Royal Enfield");
        ob2.setBikemodel("Classic 350");
        ob2.setMileage("56");
        ob2.setEngine("64");
        ob2.setFuelcapacity("89");
        ob2.setFueltype("petrol");
        ob1.setBikePhoto1(R.drawable.popular_11);
        ob2.setPrice("350");
        ob2.setBikePhoto1(R.drawable.popular_12);
        items.add(ob2);

        PopularBikeList ob3 = new PopularBikeList();
        ob3.setBikeCompany("TVS");
        ob3.setBikemodel("NTORQ 200");
        ob3.setMileage("56");
        ob3.setEngine("64");
        ob3.setFuelcapacity("89");
        ob3.setFueltype("petrol");
        ob3.setPrice("350");
        ob3.setBikePhoto1(R.drawable.popular_13);
        items.add(ob3);

        return items;
    }


}