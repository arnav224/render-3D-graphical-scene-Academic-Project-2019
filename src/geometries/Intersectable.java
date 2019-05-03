package geometries;

import primitives.*;

import java.util.List;

public interface Intersectable {
    /*************************************************
     * FUNCTION
     * FindIntersections
     * PARAMETERS
     * Ray
     * RETURN VALUE
     * List<Point3D>
     * MEANING
     * A function for finding intersections with any object.
     **************************************************/
    List<Point3D> FindIntersections(Ray ray);
}
