package geometries;

public abstract class RadialGeometry extends Geometry {
    protected double _radius;

    public RadialGeometry() {
        _radius = 0;
    }

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
