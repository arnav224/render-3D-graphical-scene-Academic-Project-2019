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
        import geometries.*;
        import primitives.*;
        import primitives.Vector;
        import scene.Scene;

        import static javafx.scene.input.KeyCode.R;
        import static sun.nio.ch.IOStatus.normalize;

public class Render
{
    IntFunction<Integer> MyNormalize = x -> x > 255 ? 255 : x; // Lambda to normalize the color.

    private Scene _scene; // An object that describes the scene.
    private ImageWriter _imageWriter; // Object to write the image.
    private final int RECURSION_LEVEL = 3;
    // ***************** Constructors ********************** //
    /*************************************************
     * FUNCTION
     * Render
     * PARAMETERS
     * ImageWriter, Scene.
     * MEANING
     * Initializing fields.
     **************************************************/
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

    /*************************************************
     * FUNCTION
     * renderImage
     * MEANING
     * This function operates the rendering of the image. Calculates each pixel in the image.
     **************************************************/
    public void renderImage(){
        for (int i = 0; i < _imageWriter.getHeight(); i++){
            for (int j = 0; j < _imageWriter.getWidth(); j++){

                /* Receiving the ray that crosses the pixel */
                Ray ray = _scene.getCamera().constructRayThroughPixel(_imageWriter.getNx(),
                        _imageWriter.getNy(), i, j,_scene.getScreenDistance(), _imageWriter.getWidth(),
                        _imageWriter.getHeight());

                // Receiving intersection points
                Map<Geometry, List<Point3D>> intersectionPoints = getSceneRayIntersections(ray);

                if (intersectionPoints.isEmpty())
                    _imageWriter.writePixel(i, j, _scene.getBackground()); // Write the pixel with a background color.
                else{
                    /* Find a closest Point and write the pixel. */
                    Map.Entry<Geometry, List<Point3D>> closestPoint = getClosestPoint(intersectionPoints);
                    if (closestPoint != null)
                        _imageWriter.writePixel(i, j, calcColor(closestPoint.getKey(), closestPoint.getValue().get(0), ray));
                }
            }
        }
    }

    //private Entry<Geometry, Point3D> findClosesntIntersection(Ray ray);

    /*************************************************
     * FUNCTION
     * printGrid
     * PARAMETERS
     * int - interval.
     * MEANING
     * Print a grid.
     **************************************************/
    public void printGrid(int interval){
        for (int i = 0; i < _imageWriter.getHeight(); i++){
            for (int j = 0; j < _imageWriter.getWidth(); j++) {
                if (i == 0 || j == 0 || (i+1) % interval == 0 || (j+1) % interval == 0)
                    _imageWriter.writePixel(i, j, new Color(255,255,255));
            }
        }


    }
    /*************************************************
     * FUNCTION
     * writeToImage
     * MEANING
     * Write the image to a file.
     * SEE ALSO
     * writeToimage in ImageWriter class.
     **************************************************/
    public void writeToImage(){
        this._imageWriter.writeToimage();
    }

    //private Color calcColor(Geometry geometry, Point3D point, Ray ray);
    //private Color calcColor(Geometry geometry, Point3D point, Ray inRay, int level); // Recursive
    /*************************************************
     * FUNCTION
     * calcColor
     * PARAMETERS
     * Geometry, Point3D.
     * RETURN VALUE
     * Color - the color of the point.
     * MEANING
     * Calculates the point's color.
     **************************************************/
    private Color calcColor(Geometry geometry, Point3D point) {
        Color ambientLight = _scene.getAmbientLight().getIntensity(point);
        Color emissionLight = geometry.get_emmission();
        //IntFunction<Integer> MyNormalize = x -> x > 255 ? 255 : x; // Lambda to normalize the color.
        Iterator<LightSource> lights = _scene.getLightsIterator();
        Color diffuseLight = new Color(0,0,0);
        Color specularLight = new Color(0,0,0);
        while (lights.hasNext()) {
            LightSource lightSource = lights.next();

            if ( !occluded(lightSource, point, geometry)) {
                diffuseLight = addColors(calcDiffusiveComp(geometry.getMaterial().getKd(),
                        geometry.getNormal(point),
                        lightSource.getL(point),
                        lightSource.getIntensity(point)), diffuseLight);
                specularLight = addColors(calcSpecularComp(geometry.getMaterial().getKs(),
                        new Vector(point, _scene.getCamera().getP0()),
                        geometry.getNormal(point),
                        lightSource.getL(point),
                        geometry.getMaterial().getShininess(),
                        lightSource.getIntensity(point)), specularLight);

            }
        }

        /* Connect all colors */
        return addColors(addColors(ambientLight, emissionLight), addColors(diffuseLight, specularLight)) ;
    }


