package com.example.yatra.activity;

import static android.view.View.GONE;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.Toast;

import com.example.yatra.JSONSchemas.Contact;

import com.example.yatra.JSONSchemas.Otpverify;
import com.example.yatra.JSONSchemas.UserLogin;
import com.example.yatra.ProfileFragment;
import com.example.yatra.R;
import com.example.yatra.retrofit.ApiService;
import com.example.yatra.retrofit.ApiUtil;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ContactActivity extends AppCompatActivity {
    ImageView movecontact;
    ScrollView contactus;
    Button Contactsubmit;
    EditText ContactFullname, contactemail, contactmessage, Contactphone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        movecontact = findViewById(R.id.movecontact);
        contactus = findViewById(R.id.contactus);
        Contactsubmit = findViewById(R.id.Contactsubmit);
        ContactFullname = findViewById(R.id.ContactFullname);
        contactemail = findViewById(R.id.contactemail);
        contactmessage = findViewById(R.id.contactmessage);
        Contactphone = findViewById(R.id.Contactphone);


        movecontact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //arrow activity to fragment

                // Fragment fragment=new ProfileFragment();
                // FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
                //  fragmentTransaction.replace(R.id.aboutYatra,fragment).commit();
                //     hideAbout.setVisibility(View.GONE);
                ProfileFragment fragment = new ProfileFragment();
                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.replace(R.id.contact, fragment);
                transaction.addToBackStack(null);
                contactus.setVisibility(GONE);
                transaction.commit();
            }


        });
        //api call
        Contactsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ApiService apiService = ApiUtil.getApiService();
                Call<Contact> responseBodyCall = apiService.contact(ContactFullname.getText().toString(), Contactphone.getText().toString(), contactemail.getText().toString(), contactmessage.getText().toString());
                responseBodyCall.enqueue(new Callback<Contact>() {
                    @Override
                    public void onResponse(Call<Contact> call, Response<Contact> response) {

                        if (response.code() == 200) {
                            Toast.makeText(ContactActivity.this, "Review insert Successfully", Toast.LENGTH_SHORT).show();

                            Contact responseBody = response.body();
                          //  SharedPreferences sharedPreferences = getSharedPreferences("USER", MODE_PRIVATE);

                           // sharedPreferences.edit().putString("TOKENLOGIN", tokenRegister).apply();
                           // sharedPreferences.edit().putBoolean("LOGIN", true).apply();

                            ContactFullname.setText("");
                            Contactphone.setText("");
                            contactemail.setText("");
                            contactmessage.setText("");
                        } else if (response.code() == 401) {

                            Toast.makeText(ContactActivity.this, "Error on Server", Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onFailure(Call<Contact> call, Throwable t) {
                        Toast.makeText(ContactActivity.this, "Fail", Toast.LENGTH_SHORT).show();
                    }

                });
            }


        });
    }
}
