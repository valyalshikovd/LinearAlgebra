package ru.vsu.cs.cg.valyalschikov_d_a.Math.Matrix;

import ru.vsu.cs.cg.valyalschikov_d_a.Math.Vectors.FourDimensionalVector;
import ru.vsu.cs.cg.valyalschikov_d_a.Math.Vectors.Vector;
import ru.vsu.cs.cg.valyalschikov_d_a.Math.Vectors.NDimensionalVector;

import java.util.Arrays;
import java.util.HashMap;

import static java.lang.Math.abs;

public class NDimensionalMatrix implements Matrix {
    int dimensional;
    public static HashMap<Integer, Double> memoizeDeter = new HashMap<>();
    protected Vector[] matrixInVectors;

    public NDimensionalMatrix(Vector ...vectors) {
        dimensional = vectors.length;
        matrixInVectors = vectors;
        if(dimensional < 1){
            throw new ArithmeticException("Нельзя создать матрицу столь малой размерности");
        }
        for (Vector vector : matrixInVectors) {
            if (vector.getDimensional() != dimensional) {
                throw new ArithmeticException("Размерность векторов не совпадает с размерностью матрицы");
            }
        }
    }

//    public NDimensionalMatrix(int dimensional){
//        NDimensionalVector[] newArr = new NDimensionalVector[dimensional];
//        this.dimensional = dimensional;
//        if(dimensional < 1){
//            throw new ArithmeticException("Нельзя создать матрицу столь малой размерности");
//        }
//        for(int i = 0; i < dimensional; i++){
//
//        }
//    }

    @Override
    public Vector[] getMatrixInVectors() {
        return matrixInVectors;
    }

    public int getDimensional() {
        return dimensional;
    }

    @Override
    public Matrix addition(Matrix matrix) {
        if(dimensional != matrix.getDimensional()){
            throw new ArithmeticException("Нельзя сложить матрицы разных размерностей");
        }
        Vector[] newVectors = new NDimensionalVector[dimensional];
        for (int i = 0; i < dimensional; i++) {
            newVectors[i] = matrixInVectors[i].addition( matrix.getMatrixInVectors()[i]);
        }
        return new NDimensionalMatrix( newVectors);

    }

    @Override
    public Vector multiplyVector(Vector vector) {
        NDimensionalVector newVector = null;
        try {
            newVector = (NDimensionalVector) vector;
        } catch (Exception e) {
            throw new RuntimeException("Неправильная размерность вектора");
        }
        if (newVector.getDimensional() != dimensional) {
            throw new RuntimeException("Неправильная размерность вектора");
        }
        double[] newValues = new double[dimensional];
        for (int i = 0; i < dimensional; i++) {
            double total = 0;
            for (int j = 0; j < dimensional; j++){
                total += matrixInVectors[i].getArrValues()[j] * vector.getArrValues()[j];

            }
            newValues[i] = total;
        }
        return new NDimensionalVector(newValues);
    }

    @Override
    public Matrix multiplyMatrix(Matrix matrix) {
        if (dimensional != matrix.getDimensional()) {
            throw new RuntimeException("Неправильная размерность матрицы");
        }
        NDimensionalVector[] newVectors = new NDimensionalVector[dimensional];
        for (int i = 0; i < dimensional; i++) {
            double[] values = new double[dimensional];
            for (int j = 0; j < dimensional; j++) {
                double sum = 0;
                for (int k = 0; k < dimensional; k++) {
                    sum += getMatrixInVectors()[i].getArrValues()[k] * matrix.getMatrixInVectors()[k].getArrValues()[j];
                }
                values[j] = sum;
            }
            newVectors[i] = new NDimensionalVector(values);
        }
        return new NDimensionalMatrix(newVectors);
    }

