package geometries;
import primitives.*;

import java.util.ArrayList;

import java.util.List;

public class Hemisphere extends RadialGeometry {

    private Point3D _center; //A center of Hemisphere.
    private Point3D _bottom; //A bottom of Hemisphere.

    // ***************** Constructors ********************** //
    /*************************************************
     * FUNCTION
     * Hemisphere
     * MEANING
     * default Constructor
     **************************************************/
    public Hemisphere() {
        super(0);
        this._center = new Point3D();
        this._bottom = new Point3D();
    }
    /*************************************************
     * FUNCTION
     * Hemisphere
     * PARAMETERS
     * Hemisphere
     * MEANING
     * copy Constructor
     **************************************************/
    public Hemisphere(Hemisphere hemisphere){
        super(hemisphere.getRadius());
        this._center = new Point3D(hemisphere.getCenter());
        this._bottom = new Point3D(hemisphere.getBottom());
    }
    /*************************************************
     * FUNCTION
     * Hemisphere
     * PARAMETERS
     * double - radius, Point3D - center.
     * MEANING
     * Initializing fields.
     **************************************************/
    public Hemisphere(double _radius, Point3D _center, Vector _vBottom) {
        super(_radius);
        this._center = new Point3D(_center);
        this._bottom = new Point3D(this._center.subtract(_vBottom.normalize().scale(this.getRadius())));
    }




    // ***************** Getters/Setters ********************** //
//    public Point3D getCenter();
//    public void setCenter(Point3D center);
    public void set_bottom(Point3D _bottom) {
        this._bottom = new Point3D(_bottom);
    }

    public Point3D getBottom() {
        return new Point3D(_bottom);
    }
    public Point3D getCenter() {
        return _center;
    }

    public Hemisphere set_center(Point3D _center) {
        this._center = _center;
        return this;
    }

    // ***************** Operations ******************** //
    /*************************************************
     * FUNCTION
     * getNormal
     * PARAMETERS
     * Point3D - point on the Hemisphere.
     * Vector - direction of ray to the point.
     * RETURN VALUE
     * Vector - is the normal.
     * MEANING
     * Return the normal to Hemisphere at the point toward the vector.
     **************************************************/
    @Override
    public Vector getNormal(Point3D point, Vector direction) {
        Vector normal = point.subtract(this._center).normalize();
        //Checks whether the direction of the norm is toward the vector.
        if (direction != null && direction.dotProduct(normal) > 0)
            return normal.scale(-1);
        else
            return normal;

//        Vector normal = new Vector(point.subtract(this._center).normalize());
//        if (direction != null && direction.dotProduct(normal) > 0)
//            return normal;
//        else
//            return normal.scale(-1);
    }
    /*************************************************
     * FUNCTION
     * FindIntersections
     * PARAMETERS
     * Ray - A ray from the view plane.
     * RETURN VALUE
     * List<Point3D> - The intersection points.
     * MEANING
     * Finding intersection points with the Hemisphere.
     **************************************************/
    @Override
    public List<Point3D> FindIntersections(Ray ray) {
        List<Point3D> hemisphereIntersectionPoints = new ArrayList<>();

        Point3D P0 = ray.getPOO(); // The beginning of the ray.
        Vector V = ray.getDirection();
        Vector L = this._center.subtract(P0); // 'L' is the distance from P0 to the center of the Hemisphere.
        double tm = L.dotProduct(V); // 'tm' is the projection of L on the ray.
        //'d' is the distance between 'tm' and the center of Hemisphere.
        double d = Math.sqrt(Math.pow(L.length(),2) - Math.pow(tm,2));
        double r = this.getRadius();

        if (d > r) // If d > r then the ray does not pass through Hemisphere.
            return hemisphereIntersectionPoints;

        // 't1' and 't2': The distance of the normalized ray from the intersection points.
        // tm - t1 = th , tm + th = t2 , so we need to calculate th. We are using the Pythagoras theorem.
        double th = Math.sqrt(Math.pow(r,2) - Math.pow(d,2));
        double t1 = tm - th;
        double t2 = tm + th;

        if (t1 >= 0) // if t1 > / = 0 then the intersection point is visible from the camera's view.
        {
            Point3D pointT1 = new Point3D(P0.add(V.scale(t1)));
            if (pointT1.distance(_bottom) <= Math.sqrt(Math.pow(r,2) + Math.pow(r,2)))// the ray passes through Hemisphere.
                hemisphereIntersectionPoints.add(pointT1);
        }
        if (d==r) // if d = r then there is only one intersection point.
            return hemisphereIntersectionPoints;
        if (t2 >= 0) // if t2 > / = 0 then the intersection point is visible from the camera's view.
        {
            Point3D pointT2 = new Point3D(P0.add(V.scale(t2)));
            if (pointT2.distance(_bottom) <= Math.sqrt(Math.pow(r,2) + Math.pow(r,2)))// the ray passes through Hemisphere.
                hemisphereIntersectionPoints.add(pointT2);
        }
        return hemisphereIntersectionPoints;
    }
}
