//package renderer;
//
//        import geometries.*;
//        import org.junit.jupiter.api.Test;
//        import primitives.*;
//        import scene.*;
//        import elements.*;
//
//        import java.awt.*;
//
//
//        import org.junit.jupiter.api.Test;
//
//        import elements.AmbientLight;
//        import elements.Camera;
//        import elements.PointLight;
//        import elements.SpotLight;
//        import geometries.Plane;
//        import geometries.Sphere;
//        import geometries.Triangle;
//        import primitives.Color;
//        import primitives.Material;
//        import primitives.Point3D;
//        import primitives.Vector;
//        import renderer.ImageWriter;
//        import renderer.Render;
//        import scene.Scene;
//
//class Tests2 {
//
//
//    /**
//     * testing the scenes representing in the lecturer like shadow and point test or spot test
//     *
//     * @throws Exception
//     */
//    @Test
//    public void Test_finalMat() throws Exception {
//        Scene scene = new Scene("dark room");
//        scene.setDistance(5500);
//        scene.setAmbientLight(new AmbientLight(new Color(), 0));
//
//        Sphere sphere = new Sphere(200, new Point3D(1200, -400, 0), new Color(0, 0, 50),
//                new Material(0.1, 5, 29, 1, 0, 1, 0));
//        scene.addGeometry(sphere); // blue left
//
//        sphere = new Sphere(100, new Point3D(1200, 100, -100), new Color(), new Material(0.1, 5, 29, 1, 0, 1, 0));
//        scene.addGeometry(sphere); // black center
//
//        sphere = new Sphere(150, new Point3D(1200, 600, -50), new Color(50, 50, 50),
//                new Material(0.1, 5, 29, 1, 0, 1, 0));
//        scene.addGeometry(sphere); // gray right
//
//        sphere = new Sphere(150, new Point3D(1500, -100, -50), new Color(50, 0, 0),
//                new Material(0.1, 5, 29, 0.7, 0, 1, 0));
//        scene.addGeometry(sphere); // red center
//
//        sphere = new Sphere(100, new Point3D(1800, -250, -100), new Color(0, 50, 0),
//                new Material(0.1, 5, 29, 0, 0, 1, 0));
//        scene.addGeometry(sphere); // green left
//
//        sphere = new Sphere(300, new Point3D(2000, 500, 100), new Color(0, 50, 100),
//                new Material(0.1, 5, 29, 1, 0, 1, 0));
//        scene.addGeometry(sphere); // purple big right
//
//        sphere = new Sphere(80, new Point3D(2000, 200, -120), new Color(50, 50, 0),
//                new Material(0.1, 5, 29, 0, 0, 1, 0));
//        scene.addGeometry(sphere); // yellow right
//
//        Plane plane = new Plane(new Point3D(0, 0, -200), new Vector(0, 0, 1), new Color(0, 0, 0),
//                new Material(3, 4, 19, 0, 0, 1, 0));
//        scene.addGeometry(plane); // floor
//
//        scene.addLight(new SpotLight(new Point3D(0, -1000, 1000), 1, 0.00001, 0.0000005, new Color(100, 100, 150),
//                new Vector(5, 2, -4)));
//        scene.addLight(new SpotLight(new Point3D(0, 1000, 1000), 1, 0.00001, 0.0000005, new Color(150, 100, 150),
//                new Vector(5, -2, -4)));
//
//        scene.setCamera(new Camera(new Point3D(-10500, 0, 100), new Vector(0, 0, 1), new Vector(1, 0, 0)));
//        ImageWriter imageWriter = new ImageWriter("dark room", 800, 800, 800, 800);
//        Render render = new Render(imageWriter, scene);
//
//        render.renderImage();
//        render.writeToImage();
//    }
//    @Test
//    public void Test_MyfinalMat() throws Exception {
//        Scene scene = new Scene("my dark room");
//        scene.setDistance(5500);
//        scene.setAmbientLight(new AmbientLight(new Color(10,0,10), 0.5));
//
//        Sphere sphere = new Sphere(200, new Point3D(-400, 0, -1200), new Color(0, 0, 50),
//                new Material(0.1, 5, 29, 1, 0, 1, 0));
//        scene.addGeometry(sphere); // blue left
//
//        sphere = new Sphere(100, new Point3D(100, -100, -1000), new Color(), new Material(0.1, 5, 29, 1, 0.5, 1, 0));
//        scene.addGeometry(sphere); // black center
//        scene.addLight(new PointLight(new Point3D(100, -150, -1000), 2, 0.000001, 0.0000005, new Color(180, 180, 180))); //light in sphere
//
//        // test version 1
//        //sphere = new Sphere(1200, new Point3D(0, -200, -1000), new Color(), new Material(0.1, 5, 29, 1, 0.5, 1, 0));
//        //scene.addGeometry(sphere); // black center
//        //scene.addLight(new PointLight(new Point3D(0, -200, -1000), 2, 0.000001, 0.0000005, new Color(150, 150, 150))); //light in sphere
//
//
//        sphere = new Sphere(150, new Point3D(600, -50, -1200), new Color(0, 0, 0),
//                new Material(0.1, 5, 29, 1, 0, 1, 0));
//        scene.addGeometry(sphere); // black left
//
//        sphere = new Sphere(150, new Point3D(-100, -50, -1500), new Color(70, 0, 0),
//                new Material(0.1, 5, 29, 0.7, 0.1, 1, 0));
//        scene.addGeometry(sphere); // red center
//
//        sphere = new Sphere(100, new Point3D(-250, -100, -1800), new Color(0, 50, 0),
//                new Material(0.1, 5, 29, 0, 0, 1, 0));
//        //scene.addGeometry(sphere); // green left
//
//        sphere = new Sphere(300, new Point3D(500, 100, -2000), new Color(85, 70, 0),
//                new Material(0.1, 5, 29, 0.6, 0.4, 1, 0));
//        scene.addGeometry(sphere); // yellow big
//
//        scene.addLight(new PointLight(new Point3D(500, 100, -2000), 2, 0.000001, 0.0000005, new Color(10, 10, 10))); //light in sphere
//
//
//        sphere = new Sphere(80, new Point3D(200, -120, -2000), new Color(50, 50, 0),
//                new Material(0.1, 5, 29, 0, 0, 1, 0));
//        //scene.addGeometry(sphere); // yellow right
//
//		/*Triangle triangle= new Triangle(new Point3D(0, 200,-1000),new Point3D(-100, 0,-1000),new Point3D(100, 0,-1000),new Color(50,0,0),new Material(0.1,5,29,0,0.5,1,0));
//		scene.addGeometry(triangle);
//		triangle= new Triangle(new Point3D(-100, 0,-1000),new Point3D(100, 0,-1000),new Point3D(0, -200,-1000),new Color(0,50,0),new Material(0.1,5,29,0,0.5,1,0.5));
//		scene.addGeometry(triangle);
//		triangle= new Triangle(new Point3D(-200, -200,-1000),new Point3D(0, -200,-1000),new Point3D(-100, 0,-1000),new Color(0,0,50),new Material(0.1,5,29,0,0.5,1,0));
//		scene.addGeometry(triangle);
//		triangle= new Triangle(new Point3D(100, 0,-1000),new Point3D(0, -200,-1000),new Point3D(200, -200,-1000),new Color(50,0,50),new Material(0.1,5,29,0,0.5,1,0));
//		scene.addGeometry(triangle);
//		//******************triangle up opossite
//		triangle= new Triangle(new Point3D(0, 200,-1000),new Point3D(-100, 400,-1000),new Point3D(100, 400,-1000),new Color(0,50,50),new Material(0.1,5,29,0,0.5,1,0));
//		scene.addGeometry(triangle);
//		triangle= new Triangle(new Point3D(0, 600,-1000),new Point3D(-100, 400,-1000),new Point3D(100, 400,-1000),new Color(0,50,50),new Material(0.1,5,29,0,0.5,1,0));
//		scene.addGeometry(triangle);
//		triangle= new Triangle(new Point3D(0, 600,-1000),new Point3D(-100, 400,-1000),new Point3D(-200, 600,-1000),new Color(0,50,50),new Material(0.1,5,29,0,0.5,1,0));
//		scene.addGeometry(triangle);
//		triangle= new Triangle(new Point3D(0, 600,-1000),new Point3D(100, 400,-1000),new Point3D(200, 600,-1000),new Color(0,50,50),new Material(0.1,5,29,0,0.5,1,0));
//		scene.addGeometry(triangle);
//		triangle= new Triangle(new Point3D(200, 200,-1000),new Point3D(0, 200,-1000),new Point3D(100, 0,-1000),new Color(0,50,50),new Material(0.1,5,29,0,0.5,1,0));
//		scene.addGeometry(triangle);
//*/
//
//        Plane plane = new Plane(new Point3D(0, -200, 0), new Vector(0, 1, 0), new Color(0, 0, 0),
//                new Material(3, 4, 19, 0.8, 0, 0.9, 0));
//        scene.addGeometry(plane); // floor
//
//        scene.addLight(new SpotLight(new Point3D(-1000, 2000, -3000), 1, 0.00001, 0.0000005, new Color(150, 150, 250),
//                new Vector(0.5, 2, 1)));
//        //scene.addLight(new SpotLight(new Point3D(1000, 1000, 0), 1, 0.00001, 0.0000005, new Color(150, 100, 150),
//        //new Vector(5, -2, -4)));
//
//
//        //stars
//
//        //sphere = new Sphere(5, new Point3D(-500, 400, -500), new Color(), new Material(0.1, 5, 29, 1, 0.5, 1, 0));
//        //scene.addGeometry(sphere); // black center
//		/*for(int i=-8; i<8; i++)
//		{
//			for(int j=0; j<6; j++)
//			{
//				sphere = new Sphere(10, new Point3D(i*50, j*50, -1000), new Color(255,255,200), new Material(0.1, 5, 29, 1, 0.1, 1, 0));
//				//scene.addGeometry(sphere);
//				scene.addLight(new PointLight(new Point3D(i*50, j*50, -1000), 2, 0.000001, 0.0000005, new Color(2, 2, 1)));
//			}
//		}*/
//        //scene.addLight(new PointLight(new Point3D(-500, 400, -500), 2, 0.000001, 0.0000005, new Color(20, 20, 20))); //light in sphere
//
//        //sphere = new Sphere(5, new Point3D(400, 500, -1000), new Color(), new Material(0.1, 5, 29, 1, 0.2, 1, 0));
//        //scene.addGeometry(sphere); // black center
//        //scene.addLight(new PointLight(new Point3D(400, 500, -1000), 2, 0.000001, 0.0000005, new Color(20, 20, 20))); //light in sphere
//
//        //sphere = new Sphere(5, new Point3D(-300, 600, -1000), new Color(), new Material(0.1, 5, 29, 1, 0.8, 1, 0));
//        //scene.addGeometry(sphere); // black center
//        //scene.addLight(new PointLight(new Point3D(-300, 600, -1000), 2, 0.000001, 0.0000005, new Color(20, 20, 20))); //light in sphere
//
//        //sphere = new Sphere(5, new Point3D(-200, 500, -800), new Color(), new Material(0.1, 5, 29, 1, 0.5, 1, 0));
//        //scene.addGeometry(sphere); // black center
//        //scene.addLight(new PointLight(new Point3D(-200, 500, -800), 2, 0.000001, 0.0000005, new Color(20, 20, 20))); //light in sphere
//
//        //sphere = new Sphere(5, new Point3D(-500, -300, -700), new Color(), new Material(0.1, 5, 29, 1, 0.5, 1, 0));
//        //scene.addGeometry(sphere); // black center
//        //scene.addLight(new PointLight(new Point3D(-500, -300, -700), 2, 0.000001, 0.0000005, new Color(20, 20, 20))); //light in sphere
//
//        //sphere = new Sphere(5, new Point3D(-400, 500, -400), new Color(), new Material(0.1, 5, 29, 1, 0.5, 1, 0));
//        //scene.addGeometry(sphere); // black center
//        //scene.addLight(new PointLight(new Point3D(-400, 500, -400), 2, 0.000001, 0.0000005, new Color(20, 20, 20))); //light in sphere
//
//
//        scene.setCamera(new Camera(new Point3D(0, 0, 10000), new Vector(0, 1, 0), new Vector(0, 0, -1)));
//        ImageWriter imageWriter = new ImageWriter("my dark room", 800, 800, 800, 800);
//        Render render = new Render(imageWriter, scene);
//
//        render.renderImage();
//        render.writeToImage();
//    }
//
//
//    @Test
//    public void Test_MyTriangles() throws Exception {
//        Scene scene = new Scene("my triangles ");
//        scene.setDistance(5500);
//        scene.setAmbientLight(new AmbientLight(new Color(20,0,20), 0.5));
//
//
//
//		/*Triangle triangle= new Triangle(new Point3D(0, 200,-1000),new Point3D(-100, 0,-1000),new Point3D(100, 0,-1000),new Color(50,0,0),new Material(0.1,5,29,0,0.5,1,0));
//		scene.addGeometry(triangle);
//		triangle= new Triangle(new Point3D(-100, 0,-1000),new Point3D(100, 0,-1000),new Point3D(0, -200,-1000),new Color(0,50,0),new Material(0.1,5,29,0,0.5,1,0.5));
//		scene.addGeometry(triangle);
//		triangle= new Triangle(new Point3D(-200, -200,-1000),new Point3D(0, -200,-1000),new Point3D(-100, 0,-1000),new Color(0,0,50),new Material(0.1,5,29,0,0.5,1,0));
//		scene.addGeometry(triangle);
//		triangle= new Triangle(new Point3D(100, 0,-1000),new Point3D(0, -200,-1000),new Point3D(200, -200,-1000),new Color(50,0,50),new Material(0.1,5,29,0,0.5,1,0));
//		scene.addGeometry(triangle);
//		//******************triangle up opossite
//		triangle= new Triangle(new Point3D(0, 200,-1000),new Point3D(-100, 400,-1000),new Point3D(100, 400,-1000),new Color(0,50,50),new Material(0.1,5,29,0,0.5,1,0));
//		scene.addGeometry(triangle);
//		triangle= new Triangle(new Point3D(0, 600,-1000),new Point3D(-100, 400,-1000),new Point3D(100, 400,-1000),new Color(0,50,50),new Material(0.1,5,29,0,0.5,1,0));
//		scene.addGeometry(triangle);
//		triangle= new Triangle(new Point3D(0, 600,-1000),new Point3D(-100, 400,-1000),new Point3D(-200, 600,-1000),new Color(0,50,50),new Material(0.1,5,29,0,0.5,1,0));
//		scene.addGeometry(triangle);
//		triangle= new Triangle(new Point3D(0, 600,-1000),new Point3D(100, 400,-1000),new Point3D(200, 600,-1000),new Color(0,50,50),new Material(0.1,5,29,0,0.5,1,0));
//		scene.addGeometry(triangle);
//		triangle= new Triangle(new Point3D(200, 200,-1000),new Point3D(0, 200,-1000),new Point3D(100, 0,-1000),new Color(0,50,50),new Material(0.1,5,29,0,0.5,1,0));
//		scene.addGeometry(triangle);
//*/
//
//        Plane plane = new Plane(new Point3D(0, -500, 0), new Vector(0, 1, 0), new Color(0, 0, 0),
//                new Material(3, 4, 19, 1, 0, 1, 0));
//        scene.addGeometry(plane); // floor
//
//        scene.addLight(new SpotLight(new Point3D(-1000, 2000, -3000), 1, 0.00001, 0.0000005, new Color(150, 255, 250),
//                new Vector(0.5, 2, 1)));
//        //scene.addLight(new SpotLight(new Point3D(1000, 1000, 0), 1, 0.00001, 0.0000005, new Color(150, 100, 150),
//        //new Vector(5, -2, -4)));
//
//
//
//
//
//
//        Triangle triangle= new Triangle(new Point3D(0, 0,-1000),new Point3D(250, -500,-1000),new Point3D(-250, -500,-1000),new Color(255,0,0),new Material(0.1,5,29,0,0.5,1,0));
//        scene.addGeometry(triangle);
//        triangle= new Triangle(new Point3D(0, 0,-1000),new Point3D(250, -500,-1500),new Point3D(250, -500,-1000),new Color(0,50,0),new Material(0.1,5,29,0,0,1,0.5));
//        scene.addGeometry(triangle);
//        triangle= new Triangle(new Point3D(0, 0,-1000),new Point3D(-250, -500,-1500),new Point3D(-250, -500,-1000),new Color(0,0,255),new Material(0.1,5,29,0,0,1,0));
//        scene.addGeometry(triangle);
//        triangle= new Triangle(new Point3D(0, 0,-1000),new Point3D(250, -500,-1500),new Point3D(250, -500,-1500),new Color(255,0,255),new Material(0.1,5,29,0,0,1,0));
//        scene.addGeometry(triangle);
//
//        scene.setCamera(new Camera(new Point3D(0, 0, 10000), new Vector(0, 1, 0), new Vector(0, 0, -1)));
//        ImageWriter imageWriter = new ImageWriter("my triangles", 800, 800, 800, 800);
//        Render render = new Render(imageWriter, scene);
//        render.renderImage();
//        render.writeToImage();
//
//    }
//    /**
//     * test the spot light in a position with 2 spheres
//     */
//    @Test
//    public void many_spheres_Test() throws Exception {
//
//        Scene scene = new Scene("many spheres");
//        Sphere sphere = new Sphere(800, new Point3D(0, 0, -1000), new Color(0, 0, 100), new Material(2, 3, 20));
//        scene.addGeometry(sphere);
//
//        sphere = new Sphere(300, new Point3D(0, 0, -400), new Color(200, 0, 0), new Material(2, 3, 20));
//        scene.addGeometry(sphere);
//
//        scene.addLight(new SpotLight(new Point3D(-200, -200, -100), 1, 0.00001, 0.000005, new Color(255, 100, 100),
//                new Vector(2, 2, -3)));
//
//        scene.setCamera(new Camera(new Point3D(0, 0, 0), new Vector(-1, 0, 0), new Vector(0, 0, -1)));
//
//        ImageWriter imageWriter = new ImageWriter("many spheres", 500, 500, 500, 500);
//
//        Render render = new Render(imageWriter, scene);
//
//        render.renderImage();
//        render.writeToImage();
//    }
//
//    /**
//     * another test of point light
//     *
//     * @throws Exception
//     */
//
//
//
//    @Test
//    public void test_pointLight() throws Exception {
//        Scene myScene = new Scene("s");
//
//        Triangle first = new Triangle(new Point3D(3500, 3500, -2000), new Point3D(-3500, -3500, -2000),
//                new Point3D(3500, -3500, -2000), new Color(), new Material(1, 1, 1));
//
//        Triangle second = new Triangle(new Point3D(3500, 3500, -2000), new Point3D(-3500, 3500, -2000),
//                new Point3D(-3500, -3500, -2000), new Color(), new Material(1, 1, 1));
//
//        Sphere third = new Sphere(800, new Point3D(0, 0, -1000), new Color(0, 0, 100), new Material(1, 1, 20));
//
//        myScene.addGeometry(first);
//        myScene.addGeometry(second);
//        myScene.addGeometry(third);
//
//        Camera camera = new Camera(new Point3D(0, 0, 10), new Vector(1, 0, 0), new Vector(0, 0, -1));
//        myScene.setCamera(camera);
//        myScene.setDistance(100);
//
//        PointLight pl = new PointLight(new Point3D(200, 200, -100), 1, 0.000001, 0.0000005, new Color(255, 100, 100));
//        myScene.addLight(pl);
//
//        ImageWriter sceneWriter = new ImageWriter("point test 2", 500, 500, 500, 500);
//        Render myRender = new Render(sceneWriter, myScene);
//
//        myRender.renderImage();
//        myRender.writeToImage();
//    }
//
//    /**
//     * test the spot light in a position with 2 spheres
//     */
//    @Test
//    public void many_spheres_Test2() throws Exception {
//
//        Scene scene = new Scene("test spot");
//        Sphere sphere = new Sphere(800, new Point3D(1000, 0, 0), new Color(0, 0, 100), new Material(2, 3, 20));
//        scene.addGeometry(sphere);
//
//        sphere = new Sphere(300, new Point3D(400, -100, 0), new Color(200, 0, 0), new Material(2, 3, 20, 0, 0.5));
//        scene.addGeometry(sphere);
//
//        scene.addLight(new SpotLight(new Point3D(100, -200, 200), 1, 0.00001, 0.000005, new Color(255, 100, 100),
//                new Vector(2, 2, -3)));
//
//        scene.setCamera(new Camera(new Point3D(0, 0, 0), new Vector(0, 0, 1), new Vector(1, 0, 0)));
//
//        ImageWriter imageWriter = new ImageWriter("many spheres 2", 500, 500, 500, 500);
//
//        Render render = new Render(imageWriter, scene);
//
//        render.renderImage();
//        render.writeToImage();
//    }
//
//    /**
//     * checks the checks the spot light on 2 triangles
//     */
//    @Test
//    public void test_spotLight() throws Exception {
//        Scene myScene = new Scene("triangles with spot light");
//
//        Triangle first = new Triangle(new Point3D(3500, 3500, -2000), new Point3D(-3500, -3500, -1000),
//                new Point3D(3500, -3500, -2000), new Color(), new Material(4, 3, 5));
//
//        Triangle second = new Triangle(new Point3D(3500, 3500, -2000), new Point3D(-3500, 3500, -1000),
//                new Point3D(-3500, -3500, -1000), new Color(), new Material(4, 3, 5));
//
//        myScene.addGeometry(first);
//        myScene.addGeometry(second);
//
//        Camera camera = new Camera(new Point3D(0, 0, 10), new Vector(1, 0, 0), new Vector(0, 0, -1));
//        myScene.setCamera(camera);
//        myScene.setDistance(100);
//
//        SpotLight mySpotLight = new SpotLight(new Point3D(200, 200, -100), 1, 0.000001, 0.0000005,
//                new Color(255, 100, 100), new Vector(-2, -2, -3));
//        myScene.addLight(mySpotLight);
//
//        ImageWriter sceneWriter = new ImageWriter("spot test 3", 500, 500, 500, 500);
//        Render myRender = new Render(sceneWriter, myScene);
//
//        myRender.renderImage();
//        myRender.writeToImage();
//    }
//
//    /**
//     * test the spot light in a position
//     */
//    @Test
//    public void spotLightTest() throws Exception {
//
//        Scene scene = new Scene("test spot");
//        Sphere sphere = new Sphere(800, new Point3D(0.0, 0.0, -1000), new Color(0, 0, 100), new Material(1, 1, 20));
//        scene.addGeometry(sphere);
//        scene.addLight(new SpotLight(new Point3D(-200, -200, -100), 1, 0.00001, 0.000005, new Color(255, 100, 100),
//                new Vector(2, 2, -3)));
//
//        scene.setCamera(new Camera(new Point3D(0, 0, 0), new Vector(-1, 0, 0), new Vector(0, 0, -1)));
//
//        ImageWriter imageWriter = new ImageWriter("Spot test", 500, 500, 500, 500);
//
//        Render render = new Render(imageWriter, scene);
//
//        render.renderImage();
//        render.writeToImage();
//    }
//
//    /**
//     * test the point light in a position
//     */
//    @Test
//    public void Test_pointLight() throws Exception {
//        Scene scene = new Scene("Test scene");
//        scene.setCamera(new Camera(new Point3D(0, 0, 10), new Vector(1, 0, 0), new Vector(0, 0, -1)));
//        scene.setDistance(100);
//
//        scene.addLight(new PointLight(new Point3D(-200, -200, -100), 2, 0.000001, 0.0000005, new Color(255, 100, 100)));
//
//        Sphere s = new Sphere(800, new Point3D(0, 0, -1000), new Color(0, 0, 100), new Material(2, 3, 20));
//        scene.addGeometry(s);
//
//        ImageWriter imageWriter = new ImageWriter(" Point Test", 500, 500, 500, 500);
//        Render render = new Render(imageWriter, scene);
//
//        render.renderImage();
//        render.writeToImage();
//    }
//    @Test
//    public void Test_pointLight_lamp() throws Exception {
//        Scene scene = new Scene("Test lamp");
//        scene.setCamera(new Camera(new Point3D(0, 0, 0), new Vector(-1, 0, 0), new Vector(0, 0, -1)));
//        scene.setDistance(250);
//
//        scene.addLight(new PointLight(new Point3D(-2000, 0, -3500), 2, 0.000001, 0.0000005, new Color(255, 100, 255)));
//
//        Sphere s = new Sphere(500, new Point3D(-2000, 0, -3500), new Color(50, 50, 50), new Material(2, 3, 20,0,0.5));
//        scene.addGeometry(s);
//        Sphere s1 = new Sphere(600, new Point3D(500, 1500, -3500), new Color(0, 0, 100), new Material(2, 3, 20));
//        scene.addGeometry(s1);
//        Sphere s2 = new Sphere(600, new Point3D(500, 0, -3500), new Color(0, 100, 0), new Material(2, 3, 20));
//        scene.addGeometry(s2);
//        Sphere s3 = new Sphere(600, new Point3D(500, -1500, -3500), new Color(100, 0, 0), new Material(2, 3, 20));
//        scene.addGeometry(s3);
//        //Plane p = new Plane(new Point3D(800,0,-3500),new Vector(new Point3D(0,1,0)), new Color(150,100,100),new Material(1,1,20));
//        //scene.addGeometry(p);
//        ImageWriter imageWriter = new ImageWriter(" Point Lamp Test", 500, 500, 500, 500);
//        Render render = new Render(imageWriter, scene);
//
//        render.renderImage();
//        render.writeToImage();
//    }
//    /**
//     * tests spot & point light
//     *
//     * @throws Exception
//     */
//    @Test
//    public void Test_spotAndPointLight() throws Exception {
//
//        Scene scene = new Scene("test spot");
//        Sphere sphere = new Sphere(800, new Point3D(0.0, 0.0, -1000), new Color(0, 0, 100), new Material(1, 1, 20));
//        scene.addGeometry(sphere);
//
//        scene.addLight(new SpotLight(new Point3D(-200, -200, -100), 1, 0.00001, 0.000005, new Color(0, 100, 250),
//                new Vector(2, 2, -3)));
//
//        PointLight pl = new PointLight(new Point3D(200, 200, -100), 1, 0.000001, 0.0000005, new Color(255, 0, 0));
//        scene.addLight(pl);
//
//        scene.setCamera(new Camera(new Point3D(0, 0, 0), new Vector(-1, 0, 0), new Vector(0, 0, -1)));
//
//        ImageWriter imageWriter = new ImageWriter("Spot & point test", 500, 500, 500, 500);
//
//        Render render = new Render(imageWriter, scene);
//
//        render.renderImage();
//        render.writeToImage();
//
//    }
//
//    /**
//     * triangle shadow on a sphere
//     *
//     * @throws Exception
//     */
//    @Test
//    public void spotLightTest2() throws Exception {
//
//        Scene scene = new Scene("shadow");
//        scene.setDistance(200);
//        Sphere sphere = new Sphere(500, new Point3D(0.0, 0.0, -1000), new Color(0, 0, 100), new Material(1, 1, 20));
//        scene.addGeometry(sphere);
//
//        Triangle triangle = new Triangle(new Point3D(-125, -225, -260), new Point3D(-225, -125, -260),
//                new Point3D(-225, -225, -270), new Color(0, 0, 100), new Material(1, 1, 4));
//        scene.addGeometry(triangle);
//
//        scene.addLight(new SpotLight(new Point3D(-200, -200, -150), 1, 0.00001, 0.000005, new Color(255, 100, 100),
//                new Vector(2, 2, -3)));
//
//        Camera camera = new Camera(new Point3D(0, 0, 10), new Vector(1, 0, 0), new Vector(0, 0, -1));
//        scene.setCamera(camera);
//
//        ImageWriter imageWriter = new ImageWriter("Spot test 2 ", 500, 500, 500, 500);
//        Render render = new Render(imageWriter, scene);
//
//        render.renderImage();
//        render.writeToImage();
//
//    }
//
//    /**
//     * sphere on triangle with shadow
//     *
//     * @throws Exception
//     */
//    @Test
//    public void shadowTest() throws Exception {
//
//        Scene scene = new Scene("shadow2");
//        Sphere sphere = new Sphere(500, new Point3D(0.0, 0.0, -1000), new Color(0, 0, 100), new Material(1, 1, 21));
//        scene.addGeometry(sphere);
//
//        Triangle triangle = new Triangle(new Point3D(3500, 3500, -2000), new Point3D(-3500, -3500, -1000),
//                new Point3D(3500, -3500, -2000), new Color(), new Material(1, 1, 3));
//
//        Triangle triangle2 = new Triangle(new Point3D(3500, 3500, -2000), new Point3D(-3500, 3500, -1000),
//                new Point3D(-3500, -3500, -1000), new Color(), new Material(1, 1, 3));
//
//        scene.addGeometry(triangle);
//        scene.addGeometry(triangle2);
//
//        scene.addLight(new SpotLight(new Point3D(200, 200, -100), 1, 0.000001, 0.0000005, new Color(255, 100, 100),
//                new Vector(-2, -2, -3)));
//
//        Camera camera = new Camera(new Point3D(0, 0, 10), new Vector(1, 0, 0), new Vector(0, 0, -1));
//        scene.setCamera(camera);
//
//        ImageWriter imageWriter = new ImageWriter("shadow test", 500, 500, 500, 500);
//
//        Render render = new Render(imageWriter, scene);
//
//        render.renderImage();
//        render.writeToImage();
//
//    }
//}
