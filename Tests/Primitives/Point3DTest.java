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

    @Test
    void toString1() {
        Point3D point3D = new Point3D(1.23, 2.34, 3.45);
        String result = point3D.toString();
        Assertions.assertEquals("(1.23, 2.34, 3.45)", result);
    }

    @Test
    void equals() {
    }

   // @Test
    //void hashCode() {
    //}

    @Test
    void distance() {
        Point3D p1 = new Point3D(1, 1, 1);
        double result = p1.distance();
        Assertions.assertEquals(1.7320508075688772, result);
    }

    @Test
    void distance1() {
        Point3D p1 = new Point3D(1.23, 2.34, 3.45);
        Point3D p2 = new Point3D(1.23, 2.34, 3.45);
        double result = p1.distance(p2);
        Assertions.assertEquals(0, result);

    }

    @Test
    void add() {
        Point3D p1 = new Point3D(1.23, 2.34, 3.45);
        Vector vector = new Vector(1, -1.5, 2.2);
        Point3D result = p1.add(vector);
        Assertions.assertEquals(new Point3D(2.23, 0.84, 5.65), result);
    }

    @Test
    void subtract() {
        Point3D p1 = new Point3D(1.23, 2.34, 3.45);
        Vector vector = new Vector(1, -1.5, 2.2);
        Point3D result = p1.subtract(vector);
        Assertions.assertEquals(new Point3D(0.23, 3.84, 1.25), result);
    }

    @Test
    void compareTo() {
        Point3D p1 = new Point3D(1.23, 2.34, 3.45);
        Point3D p2 = new Point3D(1.23, 2.34, 3.45);
        int result = p1.compareTo(p2);
        Assertions.assertEquals(result, 0);

        p1 = new Point3D(1.23, 2.34, 3.45);
        p2 = new Point3D(0.5, 1, 0);
        result = p1.compareTo(p2);
        Assertions.assertEquals(1, result);

        p1 = new Point3D(1.123, 3.45, 2.34);
        p2 = new Point3D(1.12300001, 2.34, 3.45);
        result = p1.compareTo(p2);
        Assertions.assertEquals(-1, result);

        p1 = new Point3D(1.123, 2.34, 3.45);    //almost equals
        p2 = new Point3D(1.12300000000000000000001, 2.34, 3.45);
        result = p1.compareTo(p2);
        Assertions.assertEquals(0, result);

    }
}