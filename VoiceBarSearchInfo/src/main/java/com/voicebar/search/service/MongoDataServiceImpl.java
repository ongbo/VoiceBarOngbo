package com.voicebar.search.service;

import com.alibaba.fastjson.JSONObject;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.voicebar.entity.AnalyResult;
import com.voicebar.search.base.BaseMongo;
import org.bson.Document;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Service
public class MongoDataServiceImpl extends BaseMongo {

    /**
     * 查询database数据库下的名为tablename的数据维度表
     * */
    public List<AnalyResult> listMongoInfoby(String database,String tablename){
        List<AnalyResult> result = new ArrayList<AnalyResult>();
        /**获取mongodb数据库和对应表*/
        MongoDatabase db = mongoClient.getDatabase(database);
        MongoCollection<Document> collection = db.getCollection(tablename);

        /**
         *
         * */
        Document groupFields = new Document();
        Document idFields = new Document();
        idFields.put("info","$info");
        groupFields.put("_id",idFields);
        groupFields.put("count",new Document("$sum","$count"));

        Document group = new Document("$group",groupFields);

        Document projectFields = new Document();
        projectFields.put("_id",false);
        projectFields.put("info","$_id.info");
        projectFields.put("count",true);
        Document project = new Document("$project",projectFields);
        AggregateIterable<Document> iterater = collection.aggregate(
                (List<Document>) Arrays.asList(group, project)
        );

        MongoCursor<Document> cursor = iterater.iterator();
        while(cursor.hasNext()){
            Document document = cursor.next();
            String jsonString = JSONObject.toJSONString(document);
            AnalyResult brandUser = JSONObject.parseObject(jsonString,AnalyResult.class);
            result.add(brandUser);
        }
        return result;
    }
}
