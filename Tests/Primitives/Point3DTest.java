package Primitives;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Point3DTest {

    @Test
    void get_z() {
        Point3D point3D = new Point3D(1.23, 2.34, 3.45);
        Coordinate result = point3D.get_z();
        Assertions.assertEquals(result.get_coord(), 3.45);
    }

    @Test
    void set_z() {
    }

    //@Test
    //void toString() {
    //}

    @Test
    void equals() {
    }

   // @Test
    //void hashCode() {
    //}

    @Test
    void distance() {
    }

    @Test
    void distance1() {
    }

    @Test
    void add() {
    }

    @Test
    void subtract() {
    }
}