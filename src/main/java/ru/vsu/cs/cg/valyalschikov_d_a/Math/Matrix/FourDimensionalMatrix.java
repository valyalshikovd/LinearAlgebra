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
        if(dimensional != matrix.getDimensional()){
            throw new RuntimeException("Неправильная размерность матрицы");
        }
        FourDimensionalVector[] newVectors = new FourDimensionalVector[dimensional];
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
            newVectors[i] = new FourDimensionalVector(values[0],values[1],values[2],values[3]);
        }
        return new FourDimensionalMatrix(newVectors[0],newVectors[1],newVectors[2],newVectors[3]);
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
        if (abs(determinant) < 0.0000001){
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


        matrixMinors = (FourDimensionalMatrix) matrixMinors.transposition();
        return matrixMinors.multiplyVector(new FourDimensionalVector(1 / determinant, 1 / determinant,1 / determinant,1 / determinant));
    }
}
