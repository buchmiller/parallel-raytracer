package math;

public class Vector3
{
   private float x;
   private float y;
   private float z;

   public Vector3(float x, float y, float z)
   {
      this.x = x;
      this.y = y;
      this.z = z;
   }

   public float getX()
   {
      return x;
   }

   public float getY()
   {
      return y;
   }

   public float getZ()
   {
      return z;
   }

   public float getMagnitude()
   {
      throw new RuntimeException("Not yet implemented");
   }

   public float getSquaredMagnitude()
   {
      throw new RuntimeException("Not yet implemented");
   }

   public float normalize()
   {
      throw new RuntimeException("Not yet implemented");
   }

   public Vector3 add(Vector3 v)
   {
      throw new RuntimeException("Not yet implemented");
   }

   public Vector3 subtract(Vector3 v)
   {
      throw new RuntimeException("Not yet implemented");
   }

   public Vector3 multiply(Vector3 v)
   {
      throw new RuntimeException("Not yet implemented");
   }

   public Vector3 divide(Vector3 v)
   {
      throw new RuntimeException("Not yet implemented");
   }

   public static float angle(Vector3 v1, Vector3 v2)
   {
      throw new RuntimeException("Not yet implemented");
   }

   public static Vector3 cross(Vector3 v1, Vector3 v2)
   {
      throw new RuntimeException("Not yet implemented");
   }

   public static float distance(Vector3 v1, Vector3 v2)
   {
      throw new RuntimeException("Not yet implemented");
   }

   public static float dot(Vector3 v1, Vector3 v2)
   {
      throw new RuntimeException("Not yet implemented");
   }
   
   @Override
   public int hashCode()
   {
      int hash = 7;
      hash = 97 * hash + Float.floatToIntBits(this.x);
      hash = 97 * hash + Float.floatToIntBits(this.y);
      hash = 97 * hash + Float.floatToIntBits(this.z);
      return hash;
   }

   @Override
   public boolean equals(Object obj)
   {
      if (obj == null)
      {
         return false;
      }
      if (getClass() != obj.getClass())
      {
         return false;
      }
      final Vector3 other = (Vector3) obj;
      if (Float.floatToIntBits(this.x) != Float.floatToIntBits(other.x))
      {
         return false;
      }
      if (Float.floatToIntBits(this.y) != Float.floatToIntBits(other.y))
      {
         return false;
      }
      if (Float.floatToIntBits(this.z) != Float.floatToIntBits(other.z))
      {
         return false;
      }
      return true;
   }
}
