package com.example.sammyzeng.diversitycalendarview;

import android.content.Context;
import android.support.v4.view.ViewPager;

import java.util.List;

/**
 * Created by sammy.zeng on 2018/11/15.
 */

public class CalendarMonthViewPager extends ViewPager {
    private Context context;
    private List<CalendarMonthData> calendarMonthDataList;
    private CalendarMonthPagerAdapter calendarMonthPagerAdapter;

    public List<CalendarMonthData> getCalendarMonthDataList() {
        return calendarMonthDataList;
    }

    public void setCalendarMonthDataList(List<CalendarMonthData> calendarMonthDataList) {
        this.calendarMonthDataList = calendarMonthDataList;
    }

    public CalendarMonthPagerAdapter getCalendarMonthPagerAdapter() {
        return calendarMonthPagerAdapter;
    }

    public CalendarMonthViewPager(Context context, List<CalendarMonthData> calendarMonthDataList) {
        super(context);
        this.context = context;
        this.calendarMonthDataList = calendarMonthDataList;
        init();
    }

    private void init(){
        calendarMonthPagerAdapter = new CalendarMonthPagerAdapter(context, calendarMonthDataList);
        setAdapter(calendarMonthPagerAdapter);
        setOffscreenPageLimit(3);
    }
}
