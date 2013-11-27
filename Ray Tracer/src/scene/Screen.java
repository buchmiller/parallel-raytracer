package scene;

public class Screen
{
   private int width;
   private int height;
   private float aspectRatio;

   public Screen(int width, int height)
   {
      this.width = width;
      this.height = height;
      aspectRatio = (float) width / (float) height;
   }

   public int getWidth()
   {
      return width;
   }

   public int getHeight()
   {
      return height;
   }

   public float getAspectRatio()
   {
      return aspectRatio;
   }
}
