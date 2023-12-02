package com.example.yatra.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yatra.JSONSchemas.UserDetails.UserLoginDetails;
import com.example.yatra.JSONSchemas.UserLogin;
import com.example.yatra.JSONSchemas.UserRegister;
import com.example.yatra.R;
import com.example.yatra.retrofit.ApiService;
import com.example.yatra.retrofit.ApiUtil;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    TextView tvForgotPassword;
    Button login;
    EditText email, Password;
    TextView tvLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        tvForgotPassword = findViewById(R.id.tvForgotPassword);
        login = findViewById(R.id.login);
        email = findViewById(R.id.Email);
        Password = findViewById(R.id.Password);
        tvLogin = findViewById(R.id.tvLogin);





        //show hide password icon using eye icon
        ImageView eyeIcon=findViewById(R.id.eyeIcon);
        eyeIcon.setImageResource(R.drawable.hide_1);
        eyeIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Password.getTransformationMethod().equals(HideReturnsTransformationMethod.getInstance())) {

                    Password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    //change icon
                    eyeIcon.setImageResource(R.drawable.hide_1);
                } else {
                    Password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    //change icon
                    eyeIcon.setImageResource(R.drawable.view_1);
                }
            }
        });


        tvForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, forgotPasswordActivity.class));
            }
        });


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ApiService apiService = ApiUtil.getApiService();
                Call<UserLoginDetails> responseBodyCall = apiService.userLogin(email.getText().toString(), Password.getText().toString());
                responseBodyCall.enqueue(new Callback<UserLoginDetails>() {
                    @Override
                    public void onResponse(Call<UserLoginDetails> call, Response<UserLoginDetails> response) {
                        if (response.code() == 200) {
                            Toast.makeText(LoginActivity.this, "Login Successfully", Toast.LENGTH_SHORT).show();

                            UserLoginDetails responseBody = response.body();
                            String token = responseBody.getAccessToken();
                            SharedPreferences sharedPreferences = getSharedPreferences("USER", MODE_PRIVATE);
                            sharedPreferences.edit().putString("TOKENLOGIN", token).apply();
                            sharedPreferences.edit().putBoolean("USER", true).apply();

                        // for putting email id of user
                            SharedPreferences sharedPreferences1 = getSharedPreferences("MySharedPref", MODE_PRIVATE);
                            SharedPreferences.Editor sh = sharedPreferences1.edit();
                            sh.putString("username", email.getText().toString());
                            sh.putString("userid", responseBody.getUser().getId().toString());
                            sh.putString("name", responseBody.getUser().getFullname().toString());
                            sh.putString("phone", responseBody.getUser().getPhoneNumber().toString());
                            sh.putString("address", responseBody.getUser().getAddress().toString());
                            sh.putString("email", responseBody.getUser().getEmail().toString());
                            sh.putBoolean("isLoggedIn", true);
                            sh.apply();


                            Intent intent = new Intent(LoginActivity.this, HomeMainActivity.class);
                          //  intent.putExtra("login",get(postion).getBikeCompany());

                            startActivity(intent);
                            finish();

                        } else if (response.code() == 401) {

                            Toast.makeText(LoginActivity.this, "Invalid Email or Password", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(LoginActivity.this, "Error on Server", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<UserLoginDetails> call, Throwable t) {
                        Toast.makeText(LoginActivity.this, "Fail", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, signupActivity.class));
                //   String username = email.getText().toString();
                //String password = Password.getText().toString();

                //  boolean check = validateinfo(username, password);

                // if (check == true) {
                //     Intent i = new Intent(LoginActivity.this, HomeActivity.class);
                //    startActivity(i);
            }

            //Intent i = new Intent(SigninActivity.this, UserDashboardActivity.class);
            //startActivity(i);

        });
    }
}
   // private Boolean validateinfo (String username, String password) {
     //   if (email.length() == 0) {
      //     email.requestFocus();
     //       email.setError("Field cannot be empty");
     //       return false;
      //  } else if (!username.matches("[a-zA-Z]+")) {
        //    email.requestFocus();
         //   email.setError("Enter only alphabetical character");
        //    return false;
      //  } else if (password.length() <= 5) {
        //    Password.requestFocus();
           // Password.setError("Minimum 6 characters long");
        //    return false;
       // } else {
       //     return true;
      //  }

 //   }
//}