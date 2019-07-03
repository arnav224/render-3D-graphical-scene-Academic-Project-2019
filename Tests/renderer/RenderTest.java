package renderer;

import geometries.*;
import org.junit.jupiter.api.Test;
import primitives.*;
import scene.*;
import elements.*;

import java.awt.*;

class RenderTest {

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


    @Test
    public void emmissionTest4() {
    }

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


        scene.addLight(new DirectionalLight(new Color(59, 255, 214), new Vector(-20, 0,0)));
        scene.addLight(new DirectionalLight(new Color(255, 145, 127), new Vector(-20, 5,7)));
        ImageWriter imageWriter = new ImageWriter("DirectionalLight_2", 500, 500, 500, 500);

        Render render = new Render(imageWriter, scene);

        render.renderImage();
        render.writeToImage();

    }



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


        Hemisphere hemisphere = new Hemisphere(650, new Point3D(-100.0, -0.0, -750), new Vector(13.0, 2.0, 1.5));
        hemisphere.setShininess(20);
        hemisphere.setEmmission(new Color(0, 10, 30));
        scene.addGeometry(hemisphere);


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
    public void MultipleEyeTest() throws Exception {

        Scene scene = new Scene();
        scene.setScreenDistance(300);

        Quadrangle quadrangle = new Quadrangle( new Point3D(250,-250, -300),new Point3D(250,250, -300),
                new Point3D(-250,250, -300), new Point3D(-500,-291, -300));
        quadrangle.setKt(1);
        Material material = quadrangle.getMaterial();
        material.set_NumOfReflectionRays(35);
        material.setBlurring(0.0045);
        quadrangle.setMaterial(material);
        scene.addGeometry(quadrangle);

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


        quadrangle = new Quadrangle(
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

        ImageWriter imageWriter = new ImageWriter("MultipleEyeTest", 500, 500, 500, 500);

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
        ImageWriter imageWriter = new ImageWriter("reflectedTest", 500, 500, 500, 500);

        Render render = new Render(imageWriter, scene);

        render.renderImage();
        render.writeToImage();
    }





    @Test
    void ourSceneTest() throws Exception {

        Scene scene = new Scene();
        scene.setScreenDistance(500);

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

        Hemisphere hemisphere22 = new Hemisphere(150, new Point3D(1050, 600, -4000), new Vector(1,0,0));
        hemisphere22.setShininess(20);
        hemisphere22.setEmmission(new Color(14, 150, 12));
        hemisphere22.setKt(0.1);
        hemisphere22.setKr(0.1);
        scene.addGeometry(hemisphere22);
        Hemisphere hemisphere23 = new Hemisphere(150, new Point3D(1050, 900, -3000), new Vector(1,0,0));
        hemisphere23.setShininess(20);
        hemisphere23.setEmmission(new Color(14, 150, 12));
        hemisphere23.setKt(0.1);
        hemisphere23.setKr(0.1);
        scene.addGeometry(hemisphere23);
        Hemisphere hemisphere24 = new Hemisphere(300, new Point3D(1050, 800, -2500), new Vector(1,0,0));
        hemisphere24.setShininess(20);
        hemisphere24.setEmmission(new Color(14, 150, 12));
        hemisphere24.setKt(0.1);
        hemisphere24.setKr(0.1);
        scene.addVolumeLight(new SpotLight(new Color(105, 105, 105), new Point3D(400, 800, 50),
                new Vector(-2, -2, -3), 0, 0.000001, 0.0000005),5,5);

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

        scene.addLight(new PointLight(new Color(255, 255, 255), new Point3D(1500, 1200, -1900),
                 0, 0.000001, 0.0000005));

        ImageWriter imageWriter = new ImageWriter("ourSceneTest2", 500, 500, 500, 500);

        Render render = new Render(imageWriter, scene);

        render.renderImage();
        render.writeToImage();
    }
    @Test
    void reflectedTest22() throws Exception
    {
        Scene scene = new Scene();
        scene.setScreenDistance(200);
        Plane backgroundPlain1 = new Plane(new Vector(3,0, -10), new Point3D(3000000,0, -10000000));
        backgroundPlain1.setEmmission(new Color(125, 71, 114));
        //scene.addGeometry(backgroundPlain1);
        Plane backgroundPlain2 = new Plane(new Vector(4,0, -10), new Point3D(7000000,0, -10000000));
        backgroundPlain2.setEmmission(new Color(125, 79, 69));
        //scene.addGeometry(backgroundPlain2);
        Plane backgroundPlain3 = new Plane(new Vector(2,0, -10), new Point3D(1000000,0, -10000000));
        backgroundPlain3.setEmmission(new Color(125, 25, 35));
        //scene.addGeometry(backgroundPlain3);

        Plane basePlain2 = new Plane(new Vector(1,0,0), new Point3D(-400,0,0));
        basePlain2.setEmmission(new Color(73, 27, 24));
        Material material = basePlain2.getMaterial();
        material.set_NumOfReflectionRays(20);
        material.setBlurring(0.04);
        basePlain2.setMaterial(material);
        basePlain2.setKr(0.8);
        scene.addGeometry(basePlain2);

        Quadrangle mirrorQuadrangle = new Quadrangle(new Point3D(-400, 380, -2000), new Point3D(-400, 700, -300),
                new Point3D(350, 750, -350), new Point3D(350, 430, -2050));
        mirrorQuadrangle.setEmmission(new Color(63, 63, 63));
        material = mirrorQuadrangle.getMaterial();
        material.set_NumOfReflectionRays(20);
        material.setBlurring(0.04);
        mirrorQuadrangle.setMaterial(material);
        mirrorQuadrangle.setKr(0.8);
        scene.addGeometry(mirrorQuadrangle);

        Sphere sphere = new Sphere(300, new Point3D(-100, 150, -1000));
        sphere.setShininess(20);
        sphere.setEmmission(new Color(96, 31, 80));
        material = sphere.getMaterial();
        material.set_NumOfReflectionRays(0);
        material.setBlurring(0.007);
        sphere.setMaterial(material);
        scene.addGeometry(sphere);
        Sphere sphere2 = new Sphere(200, new Point3D(-200, -450, -1000));
        sphere2.setShininess(20);
        sphere2.setEmmission(new Color(35, 48, 107));
        sphere2.setKt(0);
        sphere2.setKr(0);
        scene.addGeometry(sphere2);
        Sphere sphere3 = new Sphere(100, new Point3D(-300, -200, -750));
        sphere3.setShininess(20);
        sphere3.setEmmission(new Color(96, 94, 21));
        scene.addGeometry(sphere3);

//        scene.addVolumeLight(new SpotLight(new Color(26, 10, 10), new Point3D(200, 200, -100),
//                new Vector(-10, 8, 2), 0, 0.0001, 0.0000005), 100, 10);


//        scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(150, -200, -350),
//                new Vector(-10,0,0), 0, 0.000001, 0.000005));

//        scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(370, -350, -700),
//                new Vector(-10, 0,8), 0, 0.00001, 0.000005));

        scene.addLight(new PointLight(new Color(245, 175, 64),  new Point3D(200, -200, -100),0, 0.0000004, 0.0000007)); //inside the yelow sphare
//        scene.addLight(new PointLight(new Color(231, 224, 255), new Point3D(2500, 350, -900),0, 0.000001, 0.0000005));
//        scene.addLight(new DirectionalLight(new Color(255, 140, 120), new Vector(-10, -1, -2)));
        ImageWriter imageWriter = new ImageWriter("reflectedTest22", 500, 500, 500, 500);
        Render render = new Render(imageWriter, scene);
        render.renderImage();
        render.writeToImage();    }

    @Test
    void reflectedTest3() throws Exception{
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


        Triangle triangle = new Triangle(new Point3D(  -300, 3000, 0),
                new Point3D( -300,  -3000, 0),
                new Point3D(  -300,  0, -8000));
        Material material = triangle.getMaterial();
        material.set_NumOfReflectionRays(20);
        material.setBlurring(0.04);
        triangle.setMaterial(material);
        triangle.setEmmission(new Color(20, 20, 20));
        triangle.setKr(1);
        scene.addGeometry(triangle);

        scene.addLight(new SpotLight(new Color(255, 100, 100),  new Point3D(500, 200, -1000),
                new Vector(-2, -2, -3), 0, 0.00001, 0.000005));
        scene.addLight(new SpotLight(new Color(237, 171, 59),  new Point3D(350, -300, -800),
                new Vector(-2, 5, -3), 0, 0.00001, 0.000005));

        ImageWriter imageWriter = new ImageWriter("reflectedTest3", 500, 500, 500, 500);

        Render render = new Render(imageWriter, scene);

        render.renderImage();
        render.writeToImage();

    }


    @Test
    void reflectedTest2_2() throws Exception
    {
        Scene scene = new Scene();
        scene.setScreenDistance(200);

        Plane backgroundPlain1 = new Plane(new Vector(3,0, -10), new Point3D(3000,0, -10000));
        backgroundPlain1.setEmmission(new Color(125, 71, 114));
        backgroundPlain1.setKt(0.5);
        scene.addGeometry(backgroundPlain1);

        Plane backgroundPlain2 = new Plane(new Vector(4,0, -10), new Point3D(7000,0, -10000));
        backgroundPlain2.setEmmission(new Color(125, 79, 69));
        backgroundPlain2.setKt(0.5);
        scene.addGeometry(backgroundPlain2);

        Plane backgroundPlain3 = new Plane(new Vector(2,0, -10), new Point3D(1000,0, -10000));
        backgroundPlain3.setEmmission(new Color(125, 25, 35));
        backgroundPlain3.setKt(0.5);
        scene.addGeometry(backgroundPlain3);

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
        //scene.addGeometry(mirrorQuadrangle1);

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

        Sphere sphere01 = new Sphere(50, new Point3D(-350, -340, -820));
        sphere01.setShininess(20);
        sphere01.setEmmission(new Color(179, 60, 32));
        sphere01.setKt(0);
        sphere01.setKr(0.9);
        //scene.addGeometry(sphere01);
        Sphere sphere02 = new Sphere(50, new Point3D(-350, -210, -565));
        sphere02.setShininess(20);
        sphere02.setEmmission(new Color(204, 201, 37));
        sphere02.setKt(0);
        sphere02.setKr(0.9);
        //scene.addGeometry(sphere02);
        Sphere sphere03 = new Sphere(50, new Point3D(-350, -330, -630));
        sphere03.setShininess(20);
        sphere03.setEmmission(new Color(168, 53, 135));
        sphere03.setKt(0);
        sphere03.setKr(0.9);
        //scene.addGeometry(sphere03);
        scene.addLight(new PointLight(new Color(245, 175, 64), new Point3D(-300, -200, -750),0.01, 0.04, 0.07)); //inside the yelow sphare
        scene.addLight(new PointLight(new Color(233, 203, 232), new Point3D(2500, 350, -900),0, 0.0000001, 0.00000005));
        scene.addLight(new DirectionalLight(new Color(255, 140, 120), new Vector(-10, -1, -2)));
        ImageWriter imageWriter = new ImageWriter("reflectedTest2_2", 500, 500, 500, 500);

        Render render = new Render(imageWriter, scene);

        render.renderImage();
        render.writeToImage();
    }

    @Test
    void reflectedTest3_3() throws Exception{
        Scene scene = new Scene();
        scene.setScreenDistance(200);
        Plane backgroundPlain1 = new Plane(new Vector(0,0, -10), new Point3D(3000,0, -10000));
        backgroundPlain1.setEmmission(new Color(204, 201, 37));
        //scene.addGeometry(backgroundPlain1);

        Sphere sphere0 = new Sphere(300, new Point3D(0, 0, -1000));
        sphere0.setShininess(20);
        sphere0.setEmmission(new Color(120, 47, 90));
        sphere0.setKt(0.8);
        scene.addGeometry(sphere0);

        Sphere sphere2 = new Sphere(150, new Point3D(150, 200, -1000));
        sphere2.setShininess(20);
        sphere2.setEmmission(new Color(156, 139, 34));
        sphere2.setKt(0.2);
        scene.addGeometry(sphere2);
        Sphere sphere1 = new Sphere(150, new Point3D(-160, -500, -1200));
        sphere1.setShininess(20);
        sphere1.setEmmission(new Color(40, 81, 112));
        sphere1.setKt(0.3);
        scene.addGeometry(sphere1);

        Triangle triangle = new Triangle(new Point3D(  -313, 3000, 0),
                new Point3D( -313,  -3000, 0),
                new Point3D(  -313,  0, -8000));
        Material material = triangle.getMaterial();
        material.set_NumOfReflectionRays(400);
        material.setBlurring(0.04);
        triangle.setMaterial(material);
        triangle.setEmmission(new Color(20, 20, 20));
        triangle.setKr(1);
        scene.addGeometry(triangle);

        scene.addLight(new SpotLight(new Color(255, 100, 100),  new Point3D(500, 200, -1000),
                new Vector(-2, -2, -3), 0, 0.00001, 0.000005));
        scene.addLight(new SpotLight(new Color(237, 171, 59),  new Point3D(350, -300, -800),
                new Vector(-2, 5, -3), 0, 0.00001, 0.000005));

        ImageWriter imageWriter = new ImageWriter("reflectedTest3_3", 500, 500, 500, 500);

        Render render = new Render(imageWriter, scene);

        render.renderImage();
        render.writeToImage();

    }

}