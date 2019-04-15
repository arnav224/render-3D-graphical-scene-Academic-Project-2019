package geometries;
import primitives.*;

import java.util.List;

import java.util.Map;

public class Triangle extends Geometry {

    private Point3D _p1;
    private Point3D _p2;
    private Point3D _p3;

    // ***************** Constructors ********************** //
    public Triangle() {
        this._p1 = new Point3D();
        this._p2 = new Point3D();
        this._p3 = new Point3D();
    }
    public Triangle(Triangle triangle){
        this._p1 = triangle._p1;
        this._p2 = triangle._p2;
        this._p3 = triangle._p3;
    }
    public Triangle(Point3D _p1, Point3D _p2, Point3D _p3) {
        this._p1 = _p1;
        this._p2 = _p2;
        this._p3 = _p3;
    }
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
    @Override
    public Vector getNormal(Point3D point_NoUse) {
        return (((this._p2.subtract(this._p1))
                .crossProduct(this._p3.subtract(this._p1)))
                .normalize())
                .scale(-1);
    }

    @Override
    public List<Point3D> FindIntersections(Ray ray) {
        Point3D P0 = ray.getPOO();
        Vector N = this.getNormal(null);
        Plane plane = new Plane(N, this.getP3());
        List<Point3D> intersections = plane.FindIntersections(ray);
        if (intersections.size() == 0)
            return intersections;
        Vector P_P0 = intersections.get(0).subtract(P0);
        Vector P1_P0 = _p1.subtract(P0);
        Vector P2_P0 = _p2.subtract(P0);
        Vector P3_P0 = _p3.subtract(P0);
        int sign1 = (int)Math.signum(P_P0.dotProduct(P1_P0.crossProduct(P2_P0)));
        int sign2 = (int)Math.signum(P_P0.dotProduct(P2_P0.crossProduct(P3_P0)));
        int sign3 = (int)Math.signum(P_P0.dotProduct(P3_P0.crossProduct(P1_P0)));
        if (sign1 == sign2 && sign2 == sign3)
            return intersections;
        intersections.clear();
        return intersections;

    }
}
