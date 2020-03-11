package com.voicebar.search.control;

import com.voicebar.search.service.HbaseServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hbaseData")
public class HbaseDataControl  {
    /**题材偏好*/
    @RequestMapping(value = "themelike",method = RequestMethod.POST)
    public String themelike(String userid){
        String result = "";
//        String tablename = "userflaginfo";
//        String rowkey = userid+"";
//        String familyname = "userbehavior";
//        String column = "themelike";//题材偏好
//        try {
//            result = HbaseServiceImpl.getdata(tablename,rowkey,familyname,column);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        result = "专题配音";
        return result;
    }
/**风格偏好*/
    @RequestMapping(value = "stylelike",method = RequestMethod.POST)
    public String stylelike(String userid){
        String result = "";
//        String tablename = "userflaginfo";
//        String rowkey = userid+"";
//        String familyname = "userbehavior";
//        String column = "stylelike";//风格偏好
//        try {
//            result = HbaseServiceImpl.getdata(tablename,rowkey,familyname,column);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        result = "磁性";
        return result;
    }

    /**语言偏好*/
    @RequestMapping(value = "languagelike",method = RequestMethod.POST)
    public String languagelike(String userid){
        String result = "";
//        String tablename = "userflaginfo";
//        String rowkey = userid+"";
//        String familyname = "userbehavior";
//        String column = "languagelike";//语言偏好
//        try {
//            result = HbaseServiceImpl.getdata(tablename,rowkey,familyname,column);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        result = "中文";
        return result;
    }

    /**手机号运营*/
    @RequestMapping(value = "carrierinfo",method = RequestMethod.POST)
    public String carrierinfo(String userid){
        String result = "";
//        String tablename = "userflaginfo";
//        String rowkey = userid;
//        String famliyname = "baseinfo";
//        String colum = "carrierinfo";//运营商
//        String result = "";
//        try {
//            result = HbaseServiceImpl.getdata(tablename,rowkey,famliyname,colum);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        result = "移动用户";
        return result;
    }

    /**邮箱*/
    @RequestMapping(value = "emailinfo",method = RequestMethod.POST)
    public String emailinfo(String userid){
        String result = "";
//        String tablename = "userflaginfo";
//        String rowkey = userid;
//        String famliyname = "baseinfo";
//        String colum = "emailinfo";//运营商
//        String result = "";
//        try {
//            result = HbaseServiceImpl.getdata(tablename,rowkey,famliyname,colum);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        result = "qq邮箱用户,网易邮箱用户";
        return result;
    }

    /***/
    @RequestMapping(value = "sex",method = RequestMethod.POST)
    public String sex(String userid){
        String result = "";
//        String tablename = "userflaginfo";
//        String rowkey = userid+"";
//        String famliyname = "baseinfo";
//        String colum = "sex";
//        String result = "";
//        try {
//            result = HbaseServiceImpl.getdata(tablename,rowkey,famliyname,colum);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        result = "女性";
        return result;
    }


    /**风格偏好*/
    @RequestMapping(value = "ageinfo",method = RequestMethod.POST)
    public String ageinfo(String userid){
        String result = "";
//        String tablename = "userflaginfo";
//        String rowkey = userid;
//        String famliyname = "baseinfo";
//        String colum = "age";
//        String result = "";
//        try {
//            result = HbaseServiceImpl.getdata(tablename,rowkey,famliyname,colum);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        result = "28";
        return result;
    }

    /**风格偏好*/
    @RequestMapping(value = "region",method = RequestMethod.POST)
    public String region(String userid){
        String result = "";
//        String tablename = "userflaginfo";
//        String rowkey = userid;
//        String familyname = "baseinfo";
//        String column = "region";
//        try {
//            result = HbaseServiceImpl.getdata(tablename,rowkey,familyname,column);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        result = "湖南";
        return result;
    }

    /**风格偏好*/
    @RequestMapping(value = "usergroupinfo",method = RequestMethod.POST)
    public String usergroupinfo(String userid){
        String result = "";
//        String tablename = "userflaginfo";
//        String rowkey = userid;
//        String family = "baseinfo";
//        String column = "usergroupinfo";
//        try {
//            result = HbaseServiceImpl.getdata(tablename,rowkey,family,column);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        result = "配音师";
        return result;
    }
}