    @Override
    public Matrix transposition() {
        NDimensionalVector[] newVectors = new NDimensionalVector[dimensional];
        for (int i = 0; i < dimensional; i++) {
            double[] values = new double[dimensional];
            for (int j = 0; j < dimensional; j++) {
                values[j] = matrixInVectors[j].getArrValues()[i];
            }
            newVectors[i] = new NDimensionalVector(values);
        }
        return new NDimensionalMatrix(newVectors);
    }

    @Override
    public void printMatrix() {
        System.out.println("----------------------");
        for (int j = 0; j < dimensional; j++) {
            for (int i = 0; i < dimensional; i++) {
                System.out.print(matrixInVectors[i].getArrValues()[j] + " ");
            }
            System.out.println();
        }
        System.out.println("----------------------");
    }

    @Override
    public double getDeterminant() {
        return findDeter(dimensional);
    }

    private double findDeter(int dimensional) {

        if(memoizeDeter.containsKey(this.hashCode())){
            return memoizeDeter.get(this.hashCode());
        }

        double deter = 0;
        if (dimensional == 1) {
            deter = matrixInVectors[0].getArrValues()[0];
            memoizeDeter.put(this.hashCode(), deter);
            return deter;
        }
        for (int k = 0; k < dimensional; k++) {
            NDimensionalVector[] vectors = new NDimensionalVector[dimensional - 1];
            int counter = 0;
            for (int i = 0; i < dimensional; i++) {
                if (i == k) {
                    continue;
                }
                double[] values = new double[dimensional - 1];
                for (int j = 1; j < dimensional; j++) {
                    values[j-1] = matrixInVectors[j].getArrValues()[i];
                }
                vectors[counter] = new NDimensionalVector(values);
                counter++;
            }

            NDimensionalMatrix tmp = new NDimensionalMatrix(vectors);
            double tmpDeter = tmp.getDeterminant();
            if (k % 2 == 0) {
                deter += tmpDeter * matrixInVectors[0].getArrValues()[k];
            } else {
                deter -= tmpDeter * matrixInVectors[0].getArrValues()[k];
            }
        }
        memoizeDeter.put(this.hashCode(), deter);

        return deter;
    }

    @Override
    public Matrix inverseMatrix() {
        double determinant = this.getDeterminant();
        if (abs(determinant) < 0.000001){
            throw new RuntimeException("Zero determinant");
        }
        NDimensionalVector[] vectors = new NDimensionalVector[dimensional];

        for (int i = 0; i < dimensional; i++){

            double[] values = new double[dimensional];
            for (int j = 0; j < dimensional; j++){
                NDimensionalVector[] vectors1 = new NDimensionalVector[dimensional - 1];
                int counter = 0;
                for (int k = 0; k < dimensional; k++){
                    if(j == k){
                        continue;
                    }
                    double[] values1 = new double[dimensional - 1];

                    int counter1 = 0;

                    for (int p = 0; p < dimensional; p++){
                        if(i == p){
                            continue;
                        }
                        values1[counter1] = matrixInVectors[p].getArrValues()[k];
                        counter1++;
                    }

                    vectors1[counter] = new NDimensionalVector(values1);
                    counter++;
                }
                values[j] = new NDimensionalMatrix(vectors1).getDeterminant() * -Math.pow(-1, i+j+1) * 1/determinant;;
            }
            vectors[i] = new NDimensionalVector(values);
        }
        NDimensionalMatrix matrixMinor = new NDimensionalMatrix(vectors);
        matrixMinor = (NDimensionalMatrix) matrixMinor.transposition();

        return matrixMinor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NDimensionalMatrix that = (NDimensionalMatrix) o;
        if(dimensional != that.getDimensional()){
            return false;
        };
        for(int i = 0; i < dimensional; i++){
            if(!matrixInVectors[i].equals(that.matrixInVectors[i])){
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        Object[] res = new Object[dimensional * dimensional];
        for(int i = 0; i < dimensional; i++){
            res[i] = matrixInVectors[i].getArrValues();
        }
        return Arrays.deepHashCode(res);
    }

}
