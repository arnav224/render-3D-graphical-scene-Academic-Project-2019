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
        triangle2.setEmmission(new Color (255, 228, 60));
        triangle3.setEmmission(new Color (255, 121, 40));
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
    public void emmissionTest2()
    {
        Scene scene = new Scene();
        scene.setScreenDistance(50);


        Triangle triangle1 = new Triangle(new Point3D( 150, 0, -150),
                new Point3D(  0, 150, -70),
                new Point3D( 150, 150, -50));

        Triangle triangle2 = new Triangle(new Point3D( 150, 0, -150),
                new Point3D(  0, -150, -70),
                new Point3D( 150,-150, -50));

        Triangle triangle3 = new Triangle(new Point3D(-150, 0, -150),
                new Point3D(  0, 150, -70),
                new Point3D(-150, 150, -50));

        Triangle triangle4 = new Triangle(new Point3D(-150, 0, -150),
                new Point3D(  0,  -150, -70),
                new Point3D(-150, -150, -50));


        triangle1.setEmmission(new Color (38, 26, 255));
        triangle2.setEmmission(new Color (101, 22, 16));
        triangle3.setEmmission(new Color (255, 66, 52));
        triangle4.setEmmission(new Color (6, 91, 34));


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
    public void emmissionTest3()
    {
        Scene scene = new Scene();
        scene.setScreenDistance(50);

        Triangle triangle1 = new Triangle(new Point3D( 50, 0, -100),
                new Point3D(  0, 150, -100),
                new Point3D( 51, 100, -100));

        Triangle triangle2 = new Triangle(new Point3D( 50, 0, -100),
                new Point3D(  01, -510, -100),
                new Point3D( 150,-100, -100));

        Triangle triangle3 = new Triangle(new Point3D(-50, 0, -100),
                new Point3D(  0, 120, -100),
                new Point3D(-101, 100, -100));

        Triangle triangle4 = new Triangle(new Point3D(-50, 0, -100),
                new Point3D(  0,  -10, -100),
                new Point3D(-50, -001, -100));

        ImageWriter imageWriter = new ImageWriter("Emmission test3", 500, 500, 500, 500);
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
    public void emmissionTest4()
    {
    }

/*
    @Test
    public void emmissionTest2()
    {
        Scene scene = new Scene();
        scene.setScreenDistance(50);
        scene.setBackground(new Color(0x4C4743));

*/
/*
        Triangle triangle1 = new Triangle(new Point3D( 50, 0, -100),
                new Point3D(  0, 150, -100),
                new Point3D( 50, 100, -100));

        Triangle triangle2 = new Triangle(new Point3D( 50, 0, -100),
                new Point3D(  0, -510, -100),
                new Point3D( 150,-100, -100));

        Triangle triangle3 = new Triangle(new Point3D(-50, 0, -100),
                new Point3D(  0, 120, -100),
                new Point3D(-10, 100, -100));

        Triangle triangle4 = new Triangle(new Point3D(-50, 0, -100),
                new Point3D(  0,  -10, -100),
                new Point3D(-50, -00, -100));

        triangle1.setEmmission(new Color (64, 59, 255));
        triangle2.setEmmission(new Color (255, 228, 60));
        triangle3.setEmmission(new Color (0, 255, 250));
        triangle4.setEmmission(new Color (255, 48, 124));

        scene.addGeometry(triangle1);
        scene.addGeometry(triangle2);
        scene.addGeometry(triangle3);
        scene.addGeometry(triangle4);
*//*



*/
/*
//        Sphere sphere1 = new Sphere(200, new Point3D(0.0, 0.0, -155));
//        Sphere sphere2 = new Sphere(190, new Point3D(0.0, 0.0, -154));
//        Sphere sphere3 = new Sphere(180, new Point3D(0.0, 0.0, -153));
//        Sphere sphere4 = new Sphere(170, new Point3D(0.0, 0.0, -152));
//        Sphere sphere5 = new Sphere(160, new Point3D(0.0, 0.0, -151));
//        Sphere sphere6 = new Sphere(150, new Point3D(0.0, 0.0, -150));
        Triangle triangle1 = new Triangle(new Point3D( 150, 0, -150),
                new Point3D(  0, 150, -50),
                new Point3D( 150, 150, -50));

        Triangle triangle2 = new Triangle(new Point3D( 150, 0, -150),
                new Point3D(  0, -150, -50),
                new Point3D( 150,-150, -50));

        Triangle triangle3 = new Triangle(new Point3D(-150, 0, -150),
                new Point3D(  0, 150, -50),
                new Point3D(-150, 150, -50));

        Triangle triangle4 = new Triangle(new Point3D(-150, 0, -150),
                new Point3D(  0,  -150, -50),
                new Point3D(-150, -150, -50));

        Triangle triangle5 = new Triangle(new Point3D(-50, 0, -140),
                new Point3D(  0,  -50, -140),
                new Point3D(-50, -50, -140));


//        sphere1.setEmmission(new Color(101, 179, 255));
//        sphere2.setEmmission(new Color(88, 132, 255));
//        sphere3.setEmmission(new Color(74, 101, 255));
//        sphere4.setEmmission(new Color(40, 92, 255));
//        sphere5.setEmmission(new Color(76, 72, 255));
//        sphere6.setEmmission(new Color(97, 59, 255));
        triangle1.setEmmission(new Color (255, 137, 48));
        triangle2.setEmmission(new Color (255, 228, 60));
        triangle3.setEmmission(new Color (27, 144, 10));
        triangle4.setEmmission(new Color (255, 48, 124));
        triangle5.setEmmission(new Color (184, 255, 52));

//        scene.addGeometry(sphere1);
//        scene.addGeometry(sphere2);
//        scene.addGeometry(sphere3);
//        scene.addGeometry(sphere4);
//        scene.addGeometry(sphere5);
//        scene.addGeometry(sphere6);
        scene.addGeometry(triangle1);
        scene.addGeometry(triangle2);
        scene.addGeometry(triangle3);
        scene.addGeometry(triangle4);
        //scene.addGeometry(triangle5);
*//*


        ImageWriter imageWriter = new ImageWriter("Emmission test 2", 500, 500, 500, 500);

        Render render = new Render(imageWriter, scene);

        render.renderImage();
        render.printGrid(50);
        render.writeToImage();
    }
*/

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