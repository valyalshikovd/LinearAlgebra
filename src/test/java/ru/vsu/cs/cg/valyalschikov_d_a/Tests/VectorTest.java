package ru.vsu.cs.cg.valyalschikov_d_a.Tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.vsu.cs.cg.valyalschikov_d_a.Math.Matrix.ThreeDimensionalMatrix;
import ru.vsu.cs.cg.valyalschikov_d_a.Math.Vectors.FourDimensionalVector;
import ru.vsu.cs.cg.valyalschikov_d_a.Math.Vectors.ThreeDimensionalVector;
import ru.vsu.cs.cg.valyalschikov_d_a.Math.Vectors.TwoDimensionalVector;
import ru.vsu.cs.cg.valyalschikov_d_a.Math.Vectors.nDimensionalVector;

import java.util.Arrays;

import static java.lang.Math.abs;
import static org.junit.jupiter.api.Assertions.*;

class VectorTest {




    @Test
    void addition() {
        TwoDimensionalVector vector1 = new TwoDimensionalVector(1, 2).addition(new TwoDimensionalVector(4,32));
        Assertions.assertEquals(vector1.getA(), 5);
        Assertions.assertEquals(vector1.getB(), 34);

        ThreeDimensionalVector vector2 = new ThreeDimensionalVector(1, 2, 23).addition(new ThreeDimensionalVector(4,32,23));
        Assertions.assertEquals(vector2.getA(), 5);
        Assertions.assertEquals(vector2.getB(), 34);
        Assertions.assertEquals(vector2.getC(), 46);

        FourDimensionalVector vector3 = new FourDimensionalVector(1, 2, 23, 10).addition(new FourDimensionalVector(4,32,23, 123));
        Assertions.assertEquals(vector3.getA(), 5);
        Assertions.assertEquals(vector3.getB(), 34);
        Assertions.assertEquals(vector3.getC(), 46);
        Assertions.assertEquals(vector3.getD(), 133);

        nDimensionalVector nDvector1 = new nDimensionalVector(3 , 4, 5, 43, 3,7);
        nDimensionalVector nDvector2 = new nDimensionalVector(3 , -4, 5, -43, -3,7);
        assertTrue(nDvector1.addition(nDvector2).equals(new nDimensionalVector(6, 0, 10, 0, 0, 14)));
        assertTrue(nDvector1.subtraction(nDvector2).equals(new nDimensionalVector(0, 8, 0, 86, 6, 0)));
        assertThrows( ArithmeticException.class, () -> nDvector1.addition(new nDimensionalVector(0,0,0,0)));
        assertThrows( ArithmeticException.class, () -> nDvector1.subtraction(new nDimensionalVector(0,0,0,0)));
    }

    @Test
    void scale() {
        TwoDimensionalVector vector1 = new TwoDimensionalVector(1, 2).scale(21);
        Assertions.assertEquals(vector1.getA(), 21);
        Assertions.assertEquals(vector1.getB(), 42);

        ThreeDimensionalVector vector2 = new ThreeDimensionalVector(1, 2, 23).scale(2);
        Assertions.assertEquals(vector2.getA(), 2);
        Assertions.assertEquals(vector2.getB(), 4);
        Assertions.assertEquals(vector2.getC(), 46);

        FourDimensionalVector vector3 = new FourDimensionalVector(1, 2, 23, 10).scale(10);
        Assertions.assertEquals(vector3.getA(), 10);
        Assertions.assertEquals(vector3.getB(), 20);
        Assertions.assertEquals(vector3.getC(), 230);
        Assertions.assertEquals(vector3.getD(), 100);


        nDimensionalVector nDvector1 = new nDimensionalVector(3 , 4, 5, 43, 3,7);
        assertTrue(nDvector1.scale(10).equals(new nDimensionalVector(30,40,50,430,30,70)));
        assertTrue(nDvector1.scale(0).equals(new nDimensionalVector(0,0,0,0,0,0)));
        assertTrue(nDvector1.scale(-1).equals(new nDimensionalVector(-3,-4,-5,-43,-3,-7)));

    }

    @Test
    void length() {
        Assertions.assertEquals(new TwoDimensionalVector(3, 4).length(), 5);
        Assertions.assertEquals(3, new ThreeDimensionalVector(1,2,2).length() );
        Assertions.assertEquals(4, new FourDimensionalVector(2,2,2,2).length());

        Assertions.assertEquals(new TwoDimensionalVector(0, 0).length(), 0);
        Assertions.assertEquals(0, new ThreeDimensionalVector(0,0,0).length() );
        Assertions.assertEquals(0, new FourDimensionalVector(0,0,0,0).length());


        Assertions.assertEquals(0, new nDimensionalVector(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0).length());
        Assertions.assertTrue( 934825.222065060 - new nDimensionalVector(142,432,534,675378,634,646345).length() < 0.00000001);
    }

    @Test
    void normalization() {
        Assertions.assertEquals(1, new TwoDimensionalVector(13,321).normalization().length());
        Assertions.assertEquals(1, new ThreeDimensionalVector(13,321,421).normalization().length());
        Assertions.assertEquals(true, 0.0000001 > abs(new FourDimensionalVector(13,321,432,2).normalization().length() -1));

        Assertions.assertEquals(true, 0.0000001 > abs(new FourDimensionalVector(13,321,432,2).normalization().length() -1));

        nDimensionalVector vector = new nDimensionalVector(10,213,242,5253,543,654,653,653,654,756);
        double length = vector.length();
        boolean flag = true;
        double[] values = vector.getArrValues();
        double[] normalValues = vector.normalization().getArrValues();
        for (int i = 0; i  < values.length; i++){
            if(abs(values[i] / length - normalValues[i]) > 0.00000001){
                flag = false;
                break;
            }
        }
        assertTrue(flag);

        new nDimensionalVector(0,0,0,0,0,0,0,0,0, 0).normalization();
    }

    @Test
    void scalarProduct() {
        Assertions.assertEquals(-2, new TwoDimensionalVector(2,-5).scalarProduct(new TwoDimensionalVector(-1,0)));
        nDimensionalVector nDvector1 = new nDimensionalVector(3 , 4, 5, 43, 3,7);
        nDimensionalVector nDvector2 = new nDimensionalVector(3 , -4, 5, -43, -3,7);
        assertEquals(-1791, nDvector1.scalarProduct(nDvector2));
        assertEquals(0, nDvector1.scalarProduct(new nDimensionalVector(0,0,0,0,0,0)));
        assertThrows( ArithmeticException.class, () -> nDvector1.scalarProduct(new nDimensionalVector(0,0,0,0)));
    }

    @Test
    void testCosAngleBetweenVectors() {
        nDimensionalVector nDvector1 = new nDimensionalVector(3 , 4, 5, 43, 3,7);
        nDimensionalVector nDvector2 = new nDimensionalVector(3 , -4, 5, -43, -3,7);
        Assertions.assertEquals(0, new TwoDimensionalVector(1,0).cosAngleBetweenVectors(new TwoDimensionalVector(0,1)));
        assertEquals(-1791.0/1957, nDvector1.cosAngleBetweenVectors(nDvector2));
        assertThrows( ArithmeticException.class, () -> nDvector1.cosAngleBetweenVectors(new nDimensionalVector(0,0,0,0,0,0)));
        assertThrows( ArithmeticException.class, () -> nDvector1.cosAngleBetweenVectors(new nDimensionalVector(0,0,0,0)));
    }
}