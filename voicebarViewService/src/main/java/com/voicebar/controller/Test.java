package com.voicebar.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("test")
public class Test {
    @RequestMapping(value = "helloworld",method = RequestMethod.GET)
    public String hellowolrd(HttpServletRequest req){
        String ip =req.getRemoteAddr();
        System.out.println("ha");
        String result = "hello world from "+ ip;
        return result;
    }
}
