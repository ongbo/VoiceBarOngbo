package com.voicebar.log;

/**
 * 浏览配音素材
 * */
public class ScanDubMaterial {
    private int userid;//用户id
    private int materialid;//素材ID
    private String scantime;//浏览时间
    private String staytime;//停留时间
    private String language;//配音的语言
    private String theme;//配音题材

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public void setmaterialid(int wordid) {
        this.materialid = wordid;
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

    public int getUserid() {
        return userid;
    }

    public int getMaterialid() {
        return materialid;
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
}
