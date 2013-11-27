package scene;

import java.io.Serializable;
import math.Vector3;

public class Camera implements Serializable
{
   private Vector3 position;
   private Vector3 direction;
   private float nearClippingPlane;
   private float farClippingPlane;
   private float fov;
   private float angle;

   public Camera(Vector3 position, Vector3 direction)
   {
      this(position, direction, 90f, 0.1f, 1000f);
   }

   public Camera(Vector3 position, Vector3 direction, float fov,
                 float nearClippingPlane, float farClippingPlane)
   {
      this.position = position;
      this.direction = direction;
      this.fov = fov;
      this.angle = (float) Math.atan(Math.toRadians(fov * 0.5));
      this.nearClippingPlane = nearClippingPlane;
      this.farClippingPlane = farClippingPlane;
   }

   public Vector3 getPosition()
   {
      return position;
   }

   public Vector3 getDirection()
   {
      return direction;
   }

   public float getNearClippingPlane()
   {
      return nearClippingPlane;
   }

   public float getFarClippingPlane()
   {
      return farClippingPlane;
   }

   public float getFov()
   {
      return fov;
   }

   public float getAngle()
   {
      return angle;
   }
}
