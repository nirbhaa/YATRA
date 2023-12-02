package com.example.yatra.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.yatra.R;


public class splashActivity extends AppCompatActivity {
    ImageView img1;
    Animation top;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        img1 = (ImageView) findViewById(R.id.logo);


        top = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.splashanimation);


        img1.setAnimation(top);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(), IntroActivity.class));
                finish();
            }
        }, 5000);
    }
}