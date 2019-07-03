package primitives;
//import static primitives.Util.*;

public class Vector implements Comparable<Vector>{
    private Point3D _head;

    // ***************** Constructors ********************** //

    public Vector() {
        this._head = new Point3D();
    }
    public Vector(Point3D _head) {
        Point3D zeroPoint = new Point3D();
        this._head = new Point3D(_head);
    }
    public Vector(Vector _vector) {
        if (_vector.equals(new Vector()))
            throw new IllegalArgumentException();
        this._head = new Point3D(_vector._head);
    }
    public Vector(double xHead, double yHead, double zHead){
        this._head = new Point3D(xHead, yHead, zHead);
    }
    public Vector(Point3D p1, Point3D p2){
        this._head = new Point3D(p2.getX().subtract(p1.getX()),
                p2.getY().subtract(p1.getY()),
                p2.getZ().subtract(p1.getZ()));
    }

    // ***************** Getters/Setters ********************** //
    public Point3D getHead() {
        return new Point3D(_head);
    }
    public void setHead(Point3D _head) {
        this._head = new Point3D(_head);
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
    public Vector add (Vector vector ){
        return new Vector(this._head.add(vector));
    }

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
    public Vector subtract (Vector vector){
        return new Vector(this._head.subtract(vector));
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
    public Vector scale(double scalingFactor){
        return new Vector(new Point3D(_head.getX().scale(scalingFactor),
                _head.getY().scale(scalingFactor),
                _head.getZ().scale(scalingFactor)));
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
     * usubtract, uscale in Util class.
     **************************************************/
    public Vector crossProduct(Vector vector){
        return new Vector(this._head.getY().multiply(vector._head.getZ()).subtract(this._head.getZ().multiply(vector._head.getY())).getCoordinate(),
                this._head.getZ().multiply(vector._head.getX()).subtract(this._head.getX().multiply(vector._head.getZ())).getCoordinate(),
                this._head.getX().multiply(vector._head.getY()).subtract(this._head.getY().multiply(vector._head.getX())).getCoordinate());
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
    public Vector normalize() {
        if (primitives.Util.isZero(this.length()))
            throw new ArithmeticException();
        return this.scale(1 / this.length());
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
        return this._head.getX().scale(o._head.getX().getCoordinate()).getCoordinate() +
                this._head.getY().scale(o._head.getY().getCoordinate()).getCoordinate() +
                this._head.getZ().scale(o._head.getZ().getCoordinate()).getCoordinate();
    }
}
