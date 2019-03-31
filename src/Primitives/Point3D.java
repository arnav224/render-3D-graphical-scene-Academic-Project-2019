package Primitives;
import static Primitives.Util.*;

import java.util.Objects;

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
        super(point3D.getX(), point3D.getY());
        this._z = new Coordinate(point3D._z);
    }

    // ***************** Getters/Setters ********************** //
    public Coordinate getZ() {
        return new Coordinate(_z);
    }

    public void setZ(Coordinate _z) {
        this._z = new Coordinate(_z);
    }

    // ***************** Administration ******************** //
    /**********************************
     * FUNCTION
     * equals - Checks whether the points are equal.
     * PARAMETERS
     * Point2D - the other point
     * RETURN VALUE
     * int - 0 if equal, 1 if not equal.
     ***********************************/
    public int compareTo(Point3D o) {
        return (super.compareTo(o) == 0 && this.getZ().equals(o.getZ()) ? 0 : 1);
    }

    @Override
    public String toString() {
        return String.format("(%.2f, %.2f, %.2f)", _x.getCoordinate(), _y.getCoordinate(), _z.getCoordinate());
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
        return Objects.hash(super.getX(), super.getY(), _z);
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
        return    Math.sqrt(Math.pow(usubtract(super.getX().getCoordinate(), point3D.getX().getCoordinate()), 2)
                + Math.pow(usubtract(super.getY().getCoordinate(), point3D.getY().getCoordinate()), 2)
                + Math.pow(usubtract(this.getZ().getCoordinate(), point3D.getZ().getCoordinate()), 2));
    }
/*todo
    public double distance(Point3D point3D) {
        return Math.sqrt(Math.pow(super.getX().subtract(point3D.getX()).getCoordinate(), 2)
                + Math.pow(super.getY().subtract(point3D.getY()).getCoordinate(), 2) + Math.pow(this._z.subtract(point3D._z).getCoordinate(), 2));
    }
*/
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
        return Math.sqrt(Math.pow(super.getX().getCoordinate(), 2) + Math.pow(super.getY().getCoordinate(), 2) + Math.pow(this._z.getCoordinate(), 2));
    }
    //public void add(Vector vector);
    //public void subtract(Vector vector);
    /************************************************
         * FUNCTION
         * add
         * PARAMETERS
         * Vector
         * MEANING
         * Adds a vector to the current point.
         * SEE ALSO
         * add method in Coordinate class.
    **************************************************/
     public void add(Vector vector) {
         this._x.add(vector.getHead().getX());
         this._y.add(vector.getHead().getY());
         this._z.add(vector.getHead().getZ());
     }

    /*todo************************************************
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
    /*todo public Point3D add(Vector vector){
        return  new Point3D(
                this.getX().add(vector.get_head().getX()),
                this.getY().add(vector.get_head().getY()),
                this.getZ().add(vector.get_head().getZ()));
    }*/
    /*************************************************
     * FUNCTION
     * subtract
     * PARAMETERS
     * Vector to subtract the point.
     * MEANING
     * subtracts a vector to the current point.
     * SEE ALSO
     * subtract method in Coordinate class.
     **************************************************/
    public void subtract(Vector vector){
        this._x.subtract(vector.getHead().getX());
        this._y.subtract(vector.getHead().getY());
        this._z.subtract(vector.getHead().getZ());
    }
    /*todo************************************************
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
    /*todo public Point3D subtract(Vector vector){
        return  new Point3D(
                this.getX().subtract(vector.get_head().getX()),
                this.getY().subtract(vector.get_head().getY()),
                this.getZ().subtract(vector.get_head().getZ()));
    }*/

    /*todo************************************************
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
/*todo
    public Vector subtract(Point3D rhs){
        return  new Vector(new Point3D(this._x.subtract(rhs._x),
                this._y.subtract(rhs._y),
                this._z.subtract(rhs._z)));
    }
*/


}
