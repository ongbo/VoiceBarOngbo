package com.voicebar.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "VoiceBarSearchInfo")


/**
 *
 * 展示效果：
 * 年代群体：
 * 手机运营商：
 * 邮件运营商：
 * 地区：
 *
 * 用户行为：
 * 异常登陆：
 * PV：
 * UV：
 * 热门作品：
 * 用户偏好：
 * 题材偏好：
 * 风格偏好：
 * 语言偏好：
 * 配音能力：
 * 用户标签：
 * 所有用户的标签信息
 *  性别
 * */
public interface HbaseDataService {
//
//    @RequestMapping(value = "hbaseData/baiJiaZhiShuInfo",method = RequestMethod.POST)
//    public String baiJiaZhiShuInfo(String userid);

    /**PV*/
    @RequestMapping(value = "hbaseData/pvsearch",method = RequestMethod.POST)
    public String pvsearch(String userid);

    /**UV*/
    @RequestMapping(value = "hbaseData/uvsearch",method = RequestMethod.POST)
    public String uvsearch(String userid);
    /**热门作品*/
    @RequestMapping(value = "hbaseData/hotwork",method = RequestMethod.POST)
    public String hotwork(String userid);

    /**异常登陆*/
    @RequestMapping(value = "hbaseData/errorlogin",method = RequestMethod.POST)
    public String errorlogin(String userid);

    /**题材偏好*/
    @RequestMapping(value = "hbaseData/themelike",method = RequestMethod.POST)
    public String themeLike(String userid);
    /**语言偏好*/
    @RequestMapping(value = "hbaseData/languagelike",method = RequestMethod.POST)
    public String languageLike(String userid);
    /**风格偏好*/
    @RequestMapping(value = "hbaseData/stylelike",method = RequestMethod.POST)
    public String styleLike(String userid);
    /**手机运营商偏好*/
    @RequestMapping(value = "hbaseData/carrierinfo",method = RequestMethod.POST)
    public String carrierinfo(String userid);


        /**邮箱*/
    @RequestMapping(value = "hbaseData/emailinfo",method = RequestMethod.POST)
    public String emailinfo(String userid);

    /**性别*/
    @RequestMapping(value = "hbaseData/sex",method = RequestMethod.POST)
    public String sex(String userid);

    /**用户群体特征*/
    @RequestMapping(value = "hbaseData/usergroupinfo",method = RequestMethod.POST)
    public String usergroupinfo(String userid);

/** 年龄*/
    @RequestMapping(value = "hbaseData/ageinfo",method = RequestMethod.POST)
    public String ageinfo(String userid);
    /**地区*/
    @RequestMapping(value = "hbaseData/region",method = RequestMethod.POST)
    public String region(String userid);
}
