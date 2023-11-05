package ru.vsu.cs.cg.valyalschikov_d_a.Math.Vectors;

import static java.lang.Math.abs;

public class ThreeDimensionalVector implements Vector<ThreeDimensionalVector>{

    protected double a;
    protected double b;
    protected double c;
    protected double length;

    public ThreeDimensionalVector(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
        roundVector();
        this.length = Math.pow(a*a + b*b + c*c, 0.5);
        if (length == 0){
            throw new RuntimeException("Zero vector");
        }
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    @Override
    public ThreeDimensionalVector subtraction(ThreeDimensionalVector vector) {
        return new ThreeDimensionalVector(
                this.a - vector.a,
                this.b - vector.b,
                this.c - vector.c
        );
    }

    @Override
    public ThreeDimensionalVector addition(ThreeDimensionalVector vector) {
        return new ThreeDimensionalVector(
                this.a + vector.a,
                this.b + vector.b,
                this.c + vector.c
        );
    }
    public static ThreeDimensionalVector addition(ThreeDimensionalVector vector1, ThreeDimensionalVector vector2){
        return new ThreeDimensionalVector(
                vector1.a + vector2.a,
                vector1.b + vector2.b,
                vector1.c + vector2.c
        );
    }
    public static ThreeDimensionalVector subtraction(ThreeDimensionalVector vector1, ThreeDimensionalVector vector2){
        return new ThreeDimensionalVector(
                vector1.a - vector2.a,
                vector1.b - vector2.b,
                vector1.c - vector2.c
        );
    }

    @Override
    public ThreeDimensionalVector scale(double a) {
        return new ThreeDimensionalVector(
                this.a * a,
                this.b * a,
                this.c * a
        );
    }

    @Override
    public double length() {
        return length;
    }

    @Override
    public ThreeDimensionalVector normalization() {
        return new ThreeDimensionalVector(this.a / length, this.b / length, this.c / length);
    }

    @Override
    public double scalarProduct(ThreeDimensionalVector vector) {
        return this.a * vector.a + this.b * vector.b + this.c * vector.c;
    }

    @Override
    public double cosAngleBetweenVectors(ThreeDimensionalVector vector) {
        return (this.scalarProduct(vector))/(this.length*vector.length);
    }
    @Override
    public double[] getArrValues() {
        return new double[]{a,b,c};
    }

    public ThreeDimensionalVector vectorProduct(ThreeDimensionalVector vector){
        double i = b * vector.getC() - c * vector.getB();
        double j = a * vector.getC() - c * vector.getA();
        double k = b * vector.getA() - a * vector.getB();
        return new ThreeDimensionalVector(i,-j,k);
    }
    private void roundVector(){
        if (abs(a) < 0.0000000001){
            a = 0;
        }
        if (abs(b) < 0.0000000001){
            b = 0;
        }
        if (abs(c) < 0.0000000001){
            c = 0;
        }
    }


}
