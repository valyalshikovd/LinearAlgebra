package ru.vsu.cs.cg.valyalschikov_d_a.Math.Vectors.ChangeableVectors;

public interface ChangeableVector<T> {
    public void subtractionSelf(T vector);
    public void  additionSelf(T vector);
    public void scaleSelf(double a);
    public void normalizationSelf();

}
