package geometries;

import primitives.*;

import java.util.ArrayList;
import java.util.List;

import static primitives.Util.usubtract;

public class Hemisphere extends RadialGeometry {


    private Point3D _center; //A center of Hemisphere.
    private Point3D _bottom; //A bottom of Hemisphere.
    private Point3D _innerBottom;
    private double _innerRadius;
    private final int WITHDRAWAL_SIZE = 10;
    // ***************** Constructors ********************** //
    /*************************************************
     * FUNCTION
     * Hemisphere
     * MEANING
     * default Constructor
     **************************************************/
    public Hemisphere() {
        super(0);
        this._innerRadius = this._radius;
        this._center = new Point3D();
        this._bottom = new Point3D();
        this._innerBottom = new Point3D();
    }
    /*************************************************
     * FUNCTION
     * Hemisphere
     * PARAMETERS
     * Hemisphere
     * MEANING
     * copy Constructor
     **************************************************/
    public Hemisphere (Hemisphere hemisphere){
        super(hemisphere.getRadius());
        this._innerRadius = hemisphere.getInnerRadius();
        this._center = new Point3D(hemisphere.getCenter());
        this._bottom = new Point3D(hemisphere.getBottom());
        this._innerBottom = new Point3D(hemisphere.getInnerBottom());
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
        this._innerRadius = this._radius -WITHDRAWAL_SIZE;
        this._center = new Point3D(_center);
        this._bottom = new Point3D(this._center.subtract(_vBottom.normalize().scale(this.getRadius())));
        this._innerBottom = new Point3D(this._center.subtract(_vBottom.normalize().scale(this.getInnerRadius())));
    }



//    public Hemisphere();
//    public Hemisphere (Hemisphere Hemisphere);
//    public Hemisphere(double radius, Point3D center);
//    public Hemisphere(Map<String, String> attributes);

    // ***************** Getters/Setters ********************** //
//    public Point3D getCenter();
//    public void setCenter(Point3D center);

    public Point3D getCenter() {
        return _center;
    }

    public Hemisphere set_center(Point3D _center) {
        this._center = _center;
        return this;
    }

    public void set_bottom(Point3D _bottom) {
        this._bottom = new Point3D(_bottom);
    }

    public Point3D getBottom() {
        return new Point3D(_bottom);
    }
    private double getInnerRadius() {
        return _innerRadius;
    }

    public void set_innerRadius(double _innerRadius) {
        this._innerRadius = _innerRadius;
    }
    private Point3D getInnerBottom() {
        return new Point3D(_innerBottom);
    }

    public void set_innerBottom(Point3D _innerBottom) {
        this._innerBottom = new Point3D(_innerBottom);
    }
    // ***************** Operations ******************** //
    /*************************************************
     * FUNCTION
     * getNormal
     * PARAMETERS
     * Point3D - point on the Hemisphere.
     * RETURN VALUE
     * Vector - is the normal.
     * MEANING
     * Return the normal to Hemisphere at the point.
     **************************************************/
    @Override
    public Vector getNormal(Point3D point, Vector direction) {
        double d = this._center.distance(point);
        if (usubtract(getRadius(),d) == 0)
            return point.subtract(this._center).normalize();
        return this._center.subtract(point).normalize();
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
        double ir = this.getInnerRadius();

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
            if (pointT1.distance(_bottom) <= Math.sqrt(Math.pow(r,2)))// the ray passes through Hemisphere.
                hemisphereIntersectionPoints.add(pointT1);
        }
        if (usubtract(d,r) == 0) // if d = r then there is only one intersection point.
            return hemisphereIntersectionPoints;
        if (t2 >= 0) // if t2 > / = 0 then the intersection point is visible from the camera's view.
        {
            Point3D pointT2 = new Point3D(P0.add(V.scale(t2)));
            if (pointT2.distance(_bottom) <= Math.sqrt(Math.pow(r,2)))// the ray passes through Hemisphere.
                hemisphereIntersectionPoints.add(pointT2);
        }

        if (d > ir) // If d > ir then the ray does not pass through inner Hemisphere.
            return hemisphereIntersectionPoints;

        double ith = Math.sqrt(Math.pow(ir,2) - Math.pow(d,2));
        double it1 = tm - ith;
        double it2 = tm + ith;

        if (it1 >= 0) // if it1 > / = 0 then the intersection point is visible from the camera's view.
        {
            Point3D pointiT1 = new Point3D(P0.add(V.scale(it1)));
            if (pointiT1.distance(_innerBottom) <= Math.sqrt(2 * Math.pow(ir,2)))// the ray passes through Hemisphere.
                hemisphereIntersectionPoints.add(pointiT1);
        }
        if (usubtract(d, ir) == 0) // if d = ir then there are three intersection point.
            return hemisphereIntersectionPoints;
        if (it2 >= 0) // if it2 > / = 0 then the intersection point is visible from the camera's view.
        {
            Point3D pointiT2 = new Point3D(P0.add(V.scale(it2)));
            if (pointiT2.distance(_innerBottom) <= Math.sqrt(2 * Math.pow(ir,2)))// the ray passes through Hemisphere.
                hemisphereIntersectionPoints.add(pointiT2);
        }

        return hemisphereIntersectionPoints;
    }
}
