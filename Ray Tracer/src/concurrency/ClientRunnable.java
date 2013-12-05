package concurrency;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import raytracer.Image;
import scene.Scene;

public class ClientRunnable implements Runnable
{
   private Scene scene;
   private Socket server;
   private Image image;
   private int numTasksEach;
   private List rowNums;

   public ClientRunnable(Socket server, Scene scene, Image image, int numTasksEach, List rowNums)
   {
      this.server = server;
      this.scene = scene;
      this.image = image;
      this.numTasksEach = numTasksEach;
      this.rowNums = new ArrayList(rowNums);
   }

   @Override
   public void run()
   {
      sendData();
      getRenderData();
      closeConnection();
   }

   public void sendData()
   {
      System.out.println("Sending scene/thread/row data to servers...");

      try
      {
         ObjectOutputStream outStream = new ObjectOutputStream(server.getOutputStream());

         //write out the scene
         outStream.writeObject(scene);

         //write out number of threads to use
         outStream.writeInt(2);

         //write out row numbers to process
         outStream.writeObject(rowNums);

      }
      catch (IOException e)
      {
         System.out.println("Error: " + e);
      }
   }

   public void getRenderData()
   {
      System.out.println("Getting render data from servers");

      try
      {
         ObjectInputStream inStream = new ObjectInputStream(server.getInputStream());

         for (int i = 0; i < numTasksEach; i++)
         {
            ResultData result = (ResultData) inStream.readObject();
            System.out.println("Received data for row: " + result.getRow());
            image.setRow(result.getRow(), result.getColors());
         }
      }
      catch (IOException | ClassNotFoundException e)
      {
         System.out.println("Error: " + e);
      }
   }

   public void closeConnection()
   {
      System.out.println("Closing socket connections to servers");

      try
      {
         server.close();
      }
      catch (IOException e)
      {
         System.out.println("Error closing socket connections: " + e);
      }

   }
}
