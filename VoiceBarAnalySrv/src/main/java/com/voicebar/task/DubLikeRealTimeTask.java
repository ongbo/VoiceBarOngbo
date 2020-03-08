package com.voicebar.task;

import org.apache.flink.api.java.utils.ParameterTool;

public class DubLikeRealTimeTask {
    public static void main(String[] args) {
        //参数形式，生产环境中以参数形式指定
//        args = new String[]{"--input-topic","scanProductLog","--bootstrap.servers","192.168.80.134:9092","--zookeeper.connect","192.168.80.134:2181","--group.id","youfan"};
        final ParameterTool parameterTool = ParameterTool.fromArgs(args);

//		if (parameterTool.getNumberOfParameters() < 5) {
//			System.out.println("Missing parameters!\n" +i
//					"Usage: Kafka --input-topic <topic> --output-topic <topic> " +
//					"--bootstrap.servers <kafka brokers> " +
//					"--zookeeper.connect <zk quorum> --group.id <some id>");
//			return;
//		}

    }

}
