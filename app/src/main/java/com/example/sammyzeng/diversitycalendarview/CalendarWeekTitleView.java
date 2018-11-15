package com.example.sammyzeng.diversitycalendarview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by sammy.zeng on 2018/11/6.
 */

public class CalendarWeekTitleView {
    private TextView oneTv;
    private TextView twoTv;
    private TextView threeTv;
    private TextView fourTv;
    private TextView fiveTv;
    private TextView sixTv;
    private TextView sevenTv;
    private View calendarWeekTitleView;
    private Context context;
    private ViewGroup viewGroup;

    public CalendarWeekTitleView(Context context, ViewGroup viewGroup) {
        this.context = context;
        this.viewGroup = viewGroup;
        initView();
    }

    private void initView(){
        calendarWeekTitleView = LayoutInflater.from(context).inflate(R.layout.carlendar_week_title_layout, viewGroup, false);
        oneTv = (TextView)calendarWeekTitleView.findViewById(R.id.week_title_one);
        twoTv = (TextView)calendarWeekTitleView.findViewById(R.id.week_title_two);
        threeTv = (TextView)calendarWeekTitleView.findViewById(R.id.week_title_three);
        fourTv = (TextView)calendarWeekTitleView.findViewById(R.id.week_title_four);
        fiveTv = (TextView)calendarWeekTitleView.findViewById(R.id.week_title_five);
        sixTv = (TextView)calendarWeekTitleView.findViewById(R.id.week_title_six);
        sevenTv = (TextView)calendarWeekTitleView.findViewById(R.id.week_title_seven);
    }

    public View getView(){
        return calendarWeekTitleView;
    }

    private void setData(){

    }
}
