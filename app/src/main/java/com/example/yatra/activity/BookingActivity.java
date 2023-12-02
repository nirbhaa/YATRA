package com.example.yatra.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yatra.JSONSchemas.BookingModel;
import com.example.yatra.JSONSchemas.UserDetails.UserLoginDetails;
import com.example.yatra.R;
import com.example.yatra.retrofit.ApiService;
import com.example.yatra.retrofit.ApiUtil;

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BookingActivity extends AppCompatActivity {
    EditText returndate;
    EditText rentdate;
    EditText autoDaysText;
    EditText rentPrice;
    EditText total;

    EditText Name,Email,PhoneNumber,Address,NameBike;
    ImageView bookingform,Calender1,Calender2;
    Button btnbook;
    //Integer user_id;
    private double pricePerDay = 0.0;
    private Calendar rentCalendar, returnCalendar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookingform);

        returndate =findViewById(R.id.ReturnDate);
        rentdate =findViewById(R.id.RentDate);
        autoDaysText = findViewById(R.id.autoDaysText);
        rentPrice = findViewById(R.id.priceperday);
        total = findViewById(R.id.totalamount);
        Name =findViewById(R.id.Name);
        Email =findViewById(R.id.Email);
        PhoneNumber =findViewById(R.id.PhoneNumber);
        Address =findViewById(R.id.Address);
        NameBike =findViewById(R.id.NameBike);
        bookingform=findViewById(R.id.bookingform);
        btnbook=findViewById(R.id.btnbook);
//        Calender1 =findViewById(R.id.calenderRent);
//        Calender2 =findViewById(R.id.calenderReturn);
//


//        TextView textViewStartDate = findViewById(R.id.RentDate);
//        TextView textViewEndDate = findViewById(R.id.ReturnDate);
//
//        String startDateText = textViewStartDate.getText().toString();
//        String endDateText = textViewEndDate.getText().toString();
//
//
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
//
//        try {
//            Date startDate = dateFormat.parse(startDateText.split(":")[1].trim());
//            Date endDate = dateFormat.parse(endDateText.split(":")[1].trim());
//
//            // Calculate the time difference between the two dates
//            long timeDifference = endDate.getTime() - startDate.getTime();
//
//            // Display or use the time difference as needed
//            // For example, convert it to days
//            long daysDifference = timeDifference / (24 * 60 * 60 * 1000);
//            // Do something with the daysDifference value
//            Log.v("totaldays", String.valueOf(daysDifference));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }


        //getting the bike id of selected bike for booking
        Intent intent = getIntent();
        String bike_id = intent.getStringExtra("bikeid");
        String bike_name = intent.getStringExtra("bikename");
        String price_per_day = intent.getStringExtra("price");
         //Log.v("abc",String.valueOf(str));
         //Log.v("bikename",str1);


        // for putting email id of user
       SharedPreferences sharedPreferences1 = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        SharedPreferences.Editor sh = sharedPreferences1.edit();

        String user_id = sharedPreferences1.getString("userid", "");
        String user_name = sharedPreferences1.getString("name", "");
        String user_phone = sharedPreferences1.getString("phone", "");
        String user_address = sharedPreferences1.getString("address", "");
        String user_email = sharedPreferences1.getString("email", "");


//        Log.v("user id",user_id);
//        Log.v("user name",user_name);
//        Log.v("user phone",user_phone);
//        Log.v("user address",user_address);

        //setting user details into booking details form
        Name.setText(user_name);
        Email.setText(user_email);
        PhoneNumber.setText(user_phone);
        Address.setText(user_address);
        NameBike.setText(bike_name);
        rentPrice.setText(price_per_day);


//        rentCalendar = Calendar.getInstance();
//        returnCalendar = Calendar.getInstance();
//
//       Calender1 .setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                showDatePickerDialog(rentCalendar, rentdate);
//            }
//        });
//        Calender2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                showDatePickerDialog(returnCalendar, returndate);
//            }
//
//
//        });

        bookingform.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(BookingActivity.this, BikedetailsActivity.class));
            }


        });

