package ru.vsu.cs.cg.valyalschikov_d_a.Math.Matrix;

import ru.vsu.cs.cg.valyalschikov_d_a.Math.Vectors.FourDimensionalVector;
import ru.vsu.cs.cg.valyalschikov_d_a.Math.Vectors.ThreeDimensionalVector;
import ru.vsu.cs.cg.valyalschikov_d_a.Math.Vectors.Vector;

import static java.lang.Math.abs;

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
        if (matrix.getDimensional() != 4) {
            throw new RuntimeException("Матрица не той размерности");
        }
        return new FourDimensionalMatrix(
                vector1.addition((FourDimensionalVector) matrix.getMatrixInVectors()[0]),
                vector2.addition((FourDimensionalVector) matrix.getMatrixInVectors()[1]),
                vector3.addition((FourDimensionalVector) matrix.getMatrixInVectors()[2]),
                vector3.addition((FourDimensionalVector) matrix.getMatrixInVectors()[3])
        );
    }

    @Override
    public Matrix multiplyMatrix(Matrix matrix) {
        if (matrix.getDimensional() != 4) {
            throw new RuntimeException("Матрица не той размерности");
        }
        Vector[] vectors = matrix.getMatrixInVectors();


        FourDimensionalVector resVector1 = new FourDimensionalVector(
                vectors[0].getArrValues()[0] * vector1.getA() + vectors[1].getArrValues()[0] * vector1.getB() + vectors[2].getArrValues()[0] * vector1.getC() + vectors[3].getArrValues()[0] * vector1.getD(),
                vectors[0].getArrValues()[1] * vector1.getA() + vectors[1].getArrValues()[1] * vector1.getB() + vectors[2].getArrValues()[1] * vector1.getC() + vectors[3].getArrValues()[1] * vector1.getD(),
                vectors[0].getArrValues()[2] * vector1.getA() + vectors[1].getArrValues()[2] * vector1.getB() + vectors[2].getArrValues()[2] * vector1.getC() + vectors[3].getArrValues()[2] * vector1.getD(),
                vectors[0].getArrValues()[3] * vector1.getA() + vectors[1].getArrValues()[3] * vector1.getB() + vectors[2].getArrValues()[3] * vector1.getC() + vectors[3].getArrValues()[3] * vector1.getD());

        FourDimensionalVector resVector2 = new FourDimensionalVector(
                vectors[0].getArrValues()[0] * vector2.getA() + vectors[1].getArrValues()[0] * vector2.getB() + vectors[2].getArrValues()[0] * vector2.getC() + vectors[3].getArrValues()[0] * vector2.getD(),
                vectors[0].getArrValues()[1] * vector2.getA() + vectors[1].getArrValues()[1] * vector2.getB() + vectors[2].getArrValues()[1] * vector2.getC() + vectors[3].getArrValues()[1] * vector2.getD(),
                vectors[0].getArrValues()[2] * vector2.getA() + vectors[1].getArrValues()[2] * vector2.getB() + vectors[2].getArrValues()[2] * vector2.getC() + vectors[3].getArrValues()[2] * vector2.getD(),
                vectors[0].getArrValues()[3] * vector2.getA() + vectors[1].getArrValues()[3] * vector2.getB() + vectors[2].getArrValues()[3] * vector2.getC() + vectors[3].getArrValues()[3] * vector2.getD());


        FourDimensionalVector resVector3 = new FourDimensionalVector(
                vectors[0].getArrValues()[0] * vector3.getA() + vectors[1].getArrValues()[0] * vector3.getB() + vectors[2].getArrValues()[0] * vector3.getC()  + vectors[3].getArrValues()[0] * vector3.getD(),
                vectors[0].getArrValues()[1] * vector3.getA() + vectors[1].getArrValues()[1] * vector3.getB() + vectors[2].getArrValues()[1] * vector3.getC() + vectors[3].getArrValues()[1] * vector3.getD(),
                vectors[0].getArrValues()[2] * vector3.getA() + vectors[1].getArrValues()[2] * vector3.getB() + vectors[2].getArrValues()[2] * vector3.getC() + vectors[3].getArrValues()[2] * vector3.getD(),
                vectors[0].getArrValues()[3] * vector3.getA() + vectors[1].getArrValues()[3] * vector3.getB() + vectors[2].getArrValues()[3] * vector3.getC() + vectors[3].getArrValues()[3] * vector3.getD());

        FourDimensionalVector resVector4 = new FourDimensionalVector(
                vectors[0].getArrValues()[0] * vector4.getA() + vectors[1].getArrValues()[0] * vector4.getB() + vectors[2].getArrValues()[0] * vector4.getC()  + vectors[3].getArrValues()[0] * vector4.getD(),
                vectors[0].getArrValues()[1] * vector4.getA() + vectors[1].getArrValues()[1] * vector4.getB() + vectors[2].getArrValues()[1] * vector4.getC() + vectors[3].getArrValues()[1] * vector4.getD(),
                vectors[0].getArrValues()[2] * vector4.getA() + vectors[1].getArrValues()[2] * vector4.getB() + vectors[2].getArrValues()[2] * vector4.getC() + vectors[3].getArrValues()[2] * vector4.getD(),
                vectors[0].getArrValues()[3] * vector4.getA() + vectors[1].getArrValues()[3] * vector4.getB() + vectors[2].getArrValues()[3] * vector4.getC() + vectors[3].getArrValues()[3] * vector4.getD());

        return new FourDimensionalMatrix(resVector1, resVector2, resVector3, resVector4);
    }

    @Override
    public FourDimensionalMatrix transposition() {

        FourDimensionalVector res1 = new FourDimensionalVector(vector1.getA(), vector2.getA(), vector3.getA(), vector4.getA());
        FourDimensionalVector res2 = new FourDimensionalVector(vector1.getB(), vector2.getB(), vector3.getB(), vector4.getB());
        FourDimensionalVector res3 = new FourDimensionalVector(vector1.getC(), vector2.getC(), vector3.getC(), vector4.getC());
        FourDimensionalVector res4 = new FourDimensionalVector(vector1.getD(), vector2.getD(), vector3.getD(), vector4.getD());

        return new FourDimensionalMatrix(res1, res2, res3, res4);
    }

   // @Override
    public void printMatrix() {
        System.out.println("-----------");
        System.out.println(vector1.getA() + " " + vector2.getA() + " " + vector3.getA() + " " + vector4.getA());
        System.out.println(vector1.getB() + " " + vector2.getB() + " " + vector3.getB() + " " + vector4.getB());
        System.out.println(vector1.getC() + " " + vector2.getC() + " " + vector3.getC() + " " + vector4.getC());
        System.out.println(vector1.getD() + " " + vector2.getD() + " " + vector3.getD() + " " + vector4.getD());
        System.out.println("-----------");
    }

    @Override
    public Matrix multiplyVector(Vector vector) {
        double[] values = vector.getArrValues();
        if (values.length != 4) {
            throw new RuntimeException("Матрица не той размерности");
        }
        return new FourDimensionalMatrix(
                vector1.scale(values[0]),
                vector2.scale(values[1]),
                vector3.scale(values[2]),
                vector4.scale(values[3])
        );
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

    @Override
    public double getDeterminant(){
        double firstMinor = new ThreeDimensionalMatrix(
                new ThreeDimensionalVector(vector2.getB(), vector2.getC() ,vector2.getD()),
                new ThreeDimensionalVector(vector3.getB(), vector3.getC() ,vector3.getD()),
                new ThreeDimensionalVector(vector4.getB(), vector4.getC() ,vector4.getD()))
                .getDeterminant() * vector1.getA();
        double secondMinor = new ThreeDimensionalMatrix(
                new ThreeDimensionalVector(vector2.getA(), vector2.getC() ,vector2.getD()),
                new ThreeDimensionalVector(vector3.getA(), vector3.getC() ,vector3.getD()),
                new ThreeDimensionalVector(vector4.getA(), vector4.getC() ,vector4.getD()))
                .getDeterminant() * -vector1.getB();
        double thirdMinor = new ThreeDimensionalMatrix(
                new ThreeDimensionalVector(vector2.getA(), vector2.getB() ,vector2.getD()),
                new ThreeDimensionalVector(vector3.getA(), vector3.getB() ,vector3.getD()),
                new ThreeDimensionalVector(vector4.getA(), vector4.getB() ,vector4.getD()))
                .getDeterminant() * vector1.getC();
        double fourthMinor = new ThreeDimensionalMatrix(
                new ThreeDimensionalVector(vector2.getA(), vector2.getB() ,vector2.getC()),
                new ThreeDimensionalVector(vector3.getA(), vector3.getB() ,vector3.getC()),
                new ThreeDimensionalVector(vector4.getA(), vector4.getB() ,vector4.getC()))
                .getDeterminant() * -vector1.getD();
        return firstMinor + secondMinor + thirdMinor + fourthMinor;
    }

    @Override
    public Matrix inverseMatrix(){
        double determinant = this.getDeterminant();
        if (abs(determinant) < 0.000001){
            throw new RuntimeException("Zero determinant");
        }

        FourDimensionalMatrix matrixMinors =
                new FourDimensionalMatrix(
                        new FourDimensionalVector(
                                new ThreeDimensionalMatrix(
                                        new ThreeDimensionalVector(vector2.getB(), vector2.getC(), vector2.getD()),
                                        new ThreeDimensionalVector(vector3.getB(), vector3.getC(), vector3.getD()),
                                        new ThreeDimensionalVector(vector4.getB(), vector4.getC(), vector4.getD())
                                ).getDeterminant(),
                                new ThreeDimensionalMatrix(
                                        new ThreeDimensionalVector(vector2.getA(), vector2.getC(), vector2.getD()),
                                        new ThreeDimensionalVector(vector3.getA(), vector3.getC(), vector3.getD()),
                                        new ThreeDimensionalVector(vector4.getA(), vector4.getC(), vector4.getD())
                                ).getDeterminant() * -1,
                                new ThreeDimensionalMatrix(
                                        new ThreeDimensionalVector(vector2.getA(), vector2.getB(), vector2.getD()),
                                        new ThreeDimensionalVector(vector3.getA(), vector3.getB(), vector3.getD()),
                                        new ThreeDimensionalVector(vector4.getA(), vector4.getB(), vector4.getD())
                                ).getDeterminant(),
                                new ThreeDimensionalMatrix(
                                        new ThreeDimensionalVector(vector2.getA(), vector2.getB(), vector2.getC()),
                                        new ThreeDimensionalVector(vector3.getA(), vector3.getB(), vector3.getC()),
                                        new ThreeDimensionalVector(vector4.getA(), vector4.getB(), vector4.getC())
                                ).getDeterminant() * -1
                        ),


                        new FourDimensionalVector(
                                new ThreeDimensionalMatrix(
                                        new ThreeDimensionalVector(vector1.getB(), vector1.getC(), vector1.getD()),
                                        new ThreeDimensionalVector(vector3.getB(), vector3.getC(), vector3.getD()),
                                        new ThreeDimensionalVector(vector4.getB(), vector4.getC(), vector4.getD())
                                ).getDeterminant()* -1,
                                new ThreeDimensionalMatrix(
                                        new ThreeDimensionalVector(vector1.getA(), vector1.getC(), vector1.getD()),
                                        new ThreeDimensionalVector(vector3.getA(), vector3.getC(), vector3.getD()),
                                        new ThreeDimensionalVector(vector4.getA(), vector4.getC(), vector4.getD())
                                ).getDeterminant(),
                                new ThreeDimensionalMatrix(
                                        new ThreeDimensionalVector(vector1.getA(), vector1.getB(), vector1.getD()),
                                        new ThreeDimensionalVector(vector3.getA(), vector3.getB(), vector3.getD()),
                                        new ThreeDimensionalVector(vector4.getA(), vector4.getB(), vector4.getD())
                                ).getDeterminant()* -1,
                                new ThreeDimensionalMatrix(
                                        new ThreeDimensionalVector(vector1.getA(), vector1.getB(), vector1.getC()),
                                        new ThreeDimensionalVector(vector3.getA(), vector3.getB(), vector3.getC()),
                                        new ThreeDimensionalVector(vector4.getA(), vector4.getB(), vector4.getC())
                                ).getDeterminant()
                        ),

                        new FourDimensionalVector(
                                new ThreeDimensionalMatrix(
                                        new ThreeDimensionalVector(vector1.getB(), vector1.getC(), vector1.getD()),
                                        new ThreeDimensionalVector(vector2.getB(), vector2.getC(), vector2.getD()),
                                        new ThreeDimensionalVector(vector4.getB(), vector4.getC(), vector4.getD())
                                ).getDeterminant(),
                                new ThreeDimensionalMatrix(
                                        new ThreeDimensionalVector(vector1.getA(), vector1.getC(), vector1.getD()),
                                        new ThreeDimensionalVector(vector2.getA(), vector2.getC(), vector2.getD()),
                                        new ThreeDimensionalVector(vector4.getA(), vector4.getC(), vector4.getD())
                                ).getDeterminant()* -1,
                                new ThreeDimensionalMatrix(
                                        new ThreeDimensionalVector(vector1.getA(), vector1.getB(), vector1.getD()),
                                        new ThreeDimensionalVector(vector2.getA(), vector2.getB(), vector2.getD()),
                                        new ThreeDimensionalVector(vector4.getA(), vector4.getB(), vector4.getD())
                                ).getDeterminant(),
                                new ThreeDimensionalMatrix(
                                        new ThreeDimensionalVector(vector1.getA(), vector1.getB(), vector1.getC()),
                                        new ThreeDimensionalVector(vector2.getA(), vector2.getB(), vector2.getC()),
                                        new ThreeDimensionalVector(vector4.getA(), vector4.getB(), vector4.getC())
                                ).getDeterminant()* -1
                        ),
                        new FourDimensionalVector(
                                new ThreeDimensionalMatrix(
                                        new ThreeDimensionalVector(vector1.getB(), vector1.getC(), vector1.getD()),
                                        new ThreeDimensionalVector(vector2.getB(), vector2.getC(), vector2.getD()),
                                        new ThreeDimensionalVector(vector3.getB(), vector3.getC(), vector3.getD())
                                ).getDeterminant() * -1,
                                new ThreeDimensionalMatrix(
                                        new ThreeDimensionalVector(vector1.getA(), vector1.getC(), vector1.getD()),
                                        new ThreeDimensionalVector(vector2.getA(), vector2.getC(), vector2.getD()),
                                        new ThreeDimensionalVector(vector3.getA(), vector3.getC(), vector3.getD())
                                ).getDeterminant(),
                                new ThreeDimensionalMatrix(
                                        new ThreeDimensionalVector(vector1.getA(), vector1.getB(), vector1.getD()),
                                        new ThreeDimensionalVector(vector2.getA(), vector2.getB(), vector2.getD()),
                                        new ThreeDimensionalVector(vector3.getA(), vector3.getB(), vector3.getD())
                                ).getDeterminant() * -1,
                                new ThreeDimensionalMatrix(
                                        new ThreeDimensionalVector(vector1.getA(), vector1.getB(), vector1.getC()),
                                        new ThreeDimensionalVector(vector2.getA(), vector2.getB(), vector2.getC()),
                                        new ThreeDimensionalVector(vector3.getA(), vector3.getB(), vector3.getC())
                                ).getDeterminant()
                        )
                );

        System.out.println(determinant);
        matrixMinors.transposition().printMatrix();
        matrixMinors = (FourDimensionalMatrix) matrixMinors.transposition();
        return matrixMinors.multiplyVector(new FourDimensionalVector(1 / determinant, 1 / determinant,1 / determinant,1 / determinant));
    }
}