    //private Ray constructRefractedRay(Geometry geometry, Point3D point, Ray inRay);
    //private Ray constructReflectedRay(Vector normal, Point3D point, Ray inRay);
    //private boolean occluded(LightSource light, Point3D point, Geometry geometry);
    private Color calcSpecularComp(double ks, Vector v, Vector normal, Vector l, int shininess, Color lightIntensity){
        //Vector r = new Vector(normal);
//        r = r.scale(-2*normal.dotProduct(l));
//        r = r.add(l);
//        r = r.normalize();
//        v = v.normalize();
//        double specular = ks*Math.pow(r.dotProduct(v),shininess);
//        if(specular < 0)
//        {specular *= -1;}
//        return new Color((int)(lightIntensity.getRed()* specular)%256 ,
//                (int)(lightIntensity.getGreen()*specular)%256,
//                (int)(lightIntensity.getBlue()*specular)%256);
        v = v.normalize();
        l = l.normalize();
        Vector R = (l.subtract(normal.scale(l.dotProduct(normal) * 2))).normalize();
        double k = (ks * Math.pow(R.dotProduct(v),shininess));
        if(k < 0)
            k *= -1;
        return new Color(MyNormalize.apply((int)(k * lightIntensity.getRed())),
                MyNormalize.apply((int)(k * lightIntensity.getGreen())),
                MyNormalize.apply((int)(k * lightIntensity.getBlue())));

//        return new Color(k * lightIntensity.getRed()%256, k* lightIntensity.getBlue()%256, k * lightIntensity.getGreen()%256);


    }
    private Color calcDiffusiveComp(double kd, Vector normal, Vector l, Color lightIntensity){
        //double dif = Math.abs(kd*normal.dotProduct(l));
        double k = Math.abs(kd * normal.dotProduct(l.normalize()));
        //return new Color(0,0,0);
        return new Color(MyNormalize.apply((int)(k * lightIntensity.getRed())),
                MyNormalize.apply((int)(k * lightIntensity.getGreen())),
                MyNormalize.apply((int)(k * lightIntensity.getBlue())));

//        return new Color((k * lightIntensity.getRed())%256, (k* lightIntensity.getBlue())%256, (k * lightIntensity.getGreen())%256);

    }
    //private Map<Geometry, Point3D> getClosestPoint(Map<Geometry, List<Point3D>> intersectionPoints);

    /*************************************************
     * FUNCTION
     * getClosestPoint
     * PARAMETERS
     * Map<Geometry, List<Point3D>> - Pairs of geometries and points along the ray.
     * RETURN VALUE
     * Map.Entry<Geometry, List<Point3D>> - closest point and its Geometry.
     * MEANING
     * Calculates the closest point to the camera.
     **************************************************/
    private Map.Entry<Geometry, List<Point3D>> getClosestPoint(Map<Geometry, List<Point3D>> intersectionPoints) {
        double distance = Double.MAX_VALUE;
        Point3D P0 = _scene.getCamera().getP0(); // camera center.
        Map.Entry<Geometry, List<Point3D>> minDistancePoint = null;
        for (Map.Entry<Geometry, List<Point3D>> entry: intersectionPoints.entrySet()) {
            for (Point3D point: entry.getValue()) {
                if (P0.distance(point) < distance) {
                    minDistancePoint = entry; // We found a closer point.
                    distance = P0.distance(point);
                }
            }

        }
        return minDistancePoint;
    }
    /*************************************************
     * FUNCTION
     * getSceneRayIntersections
     * PARAMETERS
     * Ray
     * RETURN VALUE
     * Map<Geometry, List<Point3D>> - Pairs of geometries and points along the ray.
     * MEANING
     * Find intersection points for each of the geometries in the scene.
     **************************************************/
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

