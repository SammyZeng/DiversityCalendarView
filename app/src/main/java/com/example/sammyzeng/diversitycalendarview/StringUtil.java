package com.example.sammyzeng.diversitycalendarview;

/**
 * Created by sammy.zeng on 2018/11/12.
 */

public class StringUtil {

    public static boolean isEmpty(String str){
        if(str != null && !"".equals(str)){
            return false;
        }
        return true;
    }
}
