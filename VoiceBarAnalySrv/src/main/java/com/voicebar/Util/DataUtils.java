package com.voicebar.Util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DataUtils {
    /**
     * 计算属于哪个年代
     * 用于年代标签
     * */
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
        if(newdateinteger >= 1940 && newdateinteger < 1950){
            yearbasetype = "40后";
        }else if(newdateinteger >= 1950 && newdateinteger< 1960){
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

    /**
     * 计算
     * 来了两个时间,计算其实时间点和结束时间点的天数
     * */
    public static int getDayBetweenbyStartAndend(String starttime,String endtime,String dateFormatstring) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat(dateFormatstring);
        Date start = dateFormat.parse(starttime);
        Date end = dateFormat.parse(endtime);

        Calendar startcanlendar = Calendar.getInstance();
        Calendar endcalendar = Calendar.getInstance();
        startcanlendar.setTime(start);
        endcalendar.setTime(end);
        int days = 0;
        while(startcanlendar.before(endcalendar)){
            startcanlendar.add(Calendar.DAY_OF_YEAR,1);
            days+=1;
        }
        return days;
    }

    /**
     *
     * */

    /**
     * 将穿过来的时间"20170323 123322"
     * 转换成Thu Mar 23 00:33:22 CST 2017格式
     * 然后获取到小时：12点
     *
     * */
    public static String gethoursBydate(String timevalue) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd hhmmss");
        Date time = dateFormat.parse(timevalue);
//        System.out.println(time);
        dateFormat = new SimpleDateFormat("hh");
        String resulthour = dateFormat.format(time);
        return resulthour;
    }
}
