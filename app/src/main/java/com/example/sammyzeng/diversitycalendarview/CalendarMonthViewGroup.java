package com.example.sammyzeng.diversitycalendarview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
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
        setMeasuredDimension(measureWidth , measureHeight);

    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

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
                realSize = getChildAt(0).getMeasuredWidth() * 7;
            }else if(!isWidth && getChildCount() > 0 && getChildAt(0) != null){
                realSize = getChildAt(0).getMeasuredHeight() * needShowLine;
            }
        }else {
            realSize = size;
        }

        return Math.max(realSize, minSize);
    }

}
