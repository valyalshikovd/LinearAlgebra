package ru.vsu.cs.cg.valyalschikov_d_a.Math.Vectors.ChangeableVectors;

public interface ChangeableVector<T> {
    public void subtractionSelf(T a);
    public void  additionSelf(T a);
    public void scaleSelf(double a);
    public void normalizationSelf();

}
