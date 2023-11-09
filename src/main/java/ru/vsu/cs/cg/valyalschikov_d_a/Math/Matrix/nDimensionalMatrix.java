package ru.vsu.cs.cg.valyalschikov_d_a.Math.Matrix;

import ru.vsu.cs.cg.valyalschikov_d_a.Math.Vectors.ThreeDimensionalVector;
import ru.vsu.cs.cg.valyalschikov_d_a.Math.Vectors.Vector;
import ru.vsu.cs.cg.valyalschikov_d_a.Math.Vectors.nDimensionalVector;

import java.util.Arrays;
import java.util.Objects;

import static java.lang.Math.abs;

public class nDimensionalMatrix implements Matrix<nDimensionalMatrix> {
    int dimensional;
    protected nDimensionalVector[] matrixInVectors;

    public nDimensionalMatrix(nDimensionalVector... vectors) {
        dimensional = vectors.length;
        matrixInVectors = vectors;
        for (nDimensionalVector vector : matrixInVectors) {
            if (vector.getDimensional() != dimensional) {
                throw new RuntimeException("Размерность векторов не совпадает с размерностью матрицы");
            }
        }

    }

    @Override
    public Vector[] getMatrixInVectors() {
        return matrixInVectors;
    }

    public int getDimensional() {
        return dimensional;
    }

    @Override
    public Matrix<nDimensionalMatrix> addition(Matrix<nDimensionalMatrix> matrix) {
        nDimensionalVector[] newVectors = new nDimensionalVector[dimensional];
        for (int i = 0; i < dimensional; i++) {
            newVectors[i] = matrixInVectors[i].addition((nDimensionalVector) matrix.getMatrixInVectors()[i]);
        }
        return new nDimensionalMatrix(newVectors);

    }

    @Override
    public Matrix<nDimensionalMatrix> multiplyVector(Vector<?> vector) {
        nDimensionalVector newVector = null;
        try {
            newVector = (nDimensionalVector) vector;
        } catch (Exception e) {
            throw new RuntimeException("Неправильная размерность вектора");
        }
        if (newVector.getDimensional() != dimensional) {
            throw new RuntimeException("Неправильная размерность вектора");
        }
        nDimensionalVector[] newVectors = new nDimensionalVector[dimensional];
        for (int i = 0; i < dimensional; i++) {
            newVectors[i] = matrixInVectors[i].scale(vector.getArrValues()[i]);
        }
        return new nDimensionalMatrix(newVectors);
    }

    @Override
    public Matrix<nDimensionalMatrix> multiplyMatrix(Matrix<nDimensionalMatrix> matrix) {
        if (dimensional != matrix.getDimensional()) {
            throw new RuntimeException("Неправильная размерность матрицы");
        }
        nDimensionalVector[] newVectors = new nDimensionalVector[dimensional];
        for (int i = 0; i < dimensional; i++) {
            double[] values = new double[dimensional];
            for (int j = 0; j < dimensional; j++) {
                double sum = 0;
                for (int k = 0; k < dimensional; k++) {
                    sum += getMatrixInVectors()[i].getArrValues()[k] * matrix.getMatrixInVectors()[k].getArrValues()[j];
                }
                values[j] = sum;
            }
            newVectors[i] = new nDimensionalVector(values);
        }
        return new nDimensionalMatrix(newVectors);
    }

    @Override
    public Matrix<nDimensionalMatrix> transposition() {
        nDimensionalVector[] newVectors = new nDimensionalVector[dimensional];
        for (int i = 0; i < dimensional; i++) {
            double[] values = new double[dimensional];
            for (int j = 0; j < dimensional; j++) {
                values[j] = matrixInVectors[j].getArrValues()[i];
            }
            newVectors[i] = new nDimensionalVector(values);
        }
        return new nDimensionalMatrix(newVectors);
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
        double deter = 0;
        if (dimensional == 2) {
            return matrixInVectors[0].getArrValues()[0] * matrixInVectors[1].getArrValues()[1] -
                    matrixInVectors[1].getArrValues()[0] * matrixInVectors[0].getArrValues()[1];
        }
        for (int k = 0; k < dimensional; k++) {
            nDimensionalVector[] vectors = new nDimensionalVector[dimensional - 1];
            int counter = 0;
            for (int i = 0; i < dimensional; i++) {
                if (i == k) {
                    continue;
                }
                double[] values = new double[dimensional - 1];
                for (int j = 1; j < dimensional; j++) {
                    values[j-1] = matrixInVectors[j].getArrValues()[i];
                }
                vectors[counter] = new nDimensionalVector(values);
                counter++;
            }

            nDimensionalMatrix tmp = new nDimensionalMatrix(vectors);
            double tmpDeter = tmp.getDeterminant();
            if (k % 2 == 0) {
                deter -= tmpDeter * matrixInVectors[0].getArrValues()[k];
            } else {
                deter += tmpDeter * matrixInVectors[0].getArrValues()[k];
            }
        }
        return deter;
    }

    @Override
    public Matrix<nDimensionalMatrix> inverseMatrix() {
        double determinant = this.getDeterminant();
        if (abs(determinant) < 0.000001){
            throw new RuntimeException("Zero determinant");
        }
        nDimensionalVector[] vectors = new nDimensionalVector[dimensional];

        for (int i = 0; i < dimensional; i++){

            double[] values = new double[dimensional];
            for (int j = 0; j < dimensional; j++){
                nDimensionalVector[] vectors1 = new nDimensionalVector[dimensional - 1];
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

                    vectors1[counter] = new nDimensionalVector(values1);
                    counter++;
                }
                values[j] = new nDimensionalMatrix(vectors1).getDeterminant() * Math.pow(-1, i+j+1);
            }
            vectors[i] = new nDimensionalVector(values);
        }
        nDimensionalMatrix matrixMinor = new nDimensionalMatrix(vectors);
        matrixMinor = (nDimensionalMatrix) matrixMinor.transposition();
        double[] values2 = new double[dimensional];
        for (int i = 0; i < dimensional; i++){
            values2[i] = 1/determinant;
        }
        return matrixMinor.multiplyVector(new nDimensionalVector(values2));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        nDimensionalMatrix that = (nDimensionalMatrix) o;
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
        int result = Objects.hash(dimensional);
        result = 31 * result + Arrays.hashCode(matrixInVectors);
        return result;
    }
}
