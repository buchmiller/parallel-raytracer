package math;

import java.io.Serializable;

public class Color3 implements Serializable
{
   private Vector3 vector;

   public Color3(Vector3 vector)
   {
      this.vector = vector;
   }

   public Color3(float r, float g, float b)
   {
      this.vector = new Vector3(r, g, b);
   }

   public Vector3 getVector()
   {
      return this.vector;
   }

   public float getR()
   {
      return this.vector.getX();
   }

   public float getG()
   {
      return this.vector.getY();
   }

   public float getB()
   {
      return this.vector.getZ();
   }

   public Color3 add(Color3 value)
   {
      return new Color3(vector.add(value.vector));
   }

   public Color3 subtract(Color3 value)
   {
      return new Color3(vector.subtract(value.vector));
   }

   public Color3 multiply(Color3 value)
   {
      return new Color3(vector.multiply(value.vector));
   }

   public Color3 multiply(float value)
   {
      return new Color3(vector.multiply(value));
   }

   @Override
   public String toString()
   {
      return getR() + "," + getG() + "," + getB();
   }
}
