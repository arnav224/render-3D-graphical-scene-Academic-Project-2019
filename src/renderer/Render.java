package renderer;
        import java.awt.Color;
        import java.util.*;
        import java.util.function.Function;
        import java.util.function.IntFunction;
/*import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;*/
        import elements.LightSource;
        import geometries.FlatGeometry;
        import geometries.Geometry;
        import primitives.Point3D;
        import primitives.Ray;
        import primitives.Vector;
        import scene.Scene;

        import static sun.nio.ch.IOStatus.normalize;

public class Render
{
    private Scene _scene;
    private ImageWriter _imageWriter;
    private final int RECURSION_LEVEL = 3;
    // ***************** Constructors ********************** //
    public Render(ImageWriter imageWriter, Scene scene){
        set_imageWriter(imageWriter);
        set_scene(scene);
    }
    // ***************** Getters/Setters ********************** //

    public Scene get_scene() {
        return new Scene(_scene);
    }

    public void set_scene(Scene _scene) {
        this._scene = new Scene(_scene);
    }

    public ImageWriter get_imageWriter() {
        return new ImageWriter(_imageWriter);
    }

    public void set_imageWriter(ImageWriter _imageWriter) {
        this._imageWriter = new ImageWriter(_imageWriter);
    }

    public int getRECURSION_LEVEL() {
        return RECURSION_LEVEL;
    }

    // ***************** Operations ******************** //
    // Based on the 4-5 Recitations presentation of Elishai//

    public void renderImage(){
        for (int i = 0; i < _imageWriter.getHeight(); i++){
            for (int j = 0; j < _imageWriter.getWidth(); j++){
                Ray ray = _scene.getCamera().constructRayThroughPixel(_imageWriter.getNx(),
                        _imageWriter.getNy(), i, j,_scene.getScreenDistance(), _imageWriter.getWidth(),
                        _imageWriter.getHeight());
                Map<Geometry, List<Point3D>> intersectionPoints = getSceneRayIntersections(ray);
                if (intersectionPoints.isEmpty())
                    _imageWriter.writePixel(i, j, _scene.getBackground());
                else{
                    Map.Entry<Geometry, List<Point3D>> closestPoint = getClosestPoint(intersectionPoints);
                    _imageWriter.writePixel(i, j, calcColor(closestPoint.getKey(), closestPoint.getValue().get(0)));
                }
            }
        }
    }

    //private Entry<Geometry, Point3D> findClosesntIntersection(Ray ray);
    public void printGrid(int interval){
        for (int i = 0; i < _imageWriter.getHeight(); i++){
            for (int j = 0; j < _imageWriter.getWidth(); j++) {
                if (i == 0 || j == 0 || (i+1) % interval == 0 || (j+1) % interval == 0)
                    _imageWriter.writePixel(i, j, new Color(255,255,255));
            }
        }


    }
    public void writeToImage(){
        this._imageWriter.writeToimage();
    }

    //private Color calcColor(Geometry geometry, Point3D point, Ray ray);
    //private Color calcColor(Geometry geometry, Point3D point, Ray inRay, int level); // Recursive

    private Color calcColor(Geometry geometry, Point3D point) {
        Color intensity = _scene.getAmbientLight().getIntensity();
        Color color = geometry.get_emmission();
        IntFunction<Integer> MyNormalize = x -> x > 255 ? 255 : x;
        return new Color(MyNormalize.apply(color.getRed() + intensity.getRed()),
                MyNormalize.apply(color.getGreen() + intensity.getGreen()),
                MyNormalize.apply(color.getBlue() + intensity.getBlue())) ;
    }


    //private Ray constructRefractedRay(Geometry geometry, Point3D point, Ray inRay);
    //private Ray constructReflectedRay(Vector normal, Point3D point, Ray inRay);
    //private boolean occluded(LightSource light, Point3D point, Geometry geometry);
    //private Color calcSpecularComp(double ks, Vector v, Vector normal, Vector l, double shininess, Color lightIntensity);
    //private Color calcDiffusiveComp(double kd, Vector normal, Vector l, Color lightIntensity);
    //private Map<Geometry, Point3D> getClosestPoint(Map<Geometry, List<Point3D>> intersectionPoints);
    private Map.Entry<Geometry, List<Point3D>> getClosestPoint(Map<Geometry, List<Point3D>> intersectionPoints) {
        double distance = Double.MAX_VALUE;
        Point3D P0 = _scene.getCamera().getP0();
        Map.Entry<Geometry, List<Point3D>> minDistancePoint = null;
        for (Map.Entry<Geometry, List<Point3D>> entry: intersectionPoints.entrySet()) {
            for (Point3D point: entry.getValue()) {
                if (P0.distance(point) < distance) {
                    minDistancePoint = entry;
                    distance = P0.distance(point);
                }
            }

        }
        return minDistancePoint;
    }

