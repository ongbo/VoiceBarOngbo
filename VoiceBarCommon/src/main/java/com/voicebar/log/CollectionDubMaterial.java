package com.voicebar.log;
/**
 * 收藏某个配音素材
 * */
public class CollectionDubMaterial {
    private int userid;//用户id
    private int materialid;//素材id
    private String operatortime;//操作时间
    private int operatortype;//操作类型：0：收藏，1：取消收藏。
    private String language;//素材的语言
    private String theme;//素材题材

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public void setMaterialid(int materialid) {
        this.materialid = materialid;
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

    public int getUserid() {
        return userid;
    }

    public int getMaterialid() {
        return materialid;
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
}
