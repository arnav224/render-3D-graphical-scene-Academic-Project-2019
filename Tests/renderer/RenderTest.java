package renderer;

import geometries.*;
import org.junit.jupiter.api.Test;
import primitives.*;
import scene.*;
import elements.*;

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
    public void emmissionTest1() {
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

        sphere.setEmmission(new Color(0, 0, 0));
        triangle1.setEmmission(new Color(50, 255, 21));
        triangle2.setEmmission(new Color(0, 0, 0));
        triangle3.setEmmission(new Color(255, 49, 56));
        triangle4.setEmmission(new Color(28, 31, 255));

        scene.addGeometry(sphere);
        scene.addGeometry(triangle1);
        scene.addGeometry(triangle2);
        scene.addGeometry(triangle3);
        scene.addGeometry(triangle4);

        ImageWriter imageWriter = new ImageWriter("Emmission test1", 500, 500, 500, 500);

        Render render = new Render(imageWriter, scene);

        render.renderImage();
        render.printGrid(50);
        render.writeToImage();
    }

    @Test
    public void emmissionTest1_1() {
        Scene scene = new Scene();
        scene.setScreenDistance(50);

        Sphere sphere = new Sphere(100, new Point3D(0.0, 0.0, -150));
        Triangle triangle1 = new Triangle(new Point3D(600, 0, -350),
                new Point3D(0, 600, -350),
                new Point3D(600, 600, -350));

        Triangle triangle2 = new Triangle(new Point3D(600, 0, -350),
                new Point3D(0, -600, -350),
                new Point3D(600, -600, -350));

        Triangle triangle3 = new Triangle(new Point3D(-600, 0, -350),
                new Point3D(0, 600, -350),
                new Point3D(-600, 600, -350));

        Triangle triangle4 = new Triangle(new Point3D(-600, 0, -350),
                new Point3D(0, -600, -350),
                new Point3D(-600, -600, -350));

        PointLight pointLight = new PointLight(new Color(255,255,255),new Point3D(550,350,-250),0.02,0.02,0.02);
        PointLight pointLight1 = new PointLight(new Color(255,255,255),new Point3D(50,30,-250),0.02,0.02,0.02);
//        PointLight pointLight2 = new PointLight(new Color(255,255,255),new Point3D(200,200,-30),0.01,0.01,0.01);
//        PointLight pointLight3 = new PointLight(new Color(255,255,255),new Point3D(50,50,-30),0.01,0.01,0.01);
//        PointLight pointLight4 = new PointLight(new Color(255,255,255),new Point3D(200,50,-30),0.6,0.6,0.6);
//        PointLight pointLight5 = new PointLight(new Color(255,255,255),new Point3D(200,50,-30),0.6,0.6,0.6);

        sphere.setEmmission(new Color(255, 50, 40));
        triangle1.setEmmission(new Color(64, 59, 255));
        triangle2.setEmmission(new Color(0, 0, 0));
        triangle3.setEmmission(new Color(255, 121, 40));
        triangle4.setEmmission(new Color(255, 48, 124));

        scene.addGeometry(sphere);
        scene.addGeometry(triangle1);
        scene.addGeometry(triangle2);
        scene.addGeometry(triangle3);
        scene.addGeometry(triangle4);
        scene.addLight(pointLight);
        scene.addLight(pointLight1);
//        scene.addLight(pointLight2);
//        scene.addLight(pointLight3);

        ImageWriter imageWriter = new ImageWriter("Emmission test1_1", 500, 500, 500, 500);

        Render render = new Render(imageWriter, scene);

        render.renderImage();
        render.printGrid(50);
        render.writeToImage();
    }
    @Test

    public void directoinaiTest() {
        Scene scene = new Scene();
        scene.setScreenDistance(50);

        Plane plane = new Plane(new Vector(0,0,-100),new Point3D(0,0,-20));


        DirectionalLight directionalLight = new DirectionalLight(new Color(0,255,255),new Vector(0,0,-1));
//        PointLight pointLight2 = new PointLight(new Color(255,255,255),new Point3D(200,200,-30),0.01,0.01,0.01);
//        PointLight pointLight3 = new PointLight(new Color(255,255,255),new Point3D(50,50,-30),0.01,0.01,0.01);
//        PointLight pointLight4 = new PointLight(new Color(255,255,255),new Point3D(200,50,-30),0.6,0.6,0.6);
//        PointLight pointLight5 = new PointLight(new Color(255,255,255),new Point3D(200,50,-30),0.6,0.6,0.6);



        scene.addGeometry(plane);
        scene.addLight(directionalLight);
//        scene.addLight(pointLight2);
//        scene.addLight(pointLight3);

        ImageWriter imageWriter = new ImageWriter("directoinaiTest", 500, 500, 500, 500);

        Render render = new Render(imageWriter, scene);

        render.renderImage();
        render.printGrid(50);
        render.writeToImage();
    }

    @Test
    public void emmissionTest1_2() {
        Scene scene = new Scene();
        scene.setScreenDistance(50);

        Sphere sphere = new Sphere(75, new Point3D(0.0, 0.0, -100));
        Triangle triangle1 = new Triangle(new Point3D(  0,  10, -41),
                new Point3D( 25, 15, -41),
                new Point3D(  0, -20, -41));

        Plane plane = new Plane(new Vector(0,0, -1), new Point3D(0,0, -300));

        PointLight pointLight = new PointLight(new Color(255, 249, 34),new Point3D(10,10,-10),0,0.8,0);
        scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(50, 50, 200),
                new Vector(-2, -2, -3), 0, 0.0001, 0.00005));
        //PointLight pointLight1 = new PointLight(new Color(255,255,0),new Point3D(50,30,-250),0.2,0.1,0.1);

