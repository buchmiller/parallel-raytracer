package scene;

import math.Color3;
import math.Vector3;

public class PointLight
{
   private Vector3 position;
   private float intensity;
   private Color3 color;

   public Vector3 getPosition()
   {
      return position;
   }

   public float getIntensity()
   {
      return intensity;
   }

   public Color3 getColor()
   {
      return color;
   }
}
