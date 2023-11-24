package ru.vsu.cs.cg.valyalschikov_d_a.Math.Matrix;

import ru.vsu.cs.cg.valyalschikov_d_a.Math.Vectors.NDimensionalVector;
import ru.vsu.cs.cg.valyalschikov_d_a.Math.Vectors.ThreeDimensionalVector;
import ru.vsu.cs.cg.valyalschikov_d_a.Math.Vectors.Vector;

import static java.lang.Math.abs;

public class ThreeDimensionalMatrix extends NDimensionalMatrix {




    final private ThreeDimensionalVector vector1;
    final private ThreeDimensionalVector vector2;
    final private ThreeDimensionalVector vector3;

    public ThreeDimensionalMatrix(ThreeDimensionalVector vector1,
                                  ThreeDimensionalVector vector2,
                                  ThreeDimensionalVector vector3) {
        super(vector1,vector2,vector3);
        if(vector1.getDimensional() != 3 ){
            throw new ArithmeticException("Неправильная размерность векторов");
        }
        this.vector1 = vector1;
        this.vector2 = vector2;
        this.vector3 = vector3;
        dimensional = 3;
    }

    public ThreeDimensionalMatrix() {
        dimensional = 3;
        this.vector1 = new ThreeDimensionalVector(1, 0, 0);
        this.vector2 = new ThreeDimensionalVector(0, 1, 0);
        this.vector3 = new ThreeDimensionalVector(0, 0, 1);
        matrixInVectors = new ThreeDimensionalVector[]{
                vector1,
                vector2,
                vector3
        };
    }
    @Override
    public int getDimensional() {
        return dimensional;
    }
    @Override
    public Vector[] getMatrixInVectors() {
        return matrixInVectors;
    }

    public ThreeDimensionalVector getVector1() {
        return vector1;
    }

    public ThreeDimensionalVector getVector2() {
        return vector2;
    }

    public ThreeDimensionalVector getVector3() {
        return vector3;
    }
}
