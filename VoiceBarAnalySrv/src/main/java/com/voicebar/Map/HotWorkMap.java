package com.voicebar.Map;

import com.alibaba.fastjson.JSONObject;
import com.voicebar.Entity.HotworkEntity;
import com.voicebar.Entity.KafkaEvent;
import com.voicebar.log.CollectionDubWork;
import com.voicebar.log.LikeDubWork;
import com.voicebar.log.ScanDubWork;
import com.voicebar.log.TrendDubWork;
import org.apache.flink.api.common.functions.MapFunction;

public class HotWorkMap implements MapFunction<KafkaEvent, HotworkEntity> {
    public HotworkEntity map(KafkaEvent value) throws Exception {
        String word = value.getWord();
        String topic = value.getTopic();
        /**
         * CollectionDubMaterial:收藏素材
         *  * CollectionDubWork：收藏作品
         *  * DubMaterial：发布作品
         *  * LikeDubWork：点赞作品
         *  * ScanDubMaterial：浏览素材
         *  * ScanDubWork：浏览作品
         *  * TrendDubMaterial：转发素材
         *  * TrendDubWork：转发作品
         * */
        HotworkEntity hotworkEntity = new HotworkEntity();
        hotworkEntity.setCollectionnums(0L);
        hotworkEntity.setLikenums(0L);
        hotworkEntity.setScannums(0L);
        hotworkEntity.setTrendnums(0L);
        if(topic.equals("CollectionDubWork")){
            CollectionDubWork collectionDubWork = JSONObject.parseObject(word,CollectionDubWork.class);
            hotworkEntity.setWorkid(collectionDubWork.getWordid());
            hotworkEntity.setCollectionnums(1L);
        }else if(topic.equals("LikeDubWork")){
            LikeDubWork likeDubWork = JSONObject.parseObject(word,LikeDubWork.class);
            hotworkEntity.setWorkid(likeDubWork.getWorkid());
            hotworkEntity.setLikenums(1L);
        }else if(topic.equals("ScanDubWork")){
            ScanDubWork scanDubWork = JSONObject.parseObject(word,ScanDubWork.class);
            hotworkEntity.setWorkid(scanDubWork.getWorkid());
            hotworkEntity.setScannums(1L);
        }else if(topic.equals("TrendDubWork")){
            TrendDubWork trendDubWork = JSONObject.parseObject(word,TrendDubWork.class);
            hotworkEntity.setWorkid(trendDubWork.getWordid());
            hotworkEntity.setTrendnums(1L);
        }
        return hotworkEntity;
    }
}
