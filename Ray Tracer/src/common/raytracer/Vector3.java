package common.raytracer;

import java.io.Serializable;

public class Vector3 implements Serializable
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

   public Vector3(Vector3 vector)
   {
      this.x = vector.x;
      this.y = vector.y;
      this.z = vector.z;
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
      return (float) Math.sqrt(x * x + y * y + z * z);
   }

   public float getSquaredMagnitude()
   {
      return (x * x + y * y + z * z);
   }

   public Vector3 getNormalized()
   {
      float length = getMagnitude();
      if (length != 0)
      {
         return new Vector3(x / length, y / length, z / length);
      }

      return new Vector3(x, y, z);
   }

   public void normalize()
   {
      float length = getMagnitude();
      if (length != 0)
      {
         x = x / length;
         y = y / length;
         z = z / length;
      }
   }

   public Vector3 add(Vector3 v)
   {
      return new Vector3(x + v.x, y + v.y, z + v.z);
   }

   public Vector3 subtract(Vector3 v)
   {
      return new Vector3(x - v.x, y - v.y, z - v.z);
   }

   public Vector3 multiply(float n)
   {
      return new Vector3(x * n, y * n, z * n);
   }

   public Vector3 multiply(Vector3 v)
   {
      return new Vector3(x * v.x, y * v.y, z * v.z);
   }

   public Vector3 divide(float n)
   {
      return new Vector3(x / n, y / n, z / n);
   }

   public static float angle(Vector3 v1, Vector3 v2)
   {
      return (float) Math.toDegrees(Math.acos(Vector3.dot(v1, v2)));
   }

   public static Vector3 cross(Vector3 v1, Vector3 v2)
   {
      return new Vector3(v1.y * v2.z - v1.z * v2.y,
                         v1.z * v2.x - v1.x * v2.z,
                         v1.x * v2.y - v1.y - v2.x);
   }

   public static float distance(Vector3 v1, Vector3 v2)
   {
      float dx = v1.x - v2.x;
      float dy = v1.y - v2.y;
      float dz = v1.z - v2.z;

      return (float) Math.sqrt(dx * dx + dy * dy + dz * dz);
   }

   public static float dot(Vector3 v1, Vector3 v2)
   {
      return v1.x * v2.x + v1.y * v2.y + v1.z * v2.z;
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
