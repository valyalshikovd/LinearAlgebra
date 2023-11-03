package ru.vsu.cs.cg.valyalschikov_d_a.Math.Vectors;

public class TwoDimensionalVector implements Vector<TwoDimensionalVector> {

    protected  double a;
    protected double b;
    protected double length;

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public TwoDimensionalVector(double a, double b) {
        this.a = a;
        this.b = b;
        this.length = Math.pow(a*a + b*b, 0.5);
        if (length == 0){
            throw new RuntimeException("Zero vector");
        }
    }
    public static TwoDimensionalVector addition(TwoDimensionalVector a, TwoDimensionalVector b){
        return new TwoDimensionalVector(a.getA() + b.getA(), a.getB() + b.getB());
    }
    @Override
    public TwoDimensionalVector addition(TwoDimensionalVector vector) {
        return new TwoDimensionalVector(vector.getA() + this.getA(), vector.getB() + this.getB());
    }


    public static TwoDimensionalVector subtraction(TwoDimensionalVector a, TwoDimensionalVector b){
        return new TwoDimensionalVector(a.getA() - b.getA(), a.getB() - b.getB());
    }
    @Override
    public TwoDimensionalVector subtraction(TwoDimensionalVector vector) {
        return new TwoDimensionalVector(this.getA() - vector.getA() , this.getB() - vector.getB());
    }


    public static TwoDimensionalVector scale(double a, TwoDimensionalVector vector) {
        return  new TwoDimensionalVector(vector.getA() * a, vector.getB() * a);
    }
    @Override
    public TwoDimensionalVector scale(double a) {
        return new TwoDimensionalVector(this.getA() * a, this.getB() * a);
    }

    @Override
    public double length() {
        return this.length;
    }

    @Override
    public TwoDimensionalVector normalization() {
        return new TwoDimensionalVector(this.a / length, this.b / length);
    }
    @Override
    public double scalarProduct(TwoDimensionalVector vector) {
        return this.a * vector.a + this.b * vector.b;
    }


    public static double scalarProduct(TwoDimensionalVector vector1, TwoDimensionalVector vector2){
        return vector1.length * vector2.length * vector1.cosAngleBetweenVectors( vector2);
    }

    @Override
    public double cosAngleBetweenVectors(TwoDimensionalVector vector) {
        return (this.scalarProduct(vector))/(this.length*vector.length);
    }


}
