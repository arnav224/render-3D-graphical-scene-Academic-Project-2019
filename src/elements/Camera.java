package elements;
import Primitives.*;

public class Camera {
    //Eye point of the camera
    private Point3D _P0;
    private Vector _vUp;
    private Vector _vTo;
    private Vector _vRight;

    // ***************** Constructors ********************** //
    public Camera(){
        _P0 = new Point3D (0, 0, 10);
        _vUp = new Vector(1.0, 0.0, 0.0);
        _vTo = new Vector(0.0, 0.0, -1.0);
        _vRight = _vUp.crossProduct(_vTo);
    }

    public Camera (Camera camera)
    {
        _P0 = new Point3D(camera.)
    }

    public Camera (Point3D P0, Vector vUp, Vector vTo){
        _P0 = new Point3D (P0);
        _vUp = new Vector(1.0, 0.0, 0.0);
        _vTo = new Vector(0.0, 0.0, -1.0);
        _vRight = _vUp.crossProduct(_vTo);
    }
//  public Camera (Map<String, String> attributes(;
// ***************** Getters/Setters ********************** //
                           public Vector get_vUp)(;
    public void set_vUp(Vector vUp(;
            public Vector get_vTo)(;
    public void set_vTo(Vector vTo(;
            public Point3D getP0)(;
    public void setP0(Point3D P0);
    public Vector get_vRight)(;
    // ***************** Administration ********************** //
    public String toString)(;
    // ***************** Operations ******************** //
    public Ray constructRayThroughPixel (int Nx, int Ny,
                                         double x, double y,
                                         double screenDist,
                                         double screenWidth,
                                         double screenHeight);
}
