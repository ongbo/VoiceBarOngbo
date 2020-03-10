package com.voicebar.controller;

import com.alibaba.fastjson.JSONObject;
import com.voicebar.entity.AnalyResult;
import com.voicebar.entity.ViewResultAnaly;
import com.voicebar.form.AnalyForm;
import com.voicebar.service.MongoDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("mongodata")
@CrossOrigin
public class MongoDataViewControl {

    @Autowired
    MongoDataService mongoDataService;

    @RequestMapping(value = "resultinfoView",method = RequestMethod.POST)
    public String resultinfoView(@RequestBody AnalyForm analyForm){
        String type = analyForm.getType();
        List<AnalyResult> list = new ArrayList<AnalyResult>();
        if("yearbase".equals(type)){
            list = mongoDataService.searchYearBase();
        }else if("email".equals(type)){
            list = mongoDataService.searchEmail();
        }else if("carrier".equals(type)){
            list = mongoDataService.searchCarrier();
        }else if("themelike".equals(type)){
            list = mongoDataService.searchThemeLike();
        }else if("stylelike".equals(type)){
            list = mongoDataService.searchStyleLike();
        }

        ViewResultAnaly viewResultAnaly = new ViewResultAnaly();
        List<String> infolist = new ArrayList<String>();
        List<Long> countlist = new ArrayList<Long>();

        for(AnalyResult analyResult:list){
            infolist.add(analyResult.getInfo());
            countlist.add(analyResult.getCount());
        }

        viewResultAnaly.setInfolist(infolist);
        viewResultAnaly.setCountlist(countlist);
        String result = JSONObject.toJSONString(viewResultAnaly);
        return result;

    }

}
