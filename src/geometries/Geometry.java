package geometries;
import primitives.*;
import java.awt.Color;
import java.util.List;

public abstract class Geometry implements Intersectable{
    private Material _material = new Material();
    private double _nShininess = 1;
    private Color _emmission = new Color(0, 0, 0);
    /*************************************************
     * FUNCTION
     * FindIntersections
     * PARAMETERS
     * Ray
     * RETURN VALUE
     * List<Point3D>
     * MEANING
     * An abstract function for finding intersections with any Geometry.
     **************************************************/
    public abstract List<Point3D> FindIntersections (Ray ray);
    /*************************************************
     * FUNCTION
     * getNormal
     * PARAMETERS
     * Point3D
     * RETURN VALUE
     * Vector
     * MEANING
     * An abstract function for finding the Normal from any geometry
     **************************************************/
    public abstract Vector getNormal(Point3D point);
    /*************************************************
     * FUNCTION
     * get_emmission
     * RETURN VALUE
     * Color
     **************************************************/
    public Color get_emmission() {
        return _emmission;
    }
    /*************************************************
     * FUNCTION
     * setEmmission
     * PARAMETERS
     * Color
     * RETURN VALUE
     * Geometry
     **************************************************/
    public Geometry setEmmission(Color _emmission) {
        this._emmission = _emmission;
        return this;
    }

    public Material getMaterial(){
        return new Material(this._material);
    }

    public void setShininess(double n){
        this._nShininess = n;
    }
    public double getShininess(){
        return this._nShininess;
    }

//    public Color getEmmission();
//    public void setMaterial(Material _material);
//    public void setEmmission(Color emmission);
//    public void setKs(double ks);
//    public void setKd(double kd);
//    public void setKr(double Kr);
//    public void setKt(double Kt);
}
