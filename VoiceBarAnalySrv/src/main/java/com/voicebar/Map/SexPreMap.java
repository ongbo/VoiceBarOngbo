package com.voicebar.Map;

import com.voicebar.Entity.SexPreInfo;
import org.apache.flink.api.common.functions.MapFunction;

import java.util.Random;
/**
 *
 * private int userid;
 *     private int worknum;
 *     private int workfre;
 *     private int manDubWorknum;
 *     private int womanDubWorknum;
 *     private int workDayfre;
 *     private int label;
 * */
public class SexPreMap implements MapFunction<String, SexPreInfo> {
    public SexPreInfo map(String value) throws Exception {
       String[] temps = value.split(",");
       Random random = new Random();

       int userid = Integer.valueOf(temps[0]);
       int worknum = Integer.valueOf(temps[1]);
       int workfre = Integer.valueOf(temps[2]);
       int manDubWorknum = Integer.valueOf(temps[3]);
       int womanDubWorknum = Integer.valueOf(temps[4]);
       int workDayfre = Integer.valueOf(temps[5]);
       int label = Integer.valueOf(temps[6]);

       String groupfield = "sexpre=="+random.nextInt(10);
       SexPreInfo sexPreInfo = new SexPreInfo();
       sexPreInfo.setUserid(userid);
       sexPreInfo.setWorknum(worknum);
       sexPreInfo.setWorkfre(workfre);
       sexPreInfo.setManDubWorknum(manDubWorknum);
       sexPreInfo.setWomanDubWorknum(womanDubWorknum);
       sexPreInfo.setWorkDayfre(workDayfre);
       sexPreInfo.setLabel(label);

       return sexPreInfo;
    }
}
