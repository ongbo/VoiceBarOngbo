package com.voicebar.task;

import com.voicebar.Entity.YearBaseEntity;
import com.voicebar.Map.YearBaseMap;
import com.voicebar.Reduce.YearBaseReduce;
import com.voicebar.Util.MongoUtil;
import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.operators.MapOperator;
import org.apache.flink.api.java.utils.ParameterTool;
import org.bson.Document;

import java.util.List;

/*
* 年代标签：
50  年代：
60
70
80
90
00
10
统计每个群体的数量
* */
public class YearBaseTask {
    public static void main(String[] args) {
        //获取参数
        final ParameterTool params = ParameterTool.fromArgs(args);

        //设置执行环境
        final ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();

        //是参数在Web接口里可用
        env.getConfig().setGlobalJobParameters(params);

        //获取输入的数据
        DataSet<String> text = env.readTextFile(params.get("input"));
//        DataSet<String> text = env.readTextFile("/Users/ongbo/JarPackage/hadoop/hadoop-2.7.7/userinfoRegisterinfo.log");
        DataSet<YearBaseEntity> mapresult = text.map(new YearBaseMap());
        DataSet<YearBaseEntity> reduceresult = mapresult.groupBy("groupfield").reduce(new YearBaseReduce());
        try {
            List<YearBaseEntity> resultList = reduceresult.collect();
            for(YearBaseEntity yearBaseEntity : resultList){
                String yeartype = yearBaseEntity.getYeartype();
                Long count = yearBaseEntity.getCount();
                Document document = MongoUtil.findoneby("yearbasestatics","voiceportrait",yeartype);
                if(document == null){
                    document = new Document();
                    document.put("info",yeartype);
                    document.put("count",count);
                }else {
                    //如果里面已经有了，就更新
                    Long countpre = document.getLong("count");
                    Long total = countpre + count;
                    document.put("count",total);
                }
                MongoUtil.saveorupdatemongo("yearbasestatics","voiceportrait",document);


            }
            env.execute("Year Base Task");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