btnbook.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Log.v("bikeid",bike_id.toString());
        ApiService apiService = ApiUtil.getApiService();
        Call<BookingModel> responseBodyCall = apiService.getbookings(user_id, bike_id,rentdate.getText().toString(), returndate.getText().toString(),Double.parseDouble(total.getText().toString()),"progress",Integer.parseInt(autoDaysText.getText().toString()));
        responseBodyCall.enqueue(new Callback<BookingModel>() {
            @Override
            public void onResponse(Call<BookingModel> call, Response<BookingModel> response) {
                if (response.code() == 201) {
                    Toast.makeText(BookingActivity.this, "Booked Successfully", Toast.LENGTH_SHORT).show();
                    BookingModel responseBody = response.body();
                    Intent intent = new Intent(BookingActivity.this, HomeMainActivity.class);

                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(BookingActivity.this, "Error on Server", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<BookingModel> call, Throwable t) {

            }
        });
    }
});






        //  total.setOnClickListener(new View.OnClickListener() {
        //  @Override
        //   public void onClick(View v) {
        //      calculateTotalAmount();
        //   }
        //  });
        rentPrice.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    calculateTotalAmount();
                }
            }
        });



    }
//    private void showDatePickerDialog(Calendar calendar, EditText date) {
//        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
//            @Override
//            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
//                calendar.set(Calendar.YEAR, year);
//                calendar.set(Calendar.MONTH, month);
//                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
//
//                SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd", Locale.getDefault());
//                date.setText(sdf.format(calendar.getTime()));
//                calculateAutoDays();
//                // calculateTotalAmount();
//            }
//        };
//        DatePickerDialog datePickerDialog = new DatePickerDialog(this, dateSetListener,
//                calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
//                calendar.get(Calendar.DAY_OF_MONTH));
//        datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis());
//        datePickerDialog.show();
//    }
//    private void calculateAutoDays() {
//        Date rentDate = rentCalendar.getTime();
//        Date returnDate = returnCalendar.getTime();
//        rentdate=
//
//        if (rentDate != null && returnDate != null && returnDate.after(rentDate)) {
//            long differenceMillis = returnDate.getTime() - rentDate.getTime();
//            long differenceDays = differenceMillis / (24 * 60 * 60 * 1000);
//
//            autoDaysText.setText(String.valueOf(differenceDays));
//            calculateTotalAmount();
//        } else {
//            autoDaysText.setText("");
//        }
//    }

    private void calculateTotalAmount() {
//        String priceInput = rentPrice.getText().toString().trim();
//
//        if (TextUtils.isEmpty(priceInput)) {
//            Toast.makeText(this, "Please enter the price per day", Toast.LENGTH_SHORT).show();
//            return;
//        }
//
//        try {
//            pricePerDay  = Integer.parseInt(priceInput);
//        } catch (NumberFormatException e) {
//            Toast.makeText(this, "Invalid price format", Toast.LENGTH_SHORT).show();
//            return;
//        }
//
//        if ( pricePerDay  <= 0) {
//            Toast.makeText(this, "Invalid price", Toast.LENGTH_SHORT).show();
//            return;
//        }
//
//        String autoDays = autoDaysText.getText().toString();
//
//        if (!TextUtils.isEmpty(autoDays)) {
//            int numberOfDays = Integer.parseInt(autoDays);
//            double totalAmount = numberOfDays *  pricePerDay ;
//
//            NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(Locale.getDefault());
//            String formattedAmount = currencyFormat.format(totalAmount);
//
//            total.setText(formattedAmount);
//        } else {
//            total.setText("");
//        }
        try {
            int numberOfDays = Integer.parseInt(autoDaysText.getText().toString());
            double price = Double.parseDouble(rentPrice.getText().toString());

            double totalAmount = numberOfDays * price;
            total.setText("Rs" + totalAmount);

        }catch (NumberFormatException e) {
            // Handle invalid input or empty fields
            total.setText("");
        }



    }

    }
