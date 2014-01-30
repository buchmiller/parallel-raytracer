package common.scene;

import java.io.Serializable;
import common.raytracer.Color3;
import common.raytracer.Vector3;

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

   public float getIntensity(Vector3 location)
   {
      float squaredDistance = Vector3.squaredDistance(position, location);
      return intensity / squaredDistance;
   }

   public Color3 getColor()
   {
      return color;
   }
}
