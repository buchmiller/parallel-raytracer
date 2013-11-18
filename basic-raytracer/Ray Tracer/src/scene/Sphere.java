package scene;

import math.Vector3;
import raytracer.Ray;

public class Sphere extends Shape
{
   private float radius;

   public Sphere(Vector3 position, float radius, Material material)
   {
      this.position = position;
      this.radius = radius;
      this.material = material;
   }

   @Override
   public float intersect(Ray ray)
   {
      //geometric solution from:
      // http://www.scratchapixel.com/lessons/3d-basic-lessons/lesson-7-intersecting-simple-shapes/ray-sphere-intersection/

      float t0 = -1;
      //float t1 = -1;
      
      Vector3 L = position.subtract(ray.getOrigin());
      float tca = Vector3.dot(L, ray.getDirection());
      if (tca < 0)
         return -1;
      float d2 = Vector3.dot(L, L) - (tca * tca);
      if (d2 > (radius * radius))
         return -1;
      float thc = (float) Math.sqrt((radius * radius) - d2);
      t0 = tca - thc;
      //t1 = tca + thc;
      
      return t0;
   }

   @Override
   public Vector3 normal(Vector3 vector)
   {
      throw new RuntimeException("Not yet implemented");
   }

   public boolean isInside()
   {
      throw new RuntimeException("Not yet implemented");
   }
}
