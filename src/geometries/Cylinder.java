package geometries;
import Primitives.*;
import java.util.List;

public class Cylinder extends RadialGeometry {
    private Point3D _axisPoint;
    private Vector _axisDirection;
    // ***************** Constructors ********************** //
    public Cylinder(){
        this._axisPoint = new Point3D();
        this._axisDirection = new Vector();
        this._radius = 0.0;
    }
    public Cylinder(Cylinder cylinder){
        this._axisPoint = new Point3D(cylinder._axisPoint);
        this._axisDirection = new Vector(cylinder._axisDirection);
        this._radius = cylinder._radius;
    }

    public Cylinder(double radius, Point3D axisPoint, Vector axisDirection) {
        super(radius);
        this._axisPoint = new Point3D(axisPoint);
        this._axisDirection = new Vector(axisDirection);
    }

    // ***************** Getters/Setters ********************** //

    public Point3D getAxisPoint() {
        return new Point3D(_axisPoint);
    }

    public void setAxisPoint(Point3D _axisPoint) {
        this._axisPoint = _axisPoint;
    }

    public Vector getAxisDirection() {
        return new Vector(_axisDirection);
    }

    public void setAxisDirection(Vector _axisDirection) {
        this._axisDirection = _axisDirection;
    }

    // ***************** Operations ******************** //
    //todo
    @Override
    public List<Point3D> FindIntersections(Ray ray){
        return null;
    }
    //todo
    @Override
    public Vector getNormal(Point3D point){
        return null;
    }
}
