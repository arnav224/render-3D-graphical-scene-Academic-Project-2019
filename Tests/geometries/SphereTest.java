package geometries;

import primitives.*;
import elements.Camera;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SphereTest {

    @Test
    void getRadius() {
    }

    @Test
    void setRadius() {
    }

    @Test
    void getCenter() {
    }

    @Test
    void set_center() {
    }

    @Test
    void getNormal() {
    }

    @Test
    void findIntersections() {
    }

    @Test
    public void testIntersectionPoints() {
        final int WIDTH = 3;
        final int HEIGHT = 3;
        Ray[][] rays = new Ray[HEIGHT][WIDTH];
        Camera camera = new Camera(new Point3D(0.0, 0.0, 0.0),
                new Vector(0.0, 1.0, 0.0),
                new Vector(0.0, 0.0, -1.0));
        Sphere sphere = new Sphere(1, new Point3D(0.0, 0.0, -3.0));
        Sphere sphere2 = new Sphere(10, new Point3D(0.0, 0.0, -3.0));
// Only the center ray intersect the sphere in two locations
        List<Point3D> intersectionPointsSphere = new ArrayList<Point3D>();
// The sphere encapsulates the view plane - all rays intersect with the sphere once
        List<Point3D> intersectionPointsSphere2 = new ArrayList<Point3D>();
        System.out.println("Camera:\n" + camera);
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                rays[i][j] = camera.constructRayThroughPixel(
                        WIDTH, HEIGHT, j, i, 1, 3 * WIDTH, 3 * HEIGHT);
                List<Point3D> rayIntersectionPoints = sphere.FindIntersections(rays[i][j]);
                List<Point3D> rayIntersectionPoints2 = sphere2.FindIntersections(rays[i][j]);
                for (Point3D iPoint : rayIntersectionPoints)
                    intersectionPointsSphere.add(iPoint);
                for (Point3D iPoint : rayIntersectionPoints2)
                    intersectionPointsSphere2.add(iPoint);
            }
        }
        //assertTrue(intersectionPointsSphere.size() == 2);
        assertEquals(2, intersectionPointsSphere.size());//output: 0
        //assertTrue(intersectionPointsSphere2.size() == 9);
        assertEquals(9, intersectionPointsSphere2.size());//output: 3
        System.out.println("Intersection Points:");
        for (Point3D iPoint : intersectionPointsSphere) {
            assertTrue(iPoint.compareTo(new Point3D(0.0, 0.0, -2.0)) == 0 ||
                    iPoint.compareTo(new Point3D(0.0, 0.0, -4.0)) == 0);
            System.out.println(iPoint);
        }

    }
}