package com.voicebar.Util;

import java.util.*;

/**
 *
 *
 * */

public class MapUtil {

    /**
     * 对传过来的Map对象oriMap排序
     * 返回LinkedHashMap，从而对元素排序。
     * */
    public static LinkedHashMap<String, Double> sortMapByValue(Map<String,Double> oriMap){
        if(oriMap == null || oriMap.isEmpty()){
            return null;
        }

        LinkedHashMap<String,Double> sortedMap = new LinkedHashMap<String, Double>();
        List<Map.Entry<String, Double>> entryList = new ArrayList<Map.Entry<String, Double>>(
                oriMap.entrySet());
        Iterator<Map.Entry<String, Double>> iter = entryList.iterator();
        Map.Entry<String, Double> tmpEntry = null;
        while (iter.hasNext()) {
            tmpEntry = iter.next();
            sortedMap.put(tmpEntry.getKey(), tmpEntry.getValue());
        }
        return sortedMap;

    }

//    public static String getmaxLike(Map<String , Long>){
//
//    }
    static class MapValueComparator implements Comparator<Map.Entry<String, Double>> {

        @Override
        public int compare(Map.Entry<String, Double> me1, Map.Entry<String, Double> me2) {

            return me1.getValue().compareTo(me2.getValue());
        }
    }
}
