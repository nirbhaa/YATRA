package com.example.yatra.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.yatra.JSONSchemas.ForgetEmail;
import com.example.yatra.R;
import com.example.yatra.retrofit.ApiService;
import com.example.yatra.retrofit.ApiUtil;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class forgotPasswordActivity extends AppCompatActivity {
ImageView forgotpassword;
    Button btnRecover;
    EditText emails;
    String email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

         btnRecover=findViewById(R.id.btnRecover);
         forgotpassword=findViewById(R.id.forgotpassword);
        emails=findViewById(R.id.email);
       // email = getIntent().getStringExtra("email");

        btnRecover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ApiService apiService = ApiUtil.getApiService();
                Call<ForgetEmail> forgetPwEmailVerifyCall = apiService.forgetEmail(emails.getText().toString());
                forgetPwEmailVerifyCall.enqueue(new Callback<ForgetEmail>() {
                    @Override
                    public void onResponse(Call<ForgetEmail> call, Response<ForgetEmail> response) {
                        if(response.code() == 200) {
                            Toast.makeText(forgotPasswordActivity.this,"OTP has been sent",Toast.LENGTH_SHORT).show();
//                           SharedPreferences sharedPreferences = getSharedPreferences("USER",MODE_PRIVATE);
//                            sharedPreferences.edit().putString("email",emails.getText().toString()).apply();
                            //save token

                            Intent i = new Intent(forgotPasswordActivity.this,ForgotPassword2Activity.class);
                            i.putExtra("email", emails.getText().toString().trim());
                            startActivity(i);
                            finish();
                        }else if (response.code() == 401){
                            Toast.makeText(forgotPasswordActivity.this,"Invalid email address",Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(forgotPasswordActivity.this,"Error",Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onFailure(Call<ForgetEmail> call, Throwable t) {

                        Toast.makeText(forgotPasswordActivity.this,"Fail",Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        forgotpassword.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        startActivity(new Intent(forgotPasswordActivity.this, LoginActivity.class));
    }
});



    }

}