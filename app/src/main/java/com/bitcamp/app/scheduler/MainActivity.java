package com.bitcamp.app.scheduler;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    String date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView today = findViewById(R.id.today);
        final CalendarView calendar = findViewById(R.id.calendar);
        final TimePicker clock = findViewById(R.id.clock);
        final TextView year = findViewById(R.id.year);
        final TextView month = findViewById(R.id.month);
        final TextView day = findViewById(R.id.day);
        final TextView hour = findViewById(R.id.hour);
        final TextView minute = findViewById(R.id.minute);
        today.setText(String.valueOf(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss")
                .format(new Date())));
        clock.setVisibility(View.INVISIBLE);

        findViewById(R.id.date_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clock.setVisibility(View.INVISIBLE);
                calendar.setVisibility(View.VISIBLE);
            }
        });
        findViewById(R.id.time_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clock.setVisibility(View.VISIBLE);
                calendar.setVisibility(View.INVISIBLE);
            }
        });
        findViewById(R.id.reservation_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] arr = date.split("-");
                year.setText(arr[0]);
                month.setText(arr[1]);
                day.setText(arr[2]);
                hour.setText(String.valueOf(clock.getHour()));
                minute.setText(String.valueOf(clock.getMinute()));

            }
        });
        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int day) {
                date = year +"-"+(month+1)+"-"+day;
            }
        });

    }
}
