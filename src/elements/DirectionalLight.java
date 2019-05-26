package elements;

import primitives.*;

import java.awt.*;

public class DirectionalLight extends Light implements LightSource {
    private Vector _direction;//Direction of light.
    // ***************** Constructors ********************** //
    public DirectionalLight(Color color, Vector direction){
        this._color = new Color(color.getRed());
        this._direction = new Vector(direction).normalize();
    }
    // ***************** Getters/Setters ********************** //
    public Color getIntensity(Point3D point){
        return getIntensity();
    }
    public Vector getDirection(){
        return new Vector(this._direction);
    }
    public void setDirection(Vector _direction){
        this._direction = new Vector(_direction).normalize();
    }
    public Vector getL(Point3D point){
        return getDirection();
    }

    @Override
    public Color getIntensity() {
        return super.getColor();
    }
}
