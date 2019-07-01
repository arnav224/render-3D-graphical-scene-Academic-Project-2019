package geometries;
import primitives.*;


import java.util.ArrayList;
import java.util.List;

public class Cylinder extends RadialGeometry {
    private Point3D _axisPoint;
    private Vector axisDirection;
    // ***************** Constructors ********************** //
    public Cylinder(){
        this._axisPoint  =  new Point3D();
        this.axisDirection  =  new Vector();
        this._radius  =  0.0;
    }
    public Cylinder(Cylinder cylinder){
        this._axisPoint  =  new Point3D(cylinder._axisPoint);
        this.axisDirection  =  new Vector(cylinder.axisDirection);
        this._radius  =  cylinder._radius;
    }

    public Cylinder(double radius, Point3D axisPoint, Vector axisDirection) {
        super(radius);
        this._axisPoint  =  new Point3D(axisPoint);
        this.axisDirection  =  new Vector(axisDirection);
    }

    // ***************** Getters/Setters ********************** //

    public Point3D getAxisPoint() {
        return new Point3D(_axisPoint);
    }

    public void setAxisPoint(Point3D _axisPoint) {
        this._axisPoint  =  _axisPoint;
    }

    public Vector getAxisDirection() {
        return new Vector(axisDirection);
    }

    public void setAxisDirection(Vector axisDirection) {
        this.axisDirection  =  axisDirection;
    }

    // ***************** Operations ******************** //
    //todo


    /*************************************************
     * FUNCTION
     * FindIntersections
     * PARAMETERS
     * Ray
     * RETURN VALUE
     * List<Point3D>
     * MEANING
     * An function for finding intersections with Cylinder.
     *************************************************
     * @param ray*/

    @Override
    public List<Point3D> FindIntersections(Ray ray) {
        ArrayList<Point3D> list  =  new ArrayList<>();
        
        //v1
        double scalarProduct = ray.getDirection().dotProduct(axisDirection);
        Vector vc = new Vector(axisDirection).scale(scalarProduct);
        Vector V1 = new Vector(ray.getDirection()).subtract(vc);

        //v2 
        Vector pc = new Vector(_axisPoint);
        Vector V2 = new Vector(ray.getPOO()).subtract(pc);
        scalarProduct = V2.dotProduct(axisDirection);
        Vector temp = new Vector(axisDirection).scale(scalarProduct);
        V2 = V2.subtract(temp);

        double A = V1.dotProduct(V1);

        double B = 2*V1.dotProduct(V2);

        double C = V2.dotProduct(V2) - _radius*_radius;

        double delta = B*B-4*A*C;
        //if there no intersections
        if(delta<0)return list;

            //there is one intersection
        else if(delta == 0)
        {
            Vector amount = new Vector(ray.getDirection()).scale(-B);
            Vector point = new Vector(ray.getPOO()).add(amount);
            list.add(point.getHead());
            return list;
        }

        //there are 2 intersecftions
        double t1 = -B+Math.sqrt(B*B-4*A*C)/2*A;

        double t2 = -B-Math.sqrt(B*B-4*A*C)/2*A;


        Vector amount = new Vector(ray.getDirection()).scale(t1);
        Vector point = new Vector(ray.getPOO()).add(amount);
        list.add(point.getHead());

        Vector amount2 = new Vector(ray.getDirection()).scale(t2);
        Vector point2 = new Vector(ray.getPOO()).add(amount2);
        list.add(point2.getHead());

        return list;

    }
    /*************************************************
     * FUNCTION
     * getNormal
     * PARAMETERS
     * Point3D
     * Vector - direction of ray to the point.
     * RETURN VALUE
     * Vector
     * MEANING
     * An function for finding the Normal from Cylinder toward the vector.
     **************************************************/
    //todo
    @Override
    public Vector getNormal(Point3D point, Vector direction){
        double a=point.getX().getCoordinate();
        double b=point.getY().getCoordinate();
        double c=point.getZ().getCoordinate();
        double x=axisDirection.getHead().getX().getCoordinate();
        double y=axisDirection.getHead().getY().getCoordinate();
        double z=axisDirection.getHead().getZ().getCoordinate();
        double t=(a*x+b*y+c*z)/(x*x+y*y+z*z);
        Vector temp=new Vector(axisDirection).scale(t);
        Vector normal=new Vector(point).subtract(temp).normalize();

        if (direction != null && direction.dotProduct(normal) > 0)
            return normal.scale(-1);
        else
            return normal;
    }
}
