package scene;

import math.Vector3;
import raytracer.Ray;

public class Plane extends Shape
{
   private Vector3 normal;

   @Override
   public ISect intersect(Ray ray)
   {
      throw new RuntimeException("Not yet implemented");
   }

   @Override
   public Vector3 normal(Vector3 vector)
   {
      return normal;
   }
}