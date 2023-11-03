package ru.vsu.cs.cg.valyalschikov_d_a.Math.Matrix;

import ru.vsu.cs.cg.valyalschikov_d_a.Math.Vectors.ThreeDimensionalVector;
import ru.vsu.cs.cg.valyalschikov_d_a.Math.Vectors.Vector;

public class ThreeDimensiomalMatrix implements Matrix<ThreeDimensiomalMatrix> {

    private int dimensional;
    protected double[][] matrix;
    protected ThreeDimensionalVector[] matrixInVectors;

    ThreeDimensionalVector vector1;
    ThreeDimensionalVector vector2;
    ThreeDimensionalVector vector3;

    public ThreeDimensiomalMatrix(ThreeDimensionalVector vector1,
                                  ThreeDimensionalVector vector2,
                                  ThreeDimensionalVector vector3) {
        this.vector1 = vector1;
        this.vector2 = vector2;
        this.vector3 = vector3;
        matrixInVectors = new ThreeDimensionalVector[]{vector1, vector2, vector3};
        dimensional = 3;
    }

    public ThreeDimensiomalMatrix() {
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
        if (matrix.getDimensional() != 3) {
            throw new RuntimeException("Матрица не той размерности");
        }
        return new ThreeDimensiomalMatrix(
                vector1.addition((ThreeDimensionalVector) matrix.getMatrixInVectors()[0]),
                vector2.addition((ThreeDimensionalVector) matrix.getMatrixInVectors()[1]),
                vector3.addition((ThreeDimensionalVector) matrix.getMatrixInVectors()[2])
        );
    }

    @Override
    public Matrix<ThreeDimensiomalMatrix> multiplyVector(Vector<?> vector) {
        double[] values = vector.getArrValues();
        if (values.length != 3) {
            throw new RuntimeException("Матрица не той размерности");
        }


        return new ThreeDimensiomalMatrix(
                vector1.scale(values[0]),
                vector2.scale(values[1]),
                vector3.scale(values[2])
        );
    }

    @Override
    public Matrix<ThreeDimensiomalMatrix> multiplyMatrix(Matrix<ThreeDimensiomalMatrix> matrix) {
        Vector[] vectors = matrix.getMatrixInVectors();


        ThreeDimensionalVector resVector1 = new ThreeDimensionalVector(
                vectors[0].getArrValues()[0] * vector1.getA() + vectors[1].getArrValues()[0] * vector1.getB() + vectors[2].getArrValues()[0] * vector1.getC(),
                vectors[0].getArrValues()[1] * vector1.getA() + vectors[1].getArrValues()[1] * vector1.getB() + vectors[2].getArrValues()[1] * vector1.getC(),
                vectors[0].getArrValues()[2] * vector1.getA() + vectors[1].getArrValues()[2] * vector1.getB() + vectors[2].getArrValues()[2] * vector1.getC());

        ThreeDimensionalVector resVector2 = new ThreeDimensionalVector(
                vectors[0].getArrValues()[0] * vector2.getA() + vectors[1].getArrValues()[0] * vector2.getB() + vectors[2].getArrValues()[0] * vector2.getC(),
                vectors[0].getArrValues()[1] * vector2.getA() + vectors[1].getArrValues()[1] * vector2.getB() + vectors[2].getArrValues()[1] * vector2.getC(),
                vectors[0].getArrValues()[2] * vector2.getA() + vectors[1].getArrValues()[2] * vector2.getB() + vectors[2].getArrValues()[2] * vector2.getC());


        ThreeDimensionalVector resVector3 = new ThreeDimensionalVector(
                vectors[0].getArrValues()[0] * vector3.getA() + vectors[1].getArrValues()[0] * vector3.getB() + vectors[2].getArrValues()[0] * vector3.getC(),
                vectors[0].getArrValues()[1] * vector3.getA() + vectors[1].getArrValues()[1] * vector3.getB() + vectors[2].getArrValues()[1] * vector3.getC(),
                vectors[0].getArrValues()[2] * vector3.getA() + vectors[1].getArrValues()[2] * vector3.getB() + vectors[2].getArrValues()[2] * vector3.getC());

        return new ThreeDimensiomalMatrix(resVector1, resVector2, resVector3);
    }

    @Override
    public Matrix<ThreeDimensiomalMatrix> transposition() {


        ThreeDimensionalVector res1 = new ThreeDimensionalVector(vector1.getA(), vector2.getA(), vector3.getA());
        ThreeDimensionalVector res2 = new ThreeDimensionalVector(vector1.getB(), vector2.getB(), vector3.getB());
        ThreeDimensionalVector res3 = new ThreeDimensionalVector(vector1.getC(), vector2.getC(), vector3.getC());

        return new ThreeDimensiomalMatrix(res1, res2, res3);

    }

    @Override
    public void printMatrix() {
        System.out.println("-----------");
        System.out.println(vector1.getA() + " " + vector2.getA() + " " + vector3.getA());
        System.out.println(vector1.getB() + " " + vector2.getB() + " " + vector3.getB());
        System.out.println(vector1.getC() + " " + vector2.getC() + " " + vector3.getC());
        System.out.println("-----------");
    }

    public double getDeterminant(){
        return vector1.getA() * vector2.getB() * vector3.getC() + vector2.getA() * vector3.getB() * vector1.getC() +  vector3.getA() * vector1.getB() * vector2.getC() -
                vector3.getA() * vector2.getB() * vector1.getC() -  vector1.getB() * vector2.getA() * vector3.getC() - vector1.getA() * vector2.getC() * vector3.getB();
    }
}
