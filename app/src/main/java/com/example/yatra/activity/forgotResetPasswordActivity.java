package com.example.yatra.activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.yatra.JSONSchemas.ForgetEmail;
import com.example.yatra.JSONSchemas.Resetpassword;
import com.example.yatra.R;
import com.example.yatra.retrofit.ApiService;
import com.example.yatra.retrofit.ApiUtil;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class forgotResetPasswordActivity extends AppCompatActivity {
EditText password,rePassword;
Button btnreset;
ImageView forgotset;
String email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_reset_password);

        password=findViewById(R.id.password);
        rePassword=findViewById(R.id.rePassword);
        btnreset=findViewById(R.id.btnreset);
        forgotset=findViewById(R.id.forgotset);
        email = getIntent().getStringExtra("email");

        btnreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ApiService apiService = ApiUtil.getApiService();
                Call<Resetpassword> reset = apiService.resetPassword(email,password.getText().toString(),rePassword.getText().toString());
                reset.enqueue(new Callback<Resetpassword>() {
                    @Override
                    public void onResponse(Call<Resetpassword> call, Response<Resetpassword> response) {
                        if (response.code() == 200) {
                        Toast.makeText(forgotResetPasswordActivity.this, "Password reset successfully", Toast.LENGTH_SHORT).show();

                        //save token
                        Intent i = new Intent(forgotResetPasswordActivity.this, LoginActivity.class);
                        startActivity(i);
                        finish();
                    }else if(response.code()==400)

                    {
                        Toast.makeText(forgotResetPasswordActivity.this, "Email not verified", Toast.LENGTH_SHORT).show();
                    } else

                    {
                        Toast.makeText(forgotResetPasswordActivity.this, "Error", Toast.LENGTH_SHORT).show();
                    }
                }

                    @Override
                    public void onFailure(Call<Resetpassword> call, Throwable t) {
                        Toast.makeText(forgotResetPasswordActivity.this, "Fail", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });



        }

    }


