package com.example.yatra.activity;

import static android.view.View.GONE;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.yatra.ProfileFragment;
import com.example.yatra.R;

public class ChangePasswordActivity extends AppCompatActivity {
    ImageView change;
    ScrollView hideChange;
    EditText changepassword,newPassword,ConfirmPassword;
    Button btnchangepassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        change =findViewById(R.id.change);
        hideChange=findViewById(R.id.hideChange);
        //changepassword=findViewById(R.id.changepassword);
        newPassword=findViewById(R.id.newPassword);
        ConfirmPassword=findViewById(R.id.ConfirmPassword);
        btnchangepassword=findViewById(R.id.btnchangepassword);



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