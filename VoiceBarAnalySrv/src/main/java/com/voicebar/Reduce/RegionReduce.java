package com.voicebar.Reduce;

import com.voicebar.Entity.RegionInfo;
import org.apache.flink.api.common.functions.ReduceFunction;

public class RegionReduce implements ReduceFunction<RegionInfo> {
    public RegionInfo reduce(RegionInfo value1, RegionInfo value2) throws Exception {
       RegionInfo regionInfo = new RegionInfo();
       regionInfo.setRegionname(value1.getRegionname());
       regionInfo.setCount(value1.getCount()+value2.getCount());
       regionInfo.setGroupfield(value1.getGroupfield());
       return regionInfo;
    }
}
