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
     * constructRayThroughPixel - For a given scene and a given pixel,
     * a ray should be returned from the pixel on the viewPlane and in the correct direction.
     * PARAMETERS
     * int Nx, int Ny, // Screen size - The number of pixels in length and width.
     * double x, double y, // Point - The number of pixels to progress on the axes to the current point.
     * double screenDist, // - Position the screen relative to the camera point
     * double screenWidth, double screenHeight // - The screen size in the units used.
     * RETURN VALUE
     * Ray
     * MEANING
     * This function sends ray through pixel into the view plane
     * SEE ALSO
     *
     **************************************************/

    public Ray constructRayThroughPixel (int Nx, int Ny, // Screen size
                                         double x, double y,  // Point
                                         double screenDist,
                                         double screenWidth,
                                         double screenHeight){
        // Define the Ratio
        double Rx = screenWidth / Nx;
        double Ry = screenHeight / Ny;

        // The viewPlan center point
        Point3D Pc = _P0.add(_vTo.scale(screenDist));

        // the current pixel on the viewPlane
        Point3D pixel = Pc.add(_vRight.scale((x-Nx/2)*Rx )).subtract(_vUp.scale((y-Ny/2)*Ry));
                                                                                                                                                                                                //Point3D pixel = Pc.add(_vRight.scale((x-Nx/2)*Rx + Rx/2)).subtract(_vUp.scale((y-Ny/2)*Ry + Ry/2)); //this is the original formula
        if (Nx % 2 == 0)
            pixel = pixel.add(new Vector(Rx/2,0,0));
        if (Ny % 2 == 0)
            pixel = pixel.add(new Vector(0,-Ry/2,0));
        return new Ray(pixel, pixel.subtract(_P0).normalize());
    }
}

