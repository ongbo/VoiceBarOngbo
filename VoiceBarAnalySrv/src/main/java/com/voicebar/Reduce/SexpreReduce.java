package com.voicebar.Reduce;

import com.voicebar.Entity.CreateDataSet;
import com.voicebar.Entity.SexPreInfo;
import com.voicebar.Util.LR;
import org.apache.flink.api.common.functions.GroupReduceFunction;
import org.apache.flink.util.Collector;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * private int userid;
 *     private int worknum;
 *     private int workfre;
 *     private int manDubWorknum;
 *     private int womanDubWorknum;
 *     private int workDayfre;
 *     private int label;
 * */
public class SexpreReduce implements GroupReduceFunction<SexPreInfo, ArrayList<Double>> {
    public void reduce(Iterable<SexPreInfo> values, Collector<ArrayList<Double>> out) throws Exception {
        Iterator<SexPreInfo> iterator = values.iterator();
        CreateDataSet trainingSet = new CreateDataSet();
        while(iterator.hasNext()){
            SexPreInfo sexPreInfo = iterator.next();
            int userid = sexPreInfo.getUserid();
            int worknum = sexPreInfo.getWorknum();
            int workfre = sexPreInfo.getWorkfre();
            int manDubWorknum = sexPreInfo.getManDubWorknum();
            int womanDubWorknum = sexPreInfo.getWomanDubWorknum();
            int workDayfre = sexPreInfo.getWorkDayfre();
            int label = sexPreInfo.getLabel();

            ArrayList<String> as = new ArrayList<String>();
            as.add(worknum+"");
            as.add(workfre+"");
            as.add(manDubWorknum+"");
            as.add(womanDubWorknum+"");
            as.add(workDayfre+"");
            as.add(label+"");

            trainingSet.getData().add(as);
            trainingSet.getLabels().add(label+"");
        }
        /**
         * 将构造好的数据放到已经写好的flink逻辑回归实现里面去计算
         * */
        ArrayList<Double> weights = new ArrayList<Double>();
        weights = LR.gradAscent1(trainingSet,trainingSet.getLabels(),500);
        out.collect(weights);
    }
}
