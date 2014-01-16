package common.raytracer;

import common.ResultData;
import java.util.concurrent.Callable;
import common.scene.HitData;
import common.scene.Material;
import common.scene.PointLight;
import common.scene.Scene;
import common.scene.Shape;

public class TracerCallable implements Callable<ResultData>
{
   private Scene scene;
   private int row; //TODO: Allow multiple rows to be done at once?
   private int depth = 0;

   public TracerCallable(Scene scene, int row)
   {
      this.scene = scene;
      this.row = row;
   }

   @Override
   public ResultData call() throws Exception
   {
      //This sleep is only for testing, remove once more advance ray tracing is added
//      try
//      {
//         Thread.sleep(10);
//      }
//      catch (InterruptedException e)
//      {
//         System.out.println("Error: " + e);
//      }

      return render();
   }

   public ResultData render()
   {
      Color3[] colors = new Color3[scene.getScreen().getWidth()];

      for (int col = 0; col < scene.getScreen().getWidth(); col++)
      {
         //Compute primary ray direction
         Ray ray = scene.constructRay(row, col);

         //shoot primary ray into the scene and search for intersection
         //compute the first visible point in the scene for the given ray
         //obtain pixel intensity
         colors[col] = traceRay(ray);
      }

      return new ResultData(row, colors);
   }

   //    retrieve aspect value of intersected object at intersection point
   //    evaluate local illumination model using the aspect value
   //    return the computed radiance
   private Color3 shade(HitData hitData)
   {
      //************* third attempt *************
      Vector3 rayDir = hitData.getRay().getDirection();
      // intersectPos = rayPos + (rayDir * distance)
      Vector3 intersectPos = hitData.getRay().getOrigin().add(rayDir.multiply(hitData.getDistance())); //same as intersectionPoint
      Vector3 normal = hitData.getShape().normal(intersectPos);
      // reflectDir = rayDir - (normal * (2 * (normal dot rayDir)))
      Vector3 reflectDir = rayDir.subtract(normal.multiply(Vector3.dot(normal, rayDir) * 2f));

      Color3 color = new Color3(0, 0, 0); //hitData.getShape().getMaterial().getColor();

      for (PointLight light : scene.getLights())
      {
         Vector3 shadowRayDir = light.getPosition().subtract(intersectPos);
         shadowRayDir.normalize();
         if (Vector3.dot(normal, shadowRayDir) < 0) //not facing towards light source
         {
            continue; //avoid unneccesary computation
         }
         float shadowRayMagnitude = shadowRayDir.getMagnitude();
         Ray shadowRay = new Ray(intersectPos, shadowRayDir, Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY);
         boolean isInShadow = false;
         for (Shape shape : scene.getShapes())
         {
            float t = shape.intersect(shadowRay); //distance to intersection
            if (t > 0 && t < shadowRayMagnitude)
            {
               isInShadow = true;
               break;
            }
         }

         if (!isInShadow)
         {
            Material mat = hitData.getShape().getMaterial();

            float illum = Vector3.dot(shadowRayDir, normal);
            Color3 lcolor = illum > 0 ? light.getColor().multiply(illum) : new Color3(0, 0, 0);
            float specular = Vector3.dot(shadowRayDir, reflectDir.getNormalized());
            Color3 scolor = specular > 0 ? light.getColor().multiply((float) Math.pow(specular, mat.getRoughness())) : new Color3(0, 0, 0);
            color = color.add(lcolor.add(scolor.multiply(mat.getSpecular())));
         }

//         reflectDir.normalize();
//         Ray reflectRay = new Ray(intersectPos.add(N), reflectDir, 0.1f, 1000f);
//         Color3 reflection = traceRay(reflectRay);

//         Color3 shapeColor = hitData.getShape().getMaterial().getColor();
//         Color3 lightColor = light.getColor();
//
//         float diff = dot * hitData.getShape().getMaterial().getDiffuse();
//
//         //add diffuse component to ray color
//         //color += diff * shapeColor * lightColor;
//         //color = color.add(shapeColor.multiply(lightColor).multiply(diff));
//         color = color.add(shapeColor).add(lightColor);
      }

      /**
       * http://cs.fit.edu/~wds/classes/adv-graphics/raytrace/raytrace.html
       * Refraction formula: n1 and n2 are the indices of refraction in the
       * incident and transmitted media (e.g. air to water) cosTheta = sqrt[1 -
       * (n1/n2)^2 * (1 - (normal dot rayDir)^2)] transmissionRay (refraction) =
       * (n1/n2) * rayDir - [cosTheta + (n1/n2)*(normal dot rayDir)] * normal
       *
       */

//      if (depth >= scene.getMaxDepth())
//      {
//         return color.add(new Color3(50, 50, 50));
//      }
      //TODO: add reflection color
      return color.add(hitData.getShape().getMaterial().getColor());
   }

   private Color3 traceRay(Ray ray)
   {
      Shape shapeHit = null;
      float closestHit = scene.getCamera().getFarClippingPlane();

      for (Shape shape : scene.getShapes())
      {
         float t = shape.intersect(ray); //distance to intersection
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
         HitData hitData = new HitData(shapeHit, ray, closestHit);
         return shade(hitData);
      }

      return scene.getBackgroundColor(); //no intersection found
   }
}
