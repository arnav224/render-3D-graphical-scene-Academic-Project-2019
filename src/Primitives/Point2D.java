package Primitives;
import java.util.Objects;
import static primitives.Util.*;

public class Point2D implements Comparable<Point2D>{
    protected Coordinate _x;
    protected Coordinate _y;

    // ***************** Constructors ********************** //
    public Point2D() {
        this._x = new Coordinate();
        this._y = new Coordinate();
    }

    public Point2D(Coordinate _x, Coordinate _y) {
        this._x = _x;
        this._y = _y;
    }

    public Point2D(double _x, double _y) {
        this._x.set_coord(_x);
        this._y.set_coord(_y);
    }

    public Point2D(Point2D _point2D) {
        this._x = new Coordinate(_point2D._x);
        this._y = new Coordinate(_point2D._y);
    }

    // ***************** Getters/Setters ********************** //
    public Coordinate get_x() {
        return new Coordinate(_x);
    }

    public void set_x(Coordinate _x) {
        this._x = _x;
    }

    public Coordinate get_y() {
        return new Coordinate(_y);
    }

    public void set_y(Coordinate _y) {
        this._y = _y;
    }

    // ***************** Administration ******************** //
    /**********************************
     * FUNCTION
     * compareTo, Compare the distance from the zero point.
     * PARAMETERS
     * the other point to compare
     * RETURN VALUE
     * int. 0 if equal. 1 if this grater. -1 if this smaller.
     ***********************************/
    //todo - what is the purpose?
    @Override
    public int compareTo(Point2D o) {
        if (this.equals(o) || isZero(this.distance() - o.distance()))
            return 0;
        return (this.distance() - o.distance() > 0) ? 1 : -1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point2D point2D = (Point2D) o;
        return _x.equals(point2D._x) &&
                _y.equals(point2D._y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_x, _y);
    }

    /**********************************
     * FUNCTION
     * distance - calculate the distance between tow points.
     * PARAMETERS
     * Point2D - the other point
     * RETURN VALUE
     *  double - the distance  between the tow points.
     ***********************************/
    public double distance(Point2D point2D){
        return Math.sqrt(Math.pow(this._x.subtract(point2D._x).get_coord(), 2) + Math.pow(this._y.subtract(point2D._y).get_coord(), 2));
    }

    /**********************************
     * FUNCTION
     * distance - calculate the distance from the zero point.
     * PARAMETERS
     *
     * RETURN VALUE
     *  double - the distance from the zero point.
     ***********************************/
    public double distance(){
        return Math.sqrt(Math.pow(this._x.get_coord(), 2) + Math.pow(this._y.get_coord(), 2));
    }
}
