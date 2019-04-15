package elements;

import primitives.Point3D;
import primitives.Vector;

import java.awt.*;
import java.util.Map;

public class AmbientLight extends Light implements LightSource {
    private final double _Ka = 0.1;
    // ***************** Constructors ********************** //
    public AmbientLight(){
        super();
    }
    public AmbientLight(AmbientLight aLight){
        super(aLight.getColor());
    }
    public AmbientLight(int r, int g, int b){
        super(r, g, b);
    }
    public AmbientLight(Map<String, String> attributes){

    }


    // ***************** Getters/Setters ********************** //
    public double getKa() {
        return _Ka;
    }

    @Override
    public Color getIntensity(Point3D point) {
        return null;
    }

    @Override
    public Color getIntensity() {
        //todo
        return null;
    }

    @Override
    public Vector getL(Point3D point) {
        //todo
        return null;
    }
}
