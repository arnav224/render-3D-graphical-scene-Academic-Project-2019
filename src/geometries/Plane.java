package geometries;
import primitives.*;

import java.util.ArrayList;
import java.util.List;

public class Plane extends Geometry implements FlatGeometry{
    private Vector _normal; //Normal to plain
    private Point3D _Q; //Any point on the plane

    // ***************** Constructors ********************** //
    /*************************************************
     * FUNCTION
     * Plane
     * MEANING
     * Initializing fields
     **************************************************/
    public Plane() {
        this._normal = new Vector();
        this._Q = new Point3D();
    }
    /*************************************************
     * FUNCTION
     * Plane
     * PARAMETERS
     * Plane
     * MEANING
     * copy Constructor
     **************************************************/
    public Plane(Plane plane){
        this._normal = new Vector(plane._normal);
        this._Q = new Point3D(plane._Q);
    }
    /*************************************************
     * FUNCTION
     * Plane
     * PARAMETERS
     * Vector, Point3D
     * MEANING
     * Initializing fields
     **************************************************/
    public Plane(Vector _normal, Point3D _Q)  {
        this._normal = _normal.normalize();
        this._Q = new Point3D(_Q);
    }

    // ***************** Getters/Setters ********************** //
    public Plane setNormal(Vector _normal) {
        this._normal = new Vector(_normal);
        return this;
    }
    public Point3D getQ() {
        return new Point3D(this._Q);
    }
    public Plane setQ(Point3D _Q) {
        this._Q = new Point3D(_Q);
        return this;
    }

    // ***************** Operations ******************** //
    /*************************************************
     * FUNCTION
     * getNormal
     * PARAMETERS
     * Point3D
     * Vector - direction of ray to the point.
     * RETURN VALUE
     * Vector - is the normal.
     * MEANING
     * Return the normal to Plane at the point toward the vector.
     **************************************************/
    @Override
    public Vector getNormal(Point3D pointNoUse, Vector direction) {
        //Checks whether the direction of the norm is toward the vector
        if (direction != null && direction.dotProduct(_normal) > 0)
            return new Vector(_normal.scale(-1));
        else return new Vector(_normal);
    }

    /*************************************************
     * FUNCTION
     * FindIntersections
     * PARAMETERS
     * Ray - A ray from the view plane.
     * RETURN VALUE
     * List<Point3D> - The intersection points.
     * MEANING
     * Finding intersection points with the Plane.
     **************************************************/
    @Override
    public List<Point3D> FindIntersections(Ray ray) {
        List<Point3D> intersectionPointsPlane = new ArrayList<Point3D>();
        Point3D P0 = ray.getPOO(); // The beginning of the ray.
        Point3D Q0 = this.getQ();
        Vector N = this.getNormal(null, ray.getDirection());//todo
        Vector V = ray.getDirection();
        Vector v = new Vector(Q0, P0);

        //'t' is a parameter that will be multiplied by the normalized vector of the direction of the ray.
        double t = -N.dotProduct(v)/(N.dotProduct(V));  //-1 * N.dotProduct(v) / N.dotProduct(v);

        if (t >= 0) { // if t > / = 0 then the intersection point is visible from the camera's view.
            intersectionPointsPlane.add(P0.add(V.scale(t)));
        }
        return intersectionPointsPlane;

    }
}
