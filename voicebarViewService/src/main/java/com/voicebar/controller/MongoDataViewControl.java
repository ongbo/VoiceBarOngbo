package com.voicebar.controller;

import com.voicebar.entity.AnalyResult;
import com.voicebar.form.AnalyForm;
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
        }

    }

}
