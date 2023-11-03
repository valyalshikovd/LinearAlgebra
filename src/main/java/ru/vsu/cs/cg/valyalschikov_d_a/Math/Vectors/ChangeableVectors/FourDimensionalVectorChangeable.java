package ru.vsu.cs.cg.valyalschikov_d_a.Math.Vectors.ChangeableVectors;

import ru.vsu.cs.cg.valyalschikov_d_a.Math.Vectors.FourDimensionalVector;

public class FourDimensionalVectorChangeable extends FourDimensionalVector implements ChangeableVector<FourDimensionalVectorChangeable> {

    public FourDimensionalVectorChangeable(double a, double b, double c, double d) {
        super(a, b, c, d);
    }

    @Override
    public void subtractionSelf(FourDimensionalVectorChangeable vector) {
        this.a -= vector.a;
        this.b -= vector.b;
        this.c -= vector.c;
        this.d -= vector.d;
        this.length = Math.pow(a * a + b * b + c * c + d * d, 0.5);
    }

    @Override
    public void additionSelf(FourDimensionalVectorChangeable vector) {
        this.a += vector.a;
        this.b += vector.b;
        this.c += vector.c;
        this.d += vector.d;
        this.length = Math.pow(a * a + b * b + c * c + d * d, 0.5);
    }

    @Override
    public void scaleSelf(double a) {
        this.a *= a;
        this.b *= a;
        this.c *= a;
        this.d *= a;
        this.length = Math.pow(a * a + b * b + c * c + d * d, 0.5);
    }

    @Override
    public void normalizationSelf() {
        this.a = this.a / length;
        this.b = this.b / length;
        this.c = this.c / length;
        this.d = this.d / length;
        this.length = 1;
    }
}
