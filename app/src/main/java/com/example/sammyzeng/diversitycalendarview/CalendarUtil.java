package com.example.sammyzeng.diversitycalendarview;


import java.util.Calendar;

/**
 * Created by sammy.zeng on 2018/11/6.
 */

public class CalendarUtil {
    private static long currentTimecurrentTimeMillis =  System.currentTimeMillis();

    public static int getYear(){
        return Calendar.getInstance().get(Calendar.YEAR);
    }

    public static int getMonth(){
        return Calendar.getInstance().get(Calendar.MONTH) + 1;
    }

    public static int getDayOfMonth(){
        return Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
    }

    public static int getDayOfWeek(){
        return Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
    }

    public static int getDayOfWeekInMonth(){
        return Calendar.getInstance().get(Calendar.DAY_OF_WEEK_IN_MONTH);
    }

    public static int getDayOfMonth(int year,int month){
        int day = 0;
        if(year%4==0&&year%100!=0||year%400==0){
            day = 29;
        }else{
            day = 28;
        }
        switch (month){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                return day;
        }
        return 0;
    }

    public static int getWeekInMonthCount(int monthOfDay, int dayOfWeek){
        int aheadCount = dayOfWeek - 1 ;
        int weekInMonthCount = (monthOfDay + aheadCount) / 7 ;
        if((monthOfDay + aheadCount) % 7 > 0){
            weekInMonthCount ++ ;
        }
        return weekInMonthCount;
    }
}
