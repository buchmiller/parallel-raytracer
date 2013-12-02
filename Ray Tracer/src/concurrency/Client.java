package concurrency;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import math.Color3;
import math.Vector3;
import scene.Camera;
import scene.Scene;
import scene.Screen;

public class Client
{
   private List<String> serverNames;
   private int port;
   private List<Socket> servers = new ArrayList<>();
   private Scene testScene;

   public Client(List<String> serverNames, int port)
   {
      this.serverNames = serverNames;
      this.port = port;

      testScene = new Scene(new Camera(new Vector3(1, 1, 1), new Vector3(1, 1, 1)), new Screen(10, 10), new Color3(0, 0, 0), 5);
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

   public void sendSceneData()
   {
      System.out.println("Sending scene data to servers...");

      for (Socket socket : servers)
      {
         try
         {
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

            //write out scene data
            oos.writeObject(testScene);

            //read in confirmation that data was received
            System.out.println("Received from server: '" + in.readUTF() + "'");
         }
         catch (IOException e)
         {
            System.out.println("Error: " + e);
         }

      }
   }

   public void sendRowData()
   {
      System.out.println("Sending thread/row data to servers...");

      int numTasksEach = testScene.getScreen().getHeight() / servers.size();
      System.out.println("Numtasks = " + numTasksEach);

      for (Socket socket : servers)
      {
         try
         {
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            //write out number of threads to use
            out.writeUTF("2");

            //write out row numbers to process
            out.writeUTF("0-3");
         }
         catch (IOException e)
         {
            System.out.println("Error: " + e);
         }

      }
   }

   public void getRenderData()
   {
      System.out.println("Getting render data from servers");

      for (Socket socket : servers)
      {
         try
         {
            DataInputStream in = new DataInputStream(socket.getInputStream());
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

//            System.out.println("Received from server: '" + in.readUTF() + "'");
            ResultData result = (ResultData) ois.readObject();
            System.out.println("Received from server: '" + result.getRow() + "'");

            //TODO: put these in a finally statement
            in.close();
            ois.close();
         }
         catch (IOException e)
         {
            System.out.println("Error: " + e);
         }
         catch (ClassNotFoundException e)
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
}
