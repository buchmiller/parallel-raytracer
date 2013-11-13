package scene;

import math.Vector3;
import raytracer.Ray;

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

   public Vector3 getPosition()
   {
      return shape.getPosition();
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
