package elements;

import primitives.Point3D;
import primitives.Vector;

import java.awt.*;
import java.util.Map;
import java.util.Objects;

public class AmbientLight extends Light implements LightSource {
    private final double _Ka = 0.1;
    // ***************** Constructors ********************** //
    public AmbientLight(){
        super(0,0,0);
    }
    public AmbientLight(AmbientLight aLight){
        super(aLight.getColor());
    }
    public AmbientLight(int r, int g, int b){
        super(r, g, b);
    }

    public AmbientLight(Map<String, String> attributes){
        //todo
    }


    // ***************** Getters/Setters ********************** //
    public double getKa() {
        return _Ka;
    }


    @Override
    public String toString() {
        return "AmbientLight{" +
                ", _color=" + _color.toString() +
                "_Ka=" + _Ka +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AmbientLight)) return false;
        AmbientLight that = (AmbientLight) o;
        return Double.compare(that._Ka, _Ka) == 0 && this._color.equals(((AmbientLight) o).getColor());
    }


    @Override
    public Color getIntensity(Point3D point) {
        return new Color((int)_Ka * _color.getRed(), (int)_Ka * _color.getGreen(), (int)_Ka * _color.getBlue());
    }
    public Color getIntensity() {
        return getIntensity(null);
    }


    @Override
    public Vector getL(Point3D point) {
        //todo
        return null;
    }
}
