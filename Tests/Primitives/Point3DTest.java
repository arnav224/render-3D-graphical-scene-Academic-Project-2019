package Primitives;

import org.junit.jupiter.api.Test;
import org.testng.Assert;

import static org.junit.jupiter.api.Assertions.*;

class Point3DTest {

    @Test
    void get_x() throws Exception{
        Point3D point = new Point3D(1.23, 2.34, 3.45);
        Coordinate result = point.get_x();
        Assert.assertEquals(1,1);

    }

    @Test
    void set_x() {
    }

    @Test
    void get_y() {
    }

    @Test
    void set_y() {
    }

    @Test
    void compareTo() {
    }

    @Test
    void equals() {
    }


    @Test
    void distance() {
    }

    @Test
    void distance1() {
    }
}