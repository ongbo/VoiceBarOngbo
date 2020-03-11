package com.voicebar.controller;

import com.alibaba.fastjson.JSONObject;
import com.voicebar.entity.ViewResultAnaly;
import com.voicebar.form.AnalyForm;
import com.voicebar.service.HbaseDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 展示效果：
 *  年代群体：
 *  手机运营商：
 *  邮件运营商：
 * 地区：
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
@RestController
@RequestMapping("hbaseData")
@CrossOrigin
public class HbaseDataViewControl {
    @Autowired
    HbaseDataService hbaseDataService;

    @RequestMapping(value = "resultinfoView",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public String resultinfoView(@RequestBody AnalyForm analyForm){
        String type = analyForm.getType();
        String userid = analyForm.getUserid();
        String result = "";
        List<ViewResultAnaly> resultlist = new ArrayList<ViewResultAnaly>();
        if("-1".equals(type)){
            ViewResultAnaly viewResultAnaly = new ViewResultAnaly();
            result = hbaseDataService.hotwork(userid);
            viewResultAnaly.setTypename("热门作品");
            viewResultAnaly.setLablevalue(result);
            resultlist.add(viewResultAnaly);

            viewResultAnaly = new ViewResultAnaly();
            result = hbaseDataService.themeLike(userid);
            viewResultAnaly.setTypename("题材偏好");
            viewResultAnaly.setLablevalue(result);
            resultlist.add(viewResultAnaly);

            viewResultAnaly = new ViewResultAnaly();
            result = hbaseDataService.languageLike(userid);
            viewResultAnaly.setTypename("语言偏好");
            viewResultAnaly.setLablevalue(result);
            resultlist.add(viewResultAnaly);

            viewResultAnaly = new ViewResultAnaly();
            result = hbaseDataService.styleLike(userid);
            viewResultAnaly.setTypename("风格偏好");
            viewResultAnaly.setLablevalue(result);
            resultlist.add(viewResultAnaly);

            viewResultAnaly = new ViewResultAnaly();
            result = hbaseDataService.carrierinfo(userid);
            viewResultAnaly.setTypename("手机运营商");
            viewResultAnaly.setLablevalue(result);
            resultlist.add(viewResultAnaly);



            viewResultAnaly = new ViewResultAnaly();
            result = hbaseDataService.emailinfo(userid);
            viewResultAnaly.setTypename("邮件运营商");
            viewResultAnaly.setLablevalue(result);
            resultlist.add(viewResultAnaly);

            viewResultAnaly = new ViewResultAnaly();
            result = hbaseDataService.sex(userid);
            viewResultAnaly.setTypename("性别");
            viewResultAnaly.setLablevalue(result);
            resultlist.add(viewResultAnaly);
            viewResultAnaly = new ViewResultAnaly();
            result = hbaseDataService.usergroupinfo(userid);
            viewResultAnaly.setTypename("用户群体特征");
            viewResultAnaly.setLablevalue(result);
            resultlist.add(viewResultAnaly);

            viewResultAnaly = new ViewResultAnaly();
            result = hbaseDataService.ageinfo(userid);
            viewResultAnaly.setTypename("年龄");
            viewResultAnaly.setLablevalue(result);
            resultlist.add(viewResultAnaly);

            viewResultAnaly = new ViewResultAnaly();
            result = hbaseDataService.region(userid);
            viewResultAnaly.setTypename("地区");
            viewResultAnaly.setLablevalue(result);
            resultlist.add(viewResultAnaly);


            viewResultAnaly = new ViewResultAnaly();
            viewResultAnaly.setList(resultlist);
            String resultjson = JSONObject.toJSONString(viewResultAnaly);
            return resultjson;
        }
        if("hotwork".equals(type)){
            result = hbaseDataService.hotwork(userid);
        }else if ("themelike".equals(type)){
            result = hbaseDataService.themeLike(userid);
        }else if ("carrierinfo".equals(type)){
            result = hbaseDataService.carrierinfo(userid);
        }else if ("stylelike".equals(type)){
            result = hbaseDataService.styleLike(userid);
        }else if ("languagelike".equals(type)){
            result = hbaseDataService.languageLike(userid);
        }else if ("emailinfo".equals(type)){
            result = hbaseDataService.emailinfo(userid);
        }else if ("region".equals(type)){
            result = hbaseDataService.region(userid);
        }else if ("sex".equals(type)){
            result = hbaseDataService.sex(userid);
        }else if ("usergroupinfo".equals(type)){
            result = hbaseDataService.usergroupinfo(userid);
        }else if ("ageinfo".equals(type)){
            result = hbaseDataService.ageinfo(userid);
        }
        ViewResultAnaly viewResultAnaly = new ViewResultAnaly();
        viewResultAnaly.setResult(result);
        result = JSONObject.toJSONString(viewResultAnaly);
        return result;
    }
}