//        PointLight pointLight2 = new PointLight(new Color(255,255,255),new Point3D(200,200,-30),0.01,0.01,0.01);
//        PointLight pointLight3 = new PointLight(new Color(255,255,255),new Point3D(50,50,-30),0.01,0.01,0.01);
//        PointLight pointLight4 = new PointLight(new Color(255,255,255),new Point3D(200,50,-30),0.6,0.6,0.6);
//        PointLight pointLight5 = new PointLight(new Color(255,255,255),new Point3D(200,50,-30),0.6,0.6,0.6);

        triangle1.setEmmission(new Color(255, 93, 33));
        sphere.setEmmission(new Color(60, 23, 137));
        plane.setEmmission(new Color(255, 58, 199));

        scene.addGeometry(triangle1);
        scene.addGeometry(sphere);
        scene.addGeometry(plane);
        //scene.addLight(pointLight);
        //scene.addLight(pointLight1);

//        scene.addLight(pointLight2);
//        scene.addLight(pointLight3);

        ImageWriter imageWriter = new ImageWriter("Emmission test1_2", 500, 500, 500, 500);

        Render render = new Render(imageWriter, scene);

        render.renderImage();
        render.printGrid(50);
        render.writeToImage();

    }

    @Test
    public void emmissionTest1_2_3() {
        Scene scene = new Scene();
        scene.setScreenDistance(50);

        Sphere sphere = new Sphere(500, new Point3D(0.0, 0.0, -550));

        Plane plane = new Plane(new Vector(0,20, -100), new Point3D(0,0, -700));
        Triangle triangle1 = new Triangle(new Point3D(  0,  10, -10),
                new Point3D( -20, -0, -10),
                new Point3D(  0, -20, -10));
        PointLight pointLight = new PointLight(new Color(255, 249, 34),new Point3D(50,50,-10),0,0.8,0);
        //PointLight pointLight1 = new PointLight(new Color(255,255,0),new Point3D(50,30,-250),0.2,0.1,0.1);

//        PointLight pointLight2 = new PointLight(new Color(255,255,255),new Point3D(200,200,-30),0.01,0.01,0.01);
//        PointLight pointLight3 = new PointLight(new Color(255,255,255),new Point3D(50,50,-30),0.01,0.01,0.01);
//        PointLight pointLight4 = new PointLight(new Color(255,255,255),new Point3D(200,50,-30),0.6,0.6,0.6);
//        PointLight pointLight5 = new PointLight(new Color(255,255,255),new Point3D(200,50,-30),0.6,0.6,0.6);


        sphere.setEmmission(new Color(60, 23, 137));
        plane.setEmmission(new Color(255, 58, 199));

        scene.addGeometry(sphere);
        scene.addGeometry(plane);
        scene.addLight(pointLight);
        //scene.addLight(pointLight1);

//        scene.addLight(pointLight2);
//        scene.addLight(pointLight3);

        ImageWriter imageWriter = new ImageWriter("Emmission test1_2_3", 500, 500, 500, 500);

        Render render = new Render(imageWriter, scene);

        render.renderImage();
        render.printGrid(50);
        render.writeToImage();

    }

    @Test
    public void  spointlight () throws Exception
    {
        Scene scene = new Scene();
        Sphere sphere = new Sphere( 500, new Point3D(0.0, 0.0, -1000));
        sphere.setEmmission(new Color(241, 6, 151));
        sphere.setShininess(20);
        scene.addGeometry(sphere);

        scene.addLight(new SpotLight(new Color(200, 200, 200), new Point3D(-250, -250, -150),
                new Vector(2, 2, -2), 0.0001, 0.0001,0.0001));

        ImageWriter imageWriter = new ImageWriter("spot tese", 500, 500, 500, 500);

        Render render = new Render(imageWriter, scene);

        render.renderImage();
        //render.printGrid(50);
        render.writeToImage();

    }

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
        triangle4.setEmmission(new Color(0, 0, 0));


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
    public void emmissionTest_spotLight() {
        Scene scene = new Scene();
        scene.setScreenDistance(50);

        Sphere sphere = new Sphere(500, new Point3D(0.0, 0.0, -550));


        SpotLight SpotLight = new SpotLight(new Color(0,255,255),new Point3D(50,50,-10),new Vector(20, 10, -50),0,0.5,0);
        //PointLight pointLight1 = new PointLight(new Color(255,255,0),new Point3D(50,30,-250),0.2,0.1,0.1);
//        PointLight pointLight2 = new PointLight(new Color(255,255,255),new Point3D(200,200,-30),0.01,0.01,0.01);
//        PointLight pointLight3 = new PointLight(new Color(255,255,255),new Point3D(50,50,-30),0.01,0.01,0.01);
//        PointLight pointLight4 = new PointLight(new Color(255,255,255),new Point3D(200,50,-30),0.6,0.6,0.6);
//        PointLight pointLight5 = new PointLight(new Color(255,255,255),new Point3D(200,50,-30),0.6,0.6,0.6);

        sphere.setEmmission(new Color(88, 55, 255));


        scene.addGeometry(sphere);
        scene.addLight(SpotLight);
        //scene.addLight(pointLight1);
//        scene.addLight(pointLight2);
//        scene.addLight(pointLight3);

        ImageWriter imageWriter = new ImageWriter("emmissionTest_spotLight", 500, 500, 500, 500);

        Render render = new Render(imageWriter, scene);

        render.renderImage();
        render.printGrid(50);
        render.writeToImage();
    }

    @Test
    public void emmissionTest4() {
    }

    @Test
    public void shadowTest(){

        Scene scene = new Scene();
        Sphere sphere = new Sphere(500, new Point3D(0.0, 0.0, -750));
        sphere.setShininess(20);
        sphere.setEmmission(new Color(0, 0, 100));

        scene.addGeometry(sphere);

//        Triangle triangle1 = new Triangle(new Point3D(  3500,  3500, -1000),
//                new Point3D( -3500, -3500, -100),
//                new Point3D(  3500, -3500, -1000));
//
//        Triangle triangle2 = new Triangle(new Point3D(  3500,  3500, -1000),
//                new Point3D( -3500,  3500, -500),
//                new Point3D( -3500, -3500, -100));

        Triangle triangle1 = new Triangle(new Point3D(  3500,  3500, -2000),
                new Point3D( -3500, -3500, -1000),
                new Point3D(  3500, -3500, -2000));

        Triangle triangle2 = new Triangle(new Point3D(  3500,  3500, -2000),
                new Point3D( -3500,  3500, -1000),
                new Point3D( -3500, -3500, -1000));
        triangle1.setEmmission( new Color(121, 107, 87));
        triangle2.setEmmission( new Color(121, 107, 87));
        scene.addGeometry(triangle1);
        scene.addGeometry(triangle2);

        scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(100, 100, -100),
                new Vector(-2, -2, -3), 0, 0.0001, 0.00005));


        ImageWriter imageWriter = new ImageWriter("Shadow test", 500, 500, 500, 500);

        Render render = new Render(imageWriter, scene);

        render.renderImage();
        render.writeToImage();

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