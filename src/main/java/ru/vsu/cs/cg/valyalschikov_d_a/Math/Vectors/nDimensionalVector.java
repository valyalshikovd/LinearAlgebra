package ru.vsu.cs.cg.valyalschikov_d_a.Math.Vectors;

import java.util.Arrays;
import java.util.Objects;

public class nDimensionalVector implements Vector<nDimensionalVector>{

    protected double[] values;
    protected int dimensional;
    protected double length;

    public nDimensionalVector(double ...args){
        dimensional = args.length;
        values = args;

        length = 0;
        for (double value : values)
            length += value * value;
        length = Math.pow(length, 0.5);
    }

    @Override
    public double[] getArrValues() {
        return new double[0];
    }

    @Override
    public nDimensionalVector subtraction(nDimensionalVector vector) {
        if (vector.dimensional != dimensional){
            throw  new RuntimeException("Размерности векторов не совпадают");
        }
        double[] newValues = new double[dimensional];
        for(int i = 0; i < length; i++){
            newValues[i] = values[i] - vector.values[i];
        }
        return  new nDimensionalVector(newValues);
    }

    @Override
    public nDimensionalVector addition(nDimensionalVector vector) {
        if (vector.dimensional != dimensional){
            throw  new RuntimeException("Размерности векторов не совпадают");
        }
        double[] newValues = new double[dimensional];
        for(int i = 0; i < length; i++){
            newValues[i] = values[i] + vector.values[i];
        }
        return  new nDimensionalVector(newValues);
    }

    @Override
    public nDimensionalVector scale(double a) {
        double[] newValues = new double[dimensional];
        for(int i = 0; i < length; i++){
            newValues[i] = values[i] * a;
        }
        return  new nDimensionalVector(newValues);
    }

    @Override
    public double length() {
        return length;
    }

    @Override
    public nDimensionalVector normalization() {
        double[] newValues = new double[dimensional];
        for(int i = 0; i < length; i++){
            newValues[i] = values[i] / length;
        }
        return  new nDimensionalVector(newValues);
    }

    @Override
    public double scalarProduct(nDimensionalVector vector) {
        if (vector.dimensional != dimensional){
            throw  new RuntimeException("Размерности векторов не совпадают");
        }
        double scalarProd = 0;
        for(int i = 0; i < length; i++){
            scalarProd = values[i] * vector.values[i];
        }
        return  scalarProd;
    }

    @Override
    public double cosAngleBetweenVectors(nDimensionalVector vector) {
        if (vector.dimensional != dimensional){
            throw  new RuntimeException("Размерности векторов не совпадают");
        }
        return scalarProduct(vector)/(length * vector.length);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        nDimensionalVector that = (nDimensionalVector) o;
        return dimensional == that.dimensional && Arrays.equals(values, that.values);
    }


}
