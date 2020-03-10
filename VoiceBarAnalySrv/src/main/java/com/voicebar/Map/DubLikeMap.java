package com.voicebar.Map;

import com.alibaba.fastjson.JSONObject;
import com.voicebar.Entity.DubLike;
import com.voicebar.Entity.KafkaEvent;
import com.voicebar.Util.HbaseUtil;
import com.voicebar.Util.MapUtil;
import com.voicebar.log.ScanDubWork;
import org.apache.commons.lang.StringUtils;
import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.util.Collector;

import java.util.HashMap;
import java.util.Map;
/**
 *从kafka中读取一个String，但是那个string消息过来，会被flink先反序列化成KafkaEvent
 * 然后从KafkaEvent中分析数据
 * */
public class DubLikeMap implements FlatMapFunction<KafkaEvent, DubLike> {


    public void flatMap(KafkaEvent value, Collector<DubLike> out) throws Exception {
        /**
         * 获取kafkaevent的事件数据
         * 并且转成ScanDubWord对象
         * */
        String data = value.getWord();
        ScanDubWork scanDubWork = JSONObject.parseObject(data, ScanDubWork.class);
        System.out.println("###############获取到一个浏览作品数据>>>>>>>>>>>>>>>>>>"+scanDubWork);
        /**
         * 获取一个Work作品的基本信息
         * */
        int userid = scanDubWork.getUserid();
        int workid = scanDubWork.getWorkid();
        int materialid = scanDubWork.getMaterialid();
        String language = scanDubWork.getLanguage();
        String style = scanDubWork.getStyle();
        String theme = scanDubWork.getTheme();



        /**
         * 构建Hbase访问信息
         * 具体是在userflaginfo这个表下的userbehavior的用户行为列簇下的ScanWork浏览作品列下找到对应健userid的信息
         * */
        String tablename = "userflaginfo";
        String rowkey = userid+"";
        String familyname = "userbehavior";
        String column = "themelist";
        String mapdata = HbaseUtil.getdata(tablename, rowkey, familyname, column);

        System.out.println("####Hbase：userflaginfo：userbehavior：themelist>>>>>>>>>>>"+mapdata);
        Map<String ,Long> map = new HashMap<String,Long>();
        if(StringUtils.isNotBlank(mapdata)){
            map = JSONObject.parseObject(mapdata, Map.class);
        }
        String maxpretheme = MapUtil.getmaxLike(map);

        //获取当前 用户浏览theme的次数
        Long pretheme = map.get(theme);
        if(pretheme == null) pretheme = 0L;
        map.put(theme,pretheme+1);
        String fianlstring = JSONObject.toJSONString(map);
        HbaseUtil.putdata(tablename,rowkey,familyname,column,fianlstring);

        String maxtheme = MapUtil.getmaxLike(map);
        /**如果当前的最大theme和以前的最大theme数值一样大，而且不是同一个theme，那么还是取原来的那个*/
        if(StringUtils.isNotBlank(maxtheme)&&!maxpretheme.equals(maxtheme)){
            DubLike dubLike = new DubLike();
            dubLike.setDubid(Integer.valueOf(theme));
            dubLike.setCount(-1L);
            dubLike.setGroupbyfield("==themelike=="+maxpretheme);
            out.collect(dubLike);
        }
        DubLike dubLike = new DubLike();
        dubLike.setDubid(Integer.valueOf(maxtheme));
        dubLike.setCount(1L);
        out.collect(dubLike);
        dubLike.setGroupbyfield("==themelike=="+maxtheme);
        column = "themelike";
        /**更新当前用户的最喜欢的theme题材*/
        HbaseUtil.putdata(tablename,rowkey,familyname,column,maxtheme);




    }
}
