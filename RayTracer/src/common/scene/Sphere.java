package common.scene;

import java.io.Serializable;
import common.raytracer.Vector3;
import common.raytracer.Ray;

public class Sphere extends Shape implements Serializable
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

      Vector3 L = position.subtract(ray.getOrigin());
      float tca = Vector3.dot(L, ray.getDirection());
      if (tca < 0)
      {
         return -1;
      }
      float d2 = Vector3.dot(L, L) - tca * tca;
      if (d2 > (radius * radius))
      {
         return -1;
      }
      float thc = (float) Math.sqrt(radius * radius - d2);
      float t0 = tca - thc;
      float t1 = tca + thc;

      return Math.min(t0, t1);
   }

   @Override
   public Vector3 normal(Vector3 intersectPoint)
   {
      return intersectPoint.subtract(position).multiply(1.0f / radius);
   }

   public boolean isInside()
   {
      throw new RuntimeException("Not yet implemented");
   }
}
