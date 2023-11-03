package ru.vsu.cs.cg.valyalschikov_d_a.Math.Vectors.ChangeableVectors;

import ru.vsu.cs.cg.valyalschikov_d_a.Math.Vectors.TwoDimensionalVector;

public class TwoDimensionalVectorChangeable extends TwoDimensionalVector implements ChangeableVector<TwoDimensionalVectorChangeable> {
    public TwoDimensionalVectorChangeable(double a, double b) {
        super(a, b);
    }
    @Override
    public void subtractionSelf(TwoDimensionalVectorChangeable a) {
        this.a -= a.getA();
        this.b -= a.getB();
    }
    @Override
    public void additionSelf(TwoDimensionalVectorChangeable a) {
        this.a += a.getA();
        this.b += a.getB();
    }
    @Override
    public void scaleSelf(double a) {
        this.a = this.a * a;
        this.b = this.b * a;
    }

    @Override
    public void normalizationSelf() {
        this.a = this.a / length;
        this.b = this.b / length;
    }

}
