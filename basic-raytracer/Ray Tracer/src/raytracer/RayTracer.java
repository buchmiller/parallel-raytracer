package raytracer;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import math.Color3;
import math.Vector3;
import scene.Camera;
import scene.Material;
import scene.Scene;
import scene.Screen;
import scene.Sphere;

public class RayTracer
{
   public static void main(String[] args)
   {
      int width = 1000;
      int height = 1000;

      Image image = new Image(width, height);
      Camera camera = new Camera(new Vector3(0, 0, 0), new Vector3(0, 0, 0));
      Screen screen = new Screen(width, height);
      Color3 bColor = new Color3(0, 1, 0);
      int maxDepth = 4;

      Scene scene = new Scene(camera, screen, bColor, maxDepth);
      scene.addShape(new Sphere(new Vector3(-5, 5, -30), 4, new Material(new Color3(255, 0, 0), 0, 0, 0, 0, 0)));
      scene.addShape(new Sphere(new Vector3(0, 0, -20), 4, new Material(new Color3(0, 255, 0), 0, 0, 0, 0, 0)));
      scene.addShape(new Sphere(new Vector3(3, -3, -10), 4, new Material(new Color3(0, 0, 255), 0, 0, 0, 0, 0)));
      Tracer tracer = new Tracer(scene);

      BufferedImage img = new BufferedImage(screen.getWidth(), screen.getHeight(), BufferedImage.TYPE_INT_RGB);
      
      for (int row = 0; row < screen.getHeight(); row++)
      {
         Color3[] colors = tracer.render(row);

         for (int col = 0; col < colors.length; col++)
         {
            int red = (int) colors[col].getR();
            int green = (int) colors[col].getG();
            int blue = (int) colors[col].getB();

            int rgb = (red << 16) | (green << 8) | blue;
            img.setRGB(col, row, rgb);
            //System.out.print(color.toString() + " | ");
         }
         try
         {
         ImageIO.write(img, "bmp", new File("abc.bmp"));
         }
         catch (Exception e)
         {
            System.out.println("Error: " + e);
         }
         //System.out.println();
      }
   }
}
