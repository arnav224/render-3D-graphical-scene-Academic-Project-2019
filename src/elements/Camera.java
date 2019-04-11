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
        _vRight = _vTo.crossProduct(_vUp).normalize();
    }

    public Camera (Camera camera)
    {
        _P0 = camera.getP0();
        _vUp = camera.get_vUp();
        _vTo = camera.get_vTo();
        _vRight = camera.get_vRight();
    }

    public Camera (Point3D P0, Vector vUp, Vector vTo){
        _P0 = new Point3D(P0);
        _vUp = new Vector(vUp);
        _vTo = new Vector(vTo);
        _vRight = _vTo.crossProduct(_vUp).normalize();
    }
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
    public String toString()
    {
        return "Vto: " + _vTo + "\n" + "Vup: " + _vUp + "\n" + "Vright:" + _vRight + ".";
    }
    // ***************** Operations ******************** //
    public Ray constructRayThroughPixel (int Nx, int Ny,
                                         double x, double y,
                                         double screenDist,
                                         double screenWidth,
                                         double screenHeight){
/*todo
* במימוש הפונקציה יש לתת את הדעת:
 לטווח האורכים של מספר פיקסל האם מתחיל מ – - 0 או מ- 1? הרי ראינו שיש שתי נוסחאות קצת
שונות בהתאם לערך מינימלי של מספר פיקסל.
 לעובדה שניסיון ליצור ווקטור אפס גורם חריגה ועליכם להתאים את הקוד למקרה שמדובר בכמות
פיקסלים אי זוגית ובניית קרן דרך פיקסלים ש x ו/או y שלהם שוה ל- 0 . הפתרון איננו תפיסת חריגה
אלא פתרון תכנותי
* */
        Point3D Pc = _P0.add(_vTo.scale(screenDist));
        double Rx = screenWidth / Nx;
        double Ry = screenWidth / Ny;
        Point3D pixel = Pc.add(_vRight.scale((x-Nx/2)*Rx + Rx/2)).subtract(_vUp.scale((y-Ny/2)*Ry + Ry/2));
        return new Ray(getP0(), pixel.subtract(_P0).normalize());
    }
}

