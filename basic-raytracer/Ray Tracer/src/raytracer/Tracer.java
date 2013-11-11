package raytracer;

import math.Color3;
import scene.Scene;

public class Tracer
{
   private Scene scene;
   private int depth = 0;

   public Tracer(Scene scene)
   {
      this.scene = scene;
   }

   public void render(int rowNum)
   {
      throw new RuntimeException("Not yet implemented");
   }

   public Color3 traceRay(Ray ray)
   {
      throw new RuntimeException("Not yet implemented");
   }
}
