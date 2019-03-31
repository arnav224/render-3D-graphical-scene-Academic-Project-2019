package geometries;
import Primitives.*;
import java.util.List;

public class Plane extends Geometry {
    private Vector _normal;
    private Point3D _Q;

    // ***************** Constructors ********************** //
    //todo Why need?
    public Plane() {
        this._normal = new Vector();
        this._Q = new Point3D();
    }
    public Plane (Plane plane){
        //todo zero-chack?
        this._normal = new Vector(plane._normal);
        this._Q = new Point3D(plane._Q);
    }
    public Plane(Vector _normal, Point3D _Q) {
        //todo zero-chack?
        this._normal = _normal;
        this._Q = _Q;
    }

    // ***************** Getters/Setters ********************** //
    public Vector getNormal() {
        return _normal;
    }
    public Plane setNormal(Vector _normal) {
        this._normal = _normal;
        return this;
    }
    public Point3D getQ() {
        return _Q;
    }
    public Plane setQ(Point3D _Q) {
        this._Q = _Q;
        return this;
    }


    // ***************** Operations ******************** //
    @Override
    public Vector getNormal(Point3D point) {
        return _normal;
    }

    //todo implement
    @Override
    public List<Point3D> FindIntersections(Ray ray) {
        return null;
    }
}
