package concurrency;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Client
{
   private List<String> serverNames;
   private int port;
   private List<Socket> servers = new ArrayList<>();

   public Client(List<String> serverNames, int port)
   {
      this.serverNames = serverNames;
      this.port = port;
   }

   public void openConnections()
   {
      for (String serverName : serverNames)
      {
         try
         {
            System.out.println("Connecting to " + serverName + " on port " + port);
            Socket socket = new Socket(serverName, port);
            servers.add(socket);
            System.out.println("Now connected to " + socket.getRemoteSocketAddress());
         }
         catch (IOException e)
         {
            System.out.println("Error: " + e);
         }
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

            out.writeUTF("SCENE DATA");

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
      System.out.println("Sending row data to servers...");

      for (Socket socket : servers)
      {
         try
         {
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            out.writeUTF("Rows 0 - 11");
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
            System.out.println("Received from server: '" + in.readUTF() + "'");
         }
         catch (IOException e)
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
