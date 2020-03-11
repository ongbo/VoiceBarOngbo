package com.voicebar.search.control;

import com.voicebar.entity.AnalyResult;
import com.voicebar.search.service.MongoDataServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sun.misc.Request;

import java.util.ArrayList;
import java.util.List;

/**
 * MongoDB数据表：
 * 年代：yearbasestatics
 * 邮件：emailstatics
 * 运营商：carrierstatics
 * 题材偏爱程度：themelikestatics
 * 风格偏爱：stylelikestatics
 * */

@RestController
@RequestMapping("voicebar")
public class MongoDataControl {

    @Autowired
    private MongoDataServiceImpl mongoDataServiceImpl;


    /**
     * 年代查询
     * */
    @RequestMapping(value="searchYearBase", method = RequestMethod.POST)
    public List<AnalyResult> searchYearBase(){
        List<AnalyResult> list = new ArrayList<AnalyResult>();
        AnalyResult analyResult = new AnalyResult();
        //40年代，50年代，60年代，70年代，80年代，90年代，00年代 10后
        analyResult.setCount(50l);
        analyResult.setInfo("40年代");
        list.add(analyResult);
        analyResult = new AnalyResult();
        analyResult.setCount(60l);
        analyResult.setInfo("50年代");
        list.add(analyResult);
        analyResult = new AnalyResult();
        analyResult.setCount(100l);
        analyResult.setInfo("60年代");
        list.add(analyResult);
        analyResult = new AnalyResult();
        analyResult.setCount(90l);
        analyResult.setInfo("70年代");
        list.add(analyResult);
        analyResult = new AnalyResult();
        analyResult.setCount(500l);
        analyResult.setInfo("80年代");
        list.add(analyResult);
        analyResult = new AnalyResult();
        analyResult.setCount(600l);
        analyResult.setInfo("90年代");
        list.add(analyResult);
        analyResult = new AnalyResult();
        analyResult.setCount(300l);
        analyResult.setInfo("00年代");
        list.add(analyResult);
        analyResult = new AnalyResult();
        analyResult.setCount(70l);
        analyResult.setInfo("10后");

        list.add(analyResult);

        return list;
        /**
         * 50年代
         * 60年代
         * 70年代
         * 80年代
         * 90年代
         * 00年代
         * 10年代
         * */
//        analyResult.setCount(50L);
//        return mongoDataServiceImpl.listMongoInfoby("voiceportrait","yearbasestatics");
    }

    /**
     * 运营商查询
     * */
    @RequestMapping(value = "searchCarrier",method = RequestMethod.POST)
    public List<AnalyResult> searchCarrier(){
        //联通 移动 电信 其他
        List<AnalyResult> list = new ArrayList<AnalyResult>();
        AnalyResult analyResult = new AnalyResult();

        analyResult.setCount(1350l);
        analyResult.setInfo("联通");
        list.add(analyResult);

        analyResult = new AnalyResult();
        analyResult.setCount(1560l);
        analyResult.setInfo("移动");
        list.add(analyResult);

        analyResult = new AnalyResult();
        analyResult.setCount(560l);
        analyResult.setInfo("电信");
        list.add(analyResult);

        analyResult = new AnalyResult();
        analyResult.setCount(4560l);
        analyResult.setInfo("其他");
        list.add(analyResult);

        return list;
//        return mongoDataServiceImpl.listMongoInfoby("carrierstatics");

    }

    /**
     * 邮箱查询
     * */
    @RequestMapping(value = "searchEmail",method = RequestMethod.POST)
    public List<AnalyResult> searchEmail(){
        List<AnalyResult> list = new ArrayList<AnalyResult>();
        AnalyResult analyResult = new AnalyResult();
        //qq邮箱，139邮箱，网易邮箱,阿里邮箱
        analyResult.setCount(150l);
        analyResult.setInfo("qq邮箱");
        list.add(analyResult);

        analyResult = new AnalyResult();
        analyResult.setCount(60l);
        analyResult.setInfo("139邮箱");
        list.add(analyResult);

        analyResult = new AnalyResult();
        analyResult.setCount(240l);
        analyResult.setInfo("网易邮箱");
        list.add(analyResult);

        analyResult = new AnalyResult();
        analyResult.setCount(540l);
        analyResult.setInfo("阿里邮箱");
        list.add(analyResult);

        return list;

//        return mongoDataServiceImpl.listMongoInfoby("emailstatics");
    }

