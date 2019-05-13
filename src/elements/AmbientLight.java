package elements;

import primitives.Point3D;
import primitives.Vector;

import java.awt.*;
import java.util.Map;

public class AmbientLight extends Light{
    private final double _Ka = 0.1; //light intensity
    // ***************** Constructors ********************** //
    /*************************************************
     * FUNCTION
     * AmbientLight
     * MEANING
     * Initializes the color field to black
     **************************************************/
    public AmbientLight(){
        super(0,0,0);
    }
    /*************************************************
     * FUNCTION
     * AmbientLight
     * PARAMETERS
     * AmbientLight
     * MEANING
     * copy constructor
     **************************************************/
    public AmbientLight(AmbientLight aLight){
        super(aLight.getColor());
    }
    /*************************************************
     * FUNCTION
     * AmbientLight
     * PARAMETERS
     * 3 ints - initializes the color field.
     * MEANING
     * Constructor
     **************************************************/
    public AmbientLight(int r, int g, int b){
        super(r, g, b);
    }
    /*************************************************
     * FUNCTION
     * AmbientLight
     * PARAMETERS
     * Map<String, String> -
     * MEANING
     * Constructor
     * SEE ALSO
     *
     **************************************************/
    public AmbientLight(Map<String, String> attributes){
        //todo
    }


    // ***************** Getters/Setters ********************** //
    public Color getColor(){return new Color(this._color.getRGB());}
    public void setColor(Color color){this._color = new Color(color.getRGB());}
    public double getKa() {
        return _Ka;
    }


    /*************************************************
     * FUNCTION
     * getIntensity
     * PARAMETERS
     * Point3D - not in use
     * RETURN VALUE
     * Color
     * MEANING
     * Calculates the color with the lighting
     **************************************************/
    public Color getIntensity(Point3D point) {
        return new Color((int)_Ka * _color.getRed(), (int)_Ka * _color.getGreen(), (int)_Ka * _color.getBlue());
    }
    /*************************************************
     * FUNCTION
     * getIntensity
     * RETURN VALUE
     * Color
     * MEANING
     * Returns the color with the lighting
     **************************************************/
    public Color getIntensity() {
        return getIntensity(null);
    }


    /*************************************************
     * FUNCTION
     * toString
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
     * equals
     **************************************************/
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AmbientLight)) return false;
        AmbientLight that = (AmbientLight) o;
        return Double.compare(that._Ka, _Ka) == 0 && this._color.equals(((AmbientLight) o).getColor());
    }

}
