package com.kaywalker.animation;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.RadioButton;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class BookingActivity extends AppCompatActivity {

    Button btn_end;
    RadioButton rbtnCalendar,rbtnTime;
    CalendarView calendarView;
    TimePicker timePicker;
    int selectYear,selectMonth,selectDay;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        btn_end = (Button)findViewById(R.id.btn_end);

        rbtnCalendar = (RadioButton)findViewById(R.id.rbtnCalendar);
        rbtnTime = (RadioButton)findViewById(R.id.rbtnTime);

        calendarView = (CalendarView)findViewById(R.id.calendarView);
        timePicker = (TimePicker)findViewById(R.id.timePiker);

        timePicker.setVisibility(View.INVISIBLE);
        calendarView.setVisibility(View.INVISIBLE);

        rbtnCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timePicker.setVisibility(View.INVISIBLE);
                calendarView.setVisibility(View.VISIBLE);

            }
        });

        rbtnTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timePicker.setVisibility(View.VISIBLE);
                calendarView.setVisibility(View.INVISIBLE);

            }
        });

        btn_end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makeMsg();
            }
        });

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int dayOfMonth) {
                selectYear = year;
                selectMonth = month + 1;
                selectDay = dayOfMonth;
            }
        });
    }

    private void makeMsg() {
        Toast toast =Toast.makeText(this,Integer.toString(selectYear) + "년" +
                Integer.toString(selectMonth) + "월" +
                Integer.toString(selectDay) + "일" +
                Integer.toString(timePicker.getCurrentHour()) + "시" +
                Integer.toString(timePicker.getCurrentMinute()) + "분 예약완료", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.TOP|Gravity.TOP, 0, 1200);
        toast.show();
    }
}
