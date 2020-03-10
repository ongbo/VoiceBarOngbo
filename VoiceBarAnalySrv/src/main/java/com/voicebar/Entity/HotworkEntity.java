package com.voicebar.Entity;

public class HotworkEntity implements Comparable<HotworkEntity>{
    Integer workid;//作品id
    Long scannums;//浏览量权重占0.1
    Long likenums;//点赞量0.2
    Long collectionnums;//收藏量0.3
    Long trendnums;//转发量0.4
    Double weight;
    Long windowend;

    public Long getWindowend() {
        return windowend;
    }

    public void setWindowend(Long windowend) {
        this.windowend = windowend;
    }

    public HotworkEntity(Integer workid, Long scannums, Long likenums, Long collectionnums, Long trendnums, Double weight, Long windowend) {
        this.workid = workid;
        this.scannums = scannums;
        this.likenums = likenums;
        this.collectionnums = collectionnums;
        this.trendnums = trendnums;
        this.weight = weight;
        this.windowend = windowend;
    }

    public HotworkEntity() {
    }

    public HotworkEntity(Long scannums, Long likenums, Long collectionnums, Long trendnums) {
        this.scannums = scannums;
        this.likenums = likenums;
        this.collectionnums = collectionnums;
        this.trendnums = trendnums;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Integer getWorkid() {
        return workid;
    }

    public void setWorkid(Integer workid) {
        this.workid = workid;
    }

    public Long getScannums() {
        return scannums;
    }

    public void setScannums(Long scannums) {
        this.scannums = scannums;
    }

    public Long getLikenums() {
        return likenums;
    }

    public void setLikenums(Long likenums) {
        this.likenums = likenums;
    }

    public Long getCollectionnums() {
        return collectionnums;
    }

    public void setCollectionnums(Long collectionnums) {
        this.collectionnums = collectionnums;
    }

    public Long getTrendnums() {
        return trendnums;
    }

    public void setTrendnums(Long trendnums) {
        this.trendnums = trendnums;
    }

    public int compareTo(HotworkEntity o) {
       if(this.getWeight()>o.getWeight()) return 1;
       else if(this.getWeight() == o.getWeight()) return 0;
       else return -1;
    }
}
