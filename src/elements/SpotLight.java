package elements;

import primitives.*;

import java.awt.*;

public class SpotLight extends PointLight{
    private Vector _direction;
    // ***************** Constructor ********************** //
    public SpotLight(Color color, Point3D position, Vector direction,
                     double kc, double kl, double kq);
    // ***************** Getters/Setters ********************** //
    public Color getIntensity(Point3D point);
}