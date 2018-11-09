package com.example.sammyzeng.diversitycalendarview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by sammy.zeng on 2018/11/9.
 */

public class CalendarDayView extends View {
    private Context context;
    private TypedArray typedArray;
    private CalendarDayProperty calendarDayProperty;
    private Paint paint;
    private int width;
    private int height;

    public CalendarDayView(Context context) {
        this(context, null);
    }

    public CalendarDayView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CalendarDayView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        typedArray = context.obtainStyledAttributes(attrs, R.styleable.CalendarDayView);
        init();
    }

    public CalendarDayProperty getCalendarDayProperty() {
        return calendarDayProperty;
    }

    public void setCalendarDayProperty(CalendarDayProperty calendarDayProperty) {
        this.calendarDayProperty = calendarDayProperty;
    }

    private void init(){
        //初始化属性设置
        calendarDayProperty = new CalendarDayProperty(context);
        String dayText = typedArray.getString(R.styleable.CalendarDayView_dayText);
        float textSize = typedArray.getDimension(R.styleable.CalendarDayView_textSize, ViewUtil.dip2px(context, 13));
        int textColor = typedArray.getColor(R.styleable.CalendarDayView_textColor, getResources().getColor(R.color.day_text_color));
        String specialText = typedArray.getString(R.styleable.CalendarDayView_specialText);
        float specialTextSize = typedArray.getDimension(R.styleable.CalendarDayView_specialTextSize, ViewUtil.dip2px(context, 13));
        int specialTextColor = typedArray.getColor(R.styleable.CalendarDayView_specialTextColor, getResources().getColor(R.color.day_text_color));
        float textScale = typedArray.getDimension(R.styleable.CalendarDayView_textScale, 1);
        int solidColor = typedArray.getColor(R.styleable.CalendarDayView_solidColor, getResources().getColor(R.color.calendar_background));
        int strokeColor = typedArray.getColor(R.styleable.CalendarDayView_strokeColor, getResources().getColor(R.color.calendar_background));
        float strokeWidth = typedArray.getDimension(R.styleable.CalendarDayView_strokeWidth, 0);
        calendarDayProperty.setDayText(dayText);
        calendarDayProperty.setTextSize(textSize);
        calendarDayProperty.setTextColor(textColor);
        calendarDayProperty.setTextScale(textScale);
        calendarDayProperty.setTextTypeface(Typeface.DEFAULT);
        calendarDayProperty.setSolidColor(solidColor);
        calendarDayProperty.setStrokeColor(strokeColor);
        calendarDayProperty.setStrokeWidth(strokeWidth);
        calendarDayProperty.setSpecialText(specialText);
        calendarDayProperty.setSpecialTextSize(specialTextSize);
        calendarDayProperty.setSpecialTextColor(specialTextColor);
        calendarDayProperty.setSpecialTextTypeface(Typeface.DEFAULT);
        //初始化画笔
        paint = new Paint();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

    }

    @Override
    protected void onDraw(Canvas canvas) {
        width = getWidth();
        height = getHeight();
        //先外部轮廓图形填充颜色
        paint.setAntiAlias(true);
        paint.setColor(calendarDayProperty.getSolidColor());
        paint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(width/2 , height/2 , Math.min(width, height) / 2 , paint);
        paint.reset();

        //绘画边框
        if(calendarDayProperty.getStrokeWidth() > 0){
            paint.setAntiAlias(true);
            paint.setColor(calendarDayProperty.getStrokeColor());
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(calendarDayProperty.getStrokeWidth());
            canvas.drawCircle(width/2 , height/2 , Math.min(width, height) / 2 , paint);
            paint.reset();
        }

        //绘画字体,如果存在特殊文本，需要先测量其高度，目的是让号数和特殊文本整体居中
        float interalHeight = 0;
        if(!calendarDayProperty.getSpecialText().isEmpty()){
            paint.setAntiAlias(true);
            paint.setColor(calendarDayProperty.getSpecialTextColor());
            paint.setTextSize(calendarDayProperty.getSpecialTextSize() * calendarDayProperty.getTextScale());
            paint.setTypeface(calendarDayProperty.getSpecialTextTypeface());
            Rect bounds  = new Rect();
            paint.getTextBounds(calendarDayProperty.getSpecialText(), 0, calendarDayProperty.getSpecialText().length(), bounds);
            interalHeight = (bounds.height() + 18) / 2;
            canvas.drawText(calendarDayProperty.getSpecialText(), width/2 - bounds.width()/2, height/2 + bounds.height()/2 + interalHeight, paint);
            paint.reset();
        }

        paint.setAntiAlias(true);
        paint.setColor(calendarDayProperty.getTextColor());
        paint.setTextSize(calendarDayProperty.getTextSize() * calendarDayProperty.getTextScale());
        paint.setTypeface(calendarDayProperty.getTextTypeface());
        Rect bounds  = new Rect();
        paint.getTextBounds(calendarDayProperty.getDayText(), 0, calendarDayProperty.getDayText().length(), bounds);
        canvas.drawText(calendarDayProperty.getSpecialText(), width/2 - bounds.width()/2, height/2 + bounds.height()/2 - interalHeight, paint);
        paint.reset();
    }
}
