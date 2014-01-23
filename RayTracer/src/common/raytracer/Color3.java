package common.raytracer;

import java.io.Serializable;
import java.util.Random;

public class Color3 implements Serializable
{
   private Vector3 vector;
   private static final Random randomGen = new Random();
   public static final Color3 WHITE = new Color3(200, 200, 200);
   public static final Color3 BLACK = new Color3(0, 0, 0);
   public static final Color3 RED = new Color3(100, 0, 0);
   public static final Color3 GREEN = new Color3(0, 100, 0);
   public static final Color3 BLUE = new Color3(0, 0, 100);
   public static final Color3 YELLOW = new Color3(100, 100, 0);
   public static final Color3 MAGENTA = new Color3(100, 0, 100);
   public static final Color3 CYAN = new Color3(0, 100, 100);

   public Color3(Vector3 vector)
   {
      this.vector = vector;
   }

   public Color3(float r, float g, float b)
   {
      this.vector = new Vector3(r, g, b);
   }

   private static int[] genNumbers(int n, int sum)
   {
      int[] nums = new int[n];
      int upperbound = Long.valueOf(Math.round(sum * 1.0 / n)).intValue();
      int offset = Long.valueOf(Math.round(0.5 * upperbound)).intValue();

      int cursum = 0;
      for (int i = 0; i < n; i++)
      {
         int rand = randomGen.nextInt(upperbound) + offset;
         if (cursum + rand > sum || i == n - 1)
         {
            rand = sum - cursum;
         }
         cursum += rand;
         nums[i] = rand;
         if (cursum == sum)
         {
            break;
         }
      }
      return nums;
   }

   public static Color3 random()
   {
      int[] nums = genNumbers(3, randomGen.nextInt(255));
      return new Color3(nums[0], nums[1], nums[2]);
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
