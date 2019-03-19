package Primitives;

import java.util.Objects;

import static Primitives.Util.*;

public final class Coordinate implements Comparable<Coordinate> {
    protected double _coord;

    public static Coordinate ZERO = new Coordinate(0.0);

    /********** Constructors ***********/
    public Coordinate() {
        _coord = 0.0;
    }

    public Coordinate(double coord) {
        // if it too close to zero make it zero
        _coord = alignZero(coord);
    }

    public Coordinate(Coordinate other) {
        _coord = other._coord;
    }

    /************** Getters/Setters *******/
    public double get_coord() {
        return _coord;
    }

    /**********************************
     * FUNCTION
     * compareTo
     * PARAMETERS
     * Coordinate - the other coordinate to compare
     * RETURN VALUE
     * int. 0 if equal. 1 if this grater. -1 if this smaller.
     ***********************************/
    @Override
    public int compareTo(Coordinate o) {
        if (this.equals(o))
            return 0;
        return (this._coord > o._coord) ? 1 : -1;
    }

    public void set_coord(double _coord) {
        this._coord = alignZero(_coord);
    }

    /*************** Admin *****************/

    /*************************************************
     * FUNCTION
     * equals
     * PARAMETERS
     * Object - Coordinate
     * RETURN VALUE
     * boolean - The result of equality.
     **************************************************/
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(obj instanceof Coordinate)) return false;
        return usubtract(_coord, ((Coordinate)obj)._coord) == 0.0;
    }

    @Override
    public String toString() {
        return "" + _coord;
    }

    /************** Operations ***************/

    /*************************************************
     * FUNCTION
     * subtract
     * PARAMETERS
     * Coordinate
     * RETURN VALUE
     * Coordinate - new Coordinate as the result.
     * MEANING
     * Result of subtraction of two coordinates.
     * SEE ALSO
     * subtract method in Unil class.
     **************************************************/
    public Coordinate subtract(Coordinate other) {
        return new Coordinate(usubtract(_coord, other._coord));
    }

    /*************************************************
     * FUNCTION
     * add
     * PARAMETERS
     * Coordinate
     * RETURN VALUE
     * Coordinate - new Coordinate as the result.
     * MEANING
     * Calculates the result of adding a coordinate to the coordinate.
     * SEE ALSO
     * uadd method in Unil class.
     **************************************************/
    public Coordinate add(Coordinate other) {
        return new Coordinate(uadd(_coord, other._coord));
    }

    /*************************************************
     * FUNCTION
     * scale
     * PARAMETERS
     * double - scalar.
     * RETURN VALUE
     * Coordinate - new Coordinate as the result.
     * MEANING
     * Multiplication in scalar.
     * SEE ALSO
     * uscale method in Unil class.
     **************************************************/
    public Coordinate scale(double num) {
        return new Coordinate(uscale(_coord, num));
    }

    /*************************************************
     * FUNCTION
     * multiply
     * PARAMETERS
     * Coordinate
     * RETURN VALUE
     * Coordinate - new Coordinate as the result.
     * MEANING
     * The multiply result calculates two coordinates.
     * SEE ALSO
     * uscale method in Unil class.
     **************************************************/
    public Coordinate multiply(Coordinate other) {
        return new Coordinate(uscale(_coord, other._coord));
    }

}