    private Color addColors(Color a, Color b){
        IntFunction<Integer> MyNormalize = x -> x > 255 ? 255 : x; // Lambda to normalize the color.
        return new Color(MyNormalize.apply(a.getRed() + b.getRed()),
                MyNormalize.apply(a.getGreen() + b.getGreen()),
                MyNormalize.apply(a.getBlue() + b.getBlue())) ;
    }

    /*************************************************
     * FUNCTION
     * equals
     **************************************************/
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Render)
            return _scene.equals(((Render) obj)._scene) && _imageWriter.equals(((Render) obj)._imageWriter);
        return false;
    }
    /*************************************************
     * FUNCTION
     * toString
     **************************************************/
    @Override
    public String toString() {
        return "scene: " + _scene.toString() + "imageWriter: " + _imageWriter.toString();
    }


    /*************************************************
     * FUNCTION
     * occluded
     * PARAMETERS
     * LightSource, point3d, Geometry
     * RETURN VALUE
     * boolean
     * MEANING
     * This function check for specific point if thers more then one object how stand in fron of him,
     * and return true only if we have the frontal point
     **************************************************/
    private boolean occluded(LightSource light, Point3D point, Geometry geometry) {
        //1. Connect the point to the light source
        //2. Reverse the vector to point backward to the light source
        Vector lightDirection = light.getL(point).scale(-1);//.scale(-1);

        //3. the point that send the ray back
        //Point3D geometryPoint = new Point3D(point);

        //3.5 Floating point corecction
        //Vector epsVector = new Vector(0.0000001,0.0000001,0.0000001);
//        Vector normal = geometry.getNormal(point);
//        normal.scale(normal.length())




        Vector epsVector = new Vector(geometry.getNormal(point)).scale(0.005);
        Point3D geometryPoint = new Point3D(point).add(epsVector);

        //4. Construct ray from the point back to the light
        Ray lightRay = new Ray(geometryPoint, lightDirection);
        //5. Get all the intersection between the pint and the light source into a mao
        Map <Geometry,List<Point3D>> intersectionPoint = getSceneRayIntersections(lightRay);

        // 5.5 Flat geometry
        if (geometry instanceof FlatGeometry){
            intersectionPoint.remove(geometry);
        }

        //6. If the map is empty - the light goes directly to the point
        //   Otherwise - there's something between them
        return !intersectionPoint.isEmpty();
    }


    private Color calcColor(Geometry geometry, Point3D point, Ray ray) {
        return calcColor(geometry, point, ray, 0);
    }

    private Color calcColor(Geometry geometry, Point3D point, Ray inRay, int level)
    {

        if(RECURSION_LEVEL==level)
            return new Color(0, 0, 0);

        Color AmbientLight = _scene.getAmbientLight().getIntensity(point);
        Color emisionLight = geometry.getEmmission();

        Iterator<LightSource> lights = _scene.getLightsIterator();

        Color diffuseLight = new Color(0, 0, 0);
        Color specularLight = new Color(0, 0, 0);
        Color reflectedLight = new Color(0, 0, 0);//ההשפעה של ההשתקפות שלי
        Color refractedLight = new Color(0, 0, 0);//ההשפעה של השקיפות
        while (lights.hasNext()) {
            LightSource lightSource = lights.next();

            if ( !occluded(lightSource, point, geometry)) {
                diffuseLight = addColors(calcDiffusiveComp(geometry.getMaterial().getKd(),
                        geometry.getNormal(point),
                        lightSource.getL(point),
                        lightSource.getIntensity(point)), diffuseLight);
                specularLight = addColors(calcSpecularComp(geometry.getMaterial().getKs(),
                        new Vector(point, _scene.getCamera().getP0()),
                        geometry.getNormal(point),
                        lightSource.getL(point),
                        geometry.getMaterial().getShininess(),
                        lightSource.getIntensity(point)), specularLight);

            }

        }

        Ray reflectedRay = constructReflectedRay(geometry.getNormal(point), point, inRay);
//    Vector v=new Vector(reflectedRay.getP());
//    v.scale(-1);
//    reflectedRay.setP(v.getHead());
        Map.Entry<Geometry, Point3D> reflecteEntry1 = findClosesntIntersection(reflectedRay);


        if (reflecteEntry1 != null) {
//            Map.Entry<Geometry, Point3D> entry = reflecteEntry1.entrySet().iterator().next();
            Color reflectedColor = calcColor(reflecteEntry1.getKey(),
                    reflecteEntry1.getValue(), reflectedRay,level+1);
            double kr = geometry.getMaterial().getKr();
            int reflectR = (int) (kr * reflectedColor.getRed());
            int reflectG = (int) (kr * reflectedColor.getGreen());
            int reflectB = (int) (kr * reflectedColor.getBlue());
            reflectedLight = new Color(reflectR, reflectG, reflectB);
//      reflectedLight = new Color((int) (kr * reflectedColor.getRGB()));

        }
        Ray refractedRay = constructRefractedRay(geometry, point, inRay);
//    Vector v1=new Vector(refractedRay.getP());
//    v1.scale(-1);
//    refractedRay.setP(v1.getHead());
        Map.Entry<Geometry, Point3D> refracteEntry1 = findClosesntIntersection(refractedRay);

        if (refracteEntry1 != null)
        {
//            Map.Entry<Geometry, Point3D> entry2 = refracteEntry1.entrySet().iterator().next();
            Color refractedColor = calcColor(refracteEntry1.getKey(), refracteEntry1.getValue(), refractedRay,level+1);
            double kt = geometry.getMaterial().getKt();
            int refractR = (int) (kt * refractedColor.getRed());
            int refractG = (int) (kt * refractedColor.getGreen());
            int refractB = (int) (kt * refractedColor.getBlue());
            refractedLight = new Color(refractR, refractG, refractB);
//     refractedLight = new Color((int) (kt * refractedColor.getRGB()));
        }


        Color sofi=addColors(AmbientLight,emisionLight);
        sofi=addColors(sofi,diffuseLight);
        sofi=addColors(sofi,specularLight);
        sofi=addColors(sofi,reflectedLight);
        sofi=addColors(sofi,refractedLight);

        return sofi;
    }
    /*************************************************
     * FUNCTION
     * constructRefractedRay
     * PARAMETERS
     * Geometry, point3d, Ray
     * RETURN VALUE
     * ray
     * MEANING
     * This function calculate the refracted ray towards the next object
     **************************************************/
    private Ray constructRefractedRay(Geometry geometry, Point3D point, Ray inRay){

        Vector normal = geometry.getNormal(point);

        if (geometry instanceof FlatGeometry){
            return new Ray (point.add(normal.scale(-2)), inRay.getDirection());
        } else {
            return new Ray (point.add(normal.scale(-2)), inRay.getDirection());
        }

    }
