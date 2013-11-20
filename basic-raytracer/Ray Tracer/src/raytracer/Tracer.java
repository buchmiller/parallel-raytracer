package raytracer;

import math.Color3;
import math.Vector3;
import scene.ISect;
import scene.Material;
import scene.PointLight;
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

   private Color3 shade(ISect hitData)
   {
      Vector3 intersectPoint = hitData.getRay().getOrigin().add(hitData.getRay().getDirection().multiply(hitData.getDistance()));

      //************* third attempt *************
      Vector3 d = hitData.getRay().getDirection();
      Vector3 pos = d.multiply(hitData.getDistance()).add(hitData.getRay().getOrigin()); //same as intersectionPoint
      Vector3 normal = hitData.getShape().normal(pos);
      Vector3 reflectDir = d.subtract(normal.multiply(Vector3.dot(normal, d) * 2f));

      Color3 color = new Color3(0, 0, 0); //hitData.getShape().getMaterial().getColor();

      for (PointLight light : scene.getLights())
      {
         Vector3 ldis = light.getPosition().subtract(pos);
         Vector3 livec = ldis.getNormalized();
         //float neatIsect =
         Ray shadowRay = new Ray(pos, livec, Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY);
         boolean isInShadow = false;
         for (Shape shape : scene.getShapes())
         {
            float neatIsect = shape.intersect(shadowRay);
            if (neatIsect > 0 && neatIsect < ldis.getMagnitude())
            {
               isInShadow = true;
               break;
            }
         }

         if (!isInShadow)
         {
            Material mat = hitData.getShape().getMaterial();

            float illum = Vector3.dot(livec, normal);
            Color3 lcolor = illum > 0 ? light.getColor().multiply(illum) : new Color3(0, 0, 0);
            float specular = Vector3.dot(livec, reflectDir.getNormalized());
            Color3 scolor = specular > 0 ? light.getColor().multiply((float) Math.pow(specular, mat.getRoughness())) : new Color3(0, 0, 0);
            color = color.add((lcolor.multiply(mat.getDiffuse())).add(scolor.multiply(mat.getSpecular())));
         }


         //************* second attempt *************
//         Vector3 L = hitData.getShape().getPosition().subtract(intersectPoint);
//         L.normalize();
//         Vector3 N = hitData.getShape().normal(intersectPoint);
//         N.normalize();
//         Vector3 reflectDir = hitData.getRay().getDirection().subtract(intersectPoint.multiply(2.0f).multiply(Vector3.dot(hitData.getRay().getDirection(), intersectPoint)));
//         reflectDir.normalize();
//         Ray reflectRay = new Ray(intersectPoint.add(N), reflectDir, 0.1f, 1000f);
//         Color3 reflection = traceRay(reflectRay);
//         if (hitData.getShape().getMaterial().getDiffuse() > 0)
//         {
//            float dot = Vector3.dot(N, L);
//            if (dot > 0) //must be facing towards light source
//            {
//               Color3 shapeColor = hitData.getShape().getMaterial().getColor();
//               Color3 lightColor = light.getColor();
//
//               float diff = dot * hitData.getShape().getMaterial().getDiffuse();
//
//               //add diffuse component to ray color
//               //color += diff * shapeColor * lightColor;
//               //color = color.add(shapeColor.multiply(lightColor).multiply(diff));
//               color = color.add(shapeColor).add(lightColor);
//            }
//         }
         //************* first attempt *************
         //Vector3 rayDir = light.getPosition().subtract(intersection.getPosition());
         //Ray shadowRay = new Ray(intersection.getPosition(), rayDir, Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY);
//         boolean isInShadow = false;
//         for (Shape shape : scene.getShapes())
//         {
//            //float t = shape.intersect(shadowRay);
//            //if (t > 0)
//            {
//               isInShadow = true;
//               break;
//            }
//         }
      }

      if (depth >= scene.getMaxDepth())
      {
         return color.add(new Color3(50, 50, 50));
      }

      //TODO: add reflection color
      
      return color.add(hitData.getShape().getMaterial().getColor());
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
         //return shapeHit.getMaterial().getColor();
         ISect hitData = new ISect(shapeHit, ray, closestHit);
         return shade(hitData);
      }

      return scene.getBackgroundColor();
   }
}
