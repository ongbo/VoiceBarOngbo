package com.voicebar.service;

import com.voicebar.entity.AnalyResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "VoiceBarSearchInfo")
public interface YearBaseService {
    @RequestMapping(value = "yearbase/searchYearBase",method = RequestMethod.POST)
    public List<AnalyResult> searchYearBase();
}
