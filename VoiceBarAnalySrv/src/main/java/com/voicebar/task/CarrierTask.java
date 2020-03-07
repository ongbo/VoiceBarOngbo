package com.voicebar.task;

import com.voicebar.Entity.CarrierInfo;
import com.voicebar.Map.CarrierMap;
import com.voicebar.Reduce.CarrierReduce;
import com.voicebar.Util.MongoUtil;
import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.utils.ParameterTool;
import org.bson.Document;

import java.util.List;

/**
 *
 * 运营商flink代码
 * */
public class CarrierTask {
    public static void main(String[] args) {
        final ParameterTool params = ParameterTool.fromArgs(args);

        // set up the execution environment
        final ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();

        // make parameters available in the web interface
        env.getConfig().setGlobalJobParameters(params);

        // get input data
        DataSet<String> text = env.readTextFile(params.get("input"));
        DataSet<CarrierInfo> mapresult = text.map(new CarrierMap());
        DataSet<CarrierInfo> reduceresult = mapresult.groupBy("groupfield").reduce(new CarrierReduce());

        List<CarrierInfo> resultlist = null;
        try {
            resultlist = reduceresult.collect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        /**
         * 保存不同运营商的群体数量->mongbo
         * */
        for(CarrierInfo carrierInfo : resultlist){
            String carrier = carrierInfo.getCarrier();
            Long count = carrierInfo.getCount();

            Document doc = MongoUtil.findoneby("carrierstatics","voiceportrait",carrier);
            if(doc == null){
                doc = new Document();
                doc.put("info",carrier);
                doc.put("count",count);
            }else{
                Long countpre = doc.getLong("count");
                Long total = countpre + count;
                doc.put("count",total);
            }
            MongoUtil.saveorupdatemongo("carrierstatics","voiceportrait",doc);
        }

        try {
            env.execute("Carrier Analize");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
