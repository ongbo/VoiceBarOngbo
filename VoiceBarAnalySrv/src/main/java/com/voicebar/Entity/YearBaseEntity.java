package com.voicebar.Entity;

public class YearBaseEntity {
    private String yeartype;//年代类型
    private Long count;//数量
    public String groupfield;//分组字段

    public String getYeartype() {
        return yeartype;
    }

    public Long getCount() {
        return count;
    }

    public String getGroupfield() {
        return groupfield;
    }

    public void setYeartype(String yeartype) {
        this.yeartype = yeartype;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public void setGroupfield(String groupfield) {
        this.groupfield = groupfield;
    }

    @Override
    public String toString() {
        return "YearBaseEntity{" +
                "yeartype='" + yeartype + '\'' +
                ", count=" + count +
                ", groupfield='" + groupfield + '\'' +
                '}';
    }
}
