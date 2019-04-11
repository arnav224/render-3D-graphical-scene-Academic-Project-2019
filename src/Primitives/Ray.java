package Primitives;

public class Ray {
    // Point of origin
    private Point3D _POO;

    // Ray direction
    private Vector _direction;

    // ***************** Constructors ********************** //
    public Ray(){
        this._POO = new Point3D();
        this._direction = new Vector();
    }
    public Ray(Ray ray){
        this._POO = new Point3D(ray.getPOO());
        this._direction = new Vector(ray.getDirection());
    }

    public Ray(Point3D _POO, Vector _direction) {
        this._POO = new Point3D(_POO);
        this._direction = new Vector(_direction).normalize();
    }

    // ***************** Getters/Setters ********************** //
    public Point3D getPOO() {
        return new Point3D(_POO);
    }

    public void setPOO(Point3D _POO) {
        this._POO = new Point3D(_POO);
    }

    public Vector getDirection() {
        return new Vector(_direction);
    }

    public void setDirection(Vector _direction) {
        this._direction = new Vector(_direction).normalize();
    }
}
