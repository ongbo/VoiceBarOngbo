package com.voicebar.task;

import com.voicebar.Entity.KafkaEvent;
import com.voicebar.Map.DubLikeMap;
import com.voicebar.Util.KafkaEventSchema;
import org.apache.flink.api.common.restartstrategy.RestartStrategies;
import org.apache.flink.api.java.utils.ParameterTool;
import org.apache.flink.streaming.api.TimeCharacteristic;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.AssignerWithPeriodicWatermarks;
import org.apache.flink.streaming.api.watermark.Watermark;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumerBase;

import javax.annotation.Nullable;
/**
* 实时计算用户的偏好
 * 根据浏览作品
 * */
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
        /**
         * 获取flink流计算运行环境
         * 配置相关参数
         * */
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.getConfig().disableSysoutLogging();
        env.getConfig().setRestartStrategy(RestartStrategies.fixedDelayRestart(4, 10000));
        env.enableCheckpointing(10000); // create a checkpoint every 10 seconds
        env.getConfig().setGlobalJobParameters(parameterTool); // make parameters available in the web interface
        env.setStreamTimeCharacteristic(TimeCharacteristic.EventTime);

        /**
         * 从kafka源读取消息
         * */
        FlinkKafkaConsumerBase<KafkaEvent> kafkaEventFlinkKafkaConsumerBase = new FlinkKafkaConsumer<>(parameterTool.getRequired("input-topic"), new KafkaEventSchema(), parameterTool.getProperties())
                .assignTimestampsAndWatermarks(new CustomWatermarkExtractor());
        DataStream<KafkaEvent> input = env.addSource(kafkaEventFlinkKafkaConsumerBase);


        /**
         * Map预处理，自己实现一个flatmap
         *
         * */
        SingleOutputStreamOperator<R> mapresult = input.map(new DubLikeMap());


        /**
         * 执行
         * */
        env.execute("User like Dub Work Or Material");


    }

    private static class CustomWatermarkExtractor implements AssignerWithPeriodicWatermarks<KafkaEvent>{

        private static final long serialVersionUID = -742759155861320823L;

        private long currentTimestamp = Long.MIN_VALUE;

        @Nullable
        public Watermark getCurrentWatermark() {

            return new Watermark(currentTimestamp == Long.MIN_VALUE ? Long.MIN_VALUE : currentTimestamp - 1);
        }

        public long extractTimestamp(KafkaEvent element, long previousElementTimestamp) {
            this.currentTimestamp = element.getTimestamp();
            return element.getTimestamp();
        }
    }
}
