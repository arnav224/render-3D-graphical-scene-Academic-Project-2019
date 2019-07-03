package elements;

import primitives.*;

import java.awt.*;

public class PointLight extends Light implements LightSource {
    public Point3D get_position() {
        return new Point3D(_position);
    }

    public double get_Kc() {
        return _Kc;
    }

    public double get_Kl() {
        return _Kl;
    }

    public double get_Kq() {
        return _Kq;
    }

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
    @Override
    public Color getIntensity(Point3D point) {
        double d = point.distance(_position);

        /*Calculation of attenuation coefficients*/
//        double coefficient = 1/(_Kc * (_Kl * d) * (_Kq*Math.pow(d,2)));
        double coefficient = 1 / (_Kc + _Kl * d + _Kq * Math.pow(d,2)); //Calculation of attenuation coefficients
        if(coefficient > 1) { coefficient = 1; }

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
