package com.voicebar.Util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DataUtils {
    public static String getYearbaseByAge(String age){
        //获取日历
        Calendar calendar = Calendar.getInstance();
        //设置当前时间
        calendar.setTime(new Date());
        //将当前时间的年份减去年龄
        calendar.add(Calendar.YEAR,-Integer.valueOf(age));
        //那么出生的那年就是newdate
        Date newdate = calendar.getTime();
        //设置yyyy的格式
        DateFormat dateFormat = new SimpleDateFormat("yyyy");
        //获取那时候年份
        String newdatestring = dateFormat.format(newdate);
        //转成数值
        Integer newdateinteger = Integer.valueOf(newdatestring);

        //
        String yearbasetype = "未知";
        if(newdateinteger >= 1950 && newdateinteger< 1960){
            yearbasetype = "50后";
        }else if(newdateinteger >= 1960 && newdateinteger< 1970) {
            yearbasetype = "60后";
        }else if(newdateinteger >= 1970 && newdateinteger< 1980) {
            yearbasetype = "70后";
        }else if(newdateinteger >= 1980 && newdateinteger< 1990) {
            yearbasetype = "80后";
        }else if(newdateinteger >= 1990 && newdateinteger< 2000) {
            yearbasetype = "90后";
        }else if(newdateinteger >= 2000 && newdateinteger< 2010) {
            yearbasetype = "00后";
        }else if(newdateinteger >= 2010 && newdateinteger< 2020) {
            yearbasetype = "10后";
        }
        return yearbasetype;
    }
}
