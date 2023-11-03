package ru.vsu.cs.cg.valyalschikov_d_a.Math.Matrix;

import ru.vsu.cs.cg.valyalschikov_d_a.Math.Vectors.ThreeDimensionalVector;
import ru.vsu.cs.cg.valyalschikov_d_a.Math.Vectors.Vector;

public class ThreeDimensiomalMatrix implements Matrix<ThreeDimensiomalMatrix>{

    private int dimensional;
    protected double[][] matrix;
    protected ThreeDimensionalVector[] matrixInVectors;
    public ThreeDimensiomalMatrix(ThreeDimensionalVector vector1,
                                  ThreeDimensionalVector vector2,
                                  ThreeDimensionalVector vector3) {
        matrixInVectors = new ThreeDimensionalVector[]{vector1, vector2, vector3};
        dimensional = 3;
    }
    public ThreeDimensiomalMatrix(){
        dimensional = 3;
        matrixInVectors = new ThreeDimensionalVector[]{
                new ThreeDimensionalVector(1, 0, 0),
                new ThreeDimensionalVector(0, 1, 0),
                new ThreeDimensionalVector(0, 0, 1)
        };
    }
    @Override
    public int getDimensional() {
        return dimensional;
    }
    @Override
    public Vector<ThreeDimensionalVector>[] getMatrixInVectors() {
        return matrixInVectors;
    }

    @Override
    public double get(int x, int y) {
        return 0;
    }

    @Override
    public Matrix<ThreeDimensiomalMatrix> addition(Matrix<ThreeDimensiomalMatrix> matrix) {
        if(matrix.getDimensional() != 3){
            throw new RuntimeException("Матрица не той размерности");
        }
        return new ThreeDimensiomalMatrix(
                matrixInVectors[0].addition((ThreeDimensionalVector) matrix.getMatrixInVectors()[0]),
                matrixInVectors[1].addition((ThreeDimensionalVector) matrix.getMatrixInVectors()[1]),
                matrixInVectors[2].addition((ThreeDimensionalVector) matrix.getMatrixInVectors()[2])
        );
    }

    @Override
    public Matrix<ThreeDimensiomalMatrix> multiplyVector(Vector<?> vector) {
        double[] values = vector.getArrValues();
        if(values.length != 3){
            throw new RuntimeException("Матрица не той размерности");
        }
        ThreeDimensionalVector vector1 = matrixInVectors[0];
        ThreeDimensionalVector vector2 = matrixInVectors[1];
        ThreeDimensionalVector vector3 = matrixInVectors[2];

        return new ThreeDimensiomalMatrix(
                vector1.scale(values[0]),
                vector2.scale(values[1]),
                vector3.scale(values[2])
        );
    }

    @Override
    public Matrix<ThreeDimensiomalMatrix> multiplyMatrix(Matrix<ThreeDimensiomalMatrix> matrix) {
        Vector[] vectors = matrix.getMatrixInVectors();

    }

    @Override
    public Matrix <ThreeDimensiomalMatrix>transposition() {
        return null;
    }

    @Override
    public void printMatrix() {
        System.out.println("-----------");
        System.out.println(matrixInVectors[0].getA() + " " + matrixInVectors[1].getA() + " " + matrixInVectors[2].getA());
        System.out.println(matrixInVectors[0].getB() + " " + matrixInVectors[1].getB() + " " + matrixInVectors[2].getB());
        System.out.println(matrixInVectors[0].getC() + " " + matrixInVectors[1].getC() + " " + matrixInVectors[2].getC());
        System.out.println("-----------");
    }
}
