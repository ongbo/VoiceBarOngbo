package com.voicebar.Entity;

/**
 * 预测性别的基本元素
 * 用户id
 * 作品总数：worknum
 * 配音频次：workfre
 * 浏览男生配音次数：manDubWorknum
 * 浏览女生配音次数：womanDubWorknum
 * 每天浏览作品频次：workDayfre
 * 填写的性别作为标签：label
 * */
public class SexPreInfo {
    private int userid;
    private int worknum;
    private int workfre;
    private int manDubWorknum;
    private int womanDubWorknum;
    private int workDayfre;
    private int label;

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getWorknum() {
        return worknum;
    }

    public void setWorknum(int worknum) {
        this.worknum = worknum;
    }

    public int getWorkfre() {
        return workfre;
    }

    public void setWorkfre(int workfre) {
        this.workfre = workfre;
    }

    public int getManDubWorknum() {
        return manDubWorknum;
    }

    public void setManDubWorknum(int manDubWorknum) {
        this.manDubWorknum = manDubWorknum;
    }

    public int getWomanDubWorknum() {
        return womanDubWorknum;
    }

    public void setWomanDubWorknum(int womanDubWorknum) {
        this.womanDubWorknum = womanDubWorknum;
    }

    public int getWorkDayfre() {
        return workDayfre;
    }

    public void setWorkDayfre(int workDayfre) {
        this.workDayfre = workDayfre;
    }

    public int getLabel() {
        return label;
    }

    public void setLabel(int label) {
        this.label = label;
    }
}
