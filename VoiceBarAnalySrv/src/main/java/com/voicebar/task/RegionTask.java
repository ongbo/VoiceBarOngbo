package com.voicebar.task;

import com.voicebar.Entity.RegionInfo;
import com.voicebar.Entity.YearBaseEntity;
import com.voicebar.Map.RegionMap;
import com.voicebar.Reduce.RegionReduce;
import com.voicebar.Util.MongoUtil;
import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.operators.MapOperator;
import org.apache.flink.api.java.operators.ReduceOperator;
import org.apache.flink.api.java.utils.ParameterTool;
import org.bson.Document;

import java.util.List;

public class RegionTask {
    public static void main(String[] args) {
        //获取参数
        final ParameterTool params = ParameterTool.fromArgs(args);

        //设置执行环境
        final ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();

        //是参数在Web接口里可用
        env.getConfig().setGlobalJobParameters(params);

        //获取输入的数据
        DataSet<String> text = env.readTextFile(params.get("input"));

        MapOperator<String, RegionInfo> mapresult = text.map(new RegionMap());
        ReduceOperator<RegionInfo> reduceresult = mapresult.groupBy("groupfield").reduce(new RegionReduce());
        try {
            List<RegionInfo> resultList = reduceresult.collect();
            for(RegionInfo regioninfo : resultList){
                String regionname= regioninfo.getRegionname();
                Long count = regioninfo.getCount();
                Document document = MongoUtil.findoneby("regionstatics","voiceportrait",regionname);
                if(document == null){
                    document = new Document();
                    document.put("info",regionname);
                    document.put("count",count);
                }else {
                    //如果里面已经有了，就更新
                    Long countpre = document.getLong("count");
                    Long total = countpre + count;
                    document.put("count",total);
                }
                MongoUtil.saveorupdatemongo("regionstatics","voiceportrait",document);


            }
            env.execute("Year Base Task");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
