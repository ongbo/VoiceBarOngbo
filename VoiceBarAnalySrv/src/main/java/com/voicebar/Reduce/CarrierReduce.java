package com.voicebar.Reduce;

import com.voicebar.Entity.CarrierInfo;
import org.apache.flink.api.common.functions.ReduceFunction;

public class CarrierReduce implements ReduceFunction<CarrierInfo> {
    public CarrierInfo reduce(CarrierInfo value1, CarrierInfo value2) throws Exception {
        //先获取当前reduce的carrier
        String carrier = value1.getCarrier();
        Long count1 = value1.getCount();
        Long count2 = value2.getCount();

        CarrierInfo carrierInfofinal = new CarrierInfo();
        carrierInfofinal.setCarrier(carrier);
        carrierInfofinal.setCount(count1+count2);
        carrierInfofinal.setGroupfield(value1.getGroupfield());
        return carrierInfofinal;
    }
}
