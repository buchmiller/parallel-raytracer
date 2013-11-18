package scene;

import math.Vector3;
import raytracer.Ray;

public abstract class Shape
{
   protected Vector3 position;
   protected Material material;

   public Vector3 getPosition()
   {
      return position;
   }

   public Material getMaterial()
   {
      return material;
   }

   public abstract float intersect(Ray ray);
   public abstract float intersect2(Ray ray);

   public abstract Vector3 normal(Vector3 vector);
}
