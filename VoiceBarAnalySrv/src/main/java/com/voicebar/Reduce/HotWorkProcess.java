package com.voicebar.Reduce;

import com.voicebar.Entity.HotwindowEntity;
import com.voicebar.Entity.HotworkEntity;
import org.apache.flink.api.common.state.ListState;
import org.apache.flink.api.common.state.ListStateDescriptor;
import org.apache.flink.api.java.tuple.Tuple;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.functions.KeyedProcessFunction;
import org.apache.flink.util.Collector;
import scala.Function1;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HotWorkProcess extends KeyedProcessFunction<Tuple, HotworkEntity,HotworkEntity> {

    private ListState<HotworkEntity> itemState = null;

    @Override
    public void open(Configuration parameters) throws Exception {
        itemState = getRuntimeContext().getListState(new ListStateDescriptor<HotworkEntity>("itemstate",HotworkEntity.class));
    }

    public void processElement(HotworkEntity value, Context ctx, Collector<HotworkEntity> out) throws Exception {
        itemState.add(value);
        //注册一个定时器
        ctx.timerService().registerEventTimeTimer(value.getWindowend()+1);
    }
    /**定时器触发，对所有的数据进行排序*/
    @Override
    public void onTimer(long timestamp, OnTimerContext ctx, Collector<HotworkEntity> out) throws Exception {
       /**将所有state中的数据取出，放到一个listbuffer中*/
        List<HotworkEntity> itembuffer = new ArrayList<HotworkEntity>();
        for(HotworkEntity hotwindowEntity : itemState.get()){
            itembuffer.add(hotwindowEntity);
        }
        Collections.sort(itembuffer);
        itemState.clear();
        /**格式化输出排名结果,取前10个*/
        int i=0;
        for(HotworkEntity hotworkEntity : itembuffer){
            out.collect(hotworkEntity);
            i++;
            if(i>=10) break;
        }



    }
}
