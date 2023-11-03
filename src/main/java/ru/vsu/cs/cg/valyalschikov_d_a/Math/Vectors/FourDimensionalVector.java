package ru.vsu.cs.cg.valyalschikov_d_a.Math.Vectors;

public class FourDimensionalVector implements Vector<FourDimensionalVector>{
    protected double a;
    protected double b;
    protected double c;
    protected double d;
    protected double length;
    public FourDimensionalVector(double a, double b, double c, double d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.length = Math.pow(a*a + b*b + c*c + d*d, 0.5);
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

    public double getD() {
        return d;
    }

    @Override
    public FourDimensionalVector subtraction(FourDimensionalVector vector) {
        return new FourDimensionalVector(
                this.a - vector.a,
                this.b - vector.b,
                this.c - vector.c,
                this.d - vector.d
        );
    }
    public static FourDimensionalVector subtraction(FourDimensionalVector vector1, FourDimensionalVector vector2){
        return new FourDimensionalVector(
                vector1.a - vector2.a,
                vector1.b - vector2.b,
                vector1.c - vector2.c,
                vector1.d - vector2.d
        );
    }
    public static FourDimensionalVector addition(FourDimensionalVector vector1, FourDimensionalVector vector2){
        return new FourDimensionalVector(
                vector1.a + vector2.a,
                vector1.b + vector2.b,
                vector1.c + vector2.c,
                vector1.d + vector2.d
        );
    }

    @Override
    public FourDimensionalVector addition(FourDimensionalVector vector) {
        return new FourDimensionalVector(
                this.a + vector.a,
                this.b + vector.b,
                this.c + vector.c,
                this.d + vector.d
        );
    }

    @Override
    public FourDimensionalVector scale(double a) {
        return new FourDimensionalVector(
                this.a * a,
                this.b * a,
                this.c * a,
                this.d * a
        );
    }

    @Override
    public double length() {
        return length;
    }

    @Override
    public FourDimensionalVector normalization() {
        return new FourDimensionalVector(this.a / length, this.b / length, this.c / length, this.d / length);
    }

    @Override
    public double scalarProduct(FourDimensionalVector vector) {
        return this.a * vector.a + this.b * vector.b + this.c * vector.c + this.d * vector.d;
    }

    @Override
    public double cosAngleBetweenVectors(FourDimensionalVector vector) {
        return (scalarProduct(vector))/(this.length*vector.length);
    }
    @Override
    public double[] getArrValues() {
        return new double[]{a,b,c,d};
    }
}
