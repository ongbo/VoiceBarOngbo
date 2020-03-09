package com.voicebar.Entity;

import java.util.List;

public class UserGroupINFOByReduce {
    private String userid;
    private List<UserGroupInfo> list;//保存这个用户所有的作品信息
    private double avramout;//平均得分
    private double maxamout;//最高得分
    private int days;//单日消费频次
    private List<Integer> worktheme;//保存作品类型
    private List<Integer> worknums;//保存worktheme作品类型对应的数量
    private List<Long> workTimenums;//保存在某个时间点的作品数量。上午（7-12），下午（12-7），晚上（7-12），凌晨（0-7）
    private String groupfield;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public List<UserGroupInfo> getList() {
        return list;
    }

    public void setList(List<UserGroupInfo> list) {
        this.list = list;
    }

    public double getAvramout() {
        return avramout;
    }

    public void setAvramout(double avramout) {
        this.avramout = avramout;
    }

    public double getMaxamout() {
        return maxamout;
    }

    public void setMaxamout(double maxamout) {
        this.maxamout = maxamout;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public List<Integer> getWorktheme() {
        return worktheme;
    }

    public void setWorktheme(List<Integer> worktheme) {
        this.worktheme = worktheme;
    }

    public List<Integer> getWorknums() {
        return worknums;
    }

    public void setWorknums(List<Integer> worknums) {
        this.worknums = worknums;
    }

    public List<Long> getWorkTimenums() {
        return workTimenums;
    }

    public void setWorkTimenums(List<Long> workTimenums) {
        this.workTimenums = workTimenums;
    }

    public String getGroupfield() {
        return groupfield;
    }

    public void setGroupfield(String groupfield) {
        this.groupfield = groupfield;
    }
}
