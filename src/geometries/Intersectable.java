package geometries;

import Primitives.*;
import java.util.ArrayList;

public interface Intersectable {
    ArrayList<Point3D> FindIntersections(Ray ray);
}
