package com.voicebar.Reduce;

import com.voicebar.Entity.HotworkEntity;
import org.apache.flink.api.common.functions.AggregateFunction;
import org.apache.flink.api.common.functions.ReduceFunction;

import java.util.Map;

public class HotWorkAggregate implements AggregateFunction<HotworkEntity,HotworkEntity,HotworkEntity> {

    public HotworkEntity createAccumulator() {
        HotworkEntity hotworkEntity = new HotworkEntity();
        hotworkEntity.setTrendnums(0L);
        hotworkEntity.setScannums(0L);
        hotworkEntity.setLikenums(0L);
        hotworkEntity.setCollectionnums(0L);
        return hotworkEntity;
    }

    public HotworkEntity add(HotworkEntity value, HotworkEntity accumulator) {
        accumulator.setWorkid(value.getWorkid());
        accumulator.setTrendnums(value.getTrendnums()+accumulator.getTrendnums());
        accumulator.setLikenums(value.getLikenums()+accumulator.getLikenums());
        accumulator.setCollectionnums(value.getCollectionnums()+accumulator.getLikenums());
        accumulator.setScannums(value.getScannums()+accumulator.getScannums());
        return accumulator;
    }

    public HotworkEntity getResult(HotworkEntity accumulator) {
        return accumulator;
    }

    public HotworkEntity merge(HotworkEntity a, HotworkEntity b) {
        HotworkEntity hotworkEntity = new HotworkEntity(
                a.getScannums()+b.getScannums(),
                a.getLikenums()+b.getLikenums(),
                a.getCollectionnums()+b.getCollectionnums(),
                a.getTrendnums()+b.getTrendnums()
        );
        hotworkEntity.setWorkid(a.getWorkid());
        return hotworkEntity;
    }


}
