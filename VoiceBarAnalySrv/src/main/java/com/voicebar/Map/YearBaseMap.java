package com.voicebar.Map;

import com.voicebar.Entity.YearBaseEntity;
import com.voicebar.Util.DataUtils;
import com.voicebar.Util.HbaseUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.flink.api.common.functions.MapFunction;



/**
* 年代标签Map方法
 * 过来的是用户信息日志
 用户信息表：
 0：用户ID：userid
 1：用户名：username
 2：密码：password
 3：性别：sex
 4：手机号：phonenumber
 5：邮箱：mail
 6：年龄：age
 7：省份：province
 8：注册时间：registtime
* * */
public class YearBaseMap implements MapFunction<String, YearBaseEntity> {
    public YearBaseEntity map(String value) throws Exception {
       if(StringUtils.isBlank(value)){
           return null;
       }
       String[] userinfos = value.split(",");

        String userId = userinfos[0];//用户id
       String username = userinfos[1];//用户名
       String sex = userinfos[3];//用户性别
       String telphone = userinfos[4];//用户手机号
       String email = userinfos[5];//用户邮箱
       String age = userinfos[6];//用户年龄
       String registerTime = userinfos[7];//用户注册时间
       String userprovince = userinfos[8];//用户所在地区

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
        if(yearbasetype!=null) System.out.println(userId + " " +yearbasetype); else System.out.println(userId + " null ");
        yearBaseEntity.setGroupfield(groupfield);
        return yearBaseEntity;
    }
}
