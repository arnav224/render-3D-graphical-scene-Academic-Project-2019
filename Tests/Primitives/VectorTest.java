package Primitives;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
        Assertions.assertEquals((new Vector(2.0,4.0,6.0)).get_head(), (vector).get_head());
       // Assertions.assertEquals(1,1);
    }

    @Test
    void subtract() {
    }

    @Test
    void scale() {
    }

    @Test
    void crossProduct() {
    }

    @Test
    void length() {
    }

    @Test
    void normalize() {
    }

    @Test
    void dotProduct() {
    }
}