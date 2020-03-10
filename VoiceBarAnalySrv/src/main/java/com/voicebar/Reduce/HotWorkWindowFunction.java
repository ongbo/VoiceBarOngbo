package com.voicebar.Reduce;

import com.voicebar.Entity.HotwindowEntity;
import com.voicebar.Entity.HotworkEntity;
import org.apache.flink.api.java.tuple.Tuple;
import org.apache.flink.streaming.api.functions.windowing.WindowFunction;
import org.apache.flink.streaming.api.windowing.windows.TimeWindow;
import org.apache.flink.util.Collector;

public class HotWorkWindowFunction implements WindowFunction<HotworkEntity, HotworkEntity, Tuple, TimeWindow> {
    public void apply(Tuple integer, TimeWindow window, Iterable<HotworkEntity> input, Collector<HotworkEntity> out) throws Exception {
        HotworkEntity next = input.iterator().next();
        Double weight = next.getScannums()*0.1+next.getLikenums()*0.2+next.getCollectionnums()*0.3+next.getTrendnums()*0.4;
        out.collect(new HotworkEntity(next.getWorkid(),next.getScannums(),next.getLikenums(),next.getCollectionnums(),
                next.getTrendnums(),weight,window.getEnd()));
    }
}
