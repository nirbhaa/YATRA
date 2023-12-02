package com.example.yatra;



import static android.content.Context.MODE_PRIVATE;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import android.os.LocaleList;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yatra.activity.AboutUsActivity;
import com.example.yatra.activity.ChangePasswordActivity;
import com.example.yatra.activity.ContactActivity;
import com.example.yatra.activity.EditProfile;
import com.example.yatra.activity.LoginActivity;
import com.example.yatra.activity.MyBookingDetailsActivity;

import java.util.zip.Inflater;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    AppCompatButton changepassword;
    AppCompatButton aboutus;
    AppCompatButton contactus,myBooking;
    Button logout;
    TextView eMail, Name;
    AlertDialog.Builder builder;
    private Context mContext;
    private Inflater inflater;


    View view;
    public ProfileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProfileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =inflater.inflate(R.layout.fragment_profile, container, false);
        init(view);

        return view;
    }

    private void init(View view) {
//      changepassword=view.findViewById(R.id.changePwd);
       aboutus=view.findViewById(R.id.aboutus);
        contactus=view.findViewById(R.id.contactus);
        logout=view.findViewById(R.id.logout);
        myBooking=view.findViewById(R.id.myBooking);
//for setting user email id and user name
        eMail = view.findViewById(R.id.manGmail);
        Name = view.findViewById(R.id.manName);
        SharedPreferences sh = getActivity().getSharedPreferences("MySharedPref",MODE_PRIVATE);
        String s1 = sh.getString("username", "");
        String user_name = sh.getString("name", "");
       // Log.v("sdcds",s1);
        eMail.setText(s1);
        Name.setText(user_name);


//        changepassword.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(mContext, EditProfile.class));
//            }
//        });

        aboutus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(mContext, AboutUsActivity.class));
            }
        });
        contactus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(mContext, ContactActivity.class));
            }
        });
        myBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(mContext, MyBookingDetailsActivity.class));
            }
        });

//        logout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(mContext, LoginActivity.class));
//            }
//        });


        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                SharedPreferences sharedPreferences = mContext.getSharedPreferences("MySharedPref", MODE_PRIVATE);
                SharedPreferences.Editor sh = sharedPreferences.edit();
                sh.clear();
                sh.apply();

                Intent i=new Intent(mContext, LoginActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);


            }
        });







    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    }