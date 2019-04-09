package geometries;
import Primitives.*;

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
        return null;
    }
}
