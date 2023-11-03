package ru.vsu.cs.cg.valyalschikov_d_a.Math.Vectors;

public interface Vector <T> {
    public T subtraction(T a);
    public T  addition(T a);
    public T scale(double a);
    public double length();
    public T normalization();
    public double scalarProduct(T vector);
    public double cosAngleBetweenVectors(T vector);
}
