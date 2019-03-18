package Primitives;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.lang.Object.*;
class CoordinateTest {

    @Test
    void get_coord() {
        Coordinate coord = new Coordinate(1.23);
        double result = coord.get_coord();
        Assertions.assertEquals(result, 1.23);
    }

    @Test
    void compareTo() {
    }

    @Test
    void set_coord() {
    }

    @Test
    void equals() {
    }

    @Test
    void subtract() {
    }

    @Test
    void add() {
    }

    @Test
    void scale() {
    }

    @Test
    void multiply() {
    }
}