package scene;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
//import java.util.*;
import elements.*;
import geometries.Geometry;
import primitives.Point3D;
import primitives.Vector;

public class Scene {
    private Color _background;
    private AmbientLight _ambientLight; // ambient Light
    private List<Geometry> _geometries = new ArrayList<Geometry>(); // a list of geometries
    private Camera _camera;
    private double _screenDistance; // The camera distance from the screen.
    private List<LightSource> _lights = new ArrayList<LightSource>(); // lights
    private String _sceneName = "scene"; // scene Name

    // ***************** Constructors ********************** //
    /*************************************************
     * FUNCTION
     * Scene
     * MEANING
     * default Constructor
     **************************************************/
    public Scene(){
        this._background = new Color(0,0,0);
        this._screenDistance = 100;
        this._ambientLight = new AmbientLight();
        setCamera(new Camera());
    }
    /*************************************************
     * FUNCTION
     * Scene
     * PARAMETERS
     * Scene
     * MEANING
     * copy Constructor
     **************************************************/
    public Scene(Scene scene){
        this._background = scene.getBackground();
        this._ambientLight = scene.getAmbientLight();
        this._geometries = scene._geometries;
        this._camera = scene.getCamera();
        this._screenDistance = scene._screenDistance;
        this._lights = scene._lights;
        this._sceneName = scene._sceneName;
    }
    /*************************************************
     * FUNCTION
     * Scene
     * PARAMETERS
     * AmbientLight, Color, Camera,
     * double - screenDistance
     * MEANING
     * Initializing fields.
     **************************************************/
    public Scene(AmbientLight aLight, Color background, Camera camera, double screenDistance){
        setAmbientLight(aLight);
        setBackground(background);
        setCamera(camera);
        setScreenDistance(screenDistance);
        this._geometries = new ArrayList<Geometry>();
        /*todo:
        חסר איתחול לרשימת האורות
         */
    }
    // ***************** Getters/Setters ********************** //
    public Color getBackground(){
        return new Color(this._background.getRGB());
    }

    public AmbientLight getAmbientLight(){
        return new AmbientLight(this._ambientLight);
    }

    public Camera getCamera(){
        return new Camera(this._camera);
    }

    public String getSceneName(){
        return this._sceneName;
    }

    public double getScreenDistance(){
        return _screenDistance;
    }

    public void setBackground(Color _background){
        this._background = new Color(_background.getRGB());
    }

    public void setAmbientLight(AmbientLight ambientLight){
        this._ambientLight = new AmbientLight(ambientLight);
    }

    public void setCamera(Camera camera){
        this._camera = new Camera(camera);
    }

    public void setSceneName(String sceneName){
        this._sceneName = sceneName;
    }

    public void setScreenDistance(double screenDistance){
        this._screenDistance = screenDistance;
    }

    // ***************** Operations ******************** //
    /*************************************************
     * FUNCTION
     * addGeometry
     * PARAMETERS
     * Geometry
     * MEANING
     * add Geometry to the geometries' list.
     **************************************************/
    public void addGeometry(Geometry geometry){
        this._geometries.add(geometry);
    }
    /*************************************************
     * FUNCTION
     * getGeometriesIterator
     * RETURN VALUE
     * Iterator<Geometry>
     * MEANING
     * return iterator of geometries' list.
     **************************************************/
    public Iterator<Geometry> getGeometriesIterator(){
        return this._geometries.iterator();
    }

    public void addLight(LightSource light){this._lights.add(light);}

    public void addVolumeLight(LightSource light, double radios, int NumOfLights){
        if (light instanceof SpotLight){
            SpotLight spotLight = (SpotLight)light;
            Point3D originalPosition = spotLight.get_position();
            for (int i = 0; i < NumOfLights; i ++) {
                Point3D position;
                do {
                    double xRandom = originalPosition.getX().getCoordinate() + (Math.random() * 2 - 1) * radios;
                    double yRandom = originalPosition.getY().getCoordinate() + (Math.random() * 2 - 1) * radios;
                    double zRandom = originalPosition.getZ().getCoordinate() + (Math.random() * 2 - 1) * radios;
                    position = new Point3D(xRandom,yRandom,zRandom);
                } while (position.distance(originalPosition) > radios);

                addLight(new SpotLight(new Color(spotLight.getColor().getRGB()), position,
                        spotLight.get_direction(), spotLight.get_Kc(), spotLight.get_Kl(), spotLight.get_Kq()));
            }
        }
        else if (light instanceof PointLight){
            PointLight pointLight = (PointLight)light;
            Point3D originalPosition = pointLight.get_position();
            for (int i = 0; i < NumOfLights; i ++){
                Point3D position;
                do {
                    double xRandom = originalPosition.getX().getCoordinate() + (Math.random() * 2 - 1) * radios;
                    double yRandom = originalPosition.getY().getCoordinate() + (Math.random() * 2 - 1) * radios;
                    double zRandom = originalPosition.getZ().getCoordinate() + (Math.random() * 2 - 1) * radios;
                    position = new Point3D(xRandom,yRandom,zRandom);
                } while (position.distance(originalPosition) > radios);

                addLight(new PointLight(new Color(pointLight.getColor().getRGB()), position,
                                        pointLight.get_Kc(), pointLight.get_Kl(), pointLight.get_Kq()));
            }
        }
        else
            this._lights.add(light);
    }

    public Iterator<LightSource> getLightsIterator() { return this._lights.iterator(); }

    /*************************************************
     * FUNCTION
     * toString
     **************************************************/
    @Override
    public String toString() {
        return "Scene{" +
                ", _sceneName='" + _sceneName + '\'' +
                "_background=" + _background +
                ", _ambientLight=" + _ambientLight +
                ", _geometries=" + _geometries +
                ", _camera=" + _camera +
                ", _screenDistance=" + _screenDistance +
                ", _lights=" + _lights +
                '}';
    }
    /*************************************************
     * FUNCTION
     * equals
     **************************************************/
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Scene)) return false;
        Scene scene = (Scene) o;
        return Double.compare(scene._screenDistance, _screenDistance) == 0 &&
                Objects.equals(_background, scene._background) &&
                Objects.equals(_ambientLight, scene._ambientLight) &&
                Objects.equals(_geometries, scene._geometries) &&
                Objects.equals(_camera, scene._camera) &&
                Objects.equals(_lights, scene._lights) &&
                Objects.equals(_sceneName, scene._sceneName);
    }

    @Override
    public int hashCode() {
        return 0;
    }


}