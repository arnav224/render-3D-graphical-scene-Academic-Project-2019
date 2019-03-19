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
        Assertions.assertEquals(6.0, vector.add(vector1).get_head().get_z().get_coord());
    }

    @Test
    void subtract() {
    }

    @Test
    void scale() {
    }

    @Test
    void crossProduct() {
        //Vector vector1 = vec

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