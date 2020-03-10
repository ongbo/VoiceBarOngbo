package com.voicebar.Reduce;

import com.voicebar.Entity.DubLike;
import org.apache.flink.api.common.functions.ReduceFunction;

public class DubLikeStyleReduce implements ReduceFunction<DubLike> {
    public DubLike reduce(DubLike value1, DubLike value2) throws Exception {
        Integer theme = value1.getDubid();
        Long count1 = value2.getCount();
        Long count2 = value2.getCount();
        DubLike finaldublike = new DubLike();
        finaldublike.setDubid(theme);
        finaldublike.setCount(count1+count2);
        return finaldublike;
    }
}
