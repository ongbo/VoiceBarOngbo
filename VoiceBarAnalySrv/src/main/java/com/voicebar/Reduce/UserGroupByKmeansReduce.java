package com.voicebar.Reduce;

import com.voicebar.Entity.Point;
import com.voicebar.Entity.UserGroupINFOByReduce;
import com.voicebar.Entity.UserGroupInfo;
import com.voicebar.Util.Cluster;
import com.voicebar.Util.KmeansRunByUserGroup;
import org.apache.flink.api.common.functions.GroupReduceFunction;
import org.apache.flink.util.Collector;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

public class UserGroupByKmeansReduce implements GroupReduceFunction<UserGroupINFOByReduce, ArrayList<Point>> {
    public void reduce(Iterable<UserGroupINFOByReduce> values, Collector<ArrayList<Point>> out) throws Exception {
        /**
         * 重写GroupReduceFunction方法就是将同一group的所有信息都过来了
         * */
        Iterator<UserGroupINFOByReduce> iterator = values.iterator();
        ArrayList<float[]> dataSet = new ArrayList<float[]>();
        while(iterator.hasNext()){
            UserGroupINFOByReduce userGroupINFOByReduce = iterator.next();
            /**构造一个float维度变量即可了*/
            /**
             * UserGroupInfoByReduce的原始信息
             *     private String userid;
             *     private List<UserGroupInfo> list;//保存这个用户所有的作品信息
             *     private double avramout;//平均得分
             *     private double maxamout;//最高得分
             *     private int days;//单日消费频次
             *     private List<Integer> worktheme;//保存作品类型
             *     private List<Integer> worknums;//保存worktheme作品类型对应的数量
             *     private List<Long> workTimenums;//保存在某个时间点的作品数量。上午（7-12），下午（12-7），晚上（7-12），凌晨（0-7）
             *     private String groupfield;
             *
             * 但是这里要注意的是，我们的这些原始信息会有一些list值，kmeans是计算不了这些值的
             * 所以需要拆分。
             * 而且哪个作品的
             *我们这里的维度比较就是
             * 需要提取成的float[]信息：
             *在前面的操作中一定要规范格式
             * */
            int len = 0;
            float[] kmeansarray = new float[len];
            dataSet.add(kmeansarray);

        }
        KmeansRunByUserGroup kmeansRunByUserGroup = new KmeansRunByUserGroup(6,dataSet);
        Set<Cluster> clusterSet = kmeansRunByUserGroup.run();
        ArrayList<Point> arrayList = new ArrayList<Point>();
        for(Cluster cluster:clusterSet){
            arrayList.add(cluster.getCenter());
        }
        /**
         * 将每个簇放在了arraylist里面，然后写出去
         * */
        out.collect(arrayList);

    }
}
