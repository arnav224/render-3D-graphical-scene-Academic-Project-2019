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



        Color pointLightColor = super.getIntensity(point);

        Vector l = super.getL(point);
        l.normalize();

        double k = Math.abs(_direction.dotProduct(l));

        if(k > 1) {k = 1;}

        return new Color((int)(pointLightColor.getRed()*k),
                (int)(pointLightColor.getGreen()*k),
                (int)(pointLightColor.getBlue()*k));






//        double d = point.distance(_position);
//        double coefficient = this._direction.dotProduct(new Vector(this._position, point))/(_Kc + _Kl * d + _Kq * Math.pow(d,2));
//        if(coefficient > 1) { coefficient = 1; }
//        Color I0 = this.getIntensity();
//        return new Color((int)(I0.getRed()*coefficient),
//                (int)(I0.getGreen()*coefficient),
//                (int)(I0.getBlue()*coefficient));

    }

    @Override
    public Vector getL(Point3D point){
        return new Vector(this._position, point);
    }

}
