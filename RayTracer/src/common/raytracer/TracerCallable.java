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
         colors[col] = traceRay(ray, 0);
      }

      return new ResultData(row, colors);
   }

   //    retrieve aspect value of intersected object at intersection point
   //    evaluate local illumination model using the aspect value
   //    return the computed radiance
   private Color3 shade(HitData hitData, int depth)
   {
      Vector3 rayDir = hitData.getRay().getDirection();
      // intersectPos = rayPos + (rayDir * distance)
      Vector3 intersectPos = hitData.getRay().getOrigin().add(rayDir.multiply(hitData.getDistance())); //same as intersectionPoint
      Vector3 normal = hitData.getShape().normal(intersectPos);
      // reflectDir = rayDir - (normal * (2 * (normal dot rayDir)))
      Vector3 reflectDir = rayDir.subtract(normal.multiply(Vector3.dot(normal, rayDir) * 2f));

      Color3 color = Color3.BLACK; //hitData.getShape().getMaterial().getColor();

      for (PointLight light : scene.getLights())
      {
         Vector3 shadowRayDir = light.getPosition().subtract(intersectPos);
         shadowRayDir.normalize();
         if (Vector3.dot(shadowRayDir, normal) < 0) //not facing towards light source
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

            float illum = Vector3.dot(shadowRayDir, normal); //TODO this is repetitive
            Color3 lightColor = light.getColor().multiply(illum);
            float lightIntensity = light.getIntensity(intersectPos);
            float specular = Vector3.dot(shadowRayDir, reflectDir.getNormalized());
            Color3 specularColor = specular > 0 ? light.getColor().multiply((float) Math.pow(specular, mat.getRoughness())) : Color3.BLACK;
            color = color.add(lightColor.add(specularColor.multiply(mat.getSpecular())).multiply(lightIntensity));
         }
      }


//      if (depth >= scene.getMaxDepth())
//      {
//         return color.add(new Color3(50, 50, 50));
//      }

      if (depth < scene.getMaxDepth())
      {
         /**
          * http://cs.fit.edu/~wds/classes/adv-graphics/raytrace/raytrace.html
          * Refraction formula: n1 and n2 are the indices of refraction in the
          * incident and transmitted media (e.g. air to water) cosTheta = sqrt[1 -
          * (n1/n2)^2 * (1 - (normal dot rayDir)^2)] transmissionRay (refraction) =
          * (n1/n2) * rayDir - [cosTheta + (n1/n2)*(normal dot rayDir)] * normal
          *
          */
          reflectDir.normalize();
          Ray reflectRay = new Ray(intersectPos, reflectDir, Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY);
          Color3 reflectColor = traceRay(reflectRay, depth + 1);
          color = color.add(reflectColor.multiply(hitData.getShape().getMaterial().getReflect()));
      }
      return color.add(hitData.getShape().getMaterial().getColor());
   }

   private Color3 traceRay(Ray ray, int depth)
   {
      Shape shapeHit = null;
      float closestHit = scene.getCamera().getFarClippingPlane();

      for (Shape shape : scene.getShapes())
      {
         float t = shape.intersect(ray); //distance to intersection
         if (t > 0)
         {
            if (t < closestHit && t > ray.getMin())
            {
               closestHit = t;
               shapeHit = shape;
            }
         }
      }

      if (shapeHit != null)
      {
         HitData hitData = new HitData(shapeHit, ray, closestHit);
         return shade(hitData, depth);
      }

      return scene.getBackgroundColor(); //no intersection found
   }
}
