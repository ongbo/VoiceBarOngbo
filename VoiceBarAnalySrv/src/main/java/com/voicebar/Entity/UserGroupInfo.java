package com.voicebar.Entity;
/**
 * 用户群体特征分析基本数据类
 * 主要分析的类型有：
 * 配音题材和配音次数：
 * 专题配音
 * 广告配音
 * 课件多媒体配音
 * 游戏配音
 * 动漫配音
 * 旁白配音
 * 歌曲说唱配音
 * 小说配音
 * 方言配音
 * 会场配音
 * 。。。。。
*/
public class UserGroupInfo {
    private String userid;//用户id
    private String worktime;//作品发布时间
    private String language;//作品语言
    private String theme;//作品主题
    private String style;//作品风格
    private String workscore;//作品的系统得分
    private String groupfield;//分组


    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getWorktime() {
        return worktime;
    }

    public void setWorktime(String worktime) {
        this.worktime = worktime;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getWorkscore() {
        return workscore;
    }

    public void setWorkscore(String workscore) {
        this.workscore = workscore;
    }

    public String getGroupfield() {
        return groupfield;
    }

    public void setGroupfield(String groupfield) {
        this.groupfield = groupfield;
    }
}
