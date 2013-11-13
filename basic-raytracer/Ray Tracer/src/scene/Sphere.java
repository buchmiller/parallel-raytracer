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
   public ISect intersect(Ray ray)
   {
      //http://wiki.cgsociety.org/index.php/Ray_Sphere_Intersection

      float a = Vector3.dot(ray.getDirection(), ray.getDirection());
      float b = 2 * Vector3.dot(ray.getDirection(), ray.getOrigin());
      float c = Vector3.dot(ray.getOrigin(), ray.getOrigin()) - (radius * radius);

      float discriminant = b * b - 4 * a * c;
      if (discriminant < 0) // ray misses sphere
      {
         return null;
      }

      float distSqrt = (float) Math.sqrt(discriminant);
      float q;
      if (b < 0)
      {
         q = (-b - distSqrt) / 2.0f;
      }
      else
      {
         q = (-b + distSqrt) / 2.0f;
      }

      float t0 = q / a;
      float t1 = c / q;

      if (t0 > t1)
      {
         float temp = t0;
         t0 = t1;
         t1 = temp;
      }

      if (t1 < 0) //sphere is in the negative direction, a miss
      {
         return null;
      }

      if (t0 < 0) //intersection point is at t1
      {
         return new ISect(this, ray, t1);
      }
      else //intersection point is at t0
      {
         return new ISect(this, ray, t0);
      }
   }

   public float intersect2(Ray ray)
   {
      // http://ray-tracer-concept.blogspot.com/2011/11/ray-sphere-intersection.html
      
      Vector3 d = ray.getDirection();
      float t1 = -1;
      float t2 = -1;
      float discriminent;
      float t = -1;
      //temporary == e-c
      Vector3 temporary = ray.getOrigin().subtract(position);
      float b = 2 * Vector3.dot(d, temporary);
      float a = Vector3.dot(d, d);
      float c = Vector3.dot(temporary, temporary) - (radius * radius);
      float disc;
      disc = b * b - 4 * a * c;
      if (disc < 0)
      {
         return -1;
      }
      else
      {
         discriminent = (float) Math.sqrt(disc);
         t1 = (-b + discriminent) / (2 * a);
         t2 = (-b - discriminent) / (2 * a);

         if (t1 > 0)
         {
            t = t1;
         }
         else if (t2 > 0)
         {
            t = t2;
         }
      }

      return t;
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
