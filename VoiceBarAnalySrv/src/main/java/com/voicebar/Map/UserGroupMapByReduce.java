package com.voicebar.Map;

import com.voicebar.Entity.UserGroupINFOByReduce;
import com.voicebar.Entity.UserGroupInfo;
import org.apache.flink.api.common.functions.MapFunction;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 这个map里面，要填充每个用户的UserGroupINFOByReduce的其他字段信息
 * 因为经过了上一个MapReduce过程，还只是在UserGroupINFOByReduce里面有这个作品信息
 * 其他的内容还没有填充进去
 *     private String userid;
 *     private List<UserGroupInfo> list;//保存这个用户所有的作品信息
 *     private double avramout;//平均得分
 *     private double maxamout;//最高得分
 *     private int days;//单日消费频次
 *     private List<Integer> worktheme;//保存作品类型
 *     private List<Long> worknums;//保存worktheme作品类型对应的数量
 *     private List<Long> workTimenums;//保存在某个时间点的作品数量。上午（7-12），下午（12-7），晚上（7-12），凌晨（0-7）
 *     private String groupfield;
 * */
public class UserGroupMapByReduce implements MapFunction<UserGroupINFOByReduce,UserGroupINFOByReduce> {
    public UserGroupINFOByReduce map(UserGroupINFOByReduce value) throws Exception {
        List<UserGroupInfo> list = value.getList();

        /**
         * 排序
         * 按照作品发布时间进行排序
         * */
        Collections.sort(list, new Comparator<UserGroupInfo>() {
            public int compare(UserGroupInfo o1, UserGroupInfo o2) {
               String timeo1 = o1.getWorktime();
               String timeo2 = o2.getWorktime();
               DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd hhmmss");
               Date datanow = new Date();
               Date date1 = datanow;
               Date date2 = datanow;
                try {
                    date1 = dateFormat.parse(timeo1);
                    date2 = dateFormat.parse(timeo2);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                return date1.compareTo(date2);
            }
        });

        /**
         * 算出最大作品评分和系统总评分，平均评分
         * */
        double totalscore = 0l;//总评分
        double maxscore = Double.MIN_VALUE;//最大评分
        Map<Integer, Integer> frequencymap = new HashMap<Integer, Integer>();//发布作品的频次
        UserGroupINFOByReduce userGroupINFOByReduce = null;

        Map<String , Long> DubworkThememap = new HashMap<String, Long>();//作品的类别theme
        Map<Integer,Long> timeMap = new HashMap<Integer, Long>();//时间Map
        timeMap.put(1,0l);
        timeMap.put(2,0l);
        timeMap.put(3,0l);
        timeMap.put(4,0l);

        /**
         * 遍历这个用户的作品list
         * */
        for(UserGroupInfo userGroupInfo : list){
            totalscore += Double.valueOf(userGroupInfo.getWorkscore());
            if(totalscore > maxscore) maxscore = totalscore;


            /**
             * 计算作品的类别-题材
             * 这里题材都是以ID表示
             * */
            String worktheme = userGroupInfo.getTheme();
            Long pre = DubworkThememap.get(worktheme);
            if(pre == null){
                DubworkThememap.put(worktheme,1);
            }else {
                DubworkThememap.put(worktheme,pre+1);
            }

            /**
             * 计算时间段的作品次数
             * 上午（7-12）1，下午（12-7）2，晚上（7-12）3，凌晨（0-7）4
             * */
            String time = userGroupInfo.getWorktime();


//            if(userGroupINFOByReduce == null) {
//                userGroupINFOByReduce = userGroupInfo;
//                continue;
//            }

            /**
             * 计算购买的频率
             * */


        }


    }
}
