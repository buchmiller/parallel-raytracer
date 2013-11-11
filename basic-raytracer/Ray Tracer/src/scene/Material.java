package scene;

import math.Color3;

public class Material
{
   private Color3 color;
   private float transparency;
   private float refractionIndex;
   private float diffuse;
   private float specular;
   private float reflect;

   public Material(Color3 color, float transparency, float refractionIndex, float diffuse, float specular, float reflect)
   {
      this.color = color;
      this.transparency = transparency;
      this.refractionIndex = refractionIndex;
      this.diffuse = diffuse;
      this.specular = specular;
      this.reflect = reflect;
   }

   public Color3 getColor()
   {
      return color;
   }
}
