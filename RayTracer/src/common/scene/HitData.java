package common.scene;

import common.raytracer.Ray;

public class HitData
{
   private Shape shape;
   private Ray ray;
   private float distance;

   public HitData(Shape shape, Ray ray, float distance)
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

   public float getDistance()
   {
      return distance;
   }
}
