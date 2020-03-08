package com.voicebar.Entity;

import java.util.ArrayList;

/***
 * 主要保存特征信息以及标签值
 * labels：主要保存标签值
 * */
public class CreateDataSet extends Matrix{
    public ArrayList<String> labels;

    public CreateDataSet() {
        super();
        labels = new ArrayList<String>();
    }

    public ArrayList<String> getLabels() {
        return labels;
    }

    public void setLabels(ArrayList<String> labels) {
        this.labels = labels;
    }
}
