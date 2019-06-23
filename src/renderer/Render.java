package renderer;
        import java.awt.Color;
        import java.util.*;
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

        import static sun.nio.ch.IOStatus.normalize;

public class Render
{
    IntFunction<Integer> MyNormalize = x -> x > 255 ? 255 : x; // Lambda to normalize the color.

    private Scene _scene; // An object that describes the scene.
    private ImageWriter _imageWriter; // Object to write the image.
    private final int RECURSION_LEVEL = 4;//The amount of recursion.
    private double reductionThreshold = 0.01;
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
//        for (int i = 0 ; i < _imageWriter.getWidth(); i++){
//            for (int j = 0; j < _imageWriter.getHeight(); j++){
//                Ray ray=_scene.getCamera().constructRayThroughPixel(_imageWriter.getNx(),
//                        _imageWriter.getNy(),j,i,_scene.getScreenDistance()
//                        ,_imageWriter.getWidth()
//                        ,_imageWriter.getHeight());
//                Map<Geometry, List<Point3D>> intersectionPoints = getSceneRayIntersections(ray);
//                if(intersectionPoints.isEmpty()){
//                    _imageWriter.writePixel(j,i,_scene.getBackground());
//                }
//                else{
//                    Map.Entry<Geometry, List<Point3D>> closestPoint = getClosestPoint(intersectionPoints);
//                    _imageWriter.writePixel(j,i,calcColor(closestPoint.getKey(),closestPoint.getValue().get(0),ray));
//                }
//            }
//        }
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
/*
    private Color calcColor(Geometry geometry, Point3D point) {
        Color ambientLight = _scene.getAmbientLight().getIntensity(point);// Ambient Light in the point.
        Color emissionLight = geometry.get_emmission(); // Emission Light in the point.
        //IntFunction<Integer> MyNormalize = x -> x > 255 ? 255 : x; // Lambda to normalize the color.
        Iterator<LightSource> lights = _scene.getLightsIterator();//Iterator all lights.
        Color diffuseLight = new Color(0,0,0);//Diffuse light initialization.
        Color specularLight = new Color(0,0,0);//Specular light initialization.

        */
/*Calculates the power of all the lights that come to the point.*//*

        while (lights.hasNext()) {
            LightSource lightSource = lights.next();

            if ( !occluded(lightSource, point, geometry)) { // The light is not blocked.
                */
/*Add diffuse light*//*

                diffuseLight = addColors(calcDiffusiveComp(geometry.getMaterial().getKd(),
                        geometry.getNormal(point, ),
                        lightSource.getL(point),
                        lightSource.getIntensity(point)), diffuseLight);
                */
/*Add specular light*//*

                specularLight = addColors(calcSpecularComp(geometry.getMaterial().getKs(),
                        new Vector(point, _scene.getCamera().getP0()),
                        geometry.getNormal(point, ),
                        lightSource.getL(point),
                        geometry.getMaterial().getShininess(),
                        lightSource.getIntensity(point)), specularLight);

            }
        }

        */
/* Connect all colors *//*

        return addColors(addColors(ambientLight, emissionLight), addColors(diffuseLight, specularLight)) ;
    }
*/
    /*************************************************
     * FUNCTION
     * calcColor
     * PARAMETERS
     * Geometry, Point3D, Ray - Ray from the VIEW PLAIN to the Point on the Geometry.
     * RETURN VALUE
     * Color - Color on the point.
     * MEANING
     * This function calculate color for point with his geometry color, by calling the 'calcColor' recursive function.
     **************************************************/
    private Color calcColor(Geometry geometry, Point3D point, Ray ray) {
        return calcColor(geometry, point, ray, 1, 1);
    }
    /*************************************************
     * FUNCTION
     * calcColor
     * PARAMETERS
     * Geometry, Point3D, Ray
     * int - level of recursion.
     * RETURN VALUE
     * Color
     * MEANING
     * This function calculate color for point with his geometry color
     **************************************************/
    private Color calcColor(Geometry geometry, Point3D point, Ray inRay, int level, double cumulativeReduction)
    {
        Vector direction = inRay.getDirection();
        Color AmbientLight = _scene.getAmbientLight().getIntensity(point);// Ambient Light in the point.
        Color emisionLight = geometry.getEmmission();// Emission Light in the point.


        Iterator<LightSource> lights = _scene.getLightsIterator();//Iterator all lights.

        Color diffuseLight = new Color(0, 0, 0);//Diffuse light initialization.
        Color specularLight = new Color(0, 0, 0);//Specular light initialization.

        /*Calculates the power of all the lights that come to the point.*/
        Vector normal = geometry.getNormal(point, direction);
        int sininess = geometry.getMaterial().getShininess();
        while (lights.hasNext()) {
            LightSource lightSource = lights.next();
            if (!occluded(lightSource, point, geometry, direction)) {// The light is not blocked.
                /*Add diffuse light*/
                diffuseLight = addColors(calcDiffusiveComp(geometry.getMaterial().getKd(),
                        normal,
                        lightSource.getL(point),
                        lightSource.getIntensity(point)), diffuseLight);
                /*Add specular light*/
                specularLight = addColors(calcSpecularComp(geometry.getMaterial().getKs(),
                        new Vector(point, _scene.getCamera().getP0()),
                        normal,
                        lightSource.getL(point),
                        sininess,
                        lightSource.getIntensity(point)), specularLight);

            }

        }

        if(RECURSION_LEVEL <= level)// Exit conditions from recursion.
        {
            return addColors(addColors(addColors(AmbientLight,emisionLight),diffuseLight),specularLight);
        }

        Material material = geometry.getMaterial();
        //**// Recursive calls

        Color reflectedLight = new Color(0, 0, 0);//reflectedLight - The effect of reflection.
        Color refractedLight = new Color(0, 0, 0);//refractedLight - The effect of refraction.

        double kr = material.getKr();
        if (cumulativeReduction * kr > this.reductionThreshold){
            // Recursive call for a reflected ray
            Ray reflectedRay = constructReflectedRay(geometry, point, inRay);
            Map.Entry<Geometry, Point3D> reflecteEntry1 = findClosesntIntersection(reflectedRay);
            if (reflecteEntry1 != null) {
                Color reflectedColor = calcColor(reflecteEntry1.getKey(),
                        reflecteEntry1.getValue(), reflectedRay,level+1, cumulativeReduction * kr);
                int reflectR = (int) (kr * reflectedColor.getRed());
                int reflectG = (int) (kr * reflectedColor.getGreen());
                int reflectB = (int) (kr * reflectedColor.getBlue());
                reflectedLight = new Color(reflectR, reflectG, reflectB);

            }
        }

        double kt = material.getKt();
        if (cumulativeReduction * kt > this.reductionThreshold){
            /* Recursive call for a refracted ray*/
            Ray refractedRay = constructRefractedRay(geometry, point, inRay);
            Map.Entry<Geometry, Point3D> refracteEntry1 = findClosesntIntersection(refractedRay);
            if (refracteEntry1 != null)
            {
                Color refractedColor = calcColor(refracteEntry1.getKey(), refracteEntry1.getValue(), refractedRay,level+1, cumulativeReduction * kt);
                int refractR = (int) (kt * refractedColor.getRed());
                int refractG = (int) (kt * refractedColor.getGreen());
                int refractB = (int) (kt * refractedColor.getBlue());
                refractedLight = new Color(refractR, refractG, refractB);
            }
        }
        //**// End of recursive calls

        /* Connect all colors */
        Color finalColor=addColors(AmbientLight,emisionLight);
        finalColor=addColors(finalColor,diffuseLight);
        finalColor=addColors(finalColor,specularLight);
        finalColor=addColors(finalColor,reflectedLight);
        finalColor=addColors(finalColor,refractedLight);

        return finalColor;
    }

