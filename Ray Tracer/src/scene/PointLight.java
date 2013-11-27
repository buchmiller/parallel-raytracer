package scene;

import java.io.Serializable;
import math.Color3;
import math.Vector3;

public class PointLight implements Serializable
{
   private Vector3 position;
   private float intensity;
   private Color3 color;

   public PointLight(Vector3 position, float intensity, Color3 color)
   {
      this.position = position;
      this.intensity = intensity;
      this.color = color;
   }

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
