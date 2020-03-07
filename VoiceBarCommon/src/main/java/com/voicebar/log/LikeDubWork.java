package com.voicebar.log;
/**
 * 点赞某个配音作品
 * */
public class LikeDubWork {
    private int userid;//用户id
    private int workid;//作品id
    private int materialid;//对应的素材id
    private String operatortime;//操作时间
    private int operatortype;//操作类型：0：点赞，1：取消点赞。
    private String language;//作品的语言
    private String theme;//作品题材
    private String style;//作品的风格

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

    public void setOperatortime(String operatortime) {
        this.operatortime = operatortime;
    }

    public void setOperatortype(int operatortype) {
        this.operatortype = operatortype;
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

    public String getOperatortime() {
        return operatortime;
    }

    public int getOperatortype() {
        return operatortype;
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
}
