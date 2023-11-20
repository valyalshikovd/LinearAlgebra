package ru.vsu.cs.cg.valyalschikov_d_a;

import ru.vsu.cs.cg.valyalschikov_d_a.Math.Matrix.FourDimensionalMatrix;
import ru.vsu.cs.cg.valyalschikov_d_a.Math.Matrix.ThreeDimensionalMatrix;
import ru.vsu.cs.cg.valyalschikov_d_a.Math.Matrix.NDimensionalMatrix;
import ru.vsu.cs.cg.valyalschikov_d_a.Math.Vectors.FourDimensionalVector;
import ru.vsu.cs.cg.valyalschikov_d_a.Math.Vectors.ThreeDimensionalVector;
import ru.vsu.cs.cg.valyalschikov_d_a.Math.Vectors.NDimensionalVector;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//       ThreeDimensionalMatrix matrix1 = new ThreeDimensionalMatrix();
//       ThreeDimensionalMatrix matrix2 = new ThreeDimensionalMatrix();
//       matrix1.addition(matrix2).multiplyVector(new ThreeDimensionalVector(1,2,3)).printMatrix();


        ThreeDimensionalMatrix matrix1 = new ThreeDimensionalMatrix(
                new ThreeDimensionalVector(5, 3, -7),
                new ThreeDimensionalVector(-1, 6, -3),
                new ThreeDimensionalVector(2, -4, 1)
        );

        ThreeDimensionalMatrix matrix2 = new ThreeDimensionalMatrix(
                new ThreeDimensionalVector(4, -1, 3),
                new ThreeDimensionalVector(4, -2, -6),
                new ThreeDimensionalVector(2, 0, 3)
        );
        matrix1.multiplyMatrix(matrix2).transposition().printMatrix();
        System.out.println("----------------------------------------");
        ThreeDimensionalMatrix matrix3 = new ThreeDimensionalMatrix(
                new ThreeDimensionalVector(2, -3, 1),
                new ThreeDimensionalVector(4, 6, 0),
                new ThreeDimensionalVector(-3, -1, 5)
        );

        System.out.println(matrix3.getDeterminant());

        ThreeDimensionalVector vector1 = new ThreeDimensionalVector(2, 3, 5);
        ThreeDimensionalVector vector2 = new ThreeDimensionalVector(1, 2, 1);
        System.out.println(Arrays.toString(vector1.vectorProduct(vector2).getArrValues()));


        FourDimensionalMatrix fourDimensionalMatrix1 = new FourDimensionalMatrix(
                new FourDimensionalVector(2, 5, 5, 2),
                new FourDimensionalVector(3, 1, 3, 8),
                new FourDimensionalVector(3, 5, 7, 4),
                new FourDimensionalVector(1, 1, 1, 1)
        );

        FourDimensionalMatrix fourDimensionalMatrix2 = new FourDimensionalMatrix(
                new FourDimensionalVector(2, 4, 3, 3),
                new FourDimensionalVector(3, 3, 3, 3),
                new FourDimensionalVector(5, 5, 9, 6),
                new FourDimensionalVector(2, 2, 1, 2)
        );

        //  fourDimensionalMatrix1.multiplyMatrix(fourDimensionalMatrix2).transposition().printMatrix();

        new FourDimensionalMatrix().transposition().printMatrix();

        // new FourDimensionalMatrix().multiplyVector(new FourDimensionalVector(1, 4, 2, 5)).printMatrix();

        System.out.println("Детерминант: " +
                new FourDimensionalMatrix(
                        new FourDimensionalVector(1, 1, 1, -1),
                        new FourDimensionalVector(1, -2, 1, -1),
                        new FourDimensionalVector(1, 1, 3, 1),
                        new FourDimensionalVector(1, 1, 1, -4)
                ).getDeterminant());

        System.out.println("Детерминант: " +
                new FourDimensionalMatrix(
                        new FourDimensionalVector(1, 2, 3, 4),
                        new FourDimensionalVector(5, 6, 7, 8),
                        new FourDimensionalVector(9, 10, 11, 12),
                        new FourDimensionalVector(13, 14, 15, 16)
                ).getDeterminant());

        long startTime = System.nanoTime();
        new ThreeDimensionalMatrix(
                new ThreeDimensionalVector(2, 5, 7),
                new ThreeDimensionalVector(6, 3, 4),
                new ThreeDimensionalVector(5, -2, -3)
        ).inverseMatrix();//.printMatrix();

        FourDimensionalMatrix fourDimensionalMatrix = new FourDimensionalMatrix(
                new FourDimensionalVector(1, 5, 8, 9),
                new FourDimensionalVector(5, 2, 6, 10),
                new FourDimensionalVector(6, 7, 3, 7),
                new FourDimensionalVector(8, 10, 0, 4)
        );
        System.out.println("обратная");
        fourDimensionalMatrix.inverseMatrix().printMatrix();

        System.out.println("транспонирование");
        fourDimensionalMatrix.transposition().printMatrix();


        fourDimensionalMatrix = (FourDimensionalMatrix) fourDimensionalMatrix.multiplyMatrix(fourDimensionalMatrix.inverseMatrix());
        fourDimensionalMatrix.printMatrix();


        ThreeDimensionalMatrix matrix6 = new ThreeDimensionalMatrix(
                new ThreeDimensionalVector(0, 1, 0),
                new ThreeDimensionalVector(2, 2, 2),
                new ThreeDimensionalVector(1, 1, 1)
        );
        System.out.println(matrix6.getDeterminant());


        NDimensionalMatrix ndMatrix1 = new NDimensionalMatrix(
                new NDimensionalVector(1, 36, 35, 34, 33, 32, 31, 30),
                new NDimensionalVector(2, 2, 24, 25, 26, 27, 27, 29),
                new NDimensionalVector(2, 42, 3, 23, 22, 21, 20, 19),
                new NDimensionalVector(2, 42, 32, 4, 15, 16, 17, 18),
                new NDimensionalVector(2, 42, 32, 45, 5, 14, 13, 12),
                new NDimensionalVector(2, 42, 32, 45, 46, 6, 11, 10),
                new NDimensionalVector(2, 42, 32, 45, 46, 35, 7, 9),
                new NDimensionalVector(2, 42, 32, 45, 46, 35, 67, 8)
        );


        NDimensionalMatrix ndMatrix2 = new NDimensionalMatrix(
                new NDimensionalVector(1,12,13,25,26,1000),
                new NDimensionalVector(2, 11,14,24,27,36),
                new NDimensionalVector(3, 10, 15, 23, 28, 35),
                new NDimensionalVector(4, 9, 100, 22, 29, 34),
                new NDimensionalVector(55, 8, 17, 20, 30, 33),
                new NDimensionalVector(6,7,18,19,334,32)

        );

        NDimensionalMatrix ndMatrix3 = new NDimensionalMatrix(
                new NDimensionalVector(12,2,1,22,1,3),
                new NDimensionalVector(12,5,2,1,22,1),
                new NDimensionalVector(13,5,4,2,1,22),
                new NDimensionalVector(14,1,5,4,2,1),
                new NDimensionalVector(15,1,1,5,4,2),
                new NDimensionalVector(16,1,1,1,5,5)
        );
        NDimensionalMatrix ndMatrix4 = new NDimensionalMatrix(
                new NDimensionalVector(1,0,0,0,0,0),
                new NDimensionalVector(0,1,0,0,0,0),
                new NDimensionalVector(0,0,1,0,0,0),
                new NDimensionalVector(0,0,0,1,0,0),
                new NDimensionalVector(0,0,0,0,1,0),
                new NDimensionalVector(0,0,0,0,0,1)
        );
        ndMatrix2.multiplyMatrix(ndMatrix3).printMatrix();

        ndMatrix3.transposition().printMatrix();



        NDimensionalMatrix nd5Matrix = new NDimensionalMatrix(
                new NDimensionalVector(1,2,3),
                new NDimensionalVector(2,1,2),
                new NDimensionalVector(-9,2,1)
        );

       // System.out.println(ndMatrix2.getDeterminant() + "final");
        nd5Matrix.inverseMatrix().printMatrix();

        nd5Matrix.multiplyMatrix(nd5Matrix.inverseMatrix()).printMatrix();
    }

}