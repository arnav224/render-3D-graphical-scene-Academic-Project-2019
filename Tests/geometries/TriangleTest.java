package geometries;

import primitives.*;
import elements.Camera;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {

    @Test
    void getP1() {
    }

    @Test
    void setP1() {
    }

    @Test
    void getP2() {
    }

    @Test
    void setP2() {
    }

    @Test
    void getP3() {
    }

    @Test
    void setP3() {
    }

    @Test
    void getNormal() {
    }

    @Test
    void findIntersections() {
    }
    @Test
    public void TriangleIntersectionPointsTest(){
        final int WIDTH = 3;
        final int HEIGHT = 3;
        Ray[][] rays = new Ray [HEIGHT][WIDTH];
        Camera camera = new Camera(new Point3D(0.0 ,0.0 ,0.0),
                new Vector (0.0, 1.0, 0.0),
                new Vector (0.0, 0.0, -1.0));
        Triangle triangle = new Triangle(new Point3D( 0, 1, -2),
                new Point3D( 1, -1, -2),
                new Point3D(-1, -1, -2));
        Triangle triangle2 = new Triangle(new Point3D( 0, 10, -2),
                new Point3D( 1, -1, -2),
                new Point3D(-1, -1, -2));
        Triangle triangle3 = new Triangle(new Point3D( 4, -4, 4),
                new Point3D( -3, 3, 5),
                new Point3D(5, 2, 5));
        Ray ray3 = new Ray(new Point3D(0,0,0), new Vector(0.9,1.9,4.9));
        List<Point3D> intersectionPointsTriangle = new ArrayList<Point3D>();
        List<Point3D> intersectionPointsTriangle2 = new ArrayList<Point3D>();
        List<Point3D> intersectionPointsTriangle3 = new ArrayList<Point3D>();
        intersectionPointsTriangle3.addAll(triangle3.FindIntersections(ray3));
        assertEquals(1, intersectionPointsTriangle3.size());

        System.out.println("Camera:\n" + camera);
        for (int i = 0; i < HEIGHT; i++)
        {
            for (int j = 0; j < WIDTH; j++)
            {
                rays[i][j] = camera.constructRayThroughPixel
                        (WIDTH, HEIGHT, j, i, 1, 3 * WIDTH, 3 * HEIGHT);
                List<Point3D> rayIntersectionPoints = triangle.FindIntersections(rays[i][j]);
                List<Point3D> rayIntersectionPoints2 = triangle2.FindIntersections(rays[i][j]);
                for (Point3D iPoint: rayIntersectionPoints)
                    intersectionPointsTriangle.add(iPoint);
                for (Point3D iPoint: rayIntersectionPoints2)
                    intersectionPointsTriangle2.add(iPoint);
            }
        }
        //assertTrue(intersectionPointsTriangle. size() == 1);
        assertEquals(1, intersectionPointsTriangle.size());//output: 0
        //assertTrue(intersectionPointsTriangle2.size() == 2);
        assertEquals(2, intersectionPointsTriangle2.size());//output: 0
        System.out.println("Intersection Points:");
        for (Point3D iPoint: intersectionPointsTriangle)
            System.out.println(iPoint);
        System.out.println("--");
        for (Point3D iPoint: intersectionPointsTriangle2)
            System.out.println(iPoint);
    }
}