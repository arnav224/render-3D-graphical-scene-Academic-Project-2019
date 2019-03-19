package Primitives;
import static Primitives.Util.*;

public class Vector implements Comparable<Vector>{
    private Point3D _head;

    // ***************** Constructors ********************** //

    public Vector() {
        this._head = new Point3D();
    }
    public Vector(Point3D _head) {
        this._head = new Point3D(_head);
    }
    public Vector(Vector _vector) {
        this._head = new Point3D(_vector._head);
    }
    public Vector(double xHead, double yHead, double zHead){
        this._head = new Point3D(xHead, yHead, zHead);
    }
    public Vector(Point3D p1, Point3D p2){
        this._head = new Point3D(p1.get_x().subtract(p2.get_x()),
                p1.get_y().subtract(p2.get_y()),
                p1.get_z().subtract(p2.get_z()));
    }

    // ***************** Getters/Setters ********************** //
    public Point3D get_head() {
        return new Point3D(_head);
    }
    public void set_head(Point3D _head) {
        this._head = _head;
    }


    // ***************** Administration ******************** //

    /*************************************************
     * FUNCTION
     * compareTo
     * PARAMETERS
     * Vector
     * RETURN VALUE
     * int. 0 if equal. 1 if this grater. -1 if this smaller.
     * MEANING
     * Compares the distances of 2 vectors from the zero point.
     * SEE ALSO
     * compareTo method in Point2D class.
     **************************************************/
    @Override
    public int compareTo(Vector o) {
        return this._head.compareTo(o._head);
    }

    @Override
    public String toString() {
        return _head.toString();
    }

    // ***************** Operations ******************** //
    /*************************************************
     * FUNCTION
     * add
     * PARAMETERS
     * Vector
     * MEANING
     * Changes the _head in the direction of the vector.
     * SEE ALSO
     * add method in Point3D class.
     **************************************************/

    public void add (Vector vector ){
        this._head = this._head.add(vector);

    //public Vector add (Vector vector ){
    //    return new Vector(this._head.add(vector));
    //}

    /*************************************************
     * FUNCTION
     * subtract
     * PARAMETERS
     * Vector
     * MEANING
     * Changes the _head in the opposite direction to the vector.
     * SEE ALSO
     * subtract method in Point3D class.
     **************************************************/
    public void subtract (Vector vector){
        this._head = this._head.subtract(vector);
    }
    /*************************************************
     * FUNCTION
     * scale
     * PARAMETERS
     * double - scaling factor.
     * MEANING
     * Changes the scale of the vector according to the parameter.
     * SEE ALSO
     * scale method in Coordinate class.
     **************************************************/
    public void scale(double scalingFactor){
        this._head = new Point3D(_head.get_x().scale(scalingFactor),
                _head.get_y().scale(scalingFactor),
                _head.get_z().scale(scalingFactor));
    }
    /*************************************************
     * FUNCTION
     * crossProduct
     * PARAMETERS
     * Vector
     * RETURN VALUE
     * Vector - the result.
     * MEANING
     * cross product of 2 vectors.
     * SEE ALSO
     * multiply method in Coordinate class.
     **************************************************/
    public Vector crossProduct(Vector vector){
        return new Vector(this._head.get_y().multiply(vector._head.get_z()).subtract(this._head.get_z().multiply(vector._head.get_y())).get_coord(),
                this._head.get_z().multiply(vector._head.get_x()).subtract(this._head.get_x().multiply(vector._head.get_z())).get_coord(),
                this._head.get_x().multiply(vector._head.get_y()).subtract(this._head.get_y().multiply(vector._head.get_x())).get_coord());
    }
    /*************************************************
     * FUNCTION
     * length
     * RETURN VALUE
     * double - length.
     * MEANING
     * The length of the vector.
     **************************************************/
    public double length(){
        return this._head.distance();
    }
    /*************************************************
     * FUNCTION
     * normalize
     * MEANING
     * Normalizes the vector.
     **************************************************/
    public void normalize() {
        if (Primitives.Util.isZero(this.length()))
            throw new IllegalArgumentException();
        this.scale(1 / this.length());
    }
    /*************************************************
     * FUNCTION
     * dotProduct
     * PARAMETERS
     * Vector
     * RETURN VALUE
     * double - the result.
     * MEANING
     * dot product of 2 vectors.
     * SEE ALSO
     * multiply method in Coordinate class.
     **************************************************/
    public double dotProduct(Vector o){
        return this._head.get_x().multiply(o._head.get_x()).get_coord() +
                this._head.get_y().multiply(o._head.get_y()).get_coord() +
                this._head.get_z().multiply(o._head.get_z()).get_coord();
    }
}
