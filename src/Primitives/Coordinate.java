package Primitives;

import java.util.Objects;

import static primitives.Util.*;

public final class Coordinate implements Comparable<Coordinate> {
    protected double _coord;

    public static Coordinate ZERO = new Coordinate(0.0);

    /********** Constructors ***********/
    public Coordinate() {
        _coord = 0;
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
    public Coordinate subtract(Coordinate other) {
        return new Coordinate(usubtract(_coord, other._coord));
    }

    public Coordinate add(Coordinate other) {
        return new Coordinate(uadd(_coord, other._coord));
    }

    public Coordinate scale(double num) {
        return new Coordinate(uscale(_coord, num));
    }

    public Coordinate multiply(Coordinate other) {
        return new Coordinate(uscale(_coord, other._coord));
    }

}
