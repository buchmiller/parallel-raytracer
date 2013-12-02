package scene;

import java.io.Serializable;
import math.Vector3;
import raytracer.Ray;

public abstract class Shape implements Serializable
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

   public abstract Vector3 normal(Vector3 intersectPoint);
}
