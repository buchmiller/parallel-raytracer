package math;

public class Color3
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

   public void add(Color3 value)
   {
      vector = vector.add(value.vector);
   }

   public void subtract(Color3 value)
   {
      vector = vector.subtract(value.vector);
   }
   
   @Override
   public String toString()
   {
      return getR() + "," + getG() + "," + getB();
   }
}
