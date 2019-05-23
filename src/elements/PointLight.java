package elements;

import primitives.*;

import java.awt.*;

public class PointLight extends Light implements LightSource {
    Point3D _position;
    double _Kc, _Kl, _Kq;
    // ***************** Constructors ********************** //
    public PointLight(Color color, Point3D position,
                      double kc, double kl, double kq) {
        super(color);
        this._position = position;
        this._Kc = kc;
        this._Kl = kl;
        this._Kq = kq;
    }

    // ***************** Getters/Setters ********************** //
    public Color getIntensity(Point3D point){
        double d = point.distance(_position);

        double coefficient = 1 / (_Kc + _Kl * d + _Kq * Math.pow(d,2));
        if(coefficient > 1) { coefficient = 1; }
//        if(coefficient < 0) {
//            coefficient = 0;
//        }

        Color I0 = this.getIntensity();
        return new Color((int)(I0.getRed()*coefficient),
                (int)(I0.getGreen()*coefficient),
                (int)(I0.getBlue()*coefficient));
    }


    public Vector getL(Point3D point){
        return new Vector(this._position, point);
    }

    @Override
    public Color getIntensity() {
        return super.getColor();
    }
}
