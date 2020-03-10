package com.voicebar.task;

import com.voicebar.Entity.HotwindowEntity;
import com.voicebar.Entity.HotworkEntity;
import com.voicebar.Entity.KafkaEvent;
import com.voicebar.Map.HotWorkMap;
import com.voicebar.Reduce.HotWorkAggregate;
import com.voicebar.Reduce.HotWorkProcess;
import com.voicebar.Reduce.HotWorkWindowFunction;
import com.voicebar.Util.KafkaEventSchema;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.common.restartstrategy.RestartStrategies;
import org.apache.flink.api.java.tuple.Tuple;
import org.apache.flink.api.java.utils.ParameterTool;
import org.apache.flink.streaming.api.TimeCharacteristic;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.AssignerWithPeriodicWatermarks;
import org.apache.flink.streaming.api.functions.sink.RichSinkFunction;
import org.apache.flink.streaming.api.functions.windowing.WindowFunction;
import org.apache.flink.streaming.api.watermark.Watermark;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.apache.flink.streaming.api.windowing.windows.TimeWindow;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumerBase;
import org.apache.flink.util.Collector;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 取前12的热门作品
 * */
public class HorWorkTask {
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
        String[] topics = parameterTool.getRequired("input-topic").split(",");
        ArrayList<String> topiclist = (ArrayList<String>) Arrays.asList(topics);

        FlinkKafkaConsumerBase<KafkaEvent> kafkaEventFlinkKafkaConsumerBase =
                new FlinkKafkaConsumer<KafkaEvent>(
                        topiclist,
                        new KafkaEventSchema(),
                        parameterTool.getProperties()
                )
                .assignTimestampsAndWatermarks(new WorkWatermarkExtractor());

        DataStreamSource<KafkaEvent> source = env.addSource(kafkaEventFlinkKafkaConsumerBase);
        SingleOutputStreamOperator<HotworkEntity> mapresult = source.map(new HotWorkMap());
        /**根据作品id分组，然后每隔1分钟记录过去2分钟的数据*/
        SingleOutputStreamOperator<HotworkEntity> process = mapresult.keyBy("workid").timeWindow(Time.minutes(2), Time.minutes(1))
                .aggregate(new HotWorkAggregate(), new HotWorkWindowFunction())
                .keyBy("windowend")
                .process(new HotWorkProcess());
        /**将数据写到Redis*/

    }
    private static class WorkWatermarkExtractor implements AssignerWithPeriodicWatermarks<KafkaEvent> {

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
