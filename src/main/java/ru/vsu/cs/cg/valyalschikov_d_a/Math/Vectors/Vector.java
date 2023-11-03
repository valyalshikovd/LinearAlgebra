package ru.vsu.cs.cg.valyalschikov_d_a.Math.Vectors;

public interface Vector <T> {
    public static double cosAngleBetweenVectors(Vector vector1, Vector vector2){
        return (vector1.scalarProduct(vector2))/(vector1.length()*vector2.length());
    }
    public T subtraction(T vector);
    public T  addition(T vector);
    public T scale(double a);
    public double length();
    public T normalization();
    public double scalarProduct(T vector);
    public double cosAngleBetweenVectors(T vector);
}
