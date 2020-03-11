package com.voicebar.service;


import com.voicebar.entity.AnalyResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 *
 * 展示效果：
 *  年代群体：
 *  手机运营商：
 *  邮件运营商：
 *  地区：
 *
 * 用户行为：
 *  异常登陆：
 *  PV：
 *  UV：
 *  热门作品：
 *  用户群体：
 * 用户偏好：
 *  题材偏好：
 *  风格偏好：
 *  语言偏好：
 * 配音能力：
 * 用户标签：
 * 所有用户的标签信息
 *  性别，年龄
 * */
import java.util.List;

@FeignClient(value = "VoiceBarSearchInfo")
public interface MongoDataService {

    /**查询年代*/
    @RequestMapping(value = "voicebar/searchYearBase",method = RequestMethod.POST)
    public List<AnalyResult> searchYearBase();

    /**邮箱*/
    @RequestMapping(value = "voicebar/searchEmail",method = RequestMethod.POST)
    public List<AnalyResult> searchEmail();

    /**手机号运营商*/
    @RequestMapping(value = "voicebar/searchCarrier",method = RequestMethod.POST)
    public List<AnalyResult> searchCarrier();

    /**地区*/
    @RequestMapping(value = "voicebar/searchregion",method = RequestMethod.POST)
    public List<AnalyResult> searchResion();
    /**异常登陆*/
    @RequestMapping(value = "voicebar/searcherrorlogin",method = RequestMethod.POST)
    public List<AnalyResult> searchErrorLogin();
    /**PV*/
    @RequestMapping(value = "voicebar/searchpv",method = RequestMethod.POST)
    public List<AnalyResult> searchPV();
    /**UV*/
    @RequestMapping(value = "voicebar/searchuv",method = RequestMethod.POST)
    public List<AnalyResult> searchUV();
    /**热门作品*/
    @RequestMapping(value = "voicebar/searchhotwork",method = RequestMethod.POST)
    public List<AnalyResult> searchHotWork();
    /**用户群体*/
    @RequestMapping(value = "voicebar/searchusergroup",method = RequestMethod.POST)
    public List<AnalyResult> searchUserGroup();
    /**题材喜好*/
    @RequestMapping(value = "voicebar/searchThemeLike",method = RequestMethod.POST)
    public List<AnalyResult> searchThemeLike();
    /**风格喜好*/
    @RequestMapping(value = "voicebar/searchStyleLike",method = RequestMethod.POST)
    public List<AnalyResult> searchStyleLike();
    /**语言喜好*/
    @RequestMapping(value = "voicebar/searchLanguageLike",method = RequestMethod.POST)
    public List<AnalyResult> searchLanguage();

/**还有性别潮男潮女，还有消费水平*/


}
