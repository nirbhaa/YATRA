package com.example.yatra.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.chaos.view.PinView;
import com.example.yatra.JSONSchemas.Otpverify;
import com.example.yatra.JSONSchemas.ResendApi;
import com.example.yatra.R;
import com.example.yatra.retrofit.ApiService;
import com.example.yatra.retrofit.ApiUtil;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ForgotPassword2Activity extends AppCompatActivity {
    ImageView verification;
    //EditText code;
    PinView pinView;
    Button btnVerify;
    TextView resend;
    String email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password2);
        verification = findViewById(R.id.verification);
        pinView = findViewById(R.id.pinView);
        btnVerify = findViewById(R.id.btnVerify);
        resend = findViewById(R.id.resend);
        email = getIntent().getStringExtra("email");
       // Log.v("forgot",email);
//button
        btnVerify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ApiService apiService = ApiUtil.getApiService();
                Call<Otpverify> otpverifyCall = apiService.otpVerify(email, pinView.getText().toString());
                otpverifyCall.enqueue(new Callback<Otpverify>() {
                    @Override
                    public void onResponse(Call<Otpverify> call, Response<Otpverify> response) {
                        if (response.code() == 200) {
                            Toast.makeText(ForgotPassword2Activity.this, "Verification Successfully", Toast.LENGTH_SHORT).show();
                            SharedPreferences sharedPreferences = getSharedPreferences("otp", MODE_PRIVATE);
                            sharedPreferences.edit().putBoolean("otp", true).apply();
                            Intent intent = new Intent(ForgotPassword2Activity.this, forgotResetPasswordActivity.class);
                            intent.putExtra("email", email.toString().trim());
                            startActivity(intent);
                            finish();
                        } else if (response.code() == 401) {
                            Toast.makeText(ForgotPassword2Activity.this, "You entered wrong OTP", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(ForgotPassword2Activity.this, "Error", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Otpverify> call, Throwable t) {
                        Toast.makeText(ForgotPassword2Activity.this, "Fail", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        //resend
        resend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ApiService apiService = ApiUtil.getApiService();
//                SharedPreferences sh = getSharedPreferences("MySharedPref",MODE_PRIVATE);
//                String email = sh.getString("username", "");
//                Bundle extras = getIntent().getExtras();
//                String email = extras.getString("user_email");

                Call<ResendApi> ApiResponseCall = apiService.resendOtp(email);
                ApiResponseCall.enqueue(new Callback<ResendApi>() {
                    @Override
                    public void onResponse(Call<ResendApi> call, Response<ResendApi> response) {
                        if (response.code() == 200) {
                            Toast.makeText(ForgotPassword2Activity.this, "Otp has been sent Again.", Toast.LENGTH_SHORT).show();
                        } else if (response.code()==401){
                            Toast.makeText(ForgotPassword2Activity.this, "Error!! Please try after about 5 minutes.", Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(ForgotPassword2Activity.this, "Error on Server!!", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResendApi> call, Throwable t) {
                        Toast.makeText(ForgotPassword2Activity.this, "Failed to resend!!", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });


    }

    }


