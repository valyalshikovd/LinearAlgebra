package ru.vsu.cs.cg.valyalschikov_d_a.Tests;

import ru.vsu.cs.cg.valyalschikov_d_a.Math.Matrix.nDimensionalMatrix;
import ru.vsu.cs.cg.valyalschikov_d_a.Math.Vectors.nDimensionalVector;

import static org.junit.jupiter.api.Assertions.*;

class MatrixTest {

    @org.junit.jupiter.api.Test
    void addition() {
        nDimensionalMatrix ndMatrix3 = new nDimensionalMatrix(
                new nDimensionalVector(12, 2, 1, 22, 1, 3),
                new nDimensionalVector(12, 5, 2, 1, 22, 1),
                new nDimensionalVector(13, 5, 4, 2, 1, 22),
                new nDimensionalVector(14, 1, 5, 4, 2, 1),
                new nDimensionalVector(15, 1, 1, 5, 4, 2),
                new nDimensionalVector(16, 1, 1, 1, 5, 5)
        );
        nDimensionalMatrix ndMatrix4 = new nDimensionalMatrix(
                new nDimensionalVector(1, 0, 0, 0, 0, 0),
                new nDimensionalVector(0, 1, 0, 0, 0, 0),
                new nDimensionalVector(0, 0, 1, 0, 0, 0),
                new nDimensionalVector(0, 0, 0, 1, 0, 0),
                new nDimensionalVector(0, 0, 0, 0, 1, 0),
                new nDimensionalVector(0, 0, 0, 0, 0, 1)
        );
        assertEquals(true, ndMatrix3.addition(ndMatrix4).equals(
                new nDimensionalMatrix(
                        new nDimensionalVector(13, 2, 1, 22, 1, 3),
                        new nDimensionalVector(12, 6, 2, 1, 22, 1),
                        new nDimensionalVector(13, 5, 5, 2, 1, 22),
                        new nDimensionalVector(14, 1, 5, 5, 2, 1),
                        new nDimensionalVector(15, 1, 1, 5, 5, 2),
                        new nDimensionalVector(16, 1, 1, 1, 5, 6)
                )
        ));
        assertThrows(ArithmeticException.class, () -> ndMatrix3.addition(new nDimensionalMatrix(
                new nDimensionalVector(13, 2, 1),
                new nDimensionalVector(12, 6, 2),
                new nDimensionalVector(13, 5, 5)
        )));

    }

    @org.junit.jupiter.api.Test
    void multiplyVector() {
    }

    @org.junit.jupiter.api.Test
    void multiplyMatrix() {
    }

    @org.junit.jupiter.api.Test
    void transposition() {
    }

    @org.junit.jupiter.api.Test
    void getDeterminant() {
    }
}