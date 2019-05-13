package renderer;

import geometries.*;
import org.junit.jupiter.api.Test;
import primitives.*;
import scene.*;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class RenderTest {
    @Test
    public void emmissionTest() {
        Scene scene = new Scene();
        scene.setScreenDistance(50);

        Sphere sphere = new Sphere(50, new Point3D(0.0, 0.0, -50));
        Triangle triangle1 = new Triangle(new Point3D(100, 0, -50),
                new Point3D(0, 100, -50),
                new Point3D(100, 100, -50));

        Triangle triangle2 = new Triangle(new Point3D(100, 0, -50),
                new Point3D(0, -100, -50),
                new Point3D(100, -100, -50));

        Triangle triangle3 = new Triangle(new Point3D(-100, 0, -50),
                new Point3D(0, 100, -50),
                new Point3D(-100, 100, -50));

        Triangle triangle4 = new Triangle(new Point3D(-100, 0, -50),
                new Point3D(0, -100, -50),
                new Point3D(-100, -100, -50));

        sphere.setEmmission(new Color(255, 50, 40));
        triangle1.setEmmission(new Color(64, 59, 255));
        triangle2.setEmmission(new Color(255, 228, 60));
        triangle3.setEmmission(new Color(255, 121, 40));
        triangle4.setEmmission(new Color(255, 48, 124));

        scene.addGeometry(sphere);
        scene.addGeometry(triangle1);
        scene.addGeometry(triangle2);
        scene.addGeometry(triangle3);
        scene.addGeometry(triangle4);

        ImageWriter imageWriter = new ImageWriter("Emmission test12", 500, 500, 500, 500);

        Render render = new Render(imageWriter, scene);

        render.renderImage();
        render.printGrid(50);
        render.writeToImage();
    }

    @Test
    public void emmissionTest2() {
        Scene scene = new Scene();
        scene.setScreenDistance(50);


        Triangle triangle1 = new Triangle(new Point3D(150, 0, -150),
                new Point3D(0, 150, -70),
                new Point3D(150, 150, -50));

        Triangle triangle2 = new Triangle(new Point3D(150, 0, -150),
                new Point3D(0, -150, -70),
                new Point3D(150, -150, -50));

        Triangle triangle3 = new Triangle(new Point3D(-150, 0, -150),
                new Point3D(0, 150, -70),
                new Point3D(-150, 150, -50));

        Triangle triangle4 = new Triangle(new Point3D(-150, 0, -150),
                new Point3D(0, -150, -70),
                new Point3D(-150, -150, -50));


        triangle1.setEmmission(new Color(38, 26, 255));
        triangle2.setEmmission(new Color(101, 22, 16));
        triangle3.setEmmission(new Color(255, 66, 52));
        triangle4.setEmmission(new Color(6, 91, 34));


        scene.addGeometry(triangle1);
        scene.addGeometry(triangle2);
        scene.addGeometry(triangle3);
        scene.addGeometry(triangle4);

        ImageWriter imageWriter = new ImageWriter("Emmission test2", 500, 500, 500, 500);

        Render render = new Render(imageWriter, scene);

        render.renderImage();
        render.printGrid(50);
        render.writeToImage();

    }

    @Test
    public void emmissionTest2_2() {
        Scene scene = new Scene();
        scene.setScreenDistance(50);

        Triangle triangle1 = new Triangle(new Point3D(150, 0, -150),
                new Point3D(0, 150, -70),
                new Point3D(150, 150, -50));

        triangle1.setEmmission(new Color(38, 26, 255));

        scene.addGeometry(triangle1);

        ImageWriter imageWriter = new ImageWriter("Render test @@@@@@@@", 500, 500, 500, 500);

        Render render = new Render(imageWriter, scene);

        render.renderImage();
        render.printGrid(50);
        render.writeToImage();


    }

    @Test
    public void emmissionTest3() {
        Scene scene = new Scene();
        scene.setScreenDistance(50);

        Triangle triangle1 = new Triangle(new Point3D(50, 0, -100),
                new Point3D(0, 150, -100),
                new Point3D(51, 100, -100));

        Triangle triangle2 = new Triangle(new Point3D(50, 0, -100),
                new Point3D(01, -510, -100),
                new Point3D(150, -100, -100));

        Triangle triangle3 = new Triangle(new Point3D(-50, 0, -100),
                new Point3D(0, 120, -100),
                new Point3D(-101, 100, -100));

        Triangle triangle4 = new Triangle(new Point3D(-50, 0, -100),
                new Point3D(0, -10, -100),
                new Point3D(-50, -001, -100));

        ImageWriter imageWriter = new ImageWriter("Emmission test3", 500, 500, 500, 500);
        triangle1.setEmmission(new Color(38, 26, 255));
        triangle2.setEmmission(new Color(101, 22, 16));
        triangle3.setEmmission(new Color(255, 66, 52));
        triangle4.setEmmission(new Color(6, 91, 34));

        scene.addGeometry(triangle1);
        scene.addGeometry(triangle2);
        scene.addGeometry(triangle3);
        scene.addGeometry(triangle4);


        Render render = new Render(imageWriter, scene);

        render.renderImage();
        render.printGrid(50);
        render.writeToImage();

    }

    @Test
    public void emmissionTest4() {
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
    @Test
    public void basicRendering() {

//        new File(IMAGES_TEST_DIR);
        Scene scene = new Scene();
        scene.setScreenDistance(50);

        /*scene.set_camera(new Camera(
                new Point3D(0,0,10),
                new Vector(0,0,-1),
                new Vector(0,1,0)));
           scene.set_background(new Color(0.3f ,0.5f, 0.74f));*/
//         scene.set_ambientLight(new AmbientLight(Color.BLACK);

        Sphere sphere = new Sphere(50, new Point3D(0.0, 0.0, -50));
        scene.addGeometry(sphere);

        Triangle triangle1 = new Triangle(
                new Point3D(100, 0, -49),
                new Point3D(0, 100, -49),
                new Point3D(100, 100, -49));

        Triangle triangle2 = new Triangle(
                new Point3D(100, 0, -49),
                new Point3D(0, -100, -49),
                new Point3D(100, -100, -49));

        Triangle triangle3 = new Triangle(
                new Point3D(-100, 0, -49),
                new Point3D(0, 100, -49),
                new Point3D(-100, 100, -49));

        Triangle triangle4 = new Triangle(
                new Point3D(-100, 0, -49),
                new Point3D(0, -100, -49),
                new Point3D(-100, -100, -49));

        sphere.setEmmission( new Color(255,152,187));
        triangle1.setEmmission( new Color(255, 31, 26));
        triangle2.setEmmission( new Color(23, 247, 255));
        triangle3.setEmmission( new Color(255, 254, 0));
        triangle4.setEmmission( new Color(34, 255, 0));

        scene.addGeometry(triangle1);
        scene.addGeometry(triangle2);
        scene.addGeometry(triangle3);
        scene.addGeometry(triangle4);

        ImageWriter imageWriter = new ImageWriter( "Render test efi", 500, 500, 500, 500);

        Render render = new Render(imageWriter, scene);

        render.renderImage();
        render.printGrid(50);
        render.writeToImage();

    }

}