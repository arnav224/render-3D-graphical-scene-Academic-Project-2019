package renderer;

import geometries.*;
import org.junit.jupiter.api.Test;
import primitives.*;
import scene.*;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class RenderTest {
    @Test
    public void emmissionTest()
    {
        Scene scene = new Scene();
        scene.setScreenDistance(50);

        Sphere sphere = new Sphere(50, new Point3D(0.0, 0.0, -50));
        Triangle triangle1 = new Triangle(new Point3D( 150, 0, -50),
                new Point3D(  0, 150, -50),
                new Point3D( 150, 150, -50));

        Triangle triangle2 = new Triangle(new Point3D( 150, 0, -50),
                new Point3D(  0, -150, -50),
                new Point3D( 150,-150, -50));

        Triangle triangle3 = new Triangle(new Point3D(-150, 0, -50),
                new Point3D(  0, 150, -50),
                new Point3D(-150, 150, -50));

        Triangle triangle4 = new Triangle(new Point3D(-150, 0, -50),
                new Point3D(  0,  -150, -50),
                new Point3D(-150, -150, -50));

        sphere.setEmmission(new Color(92, 143, 255));
        triangle1.setEmmission(new Color (64, 59, 255));
        triangle2.setEmmission(new Color (67, 255, 41));
        triangle3.setEmmission(new Color (255, 173, 102));
        triangle4.setEmmission(new Color (255, 48, 124));

        scene.addGeometry(sphere);
        scene.addGeometry(triangle1);
        scene.addGeometry(triangle2);
        scene.addGeometry(triangle3);
        scene.addGeometry(triangle4);

        ImageWriter imageWriter = new ImageWriter("Emmission test", 500, 500, 500, 500);

        Render render = new Render(imageWriter, scene);

        render.renderImage();
        render.printGrid(50);
        render.writeToImage();
    }

    @Test
    void get_scene() {
    }

    @Test
    void set_scene() {
    }

    @Test
    void get_imageWriter() {
    }

    @Test
    void set_imageWriter() {
    }

    @Test
    void getRECURSION_LEVEL() {
    }

    @Test
    void renderImage() {
    }

    @Test
    void printGrid() {
    }
}