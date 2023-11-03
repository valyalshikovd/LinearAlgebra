package ru.vsu.cs.cg.valyalschikov_d_a.Math.Vectors.ChangeableVectors;

import ru.vsu.cs.cg.valyalschikov_d_a.Math.Vectors.TwoDimensionalVector;

public class TwoDimensionalVectorChangeable extends TwoDimensionalVector implements ChangeableVector<TwoDimensionalVectorChangeable> {
    public TwoDimensionalVectorChangeable(double a, double b) {
        super(a, b);
    }
    @Override
    public void subtractionSelf(TwoDimensionalVectorChangeable vector) {
        this.a -= vector.getA();
        this.b -= vector.getB();
        this.length = Math.pow(this.a*this.a + this.b*this.b, 0.5);
    }
    @Override
    public void additionSelf(TwoDimensionalVectorChangeable vector) {
        this.a += vector.getA();
        this.b += vector.getB();
        this.length = Math.pow(this.a*this.a + this.b*this.b, 0.5);
    }
    @Override
    public void scaleSelf(double a) {
        this.a = this.a * a;
        this.b = this.b * a;
        this.length = Math.pow(this.a*this.a + this.b*this.b, 0.5);
    }

    @Override
    public void normalizationSelf() {
        this.a = this.a / length;
        this.b = this.b / length;
        this.length = 1;
    }

}
