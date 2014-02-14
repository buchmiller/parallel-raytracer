package common.scene;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import common.raytracer.Color3;
import common.raytracer.Vector3;
import common.raytracer.Ray;

public class Scene implements Serializable
{
   public enum Type
   {
      SIMPLE, COMPLEX, MIRRORS, LIGHTTEST, SHADOWTEST, REFLECTTEST
   }
   private List<Shape> shapes = new ArrayList<>();
   private List<PointLight> lights = new ArrayList<>();
   private Camera camera;
   private Screen screen;
   private Color3 backgroundColor;
   private int maxDepth;
   private int antialisingAmount;

   public Scene(Camera camera, Screen screen, Color3 backgroundColor, int maxDepth, int antialiasingAmount)
   {
      this.camera = camera;
      this.screen = screen;
      this.backgroundColor = backgroundColor;
      this.maxDepth = maxDepth;
      this.antialisingAmount = antialiasingAmount;
   }

   public void addShape(Shape shape)
   {
      shapes.add(shape);
   }

   public void addLight(PointLight light)
   {
      lights.add(light);
   }

   public List<Shape> getShapes()
   {
      return shapes;
   }

   public List<PointLight> getLights()
   {
      return lights;
   }

   public Camera getCamera()
   {
      return camera;
   }

   public Screen getScreen()
   {
      return screen;
   }

   public Color3 getBackgroundColor()
   {
      return backgroundColor;
   }

   public int getMaxDepth()
   {
      return maxDepth;
   }

   public int getAntialisingAmount()
   {
      return antialisingAmount;
   }

   public Ray constructRay(float px, float py)
   {
//      float x = (float) (2 * ((col + 0.5) / screen.getWidth()) - 1) * screen.getAspectRatio() * camera.getAngle();
//      float y = (float) (1 - 2 * ((row + 0.5) / screen.getHeight())) * camera.getAngle();
      float x = (float) (2 * px - 1) * screen.getAspectRatio() * camera.getAngle();
      float y = (float) (1 - 2 * py) * camera.getAngle();
      Vector3 rayDir = new Vector3(x, y, -1);
      rayDir.normalize();

      return new Ray(camera.getPosition(), rayDir, camera.getNearClippingPlane(), camera.getFarClippingPlane());
   }

   public static Scene createScene(Type type, Camera camera, Screen screen, Color3 bColor, int maxDepth, int aa)
   {
      Scene scene = new Scene(camera, screen, bColor, maxDepth, aa);

      switch (type)
      {
         case SIMPLE:
            createSimple(scene);
            break;
         case COMPLEX:
            createComplex(scene);
            break;
         case MIRRORS:
            createTwoMirrors(scene);
            break;
         case LIGHTTEST:
            createLightTest(scene);
            break;
         case SHADOWTEST:
            createShadowTest(scene);
            break;
         case REFLECTTEST:
            createReflectTest(scene);
            break;
      }

      return scene;
   }

   private static void createSimple(Scene scene)
   {
      scene.addShape(new Sphere(new Vector3(-2, 0, -2), 1, new Material(Color3.RED))); //red
      scene.addShape(new Sphere(new Vector3(2, 0, -5), 1, new Material(Color3.BLUE))); //blue
      scene.addShape(new Sphere(new Vector3(0, 0, -10), 1, new Material(Color3.YELLOW))); //yellow
      scene.addShape(new Sphere(new Vector3(2, 0, -15), 1, new Material(Color3.GREEN))); //green

      Vector3 normal = new Vector3(0, 1, 0);
      normal.normalize();
      scene.addShape(new Plane(new Vector3(0, -0.5f, -10), new Material(new Color3(100, 100, 100), 0), normal)); //grey

      normal = new Vector3(-1, 0.3f, 0);
      normal.normalize();
      scene.addShape(new Plane(new Vector3(2.2f, 0, -10), new Material(new Color3(100, 100, 100), 0), normal)); //grey

      //lights
      scene.addLight(new PointLight(new Vector3(-5, 10, -10), 100, new Color3(100, 100, 100)));
   }

   private static void createLightTest(Scene scene)
   {
      scene.addShape(new Sphere(new Vector3(0, 0, -4), 0.5f, new Material(Color3.BLACK, 0)));

      Vector3 normal = new Vector3(0, 1, 0);
      normal.normalize();
      scene.addShape(new Plane(new Vector3(0, -0.5f, -10), new Material(Color3.BLACK, 0), normal));

      //lights
      scene.addLight(new PointLight(new Vector3(1, 1, -3), 4, Color3.CYAN));
      scene.addLight(new PointLight(new Vector3(-1, 0.5f, -3), 3, Color3.YELLOW));
   }