//    private Map.Entry<Geometry, List<Point3D>> findClosesntIntersection(Ray ray){
//        Map<Geometry, List<Point3D>> intersectionPoints = getSceneRayIntersections(ray);
//
//        if (intersectionPoints.size() == 0)
//            return null;
//
//        Map.Entry<Geometry, List<Point3D>> closestPoint = getClosestPoint(intersectionPoints);
//        //Map.Entry<Geometry, Point3D> entry = closestPoint.entrySet().iterator().next();
//        return closestPoint /*entry*/;
//    }
    private Map.Entry<Geometry, Point3D> findClosesntIntersection(Ray ray){
        Map<Geometry, List<Point3D>> intersectionPoints = getSceneRayIntersections(ray);

        if (intersectionPoints.size() == 0)
            return null;

        Map.Entry<Geometry, List<Point3D>> closestPoint = getClosestPoint(intersectionPoints);
        Point3D point3D = closestPoint.getValue().get(0);
        Map<Geometry, Point3D> map = new HashMap<Geometry, Point3D>();
        map.put(closestPoint.getKey(),closestPoint.getValue().get(0));
        return map.entrySet().iterator().next(); // new Map.Entry<Geometry, Point3D>(closestPoint.getKey(),closestPoint.getValue().get(0)) ;
    }
    /*************************************************
     * FUNCTION
     * constructReflectedRay
     * PARAMETERS
     * Vector, point3d, Ray
     * RETURN VALUE
     * Ray
     * MEANING
     * This function calculate the reflected ray from the surface
     **************************************************/
    private Ray constructReflectedRay(Vector normal, Point3D point, Ray inRay) {
        Vector l = inRay.getDirection().normalize();
        Vector R = new Vector(l).normalize();
        Ray reflectedRay = new Ray(point.add(normal.scale(-2 * l.dotProduct(normal)).add(normal)), R);
        return reflectedRay;
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

