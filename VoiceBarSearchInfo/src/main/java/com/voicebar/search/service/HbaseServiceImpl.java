package com.voicebar.search.service;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class HbaseServiceImpl {
    private static Admin admin = null;
    private static Connection conn = null;

    static{
        Configuration configuration = HBaseConfiguration.create();
        configuration.set("hbase.rootdir","hdfs://114.116.206.19:5009/hbase");
        configuration.set("hbase.zookeeper.quorum","114.116.196.252:5000,114.116.196.252:5003,114.116.196.252:5006");
        configuration.set("hbase.client.scanner.timeout.period", "600000");
        configuration.set("hbase.rpc.timeout", "600000");
        try {
            conn = ConnectionFactory.createConnection(configuration);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            admin = conn.getAdmin();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String getdata(String tablename, String rowkey, String famliyname,String colum) throws Exception {
        Table table = conn.getTable(TableName.valueOf(tablename));
        // 将字符串转换成byte[]
        byte[] rowkeybyte = Bytes.toBytes(rowkey);
        Get get = new Get(rowkeybyte);
        Result result =table.get(get);
        byte[] resultbytes = result.getValue(famliyname.getBytes(),colum.getBytes());
        if(resultbytes == null){
            return null;
        }

        return new String(resultbytes);
    }

}
