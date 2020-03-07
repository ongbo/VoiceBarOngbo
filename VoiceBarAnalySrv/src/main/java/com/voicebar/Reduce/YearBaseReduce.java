package com.voicebar.Reduce;

import com.voicebar.Entity.YearBaseEntity;
import org.apache.flink.api.common.functions.ReduceFunction;

public class YearBaseReduce implements ReduceFunction<YearBaseEntity> {

    public YearBaseEntity reduce(YearBaseEntity value1, YearBaseEntity value2) throws Exception {
        String yeartype = value1.getYeartype();
        Long count1 = value1.getCount();
        Long count2 = value2.getCount();

        YearBaseEntity finalyyearBase = new YearBaseEntity();
        finalyyearBase.setCount(count1+count2);
        finalyyearBase.setYeartype(yeartype);
        return finalyyearBase;
    }
}
