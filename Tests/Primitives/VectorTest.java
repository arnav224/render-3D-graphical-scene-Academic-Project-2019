package Primitives;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static java.lang.StrictMath.sqrt;
import static org.junit.jupiter.api.Assertions.*;

class VectorTest {

    @Test
    void get_head() {
    }

    @Test
    void set_head() {
    }

    @Test
    void compareTo() {
    }

    /*@Test
    void toString() {
    }*/

    @Test
    void add() {
        Vector vector = new Vector(1, 2, 3);
        Vector vector1 = new Vector(1, 2, 3);
        vector.add(vector1);
        Assertions.assertEquals(new Vector(2.00,4.00,6.00), vector);
        Vector vector2 = new Vector(1, 2, 3);
        Vector vector3 = new Vector(0, 0, 0);
        vector2.add(vector3);
        Assertions.assertEquals(new Vector(1.00,2.00,3.00), vector2);
    }

    @Test
    void subtract() {
        Vector vector = new Vector(1, 2, 3);
        Vector vector1 = new Vector(1, 2, 3);
        vector.subtract(vector1);
        Assertions.assertEquals(new Vector(0.00,0.00,0.00), vector);
        Vector vector2 = new Vector(1, 2, 3);
        Vector vector3 = new Vector(0, 0, 0);
        vector2.subtract(vector3);
        Assertions.assertEquals(new Vector(1.00,2.00,3.00), vector2);
    }

    @Test
    void scale() {
        Vector vector = new Vector(1, 2, 3);
        vector.scale(1);
        Assertions.assertEquals(new Vector(1.00,2.00,3.00), vector);
        vector.scale(2);
        Assertions.assertEquals(new Vector(2.00,4.00,6.00), vector);
        vector.scale(0);
        Assertions.assertEquals(new Vector(0,0,0), vector);
    }

    @Test
    void crossProduct() {
        Vector vector = new Vector(1, 2, 3);
        Vector vector1 = new Vector(-1, 2, -3);
        Vector result = vector.crossProduct(vector1);
        Assertions.assertEquals(new Vector(-12,0,4), result);
    }

    @Test
    void length() {
        Vector vector = new Vector(1, 2, 3);
        double result = vector.length();
        Assertions.assertEquals(sqrt(14), result);
    }

    @Test
    void normalize() {
        Vector vector = new Vector(1, 2, 3);
        vector.normalize();
        Assertions.assertEquals(new Vector(1/sqrt(14), 2/sqrt(14), 3/sqrt(14)), vector);
    }

    @Test
    void dotProduct() {
        Vector vector = new Vector(1, 2, 3);
        Vector vector1 = new Vector(1, 2, 3);
        double result = vector.dotProduct(vector1);
        Assertions.assertEquals(14.00, result);
        Vector vector2 = new Vector(1, 2, 3);
        Vector vector3 = new Vector(0, 0, 0);
        result = vector2.dotProduct(vector3);
        Assertions.assertEquals(0.00, result);
    }
}