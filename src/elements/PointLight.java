package elements;

import primitives.*;

import java.awt.*;

public class PointLight extends Light implements LightSource {
    Point3D _position;
    double _Kc, _Kl, _Kq;
    // ***************** Constructors ********************** //
    public PointLight(Color color, Point3D position,
                      double kc, double kl, double kq);
    // ***************** Getters/Setters ********************** //
    public Color getIntensity(Point3D point);
    public Vector getL(Point3D point);

    @Override
    public Color getIntensity() {
        return null;
    }
}