package com.voicebar.Sink;

import com.voicebar.Entity.DubLike;
import com.voicebar.Util.MongoUtil;
import com.voicebar.Util.voiceinfo;
import org.apache.flink.streaming.api.functions.sink.SinkFunction;
import org.bson.Document;

public class ThemeLikeSink implements SinkFunction<DubLike> {
    public String tablename;
    public String database;
    public ThemeLikeSink(String tablename, String database){
        this.tablename = tablename;
        this.database = database;
    }
    public void invoke(DubLike value, Context context) throws Exception {
        String theme = voiceinfo.voicetheme.get(value.getDubid());
        Long count = value.getCount();
        Document doc = MongoUtil.findoneby(tablename,database, theme);
        if(doc == null){
            /**说明mongdb还没有这个消息*/
            doc = new Document();
            doc.put("info",theme);
            doc.put("count",count);
        }else{
            Long countpre = doc.getLong("count");
            Long total = countpre + count;
            doc.put("count",total);
        }
        MongoUtil.saveorupdatemongo("themelikestatics","voiceportrait",doc);
    }
}
