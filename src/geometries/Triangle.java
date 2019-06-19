package geometries;
import primitives.*;

import java.util.ArrayList;
import java.util.List;

import java.util.Map;

public class Triangle extends Geometry implements FlatGeometry{
    /* Three vertices of the triangle */
    private Point3D _p1;
    private Point3D _p2;
    private Point3D _p3;

    // ***************** Constructors ********************** //
    /*************************************************
     * FUNCTION
     * Triangle
     * MEANING
     * default Constructor
     **************************************************/
    public Triangle() {
        this._p1 = new Point3D();
        this._p2 = new Point3D();
        this._p3 = new Point3D();
    }
    /*************************************************
     * FUNCTION
     * Triangle
     * PARAMETERS
     * Triangle
     * MEANING
     * copy Constructor
     **************************************************/
    public Triangle(Triangle triangle){
        this._p1 = triangle._p1;
        this._p2 = triangle._p2;
        this._p3 = triangle._p3;
    }
    /*************************************************
     * FUNCTION
     * Triangle
     * PARAMETERS
     * 3 Point3D - Three vertices of a triangle.
     * MEANING
     * Initializing fields.
     **************************************************/
    public Triangle(Point3D _p1, Point3D _p2, Point3D _p3) {
        this._p1 = _p1;
        this._p2 = _p2;
        this._p3 = _p3;
    }
    /*************************************************
     * FUNCTION
     * Triangle
     * PARAMETERS
     * Map<String, String>
     * MEANING
     *
     **************************************************/
    public Triangle(Map<String, String> attributes){
        //todo implement
    }

    // ***************** Getters/Setters ********************** //
    public Point3D getP1() {
        return _p1;
    }
    public Triangle setP1(Point3D _p1) {
        this._p1 = _p1;
        return this;
    }
    public Point3D getP2() {
        return _p2;
    }
    public Triangle setP2(Point3D _p2) {
        this._p2 = _p2;
        return this;
    }
    public Point3D getP3() {
        return _p3;
    }
    public Triangle setP3(Point3D _p3) {
        this._p3 = _p3;
        return this;
    }

    // ***************** Operations ******************** //
    /*************************************************
     * FUNCTION
     * getNormal
     * PARAMETERS
     * Point3D - point on the Triangle.
     * RETURN VALUE
     * Vector - is the normal.
     * MEANING
     * Return the normal to Triangle at the point.
     **************************************************/
    @Override
    public Vector getNormal(Point3D point_NoUse, Vector direction) {
        return (((this._p2.subtract(this._p1))
                .crossProduct(this._p3.subtract(this._p1))) // A cross product of 2 sides returns the normal.
                .normalize())
                .scale(-1);
    }
    /*************************************************
     * FUNCTION
     * FindIntersections
     * PARAMETERS
     * Ray - A ray from the view plane.
     * RETURN VALUE
     * List<Point3D> - The intersection points.
     * MEANING
     * Finding intersection points with the Triangle.
     **************************************************/
    @Override
    public List<Point3D> FindIntersections(Ray ray) {
        Point3D P0 = ray.getPOO(); // The beginning of the ray.
        Vector N;
        try
        {
            N = this.getNormal(null, ray.getDirection());
        }
        catch ( ArithmeticException e) // Catches a zero vector.
        {
            return new ArrayList<>();
        }
        Plane plane = new Plane(N, this.getP3());
        //Find the intersection point with a plane containing the triangle.
        List<Point3D> intersections = plane.FindIntersections(ray);
        if (intersections.size() == 0) // No intersection point found.
            return intersections;

        /* Calculate the vectors from P0 to the point found and to each of the vertices of the triangle. */
        Vector P_P0 = intersections.get(0).subtract(P0);
        Vector P1_P0 = _p1.subtract(P0);
        Vector P2_P0 = _p2.subtract(P0);
        Vector P3_P0 = _p3.subtract(P0);

/*
        boolean sign1 = P_P0.dotProduct(P1_P0.crossProduct(P2_P0)) > 0;
        boolean sign2 = P_P0.dotProduct(P2_P0.crossProduct(P3_P0)) > 0;
        boolean sign3 = P_P0.dotProduct(P3_P0.crossProduct(P1_P0)) > 0;
        if ((sign1 && sign2 && sign3) || !(sign1 || sign2 || sign3))
            return intersections;
        intersections.clear();
        return intersections;
*/

        if (P_P0.length() == 0) // if length = 0 then it causes unexpected result.
        {
            intersections.clear();
            return intersections;
        }

        /* Here we calculate the projection of the norm of each of the vectors we found
        on the vector that reaches the point, and calculate whether it is positive, negative, or zero. */
        int sign1 = (int)Math.signum(P_P0.dotProduct(P1_P0.crossProduct(P2_P0)));
        int sign2 = (int)Math.signum(P_P0.dotProduct(P2_P0.crossProduct(P3_P0)));
        int sign3 = (int)Math.signum(P_P0.dotProduct(P3_P0.crossProduct(P1_P0)));
        if ((sign1 == sign2 || sign1 == 0 || sign2==0) // Check whether the point on the triangle.
                && (sign2 == sign3 || sign2 == 0 || sign3==0)
                && (sign1 == sign3 || sign1 == 0 || sign3==0))
            return intersections;
//        if (sign1 == sign2 && sign2 == sign3)
//            return intersections;
        intersections.clear(); // If we got here, the point on the plane but not on the triangle.
        return intersections;

    }
}
