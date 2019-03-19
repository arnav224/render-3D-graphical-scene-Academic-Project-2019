package Primitives;

import java.util.Objects;

import static Primitives.Util.isZero;

public class Point3D extends Point2D {
    private Coordinate _z;

    // ***************** Constructors ********************** //
    public Point3D() {
        super();
        this._z = new Coordinate();
    }

    public Point3D(Coordinate _x, Coordinate _y, Coordinate _z) {
        super(_x, _y);
        this._z = new Coordinate(_z);
    }

    public Point3D(double _x, double _y, double _z) {
        super(_x, _y);
        this._z = new Coordinate(_z);
    }

    public Point3D(Point3D point3D) {
        super(point3D.get_x(), point3D.get_y());
        this._z = new Coordinate(point3D._z);
    }

    // ***************** Getters/Setters ********************** //
    public Coordinate get_z() {
        return new Coordinate(_z);
    }

    public void set_z(Coordinate _z) {
        this._z = new Coordinate(_z);
    }

    // ***************** Administration ******************** //

    @Override
    public String toString() {
        return String.format("(%.2f, %.2f, %.2f)", _x.get_coord(), _y.get_coord(), _z.get_coord());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point3D point3D = (Point3D) o;
        return super.equals(o) && this._z.equals(point3D._z);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.get_x(), super.get_y(), _z);
    }

    // ***************** Operations ******************** //
    /*************************************************
     * FUNCTION
     * distance
     * PARAMETERS
     * Point3D - other point.
     * RETURN VALUE
     * double - The distance between two points.
     **************************************************/
    public double distance(Point3D point3D) {
        return Math.sqrt(Math.pow(super.get_x().subtract(point3D.get_x()).get_coord(), 2)
                + Math.pow(super.get_y().subtract(point3D.get_y()).get_coord(), 2) + Math.pow(this._z.subtract(point3D._z).get_coord(), 2));
    }
    /*************************************************
     * FUNCTION
     * distance
     * RETURN VALUE
     * double - The distance.
     * MEANING
     * The distance between the point and the zero point
     **************************************************/
    @Override
    public double distance() {
        return Math.sqrt(Math.pow(super.get_x().get_coord(), 2) + Math.pow(super.get_y().get_coord(), 2) + Math.pow(this._z.get_coord(), 2));
    }
    /*************************************************
     * FUNCTION
     * add
     * PARAMETERS
     * Vector
     * RETURN VALUE
     * Point3D - new Point3D as the result.
     * MEANING
     * Calculates the result of adding a vector to the Point.
     * SEE ALSO
     * add method in Coordinate class.
     **************************************************/
    public Point3D add(Vector vector){
        return  new Point3D(
                this.get_x().add(vector.get_head().get_x()),
                this.get_y().add(vector.get_head().get_y()),
                this.get_z().add(vector.get_head().get_z()));
    }
    /*************************************************
     * FUNCTION
     * subtract
     * PARAMETERS
     * Vector
     * RETURN VALUE
     * Point3D - new Point3D as the result.
     * MEANING
     * Calculates the result of vector reduction from the Point.
     * SEE ALSO
     * subtract method in Coordinate class.
     **************************************************/
    public Point3D subtract(Vector vector){
        return  new Point3D(
                this.get_x().subtract(vector.get_head().get_x()),
                this.get_y().subtract(vector.get_head().get_y()),
                this.get_z().subtract(vector.get_head().get_z()));
    }

    /*************************************************
     * FUNCTION
     * subtract
     * PARAMETERS
     * Point3D
     * RETURN VALUE
     * Vector - new Vector as the result.
     * MEANING
     * Creates a new vector from the result of subtracting a point from the point.
     * SEE ALSO
     * subtract method in Coordinate class.
     **************************************************/
    public Vector subtract(Point3D rhs){
        return  new Vector(new Point3D(this._x.subtract(rhs._x),
                this._y.subtract(rhs._y),
                this._z.subtract(rhs._z)));
    }
}
