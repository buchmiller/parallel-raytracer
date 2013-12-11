package common.scene;

import java.io.Serializable;
import common.raytracer.Vector3;
import common.raytracer.Ray;

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
