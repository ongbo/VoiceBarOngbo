package com.voicebar.task;

import com.voicebar.Entity.Point;
import com.voicebar.Entity.UserGroupINFOByReduce;
import com.voicebar.Map.KmeansFinalusergroupMap;
import com.voicebar.Map.UserGroupMap;
import com.voicebar.Map.UserGroupMapByReduce;
import com.voicebar.Reduce.UserGroupByKmeansReduce;
import com.voicebar.Reduce.UserGroupReduce;
import com.voicebar.Util.Cluster;
import com.voicebar.Util.KmeansRunByUserGroup;
import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.operators.GroupReduceOperator;
import org.apache.flink.api.java.operators.MapOperator;
import org.apache.flink.api.java.operators.ReduceOperator;
import org.apache.flink.api.java.utils.ParameterTool;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class UserGroupTask {
    public static void main(String[] args) {
        final ParameterTool params = ParameterTool.fromArgs(args);

        // set up the execution environment
        final ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();

        // make parameters available in the web interface
        env.getConfig().setGlobalJobParameters(params);

        // get input data
        DataSet<String> text = env.readTextFile(params.get("input"));

        MapOperator<String, UserGroupINFOByReduce> mapresult = text.map(new UserGroupMap());
        ReduceOperator<UserGroupINFOByReduce> reduceresult = mapresult.reduce(new UserGroupReduce());
        /**
         * 目前为止，已经将一个用户的所有的作品信息都收集到一起了。It's OK的。而且是分用户收集到一起了ArrayList
         * 然后需要对每个用户的作品计算维度向量
         * 构成Kmeans的维度信息，对于一些没必要的东西进行降维
         * */
        MapOperator<UserGroupINFOByReduce, UserGroupINFOByReduce> map = reduceresult.map(new UserGroupMapByReduce());
        GroupReduceOperator<UserGroupINFOByReduce, ArrayList<Point>> groupfield = map.groupBy("groupfield").reduceGroup(new UserGroupByKmeansReduce());
        try {
            List<ArrayList<Point>> resultlist = groupfield.collect();
            ArrayList<float[]> dataset = new ArrayList<float[]>();
            for(ArrayList<Point> array:resultlist){
                for(Point point:array){
                    dataset.add(point.getlocalArray());
                }
            }

            KmeansRunByUserGroup kMeansRunbyusergroup =new KmeansRunByUserGroup(6, dataset);

            Set<Cluster> clusterSet = kMeansRunbyusergroup.run();
            List<Point> finalClutercenter = new ArrayList<Point>();
            int count= 100;
            for(Cluster cluster:clusterSet){
                Point point = cluster.getCenter();
                point.setId(count++);
                finalClutercenter.add(point);
            }
//            DataSet<Point> flinalMap = map.map(new KmeansFinalusergroupMap(finalClutercenter));
            env.execute("UserGroupTask analy");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
