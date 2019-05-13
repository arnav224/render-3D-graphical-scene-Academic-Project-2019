package elements;

import primitives.*;

import java.awt.*;

public class DirectionalLight extends Light implements LightSource {
    private Vector _direction;
    // ***************** Constructors ********************** //
    public DirectionalLight(Color color, Vector direction){}
    // ***************** Getters/Setters ********************** //
    public Color getIntensity(Point3D point){}
    public Vector getDirection(){return new Vector(this._direction);}
    public void setDirection(Vector _direction){}
    public Vector getL(Point3D point){}

    @Override
    public Color getIntensity() {
        return super.getColor();
    }
}
