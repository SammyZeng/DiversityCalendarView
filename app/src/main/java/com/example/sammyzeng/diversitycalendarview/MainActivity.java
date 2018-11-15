package com.example.sammyzeng.diversitycalendarview;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FrameLayout frameLayout = findViewById(R.id.frame_layout);
        ArrayList<CalendarMonthData> listData = new ArrayList<>();
        int year = CalendarUtil.getYear();
        int month = CalendarUtil.getMonth();
        for(int i = 0 ; i < 10; i++){
            int dayOfMonth = CalendarUtil.getDayOfMonth(year, month);
            int dayOfWeek = CalendarUtil.getDayOfWeek();
            int weekInMonthCount = CalendarUtil.getWeekInMonthCount(dayOfMonth, dayOfWeek);
            CalendarMonthData calendarMonthData = new CalendarMonthData(dayOfMonth, dayOfWeek, weekInMonthCount);
            listData.add(calendarMonthData);
        }
        CalendarLinearLayout calendarLinearLayout = new CalendarLinearLayout(this, listData);
        frameLayout.addView(calendarLinearLayout);
    }


}
