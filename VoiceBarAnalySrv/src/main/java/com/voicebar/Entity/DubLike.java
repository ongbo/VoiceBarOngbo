package com.voicebar.Entity;

public class DubLike {
    private Integer Dubid;//themeID
    private Long count;//数量或者频次
    private String groupbyfield;

    public Integer getDubid() {
        return Dubid;
    }

    public void setDubid(Integer dubid) {
        Dubid = dubid;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public String getGroupbyfield() {
        return groupbyfield;
    }

    public void setGroupbyfield(String groupbyfield) {
        this.groupbyfield = groupbyfield;
    }
}
