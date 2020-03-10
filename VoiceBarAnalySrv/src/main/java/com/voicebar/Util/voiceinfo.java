package com.voicebar.Util;

import java.util.HashMap;
import java.util.Map;

public class voiceinfo {
    public static Map<Integer,String> voicelanguage = new HashMap<Integer, String>(){
        {
            put(0,"中文");
            put(1,"英语");
            put(2,"日语");
            put(3,"德语");
            put(4,"韩语");
            put(5,"法语");
            put(6,"泰语");
            put(7,"俄语");
            put(8,"西班牙语");
            put(9,"阿拉伯语");
            put(10,"意大利语");
            put(11,"葡萄牙语");
            put(12,"马来西亚语");
            put(13,"其他小语种");

        }
    };
    public static Map<Integer,String> voicetheme = new HashMap<Integer,String>(){
        {
            put(0,"专题配音");
            put(1,"广告配音");
            put(2,"课件多媒体配音");
            put(3,"游戏配音");
            put(4,"动漫配音");
            put(5,"旁白配音");
            put(6,"歌曲配音");
            put(7,"小说配音");
            put(8,"电影配音");
            put(9,"方言配音");
            put(10,"说唱配音");
            put(11,"舞台剧配音");
            put(12,"场会配音");
            put(13,"仿生配音");


        }
    };
    public static Map<Integer,String> voicestyle = new HashMap<Integer,String>(){
        {
            put(0,"嘹亮浑厚");
            put(1,"可爱声");
            put(2,"多变声");
            put(3,"磁性");
            put(4,"回音");
            put(5,"低沉");
            put(6,"甜美");
            put(7,"温柔");
            put(8,"知性");
            put(9,"品质");
            put(10,"干脆利落");
            put(11,"大气");
            put(12,"搞怪");
            put(13,"喜悦");
            put(13,"无厘头");
            put(13,"欢快");
            put(13,"时尚");


        }
    };
}
