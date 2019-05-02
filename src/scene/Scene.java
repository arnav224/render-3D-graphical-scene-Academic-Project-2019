package scene;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import elements.AmbientLight;
import elements.Camera;
import elements.LightSource;
import geometries.Geometry;
public class Scene {
    private Color _background;
    private AmbientLight _ambientLight;
    private List<Geometry> _geometries = new ArrayList<Geometry>();
    private Camera _camera;
    private double _screenDistance;
    private List<LightSource> _lights = new ArrayList<LightSource>();
    private String _sceneName = "scene";

    // ***************** Constructors ********************** //
    /*************************************************
     * FUNCTION
     *
     * PARAMETERS
     *
     * RETURN VALUE
     *
     * MEANING
     *
     * SEE ALSO
     *
     **************************************************/
    public Scene(){
        this._background = new Color(0,0,0);
        this._screenDistance = 100;
        this._ambientLight = new AmbientLight();
        setCamera(new Camera());
    }
    /*************************************************
     * FUNCTION
     *
     * PARAMETERS
     *
     * RETURN VALUE
     *
     * MEANING
     *
     * SEE ALSO
     *
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
     *
     * PARAMETERS
     *
     * RETURN VALUE
     *
     * MEANING
     *
     * SEE ALSO
     *
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
     *
     * PARAMETERS
     *
     * RETURN VALUE
     *
     * MEANING
     *
     * SEE ALSO
     *
     **************************************************/
    public void addGeometry(Geometry geometry){
        this._geometries.add(geometry);
    }
    /*************************************************
     * FUNCTION
     *
     * PARAMETERS
     *
     * RETURN VALUE
     *
     * MEANING
     *
     * SEE ALSO
     *
     **************************************************/
    public Iterator<Geometry> getGeometriesIterator(){
        return this._geometries.iterator();
    }

    //public void addLight(LightSource light);

    //public Iterator<LightSource> getLightsIterator();

    /*************************************************
     * FUNCTION
     *
     * PARAMETERS
     *
     * RETURN VALUE
     *
     * MEANING
     *
     * SEE ALSO
     *
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
     *
     * PARAMETERS
     *
     * RETURN VALUE
     *
     * MEANING
     *
     * SEE ALSO
     *
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