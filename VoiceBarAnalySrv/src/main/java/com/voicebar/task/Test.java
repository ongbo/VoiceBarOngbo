package com.voicebar.task;

import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.utils.ParameterTool;

public class Test {
    public static void main(String[] args) {
        //获取参数
        final ParameterTool params = ParameterTool.fromArgs(args);

        //设置执行环境
        final ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();

        //是参数在Web接口里可用
        env.getConfig().setGlobalJobParameters(params);

        //获取输入的数据
        DataSet<String> text = env.readTextFile(params.get("input"));
        DataSet map = text.flatMap(null);
        DataSet reduce = map.groupBy("groupbyfield").reduce(null);

        try {
            env.execute("test");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
