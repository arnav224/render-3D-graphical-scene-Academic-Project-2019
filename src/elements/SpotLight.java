package elements;

import primitives.*;

import java.awt.*;

public class SpotLight extends PointLight{
    private Vector _direction;
    // ***************** Constructor ********************** //
    public SpotLight(Color color, Point3D position, Vector _direction, double kc, double kl, double kq) {
        super(color, position, kc, kl, kq);
        this._direction = new Vector(_direction);
    }

    // ***************** Getters/Setters ********************** //
    public Color getIntensity(Point3D point){

    }
}