    /**
     * 题材偏爱程度
     * */
    @RequestMapping(value = "searchThemeLike", method = RequestMethod.POST)
    public List<AnalyResult> searchThemeLike(){
        //李宁 爱迪达斯 森马 海尔
        List<AnalyResult> list = new ArrayList<AnalyResult>();
        AnalyResult analyResult = new AnalyResult();

        analyResult.setCount(1350l);
        analyResult.setInfo("李宁");
        list.add(analyResult);

        analyResult = new AnalyResult();
        analyResult.setCount(1560l);
        analyResult.setInfo("爱迪达斯");
        list.add(analyResult);

        analyResult = new AnalyResult();
        analyResult.setCount(560l);
        analyResult.setInfo("森马");
        list.add(analyResult);

        analyResult = new AnalyResult();
        analyResult.setCount(4560l);
        analyResult.setInfo("海尔");
        list.add(analyResult);

        return list;

//        return mongoDataServiceImpl.listMongoInfoby("themelikestatics");
    }

    /**
     * 风格偏爱程度
     * */
    @RequestMapping(value = "searchStyleLike", method = RequestMethod.POST)
    public List<AnalyResult> searchStyleLike(){
        //李宁 爱迪达斯 森马 海尔
        List<AnalyResult> list = new ArrayList<AnalyResult>();
        AnalyResult analyResult = new AnalyResult();

        analyResult.setCount(1350l);
        analyResult.setInfo("李宁");
        list.add(analyResult);

        analyResult = new AnalyResult();
        analyResult.setCount(1560l);
        analyResult.setInfo("爱迪达斯");
        list.add(analyResult);

        analyResult = new AnalyResult();
        analyResult.setCount(560l);
        analyResult.setInfo("森马");
        list.add(analyResult);

        analyResult = new AnalyResult();
        analyResult.setCount(4560l);
        analyResult.setInfo("海尔");
        list.add(analyResult);

        return list;

//        return mongoDataServiceImpl.listMongoInfoby("stylelikestatics");
    }


    /**
     * 语言偏爱程度
     * */
    @RequestMapping(value = "searchLanguageLike", method = RequestMethod.POST)
    public List<AnalyResult> searchLanguageLike(){
        //李宁 爱迪达斯 森马 海尔
        List<AnalyResult> list = new ArrayList<AnalyResult>();
        AnalyResult analyResult = new AnalyResult();

        analyResult.setCount(1350l);
        analyResult.setInfo("李宁");
        list.add(analyResult);

        analyResult = new AnalyResult();
        analyResult.setCount(1560l);
        analyResult.setInfo("爱迪达斯");
        list.add(analyResult);

        analyResult = new AnalyResult();
        analyResult.setCount(560l);
        analyResult.setInfo("森马");
        list.add(analyResult);

        analyResult = new AnalyResult();
        analyResult.setCount(4560l);
        analyResult.setInfo("海尔");
        list.add(analyResult);

        return list;

//        return mongoDataServiceImpl.listMongoInfoby("languagelikestatics");
    }

    /**地区*/
    @RequestMapping(value = "searchregion",method = RequestMethod.POST)
    public List<AnalyResult> searchRegion(){
        List<AnalyResult> list = new ArrayList<AnalyResult>();
        AnalyResult analyResult = new AnalyResult();

        analyResult.setCount(123440L);
        analyResult.setInfo("湖南");
        list.add(analyResult);
        analyResult = new AnalyResult();
        analyResult.setCount(12343440L);
        analyResult.setInfo("广东");
        list.add(analyResult);
        analyResult = new AnalyResult();
        analyResult.setCount(123440L);
        analyResult.setInfo("上海");
        list.add(analyResult);
        analyResult = new AnalyResult();
        analyResult.setCount(123440L);
        analyResult.setInfo("北京");
        list.add(analyResult);

//        return mongoDataServiceImpl.listMongoInfoby("regionstatics");
        return list;

    }
    @RequestMapping(value = "searcherrorlogin",method = RequestMethod.POST)
    public List<AnalyResult> searchErrorLogin(){
        List<AnalyResult> list = new ArrayList<>();
        AnalyResult analyResult = new AnalyResult();
        analyResult.setCount(223L);
        analyResult.setInfo("异常登陆");
        list.add(analyResult);
//        return mongoDataServiceImpl.listMongoInfoby("errorlogin");
        return list;
    }


