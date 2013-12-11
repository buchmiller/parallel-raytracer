package common.scene;

import common.raytracer.Ray;

public class ISect
{
   private Shape shape;
   private Ray ray;
   private float distance;

   public ISect(Shape shape, Ray ray, float distance)
   {
      this.shape = shape;
      this.ray = ray;
      this.distance = distance;
   }

   public Shape getShape()
   {
      return shape;
   }

   public Ray getRay()
   {
      return ray;
   }

   public float getIntensity()
   {
      throw new RuntimeException("Not yet implemented");
   }

   public float getDistance()
   {
      return distance;
   }
}
