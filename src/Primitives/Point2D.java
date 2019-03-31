package Primitives;

import java.util.Objects;

public class Point2D implements Comparable<Point2D>{
    protected Coordinate _x;
    protected Coordinate _y;

    // ***************** Constructors ********************** //
    public Point2D() {
        this._x = new Coordinate();
        this._y = new Coordinate();
    }

    public Point2D(Coordinate _x, Coordinate _y) {
        this._x = new Coordinate(_x);
        this._y = new Coordinate(_y);
    }

    public Point2D(double _x, double _y) {
        this._x = new Coordinate(_x);
        this._y = new Coordinate(_y);
    }

    public Point2D(Point2D _point2D) {
        this._x = new Coordinate(_point2D._x);
        this._y = new Coordinate(_point2D._y);
    }

    // ***************** Getters/Setters ********************** //
    public Coordinate getX() {
        return new Coordinate(_x);
    }

    public void setX(Coordinate _x) {
        this._x = new Coordinate(_x);
    }

    public Coordinate getY() {
        return new Coordinate(_y);
    }

    public void setY(Coordinate _y) {
        this._y = new Coordinate(_y);
    }

    // ***************** Administration ******************** //
    /*todo*********************************
     * FUNCTION
     * compareTo, Compare the distance from the zero point.
     * PARAMETERS
     * the other point to compare
     * RETURN VALUE
     * int. 0 if equal. 1 if this grater. -1 if this smaller.
     ***********************************/

    /**********************************
     * FUNCTION
     * equals - Checks whether the points are equal.
     * PARAMETERS
     * Point2D - the other point
     * RETURN VALUE
     * int - 0 if equal, 1 if not equal.
     ***********************************/
    @Override
    public int compareTo(Point2D o) {
        return this.equals(o) ? 0 : 1;

/* todo Remember to ask: Does it exceed the habit of compareTo?
        if (this.equals(o) || isZero(this.distance() - o.distance()))
            return 0;
        return (this.distance() - o.distance() > 0) ? 1 : -1;
*/
    }

    /**********************************
     * FUNCTION
     * equals - Checks whether the points are equal.
     * PARAMETERS
     * Point2D - the other point
     * RETURN VALUE
     * boolean - whether the points are equal.
     ***********************************/
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
/*
    public double distance(Point2D point2D){
        return   Math.sqrt(Math.pow(usubtract(this.getX().getCoordinate(), point2D.getX().getCoordinate()), 2)
                + Math.sqrt(Math.pow(usubtract(this.getY().getCoordinate(), point2D.getY().getCoordinate()), 2)));
    }
*/
    public double distance(Point2D point2D){
        return Math.sqrt(Math.pow(this._x.subtract(point2D._x).getCoordinate(), 2) + Math.pow(this._y.subtract(point2D._y).getCoordinate(), 2));
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
        return Math.sqrt(Math.pow(this._x.getCoordinate(), 2) + Math.pow(this._y.getCoordinate(), 2));
    }
}
