package com.voicebar.Util;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

/**
* Hbase操作工具类
*

 */
public class HbaseUtil {
    private static Admin admin = null;
    private static Connection conn = null;

    static {
        //创建hbase配置对象
        Configuration conf = HBaseConfiguration.create();
        conf.set("hbase.rootdir","hdfs://114.116.206.19:5009/hbase");
        conf.set("hbase.zookeeper.quorum","114.116.196.252:5000,114.116.196.252:5003,114.116.196.252:5006");
        conf.set("hbase.client.scanner.timeout.period", "600000");
        conf.set("hbase.rpc.timeout", "600000");
        try {
            conn = ConnectionFactory.createConnection(conf);
            admin = conn.getAdmin();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
    * 插入数据：create "userflaginfo","baseinfo"
    *
    * */
    public static void put(String tablename, String rowkey, String familyname, Map<String,String> datamap){
        Table table = null;
        try {
            table = conn.getTable(TableName.valueOf(tablename));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //将字符串转换成byte[]
        byte[] rowkeybyte = Bytes.toBytes(rowkey);
        Put put = new Put(rowkeybyte);
        if(datamap != null){
            Set<Map.Entry<String,String>> set = datamap.entrySet();
            for(Map.Entry<String,String> entry : set){
                String key = entry.getKey();
                Object value = entry.getValue();
                put.addColumn(Bytes.toBytes(familyname), Bytes.toBytes(key), Bytes.toBytes(value+""));
            }
        }
        try {
            table.put(put);
            table.close();
            System.out.println("Hbase>>>> This data had been put successful");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Hbase>>>> This data had been put Fail！！！！");
        }

    }

    /**
    * 获取数据
    * */
    public static String getdata(String tablename, String rowkey, String famliyname,String colum) throws Exception {
        Table table = conn.getTable(TableName.valueOf(tablename));
        // 将字符串转换成byte[]
        byte[] rowkeybyte = Bytes.toBytes(rowkey);
        Get get = new Get(rowkeybyte);
        Result result =table.get(get);
        byte[] resultbytes = result.getValue(famliyname.getBytes(),colum.getBytes());
        if(resultbytes == null){
            System.out.println("Hbase>>>>>> This data get null");
            return null;
        }
        System.out.println("Hbase>>>>>> This data get successful!!!!");
        return new String(resultbytes);
    }

    /**
     *创建数据
     */
    public static void putdata(String tablename, String rowkey, String famliyname,String colum,String data) throws Exception {
        Table table = conn.getTable(TableName.valueOf(tablename));
        Put put = new Put(rowkey.getBytes());
        put.addColumn(famliyname.getBytes(),colum.getBytes(),data.getBytes());
        table.put(put);
    }

    public static void main(String[] args) {

    }
}

