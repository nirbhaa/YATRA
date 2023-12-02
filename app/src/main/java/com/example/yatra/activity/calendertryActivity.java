package com.example.yatra.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import com.example.yatra.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class calendertryActivity extends AppCompatActivity {
    private TextView rentDateText, returnDateText, autoDaysText;
    private Button rentDatePickerBtn, returnDatePickerBtn;

    private Calendar rentCalendar, returnCalendar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendertry);

        rentDateText = findViewById(R.id.rentDateText);
        returnDateText = findViewById(R.id.returnDateText);
        autoDaysText = findViewById(R.id.autoDaysText);
        rentDatePickerBtn = findViewById(R.id.rentDatePickerBtn);
        returnDatePickerBtn = findViewById(R.id.returnDatePickerBtn);

        rentCalendar = Calendar.getInstance();
        returnCalendar = Calendar.getInstance();

        rentDatePickerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePickerDialog(rentCalendar, rentDateText);
            }
        });

        returnDatePickerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog(returnCalendar, returnDateText);
            }
        });
    }

    private void showDatePickerDialog(final Calendar calendar, final TextView dateText) {
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, monthOfYear);
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
                dateText.setText(sdf.format(calendar.getTime()));

                calculateAutoDays();
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
        } else {
            autoDaysText.setText("");
        }
    }
}