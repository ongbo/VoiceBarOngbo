package com.voicebar.task;

import com.voicebar.Entity.SexPreInfo;
import com.voicebar.Map.SexPreMap;
import com.voicebar.Reduce.SexpreReduce;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.operators.DataSource;
import org.apache.flink.api.java.operators.GroupReduceOperator;
import org.apache.flink.api.java.operators.MapOperator;
import org.apache.flink.api.java.utils.ParameterTool;

import java.util.*;

public class SexPreTask  {
    public static void main(String[] args) {
        final ParameterTool params = ParameterTool.fromArgs(args);
        ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();
        env.getConfig().setGlobalJobParameters(params);

        DataSource<String> text = env.readTextFile(params.get("input"));
        MapOperator<String, SexPreInfo> map = text.map(new SexPreMap());
        GroupReduceOperator<SexPreInfo, ArrayList<Double>> reduceresult = map.groupBy("groupfield").reduceGroup(new SexpreReduce());


        try {
            //将训练好的权值转为List，这里list里面有很多组权值，我们要选一个最好的，误差最小的
            List<ArrayList<Double>> reusltlist = reduceresult.collect();
            int groupsize  = reusltlist.size();
            Map<Integer,Double> summap = new TreeMap<Integer,Double>(new Comparator<Integer>() {

                public int compare(Integer o1, Integer o2) {
                    return o1.compareTo(o2);
                }
            });
            for(ArrayList<Double> array:reusltlist){

                for(int i=0;i<array.size();i++){
                    double pre = summap.get(i)==null?0d:summap.get(i);
                    summap.put(i,pre+array.get(i));
                }
            }
            ArrayList<Double> finalweight = new ArrayList<Double>();
            Set<Map.Entry<Integer,Double>> set = summap.entrySet();
//            将所有权值/groupsize
            for(Map.Entry<Integer,Double> mapentry :set){
                Integer key = mapentry.getKey();
                Double sumvalue = mapentry.getValue();
                double finalvalue = sumvalue/groupsize;
                finalweight.add(finalvalue);
            }
            env.execute("LogicTask analy");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
