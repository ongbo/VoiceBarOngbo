package com.voicebar.Entity;

public class Point {
    /**
     * localArray保存某一个点维度数据
     * */
    private float[] localArray;
    private int id;
    private int clusterId;//表示属于哪个簇
    private float dist;//表示和所属类中心的距离
    private Point clusterPoint;//中心点信息
    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass())
            return false;

        Point point = (Point) obj;
        if (point.localArray.length != localArray.length)
            return false;

        for (int i = 0; i < localArray.length; i++) {
            if (Float.compare(point.localArray[i], localArray[i]) != 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        float x = localArray[0];
        float y = localArray[localArray.length - 1];
        long temp = x != +0.0d ? Double.doubleToLongBits(x) : 0L;
        int result = (int) (temp ^ (temp >>> 32));
        temp = y != +0.0d ? Double.doubleToLongBits(y) : 0L;
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    public Point(int id, float[] localArray) {
        this.id = id;
        this.localArray = localArray;
    }
    public Point(float[] localArray) {
        this.id = -1; //表示不属于任意一个类
        this.localArray = localArray;
    }
    public float[] getlocalArray() {
        return localArray;
    }

    public void setlocalArray(float[] localArray) {
        this.localArray = localArray;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClusterId() {
        return clusterId;
    }

    public void setClusterId(int clusterId) {
        this.clusterId = clusterId;
    }

    public float getDist() {
        return dist;
    }

    public void setDist(float dist) {
        this.dist = dist;
    }

    public Point getClusterPoint() {
        return clusterPoint;
    }

    public void setClusterPoint(Point clusterPoint) {
        this.clusterPoint = clusterPoint;
    }
}
