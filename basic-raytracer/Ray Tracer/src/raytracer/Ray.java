package raytracer;

import math.Vector3;

public class Ray
{
   private Vector3 origin;
   private Vector3 direction;
   private float min;
   private float max;

   public Ray(Vector3 origin, Vector3 direction, float min, float max)
   {
      this.origin = origin;
      this.direction = direction;
      this.min = min;
      this.max = max;
   }

   public Ray(Vector3 src, Vector3 dest)
   {
      this.origin = new Vector3(src);
      this.direction = new Vector3(dest.getX() - src.getX(),
            dest.getY() - src.getY(), dest.getZ() - src.getZ());
      this.direction.normalize();
   }

   public Vector3 getOrigin()
   {
      return origin;
   }

   public Vector3 getDirection()
   {
      return direction;
   }

   public float getMin()
   {
      return min;
   }

   public float getMax()
   {
      return max;
   }
}
