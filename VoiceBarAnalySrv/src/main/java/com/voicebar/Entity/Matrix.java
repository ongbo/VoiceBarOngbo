package com.voicebar.Entity;

import java.util.ArrayList;

/**
 * 保存特征信息
 * 主要保存特征矩阵
 * */
public class Matrix {
    /**
     * 分为两层ArrayList
     * 外面代表行
     * 里面代表列
     * */
    public ArrayList<ArrayList<String>> data;
    public Matrix() {
        data = new ArrayList<ArrayList<String>>();

    }

    public ArrayList<ArrayList<String>> getData() {
        return data;
    }

    public void setData(ArrayList<ArrayList<String>> data) {
        this.data = data;
    }
}
