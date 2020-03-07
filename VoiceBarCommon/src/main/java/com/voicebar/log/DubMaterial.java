package com.voicebar.log;
/**
 * 某个用户给一段素材配音了
 * */
public class DubMaterial {
    private int userid;
    private int materialid;
    private int workid;
    private String operatortime;
    private int operatortype;//操作类型 0：配音并且发布  1：删除或取消配音
    private String theme;//素材的题材
    private String language;//配音的语言
    private String style;//配音的风格


    public void setUserid(int userid) {
        this.userid = userid;
    }

    public void setMaterialid(int materialid) {
        this.materialid = materialid;
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

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public int getUserid() {
        return userid;
    }

    public int getMaterialid() {
        return materialid;
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

    public String getTheme() {
        return theme;
    }

    public String getLanguage() {
        return language;
    }

    public String getStyle() {
        return style;
    }
}
