package concurrency;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import math.Color3;
import math.Vector3;
import raytracer.Image;
import scene.Camera;
import scene.Material;
import scene.Plane;
import scene.PointLight;
import scene.Scene;
import scene.Screen;
import scene.Sphere;

public class Client
{
   private List<String> serverNames;
   private int port;
   private List<Socket> servers = new ArrayList<>();
   private Scene testScene;
   private Image image;

   public Client(List<String> serverNames, int port)
   {
      this.serverNames = serverNames;
      this.port = port;

      //Data for a test scene
      int width = 640;
      int height = 480;
      String fileName = "output";
      image = new Image(width, height);
      Camera camera = new Camera(new Vector3(0, 0, 0), new Vector3(0, 0, 0));
      Screen screen = new Screen(width, height);
      Color3 bColor = new Color3(0, 1, 0);
      int maxDepth = 4;

      Scene scene = new Scene(camera, screen, bColor, maxDepth);

      scene.addShape(new Sphere(new Vector3(-2, 0, -2), 1, new Material(new Color3(300, 0, 0)))); //red
      scene.addShape(new Sphere(new Vector3(2, 0, -5), 1, new Material(new Color3(0, 0, 300)))); //blue
      scene.addShape(new Sphere(new Vector3(0, 0, -10), 1, new Material(new Color3(300, 300, 0)))); //yellow
      scene.addShape(new Sphere(new Vector3(2, 0, -15), 1, new Material(new Color3(0, 300, 0)))); //green

      Vector3 normal = new Vector3(0, 1, 0);
      normal.normalize();
      scene.addShape(new Plane(new Vector3(0, -0.5f, -10), new Material(new Color3(100, 100, 100)), normal)); //grey

      normal = new Vector3(-1, 0.3f, 0);
      normal.normalize();
      scene.addShape(new Plane(new Vector3(2.2f, 0, -10), new Material(new Color3(100, 100, 100)), normal)); //grey

      //lights
      scene.addLight(new PointLight(new Vector3(-5, 10, -10), 5, new Color3(100, 100, 100)));

      testScene = scene;
   }

   public void openConnections() throws IOException
   {
      for (String serverName : serverNames)
      {
         System.out.println("Connecting to " + serverName + " on port " + port);
         Socket socket = new Socket(serverName, port);
         servers.add(socket);
         System.out.println("Now connected to " + socket.getRemoteSocketAddress());

      }
   }

   public void sendData()
   {
      System.out.println("Sending scene/thread/row data to servers...");
      int numTasksEach = testScene.getScreen().getHeight() / servers.size();
      System.out.println("NumtasksEach = " + numTasksEach);

      //create list of row numbers for partitioning
      List<Integer> rowNums = new ArrayList<>();
      for (int i = 0; i < testScene.getScreen().getHeight(); i++)
      {
         rowNums.add(i);
      }

      int i = 0;
      for (Socket socket : servers)
      {
         try
         {
            ObjectOutputStream outStream = new ObjectOutputStream(socket.getOutputStream());

            //write out the scene
            outStream.writeObject(testScene);

            //write out number of threads to use
            outStream.writeInt(2);

            //write out row numbers to process
            outStream.writeObject(new ArrayList(rowNums.subList(i, i + Math.min(numTasksEach, rowNums.size() - i))));

         }
         catch (IOException e)
         {
            System.out.println("Error: " + e);
         }

         i += numTasksEach;
      }
   }

   public void getRenderData()
   {
      System.out.println("Getting render data from servers");

      for (Socket socket : servers)
      {
         try
         {
            ObjectInputStream inStream = new ObjectInputStream(socket.getInputStream());

            ResultData result = (ResultData) inStream.readObject();
            System.out.println("Received from server: '" + result.getRow() + "'");
            image.setRow(result.getRow(), result.getColors());
         }
         catch (IOException | ClassNotFoundException e)
         {
            System.out.println("Error: " + e);
         }
      }
   }

   public void closeConnections()
   {
      System.out.println("Closing socket connections to servers");

      for (Socket socket : servers)
      {
         try
         {
            socket.close();
         }
         catch (IOException e)
         {
            System.out.println("Error closing socket connections: " + e);
         }
      }
   }

   public void saveImageToFile()
   {
      image.saveImageToFile("output");
   }
}
