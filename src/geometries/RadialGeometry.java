package geometries;

public abstract class RadialGeometry extends Geometry {
    protected double _radius;
    /*************************************************
     * FUNCTION
     *
     * PARAMETERS
     *
     * RETURN VALUE
     *
     * MEANING
     *
     * SEE ALSO
     *
     **************************************************/
    public RadialGeometry() {
        _radius = 0;
    }
    /*************************************************
     * FUNCTION
     *
     * PARAMETERS
     *
     * RETURN VALUE
     *
     * MEANING
     *
     * SEE ALSO
     *
     **************************************************/
    public RadialGeometry(double _radius) {
        this._radius = _radius;
    }

    public double getRadius() {
        return _radius;
    }

    public void setRadius(double _radius) {
        this._radius = _radius;
    }

}
