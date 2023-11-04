package ru.vsu.cs.cg.valyalschikov_d_a.Math.Matrix;

import ru.vsu.cs.cg.valyalschikov_d_a.Math.Vectors.FourDimensionalVector;
import ru.vsu.cs.cg.valyalschikov_d_a.Math.Vectors.ThreeDimensionalVector;
import ru.vsu.cs.cg.valyalschikov_d_a.Math.Vectors.Vector;

public class FourDimensionalMatrix implements Matrix {
    private int dimensional;
    protected FourDimensionalVector[] matrixInVectors;
    FourDimensionalVector vector1;
    FourDimensionalVector vector2;
    FourDimensionalVector vector3;
    FourDimensionalVector vector4;

    public FourDimensionalMatrix(
            FourDimensionalVector vector1,
            FourDimensionalVector vector2,
            FourDimensionalVector vector3,
            FourDimensionalVector vector4) {
        this.vector1 = vector1;
        this.vector2 = vector2;
        this.vector3 = vector3;
        this.vector4 = vector4;
        matrixInVectors = new FourDimensionalVector[]{vector1, vector2, vector3, vector4};
        dimensional = 4;
    }

    public FourDimensionalMatrix() {
        dimensional = 4;
        this.vector1 = new FourDimensionalVector(1, 0, 0, 0);
        this.vector2 = new FourDimensionalVector(0, 1, 0, 0);
        this.vector3 = new FourDimensionalVector(0, 0, 1, 0);
        this.vector4 = new FourDimensionalVector(0, 0, 0, 1);
        matrixInVectors = new FourDimensionalVector[]{
                vector1,
                vector2,
                vector3,
                vector4
        };
    }

    @Override
    public int getDimensional() {
        return dimensional;
    }

    @Override
    public Matrix addition(Matrix matrix) {
    }

    @Override
    public Matrix multiplyMatrix(Matrix vector) {
        return null;
    }

    @Override
    public Matrix transposition() {
        return null;
    }

    @Override
    public void printMatrix() {

    }

    @Override
    public Matrix multiplyVector(Vector vector) {
        return null;
    }

    @Override
    public FourDimensionalVector[] getMatrixInVectors() {
        return matrixInVectors;
    }

    public FourDimensionalVector getVector1() {
        return vector1;
    }

    public FourDimensionalVector getVector2() {
        return vector2;
    }

    public FourDimensionalVector getVector3() {
        return vector3;
    }

    public FourDimensionalVector getVector4() {
        return vector4;
    }
}
