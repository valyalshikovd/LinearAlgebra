package ru.vsu.cs.cg.valyalschikov_d_a.Math.Matrix;

import ru.vsu.cs.cg.valyalschikov_d_a.Math.Vectors.ThreeDimensionalVector;
import ru.vsu.cs.cg.valyalschikov_d_a.Math.Vectors.Vector;
import ru.vsu.cs.cg.valyalschikov_d_a.Math.Vectors.nDimensionalVector;

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
                    System.out.println(sum);
                    sum += getMatrixInVectors()[i].getArrValues()[k] * matrix.getMatrixInVectors()[k].getArrValues()[j];
                }
                System.out.println("---");
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
            tmp.printMatrix();
            double tmpDeter = tmp.getDeterminant();
            System.out.println(tmpDeter);
            if (k % 2 == 0) {
                deter -= tmpDeter * matrixInVectors[0].getArrValues()[k];
            } else {
                deter += tmpDeter * matrixInVectors[0].getArrValues()[k];
            }
            System.out.println(deter);
        }
        return deter;
    }

    @Override
    public Matrix<nDimensionalMatrix> inverseMatrix() {
        return null;
    }

}
