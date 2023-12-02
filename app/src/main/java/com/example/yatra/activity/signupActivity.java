package com.example.yatra.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yatra.JSONSchemas.UserRegister;
import com.example.yatra.R;
import com.example.yatra.retrofit.ApiService;
import com.example.yatra.retrofit.ApiUtil;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class signupActivity extends AppCompatActivity {
    TextView tvLogin;
    Button signup;
    EditText confirmPassword, password, phoneNo, address, email, username;
    RadioButton male, female;
    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        signup = findViewById(R.id.signup);
        username = findViewById(R.id.username);
        email = findViewById(R.id.email);
        address = findViewById(R.id.address);
        phoneNo = findViewById(R.id.phoneNo);
        password = findViewById(R.id.password);
        confirmPassword = findViewById(R.id.confirmPassword);
        tvLogin = findViewById(R.id.tvLogin);

        //show hide password icon using eye icon
        ImageView eyeIcon=findViewById(R.id.eyeIcon1);
        eyeIcon.setImageResource(R.drawable.hide_1);
        eyeIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (password.getTransformationMethod().equals(HideReturnsTransformationMethod.getInstance())) {

                    password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    //change icon
                    eyeIcon.setImageResource(R.drawable.hide_1);
                } else {
                    password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    //change icon
                    eyeIcon.setImageResource(R.drawable.view_1);
                }
            }
        });
        //show hide password icon using eye icon
        ImageView eyeIcon1=findViewById(R.id.eyeIcon2);
        eyeIcon1.setImageResource(R.drawable.hide_1);
        eyeIcon1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (confirmPassword.getTransformationMethod().equals(HideReturnsTransformationMethod.getInstance())) {

                    confirmPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    //change icon
                    eyeIcon1.setImageResource(R.drawable.hide_1);
                } else {
                    confirmPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    //change icon
                    eyeIcon1.setImageResource(R.drawable.view_1);
                }
            }
        });




        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!validateFullname() | !validateAddress() | !validatePhoneNumber()  |
                        !validatePassword() | !validateEmail() | !validatePasswordCheck()) {
                    return;
                } else {
                    userRegister();
                }
            }
        });

        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(signupActivity.this,LoginActivity.class));
            }
        });
    }

    private Boolean validateFullname() {
        String val = username.getText().toString();

        if (val.isEmpty()) {
            username.setError("Full name cannot be empty");
            return false;
        } else {
            username.setError(null);
            return true;
        }
    }

    private Boolean validateAddress() {
        String val = address.getText().toString();

        if (val.isEmpty()) {
            address.setError("Address field cannot be empty");
            return false;
        } else {
            address.setError(null);
            return true;
        }
    }


    private Boolean validateEmail() {
        String val = email.getText().toString();
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if (val.isEmpty()) {
            email.setError("Email field cannot be empty");
            return false;
        } else if (!val.matches(emailPattern)) {
            email.setError("Invalid email address");
            return false;
        } else {
            email.setError(null);
            //Email.setErrorEnabled(false);
            return true;
        }
    }

    private Boolean validatePassword() {
        String val = password.getText().toString();
        String passwordVal = "^" +
                //"(?=.*[0-9])" +         //at least 1 digit
                //"(?=.*[a-z])" +         //at least 1 lower case letter
                //"(?=.*[A-Z])" +         //at least 1 upper case letter
                "(?=.*[a-zA-Z])" +      //any letter
                "(?=.*[@#$%^&+=])" +    //at least 1 special character
                "(?=\\S+$)" +           //no white spaces
                ".{4,}" +               //at least 4 characters
                "$";

        if (val.isEmpty()) {
            password.setError("Password field cannot be empty");
            return false;
        } else if (!val.matches(passwordVal)) {
            password.setError("Password is too weak");
            return false;
        } else {
            password.setError(null);
            // Password.setErrorEnabled(false);
            return true;
        }
    }

    private Boolean validatePasswordCheck() {
        String val = confirmPassword.getText().toString();
        String val1 = password.getText().toString();

        if (!val.equals(val1)) {
            confirmPassword.setError("password didnot matched!!please re-type password");
            return false;
        } else {
            confirmPassword.setError(null);
            return true;
        }
    }

    private Boolean validatePhoneNumber() {
        String val = phoneNo.getText().toString();
        String phoneVal = //"^" +
                //"(?=.*[0-9])" +         //at least 1 digit
                //"(?=.*[a-z])" +         //at least 1 lower case letter
                //"(?=.*[A-Z])" +         //at least 1 upper case letter
                //  "(?=.*[a-zA-Z])" +      //any letter
                //  "(?=.*[@#$%^&+=])" +    //at least 1 special character
                //  "(?=\\S+$)" +           //no white spaces
                //   ".{4,}" +               //at least 4 characters
                //   "$";
                //"^" + "(?=.*[0-9]{10,13})" + "$";
                "^[0-9\\s-]*$";

        if (val.isEmpty()) {
            phoneNo.setError("Please fill mobile number");
            return false;
        } else if (!val.matches(phoneVal)) {
            phoneNo.setError("Incorrect format");
            return false;
        } else {
            phoneNo.setError(null);
            // Password.setErrorEnabled(false);
            return true;
        }
    }

    //private Boolean validateGender() {
       // String val = male.getText().toString();
      //  String val1 = female.getText().toString();

      // if (!male.isChecked() && !female.isChecked()) {
        //    male.setError("Please select a gender");
       //     return false;
        //} else {
         //   female.setError(null);
        //    return true;
     //   }
   // }

    private void userRegister() {
      //  RadioGroup radioGroupGender = findViewById(R.id.radioGroup);
      //  int selectedId = radioGroupGender.getCheckedRadioButtonId();
      //  RadioButton selectedRadioButton = findViewById(selectedId);
     //   String gender;
      //  if (selectedRadioButton.getId() == R.id.Male) {
    //        gender = "male";
     //   } else {
      //      gender = "female";
    //    }


        ApiService apiService = ApiUtil.getApiService();
        Call<UserRegister> responseBodyCall = apiService.userRegister(username.getText().toString(), email.getText().toString(), password.getText().toString(), confirmPassword.getText().toString(), address.getText().toString(), phoneNo.getText().toString());
                responseBodyCall.enqueue(new Callback<UserRegister>() {

            @Override
            public void onResponse(Call<UserRegister> call, Response<UserRegister> response) {
                if (response.code() == 200) {
                    Toast.makeText(signupActivity.this, "User Created Successfully", Toast.LENGTH_SHORT).show();
                    UserRegister responseBody = response.body();
                    String tokenRegister = responseBody.getAccessToken();
                    SharedPreferences sharedPreferences = getSharedPreferences("USEREGESTER", MODE_PRIVATE);
                    sharedPreferences.edit().putString("TOKENREGISTER", tokenRegister).apply();
                    sharedPreferences.edit().putBoolean("USEREGESTER", true).apply();
                        Intent intent = new Intent(signupActivity.this, VerificationActivity.class);
                    intent.putExtra("email", email.getText().toString().trim());
                        startActivity(intent);
                        finish();

                } else if (response.code() == 401) {

                    Toast.makeText(signupActivity.this, "Error on Server", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<UserRegister> call, Throwable t) {
                Toast.makeText(signupActivity.this, "Fail", Toast.LENGTH_SHORT).show();
            }

        });


    }

}