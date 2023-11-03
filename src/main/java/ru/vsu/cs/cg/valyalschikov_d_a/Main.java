package ru.vsu.cs.cg.valyalschikov_d_a;

import ru.vsu.cs.cg.valyalschikov_d_a.Math.Matrix.ThreeDimensionalMatrix;
import ru.vsu.cs.cg.valyalschikov_d_a.Math.Vectors.ThreeDimensionalVector;

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


        ThreeDimensionalMatrix matrix3 = new ThreeDimensionalMatrix(
                new ThreeDimensionalVector(2, -3, 1),
                new ThreeDimensionalVector(4, 6, 0),
                new ThreeDimensionalVector(-3, -1, 5)
        );

        System.out.println(matrix3.getDeterminant());

        ThreeDimensionalVector vector1 = new ThreeDimensionalVector(2,3,5);
        ThreeDimensionalVector vector2 = new ThreeDimensionalVector(1,2,1);
        System.out.println(Arrays.toString(vector1.vectorProduct(vector2).getArrValues()));
    }
}