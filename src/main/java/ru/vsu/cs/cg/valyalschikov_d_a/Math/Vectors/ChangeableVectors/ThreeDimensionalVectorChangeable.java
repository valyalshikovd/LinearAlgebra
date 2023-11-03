package ru.vsu.cs.cg.valyalschikov_d_a.Math.Vectors.ChangeableVectors;
import ru.vsu.cs.cg.valyalschikov_d_a.Math.Vectors.ThreeDimensionalVector;

public class ThreeDimensionalVectorChangeable extends ThreeDimensionalVector implements ChangeableVector<ThreeDimensionalVectorChangeable> {

    public ThreeDimensionalVectorChangeable(double a, double b, double c) {
        super(a, b, c);
    }
    @Override
    public void subtractionSelf(ThreeDimensionalVectorChangeable vector) {
        this.a -= vector.a;
        this.b -= vector.b;
        this.c -= vector.c;
        this.length = Math.pow(this.a*this.a + this.b*this.b + this.c*this.c, 0.5);
    }
    @Override
    public void additionSelf(ThreeDimensionalVectorChangeable vector) {
        this.a += vector.a;
        this.b += vector.b;
        this.c += vector.c;
        this.length = Math.pow(this.a*this.a + this.b*this.b + this.c*this.c, 0.5);
    }
    @Override
    public void scaleSelf(double a) {
        this.a *= a;
        this.b *= a;
        this.c *= a;
        this.length = Math.pow(this.a*this.a + this.b*this.b + this.c*this.c, 0.5);
    }
    @Override
    public void normalizationSelf() {
        this.a = this.a / length;
        this.b = this.b / length;
        this.c = this.c / length;
        this.length = 1;
    }
}
