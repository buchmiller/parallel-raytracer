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
      throw new RuntimeException("Not yet implemented");
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
