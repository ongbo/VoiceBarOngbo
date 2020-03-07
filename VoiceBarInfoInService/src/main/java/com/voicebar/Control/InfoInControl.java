package com.voicebar.Control;


import com.alibaba.fastjson.JSONObject;
import com.voicebar.entity.ResultMessage;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("infolog")
public class InfoInControl {


    @RequestMapping(value = "helloworld",method = RequestMethod.GET)
    public String helloword(HttpServletRequest req){
        String ip = req.getRemoteAddr();
        ResultMessage resultMessage = new ResultMessage();
        resultMessage.setMessage("hello:"+ip);
        resultMessage.setStatus("success");
        String result = JSONObject.toJSONString(resultMessage);
        return result;
    }


}
