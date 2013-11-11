package scene;

import math.Vector3;

public class Camera
{
   private Vector3 position;
   private Vector3 direction;

   public Camera(Vector3 position, Vector3 direction)
   {
      this.position = position;
      this.direction = direction;
   }

   public Vector3 getPosition()
   {
      return position;
   }

   public Vector3 getDirection()
   {
      return direction;
   }
}
