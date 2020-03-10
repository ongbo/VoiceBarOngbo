package com.voicebar.Entity;

public class KafkaEvent {
    private final static String splitword = "##";//分隔符
    private String word;//字段
    private int frequency;//频次，穿过来的好像是1
    private long timestamp;//时间戳
    private String topic;
    //传过来的基本都是：word##1##data

    public KafkaEvent() {}

    public KafkaEvent(String word, int frequency, long timestamp,String topic) {
        this.word = word;
        this.frequency = frequency;
        this.timestamp = timestamp;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public static KafkaEvent fromString(String eventStr) {
        String[] split = eventStr.split(splitword);
        return new KafkaEvent(split[0], Integer.valueOf(split[1]), Long.valueOf(split[2]),split[3]);
    }

    @Override
    public String toString() {
        return word +splitword + frequency + splitword + timestamp+ topic;
    }
}
