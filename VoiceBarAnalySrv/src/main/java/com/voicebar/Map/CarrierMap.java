package com.voicebar.Map;

import com.voicebar.Entity.CarrierInfo;
import com.voicebar.Util.CarrierUtil;
import com.voicebar.Util.HbaseUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.flink.api.common.functions.MapFunction;

/**
 * 运营商Map函数
 * */
public class CarrierMap implements MapFunction<String, CarrierInfo> {
    public CarrierInfo map(String value) throws Exception {
       if(StringUtils.isBlank(value))
           return null;

        String[] userinfos = value.split(",");

        String userId = userinfos[0];
        String username = userinfos[1];
        String sex = userinfos[2];
        String telphone = userinfos[3];
        String email = userinfos[4];
        String age = userinfos[5];
        String registerTime = userinfos[6];
        String userprovince = userinfos[7];

        int carriertype = CarrierUtil.getCarrierByTel(telphone);
        String carriertypestring = carriertype==0?"未知运营商":carriertype==1?"移动用户":carriertype==2?"联通用户":"电信用户";

        String tablename = "userflaginfo";
        String rowkey = userId;
        String famliyname = "baseinfo";
        String colum = "carrierinfo";//运营商
        HbaseUtil.putdata(tablename,rowkey,famliyname,colum,carriertypestring);

        CarrierInfo carrierInfo = new CarrierInfo();
        String groupfield = "carrierInfo=="+carriertype;
        carrierInfo.setCount(1L);
        carrierInfo.setCarrier(carriertypestring);
        carrierInfo.setGroupfield(groupfield);
        return carrierInfo;
    }
}
