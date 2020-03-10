package com.voicebar.Entity;

public class HotwindowEntity implements Comparable<HotwindowEntity> {
    Integer workid;
    Long windowend;
    Double weight;

    public HotwindowEntity(Integer workid, Long windowend, Double weight) {
        this.workid = workid;
        this.windowend = windowend;
        this.weight = weight;
    }

    public Integer getWorkid() {
        return workid;
    }

    public void setWorkid(Integer workid) {
        this.workid = workid;
    }

    public Long getWindowend() {
        return windowend;
    }

    public void setWindowend(Long windowend) {
        this.windowend = windowend;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }


    public int compareTo(HotwindowEntity o) {
       if(this.getWeight() > o.getWeight()) return 1;
       else if(this.getWeight() == o.getWeight()) return 0;
       else return -1;
    }
}
