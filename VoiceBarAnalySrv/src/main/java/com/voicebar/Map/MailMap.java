package com.voicebar.Map;

import com.voicebar.Entity.mailInfo;
import com.voicebar.Util.HbaseUtil;
import com.voicebar.Util.MailUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.flink.api.common.functions.MapFunction;

public class MailMap implements MapFunction<String, mailInfo> {
    public mailInfo map(String value) throws Exception {
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

        String mailtype = MailUtil.getEmailtypeBy(email);

        String tablename = "userflaginfo";
        String rowkey = userId;
        String famliyname = "baseinfo";
        String colum = "emailinfo";//运营商

        //将邮箱类型保存到用户的数据结构里
        HbaseUtil.putdata(tablename, rowkey, famliyname, colum, mailtype);

        mailInfo mailInfo = new mailInfo();
        String groupfield = "emailInfo=="+mailtype;
        mailInfo.setEmailtype(mailtype);
        mailInfo.setCount(1L);
        mailInfo.setGroupfield(groupfield);
        return mailInfo;


    }
}
