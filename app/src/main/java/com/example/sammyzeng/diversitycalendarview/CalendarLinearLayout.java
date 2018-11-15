package com.example.sammyzeng.diversitycalendarview;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.List;

/**
 * Created by sammy.zeng on 2018/11/15.
 */

public class CalendarLinearLayout extends LinearLayout {
    private Context context;
    private List<CalendarMonthData> calendarMonthDataList;
    private CalendarTitleView calendarTitleView;
    private CalendarWeekTitleView calendarWeekTitleView;
    private CalendarMonthViewPager viewPager;

    public CalendarLinearLayout(Context context, List<CalendarMonthData> calendarMonthDataList) {
        super(context);
        this.context = context;
        this.calendarMonthDataList = calendarMonthDataList;
        init();
    }

    private void init(){
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        setLayoutParams(layoutParams);
        setOrientation(LinearLayout.VERTICAL);
        addChildView();

    }

    private void addChildView(){
        calendarTitleView = new CalendarTitleView(context, this, new ICalendarTitleButtonListener() {
            @Override
            public void onBackClick() {

            }

            @Override
            public void onNextClick() {

            }
        });

        addView(calendarTitleView.getTitleView());

        calendarWeekTitleView = new CalendarWeekTitleView(context, this);
        addView(calendarWeekTitleView.getView());
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        viewPager = new CalendarMonthViewPager(context, calendarMonthDataList);
        viewPager.setLayoutParams(layoutParams);
        addView(viewPager);
    }

}
