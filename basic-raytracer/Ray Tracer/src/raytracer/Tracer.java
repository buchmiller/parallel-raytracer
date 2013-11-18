package raytracer;

import math.Color3;
import scene.ISect;
import scene.Scene;
import scene.Shape;

public class Tracer
{
   private Scene scene;
   private int depth = 0;

   public Tracer(Scene scene)
   {
      this.scene = scene;
   }

   public Color3[] render(int row)
   {
      Color3[] colors = new Color3[scene.getScreen().getWidth()];

      for (int col = 0; col < scene.getScreen().getWidth(); col++)
      {
         //Compute primary ray direction
         //compute pixel area in the viewplane using the current camera
         Ray ray = scene.constructRay(row, col);

         //shoot primary ray into the scene and search for intersection
         //compute the first visible point in the scene for the given ray
         //obtain pixel intensity
         Color3 color = traceRay(ray);

         //compute illumination
         //	if none intersection is found then
         //    return background radiance
         // else begin
         //    retrieve aspect value of intersected object at intersection point
         //    evaluate local illumination model using the aspect value
         //    return the computed radiance

         //update pixel intensity in the image
         colors[col] = color;
      }

      return colors;
   }

   private Color3 traceRay(Ray ray)
   {
      Shape shapeHit = null;
      float closestHit = scene.getCamera().getFarClippingPlane();

      for (Shape shape : scene.getShapes())
      {
//         ISect intersection = shape.intersect(ray);
//         if (intersection.getDistance() < closestHit)
//         {
//            closestHit = intersection.getDistance();
//            shapeHit = shape;
//         }
         float t = shape.intersect(ray);
         if (t > 0)
         {
            if (t < closestHit && t > scene.getCamera().getNearClippingPlane())
            {
               closestHit = t;
               shapeHit = shape;
            }
         }
      }
      
      if (shapeHit != null)
      {
         //TODO: replace this line with a call to a shade() function.
         return shapeHit.getMaterial().getColor();
      }

      return scene.getBackgroundColor();
   }
}