    /*************************************************
     * FUNCTION
     * calcDiffusiveComp
     * PARAMETERS
     * double kd, Vector normal, Vector l - light to point vector,
     * Color light Intensity.
     * RETURN VALUE
     * Color
     * MEANING
     * This function calculate the diffusive factor and change the color by it
     **************************************************/
    private Color calcDiffusiveComp(double kd, Vector normal, Vector l, Color lightIntensity){
        /*When normal and l are normalized, normal ・ l is the cosine of the angle between them. The power is K.*/
        double k = Math.abs(kd * normal.dotProduct(l.normalize()));
        return new Color(MyNormalize.apply((int)(k * lightIntensity.getRed())),
                MyNormalize.apply((int)(k * lightIntensity.getGreen())),
                MyNormalize.apply((int)(k * lightIntensity.getBlue())));

//        return new Color((k * lightIntensity.getRed())%256, (k* lightIntensity.getBlue())%256, (k * lightIntensity.getGreen())%256);

    }

    /*************************************************
     * FUNCTION
     * calcSpecularComp
     * PARAMETERS
     * double ks, Vector v, Vector normal,
     * Vector l - light to point vector, double shininess, Color lightIntensity
     * RETURN VALUE
     * Color
     * MEANING
     * This function calculate the specular factor and change the color by it.
     **************************************************/
    private Color calcSpecularComp(double ks, Vector v, Vector normal, Vector l, int shininess, Color lightIntensity){

        v = v.normalize();
        l = l.normalize();
        Vector R = (l.subtract(normal.scale(l.dotProduct(normal) * 2))).normalize();// the reflectance direction.
        double k = (ks * Math.pow(R.dotProduct(v),shininess));//Light is exponentially reduced by K.
        if(k < 0)
            k *= -1;
        return new Color(MyNormalize.apply((int)(k * lightIntensity.getRed())),
                MyNormalize.apply((int)(k * lightIntensity.getGreen())),
                MyNormalize.apply((int)(k * lightIntensity.getBlue())));

//        Vector r = new Vector(normal);
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
//        return new Color(k * lightIntensity.getRed()%256, k* lightIntensity.getBlue()%256, k * lightIntensity.getGreen()%256);


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

    /*************************************************
     * FUNCTION
     * addColors
     * PARAMETERS
     * 2 Color
     * RETURN VALUE
     * Color
     * MEANING
     * this functions get two different colors and add them one to each other
     **************************************************/
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
    private boolean occluded(LightSource light, Point3D point, Geometry geometry, Vector direction) {
        //1. Connect the point to the light source
        //2. Reverse the vector to point backward to the light source
        Vector lightDirection = light.getL(point).scale(-1);//.scale(-1);


        //Point3D geometryPoint = new Point3D(point);

        //Vector epsVector = new Vector(0.0000001,0.0000001,0.0000001);
//        Vector normal = geometry.getNormal(point);
//        normal.scale(normal.length())


        //3. the point that send the ray back
        //3.5 Floating point corecction
        Vector epsVector = new Vector(geometry.getNormal(point, direction)).scale(0.0005);
        Point3D geometryPoint = new Point3D(point).add(epsVector);

        //4. Construct ray from the point back to the light
        Ray lightRay = new Ray(geometryPoint, lightDirection);
        //5. Get all the intersection between the point and the light source into a mao
        Map <Geometry,List<Point3D>> intersectionPoint = getSceneRayIntersections(lightRay);

        // 5.5 Flat geometry
        if (geometry instanceof Quadrangle || geometry instanceof FlatGeometry){
            intersectionPoint.remove(geometry);
        }

        //6. If the map is empty - the light goes directly to the point
        //   Otherwise - there's something between them

        return !intersectionPoint.isEmpty();
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
    private Ray constructReflectedRay(Geometry geometry, Point3D point, Ray inRay){
        Vector normal = geometry.getNormal(point, inRay.getDirection());
        Vector l = inRay.getDirection();
        l = l.normalize();

        normal = normal.scale(-2 * l.dotProduct(normal));
        l = l.add(normal);

        Vector R = new Vector(l);
        R = R.normalize();

        point = point.add(normal);

        Ray reflectedRay = new Ray(point, R);

        return reflectedRay;
    }
    /*************************************************
     * FUNCTION
     * constructRefractedRay
     * PARAMETERS
     * Geometry, Point3D, Ray
     * RETURN VALUE
     * Ray
     * MEANING
     * This function calculate the refracted ray towards the next object
     **************************************************/
    private Ray constructRefractedRay(Geometry geometry, Point3D point, Ray inRay){

        Vector direction = inRay.getDirection();
        Vector normalEpsilon = geometry.getNormal(point, direction).scale(-0.0005);
        if (geometry instanceof FlatGeometry){
            return new Ray (point.add(normalEpsilon), direction);
        } else {
            return new Ray (point.add(normalEpsilon), direction);
        }

    }
    private List<Ray> constructRefractedRays(Geometry geometry, Point3D point, Ray inRay){
        List<Ray> result = new ArrayList<>(5);
        Vector direction = inRay.getDirection();
        Vector normalEpsilon = geometry.getNormal(point, direction).scale(-0.00001);
        if (geometry instanceof FlatGeometry)
            result.add(new Ray (point.add(normalEpsilon), direction));
        else
            result.add(new Ray (point.add(normalEpsilon), direction));

        return result;
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

    /*************************************************
     * FUNCTION
     * findClosesntIntersection
     * PARAMETERS
     * Ray
     * RETURN VALUE
     * Map.Entry<Geometry, Point3D>
     * MEANING
     * The function finds the next intersection with the ray.
     **************************************************/
    private Map.Entry<Geometry, Point3D> findClosesntIntersection(Ray ray){
        Map<Geometry, List<Point3D>> intersectionPoints = getSceneRayIntersections(ray);//Find the intersection points.

        if (intersectionPoints.size() == 0)//No intersection points.
            return null;

        /*The next intersection with the ray.*/
        Map.Entry<Geometry, List<Point3D>> closestPoint = getClosestPoint(intersectionPoints);
        //Point3D point3D = closestPoint.getValue().get(0);
        Map<Geometry, Point3D> map = new HashMap<Geometry, Point3D>();
        map.put(closestPoint.getKey(),closestPoint.getValue().get(0));
        return map.entrySet().iterator().next();
        // new Map.Entry<Geometry, Point3D>(closestPoint.getKey(),closestPoint.getValue().get(0)) ;
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

