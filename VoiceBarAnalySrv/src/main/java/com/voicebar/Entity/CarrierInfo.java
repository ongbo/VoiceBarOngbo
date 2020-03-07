package com.voicebar.Entity;

public class CarrierInfo {
    private String carrier;//运营商
    private Long count;//数量
    private String groupfield;//分组

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public void setGroupfield(String groupfield) {
        this.groupfield = groupfield;
    }

    public String getCarrier() {
        return carrier;
    }

    public Long getCount() {
        return count;
    }

    public String getGroupfield() {
        return groupfield;
    }
}
