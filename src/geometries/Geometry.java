package geometries;
import primitives.*;
import java.awt.Color;
import java.util.List;

public abstract class Geometry implements Intersectable{
    private Material _material = new Material();
    //private double _nShininess = 1;
    private Color _emmission = new Color(0, 0, 0);

    // ***************** Operations ******************** //
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
     * Vector - direction of ray to the point.
     * RETURN VALUE
     * Vector
     * MEANING
     * An abstract function for finding the Normal from any geometry toward the vector.
     **************************************************/
    public abstract Vector getNormal(Point3D point, Vector direction);

    // ***************** Getters/Setters ********************** //
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

    public void setShininess(int n){
        this._material.setShininess(n);
    }
    public int getShininess(){
        return this._material.getShininess();
    }


    public Color getEmmission(){
        return new Color(_emmission.getRGB());
    }
    public void setMaterial(Material _material){
        this._material = new Material(_material);
    }

    public void setKs(double ks){
        this._material.setKs(ks);
    }
    public void setKd(double kd){
        this._material.setKd(kd);
    }
    public void setKr(double Kr) throws Exception{
        this._material.setKr(Kr);
    }
    public void setKt(double Kt) throws Exception{
        this._material.setKt(Kt);
    }
}
