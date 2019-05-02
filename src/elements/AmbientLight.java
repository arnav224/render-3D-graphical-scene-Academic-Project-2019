package elements;

import primitives.Point3D;
import primitives.Vector;

import java.awt.*;
import java.util.Map;
import java.util.Objects;

public class AmbientLight extends Light implements LightSource {
    private final double _Ka = 0.1; //light intensity
    // ***************** Constructors ********************** //
    /*************************************************
     * FUNCTION
     *
     * PARAMETERS
     *
     * RETURN VALUE
     *
     * MEANING
     *
     * SEE ALSO
     *
     **************************************************/
    public AmbientLight(){
        super(0,0,0);
    }
    /*************************************************
     * FUNCTION
     *
     * PARAMETERS
     *
     * RETURN VALUE
     *
     * MEANING
     *
     * SEE ALSO
     *
     **************************************************/
    public AmbientLight(AmbientLight aLight){
        super(aLight.getColor());
    }
    /*************************************************
     * FUNCTION
     *
     * PARAMETERS
     *
     * RETURN VALUE
     *
     * MEANING
     *
     * SEE ALSO
     *
     **************************************************/
    public AmbientLight(int r, int g, int b){
        super(r, g, b);
    }
    /*************************************************
     * FUNCTION
     *
     * PARAMETERS
     *
     * RETURN VALUE
     *
     * MEANING
     *
     * SEE ALSO
     *
     **************************************************/
    public AmbientLight(Map<String, String> attributes){
        //todo
    }


    // ***************** Getters/Setters ********************** //
    public double getKa() {
        return _Ka;
    }

    /*************************************************
     * FUNCTION
     *
     * PARAMETERS
     *
     * RETURN VALUE
     *
     * MEANING
     *
     * SEE ALSO
     *
     **************************************************/
    @Override
    public String toString() {
        return "AmbientLight{" +
                ", _color=" + _color.toString() +
                "_Ka=" + _Ka +
                '}';
    }
    /*************************************************
     * FUNCTION
     *
     * PARAMETERS
     *
     * RETURN VALUE
     *
     * MEANING
     *
     * SEE ALSO
     *
     **************************************************/
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AmbientLight)) return false;
        AmbientLight that = (AmbientLight) o;
        return Double.compare(that._Ka, _Ka) == 0 && this._color.equals(((AmbientLight) o).getColor());
    }

    /*************************************************
     * FUNCTION
     *
     * PARAMETERS
     *
     * RETURN VALUE
     *
     * MEANING
     *
     * SEE ALSO
     *
     **************************************************/
    @Override
    public Color getIntensity(Point3D point) {
        return new Color((int)_Ka * _color.getRed(), (int)_Ka * _color.getGreen(), (int)_Ka * _color.getBlue());
    }
    /*************************************************
     * FUNCTION
     *
     * PARAMETERS
     *
     * RETURN VALUE
     *
     * MEANING
     *
     * SEE ALSO
     *
     **************************************************/
    public Color getIntensity() {
        return getIntensity(null);
    }

    /*************************************************
     * FUNCTION
     *
     * PARAMETERS
     *
     * RETURN VALUE
     *
     * MEANING
     *
     * SEE ALSO
     *
     **************************************************/
    @Override
    public Vector getL(Point3D point) {
        //todo
        return null;
    }
}
