package com.example.sammyzeng.diversitycalendarview;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sammy.zeng on 2018/11/15.
 */

public class CalendarMonthPagerAdapter extends PagerAdapter {
    private Context context ;
    private List<CalendarMonthData> dataList;
    private List<CalendarMonthViewGroup> monthViewGroupsList;

    public CalendarMonthPagerAdapter(Context context , List<CalendarMonthData> dataList){
        this.context = context;
        this.dataList = dataList;
        monthViewGroupsList = new ArrayList<>();
        setMonthViewGroupsList();
    }

    public void setData(List<CalendarMonthData> dataList){
        this.dataList = dataList;
        setMonthViewGroupsList();
    }

    @Override
    public int getCount() {
        return dataList != null ? dataList.size() : 0;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        CalendarMonthViewGroup calendarMonthViewGroup = monthViewGroupsList.get(position);
        container.addView(calendarMonthViewGroup);
        return calendarMonthViewGroup;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((CalendarMonthViewGroup)object);
    }

    private void setMonthViewGroupsList(){
        if(dataList == null || dataList.size() == 0) return;

        for(CalendarMonthData calendarMonthData : dataList){
            CalendarMonthViewGroup calendarMonthViewGroup = new CalendarMonthViewGroup(context);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams( ViewGroup.LayoutParams.MATCH_PARENT,  ViewGroup.LayoutParams.MATCH_PARENT);
            calendarMonthViewGroup.setLayoutParams(layoutParams);
            if(calendarMonthData != null){
                calendarMonthViewGroup.setData(calendarMonthData.getWeekInMonthCount(), calendarMonthData.getDayOfWeek(), calendarMonthData.getDayOfMonth());
            }
            monthViewGroupsList.add(calendarMonthViewGroup);
        }
    }
}
