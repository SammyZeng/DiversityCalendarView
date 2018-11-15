package com.example.sammyzeng.diversitycalendarview;

import android.content.Context;
import android.icu.util.Measure;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

/**
 * Created by sammy.zeng on 2018/11/9.
 */

public class CalendarMonthViewGroup extends ViewGroup {
    private Context context;
    private int windowWidth;
    private int windowHeight;
    private int needShowLine;
    private int needInteralCount;
    private static int widthShowItemViewCount = 7;

    public CalendarMonthViewGroup(Context context) {
        this(context, null);
    }

    public CalendarMonthViewGroup(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CalendarMonthViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        getWindowMetrics();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int measureWidth = setMeasureSpec(widthMeasureSpec, windowWidth/2, true);
        int measureHeight = setMeasureSpec(heightMeasureSpec, windowHeight/4, false);
        int measureWidthMode = MeasureSpec.getMode(widthMeasureSpec);
        int measureHeightMode = MeasureSpec.getMode(heightMeasureSpec);
        int childWidthMeasureSpec = setChildMeasureSpec(measureWidth, measureWidthMode, true);
        int childHeightMeasureSpec = setChildMeasureSpec(measureHeight, measureHeightMode, false);
        measureChildren(childWidthMeasureSpec, childHeightMeasureSpec);
        setMeasuredDimension(measureWidth, measureHeight);
        Log.i("test", "onMeasure" + " " + "measureWidth:" + measureWidth + " " + "measureHeight:" + measureHeight);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        Log.i("test", "onSizeChanged: " + "w" + w  + " " + "h" + h + "oldw" + oldw  + " " + "oldh" + oldh);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int nowL = 0 ;
        int nowT = 0 ;
        int nowR = 0 ;
        //设置留空的位置
        if(getChildCount()>0 && getChildAt(0) != null){
            int itemViewMeasureWidth = getChildAt(0).getMeasuredWidth();
            nowL = itemViewMeasureWidth * needInteralCount;
        }
        for(int i = 0 ; i < getChildCount() ; i++){
            View itemView = getChildAt(i);
            int itemViewMeasureWidth =  itemView.getMeasuredWidth();
            int itemViewMeasureHeight = itemView.getMeasuredHeight();
            nowR = itemViewMeasureWidth  + nowL;
            if(nowR > getMeasuredWidth()){
                nowL = 0;
                nowR = itemViewMeasureWidth;
                nowT = itemViewMeasureHeight + nowT;
            }
            itemView.layout(nowL, nowT , nowL + itemViewMeasureWidth , nowT + itemViewMeasureHeight);
            nowL = nowR ;
        }
        Log.i("test", "onMeasure" + " " + "changed: " + changed + " " + "l: " + l + " " + "t: " + t + " " + "r: " + r + " " + "b: " + b);
    }

    //添加一定个数的CalendarDayView
    public void setData(int needShowLine , int needInteralCount , int dayCount){
        this.needShowLine = needShowLine;
        this.needInteralCount = needInteralCount;
        for(int i = 0 ; i<dayCount ; i++){
            addCalendarDayView();
        }
    }

    //获取屏幕大小
    private void getWindowMetrics(){
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        windowWidth = displayMetrics.widthPixels;
        windowHeight = displayMetrics.heightPixels;
    }

    //设置当前容器的最小高宽
    private int setMeasureSpec(int measureSpec, int minSize, boolean isWidth){
        int realSize = 0;
        int size = MeasureSpec.getSize(measureSpec);
        int model = MeasureSpec.getMode(measureSpec);
        if(model == MeasureSpec.AT_MOST){
            if(isWidth && getChildCount() > 0 && getChildAt(0) != null){
                realSize = getChildAt(0).getWidth() * widthShowItemViewCount;
            }else if(!isWidth && getChildCount() > 0 && getChildAt(0) != null){
                realSize = getChildAt(0).getHeight() * needShowLine;
            }
        }else {
            realSize = size;
        }

        return Math.max(realSize, minSize);
    }

    //设定子控件的MeasureSpec
    private int setChildMeasureSpec(int measureSize, int measureMode, boolean isWidth){
        if(isWidth){
            int childWidth = measureSize / widthShowItemViewCount ;
            return MeasureSpec.makeMeasureSpec(childWidth, measureMode);
        }else {
            int childHeight = measureSize / needShowLine;
            return MeasureSpec.makeMeasureSpec(childHeight, measureMode);
        }
    }

    //添加CalendarDayView
    private void addCalendarDayView(){
        CalendarDayView calendarDayView = new CalendarDayView(context);
        LayoutParams layoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        calendarDayView.setLayoutParams(layoutParams);
        addView(calendarDayView);
    }
}
