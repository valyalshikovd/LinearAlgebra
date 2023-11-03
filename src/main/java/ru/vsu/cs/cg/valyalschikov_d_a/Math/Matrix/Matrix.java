package ru.vsu.cs.cg.valyalschikov_d_a.Math.Matrix;

import ru.vsu.cs.cg.valyalschikov_d_a.Math.Vectors.Vector;

public interface Matrix <T>{
    public Vector<?>[] getMatrixInVectors();
    public int getDimensional();

    public double get(int x, int y);

    public Matrix<T> addition(Matrix<T> matrix);

    public Matrix<T> multiplyVector(Vector<?> vector);
    public Matrix<T> multiplyMatrix(Matrix<T> vector);
    public Matrix<T> transposition();
    public void printMatrix();
}
