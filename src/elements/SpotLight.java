package elements;

import primitives.*;

import java.awt.*;

public class SpotLight extends PointLight{
    private Vector _direction;
    // ***************** Constructor ********************** //
    public SpotLight(Color color, Point3D position, Vector _direction, double kc, double kl, double kq) {
        super(color, position, kc, kl, kq);
        this._direction = new Vector(_direction).normalize();
    }

    // ***************** Getters/Setters ********************** //
    public Color getIntensity(Point3D point){
        double d = point.distance(_position);
        double coefficient = this._direction.dotProduct(new Vector(this._position, point).normalize())/(_Kc * _Kl * d * _Kq * Math.pow(d,2));
        Color I0 = this.getIntensity();
        return new Color((int)(I0.getRed()*coefficient),
                (int)(I0.getGreen()*coefficient),
                (int)(I0.getBlue()*coefficient));
    }

    @Override
    public Vector getL(Point3D point){
        return new Vector(this._position, point);
    }

}
