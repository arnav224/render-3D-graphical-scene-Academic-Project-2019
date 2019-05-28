package renderer;

import geometries.*;
import org.junit.jupiter.api.Test;
import primitives.*;
import scene.*;
import elements.*;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class RenderTest {
/*
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
*/

    @Test
    public void emmissionTest1() {
        Scene scene = new Scene();
        scene.setScreenDistance(50);
        AmbientLight ambientLight = new AmbientLight();
        ambientLight.setColor(new Color(255,255,255));
        scene.setAmbientLight(ambientLight);
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

/*
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
*/

/*
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
*/

/*
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
*/


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
    public void shadowTest1YH() {
        Scene scene = new Scene();
        Sphere sphere = new Sphere(500, new Point3D(0.0, 0.0, -800));
        sphere.setShininess(20);
        sphere.setEmmission(new Color(241, 6, 151));

        scene.addGeometry(sphere);

        Triangle triangle1 = new Triangle(new Point3D(  300,  300, -500),
                new Point3D( -300, -300, -500),
                new Point3D(  300, -300, -500));



        scene.addGeometry(triangle1);


        scene.addLight(new SpotLight(new Color(200, 200, 200), new Point3D(-50, 50, -300),
                new Vector(20, 20, -80), 0.0001, 0.0001,0.0001));


        ImageWriter imageWriter = new ImageWriter("Shadow testYH", 500, 500, 500, 500);

        Render render = new Render(imageWriter, scene);

        render.renderImage();
        render.writeToImage();

    }

    @Test
    public void DirectionalLight(){

        Scene scene = new Scene();
        Sphere sphere = new Sphere(500, new Point3D(0.0, 0.0, -1500));
        sphere.setShininess(50);
        sphere.setEmmission(new Color(83, 50, 102));
        sphere.setKt(0);
        sphere.setKr(0);
        scene.addGeometry(sphere);

        Quadrangle quadrangle = new Quadrangle(new Point3D( -1000, 20000, 0),new Point3D( -1000, -20000, 0),
                new Point3D( 500, -20000, -20000),new Point3D( 500, 20000, -20000));
        quadrangle.setEmmission(new Color(35, 64, 7));
        quadrangle.setKr(0.1);
        scene.addGeometry(quadrangle);

        Triangle triangle1 = new Triangle(new Point3D(  550,  0, -1500),
                new Point3D( 450, -200, -900),
                new Point3D(  450, 300, -850));
        triangle1.setEmmission(new Color(100, 9, 116));
        scene.addGeometry(triangle1);

//        Triangle triangle1 = new Triangle(new Point3D(  3500,  3500, -2000),
//                new Point3D( -3500, -3500, -2000),
//                new Point3D(  3500, -3500, -2000));
//
//        Triangle triangle2 = new Triangle(new Point3D(  3500,  3500, -2000),
//                new Point3D( -3500,  3500, -2000),
//                new Point3D( -3500, -3500, -2000));
//        triangle2.setEmmission(new Color(14, 26, 72));
//        triangle1.setEmmission(new Color(14, 26, 72));
//        scene.addGeometry(triangle1);
//        scene.addGeometry(triangle2);

        //scene.addLight(new DirectionalLight(new Color(165, 228, 202), new Vector(-20, 5, -1)));
        scene.addLight(new DirectionalLight(new Color(255, 247, 232), new Vector(-20, 0,0)));
        ImageWriter imageWriter = new ImageWriter("    DirectionalLight_1", 500, 500, 500, 500);

        Render render = new Render(imageWriter, scene);

        render.renderImage();
        render.writeToImage();

    }
    @Test
    public void DirectionalLight2(){

        Scene scene = new Scene();
        Sphere sphere = new Sphere(500, new Point3D(0.0, 0.0, -1500));
        sphere.setShininess(50);
        sphere.setEmmission(new Color(255, 123, 182));
        sphere.setKr(0.1);
        scene.addGeometry(sphere);
        scene.setScreenDistance(285);

        Triangle triangle = new Triangle(new Point3D(  -500, 3000, 0),
                new Point3D( -500,  -3000, 0),
                new Point3D(  -200,  0, -20000));
        triangle.setEmmission(new Color(125, 110, 24));
        triangle.setKr(0.18);
        scene.addGeometry(triangle);



        Quadrangle quadrangle = new Quadrangle(new Point3D(  250,  750, -1500),
                new Point3D( 250, -300, -1400),
                new Point3D(  250, -250, -900), new Point3D(  250, 600, -850));
        quadrangle.setEmmission(new Color(191, 94, 136));
        quadrangle.setKr(0.1);
        scene.addGeometry(quadrangle);

        Triangle triangle1 = new Triangle(new Point3D(  550,  0, -1500),
                new Point3D( 450, -200, -700),
                new Point3D(  450, 300, -750));
        triangle1.setEmmission(new Color(82, 50, 191));
        scene.addGeometry(triangle1);

//        Triangle triangle1 = new Triangle(new Point3D(  3500,  3500, -2000),
//                new Point3D( -3500, -3500, -2000),
//                new Point3D(  3500, -3500, -2000));
//
//        Triangle triangle2 = new Triangle(new Point3D(  3500,  3500, -2000),
//                new Point3D( -3500,  3500, -2000),
//                new Point3D( -3500, -3500, -2000));
//        triangle2.setEmmission(new Color(14, 26, 72));
//        triangle1.setEmmission(new Color(14, 26, 72));
//        scene.addGeometry(triangle1);
//        scene.addGeometry(triangle2);

        //scene.addLight(new DirectionalLight(new Color(165, 228, 202), new Vector(-20, 5, -1)));
        scene.addLight(new DirectionalLight(new Color(59, 255, 214), new Vector(-20, 0,0)));
        scene.addLight(new DirectionalLight(new Color(255, 145, 127), new Vector(-20, 5,7)));
        ImageWriter imageWriter = new ImageWriter("DirectionalLight_2", 500, 500, 500, 500);

        Render render = new Render(imageWriter, scene);

        render.renderImage();
        render.writeToImage();

    }


    @Test
    public void shadowTest(){

        Scene scene = new Scene();
        Sphere sphere = new Sphere(500, new Point3D(0.0, 0.0, -1000));
        sphere.setShininess(80);
        sphere.setEmmission(new Color(0, 0, 30));

        scene.addGeometry(sphere);

        Triangle triangle1 = new Triangle(new Point3D(  3500,  3500, -2000),
                new Point3D( -3500, -3500, -1000),
                new Point3D(  3500, -3500, -2000));

        Triangle triangle2 = new Triangle(new Point3D(  3500,  3500, -2000),
                new Point3D( -3500,  3500, -1000),
                new Point3D( -3500, -3500, -1000));

        scene.addGeometry(triangle1);
        scene.addGeometry(triangle2);

        scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(200, 200, -100),
                new Vector(-2, -2, -3), 0, 0.000001, 0.0000005));


        ImageWriter imageWriter = new ImageWriter("Shadow test", 500, 500, 500, 500);

        Render render = new Render(imageWriter, scene);

        render.renderImage();
        render.writeToImage();

    }

