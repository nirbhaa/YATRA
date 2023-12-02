package com.example.yatra.activity;

import static android.view.View.GONE;



import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.example.yatra.ProfileFragment;
import com.example.yatra.R;

public class AboutUsActivity extends AppCompatActivity {
ImageView about;
ScrollView hideAbout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        about =findViewById(R.id.about);
        hideAbout=findViewById(R.id.hideAbout);



        about.setOnClickListener(new View.OnClickListener() {
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
              transaction.replace(R.id.aboutYatra,fragment);
             transaction.addToBackStack(null);
             hideAbout.setVisibility(GONE);
              transaction.commit();
            }


        });


    }
}