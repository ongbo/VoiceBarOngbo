package com.voicebar.Util;

import com.alibaba.fastjson.JSONObject;

import java.util.Map;

public class test {
    public static void main(String[] args) {
        String getdata = null;
        System.out.println("get start");
        try {
            getdata = HbaseUtil.getdata("tablename", "1", "family", "name");
        } catch (Exception e) {
            e.printStackTrace();
        }
        Map<String,Long> mapdata = JSONObject.parseObject(getdata, Map.class);

        System.out.println("get end");
        System.out.println(getdata);
    }
}
