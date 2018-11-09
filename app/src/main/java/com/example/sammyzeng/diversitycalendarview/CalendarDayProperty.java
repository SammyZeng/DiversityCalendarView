package com.example.sammyzeng.diversitycalendarview;

import android.content.Context;
import android.graphics.Typeface;

/**
 * Created by sammy.zeng on 2018/11/9.
 */

public class CalendarDayProperty {
    //几号文本
    private String dayText;
    //字体大小
    private float textSize;
    //字体颜色
    private int textColor;
    //字体风格
    private Typeface textTypeface;
    //字体缩放大小
    private float textScale;

    //特殊文本
    private String specialText;
    //字体大小
    private float specialTextSize;
    //字体颜色
    private int specialTextColor;
    //字体风格
    private Typeface specialTextTypeface;

    //填充颜色
    private int solidColor;
    //边框颜色
    private int strokeColor;
    //边框宽度
    private float strokeWidth;
    //填充背景的形状
    private int solidShape;

    //初始化默认值
    public CalendarDayProperty(Context context) {
        textSize = ViewUtil.dip2px(context, 13);
        textColor = context.getResources().getColor(R.color.day_text_color);
        textTypeface = Typeface.DEFAULT ;
        textScale = 1.0f;
        solidColor = context.getResources().getColor(R.color.calendar_background);
        strokeColor = context.getResources().getColor(R.color.calendar_background);
    }

    public String getDayText() {
        return dayText;
    }

    public void setDayText(String dayText) {
        this.dayText = dayText;
    }

    public float getTextSize() {
        return textSize;
    }

    public void setTextSize(float textSize) {
        this.textSize = textSize;
    }

    public int getTextColor() {
        return textColor;
    }

    public void setTextColor(int textColor) {
        this.textColor = textColor;
    }


    public Typeface getTextTypeface() {
        return textTypeface;
    }

    public void setTextTypeface(Typeface textTypeface) {
        this.textTypeface = textTypeface;
    }

    public float getTextScale() {
        return textScale;
    }

    public void setTextScale(float textScale) {
        this.textScale = textScale;
    }

    public int getSolidColor() {
        return solidColor;
    }

    public void setSolidColor(int solidColor) {
        this.solidColor = solidColor;
    }

    public int getStrokeColor() {
        return strokeColor;
    }

    public void setStrokeColor(int strokeColor) {
        this.strokeColor = strokeColor;
    }

    public float getStrokeWidth() {
        return strokeWidth;
    }

    public void setStrokeWidth(float strokeWidth) {
        this.strokeWidth = strokeWidth;
    }

    public float getSpecialTextSize() {
        return specialTextSize;
    }

    public void setSpecialTextSize(float specialTextSize) {
        this.specialTextSize = specialTextSize;
    }

    public int getSpecialTextColor() {
        return specialTextColor;
    }

    public void setSpecialTextColor(int specialTextColor) {
        this.specialTextColor = specialTextColor;
    }

    public Typeface getSpecialTextTypeface() {
        return specialTextTypeface;
    }

    public void setSpecialTextTypeface(Typeface specialTextTypeface) {
        this.specialTextTypeface = specialTextTypeface;
    }

    public int getSolidShape() {
        return solidShape;
    }

    public void setSolidShape(int solidShape) {
        this.solidShape = solidShape;
    }

    public String getSpecialText() {
        return specialText;
    }

    public void setSpecialText(String specialText) {
        this.specialText = specialText;
    }
}
