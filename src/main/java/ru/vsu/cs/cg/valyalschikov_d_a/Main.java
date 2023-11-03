package ru.vsu.cs.cg.valyalschikov_d_a;

import ru.vsu.cs.cg.valyalschikov_d_a.Math.Vectors.TwoDimensionalVector;
import ru.vsu.cs.cg.valyalschikov_d_a.Math.Vectors.Vector;

public class Main {
    public static void main(String[] args) {
        TwoDimensionalVector vector1 = new TwoDimensionalVector(1, 1);
        TwoDimensionalVector vector2 = new TwoDimensionalVector(1, 0);

        System.out.println(vector1.addition(vector2).length());
        System.out.println(vector1.scalarProduct(vector2));

        System.out.println(Vector.cosAngleBetweenVectors(vector1, vector2));


    }
}