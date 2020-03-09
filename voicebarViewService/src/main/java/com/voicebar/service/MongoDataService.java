package com.voicebar.service;


import com.voicebar.entity.AnalyResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "VoiceBarSearchInfo")
public interface MongoDataService {

    /**查询年代*/
    @RequestMapping(value = "voicebar/searchYearBase",method = RequestMethod.POST)
    public List<AnalyResult> searchYearBase();

    /**邮箱*/
    @RequestMapping(value = "voicebar/searchEmail",method = RequestMethod.POST)
    public List<AnalyResult> searchEmail();

    /**运营商*/
    @RequestMapping(value = "voicebar/searchCarrier",method = RequestMethod.POST)
    public List<AnalyResult> searchCarrier();

    /**题材喜好*/
    @RequestMapping(value = "voicebar/searchThemeLike",method = RequestMethod.POST)
    public List<AnalyResult> searchThemeLike();

    /**风格喜好*/
    @RequestMapping(value = "voicebar/searchStyleLike",method = RequestMethod.POST)
    public List<AnalyResult> searchStyleLike();

/**还有性别潮男潮女，还有消费水平*/


}
