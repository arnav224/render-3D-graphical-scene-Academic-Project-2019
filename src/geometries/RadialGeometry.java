package geometries;

public abstract class RadialGeometry extends Geometry {
    protected double _radius; // radius
    // ***************** Constructors ********************** //
    /*************************************************
     * FUNCTION
     * RadialGeometry
     * MEANING
     * Initializes _radius to 0.
     **************************************************/
    public RadialGeometry() {
        _radius = 0;
    }
    /*************************************************
     * FUNCTION
     * RadialGeometry
     * PARAMETERS
     * double
     * MEANING
     * Initializes _radius.
     **************************************************/
    public RadialGeometry(double _radius) {
        this._radius = _radius;
    }

    // ***************** Getters/Setters ********************** //

    public double getRadius() {
        return _radius;
    }

    public void setRadius(double _radius) {
        this._radius = _radius;
    }

}