   private static void createShadowTest(Scene scene)
   {
      for (int y = -2; y < 3; y++)
      {
         for (int x = -3; x < 4; x++)
         {
            scene.addShape(new Sphere(new Vector3(x, y, -5), 0.4f, new Material(Color3.RED, 0)));
         }
      }

      Vector3 normal = new Vector3(0, 0, 1);
      normal.normalize();
      scene.addShape(new Plane(new Vector3(0, -0.4f, -5), new Material(Color3.BLACK, 0), normal));

      //lights
      scene.addLight(new PointLight(new Vector3(0, 0, -4), 2, Color3.WHITE));
   }

   private static void createReflectTest(Scene scene)
   {
      scene.addShape(new Sphere(new Vector3(-2, 0, -2), 1, new Material(Color3.RED, 1, 0.3f))); //red
      scene.addShape(new Sphere(new Vector3(2, 0, -5), 1, new Material(Color3.BLUE, 1, 0.3f))); //blue
      scene.addShape(new Sphere(new Vector3(0, 0, -10), 1, new Material(Color3.YELLOW, 1, 0.3f))); //yellow
      scene.addShape(new Sphere(new Vector3(2, 0, -15), 1, new Material(Color3.GREEN, 1, 0.3f))); //green

      Vector3 normal = new Vector3(0, 1, 0);
      normal.normalize();
      scene.addShape(new Plane(new Vector3(0, -0.5f, -10), new Material(Color3.BLACK, 0, 0.5f), normal));

      normal = new Vector3(-1, 0.3f, 0);
      normal.normalize();
      scene.addShape(new Plane(new Vector3(2.2f, 0, -10), new Material(Color3.BLACK, 0, 0.5f), normal));

      //lights
      scene.addLight(new PointLight(new Vector3(-5, 10, -10), 200, new Color3(100, 100, 100)));
   }

   private static void createTwoMirrors(Scene scene)
   {
      scene.addShape(new Sphere(new Vector3(-2, 0, 0), 0.5f, new Material(Color3.BLACK, 1, 0.5f)));
      scene.addShape(new Sphere(new Vector3(2, -0.3f, 0), 0.5f, new Material(Color3.RED, 1, 0.5f)));
      scene.addShape(new Sphere(new Vector3(-1.2f, 2, 0), 0.5f, new Material(Color3.YELLOW, 1, 0.5f)));
      scene.addShape(new Sphere(new Vector3(0, -2, -1), 0.5f, new Material(Color3.CYAN, 1, 0.5f)));

      Vector3 normal = new Vector3(0, 0, 1);
      normal.normalize();
      scene.addShape(new Plane(new Vector3(0, -0.5f, -2), new Material(Color3.BLACK, 0, 0.8f), normal));

      normal = new Vector3(0, 0, -1);
      normal.normalize();
      scene.addShape(new Plane(new Vector3(0, -0.5f, 2), new Material(Color3.BLACK, 0, 0.8f), normal));

      //lights
      scene.addLight(new PointLight(new Vector3(-5, 10, -10), 100, new Color3(100, 100, 100)));
   }

   private static void createComplex(Scene scene)
   {
      for (int x = -5; x <= 5; x++)
      {
         for (int y = -5; y <= 5; y++)
         {
            for (int z = 10; z <= 20; z++)
            {
               scene.addShape(new Sphere(new Vector3(x, y, -z), 0.4f, new Material(Color3.random(), 0.5f, 0.2f)));
            }
         }
      }

      Vector3 normal = new Vector3(-1, 0, 0);
      normal.normalize();
      scene.addShape(new Plane(new Vector3(7, 0, 0), new Material(Color3.BLACK, 0, 0.5f), normal));

      normal = new Vector3(1, 0, 0);
      normal.normalize();
      scene.addShape(new Plane(new Vector3(-7, 0, 0), new Material(Color3.BLACK, 0, 0.5f), normal));

      //lights
      for (int x = -3; x <= 3; x += 3)
      {
         for (int y = -3; y <= 3; y += 3)
         {
            scene.addLight(new PointLight(new Vector3(x, y, -5), 50, new Color3(10, 10, 10)));
         }
      }
   }
}
