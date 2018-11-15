package com.example.sammyzeng.diversitycalendarview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by sammy.zeng on 2018/11/6.
 */

public class CalendarTitleView implements View.OnClickListener {

    private TextView calendar_back_control_ib;
    private TextView calendar_year_text_tv;
    private TextView calendar_month_text_tv;
    private TextView calendar_next_control_ib;
    private View titleView;
    private Context context;
    private ViewGroup viewGroup;
    private ICalendarTitleButtonListener iCalendarTitleButtonListener;

    public CalendarTitleView(Context context, ViewGroup viewGroup, ICalendarTitleButtonListener iCalendarTitleButtonListener) {
        this.context = context;
        this.viewGroup = viewGroup;
        this.iCalendarTitleButtonListener = iCalendarTitleButtonListener;
        init();
    }

    private void init(){
        titleView = LayoutInflater.from(context).inflate(R.layout.calendar_title_layout, viewGroup, false);
        calendar_back_control_ib = titleView.findViewById(R.id.calendar_back_control_ib);
        calendar_year_text_tv = titleView.findViewById(R.id.calendar_year_text_tv);
        calendar_month_text_tv = titleView.findViewById(R.id.calendar_month_text_tv);
        calendar_next_control_ib = titleView.findViewById(R.id.calendar_next_control_ib);
    }

    private void setData(){

    }

    @Override
    public void onClick(View v) {
        int viewId = v.getId();
        switch (viewId){
            case R.id.calendar_back_control_ib:
                if(iCalendarTitleButtonListener != null){
                    iCalendarTitleButtonListener.onBackClick();
                }
                break;

            case R.id.calendar_next_control_ib:
                if(iCalendarTitleButtonListener != null){
                    iCalendarTitleButtonListener.onNextClick();
                }
                break;

        }
    }

    public View getTitleView(){
        return titleView;
    }


}
