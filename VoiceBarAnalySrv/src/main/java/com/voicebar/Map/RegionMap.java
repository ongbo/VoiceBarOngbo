package com.voicebar.Map;

import com.voicebar.Entity.RegionInfo;
import com.voicebar.Util.HbaseUtil;
import com.voicebar.Util.MailUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.flink.api.common.functions.MapFunction;

public class RegionMap implements MapFunction<String, RegionInfo> {

    public RegionInfo map(String value) throws Exception {
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
        String userprovince = userinfos[7];//用户所在地区
        String registerTime = userinfos[8];//用户注册时间
        //
        String retiontype = MailUtil.getRegionBy(userprovince);
        System.out.println(userprovince+":"+retiontype);
        String tablename = "userflaginfo";
        String rowkey = userId;
        String familyname = "baseinfo";
        String column = "regionstatics";
        HbaseUtil.putdata(tablename,rowkey,familyname,column,retiontype);

        RegionInfo regionInfo = new RegionInfo();
        regionInfo.setCount(1L);
        regionInfo.setGroupfield("==region=="+retiontype);
        regionInfo.setRegionname(retiontype);
        return regionInfo;
    }
}
