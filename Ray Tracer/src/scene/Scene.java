package scene;

import java.util.ArrayList;
import java.util.List;
import math.Color3;
import math.Vector3;
import raytracer.Ray;

public class Scene
{
   private List<Shape> shapes = new ArrayList<>();
   private List<PointLight> lights = new ArrayList<>();
   private Camera camera;
   private Screen screen;
   private Color3 backgroundColor;
   private int maxDepth;

   public Scene(Camera camera, Screen screen, Color3 backgroundColor, int maxDepth)
   {
      this.camera = camera;
      this.screen = screen;
      this.backgroundColor = backgroundColor;
      this.maxDepth = maxDepth;
   }

   public void addShape(Shape shape)
   {
      shapes.add(shape);
   }

   public void addLight(PointLight light)
   {
      lights.add(light);
   }

   public List<Shape> getShapes()
   {
      return shapes;
   }

   public List<PointLight> getLights()
   {
      return lights;
   }

   public Camera getCamera()
   {
      return camera;
   }

   public Screen getScreen()
   {
      return screen;
   }

   public Color3 getBackgroundColor()
   {
      return backgroundColor;
   }

   public int getMaxDepth()
   {
      return maxDepth;
   }

   public Ray constructRay(int row, int col)
   {
      float x = (float) (2 * ((col + 0.5) / screen.getWidth()) - 1) * screen.getAspectRatio() * camera.getAngle();
      float y = (float) (1 - 2 * ((row + 0.5) / screen.getHeight())) * camera.getAngle();
      Vector3 rayDir = new Vector3(x, y, -1);
      rayDir.normalize();

      return new Ray(camera.getPosition(), rayDir, camera.getNearClippingPlane(), camera.getFarClippingPlane());
   }
}
