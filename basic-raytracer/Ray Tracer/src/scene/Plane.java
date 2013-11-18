package scene;

import math.Vector3;
import raytracer.Ray;

public class Plane extends Shape
{
   private Vector3 normal;

   public Plane(Vector3 position, Material material, Vector3 normal)
   {
      this.position = position;
      this.material = material;
      this.normal = normal.getNormalized();
   }

   @Override
   public float intersect(Ray ray)
   {
      float distance = -1;
      float denom = -Vector3.dot(normal, ray.getDirection().getNormalized());
      
      if (denom > 1e-6)
      {
         Vector3 p0l0 = ray.getOrigin().subtract(position);
         distance = Vector3.dot(p0l0, normal) / denom;
      }

      return distance;
   }

   @Override
   public Vector3 normal(Vector3 vector)
   {
      return normal;
   }
}
