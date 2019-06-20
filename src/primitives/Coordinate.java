package primitives;

import static primitives.Util.*;

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
    public double getCoordinate() {
        return _coord;
    }

    public void setCoordinate(double _coord) {
        this._coord = alignZero(_coord);
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
        return String.format("%.2f", _coord);
    }

    /************** Operations ***************/

    /************************************************
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
     //***********************************************/
    public Coordinate subtract(Coordinate other) {
        return new Coordinate(usubtract(_coord, other._coord));
    }

/*todo
    */
/*************************************************
     * FUNCTION
     * subtract
     * PARAMETERS
     * Coordinate
     * MEANING
     * Subtracts a coordinate to the current coordinate.
     * SEE ALSO
     * subtract method in Unil class.
     **************************************************//*
*/
/*

    public void subtract(Coordinate other) {
        this._coord = (usubtract(_coord, other._coord));
    }
*//*



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
        return new Coordinate(uadd(this._coord, other._coord));
    }

/*
    public void add(Coordinate other) {
        this._coord = (uadd(_coord, other._coord));
    }
*/
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
        return new Coordinate(_coord * num);
        //return new Coordinate(uscale(_coord, num));
    }

/*
    public void scale(double num) {
        this._coord = uscale(_coord, num);
    }
*/

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


/*
    public void multiply(Coordinate other) {
        this._coord = uscale(_coord, other._coord);
    }
*/


}
