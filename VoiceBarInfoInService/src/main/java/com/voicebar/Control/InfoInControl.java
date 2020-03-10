package com.voicebar.Control;


import com.alibaba.fastjson.JSONObject;
import com.voicebar.entity.ResultMessage;
import com.voicebar.log.*;
import com.voicebar.utils.ReadProperties;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@RestController
@RequestMapping("infolog")
public class InfoInControl {
    private final String CollectionDubMaterialTopic = ReadProperties.getKey("CollectionDubMaterial");
    private final String CollectionDubWorkTopic = ReadProperties.getKey("CollectionDubWork");
    private final String DubMaterialTopic = ReadProperties.getKey("DubMaterial");
    private final String LikeDubWorkTopic = ReadProperties.getKey("LikeDubWork");
    private final String ScanDubMaterialTopic = ReadProperties.getKey("ScanDubMaterial");
    private final String ScanDubWorkTopic = ReadProperties.getKey("ScanDubWork");
    private final String TrendDubMaterialTopic = ReadProperties.getKey("TrendDubMaterial");
    private final String TrendDubWorkTopic = ReadProperties.getKey("TrendDubWork");

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @RequestMapping(value = "helloworld",method = RequestMethod.GET)
    public String helloword(HttpServletRequest req){
        String ip = req.getRemoteAddr();
        ResultMessage resultMessage = new ResultMessage();
        resultMessage.setMessage("hello:"+ip);
        resultMessage.setStatus("success");
        String result = JSONObject.toJSONString(resultMessage);
        return result;
    }
/**
 *
 * CollectionDubMaterial
 * CollectionDubWork
 * DubMaterial
 * LikeDubWork
 * ScanDubMaterial
 * ScanDubWork
 * TrendDubMaterial
 * TrendDubWork
 * */
    @RequestMapping(value = "receivelog" , method = RequestMethod.POST)
    public String receivelog(String receivelog, HttpServletRequest req){
        if(StringUtils.isBlank(receivelog)){
            return null;
        }

        String[] rearrays = receivelog.split(":", 2);
        String classname = rearrays[0];
        String data = rearrays[1];
        String resultmessage = "";
        if(classname.equals("CollectionDubMaterial")){
            CollectionDubMaterial collectionDubMaterial = JSONObject.parseObject(data, CollectionDubMaterial.class);
            resultmessage = JSONObject.toJSONString(collectionDubMaterial);
            kafkaTemplate.send(CollectionDubMaterialTopic, resultmessage+"##1##"+new Date().getTime());
        }else if(classname.equals("CollectionDubWork")){
            CollectionDubWork collectionDubWork = JSONObject.parseObject(data, CollectionDubWork.class);
            resultmessage = JSONObject.toJSONString(collectionDubWork);
            kafkaTemplate.send(CollectionDubWorkTopic, resultmessage+"##1##"+new Date().getTime());

        }else if(classname.equals("DubMaterial")){
            DubMaterial dubMaterial = JSONObject.parseObject(data, DubMaterial.class);
            resultmessage = JSONObject.toJSONString(dubMaterial);
            kafkaTemplate.send(DubMaterialTopic, resultmessage+"##1##"+new Date().getTime());
        }else if(classname.equals("LikeDubWork")){
            LikeDubWork likeDubWork = JSONObject.parseObject(data, LikeDubWork.class);
            resultmessage = JSONObject.toJSONString(likeDubWork);
            kafkaTemplate.send(LikeDubWorkTopic, resultmessage+"##1##"+new Date().getTime());
        }else if(classname.equals("ScanDubMaterial")){
            ScanDubMaterial scanDubMaterial = JSONObject.parseObject(data, ScanDubMaterial.class);
            resultmessage = JSONObject.toJSONString(scanDubMaterial);
            kafkaTemplate.send(ScanDubMaterialTopic, resultmessage+"##1##"+new Date().getTime());
        }else if(classname.equals("ScanDubWork")){
            ScanDubWork scanDubWork = JSONObject.parseObject(data, ScanDubWork.class);
            resultmessage = JSONObject.toJSONString(scanDubWork);
            kafkaTemplate.send(ScanDubWorkTopic, resultmessage+"##1##"+new Date().getTime());
        }else if(classname.equals("TrendDubMaterial")){
            TrendDubMaterial trendDubMaterial = JSONObject.parseObject(data, TrendDubMaterial.class);
            resultmessage = JSONObject.toJSONString(trendDubMaterial);
            kafkaTemplate.send(TrendDubMaterialTopic, resultmessage+"##1##"+new Date().getTime());
        }else if(classname.equals("TrendDubWork")){
            TrendDubWork trendDubWork = JSONObject.parseObject(data, TrendDubWork.class);
            resultmessage = JSONObject.toJSONString(trendDubWork);
            kafkaTemplate.send(TrendDubWorkTopic, resultmessage+"##1##"+new Date().getTime());
        }

        ResultMessage resultMessage = new ResultMessage();
        resultMessage.setMessage(resultmessage);
        resultMessage.setStatus("success");
        String result = JSONObject.toJSONString(resultMessage);
        return result;

    }



}
