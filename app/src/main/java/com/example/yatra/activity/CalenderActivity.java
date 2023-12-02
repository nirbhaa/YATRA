package com.example.yatra.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.example.yatra.R;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class CalenderActivity extends AppCompatActivity {
EditText returndate;
    EditText rentdate;
    EditText autoDaysText;
    EditText rentPrice;
    EditText total;
    private double pricePerDay = 0.0;
    private Calendar rentCalendar, returnCalendar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender);
        returndate =findViewById(R.id.returndate);
        rentdate =findViewById(R.id.rentdate);
        autoDaysText = findViewById(R.id.autoDaysText);
        rentPrice = findViewById(R.id.rentPrice);
        total = findViewById(R.id.total);

        rentCalendar = Calendar.getInstance();
        returnCalendar = Calendar.getInstance();

        rentdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePickerDialog(rentCalendar, rentdate);
            }
        });
        returndate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePickerDialog(returnCalendar, returndate);
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

    private void showDatePickerDialog(Calendar calendar, EditText date) {
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, month);
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
                date.setText(sdf.format(calendar.getTime()));
                calculateAutoDays();
               // calculateTotalAmount();
            }
        };
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, dateSetListener,
                calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis());
        datePickerDialog.show();
    }
    private void calculateAutoDays() {
        Date rentDate = rentCalendar.getTime();
        Date returnDate = returnCalendar.getTime();

        if (rentDate != null && returnDate != null && returnDate.after(rentDate)) {
            long differenceMillis = returnDate.getTime() - rentDate.getTime();
            long differenceDays = differenceMillis / (24 * 60 * 60 * 1000);

            autoDaysText.setText(String.valueOf(differenceDays));
            calculateTotalAmount();
        } else {
            autoDaysText.setText("");
        }
    }

    private void calculateTotalAmount() {
        String priceInput = rentPrice.getText().toString().trim();

        if (TextUtils.isEmpty(priceInput)) {
            Toast.makeText(this, "Please enter the price per day", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            pricePerDay  = Integer.parseInt(priceInput);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Invalid price format", Toast.LENGTH_SHORT).show();
            return;
        }

        if ( pricePerDay  <= 0) {
            Toast.makeText(this, "Invalid price", Toast.LENGTH_SHORT).show();
            return;
        }

        String autoDays = autoDaysText.getText().toString();

        if (!TextUtils.isEmpty(autoDays)) {
            int numberOfDays = Integer.parseInt(autoDays);
            double totalAmount = numberOfDays *  pricePerDay ;

            NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(Locale.getDefault());
            String formattedAmount = currencyFormat.format(totalAmount);

            total.setText(formattedAmount);
        } else {
            total.setText("");
        }
    }
}