//    @Test
//    public void shadowTestA(){
//
//        Scene scene = new Scene();
//        Sphere sphere = new Sphere(50, new Point3D(170.0, -30.0, -680));
//        sphere.setShininess(20);
//        sphere.setEmmission(new Color(20, 30, 21));
//
//        //scene.addGeometry(sphere);
//
//        Sphere sphere2 = new Sphere(50, new Point3D(-20.0, -160.0, -680));
//        sphere2.setShininess(20);
//        sphere2.setEmmission(new Color(30, 8, 8));
//
//        //scene.addGeometry(sphere2);
//
//        Sphere sphere3 = new Sphere(20, new Point3D(-100.0, 20.0, -680));
//        sphere3.setShininess(20);
//        sphere3.setEmmission(new Color(4, 28, 30));
//
//        //scene.addGeometry(sphere3);
//
//        Sphere sphere4 = new Sphere(50, new Point3D(30.0, -260.0, -680));
//        sphere4.setShininess(20);
//        sphere4.setEmmission(new Color(4, 5, 30));
//
//        //scene.addGeometry(sphere4);
//
//        Sphere sphere5 = new Sphere(50, new Point3D(260.0, -120.0, -680));
//        sphere5.setShininess(20);
//        sphere5.setEmmission(new Color(3, 30, 8));
//
//        //scene.addGeometry(sphere5);
//
//        Hemisphere hemisphere = new Hemisphere(650, new Point3D(-0.0, -0.0, -750), new Vector(13.0, 2.0, 1.5));
//        hemisphere.setShininess(20);
//        hemisphere.setEmmission(new Color(0, 10, 30));
//        scene.addGeometry(hemisphere);
//
////        Hemisphere2 hemisphere2 = new Hemisphere2(505, new Point3D(0.0, -0.0, -650), new Vector(3.0, 2.5, 8.5));
////        hemisphere2.setShininess(20);
////        hemisphere2.setEmmission(new Color(0, 10, 30));
////        scene.addGeometry(hemisphere2);
//
//        Triangle triangle1 = new Triangle(new Point3D(  3500,  3500, -2000),
//                new Point3D( -3500, -3500, -1000),
//                new Point3D(  3500, -3500, -2000));
//
//        Triangle triangle2 = new Triangle(new Point3D(  3500,  3500, -2000),
//                new Point3D( -3500,  3500, -1000),
//                new Point3D( -3500, -3500, -1000));
//
//        //scene.addGeometry(triangle1);
//        //scene.addGeometry(triangle2);
//
//        scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(200, 200, -100),
//                new Vector(-2, -2, -3), 0, 0.000001, 0.0000005));
//        //scene.addLight(new PointLight(new Color(255, 140, 120), new Point3D(0.0, 0.0, -300),0, 0.000001, 0.0000005));
//
//        ImageWriter imageWriter = new ImageWriter("Shadow test A", 500, 500, 500, 500);
//
//        Render render = new Render(imageWriter, scene);
//
//        render.renderImage();
//        render.writeToImage();
//
//    }

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

        @Test
        public void QuadrangleTest(){
            Scene scene = new Scene();
            scene.setScreenDistance(50);
            Quadrangle quadrangle = new Quadrangle(new Point3D(50,50,-50),new Point3D(50,-50,-50),
                    new Point3D(-50,50,-50),new Point3D(-50,-50,-50));
            quadrangle.setEmmission(new Color(0, 0, 100));
            scene.addGeometry(quadrangle);

            scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(-200, -200, -150),
                    new Vector(2, 2, -3), 0.1, 0.00001, 0.000005));

            ImageWriter imageWriter = new ImageWriter("QuadrangleTest1", 500, 500, 500, 500);

            Render render = new Render(imageWriter, scene);

            render.renderImage();
            render.writeToImage();

        }
        @Test
        public void recursiveTest()
        {
            Scene scene = new Scene();
            scene.setScreenDistance(300);

            Sphere sphere = new Sphere(500, new Point3D(0.0, 0.0, -1000));
            sphere.setShininess(20);
            sphere.setEmmission(new Color(0, 0, 100));
            sphere.setKt(0.5);
            scene.addGeometry(sphere);

            Sphere sphere2 = new Sphere(250, new Point3D(0.0, 0.0, -1000));
            sphere2.setShininess(20);
            sphere2.setEmmission(new Color(100, 20, 20));
            sphere2.setKt(0);
            scene.addGeometry(sphere2);

            scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(-200, -200, -150),
                    new Vector(2, 2, -3), 0.1, 0.00001, 0.000005));

            ImageWriter imageWriter = new ImageWriter("Recursive Test 11", 500, 500, 500, 500);

            Render render = new Render(imageWriter, scene);

            render.renderImage();
            render.writeToImage();
        }


        @Test
        public void recursiveTest2(){

            Scene scene = new Scene();
            scene.setScreenDistance(300);

            Sphere sphere = new Sphere(300, new Point3D(-550, -500, -1000));
            sphere.setShininess(20);
            sphere.setEmmission(new Color(0, 0, 100));
            sphere.setKt(0.5);
            sphere.setKr(0.5);
            sphere.setShininess(0);
            scene.addGeometry(sphere);

            Sphere sphere2 = new Sphere(150, new Point3D(-550, -500, -1000));
            sphere2.setShininess(20);
            sphere2.setEmmission(new Color(100, 20, 20));
            sphere2.setKt(0);
            sphere2.setKr(0.5);
            sphere2.setShininess(0);
            scene.addGeometry(sphere2);

            Triangle triangle = new Triangle(new Point3D(  1500, -1500, -1500),
                    new Point3D( -1500,  1500, -1500),
                    new Point3D(  200,  200, -375));

            Triangle triangle2 = new Triangle(new Point3D(  1500, -1500, -1500),
                    new Point3D( -1500,  1500, -1500),
                    new Point3D( -1500, -1500, -1500));
            triangle.setShininess(0);
            triangle2.setShininess(0);
            triangle.setEmmission(new Color(20, 20, 20));
            triangle2.setEmmission(new Color(20, 20, 20));
            triangle.setKr(1);
            triangle2.setKr(0.5);
            scene.addGeometry(triangle);
            scene.addGeometry(triangle2);

            scene.addLight(new SpotLight(new Color(255, 100, 100),  new Point3D(200, 200, -150),
                    new Vector(-2, -2, -3), 0, 0.00001, 0.000005));

            ImageWriter imageWriter = new ImageWriter("Recursive Test 2", 500, 500, 500, 500);

            Render render = new Render(imageWriter, scene);

            render.renderImage();
            render.writeToImage();

        }

    @Test
    public void recursiveTest3(){

        Scene scene = new Scene();
        scene.setScreenDistance(300);

        Sphere sphere = new Sphere(300, new Point3D(0, 0, -1000));
        sphere.setShininess(20);
        sphere.setEmmission(new Color(0, 0, 100));
        sphere.setKt(0.5);
        scene.addGeometry(sphere);

        Sphere sphere2 = new Sphere(150, new Point3D(0, 0, -1000));
        sphere2.setShininess(20);
        sphere2.setEmmission(new Color(100, 20, 20));
        sphere2.setKt(0);
        scene.addGeometry(sphere2);

        Triangle triangle = new Triangle(new Point3D(  2000, -1000, -1500),
                new Point3D( -1000,  2000, -1500),
                new Point3D(  700,  700, -375));

        Triangle triangle2 = new Triangle(new Point3D(  2000, -1000, -1500),
                new Point3D( -1000,  2000, -1500),
                new Point3D( -1000, -1000, -1500));

        triangle.setEmmission(new Color(20, 20, 20));
        triangle2.setEmmission(new Color(20, 20, 20));
        triangle.setKr(1);
        triangle2.setKr(0.5);
        scene.addGeometry(triangle);
        scene.addGeometry(triangle2);

        scene.addLight(new SpotLight(new Color(255, 100, 100),  new Point3D(200, 200, -150),
                new Vector(-2, -2, -3), 0, 0.00001, 0.000005));

        ImageWriter imageWriter = new ImageWriter("Recursive Test 3", 500, 500, 500, 500);

        Render render = new Render(imageWriter, scene);

        render.renderImage();
        render.writeToImage();
    }

    @Test
    public void Point_1(){

        Scene scene = new Scene();
        scene.setScreenDistance(300);

        Sphere sphere = new Sphere(300, new Point3D(0, 0, -1000));
        sphere.setShininess(20);
        sphere.setEmmission(new Color(120, 47, 90));
        sphere.setKt(0.8);
        scene.addGeometry(sphere);

        Sphere sphere2 = new Sphere(1700, new Point3D(-2000, 0, -1000));
        sphere2.setShininess(25);
        sphere2.setEmmission(new Color(156, 139, 34));
        sphere2.setKt(0.2);
        scene.addGeometry(sphere2);

        Sphere sphere3 = new Sphere(100, new Point3D(400, 0, -1000));
        sphere3.setShininess(20);
        sphere3.setEmmission(new Color(155, 61, 156));
        sphere3.setKt(0.59);
        scene.addGeometry(sphere3);

//        Plane plane = new Plane();
//        plane.setEmmission(new Color(11, 146, 156));
//        plane.setNormal(new Vector(0,0,1));
//        plane.setQ(new Point3D(0, 0, -1500));
//        scene.addGeometry(plane);

        Quadrangle quadrangle = new Quadrangle(new Point3D(400,-150,-1050),new Point3D(400,150,-1050),
                                               new Point3D(100,150,-700),new Point3D(100,-150,-700));
        quadrangle.setEmmission(new Color(255, 115, 22));
        quadrangle.setKt(0);
        quadrangle.setKr(0);
        scene.addGeometry(quadrangle);

        Triangle triangle = new Triangle(new Point3D(  -500, 3000, 0),
                new Point3D( -500,  -3000, 0),
                new Point3D(  -200,  0, -20000));


        triangle.setEmmission(new Color(20, 20, 20));
        triangle.setKr(1);
        scene.addGeometry(triangle);

        scene.addLight(new PointLight(new Color(255, 140, 120), new Point3D(2500, 350, -900),0, 0.000001, 0.0000005));
        scene.addLight(new PointLight(new Color(27, 255, 204), new Point3D(2300, -700, -1500),0.01, 0.00001, 0.000005));

        ImageWriter imageWriter = new ImageWriter("Point_1", 500, 500, 500, 500);

        Render render = new Render(imageWriter, scene);

        render.renderImage();
        render.writeToImage();
    }
    @Test
    public void aaaaaatest(){

        Scene scene = new Scene();
        scene.setScreenDistance(400);

        Sphere sphere = new Sphere(300, new Point3D(0, 0, -1000));
        sphere.setShininess(20);
        sphere.setEmmission(new Color(120, 47, 90));
        sphere.setKt(0.8);
        scene.addGeometry(sphere);

        Sphere sphere2 = new Sphere(150, new Point3D(150, 200, -1000));
        sphere2.setShininess(20);
        sphere2.setEmmission(new Color(156, 139, 34));
        sphere2.setKt(0.2);
        scene.addGeometry(sphere2);

//        Quadrangle quadrangle = new Quadrangle(new Point3D(550,1000,0),
//                new Point3D(-50,1000,-2000), new Point3D(550,-1000,0),new Point3D(-50,-1000,-2000));
//        quadrangle.setEmmission(new Color(121, 104, 116));
        //scene.addGeometry(quadrangle);

        Triangle triangle = new Triangle(new Point3D(  -1000, 3000, 0),
                new Point3D( -1000,  -3000, 0),
                new Point3D(  -800,  0, -8000));


        triangle.setEmmission(new Color(20, 20, 20));
        triangle.setKr(1);
        scene.addGeometry(triangle);

        scene.addLight(new SpotLight(new Color(255, 100, 100),  new Point3D(500, 200, -1000),
                new Vector(-2, -2, -3), 0, 0.00001, 0.000005));
        scene.addLight(new SpotLight(new Color(237, 171, 59),  new Point3D(350, -300, -800),
                new Vector(-2, 5, -3), 0, 0.00001, 0.000005));

        ImageWriter imageWriter = new ImageWriter("aaaaaatest", 500, 500, 500, 500);

        Render render = new Render(imageWriter, scene);

        render.renderImage();
        render.writeToImage();
    }

    @Test
    public void Table_Test() {

        Scene scene = new Scene();
        scene.setScreenDistance(50);
        scene.setBackground(new Color(2, 0, 0));
        //scene.set_camera(new Camera(new Point3D(40,0,100),new Vector(1,0,0),new Vector(0,0,-1)));
        //----The code of the routain , you can get a look in scene class
        //ROUTING UP/DOWN
        // scene.set_camera(new Camera(new Point3D(0,0,0), scene.RoutinY(scene.get_camera().get_Vup(),-45),
        //       scene.RoutinY(scene.get_camera().get_Vto(),-45)));
        //ROUTING AROUND
        //scene.set_camera(new Camera(new Point3D(0,0,0), scene.RoutinX(scene.get_camera().get_Vup(),-50),
        //       scene.RoutinX(scene.get_camera().get_Vto(),-50)));
        //the top of table
        Point3D Tabl_A = new Point3D(-60, -100, -51);
        Point3D Tabl_B = new Point3D(-60, 100, -51);
        Point3D Tabl_C = new Point3D(-80, 100, -51);
        Point3D Tabl_D = new Point3D(-80, -100, -51);
        Point3D Tabl_E = new Point3D(-60, -100, -151);
        Point3D Tabl_F = new Point3D(-60, 100, -151);
        Point3D Tabl_G = new Point3D(-80, 100, -151);
        Point3D Tabl_H = new Point3D(-80, -100, -151);

        Quadrangle up = new Quadrangle(Tabl_E, Tabl_F, Tabl_G, Tabl_H);
        up.setEmmission(new Color(228, 128, 58));
        Quadrangle down = new Quadrangle(Tabl_A, Tabl_B, Tabl_C, Tabl_D);
        down.setEmmission(new Color(228, 128, 58));
        Quadrangle right = new Quadrangle(Tabl_H, Tabl_F, Tabl_B, Tabl_D);
        right.setEmmission(new Color(228, 128, 58));
        Quadrangle left = new Quadrangle(Tabl_A, Tabl_G, Tabl_C, Tabl_E);
        left.setEmmission(new Color(228, 128, 58));
        Quadrangle front = new Quadrangle(Tabl_H, Tabl_G, Tabl_C, Tabl_D);
        front.setEmmission(new Color(228, 128, 58));
        Quadrangle back = new Quadrangle(Tabl_A, Tabl_B, Tabl_E, Tabl_F);
        back.setEmmission(new Color(228, 128, 58));

        scene.addGeometry(up);
        scene.addGeometry(down);
        scene.addGeometry(right);
        scene.addGeometry(left);
        scene.addGeometry(front);
        scene.addGeometry(back);

/*
        //the front left leg
        Point3D Leg_front_left_A = new Point3D(-80, -90, -61);
        Point3D Leg_front_left_B = add_point(Leg_front_left_A, 0, 15, 0);//new Point3D(-80, -75, -61);
        Point3D Leg_front_left_C = new Point3D(-240, -75, -61);
        Point3D Leg_front_left_D = new Point3D(-240, -90, -61);
        Point3D Leg_front_left_E = new Point3D(-80, -90, -76);
        Point3D Leg_front_left_F = new Point3D(-80, -75, -76);
        Point3D Leg_front_left_G = new Point3D(-240, -75, -76);
        Point3D Leg_front_left_H = new Point3D(-240, -90, -76);

        List<Quadrilateral> Leg_front_left = cube(Leg_front_left_A, Leg_front_left_B, Leg_front_left_C,
                Leg_front_left_D, Leg_front_left_E, Leg_front_left_F, Leg_front_left_G, Leg_front_left_H);

        scene.addGeometry(Leg_front_left.get(0));
        scene.addGeometry(Leg_front_left.get(1));
        scene.addGeometry(Leg_front_left.get(2));
        scene.addGeometry(Leg_front_left.get(3));
        scene.addGeometry(Leg_front_left.get(4));
        scene.addGeometry(Leg_front_left.get(5));

        //the front right leg
        Point3D Leg_front_right_A = new Point3D(-80, 75, -61);
        Point3D Leg_front_right_B = new Point3D(-80, 90, -61);
        Point3D Leg_front_right_G = new Point3D(-240, 90, -76);
        Point3D Leg_front_right_C = add_point(Leg_front_right_G, 0, 0, 15);
        Point3D Leg_front_right_D = add_point(Leg_front_right_A, -160, 0, 0);
        Point3D Leg_front_right_E = add_point(Leg_front_right_A, 0.0, 0.0, -15.0);
        Point3D Leg_front_right_F = add_point(Leg_front_right_G, 160, 0.0, 0.0);
        Point3D Leg_front_right_H = add_point(Leg_front_right_G, 0, -15, 0.0);

        List<Quadrilateral> Leg_frong_right = cube(Leg_front_right_A, Leg_front_right_B, Leg_front_right_C, Leg_front_right_D
                , Leg_front_right_E, Leg_front_right_F, Leg_front_right_G, Leg_front_right_H);

        scene.addGeometry(Leg_frong_right.get(0));
        scene.addGeometry(Leg_frong_right.get(1));
        scene.addGeometry(Leg_frong_right.get(2));
        scene.addGeometry(Leg_frong_right.get(3));
        scene.addGeometry(Leg_frong_right.get(4));
        scene.addGeometry(Leg_frong_right.get(5));

        //the back left leg
        Point3D Leg_back_left_A = new Point3D(-80, -90, -126);
        Point3D Leg_back_left_G = new Point3D(-240, -75, -141);
        Point3D Leg_back_left_B = add_point(Leg_back_left_A, 0, 15, 0);
        Point3D Leg_back_left_C = add_point(Leg_back_left_G, 0, 0, 15);
        Point3D Leg_back_left_D = add_point(Leg_back_left_A, -160, 0, 0);
        Point3D Leg_back_left_E = add_point(Leg_back_left_A, 0, 0, -15);
        Point3D Leg_back_left_F = add_point(Leg_back_left_G, 160, 0.0, 0.0);
        Point3D Leg_back_left_H = add_point(Leg_back_left_G, 0, -15, 0.0);

        List<Quadrilateral> Leg_back_left = cube(Leg_back_left_A, Leg_back_left_B, Leg_back_left_C, Leg_back_left_D,
                Leg_back_left_E, Leg_back_left_F, Leg_back_left_G, Leg_back_left_H);

        scene.addGeometry(Leg_back_left.get(0));
        scene.addGeometry(Leg_back_left.get(1));
        scene.addGeometry(Leg_back_left.get(2));
        scene.addGeometry(Leg_back_left.get(3));
        scene.addGeometry(Leg_back_left.get(4));
        scene.addGeometry(Leg_back_left.get(5));

        //the back right leg
        Point3D Leg_back_right_A = new Point3D(-80, 75, -126);
        Point3D Leg_back_right_G = new Point3D(-240, 90, -141);
        Point3D Leg_back_right_B = add_point(Leg_back_right_A, 0, 15, 0);
        Point3D Leg_back_right_C = add_point(Leg_back_right_G, 0, 0, 15);
        Point3D Leg_back_right_D = add_point(Leg_back_right_A, -160, 0, 0);
        Point3D Leg_back_right_E = add_point(Leg_back_right_A, 0, 0, -15);
        Point3D Leg_back_right_F = add_point(Leg_back_right_G, 160, 0, 0);
        Point3D Leg_back_right_H = add_point(Leg_back_right_G, 0, -15, 0);

        List<Quadrilateral> Leg_back_right = cube(Leg_back_right_A, Leg_back_right_B, Leg_back_right_C, Leg_back_right_D,
                Leg_back_right_E, Leg_back_right_F, Leg_back_right_G, Leg_back_right_H);

        scene.addGeometry(Leg_back_right.get(0));
        scene.addGeometry(Leg_back_right.get(1));
        scene.addGeometry(Leg_back_right.get(2));
        scene.addGeometry(Leg_back_right.get(3));
        scene.addGeometry(Leg_back_right.get(4));
        scene.addGeometry(Leg_back_right.get(5));


        Quadrilateral background = new Quadrilateral(new Point3D(-250, -250, -51), new Point3D(-250, 250, -51),
                new Point3D(-250, 250, -151), new Point3D(-250, -250, -151));
        background.set_emmission(new Color(2, 0, 0));
        scene.addGeometry(background);
*/
        scene.addLight(new SpotLight(new Color(255, 100, 100),  new Point3D(240, 50, -50),
                new Vector(-2, 0, -3), 0.1, 0.00001, 0.000005));

        scene.addLight(new DirectionalLight(new Color(100, 0, 102), new Vector(-1, -0.5, 0)));

        ImageWriter imageWriter = new ImageWriter("Table test", 500, 500, 500, 500);
        Render render = new Render(imageWriter, scene);
        render.renderImage();
        render.writeToImage();
    }


}