package geometries;

import primitives.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Quadrangle extends Geometry {
    private Triangle _tri1;
    private Triangle _tri2;

    public Quadrangle(Point3D p1, Point3D p2, Point3D p3, Point3D p4) {
        _tri1 = new Triangle(p1, p2, p4);
        _tri2 = new Triangle(p2, p3, p4);
        if (_tri1.getNormal(null).crossProduct((_tri2.getNormal(null))).length() != 0)
            throw new ExceptionInInitializerError("The four points are not on the same plane");
    }


    public Quadrangle(Quadrangle quadrangle) {
        this._tri1 = new Triangle((quadrangle._tri1));
        this._tri2 = new Triangle((quadrangle._tri2));
    }

    public Triangle get_tri1() {
        return new Triangle(_tri1);
    }

    public Triangle get_tri2() {
        return new Triangle(_tri2);
    }

    public Vector getNormal(Point3D point_NoUse){
        return _tri1.getNormal(point_NoUse);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Quadrangle)) return false;
        Quadrangle that = (Quadrangle) o;
        return get_tri1().equals(that.get_tri1()) &&
                get_tri2().equals(that.get_tri2());
    }

    @Override
    public int hashCode() {
        return Objects.hash(get_tri1(), get_tri2());
    }

    public List<Point3D> FindIntersections(Ray ray) {
        List<Point3D> newList = new ArrayList<Point3D>(_tri1.FindIntersections(ray));
        newList.addAll(_tri2.FindIntersections(ray));
        return newList;
    }

    }