    /**PV*/
    @RequestMapping(value = "searchpv",method = RequestMethod.POST)
    public List<AnalyResult> searchpv(){
        List<AnalyResult> list = new ArrayList<>();
        AnalyResult analyResult = new AnalyResult();

        analyResult.setCount(23432L);
        analyResult.setInfo("PV");
        list.add(analyResult);
//        return mongoDataServiceImpl.listMongoInfoby("pvstatics");
        return list;
    }

    /**UV*/
    @RequestMapping(value = "searchuv",method = RequestMethod.POST)
    public List<AnalyResult> searchuv(){
        List<AnalyResult> list = new ArrayList<>();
        AnalyResult analyResult = new AnalyResult();

        analyResult.setCount(23432L);
        analyResult.setInfo("UV");
//        return mongoDataServiceImpl.listMongoInfoby("uvstatics");
        list.add(analyResult);
        return list;
    }
    /**热门作品*/
    @RequestMapping(value = "searchhotwork",method = RequestMethod.POST)
    public List<AnalyResult> searchhotwork(){
        List<AnalyResult> list = new ArrayList<>();
        AnalyResult analyResult = new AnalyResult();

        analyResult.setInfo("王道只穿");
        analyResult.setCount(23432L);
        list.add(analyResult);

        analyResult = new AnalyResult();
        analyResult.setInfo("庆余年");
        analyResult.setCount(34321L);
        list.add(analyResult);
//        return mongoDataServiceImpl.listMongoInfoby("hotworkstatics");
        return list;
    }
    /**用户群体*/
    @RequestMapping(value = "searchusergroup",method = RequestMethod.POST)
    public List<AnalyResult> searchusergroup(){
        List<AnalyResult> list = new ArrayList<>();
        AnalyResult analyResult = new AnalyResult();

        analyResult.setInfo("超人");
        analyResult.setCount(4312234L);
        list.add(analyResult);

        analyResult = new AnalyResult();
        analyResult.setCount(3421L);
        analyResult.setInfo("无处");
        list.add(analyResult);
//        return mongoDataServiceImpl.listMongoInfoby("usergroupstatics");
        return list;
    }

    /**
     * 配音水平之类的
     * */
//
//    @RequestMapping(value = "searchConsumptionlevel",method = RequestMethod.POST)
//    public List<AnalyResult> searchConsumptionlevel(){
//        //高消费 中等消费  低消费
//        List<AnalyResult> list = new ArrayList<AnalyResult>();
//        AnalyResult analyResult = new AnalyResult();
//        //qq邮箱，139邮箱，网易邮箱,阿里邮箱
//        analyResult.setCount(50l);
//        analyResult.setInfo("高消费");
//        list.add(analyResult);
//
//        analyResult = new AnalyResult();
//        analyResult.setCount(560l);
//        analyResult.setInfo("中等消费");
//        list.add(analyResult);
//
//        analyResult = new AnalyResult();
//        analyResult.setCount(760l);
//        analyResult.setInfo("低消费");
//        list.add(analyResult);
//
//        return list;
//
////        return mongoDataServiceImpl.listMongoInfoby("consumptionlevelstatics");
//    }

//    @RequestMapping(value = "searchChaoManAndWomen",method = RequestMethod.POST)
//    public List<AnalyResult> searchChaoManAndWomen(){
//        //潮男 潮女
//        List<AnalyResult> list = new ArrayList<AnalyResult>();
//        AnalyResult analyResult = new AnalyResult();
//
//        analyResult.setCount(350l);
//        analyResult.setInfo("潮男");
//        list.add(analyResult);
//
//        analyResult = new AnalyResult();
//        analyResult.setCount(560l);
//        analyResult.setInfo("潮女");
//        list.add(analyResult);
//
//        return list;
//
////        return mongoDataServiceImpl.listMongoInfoby("chaoManAndWomenstatics");
//    }


}
