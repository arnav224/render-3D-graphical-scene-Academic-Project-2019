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

        Color LightColor = super.getIntensity();
        double d = point.distance(_position);
        Vector l = super.getL(point).normalize();

            /*Calculation of attenuation coefficients*/
        double k = Math.abs(_direction.normalize().dotProduct(l))/(_Kc + _Kl * d + _Kq * Math.pow(d,2));

        if(k > 1) {k = 1;}

        return new Color((int)(LightColor.getRed()*k),
                (int)(LightColor.getGreen()*k),
                (int)(LightColor.getBlue()*k));


    }

    public Vector get_direction(){
        return new Vector(_direction);
    }

    @Override
    public Vector getL(Point3D point){
        return new Vector(this._position, point);
    }

}
