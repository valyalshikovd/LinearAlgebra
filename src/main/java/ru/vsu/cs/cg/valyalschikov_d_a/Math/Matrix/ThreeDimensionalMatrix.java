package ru.vsu.cs.cg.valyalschikov_d_a.Math.Matrix;

import ru.vsu.cs.cg.valyalschikov_d_a.Math.Vectors.ThreeDimensionalVector;
import ru.vsu.cs.cg.valyalschikov_d_a.Math.Vectors.Vector;
import ru.vsu.cs.cg.valyalschikov_d_a.Math.Vectors.nDimensionalVector;

import static java.lang.Math.abs;

public class ThreeDimensionalMatrix implements Matrix<ThreeDimensionalMatrix> {

    private int dimensional;
    protected ThreeDimensionalVector[] matrixInVectors;

    ThreeDimensionalVector vector1;
    ThreeDimensionalVector vector2;
    ThreeDimensionalVector vector3;

    public ThreeDimensionalMatrix(ThreeDimensionalVector vector1,
                                  ThreeDimensionalVector vector2,
                                  ThreeDimensionalVector vector3) {
        this.vector1 = vector1;
        this.vector2 = vector2;
        this.vector3 = vector3;
        matrixInVectors = new ThreeDimensionalVector[]{vector1, vector2, vector3};
        dimensional = 3;
    }

    public ThreeDimensionalMatrix() {
        dimensional = 3;
        this.vector1 = new ThreeDimensionalVector(1, 0, 0);
        this.vector2 = new ThreeDimensionalVector(0, 1, 0);
        this.vector3 = new ThreeDimensionalVector(0, 0, 1);
        matrixInVectors = new ThreeDimensionalVector[]{
                vector1,
                vector2,
                vector3
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
    public Matrix<ThreeDimensionalMatrix> addition(Matrix<ThreeDimensionalMatrix> matrix) {
        if (matrix.getDimensional() != 3) {
            throw new RuntimeException("Матрица не той размерности");
        }
        return new ThreeDimensionalMatrix(
                vector1.addition((ThreeDimensionalVector) matrix.getMatrixInVectors()[0]),
                vector2.addition((ThreeDimensionalVector) matrix.getMatrixInVectors()[1]),
                vector3.addition((ThreeDimensionalVector) matrix.getMatrixInVectors()[2])
        );
    }

    @Override
    public Matrix<ThreeDimensionalMatrix> multiplyVector(Vector<?> vector) {
        double[] values = vector.getArrValues();
        if (values.length != 3) {
            throw new RuntimeException("Матрица не той размерности");
        }


        return new ThreeDimensionalMatrix(
                vector1.scale(values[0]),
                vector2.scale(values[1]),
                vector3.scale(values[2])
        );
    }

    @Override
    public Matrix<ThreeDimensionalMatrix> multiplyMatrix(Matrix<ThreeDimensionalMatrix> matrix) {
        if(dimensional != matrix.getDimensional()){
            throw new RuntimeException("Неправильная размерность матрицы");
        }
        ThreeDimensionalVector[] newVectors = new ThreeDimensionalVector[dimensional];
        for (int i = 0; i < dimensional; i++){
            double[] values = new double[dimensional];
            for (int j = 0; j < dimensional; j++){
                double sum = 0;
                for(int k = 0; k < dimensional; k++){
                    System.out.println(sum);
                    //  sum += getMatrixInVectors()[k].getArrValues()[j] * matrix.getMatrixInVectors()[i].getArrValues()[k];
                    sum += getMatrixInVectors()[i].getArrValues()[k] * matrix.getMatrixInVectors()[k].getArrValues()[j];
                }
                System.out.println("---");
                values[j] = sum;
            }
            newVectors[i] = new ThreeDimensionalVector(values[0],values[1],values[2]);
        }
        return new ThreeDimensionalMatrix(newVectors[0],newVectors[1],newVectors[2]);
    }

    @Override
    public Matrix<ThreeDimensionalMatrix> transposition() {


        ThreeDimensionalVector res1 = new ThreeDimensionalVector(vector1.getA(), vector2.getA(), vector3.getA());
        ThreeDimensionalVector res2 = new ThreeDimensionalVector(vector1.getB(), vector2.getB(), vector3.getB());
        ThreeDimensionalVector res3 = new ThreeDimensionalVector(vector1.getC(), vector2.getC(), vector3.getC());

        return new ThreeDimensionalMatrix(res1, res2, res3);

    }

    //    @Override
    public void printMatrix() {
        System.out.println("-----------");
        System.out.println(vector1.getA() + " " + vector2.getA() + " " + vector3.getA());
        System.out.println(vector1.getB() + " " + vector2.getB() + " " + vector3.getB());
        System.out.println(vector1.getC() + " " + vector2.getC() + " " + vector3.getC());
        System.out.println("-----------");
    }

    @Override
    public double getDeterminant() {
        return vector1.getA() * vector2.getB() * vector3.getC() + vector2.getA() * vector3.getB() * vector1.getC() + vector3.getA() * vector1.getB() * vector2.getC() -
                vector3.getA() * vector2.getB() * vector1.getC() - vector1.getB() * vector2.getA() * vector3.getC() - vector1.getA() * vector2.getC() * vector3.getB();
    }

    @Override
    public Matrix<ThreeDimensionalMatrix> inverseMatrix() {
        double determinant = getDeterminant();
        if (abs(determinant) < 0.000001) {
            throw new RuntimeException("Zero determinant");
        }

        ThreeDimensionalMatrix matrixMinors =
                new ThreeDimensionalMatrix(
                        new ThreeDimensionalVector(
                                vector2.getB() * vector3.getC() - vector3.getB() * vector2.getC(),
                                -(vector2.getA() * vector3.getC() - vector3.getA() * vector2.getC()),
                                -vector2.getB() * vector3.getA() + vector3.getB() * vector2.getA()),
                        new ThreeDimensionalVector(
                                -(vector1.getB() * vector3.getC() - vector1.getC() * vector3.getB()),
                                (vector1.getA() * vector3.getC() - vector1.getC() * vector3.getA()),
                                -vector1.getB() * vector3.getA() + vector1.getB() * vector3.getA()),
                        new ThreeDimensionalVector(
                                vector1.getB() * vector2.getC() - vector1.getC() * vector2.getB(),
                                -(vector1.getA() * vector2.getC() - vector1.getC() * vector2.getA()),
                                -vector1.getB() * vector2.getA() + vector1.getA() * vector2.getB())
                );
        matrixMinors = (ThreeDimensionalMatrix) matrixMinors.transposition();
        return matrixMinors.multiplyVector(new ThreeDimensionalVector(1 / determinant, 1 / determinant, 1 / determinant));
    }
}
