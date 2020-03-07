package com.voicebar.Reduce;

import com.voicebar.Entity.mailInfo;
import org.apache.flink.api.common.functions.ReduceFunction;

public class MailReduce implements ReduceFunction<mailInfo> {
    public mailInfo reduce(mailInfo value1, mailInfo value2) throws Exception {
       String mailtype = value1.getEmailtype();
       Long count1 = value1.getCount();
       Long count2 = value2.getCount();

       mailInfo mailInfo = new mailInfo();
       mailInfo.setEmailtype(mailtype);
       mailInfo.setCount(count1+count2);
       return mailInfo;
    }
}
