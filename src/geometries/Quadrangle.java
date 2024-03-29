package geometries;

import primitives.*;

import java.util.ArrayList;
import java.util.List;

public class Quadrangle extends Geometry implements FlatGeometry{
    /*2 triangles to form a square*/
    private Triangle _tri1;
    private Triangle _tri2;

    // ***************** Constructors ********************** //
    /*************************************************
     * FUNCTION
     * Quadrangle
     * PARAMETERS
     * 4 Point3D - Four vertices of a quadrangle.
     * MEANING
     * Initializing fields.
     **************************************************/
    public Quadrangle(Point3D p1, Point3D p2, Point3D p3, Point3D p4) {
        _tri1 = new Triangle(p1, p2, p4);
        _tri2 = new Triangle(p2, p3, p4);
        if (_tri1.getNormal(null, null).crossProduct((_tri2.getNormal(null, null))).length() != 0)
            throw new ExceptionInInitializerError("The four points are not on the same plane");
    }

    /*************************************************
     * FUNCTION
     * Quadrangle
     * PARAMETERS
     * Quadrangle
     * MEANING
     * copy Constructor
     **************************************************/
    public Quadrangle(Quadrangle quadrangle) {
        this._tri1 = new Triangle((quadrangle._tri1));
        this._tri2 = new Triangle((quadrangle._tri2));
    }

    // ***************** Getters/Setters ********************** //
    public Triangle get_tri1() {
        return new Triangle(_tri1);
    }

    public Triangle get_tri2() {
        return new Triangle(_tri2);
    }

// ***************** Operations ******************** //
    /*************************************************
     * FUNCTION
     * getNormal
     * PARAMETERS
     * Point3D - point on the Quadrangle.
     * Vector - direction of ray to the point.
     * RETURN VALUE
     * Vector - is the normal.
     * MEANING
     * Return the normal to Quadrangle at the point toward the vector.
     **************************************************/
    public Vector getNormal(Point3D point_NoUse, Vector direction){
        return _tri2.getNormal(point_NoUse, direction);
    }

    /*************************************************
     * FUNCTION
     * FindIntersections
     * PARAMETERS
     * Ray - A ray from the view plane.
     * RETURN VALUE
     * List<Point3D> - The intersection points.
     * MEANING
     * Finding intersection points with the Quadrangle.
     **************************************************/
    public List<Point3D> FindIntersections(Ray ray) {
        List<Point3D> newList = new ArrayList<Point3D>(_tri1.FindIntersections(ray));//intersection points with the _tri1 Triangle.
        newList.addAll(_tri2.FindIntersections(ray));//intersection points with the _tri2 Triangle.
        return newList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Quadrangle)) return false;
        Quadrangle that = (Quadrangle) o;
        return get_tri1().equals(that.get_tri1()) &&
                get_tri2().equals(that.get_tri2());
    }

}

