package Primitives;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

import static org.junit.jupiter.api.Assertions.*;

class CoordinateTest  {

    @Test
    void get_coord() {
        Coordinate coord = new Coordinate(1.23);
        double result = coord.get_coord();
        Assert.assertEquals(result, 1.23);
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
    void toString11111() {

    }

    @Test
    void subtract() {

    }
//@Test
    //void subtract() {
    //}

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