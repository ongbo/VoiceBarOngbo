package com.voicebar.task;

import com.voicebar.Entity.mailInfo;
import com.voicebar.Map.MailMap;
import com.voicebar.Reduce.MailReduce;
import com.voicebar.Util.MongoUtil;
import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.utils.ParameterTool;
import org.bson.Document;

import java.util.List;

public class MailTask {
    public static void main(String[] args) {
        final ParameterTool params = ParameterTool.fromArgs(args);

        // set up the execution environment
        final ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();

        // make parameters available in the web interface
        env.getConfig().setGlobalJobParameters(params);

        // get input data
        DataSet<String> text = env.readTextFile(params.get("input"));

        DataSet<mailInfo> mapresult =  text.map(new MailMap());
        DataSet<mailInfo> reduceresult = mapresult.groupBy("groupfield").reduce(new MailReduce());

        try {
            List<mailInfo> resultlist = reduceresult.collect();
            for(mailInfo mailInfo : resultlist){
                String mailtype = mailInfo.getEmailtype();
                Long count = mailInfo.getCount();

                Document doc = MongoUtil.findoneby("emailstatics","voiceportrait",mailtype);
                if(doc == null){
                    doc = new Document();
                    doc.put("info",mailtype);
                    doc.put("count",count);
                }else{
                    Long countpre = mailInfo.getCount();
                    Long total = count+countpre;
                    doc.put("count",total);
                }
                MongoUtil.saveorupdatemongo("emailstatics","voiceportrait",doc);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            env.execute("Mail Analize");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
