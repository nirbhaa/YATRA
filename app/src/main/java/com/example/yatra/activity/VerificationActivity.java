package com.example.yatra.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.chaos.view.PinView;
import com.example.yatra.JSONSchemas.Otpverify;
import com.example.yatra.JSONSchemas.ResendApi;
import com.example.yatra.JSONSchemas.UserLogin;
import com.example.yatra.R;
import com.example.yatra.retrofit.ApiService;
import com.example.yatra.retrofit.ApiUtil;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VerificationActivity extends AppCompatActivity {
    ImageView verification;
    //EditText code;
    PinView pinView;
    Button btnVerify;
    TextView resend;
    String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification);

        verification = findViewById(R.id.verification);
        pinView = findViewById(R.id.pinView);
        btnVerify = findViewById(R.id.btnVerify);
        resend = findViewById(R.id.resend);
        email = getIntent().getStringExtra("email");
        //  SharedPreferences shp = getSharedPreferences("USERREGISTER", MODE_PRIVATE);
        //   String email = shp.getString("email", "");
        // tvShowEmail.setText(email);

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
                            Toast.makeText(VerificationActivity.this, "Verification Successfully", Toast.LENGTH_SHORT).show();
                            SharedPreferences sharedPreferences = getSharedPreferences("otp", MODE_PRIVATE);
                            sharedPreferences.edit().putBoolean("otp", true).apply();
                            Intent intent = new Intent(VerificationActivity.this, LoginActivity.class);
                            startActivity(intent);
                            finish();
                        } else if (response.code() == 401) {
                            Toast.makeText(VerificationActivity.this, "You entered wrong OTP", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(VerificationActivity.this, "Error", Toast.LENGTH_SHORT).show();
                        }
                    }
                    @Override
                    public void onFailure(Call<Otpverify> call, Throwable t) {
                        Toast.makeText(VerificationActivity.this, "Fail", Toast.LENGTH_SHORT).show();
                    }

                });
            }
        });


//        resend.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ApiService apiService = ApiUtil.getApiService();
//                Call<ResendApi> resendApiCall = apiService.resendOtp(email);
//                resendApiCall.enqueue(new Callback<ResendApi>() {
//                    @Override
//                    public void onResponse(Call<ResendApi> call, Response<ResendApi> response) {
//                        if (response.isSuccessful()) {
//                            ResendApi resendOtp = response.body();
//                            if (resendOtp != null) {
//                                Boolean status = resendOtp.isStatus();
//                                if (status != null) {
//                                    if (status) {
//                                        // Status is true
//                                        Toast.makeText(VerificationActivity.this, "OTP has been resent", Toast.LENGTH_SHORT).show();
//                                    } else {
//                                        // Status is false
//                                        Toast.makeText(VerificationActivity.this, "Please try after 6 minute", Toast.LENGTH_SHORT).show();
//                                    }
//                                } else {
//                                    // Handle the case where the 'status' field is null
//                                    Toast.makeText(VerificationActivity.this, "Invalid response from server", Toast.LENGTH_SHORT).show();
//                                }
//                            } else {
//                                // Handle the case where the response body is null
//                                Toast.makeText(VerificationActivity.this, "Error resending otp", Toast.LENGTH_SHORT).show();
//                            }
//                        } else {
//                            // Handle the case where the HTTP response code is not 200
//                            if (response.code() == 401) {
//                                // Unauthorized (e.g., invalid credentials)
//                                Toast.makeText(VerificationActivity.this, "Please try after 1 minute", Toast.LENGTH_SHORT).show();
//                            } else {
//                                // Handle other HTTP response codes if needed
//                                Toast.makeText(VerificationActivity.this, "Error", Toast.LENGTH_SHORT).show();
//                            }
//                        }
//
//                    }
//
//                    @Override
//                    public void onFailure(Call<ResendApi> call, Throwable t) {
//                        Toast.makeText(VerificationActivity.this, "Failed to send OTP: " + t.getMessage(), Toast.LENGTH_SHORT).show();
//                    }
//                }
//            }
//        }

        resend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ApiService apiService = ApiUtil.getApiService();
                SharedPreferences sh = getSharedPreferences("MySharedPref",MODE_PRIVATE);
                String email = sh.getString("username", "");
//                Bundle extras = getIntent().getExtras();
//                String email = extras.getString("user_email");

                Call<ResendApi> ApiResponseCall = apiService.resendOtp(email);
                ApiResponseCall.enqueue(new Callback<ResendApi>() {
                    @Override
                    public void onResponse(Call<ResendApi> call, Response<ResendApi> response) {
                        if (response.code() == 200) {
                            Toast.makeText(VerificationActivity.this, "Otp has been sent Again.", Toast.LENGTH_SHORT).show();
                        } else if (response.code()==401){
                            Toast.makeText(VerificationActivity.this, "Error!! Please try after about 5 minutes.", Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(VerificationActivity.this, "Error on Server!!", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResendApi> call, Throwable t) {
                        Toast.makeText(VerificationActivity.this, "Failed to resend!!", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }



}






