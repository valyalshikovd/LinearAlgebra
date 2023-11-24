package ru.vsu.cs.cg.valyalschikov_d_a.Math.Vectors;
import static java.lang.Math.abs;

public class NDimensionalVector implements Vector{

    final protected double[] values;
    protected int dimensional;
    protected double length;

    @Override
    public int getDimensional() {
        return dimensional;
    }

    public NDimensionalVector(double ...args){
        dimensional = args.length;
        if(dimensional < 1){
            throw new ArithmeticException("Нельзя создать пустой вектор");
        }
        values = args;
        length = 0;
        for (double value : values)
            length += value * value;
        length = Math.pow(length, 0.5);
        roundVector();
    }
    @Override
    public double getLength() {
        return length;
    }

    @Override
    public double[] getArrValues() {
        return values;
    }

    @Override
    public Vector subtraction(Vector vector) {
        if (vector.getDimensional() != dimensional){
            throw  new ArithmeticException("Размерности векторов не совпадают");
        }
        double[] newValues = new double[dimensional];
        for(int i = 0; i < dimensional ; i++){
            newValues[i] = values[i] - vector.getArrValues()[i];
        }
        return  new NDimensionalVector(newValues);
    }

    @Override
    public Vector addition(Vector vector) {
        if (vector.getDimensional() != dimensional){
            throw  new ArithmeticException("Размерности векторов не совпадают");
        }
        double[] newValues = new double[dimensional];
        for(int i = 0; i < dimensional ; i++){
            newValues[i] = values[i] + vector.getArrValues()[i];
        }
        return  new NDimensionalVector(newValues);
    }

    @Override
    public Vector scale(double a) {
        double[] newValues = new double[dimensional];
        for(int i = 0; i < dimensional; i++){
            newValues[i] = values[i] * a;
        }
        return  new NDimensionalVector(newValues);
    }

    @Override
    public double length() {
        return length;
    }

    @Override
    public NDimensionalVector normalization() {
        double[] newValues = new double[dimensional];
        for(int i = 0; i < dimensional ; i++){
            newValues[i] = values[i] / length;
        }
        return  new NDimensionalVector(newValues);
    }

    @Override
    public double scalarProduct(Vector vector) {
        if (vector.getDimensional() != dimensional){
            throw  new ArithmeticException("Размерности векторов не совпадают");
        }
        double scalarProd = 0;
        for(int i = 0; i < dimensional; i++){
            scalarProd += values[i] * vector.getArrValues()[i];
        }
        return  scalarProd;
    }

    @Override
    public double cosAngleBetweenVectors(Vector vector) {
        if (vector.getDimensional() != dimensional){
            throw new ArithmeticException("Размерности векторов не совпадают");
        }
        if (length == 0 || vector.getLength() == 0) {
            throw new ArithmeticException("Нулевой вектор");
        }
        return scalarProduct(vector)/(length * vector.getLength());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NDimensionalVector that = (NDimensionalVector) o;
        if(dimensional != that.dimensional){
            return false;
        }
        for(int i = 0; i < dimensional; i++){
            if(abs(that.values[i] - values[i]) > 0.00000001){
                return false;
            }
        }
        return true;
    }
    private void roundVector(){
        for (int i = 0; i < dimensional; i++){
            if(abs(values[i]) < 0.0000000001){
                values[i] = 0;
            }
        }
    }
}
