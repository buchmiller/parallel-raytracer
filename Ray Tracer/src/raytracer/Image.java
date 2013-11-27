package raytracer;

import math.Color3;

public class Image
{
   private int width;
   private int height;
   private Color3[][] pixels;

   public Image(int width, int height)
   {
      this.width = width;
      this.height = height;
      pixels = new Color3[height][width];
   }
   
   public void saveImageToFile(String fileName)
   {
      throw new RuntimeException("Not yet implemented");
   }

   public void displayImage()
   {
      throw new RuntimeException("Not yet implemented");
   }
}
