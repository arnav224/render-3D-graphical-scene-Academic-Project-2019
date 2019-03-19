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
        this._POO = new Point3D(ray.get_POO());
        this._direction = new Vector(ray.get_direction());
    }

    // ***************** Getters/Setters ********************** //
    public Point3D get_POO() {
        return new Point3D(_POO);
    }

    public void set_POO(Point3D _POO) {
        this._POO = new Point3D(_POO);
    }

    public Vector get_direction() {
        return new Vector(_direction);
    }

    public void set_direction(Vector _direction) {
        this._direction = new Vector(_direction);
    }
}
