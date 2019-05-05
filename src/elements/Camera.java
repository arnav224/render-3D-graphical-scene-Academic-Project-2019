package elements;
import primitives.*;

public class Camera {
    //Eye point of the camera
    private Point3D _P0; //center point
    private Vector _vUp; //y-axis
    private Vector _vTo; //-z-axis
    private Vector _vRight; //x-axis

    // ***************** Constructors ********************** //
    /*************************************************
     * FUNCTION
     * Camera
     * MEANING
     * Default camera position initialization.
     **************************************************/
    public Camera(){
        _P0 = new Point3D (0, 0, 10);
        _vUp = new Vector(1.0, 0.0, 0.0);
        _vTo = new Vector(0.0, 0.0, -1.0);
        _vRight = _vTo.crossProduct(_vUp).normalize();
    }
    /*************************************************
     * FUNCTION
     * Camera
     * PARAMETERS
     * Camera
     * MEANING
     * copy constructor
     **************************************************/
    public Camera (Camera camera)
    {
        _P0 = camera.getP0();
        _vUp = camera.get_vUp();
        _vTo = camera.get_vTo();
        _vRight = camera.get_vRight();
    }
    /*************************************************
     * FUNCTION
     * Camera
     * PARAMETERS
     * Point3D, Vector, Vector.
     * RETURN VALUE
     * Camera
     * MEANING
     * Camera position initialization.
     **************************************************/
    public Camera (Point3D P0, Vector vUp, Vector vTo){
        _P0 = new Point3D(P0);
        _vUp = new Vector(vUp);
        _vTo = new Vector(vTo);
        _vRight = _vTo.crossProduct(_vUp).normalize();
    }
    /*************************************************
     * FUNCTION
     * Camera
     * PARAMETERS
     * Map<String, String> -
     * RETURN VALUE
     * Camera
     * MEANING
     *
     * SEE ALSO
     *
     **************************************************/
//  public Camera (Map<String, String> attributes(;

// ***************** Getters/Setters ********************** //

    public Point3D getP0() {
        return _P0;
    }
    public Camera setP0(Point3D _P0) {
        this._P0 = _P0;
        return this;
    }
    public Vector get_vUp() {
        return _vUp;
    }
    public Camera set_vUp(Vector _vUp) {
        this._vUp = _vUp;
        return this;
    }
    public Vector get_vTo() {
        return _vTo;
    }
    public Camera set_vTo(Vector _vTo) {
        this._vTo = _vTo;
        return this;
    }
    public Vector get_vRight() {
        return _vRight;
    }
    public Camera set_vRight(Vector _vRight) {
        this._vRight = _vRight;
        return this;
    }

    // ***************** Administration ********************** //
    /*************************************************
     * FUNCTION
     * toString
     **************************************************/
    public String toString()
    {
        return "Vto: " + _vTo + "\n" + "Vup: " + _vUp + "\n" + "Vright:" + _vRight + ".";
    }
    // ***************** Operations ******************** //
    /*************************************************
     * FUNCTION
     * constructRayThroughPixel
     * PARAMETERS
     * 2 ints -
     * 2 doubles -
     * 3 doubles -
     * RETURN VALUE
     * Ray -
     * MEANING
     * todo
     * SEE ALSO
     *
     **************************************************/
    public Ray constructRayThroughPixel (int Nx, int Ny,
                                         double x, double y,
                                         double screenDist,
                                         double screenWidth,
                                         double screenHeight){ //todo: to green
        Point3D Pc = _P0.add(_vTo.scale(screenDist));
        double Rx = screenWidth / Nx;
        double Ry = screenHeight / Ny;
        //todo add or sub
        Point3D pixel = Pc.add(_vRight.scale((x-Nx/2)*Rx )).subtract(_vUp.scale((y-Ny/2)*Ry));
        //Point3D pixel = Pc.add(_vRight.scale((x-Nx/2)*Rx + Rx/2)).subtract(_vUp.scale((y-Ny/2)*Ry + Ry/2)); //this is the original formula
        if (Nx % 2 == 0)
            pixel = pixel.add(new Vector(Rx/2,0,0));
        if (Ny % 2 == 0)
            pixel = pixel.add(new Vector(0,-Ry/2,0));
        return new Ray(pixel, pixel.subtract(_P0).normalize());
        //todo the ray start from?
        //return new Ray(new Point3D(), pixel.subtract(_P0).normalize());
    //new Point3D((x-(Nx-1)/2)*Rx, (y-(Ny-1)/2)*Ry, -1*screenDist)
    }
}

