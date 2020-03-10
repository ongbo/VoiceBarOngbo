package com.voicebar.log;

import java.io.Serializable;

/**
 *
 * 浏览配音作品
 *
 * */
public class ScanDubWork implements Serializable {
    private int userid;//用户id
    private int workid;//作品ID
    private int materialid;//对应的素材id
    private String scantime;//浏览时间
    private String staytime;//停留时间
    private String language;//配音的语言
    private String theme;//配音题材
    private String style;//配音风格

    public void setMaterialid(int materialid) {
        this.materialid = materialid;
    }

    public int getMaterialid() {
        return materialid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public void setWorkid(int workid) {
        this.workid = workid;
    }

    public void setScantime(String scantime) {
        this.scantime = scantime;
    }

    public void setStaytime(String staytime) {
        this.staytime = staytime;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public int getUserid() {
        return userid;
    }

    public int getWorkid() {
        return workid;
    }

    public String getScantime() {
        return scantime;
    }

    public String getStaytime() {
        return staytime;
    }

    public String getLanguage() {
        return language;
    }

    public String getTheme() {
        return theme;
    }

    public String getStyle() {
        return style;
    }

    @Override
    public String toString() {
        return "ScanDubWork{" +
                "userid=" + userid +
                ", workid=" + workid +
                ", materialid=" + materialid +
                ", scantime='" + scantime + '\'' +
                ", staytime='" + staytime + '\'' +
                ", language='" + language + '\'' +
                ", theme='" + theme + '\'' +
                ", style='" + style + '\'' +
                '}';
    }
}
