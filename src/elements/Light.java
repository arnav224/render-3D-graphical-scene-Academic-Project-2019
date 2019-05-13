package elements;

import java.awt.*;

public abstract class Light {
    protected Color _color;
    // ***************** Constructors ********************** //
    public Light(){
        this._color = new Color(0,0,0);
    }
    public Light (Color color){
        this._color = new Color(color.getRed());
    }
    public Light (int r, int g, int b){
        this._color = new Color(r, g, b);
    }

    // ***************** Getters/Setters ********************** //

    public Color getColor() {
        return new Color(this._color.getRGB());
    }
    public void setColor(Color _color) {
        this._color = new Color(_color.getRGB());
    }

    public abstract Color getIntensity();
}
