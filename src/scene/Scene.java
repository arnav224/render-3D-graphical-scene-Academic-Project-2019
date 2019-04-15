package scene;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
    public Scene(){
        this._background = new Color(0,0,0);
        this._screenDistance = 100;
        this._ambientLight = new AmbientLight();
        setCamera(new Camera());
    }

    public Scene(Scene scene){
        this._background = scene.getBackground();
        this._ambientLight = scene.getAmbientLight();
        this._geometries = scene._geometries;
        this._camera = scene.getCamera();
        this._screenDistance = scene._screenDistance;
        this._lights = scene._lights;
        this._sceneName = scene._sceneName;
    }

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
    public void addGeometry(Geometry geometry){
        this._geometries.add(geometry);
    }

    public Iterator<Geometry> getGeometriesIterator(){
        return this._geometries.iterator();
    }

    //public void addLight(LightSource light);

    //public Iterator<LightSource> getLightsIterator();

    @Override
    public String toString() {
        return this._sceneName;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}