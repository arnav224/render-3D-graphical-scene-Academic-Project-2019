package elements;

import java.awt.*;

public abstract class Light {
    protected Color _color;
    // ***************** Constructors ********************** //
    public Light(){
        this._color = new Color(0,0,0);
    }
    public Light (Color color){
        this._color = color;
    }
    public Light (int r, int g, int b){
        this._color = new Color(r, g, b);
    }

    // ***************** Getters/Setters ********************** //

    public Color getColor() {
        return _color;
    }

    public Light setColor(Color _color) {
        this._color = _color;
        return this;
    }

    //todo        public abstract Color getIntensity();
}
