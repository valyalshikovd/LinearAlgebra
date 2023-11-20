package ru.vsu.cs.cg.valyalschikov_d_a.Tests;

import org.junit.jupiter.api.Test;
import ru.vsu.cs.cg.valyalschikov_d_a.Math.Matrix.NDimensionalMatrix;
import ru.vsu.cs.cg.valyalschikov_d_a.Math.Vectors.NDimensionalVector;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MatrixTest {

    @org.junit.jupiter.api.Test
    void addition() {
        NDimensionalMatrix ndMatrix3 = new NDimensionalMatrix(
                new NDimensionalVector(12, 2, 1, 22, 1, 3),
                new NDimensionalVector(12, 5, 2, 1, 22, 1),
                new NDimensionalVector(13, 5, 4, 2, 1, 22),
                new NDimensionalVector(14, 1, 5, 4, 2, 1),
                new NDimensionalVector(15, 1, 1, 5, 4, 2),
                new NDimensionalVector(16, 1, 1, 1, 5, 5)
        );
        NDimensionalMatrix ndMatrix4 = new NDimensionalMatrix(
                new NDimensionalVector(1, 0, 0, 0, 0, 0),
                new NDimensionalVector(0, 1, 0, 0, 0, 0),
                new NDimensionalVector(0, 0, 1, 0, 0, 0),
                new NDimensionalVector(0, 0, 0, 1, 0, 0),
                new NDimensionalVector(0, 0, 0, 0, 1, 0),
                new NDimensionalVector(0, 0, 0, 0, 0, 1)
        );
        assertEquals(true, ndMatrix3.addition(ndMatrix4).equals(
                new NDimensionalMatrix(
                        new NDimensionalVector(13, 2, 1, 22, 1, 3),
                        new NDimensionalVector(12, 6, 2, 1, 22, 1),
                        new NDimensionalVector(13, 5, 5, 2, 1, 22),
                        new NDimensionalVector(14, 1, 5, 5, 2, 1),
                        new NDimensionalVector(15, 1, 1, 5, 5, 2),
                        new NDimensionalVector(16, 1, 1, 1, 5, 6)
                )
        ));
        assertThrows(ArithmeticException.class, () -> ndMatrix3.addition(new NDimensionalMatrix(
                new NDimensionalVector(13, 2, 1),
                new NDimensionalVector(12, 6, 2),
                new NDimensionalVector(13, 5, 5)
        )));

        assertEquals(true, ndMatrix3.addition(new NDimensionalMatrix(
                new NDimensionalVector(0, 0, 0, 0, 0, 0),
                new NDimensionalVector(0, 0, 0, 0, 0, 0),
                new NDimensionalVector(0, 0, 0, 0, 0, 0),
                new NDimensionalVector(0, 0, 0, 0, 0, 0),
                new NDimensionalVector(0, 0, 0, 0, 0, 0),
                new NDimensionalVector(0, 0, 0, 0, 0, 0)
        )).equals(ndMatrix3));
    }

    @org.junit.jupiter.api.Test
    void multiplyVector() {
        NDimensionalMatrix ndMatrix4 = new NDimensionalMatrix(
                new NDimensionalVector(1, 0, 0, 0, 0, 0),
                new NDimensionalVector(0, 1, 0, 0, 2, 0),
                new NDimensionalVector(0, 0, 1, 0, 0, 0),
                new NDimensionalVector(0, 0, 0, 1, 0, 0),
                new NDimensionalVector(0, 23, 0, 0, 1, 0),
                new NDimensionalVector(0, 0, 0, 0, 0, 1)
        );

        System.out.println(Arrays.toString(ndMatrix4.multiplyVector(new NDimensionalVector(1, 2, 3, 4, 5, 6)).getArrValues()));
        assertEquals(true, ndMatrix4.multiplyVector(new NDimensionalVector(1,2,3,4,5,6)).equals(
                new NDimensionalVector(1 , 12, 3, 4 ,51, 6)
        ));
    }


    @org.junit.jupiter.api.Test
    void multiplyVectorX() {
        NDimensionalMatrix ndMatrix4 = new NDimensionalMatrix(
                new NDimensionalVector(1, 2, 3),
                new NDimensionalVector(4, 5, 6),
                new NDimensionalVector(7, 9, 9)
        );
        System.out.println(Arrays.toString(ndMatrix4.multiplyVector(new NDimensionalVector(1, 10, 100)).getArrValues()));
        assertEquals(true, ndMatrix4.multiplyVector(new NDimensionalVector(1, 10, 100)).equals(
                new NDimensionalVector(321, 654, 997)
        ));

    }

    @org.junit.jupiter.api.Test
    void multiplyMatrix() {

        NDimensionalMatrix ndMatrix2 = new NDimensionalMatrix(
                new NDimensionalVector(1,12,13,25,26,1000),
                new NDimensionalVector(2, 11,14,24,27,36),
                new NDimensionalVector(3, 10, 15, 23, 28, 35),
                new NDimensionalVector(4, 9, 100, 22, 29, 34),
                new NDimensionalVector(55, 8, 17, 20, 30, 33),
                new NDimensionalVector(6,7,18,19,334,32)

        );

        NDimensionalMatrix ndMatrix3 = new NDimensionalMatrix(
                new NDimensionalVector(12,2,1,22,1,3),
                new NDimensionalVector(12,5,2,1,22,1),
                new NDimensionalVector(13,5,4,2,1,22),
                new NDimensionalVector(14,1,5,4,2,1),
                new NDimensionalVector(15,1,1,5,4,2),
                new NDimensionalVector(16,1,1,1,5,5)
        );


        assertEquals(true, ndMatrix2.multiplyMatrix(ndMatrix3).equals(
                new NDimensionalMatrix(
                        new NDimensionalVector(17065, 1178,1228,1290,5432,5378),
                        new NDimensionalVector(1655,216,263,350,594,583),
                        new NDimensionalVector(1653,217,261,373,571,603),
                        new NDimensionalVector(2743,638,595,564,632,2471),
                        new NDimensionalVector(2235,318,302,1515,573,792),
                        new NDimensionalVector(6178,522,553,1953,1712,1268)
                )
        ));
    }

    @org.junit.jupiter.api.Test
    void transposition() {
        NDimensionalMatrix ndMatrix3 = new NDimensionalMatrix(
                new NDimensionalVector(12,2,1,22,1,3),
                new NDimensionalVector(12,5,2,1,22,1),
                new NDimensionalVector(13,5,4,2,1,22),
                new NDimensionalVector(14,1,5,4,2,1),
                new NDimensionalVector(15,1,1,5,4,2),
                new NDimensionalVector(16,1,1,1,5,5)
        );


        assertEquals(true, ndMatrix3.transposition().equals(
                new NDimensionalMatrix(
                        new NDimensionalVector(12,12,13,14,15,16),
                        new NDimensionalVector(2,5,5,1,1,1),
                        new NDimensionalVector(1,2,4,5,1,1),
                        new NDimensionalVector(22,1,2,4,5,1),
                        new NDimensionalVector(1,22,1,2,4,5),
                        new NDimensionalVector(3,1,22,1,2,5)
                )
        ));
    }

    @org.junit.jupiter.api.Test
    void getDeterminant() {



        NDimensionalMatrix ndMatrix3 = new NDimensionalMatrix(
                new NDimensionalVector(12,2,1,22,1),
                new NDimensionalVector(12,5,2,1,22),
                new NDimensionalVector(13,5,4,2,1),
                new NDimensionalVector(14,1,5,4,2),
                new NDimensionalVector(15,1,1,5,4)
        );

        assertEquals(94215,ndMatrix3.getDeterminant());
        NDimensionalMatrix ndMatrix4 = new NDimensionalMatrix(
                new NDimensionalVector(12,2,1),
                new NDimensionalVector(12,5,2),
                new NDimensionalVector(13,5,4)
        );

        assertEquals(71,ndMatrix4.getDeterminant());
        NDimensionalMatrix ndMatrix5 = new NDimensionalMatrix(
                new NDimensionalVector(0,0,0),
                new NDimensionalVector(12,5,2),
                new NDimensionalVector(13,5,4)
        );

        assertEquals(0,ndMatrix5.getDeterminant());

        NDimensionalMatrix ndMatrix6 = new NDimensionalMatrix(
                new NDimensionalVector(46,73,563, 13161),
                new NDimensionalVector(6444464,516465,15819, 211),
                new NDimensionalVector(-611646,5468,611643, 616666),
                new NDimensionalVector(999999,499,4999, 11111)
        );
        NDimensionalMatrix ndMatrix7 = new NDimensionalMatrix(
                new NDimensionalVector(46,73,563, 13161, 23233,342,543,54, 1 ,7,1,11,33,1,1),
                new NDimensionalVector(6444464,516465,15819, 211, 23233,342,543, 23 ,1 ,7,1,321,77,1,1),
                new NDimensionalVector(-611646,5468,611643, 616666,23233,342,543, 543, 1,6,1 ,100,7,1,1),
                new NDimensionalVector(999299,499,4999, 111211,23233,342,543,5 , 1123,3,1,100,776,1,1),
                new NDimensionalVector(999949,499,4999, 1114311,23233,342,5423,543 , 1,626,1,100,634,1,1),
                new NDimensionalVector(939999,499,4999, 111211,23233,342,543,5243, 1,4326,1,100,6364,1,1),
                new NDimensionalVector(9912999,499,4999, 1111131,23233,342,543,53243, 1123,423,1,100,63,1,1),
                new NDimensionalVector(9999099,499,4999, 111121,23233,342,543,5432, 1,432,1,100,64,1,1),
                new NDimensionalVector(9999099,499,4999, 111121,23233,342,543,54322, 1232,543,1,100,63,1,1),
                new NDimensionalVector(9999099,499,4999, 111121,23233,342,543,54322, 1232, 54,1,100,634,1,1),
                new NDimensionalVector(9999099,499,4999, 111121,23233,342,543,54322, 1232, 54,12,100,432,1,1),
        new NDimensionalVector(9999099,499,4999, 111121,23233,342,543,54322, 1232, 54,12,103240,321,1,1),
                new NDimensionalVector(9999099,499,4999, 111121,23233,342,543,54322, 1232, 54,12,103240, 23,1,1),
                new NDimensionalVector(9999099,499,4999, 111121,23233,342,543,54322, 1232, 54,12,103240, 23, 214,1),
        new NDimensionalVector(9999099,499,4999, 111121,23233,342,543,54322, 1232, 54,12,103240, 23, 214,123)




        );

        assertEquals(-3.975448205846339E21, ndMatrix6.getDeterminant());


        assertEquals(94215,ndMatrix3.getDeterminant());   //36024000
                                                                  //8947400
    }

    @Test
    void inverseMatrixText() {

        NDimensionalMatrix ndMatrix6 = new NDimensionalMatrix(
                new NDimensionalVector(1,1,1,1),
                new NDimensionalVector(1,2,4,8),
                new NDimensionalVector(1,2,8,8),
                new NDimensionalVector(1,2,1,2)
        );
        NDimensionalMatrix ndMatrix7 = new NDimensionalMatrix(
                new NDimensionalVector(2,0.25,-0.25,-1),
                new NDimensionalVector(-1,-7.0/24,0.125,7.0/6),
                new NDimensionalVector(0,-0.25,0.25,0),
                new NDimensionalVector(0,7.0/24,-1.0/8,-1.0/6)
        );
        assertTrue(ndMatrix6.inverseMatrix().equals(ndMatrix7));



    }
}