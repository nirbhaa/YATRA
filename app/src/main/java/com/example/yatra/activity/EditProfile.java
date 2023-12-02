package com.example.yatra.activity;

import static android.view.View.GONE;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;

import com.example.yatra.ProfileFragment;
import com.example.yatra.R;

public class EditProfile extends AppCompatActivity {
    ImageView change;
    ScrollView hideChange;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        change =findViewById(R.id.change);
        hideChange=findViewById(R.id.hideChange);
        change.setOnClickListener(new View.OnClickListener() {
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
                transaction.replace(R.id.changeYatra,fragment);
                transaction.addToBackStack(null);
                hideChange.setVisibility(GONE);
                transaction.commit();
            }


        });
    }
}