package scene;

import math.Vector3;
import raytracer.Ray;

public class ISect
{
   private Shape shape;
   private Vector3 position;
   private float distance;

   public ISect(Shape shape, Vector3 position, float distance)
   {
      this.shape = shape;
      this.position = position;
      this.distance = distance;
   }

   public Shape getShape()
   {
      return shape;
   }

   public Vector3 getPosition()
   {
      return position;
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
