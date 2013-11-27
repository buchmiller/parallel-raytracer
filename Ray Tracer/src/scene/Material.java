package scene;

import math.Color3;

public class Material
{
   private Color3 color;
   private float transparency;
   private float refractionIndex;
   private float diffuse; //Lambertian reflection
   private float specular; //mirror-like reflection
   private float reflect;
   private float roughness; //lower value = shiny

   public Material(Color3 color, float transparency, float refractionIndex, float diffuse, float specular, float reflect, float roughness)
   {
      this.color = color;
      this.transparency = transparency;
      this.refractionIndex = refractionIndex;
      this.diffuse = diffuse;
      this.specular = specular;
      this.reflect = reflect;
      this.roughness = roughness;
   }

   public Material(Color3 color)
   {
      this(color, 0, 0, 1, 1, 0, 50);
   }
   
   public Color3 getColor()
   {
      return color;
   }

   public float getDiffuse()
   {
      return diffuse;
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
