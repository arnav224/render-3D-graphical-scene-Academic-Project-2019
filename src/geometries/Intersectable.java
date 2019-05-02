package geometries;

import primitives.*;

import java.util.List;

public interface Intersectable {
    /*************************************************
     * FUNCTION
     *
     * PARAMETERS
     *
     * RETURN VALUE
     *
     * MEANING
     *
     * SEE ALSO
     *
     **************************************************/
    List<Point3D> FindIntersections(Ray ray);
}
