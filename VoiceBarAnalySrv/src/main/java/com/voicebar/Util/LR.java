package com.voicebar.Util;

import com.voicebar.Entity.CreateDataSet;
import com.voicebar.Entity.Matrix;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LR {
    /**
     * 调用colicTest
     * 测试一下即可
     * */
    public static void main(String[] args) {
        colicTest();
    }
    /**
     */
    public static void LogisticTest() {
        // TODO Auto-generated method stub
        CreateDataSet dataSet = new CreateDataSet();
        dataSet = readFile("testSet.txt");
        ArrayList<Double> weights = new ArrayList<Double>();
        weights = gradAscent1(dataSet, dataSet.labels, 150);
        for (int i = 0; i < 3; i++) {
            System.out.println(weights.get(i));
        }
        System.out.println();
    }

    /**
     * @param inX
     * @param weights
     * @return
     */
    public static String classifyVector(ArrayList<String> inX, ArrayList<Double> weights) {
        ArrayList<Double> sum = new ArrayList<Double>();
        sum.clear();
        sum.add(0.0);
        for (int i = 0; i < inX.size(); i++) {
            sum.set(0, sum.get(0) + Double.parseDouble(inX.get(i)) * weights.get(i));
        }
        if (sigmoid(sum).get(0) > 0.5)
            return "1";
        else
            return "0";

    }

    /**
     */
    public static void colicTest() {
        //创建训练集对象
        CreateDataSet trainingSet = new CreateDataSet();
        //创建测试集对象
        CreateDataSet testSet = new CreateDataSet();

        /***
         *
         * 调用readFile方法
         * 将训练集和测试集都读进来
         * 形成的是一种矩阵的形式CreateDataSet
         * */
        trainingSet = readFile("testTraining.txt");// 23 445 34 1  45 56 67 0
        testSet = readFile("Test.txt");// 23 445 34 1  45 56 67 0

        /**
         * 权重值
         * */
        ArrayList<Double> weights = new ArrayList<Double>();
        /**
         * 调用gradAccent方法计算
         * */
        weights = gradAscent1(trainingSet, trainingSet.labels, 500);

        /**
         * 计算误差
         * */
        int errorCount = 0;
        for (int i = 0; i < testSet.data.size(); i++) {
            if (!classifyVector(testSet.data.get(i), weights).equals(testSet.labels.get(i))) {
                errorCount++;
            }
            System.out.println(classifyVector(testSet.data.get(i), weights) + "," + testSet.labels.get(i));
        }
        System.out.println(1.0 * errorCount / testSet.data.size());

    }

    /**
     * @param inX
     * @return
     * @Description: [sigmod函数]
     */
    public static ArrayList<Double> sigmoid(ArrayList<Double> inX) {
        ArrayList<Double> inXExp = new ArrayList<Double>();
        for (int i = 0; i < inX.size(); i++) {
            inXExp.add(1.0 / (1 + Math.exp(-inX.get(i))));
        }
        return inXExp;
    }

    /**
     * @param dataSet：训练数据
     * @param classLabels：训练数据的labels
     * @param numberIter：训练次数
     * @return
     */
    public static ArrayList<Double> gradAscent1(Matrix dataSet, ArrayList<String> classLabels, int numberIter) {
        /**
         * m：代表行的个数
         * n：代表列的个数,即维度
         * alpha：作为梯度下降的幅度，就是在更新权值的时候alpha*梯度，来看权值一次更新多少，故名为步长
         * randIndex：作为随机的索引，来随机抽取数据集
         * */
        int m = dataSet.data.size();
        int n = dataSet.data.get(0).size();
        double alpha = 0.0;
        int randIndex = 0;

        /**
         * weights：权值
         * weightstmp：临时权值
         * h：可以不要，就临时保存sigmoid函数后的真是值
         * dataIndex：随机抽取数据集的索引集，你也可以按顺序来
         * dataMatrixMulweights：保存计算出来的值，即数据集和权值相乘的结果
         * */
        ArrayList<Double> weights = new ArrayList<Double>();
        ArrayList<Double> weightstmp = new ArrayList<Double>();
        ArrayList<Double> h = new ArrayList<Double>();
        ArrayList<Integer> dataIndex = new ArrayList<Integer>();
        ArrayList<Double> dataMatrixMulweights = new ArrayList<Double>();

        /**
         * 初始化权值，暂时都保存为1.0
         * 一共有n个权值，因为每一行数据，有n列元素，每个元素应该对应一个权值
         * */
        for (int i = 0; i < n; i++) {
            weights.add(1.0);
            weightstmp.add(1.0);
        }


        dataMatrixMulweights.add(0.0);

        /**
         * error：保存误差
         * for循环开始计算，numberIter是参数传进来的计算次数
         * */
        double error = 0.0;
        for (int j = 0; j < numberIter; j++) {
            // 产生0到m的数组
            for (int p = 0; p < m; p++) {
                dataIndex.add(p);
            }
            /**
             * 每一次迭代计算
             * 都要对所有的训练集进行计算
             * 即对m条数据集计算
             * */

            for (int i = 0; i < m; i++) {

                alpha = 4 / (1.0 + i + j) + 0.0001;
                randIndex = (int) (Math.random() * dataIndex.size());
                dataIndex.remove(randIndex);

                /***
                 * 这里temp保存的是某一行数据和权值进行相乘（x1,x2,x3,x4,x5....）* (w1,w2,w3,w4,w5)......
                 * */
                double temp = 0.0;
                for (int k = 0; k < n; k++) {
                    temp = temp + Double.parseDouble(dataSet.data.get(randIndex).get(k)) * weights.get(k);
                }

                /**
                 * 将dataMatrixMulWeights：这里其实没必要这样设置，
                 * 因为temp传到sigmoid函数还是只有一个元素，每次迭代都只有一个元素
                 * 这里可以改成直接传进去，不需要这个变量
                 * */
                dataMatrixMulweights.set(0, temp);
                h = sigmoid(dataMatrixMulweights);

                /**
                 * sigmoid函数出来后的预测值h.get(0)，和真实数据集的实际值做比较
                 * */
                error = Double.parseDouble(classLabels.get(randIndex)) - h.get(0);
                /**
                 * 利用梯度下降法，来更新权值
                 * */
                double tempweight = 0.0;
                for (int p = 0; p < n; p++) {
                    tempweight = alpha * Double.parseDouble(dataSet.data.get(randIndex).get(p)) * error;
                    weights.set(p, weights.get(p) + tempweight);
                }
            }

        }
        return weights;
    }

    /**
     * @param dataSet
     * @param classLabels
     * @return
     */
    public static ArrayList<Double> gradAscent0(Matrix dataSet, ArrayList<String> classLabels) {
        int m = dataSet.data.size();
        int n = dataSet.data.get(0).size();
        ArrayList<Double> weights = new ArrayList<Double>();
        ArrayList<Double> weightstmp = new ArrayList<Double>();
        ArrayList<Double> h = new ArrayList<Double>();
        double error = 0.0;
        ArrayList<Double> dataMatrixMulweights = new ArrayList<Double>();
        double alpha = 0.01;
        for (int i = 0; i < n; i++) {
            weights.add(1.0);
            weightstmp.add(1.0);
        }
        h.add(0.0);
        double temp = 0.0;
        dataMatrixMulweights.add(0.0);
        for (int i = 0; i < m; i++) {
            temp = 0.0;
            for (int k = 0; k < n; k++) {
                temp = temp + Double.parseDouble(dataSet.data.get(i).get(k)) * weights.get(k);
            }
            dataMatrixMulweights.set(0, temp);
            h = sigmoid(dataMatrixMulweights);
            error = Double.parseDouble(classLabels.get(i)) - h.get(0);
            double tempweight = 0.0;
            for (int p = 0; p < n; p++) {
                tempweight = alpha * Double.parseDouble(dataSet.data.get(i).get(p)) * error;
                weights.set(p, weights.get(p) + tempweight);
            }
        }
        return weights;
    }

    /**
     * @param dataSet
     * @param classLabels
     * @return
     */
    public static ArrayList<Double> gradAscent(Matrix dataSet, ArrayList<String> classLabels) {
        int m = dataSet.data.size();
        int n = dataSet.data.get(0).size();
        ArrayList<Double> weights = new ArrayList<Double>();
        ArrayList<Double> weightstmp = new ArrayList<Double>();
        ArrayList<Double> h = new ArrayList<Double>();
        ArrayList<Double> error = new ArrayList<Double>();
        ArrayList<Double> dataMatrixMulweights = new ArrayList<Double>();
        double alpha = 0.001;
        int maxCycles = 500;
        for (int i = 0; i < n; i++) {
            weights.add(1.0);
            weightstmp.add(1.0);
        }
        for (int i = 0; i < m; i++) {
            h.add(0.0);
            error.add(0.0);
            dataMatrixMulweights.add(0.0);
        }
        double temp;
        for (int i = 0; i < maxCycles; i++) {
            for (int j = 0; j < m; j++) {
                temp = 0.0;
                for (int k = 0; k < n; k++) {
                    temp = temp + Double.parseDouble(dataSet.data.get(j).get(k)) * weights.get(k);
                }
                dataMatrixMulweights.set(j, temp);
            }
            h = sigmoid(dataMatrixMulweights);
            for (int q = 0; q < m; q++) {
                error.set(q, Double.parseDouble(classLabels.get(q)) - h.get(q));
            }
            double tempweight = 0.0;
            for (int p = 0; p < n; p++) {
                tempweight = 0.0;
                for (int q = 0; q < m; q++) {
                    tempweight = tempweight + alpha * Double.parseDouble(dataSet.data.get(q).get(p)) * error.get(q);
                }
                weights.set(p, weights.get(p) + tempweight);
            }
        }
        return weights;
    }

    public LR() {
        super();
    }

    /**
     * @param fileName
     *            读入的文件名
     * @return
     */
    public static CreateDataSet readFile(String fileName) {
        File file = new File(fileName);
        BufferedReader reader = null;
        CreateDataSet dataSet = new CreateDataSet();
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                // 显示行号
                String[] strArr = tempString.split("\t");
                ArrayList<String> as = new ArrayList<String>();
                as.add("1");
                for (int i = 0; i < strArr.length - 1; i++) {
                    as.add(strArr[i]);
                }
                dataSet.data.add(as);
                dataSet.labels.add(strArr[strArr.length - 1]);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
        return dataSet;
    }
}
