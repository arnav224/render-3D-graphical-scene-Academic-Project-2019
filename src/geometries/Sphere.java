package geometries;
import Primitives.*;

import java.util.ArrayList;

import java.util.List;

public class Sphere extends RadialGeometry {

    private Point3D _center;

    // ***************** Constructors ********************** //

    public Sphere() {
        super(0);
        this._center = new Point3D();
    }
    public Sphere (Sphere sphere){
        super(sphere.getRadius());
        this._center = new Point3D(sphere.getCenter());
    }
    public Sphere(double _radius, Point3D _center) {
        super(_radius);
        this._center = new Point3D(_center);
    }



//    public Sphere();
//    public Sphere (Sphere sphere);
//    public Sphere(double radius, Point3D center);
//    public Sphere(Map<String, String> attributes);

//    // ***************** Getters/Setters ********************** //
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
    @Override
    public Vector getNormal(Point3D point) {
        return point.subtract(this._center).normalize();
    }
    @Override
    public List<Point3D> FindIntersections(Ray ray) {
        List<Point3D> point3DS = new ArrayList<>();
        Point3D P0 = ray.getPOO();
        Vector V = ray.getDirection();
        Vector L = this._center.subtract(P0);
        double tm = L.dotProduct(V);
        double d = Math.sqrt(Math.pow(L.length(),2) - Math.pow(tm,2));
        double r = this.getRadius();
        if (d > r)
            return point3DS;
        double th = Math.sqrt(Math.pow(r,2) - Math.pow(d,2));
        double t1 = tm - th;
        double t2 = tm + th;
        if (t1 >= 0)
            point3DS.add(new Point3D(P0.add(V.scale(t1))));
        if (d==r)
            return point3DS;
        if (t2 >= 0)
            point3DS.add(new Point3D(P0.add(V.scale(t2))));
        return point3DS;
    }
}
