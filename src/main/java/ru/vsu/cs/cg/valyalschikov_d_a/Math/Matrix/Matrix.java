package ru.vsu.cs.cg.valyalschikov_d_a.Math.Matrix;

import ru.vsu.cs.cg.valyalschikov_d_a.Math.Vectors.Vector;

public interface Matrix {
    public Vector[] getMatrixInVectors();
    public int getDimensional();
    public Matrix addition(Matrix matrix);
    public Vector multiplyVector(Vector vector);
    public Matrix multiplyMatrix(Matrix vector);
    public Matrix transposition();
    public void printMatrix();
    public double getDeterminant();
    public Matrix inverseMatrix();
}
