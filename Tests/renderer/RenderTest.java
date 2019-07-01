package renderer;

import geometries.*;
import org.junit.jupiter.api.Test;
import primitives.*;
import scene.*;
import elements.*;

import java.awt.*;

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


/*
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
*/

    @Test
    public void emmissionTest4() {
    }

/*
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
*/
    @Test
    public void DirectionalLight2() throws Exception {

        Scene scene = new Scene();
        Sphere sphere = new Sphere(500, new Point3D(0.0, 0.0, -1500));
        sphere.setShininess(50);
        sphere.setEmmission(new Color(255, 123, 182));
        sphere.setKr(0.1);
        scene.addGeometry(sphere);
        scene.setScreenDistance(285);

        Plane plane = new Plane(new Vector(0,0,-1), new Point3D(0,0,-300));
        plane.setKt(1);
        Material material = plane.getMaterial();
        material.set_NumOfReflectionRays(0);
        material.setBlurring(0.0004);
        plane.setMaterial(material);
        //scene.addGeometry(plane);


        Triangle triangle = new Triangle(new Point3D(  -500, 3000, 0),
                new Point3D( -500,  -3000, 0),
                new Point3D(  -200,  0, -20000));
        triangle.setEmmission(new Color(125, 110, 24));
        material = triangle.getMaterial();
        material.set_NumOfReflectionRays(20);
        material.setBlurring(0.00001);
        triangle.setMaterial(material);
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


/*
    @Test
    public void shadowTestold() throws Exception {

        Scene scene = new Scene();
        Sphere sphere = new Sphere(500, new Point3D(0.0, 0.0, -1000));
        sphere.setShininess(20);
        sphere.setEmmission(new Color(0, 0, 30));
        scene.addGeometry(sphere);

        Quadrangle quadrangle = new Quadrangle(new Point3D(-550, 700, -1500),
                new Point3D(-550, -100,-1500),
                new Point3D(-550, -100, -420),
                new Point3D(-550, 700, -420));
        quadrangle.setEmmission(new Color(47, 17, 54));
        scene.addGeometry(quadrangle);
        Quadrangle quadrangle2 = new Quadrangle(new Point3D(-550, 700, -1500),
                new Point3D(-450, 700,-1500),
                new Point3D(-450, 700, -420),
                new Point3D(-550, 700, -420));
        quadrangle2.setEmmission(new Color(30, 41, 5));
        scene.addGeometry(quadrangle2);
        Quadrangle quadrangle3 = new Quadrangle(new Point3D(-450, 700,-1500),
                new Point3D(-450, 400,-1500),
                new Point3D(-450, 400, -420),
                new Point3D(-450, 700, -420));
        quadrangle3.setEmmission(new Color(38, 41, 6));
        scene.addGeometry(quadrangle3);
//        Sphere sphere2 = new Sphere(200, new Point3D(-345.0, 100.0, -520));
//        sphere2.setShininess(80);
//        sphere2.setEmmission(new Color(0, 0, 30));
//
//        scene.addGeometry(sphere2);

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

        scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(200, 350, -100),
                new Vector(-1, -1, -3), 0, 0.000001, 0.0000005));

        ImageWriter imageWriter = new ImageWriter("Shadow testold", 500, 500, 500, 500);

        Render render = new Render(imageWriter, scene);

        render.renderImage();
        render.writeToImage();

    }
*/

    @Test
    public void shadowTest() throws Exception {

        Scene scene = new Scene();
        Sphere sphere = new Sphere(500, new Point3D(0.0, 0.0, -1000));
        sphere.setShininess(20);
        sphere.setEmmission(new Color(0, 0, 30));
        scene.addGeometry(sphere);

        Quadrangle quadrangle = new Quadrangle(new Point3D(-550, 700, -1500),
                new Point3D(-550, -100,-1500),
                new Point3D(-550, -100, -420),
                new Point3D(-550, 700, -420));
        quadrangle.setEmmission(new Color(47, 17, 54));
        scene.addGeometry(quadrangle);
        Quadrangle quadrangle2 = new Quadrangle(new Point3D(-550, 700, -1500),
                new Point3D(-450, 700,-1500),
                new Point3D(-450, 700, -420),
                new Point3D(-550, 700, -420));
        quadrangle2.setEmmission(new Color(30, 41, 5));
        scene.addGeometry(quadrangle2);
        Quadrangle quadrangle3 = new Quadrangle(new Point3D(-450, 700,-1500),
                new Point3D(-450, 400,-1500),
                new Point3D(-450, 400, -420),
                new Point3D(-450, 700, -420));
        quadrangle3.setEmmission(new Color(38, 41, 6));
        scene.addGeometry(quadrangle3);
//        Sphere sphere2 = new Sphere(200, new Point3D(-345.0, 100.0, -520));
//        sphere2.setShininess(80);
//        sphere2.setEmmission(new Color(0, 0, 30));
//
//        scene.addGeometry(sphere2);

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

        scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(200, 350, -100),
                new Vector(-1, -1, -3), 0, 0.000001, 0.0000005));

        ImageWriter imageWriter = new ImageWriter("Shadow test", 500, 500, 500, 500);

        Render render = new Render(imageWriter, scene);

        render.renderImage();
        render.writeToImage();

    }

    @Test
    public void shadowTestA() throws Exception {

        Scene scene = new Scene();
        Sphere sphere = new Sphere(50, new Point3D(170.0, -30.0, -680));
        sphere.setShininess(20);
        sphere.setEmmission(new Color(20, 30, 21));

        //scene.addGeometry(sphere);

        Sphere sphere2 = new Sphere(50, new Point3D(-20.0, -160.0, -680));
        sphere2.setShininess(20);
        sphere2.setEmmission(new Color(30, 8, 8));

        scene.addGeometry(sphere2);

        Sphere sphere3 = new Sphere(20, new Point3D(-100.0, 20.0, -680));
        sphere3.setShininess(20);
        sphere3.setEmmission(new Color(4, 28, 30));

        scene.addGeometry(sphere3);

        Sphere sphere4 = new Sphere(50, new Point3D(30.0, -260.0, -680));
        sphere4.setShininess(20);
        sphere4.setEmmission(new Color(4, 5, 30));

        scene.addGeometry(sphere4);

        Sphere sphere5 = new Sphere(50, new Point3D(260.0, -120.0, -680));
        sphere5.setShininess(20);
        sphere5.setEmmission(new Color(3, 30, 8));

        //scene.addGeometry(sphere5);

        Hemisphere2 hemisphere = new Hemisphere2(650, new Point3D(-100.0, -0.0, -750), new Vector(13.0, 2.0, 1.5));
        hemisphere.setShininess(20);
        hemisphere.setEmmission(new Color(0, 10, 30));
        scene.addGeometry(hemisphere);

//        Hemisphere22 hemisphere2 = new Hemisphere22(505, new Point3D(0.0, -0.0, -650), new Vector(3.0, 2.5, 8.5));
//        hemisphere2.setShininess(20);
//        hemisphere2.setEmmission(new Color(0, 10, 30));
//        scene.addGeometry(hemisphere2);

        Triangle triangle1 = new Triangle(new Point3D(  3500,  3500, -2000),
                new Point3D( -3500, -3500, -1000),
                new Point3D(  3500, -3500, -2000));

        Triangle triangle2 = new Triangle(new Point3D(  3500,  3500, -2000),
                new Point3D( -3500,  3500, -1000),
                new Point3D( -3500, -3500, -1000));

        scene.addGeometry(triangle1);
        scene.addGeometry(triangle2);

        scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(300, 200, 200),
                new Vector(-2, -2, -3), 0, 0.000001, 0.0000005));
        //scene.addLight(new PointLight(new Color(255, 140, 120), new Point3D(0.0, 0.0, -300),0, 0.000001, 0.0000005));

        ImageWriter imageWriter = new ImageWriter("Shadow test A", 500, 500, 500, 500);

        Render render = new Render(imageWriter, scene);

        render.renderImage();
        render.writeToImage();

    }
    @Test
    public void directionTest() {
        Scene scene = new Scene();
        scene.setScreenDistance(50);
        Plane plane = new Plane(new Vector(0,0,-1), new Point3D(0,0,-200));
        scene.addGeometry(plane);
        scene.addLight(new PointLight(new Color(255, 140, 120), new Point3D(0,0,-300),0, 0.000001, 0.0000005));

        ImageWriter imageWriter = new ImageWriter("directionTest", 500, 500, 500, 500);

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

    @Test
    public void QuadrangleTest() throws Exception {
            Scene scene = new Scene();
            scene.setScreenDistance(50);
            Quadrangle quadrangle = new Quadrangle(new Point3D(50,-50,-50),new Point3D(50,50,-50),
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
    public void recursiveTest() throws Exception
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
    public void refructedTest() throws Exception {
        Scene scene = new Scene();
        scene.setScreenDistance(300);

        Triangle triangle = new Triangle(
                new Point3D( -1500,  1500, -1000),new Point3D(  1500, -1500, -1000),
                new Point3D(  1500,  1500, -1000));

        Triangle triangle2 = new Triangle(new Point3D(  200, -800, -1500),
                new Point3D( -800,  200, -1500),
                new Point3D( 500, 500, -1500));
        triangle.setShininess(0);
        triangle2.setShininess(0);
        triangle.setEmmission(new Color(255, 105, 0));
        triangle2.setEmmission(new Color(0, 150, 255));

        triangle.setKt(0.8);
        triangle2.setKt(0);
        scene.addGeometry(triangle);
        scene.addGeometry(triangle2);

        scene.addLight(new SpotLight(new Color(255, 100, 100),  new Point3D(200, 200, -150),
                new Vector(-2, -2, -3), 0, 0.00001, 0.000005));

        ImageWriter imageWriter = new ImageWriter("refructedTest1", 500, 500, 500, 500);

        Render render = new Render(imageWriter, scene);

        render.renderImage();
        render.writeToImage();


    }

    @Test
    public void recursiveTest2() throws Exception {

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
            Material material = triangle.getMaterial();
            material.set_NumOfReflectionRays(5);
            material.setBlurring(0.0005);
            triangle.setMaterial(material);


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
    public void recursiveTest3() throws Exception {

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

/*
    @Test
    public void Point_1() throws Exception {

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
        scene.addLight(new PointLight(new Color(146, 255, 202), new Point3D(2300, 570, -750),0, 0.000001, 0.0000005));

        ImageWriter imageWriter = new ImageWriter("Point_1", 500, 500, 500, 500);

        Render render = new Render(imageWriter, scene);

        render.renderImage();
        render.writeToImage();
    }
*/
@Test
public void Point_1() throws Exception {

    Scene scene = new Scene();
    scene.setScreenDistance(300);

    Sphere sphere = new Sphere(300, new Point3D(0, 0, -1000));
    sphere.setShininess(20);
    sphere.setEmmission(new Color(120, 47, 90));
    sphere.setKt(0.5);
    scene.addGeometry(sphere);

    Sphere sphere2 = new Sphere(1700, new Point3D(-2000, 0, -1000));
    sphere2.setShininess(25);
    sphere2.setEmmission(new Color(156, 139, 34));
    sphere2.setKt(0.2);
    scene.addGeometry(sphere2);

    Sphere sphere3 = new Sphere(100, new Point3D(400, 0, -900));
    sphere3.setShininess(20);
    sphere3.setEmmission(new Color(155, 61, 156));
    sphere3.setKt(0);
    scene.addGeometry(sphere3);

//        Plane plane = new Plane();
//        plane.setEmmission(new Color(11, 146, 156));
//        plane.setNormal(new Vector(0,0,1));
//        plane.setQ(new Point3D(0, 0, -1500));
//        scene.addGeometry(plane);

    Quadrangle quadrangle = new Quadrangle(
            new Point3D(100,-150,-700),new Point3D(100,150,-700),
            new Point3D(400,150,-1050), new Point3D(400,-150,-1050));
    quadrangle.setEmmission(new Color(126, 67, 23));
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
    scene.addLight(new PointLight(new Color(146, 255, 202), new Point3D(2300, 570, -750),0, 0.000001, 0.0000005));

    ImageWriter imageWriter = new ImageWriter("Point_1", 500, 500, 500, 500);

    Render render = new Render(imageWriter, scene);

    render.renderImage();
    render.writeToImage();
}


    @Test
    public void aaaaaatest() throws Exception {

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
    @Test
    public void softShadowTest() throws Exception {

        Scene scene = new Scene();
        Sphere sphere = new Sphere(500, new Point3D(0.0, 0.0, -1000));
        sphere.setShininess(20);
        sphere.setEmmission(new Color(0, 0, 30));
        scene.addGeometry(sphere);

        Quadrangle quadrangle = new Quadrangle(new Point3D(-550, 700, -1500),
                new Point3D(-550, -100,-1500),
                new Point3D(-550, -100, -420),
                new Point3D(-550, 700, -420));
        quadrangle.setEmmission(new Color(47, 17, 54));
        scene.addGeometry(quadrangle);
        Quadrangle quadrangle2 = new Quadrangle(new Point3D(-550, 700, -1500),
                new Point3D(-450, 700,-1500),
                new Point3D(-450, 700, -420),
                new Point3D(-550, 700, -420));
        quadrangle2.setEmmission(new Color(30, 41, 5));
        scene.addGeometry(quadrangle2);
        Quadrangle quadrangle3 = new Quadrangle(new Point3D(-450, 700,-1500),
                new Point3D(-450, 400,-1500),
                new Point3D(-450, 400, -420),
                new Point3D(-450, 700, -420));
        quadrangle3.setEmmission(new Color(38, 41, 6));
        scene.addGeometry(quadrangle3);
//        Sphere sphere2 = new Sphere(200, new Point3D(-345.0, 100.0, -520));
//        sphere2.setShininess(80);
//        sphere2.setEmmission(new Color(0, 0, 30));
//
//        scene.addGeometry(sphere2);

        Triangle triangle1 = new Triangle(new Point3D(  3500,  3500, -2000),
                new Point3D( -3500, -3500, -1000),
                new Point3D(  3500, -3500, -2000));

        Triangle triangle2 = new Triangle(new Point3D(  3500,  3500, -2000),
                new Point3D( -3500,  3500, -1000),
                new Point3D( -3500, -3500, -1000));

        scene.addGeometry(triangle1);
        scene.addGeometry(triangle2);

        scene.addVolumeLight(new SpotLight(new Color(26, 10, 10), new Point3D(200, 200, -100),
                new Vector(-2, -2, -3), 0, 0.000001, 0.0000005), 100, 10);

        scene.addVolumeLight(new SpotLight(new Color(26, 10, 10), new Point3D(200, 350, -100),
                new Vector(-1, -1, -3), 0, 0.000001, 0.0000005), 100, 10);

        ImageWriter imageWriter = new ImageWriter("Soft Shadow test7", 500, 500, 500, 500);

        Render render = new Render(imageWriter, scene);

        render.renderImage();
        render.writeToImage();

    }
    @Test
    public void softPoint_1() throws Exception {

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

        scene.addVolumeLight(new PointLight(new Color(25, 14, 12), new Point3D(2500, 350, -900),0, 0.000001, 0.0000005),200,20);
        //scene.addVolumeLight(new PointLight(new Color(27, 255, 204), new Point3D(2300, -700, -1500),0.01, 0.00001, 0.000005),50,8);

        ImageWriter imageWriter = new ImageWriter("softPoint_4", 500, 500, 500, 500);

        Render render = new Render(imageWriter, scene);

        render.renderImage();
        render.writeToImage();
    }

    @Test
    void CylinderTest() throws Exception {
        Scene scene = new Scene();
        scene.setScreenDistance(200);
        Cylinder cylinder = new Cylinder(50, new Point3D( 0,  0, -500), new Vector(1,0,0));
        cylinder.setEmmission(new Color(255, 134, 42));
        scene.addGeometry(cylinder);
        scene.addLight(new PointLight(new Color(255, 140, 120), new Point3D(2500, 350, -900),0, 0.000001, 0.0000005));
        ImageWriter imageWriter = new ImageWriter("CylinderTest", 500, 500, 500, 500);

        Render render = new Render(imageWriter, scene);

        render.renderImage();
        render.writeToImage();
    }

    @Test
    void reflectedTest() throws Exception {
        Scene scene = new Scene();
        scene.setScreenDistance(220);
        Plane plane = new Plane(new Vector(1,0, 0), new Point3D(-500,0, 0));
        plane.setEmmission(new Color(43, 43, 43));
        plane.setKr(0.9995);
        Material material = plane.getMaterial();
        material.set_NumOfReflectionRays(10);
        material.setBlurring(0.05);
        plane.setMaterial(material);
        scene.addGeometry(plane);

        Plane plane2 = new Plane(new Vector(0,0, -1), new Point3D(0,0, -10000));
        plane2.setEmmission(new Color(255, 104, 104));
        //scene.addGeometry(plane2);

        Sphere sphere = new Sphere(300, new Point3D(-200, 0, -1000));
        sphere.setShininess(20);
        sphere.setEmmission(new Color(120, 47, 90));
        scene.addGeometry(sphere);


        scene.addLight(new PointLight(new Color(255, 140, 120), new Point3D(2500, 350, -900),0, 0.000001, 0.0000005));
//        scene.addLight(new DirectionalLight(new Color(255, 140, 120), new Vector(-10, -1, -2)));
        ImageWriter imageWriter = new ImageWriter("reflectedTest", 500, 500, 500, 500);

        Render render = new Render(imageWriter, scene);

        render.renderImage();
        render.writeToImage();
    }

    @Test
    void reflectedTest2() throws Exception
    {
        Scene scene = new Scene();
        scene.setScreenDistance(200);

        Plane backgroundPlain1 = new Plane(new Vector(3,0, -10), new Point3D(3000,0, -10000));
        backgroundPlain1.setEmmission(new Color(125, 71, 114));
        backgroundPlain1.setKt(0.5);
        //scene.addGeometry(backgroundPlain1);

        Plane backgroundPlain2 = new Plane(new Vector(4,0, -10), new Point3D(7000,0, -10000));
        backgroundPlain2.setEmmission(new Color(125, 79, 69));
        backgroundPlain2.setKt(0.5);
        //scene.addGeometry(backgroundPlain2);

        Plane backgroundPlain3 = new Plane(new Vector(2,0, -10), new Point3D(1000,0, -10000));
        backgroundPlain3.setEmmission(new Color(125, 25, 35));
        backgroundPlain3.setKt(0.5);
        //scene.addGeometry(backgroundPlain3);

        Plane basePlain2 = new Plane(new Vector(1,0,0), new Point3D(-400,0,0));
//        Quadrangle baseQuadrangle = new Quadrangle(new Point3D(-400, -5000, 0),
//                new Point3D(-400, -50000, -100000), new Point3D(-400, 50000, -100000), new Point3D(-400, 5000, 0));
        basePlain2.setEmmission(new Color(0, 0, 0));
        Material material = basePlain2.getMaterial();
        material.set_NumOfReflectionRays(0);
        material.setBlurring(0.04);
        basePlain2.setMaterial(material);
        basePlain2.setKr(0.8);
        scene.addGeometry(basePlain2);

        Quadrangle mirrorQuadrangle = new Quadrangle(new Point3D(-400, 380, -2000), new Point3D(-400, 700, -300),
                new Point3D(350, 750, -350), new Point3D(350, 430, -2050));
        mirrorQuadrangle.setEmmission(new Color(233, 228, 217));
        material = mirrorQuadrangle.getMaterial();
        material.set_NumOfReflectionRays(0);
        material.setBlurring(0.04);
        mirrorQuadrangle.setMaterial(material);
        mirrorQuadrangle.setKr(0.8);
        scene.addGeometry(mirrorQuadrangle);

        Quadrangle mirrorQuadrangle1 = new Quadrangle(new Point3D(-400, -780, -2000), new Point3D(-400, -1100, -300),
                 new Point3D(350, -1150, -350), new Point3D(350, -830, -2050));
        mirrorQuadrangle1.setEmmission(new Color(233, 228, 217));
        material = mirrorQuadrangle1.getMaterial();
        material.set_NumOfReflectionRays(0);
        material.setBlurring(0.04);
        mirrorQuadrangle1.setMaterial(material);
        mirrorQuadrangle1.setKr(0.8);
        scene.addGeometry(mirrorQuadrangle1);

        Sphere sphere = new Sphere(250, new Point3D(-150, 60, -1400));
        sphere.setShininess(20);
        sphere.setEmmission(new Color(207, 80, 157));
        material = sphere.getMaterial();
        material.set_NumOfReflectionRays(0);
        material.setBlurring(0.007);
        sphere.setMaterial(material);
        sphere.setKr(0.5);
        sphere.setKt(0);
        scene.addGeometry(sphere);

        Sphere sphere2 = new Sphere(200, new Point3D(-200, -450, -1100));
        sphere2.setShininess(20);
        sphere2.setEmmission(new Color(69, 98, 206));
        sphere2.setKt(0);
        sphere2.setKr(0.5);
        scene.addGeometry(sphere2);

        Sphere sphere3 = new Sphere(100, new Point3D(-300, 300, -750));
        sphere3.setShininess(25);
        sphere3.setEmmission(new Color(198, 194, 47));
        sphere3.setKr(0.5);
        scene.addGeometry(sphere3);

        Hemisphere2 hemisphere = new Hemisphere2(150, new Point3D(-250, 100, -450), new Vector(2,0,1));
        hemisphere.setShininess(20);
        hemisphere.setEmmission(new Color(14, 114, 13));
        material = hemisphere.getMaterial();
        material.set_NumOfReflectionRays(0);
        material.setBlurring(0.007);
        hemisphere.setMaterial(material);
        hemisphere.setKr(0);
        hemisphere.setKt(0);
        //scene.addGeometry(hemisphere);
        Sphere sphere01 = new Sphere(50, new Point3D(-350, -340, -820));
        sphere01.setShininess(20);
        sphere01.setEmmission(new Color(179, 60, 32));
        sphere01.setKt(0);
        sphere01.setKr(0.9);
        scene.addGeometry(sphere01);
        Sphere sphere02 = new Sphere(50, new Point3D(-350, -210, -565));
        sphere02.setShininess(20);
        sphere02.setEmmission(new Color(204, 201, 37));
        sphere02.setKt(0);
        sphere02.setKr(0.9);
        scene.addGeometry(sphere02);
        Sphere sphere03 = new Sphere(50, new Point3D(-350, -330, -630));
        sphere03.setShininess(20);
        sphere03.setEmmission(new Color(168, 53, 135));
        sphere03.setKt(0);
        sphere03.setKr(0.9);
        scene.addGeometry(sphere03);
        //scene.addLight(new PointLight(new Color(245, 175, 64), new Point3D(-300, -200, -750),0.01, 0.04, 0.07)); //inside the yelow sphare
        scene.addLight(new PointLight(new Color(179, 9, 7), new Point3D(2500, 350, -900),0, 0.0000001, 0.00000005));
//        scene.addLight(new DirectionalLight(new Color(255, 140, 120), new Vector(-10, -1, -2)));
        ImageWriter imageWriter = new ImageWriter("reflectedTest2", 500, 500, 500, 500);

        Render render = new Render(imageWriter, scene);

        render.renderImage();
        render.writeToImage();
    }




    @Test
    void ourSceneTest() throws Exception {

        Scene scene = new Scene();
        scene.setScreenDistance(500);
//        Plane plane = new Plane(new Vector(1,0, 0), new Point3D(-500,0, 0));
//        plane.setEmmission(new Color(20, 120, 93));
//        plane.setKr(0.95);
//        Material material = plane.getMaterial();
//        material.set_NumOfReflectionRays(5);
//        material.setReflectionSharpness(0.004);
//        plane.setMaterial(material);
//
//        scene.addGeometry(plane);
        Triangle triangle1 = new Triangle(new Point3D(  1050,  3500, 1000),
                new Point3D( 1050,  50, 1000),
                new Point3D(  1050, 50, -7000));
        triangle1.setShininess(20);
        triangle1.setEmmission(new Color(60, 20, 12));
        triangle1.setKt(0.1);
        triangle1.setKr(0.1);
        Triangle triangle2 = new Triangle(new Point3D(  1050,  -3500, 1000),
                new Point3D( 1050,  -50, 1000),
                new Point3D(  1050, -50, -7000));
        triangle2.setShininess(20);
        triangle2.setEmmission(new Color(60, 20, 12));
        triangle2.setKt(0.1);
        triangle2.setKr(0.1);
        scene.addGeometry(triangle1);
        scene.addGeometry(triangle2);
        Triangle triangle3 = new Triangle(new Point3D(  -1050,  3500, 1000),
                new Point3D( -1050,  50, 1000),
                new Point3D(  -1050, 50, -7000));
        triangle3.setShininess(20);
        triangle3.setEmmission(new Color(155, 53, 30));
        triangle3.setKt(0.1);
        triangle3.setKr(0.1);
        Triangle triangle4 = new Triangle(new Point3D(  -1050,  -3500, 1000),
                new Point3D( -1050,  -50, 1000),
                new Point3D(  -1050, -50, -7000));
        triangle4.setShininess(20);
        triangle4.setEmmission(new Color(155, 53, 30));
        triangle4.setKt(0.1);
        triangle4.setKr(0.1);
        scene.addGeometry(triangle3);
        scene.addGeometry(triangle4);
        Quadrangle quadrangle1 = new Quadrangle(new Point3D(  -1000,  -3500, 1000),
                new Point3D(  1000,  -3500, 1000),
                new Point3D(  1000, -50, -7000),
                new Point3D(  -1000, -50, -7000));
        quadrangle1.setShininess(20);
        quadrangle1.setKt(0.5);
        quadrangle1.setKr(0.5);
        scene.addGeometry(quadrangle1);
        Quadrangle quadrangle2 = new Quadrangle(new Point3D(  -1000,  3500, 1000),
                new Point3D(  1000,  3500, 1000),
                new Point3D(  1000, 50, -7000),
                new Point3D(  -1000, 50, -7000));
        quadrangle2.setShininess(20);
        quadrangle2.setKt(0.5);
        quadrangle2.setKr(0.5);
        scene.addGeometry(quadrangle2);
//        Plane plane1 = new Plane(new Vector(0,69/160,1), new Point3D(  -1050, 50, -7000));
//        plane1.setShininess(20);
//        plane1.setKt(0.5);
//        plane1.setKr(0.5);
//        scene.addGeometry(plane1);
        Sphere sphere1 = new Sphere(200, new Point3D(-850, 70, -2500));
        sphere1.setShininess(20);
        sphere1.setEmmission(new Color(0, 0, 0));
        sphere1.setKt(0.1);
        sphere1.setKr(0.9);
        scene.addGeometry(sphere1);

        Sphere sphere2 = new Sphere(200, new Point3D(-850, -580, -2650));
        sphere2.setShininess(20);
        sphere2.setEmmission(new Color(0, 0, 0));
        sphere2.setKt(0.1);
        sphere2.setKr(0.9);
        scene.addGeometry(sphere2);

        Sphere sphere3 = new Sphere(200, new Point3D(-850, 470, -2850));
        sphere3.setShininess(20);
        sphere3.setEmmission(new Color(0, 0, 0));
        sphere3.setKt(0.1);
        sphere3.setKr(0.9);

        scene.addGeometry(sphere3);

        Hemisphere2 hemisphere22 = new Hemisphere2(150, new Point3D(1050, 600, -4000), new Vector(1,0,0));
        hemisphere22.setShininess(20);
        hemisphere22.setEmmission(new Color(14, 150, 12));
        hemisphere22.setKt(0.1);
        hemisphere22.setKr(0.1);
        scene.addGeometry(hemisphere22);
        Hemisphere2 hemisphere23 = new Hemisphere2(150, new Point3D(1050, 900, -3000), new Vector(1,0,0));
        hemisphere23.setShininess(20);
        hemisphere23.setEmmission(new Color(14, 150, 12));
        hemisphere23.setKt(0.1);
        hemisphere23.setKr(0.1);
        scene.addGeometry(hemisphere23);
        Hemisphere2 hemisphere24 = new Hemisphere2(300, new Point3D(1050, 800, -2500), new Vector(1,0,0));
        hemisphere24.setShininess(20);
        hemisphere24.setEmmission(new Color(14, 150, 12));
        hemisphere24.setKt(0.1);
        hemisphere24.setKr(0.1);
        //scene.addGeometry(hemisphere24);
//        Hemisphere2 hemisphere25 = new Hemisphere2(300, new Point3D(0, -700, -2500), new Vector(0,2,1));
//        hemisphere25.setShininess(20);
//        hemisphere25.setEmmission(new Color(188, 31, 188));
//        hemisphere25.setKt(0.1);
//        hemisphere25.setKr(0.1);
//        scene.addGeometry(hemisphere25);
        scene.addVolumeLight(new SpotLight(new Color(105, 105, 105), new Point3D(400, 800, 50),
                new Vector(-2, -2, -3), 0, 0.000001, 0.0000005),5,5);

//        scene.addLight(new PointLight(new Color(255, 255, 255), new Point3D(705, 500, -4000),
//                0, 0.000001, 0.0000005));
//        scene.addVolumeLight(new PointLight(new Color(105, 105, 105), new Point3D(400, 500, -3000),
//                0, 0.000001, 0.0000005),5,5);
        ImageWriter imageWriter = new ImageWriter("ourSceneTest1", 500, 500, 500, 500);

        Render render = new Render(imageWriter, scene);

        render.renderImage();
        render.writeToImage();
    }
    @Test
    void ourSceneTest2()throws Exception{
        Scene scene = new Scene();
        scene.setScreenDistance(500);

        Sphere sphere0 = new Sphere(100, new Point3D(-950, 500, -3000));
        sphere0.setShininess(20);
        sphere0.setEmmission(new Color(24, 95, 12));
        sphere0.setKt(0.1);
        sphere0.setKr(0.9);
        scene.addGeometry(sphere0);
        Sphere sphere1 = new Sphere(100, new Point3D(-750, 500, -3000));
        sphere1.setShininess(20);
        sphere1.setEmmission(new Color(95, 17, 95));
        sphere1.setKt(0.1);
        sphere1.setKr(0.9);
        scene.addGeometry(sphere1);
        Sphere sphere2 = new Sphere(100, new Point3D(-550, 500, -3000));
        sphere2.setShininess(20);
        sphere2.setEmmission(new Color(104, 102, 58));
        sphere2.setKt(0.8);
        sphere2.setKr(0);
        scene.addGeometry(sphere2);
        Triangle triangle3 = new Triangle(new Point3D(  -1050,  3500, 1000),
                new Point3D( -1050,  50, 1000),
                new Point3D(  -1050, 50, -7000));
        triangle3.setShininess(20);
        triangle3.setEmmission(new Color(95, 22, 95));
        triangle3.setKt(0.1);
        triangle3.setKr(0.1);
        Triangle triangle4 = new Triangle(new Point3D(  -1050,  -3500, 1000),
                new Point3D( -1050,  -50, 1000),
                new Point3D(  -1050, -50, -7000));
        triangle4.setShininess(20);
        triangle4.setEmmission(new Color(95, 22, 95));
        triangle4.setKt(0.1);
        triangle4.setKr(0.1);
        scene.addGeometry(triangle3);
        scene.addGeometry(triangle4);

//        Plane plane1 = new Plane(new Vector(0,69/160,1), new Point3D(  -1050, 50, -7000));
//        plane1.setShininess(20);
//        plane1.setKt(0.5);
//        plane1.setKr(0.5);
//        scene.addGeometry(plane1);
        scene.addLight(new PointLight(new Color(255, 255, 255), new Point3D(1500, 1200, -1900),
                 0, 0.000001, 0.0000005));

        ImageWriter imageWriter = new ImageWriter("ourSceneTest2", 500, 500, 500, 500);

        Render render = new Render(imageWriter, scene);

        render.renderImage();
        render.writeToImage();
    }
}