    private Map<Geometry, List<Point3D>> getSceneRayIntersections(Ray ray){
        Iterator<Geometry> geometries = _scene.getGeometriesIterator();
        Map<Geometry, List<Point3D>> intersectionPoints = new HashMap<Geometry, List<Point3D>>();
        while (geometries.hasNext()){
            Geometry geometry = geometries.next();
            List<Point3D> geometryIntersectionPoints = geometry.FindIntersections(ray);
            if (!geometryIntersectionPoints.isEmpty())
                intersectionPoints.put(geometry, geometryIntersectionPoints);
        }
        return intersectionPoints;
    }

    //private Color addColors(Color a, Color b);

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "scene: " + _scene.toString() + "imageWriter: " + _imageWriter.toString();
    }
}





/*
package renderer;
        import java.awt.Color;
        import java.util.*;
*/
/*import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;*//*

        import elements.LightSource;
        import geometries.FlatGeometry;
        import geometries.Geometry;
        import primitives.Point3D;
        import primitives.Ray;
        import primitives.Vector;
        import scene.Scene;
public class Render
{
    private Scene _scene;
    private ImageWriter _imageWriter;
    private final int RECURSION_LEVEL = 3;
    // ***************** Constructors ********************** //
    public Render(ImageWriter imageWriter, Scene scene){
        set_imageWriter(imageWriter);
        set_scene(scene);
    }
    // ***************** Getters/Setters ********************** //

    public Scene get_scene() {
        return new Scene(_scene);
    }

    public void set_scene(Scene _scene) {
        this._scene = new Scene(_scene);
    }

    public ImageWriter get_imageWriter() {
        return new ImageWriter(_imageWriter);
    }

    public void set_imageWriter(ImageWriter _imageWriter) {
        this._imageWriter = new ImageWriter(_imageWriter);
    }

    public int getRECURSION_LEVEL() {
        return RECURSION_LEVEL;
    }

    // ***************** Operations ******************** //
    // Based on the 4-5 Recitations presentation of Elishai//

    public void renderImage(){
        for (int i = 0; i < _imageWriter.getHeight(); i++){
            for (int j = 0; j < _imageWriter.getWidth(); j++){
                Ray ray = _scene.getCamera().constructRayThroughPixel(_imageWriter.getNx(),
                        _imageWriter.getNy(), i, j,_scene.getScreenDistance(), _imageWriter.getWidth(),
                        _imageWriter.getHeight());
                List<Point3D> intersectionPoints = getSceneRayIntersections(ray);
                if (intersectionPoints.isEmpty())
                    _imageWriter.writePixel(i, j, _scene.getBackground());
                else{
                    Point3D closestPoint = getClosestPoint(intersectionPoints);
                    _imageWriter.writePixel(i, j, calcColor(closestPoint));
                }
            }
        }
    }
    //private Entry<Geometry, Point3D> findClosesntIntersection(Ray ray);
    public void printGrid(int interval){

    }
    //public void writeToImage();
    //private Color calcColor(Geometry geometry, Point3D point, Ray ray);
    //private Color calcColor(Geometry geometry, Point3D point, Ray inRay, int level); // Recursive

    private Color calcColor(Point3D point) {
        return _scene.getAmbientLight().getIntensity();
    }
    //private Ray constructRefractedRay(Geometry geometry, Point3D point, Ray inRay);
    //private Ray constructReflectedRay(Vector normal, Point3D point, Ray inRay);
    //private boolean occluded(LightSource light, Point3D point, Geometry geometry);
    //private Color calcSpecularComp(double ks, Vector v, Vector normal, Vector l, double shininess, Color lightIntensity);
    //private Color calcDiffusiveComp(double kd, Vector normal, Vector l, Color lightIntensity);
    //private Map<Geometry, Point3D> getClosestPoint(Map<Geometry, List<Point3D>> intersectionPoints);
    private Point3D getClosestPoint(List<Point3D> intersectionPoints) {
        double distance = Double.MAX_VALUE;
        Point3D P0 = _scene.getCamera().getP0();
        Point3D minDistancePoint = null;
        for (Point3D point: intersectionPoints) {
            if (P0.distance(point) < distance) {
                minDistancePoint = new Point3D(point);
                distance = P0.distance(point);
            }
        }
        return minDistancePoint;
    }

    private List<Point3D> getSceneRayIntersections(Ray ray){
        Iterator<Geometry> geometries = _scene.getGeometriesIterator();
        List<Point3D> intersectionPoints = new ArrayList<Point3D>();
        while (geometries.hasNext()){
            Geometry geometry = geometries.next();
            List<Point3D> geometryIntersectionPoints = geometry.FindIntersections(ray);
            intersectionPoints.addAll(geometryIntersectionPoints);
        }
        return intersectionPoints;
    }

    //private Color addColors(Color a, Color b);

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "scene: " + _scene.toString() + "imageWriter: " + _imageWriter.toString();
    }
}
*/

