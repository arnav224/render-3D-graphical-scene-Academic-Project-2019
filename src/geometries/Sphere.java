package geometries;
import primitives.*;

import java.util.ArrayList;

import java.util.List;

public class Sphere extends RadialGeometry {

    private Point3D _center; //A center of Sphere.

    // ***************** Constructors ********************** //
    /*************************************************
     * FUNCTION
     * Sphere
     * MEANING
     * default Constructor
     **************************************************/
    public Sphere() {
        super(0);
        this._center = new Point3D();
    }
    /*************************************************
     * FUNCTION
     * Sphere
     * PARAMETERS
     * Sphere
     * MEANING
     * copy Constructor
     **************************************************/
    public Sphere (Sphere sphere){
        super(sphere.getRadius());
        this._center = new Point3D(sphere.getCenter());
    }
    /*************************************************
     * FUNCTION
     * Sphere
     * PARAMETERS
     * double - radius, Point3D - center.
     * MEANING
     * Initializing fields.
     **************************************************/
    public Sphere(double _radius, Point3D _center) {
        super(_radius);
        this._center = new Point3D(_center);
    }



//    public Sphere();
//    public Sphere (Sphere sphere);
//    public Sphere(double radius, Point3D center);
//    public Sphere(Map<String, String> attributes);

     // ***************** Getters/Setters ********************** //
//    public Point3D getCenter();
//    public void setCenter(Point3D center);

    public Point3D getCenter() {
        return _center;
    }

    public Sphere set_center(Point3D _center) {
        this._center = _center;
        return this;
    }

    // ***************** Operations ******************** //
    /*************************************************
     * FUNCTION
     * getNormal
     * PARAMETERS
     * Point3D - point on the Sphere.
     * RETURN VALUE
     * Vector - is the normal.
     * MEANING
     * Return the normal to Sphere at the point.
     **************************************************/
    @Override
    public Vector getNormal(Point3D point) {
        return point.subtract(this._center).normalize();
    }
    /*************************************************
     * FUNCTION
     * FindIntersections
     * PARAMETERS
     * Ray - A ray from the view plane.
     * RETURN VALUE
     * List<Point3D> - The intersection points.
     * MEANING
     * Finding intersection points with the Sphere.
     **************************************************/
    @Override
    public List<Point3D> FindIntersections(Ray ray) {
        List<Point3D> sphereIntersectionPoints = new ArrayList<>();

        Point3D P0 = ray.getPOO(); // The beginning of the ray.
        Vector V = ray.getDirection();
        Vector L = this._center.subtract(P0); // 'L' is the distance from P0 to the center of the Sphere.
        double tm = L.dotProduct(V); // 'tm' is the projection of L on the ray.
        //'d' is the distance between 'tm' and the center of Sphere.
        double d = Math.sqrt(Math.pow(L.length(),2) - Math.pow(tm,2));
        double r = this.getRadius();

        if (d > r) // If d > r then the ray does not pass through Sphere.
            return sphereIntersectionPoints;

        // 't1' and 't2': The distance of the normalized ray from the intersection points.
        // tm - t1 = th , tm + th = t2 , so we need to calculate th. We are using the Pythagoras theorem.
        double th = Math.sqrt(Math.pow(r,2) - Math.pow(d,2));
        double t1 = tm - th;
        double t2 = tm + th;

        if (t1 >= 0) // if t1 > / = 0 then the intersection point is visible from the camera's view.
            sphereIntersectionPoints.add(new Point3D(P0.add(V.scale(t1))));
        if (d==r) // if d = r then there is only one intersection point.
            return sphereIntersectionPoints;
        if (t2 >= 0) // if t2 > / = 0 then the intersection point is visible from the camera's view.
            sphereIntersectionPoints.add(new Point3D(P0.add(V.scale(t2))));
        return sphereIntersectionPoints;
    }
}
