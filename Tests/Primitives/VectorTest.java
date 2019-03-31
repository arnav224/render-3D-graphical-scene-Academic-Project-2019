package Primitives;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;


import static java.lang.StrictMath.sqrt;

class VectorTest {
    /************************************** Point3D tests **************************************************************/
    @Test
    public void Test01() {
        System.out.println("Test01: Point3D compareTo");
        Point3D point3D = new Point3D(2.0, -7.5, 9.25);
        Point3D instance = new Point3D(2.0, -7.5, 9.25);
        int expResult = 0;
        int result = instance.compareTo(point3D);
        Assertions.assertEquals(expResult, result);
    }

    @Test
    public void Test02() {
        System.out.println("Test02: Point3D toString");
        Point3D instance = new Point3D(1.123, 2.569, 3.999);
        String expResult = "(1.12, 2.57, 4.00)";
        String result = instance.toString();
        Assertions.assertEquals(expResult, result);
    }

    @Test
    public void Test03() {
        System.out.println("Test03: Point3D add");
        Vector vector = new Vector(1.25, -2.0, 3.0);
        Point3D instance = new Point3D(4.75, -5.0, 6.0);
        instance.add(vector);
        Assertions.assertTrue( instance.compareTo(new Point3D(6.0, -7.0, 9.0)) == 0);
    }

    @Test
    public void Test04() {
        System.out.println("Test04: Point3D subtract");
        Vector vector = new Vector(1.0, 2.0, 3.0);
        Point3D instance = new Point3D(4.0, 5.0, 6.0);
        instance.subtract(vector);
        Assertions.assertTrue(instance.compareTo(new Point3D(3.0, 3.0, 3.0)) == 0);
    }

    @Test
    public void Test05() {
        System.out.println("Test05: Point3D distance");
        Point3D point = new Point3D(-20.5, 55, 9.25);
        Point3D instance = new Point3D(75, -10, -100);
        double expResult = 159.0;
        double result = instance.distance(point);
        Assertions.assertEquals(expResult, result, 0.01);
    }
    /************************************** Vector tests **************************************************************/
    @Test
    public void Test06(){
        System.out.println("Test06: Vector Add test");

        Vector v1 = new Vector(1.0, 1.0, 1.0);
        Vector v2 = new Vector(-1.0, -1.0, -1.0);

        v1.add(v2);
        Assertions.assertTrue(v1.compareTo(new Vector(0.0,0.0,0.0)) == 0);

        v2.add(v1);
        Assertions.assertTrue(v2.compareTo(v2) == 0);
    }

    @Test
    public void Test07(){
        System.out.println("Test07: Vector Substruct test");

        Vector v1 = new Vector(1.0, 1.0, 1.0);
        Vector v2 = new Vector(-1.0, -1.0, -1.0);

        v1.subtract(v2);
        Assertions.assertTrue(v1.compareTo(new Vector(2.0,2.0,2.0)) == 0);

        v2.subtract(v1);
        Assertions.assertTrue(v2.compareTo(new Vector(-3.0,-3.0,-3.0)) == 0);
    }

    @Test
    public void Test08(){
        System.out.println("Test08: Vector Scaling test");

        Vector v1 = new Vector(1.0, 1.0, 1.0);

        v1.scale(1);
        Assertions.assertTrue(v1.compareTo(v1) == 0);

        v1.scale(2);
        Assertions.assertTrue(v1.compareTo(new Vector(2.0,2.0,2.0)) == 0);

        v1.scale(-2);
        Assertions.assertTrue(v1.compareTo(new Vector(-4.0,-4.0,-4.0)) == 0);
    }

    @Test
    public void Test09(){
        System.out.println("Test09: Vector Dot product test");


        Vector v1 = new Vector(3.5,-5,10);
        Vector v2 = new Vector(2.5,7,0.5);

        Assertions.assertTrue(Double.compare(v1.dotProduct(v2), (8.75 + -35 + 5)) == 0);

    }

    @Test
    public void Test10() {
        System.out.println("Test10: Vector Length test");

        Vector v = new Vector(3.5,-5,10);
        Assertions.assertTrue(v.length() ==  Math.sqrt(12.25 + 25 + 100));
    }

    @Test
    public void Test11(){
        System.out.printf("Test11: Vector Normalize test -> ");

        Vector v = new Vector(100,-60.781,0.0001);
        System.out.printf("Length = %f  ", v.length());
        v.normalize();
        System.out.printf("Length = %f\n", v.length());

        Assertions.assertEquals( 1, v.length(), 1e-10);

        v = new Vector(0,0,0);

        try {
            v.normalize();
            Assertions.fail("Didn't throw divide by zero exception!");
        } catch (ArithmeticException e) {
            Assertions.assertTrue(true);
        }

    }

    @Test
    public void Test12(){
        System.out.println("Test12: Vector Cross product test");

        Vector v1 = new Vector(3.5, -5.0, 10.0);
        Vector v2 = new Vector(2.5, 7, 0.5);
        Vector v3 = v1.crossProduct(v2);

        Assertions.assertEquals( 0, v3.dotProduct(v2), 1e-10);
        Assertions.assertEquals( 0, v3.dotProduct(v1), 1e-10);

        Vector v4 = v2.crossProduct(v1);
        v3.add(v4);
        Assertions.assertEquals( 0, v3.length(), 1e-10);
    }








/*    @Test
    void get_head() {
    }

    @Test
    void set_head() {
    }

    @Test
    void compareTo() {
    }



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

        Vector vector5 = new Vector(-1, 2, 3);
        Vector vector6 = new Vector(0, 0, 0);
        vector5.subtract(vector6);
        Assertions.assertEquals(new Vector(-1, 2, 3), vector5);
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
    } */
}