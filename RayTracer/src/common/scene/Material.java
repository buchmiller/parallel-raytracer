package common.scene;

import java.io.Serializable;
import common.raytracer.Color3;

public class Material implements Serializable
{
   private Color3 color;
   private float transparency;
   private float refractionIndex;
   private float specular; //mirror-like reflection
   private float reflect;
   private float roughness; //lower value = shiny

   public Material(Color3 color, float transparency, float refractionIndex, float specular, float reflect, float roughness)
   {
      this.color = color;
      this.transparency = transparency;
      this.refractionIndex = refractionIndex;
      this.specular = specular;
      this.reflect = reflect;
      this.roughness = roughness;
   }

   public Material(Color3 color, float specular)
   {
      this(color, 0, 0, specular, 0, 50);
   }

   public Material(Color3 color)
   {
      this(color, 0, 0, 1, 0, 50);
   }

   public Color3 getColor()
   {
      return color;
   }

   public float getSpecular()
   {
      return specular;
   }

   public float getRoughness()
   {
      return roughness;
   }
}
