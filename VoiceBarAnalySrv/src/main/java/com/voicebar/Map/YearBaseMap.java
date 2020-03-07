package com.voicebar.Map;

import com.voicebar.Entity.YearBaseEntity;
import com.voicebar.Util.DataUtils;
import com.voicebar.Util.HbaseUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.flink.api.common.functions.MapFunction;



/*
* 年代标签Map方法
* */
public class YearBaseMap implements MapFunction<String, YearBaseEntity> {
    public YearBaseEntity map(String value) throws Exception {
       if(StringUtils.isBlank(value)){
           return null;
       }
       String[] userinfos = value.split(",");

       String userId = userinfos[0];
       String username = userinfos[1];
       String sex = userinfos[2];
       String telphone = userinfos[3];
       String email = userinfos[4];
       String age = userinfos[5];
       String registerTime = userinfos[6];
       String userprovince = userinfos[7];

       String yearbasetype = DataUtils.getYearbaseByAge(age);
       String tablename = "userflaginfo";
       String rowkey = userId;
       String familyname = "baseinfo";
       String column = "yearbase";

        HbaseUtil.putdata(tablename,rowkey,familyname,column,yearbasetype);
        YearBaseEntity yearBaseEntity = new YearBaseEntity();
        String groupfield = "yearbase=="+yearbasetype;
        yearBaseEntity.setYeartype(yearbasetype);
        yearBaseEntity.setCount(1L);
        yearBaseEntity.setGroupfield(groupfield);
        return yearBaseEntity;
    }
}
