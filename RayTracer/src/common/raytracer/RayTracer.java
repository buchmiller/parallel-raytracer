package common.raytracer;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import common.scene.Camera;
import common.scene.Material;
import common.scene.Plane;
import common.scene.PointLight;
import common.scene.Scene;
import common.scene.Screen;
import common.scene.Sphere;

public class RayTracer
{
   public static void main(String[] args)
   {
      int width = 640;
      int height = 480;
      String fileName = "output";

      if (args.length > 1) //allow for easily changing size on command line
      {
         width = Integer.parseInt(args[0]);
         height = Integer.parseInt(args[1]);
         if (args.length > 2) //allow for changing the output fileName
         {
            fileName = args[2];
         }
      }

//      Image image = new Image(width, height);
      Camera camera = new Camera(new Vector3(0, 0, 0), new Vector3(0, 0, 0));
      Screen screen = new Screen(width, height);
      Color3 bColor = new Color3(0, 1, 0);
      int maxDepth = 4;

      Scene scene = new Scene(camera, screen, bColor, maxDepth, 1);

      //color wheel
//      scene.addShape(new Sphere(new Vector3(0, 5, -30), 4, new Material(new Color3(255, 0, 0)))); //red
//      scene.addShape(new Sphere(new Vector3(5, 2.5f, -30), 4, new Material(new Color3(255, 255, 0)))); //yellow
//      scene.addShape(new Sphere(new Vector3(5, -2.5f, -30), 4, new Material(new Color3(0, 255, 0)))); //green
//      scene.addShape(new Sphere(new Vector3(0, -5, -30), 4, new Material(new Color3(0, 255, 255)))); //cyan
//      scene.addShape(new Sphere(new Vector3(-5, -2.5f, -30), 4, new Material(new Color3(0, 0, 255)))); //blue
//      scene.addShape(new Sphere(new Vector3(-5, 2.5f, -30), 4, new Material(new Color3(255, 0, 255)))); //magenta
//      scene.addShape(new Sphere(new Vector3(0, 0, -29), 5, new Material(new Color3(255, 255, 255)))); //white


      scene.addShape(new Sphere(new Vector3(-2, 0, -2), 1, new Material(new Color3(300, 0, 0)))); //red
      scene.addShape(new Sphere(new Vector3(2, 0, -5), 1, new Material(new Color3(0, 0, 300)))); //blue
      scene.addShape(new Sphere(new Vector3(0, 0, -10), 1, new Material(new Color3(300, 300, 0)))); //yellow
      scene.addShape(new Sphere(new Vector3(2, 0, -15), 1, new Material(new Color3(0, 300, 0)))); //green

      Vector3 normal = new Vector3(0, 1, 0);
      normal.normalize();
      scene.addShape(new Plane(new Vector3(0, -0.5f, -10), new Material(new Color3(100, 100, 100)), normal)); //grey

      normal = new Vector3(-1, 0.3f, 0);
      normal.normalize();
      scene.addShape(new Plane(new Vector3(2.2f, 0, -10), new Material(new Color3(100, 100, 100)), normal)); //grey

      //lights
      scene.addLight(new PointLight(new Vector3(-5, 10, -10), 5, new Color3(100, 100, 100)));

      Tracer tracer = new Tracer(scene);

      BufferedImage img = new BufferedImage(screen.getWidth(), screen.getHeight(), BufferedImage.TYPE_INT_RGB);

      long startTime = System.currentTimeMillis();

      for (int row = 0; row < screen.getHeight(); row++)
      {
         Color3[] colors = tracer.render(row);

         for (int col = 0; col < colors.length; col++)
         {
            int red = colors[col].getR() < 0 ? 0 : (int) colors[col].getR() % 256;
            int green = colors[col].getG() < 0 ? 0 : (int) colors[col].getG() % 256;
            int blue = colors[col].getB() < 0 ? 0 : (int) colors[col].getB() % 256;

            int rgb = (red << 16) | (green << 8) | blue;
            img.setRGB(col, row, rgb);
            //System.out.print(color.toString() + " | ");
         }
         //System.out.println();
      }

      long endTime = System.currentTimeMillis();
      System.out.println("Raytracing took " + (endTime - startTime) + " milliseconds.");

      try
      {
         ImageIO.write(img, "bmp", new File(fileName + ".bmp"));
      }
      catch (Exception e)
      {
         System.out.println("Error: " + e);
      }
   }
}
