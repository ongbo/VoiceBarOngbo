package com.voicebar.search.control;

import com.voicebar.entity.AnalyResult;
import com.voicebar.search.service.MongoDataServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("data")
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
        return mongoDataServiceImpl.listMongoInfoby("voiceportrait","yearbasestatics");
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
     * 题材偏爱程度
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
