package com.example.sammyzeng.diversitycalendarview;

/**
 * Created by sammy.zeng on 2018/11/15.
 */

public class CalendarMonthData {
    private int dayOfMonth ;
    private int dayOfWeek;
    private int weekInMonthCount;

    public CalendarMonthData() {
    }

    public CalendarMonthData(int dayOfMonth, int dayOfWeek, int weekInMonthCount) {
        this.dayOfMonth = dayOfMonth;
        this.dayOfWeek = dayOfWeek;
        this.weekInMonthCount = weekInMonthCount;
    }

    public int getDayOfMonth() {
        return dayOfMonth;
    }

    public void setDayOfMonth(int dayOfMonth) {
        this.dayOfMonth = dayOfMonth;
    }

    public int getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(int dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public int getWeekInMonthCount() {
        return weekInMonthCount;
    }

    public void setWeekInMonthCount(int weekInMonthCount) {
        this.weekInMonthCount = weekInMonthCount;
    }
}
