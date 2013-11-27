package concurrency;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class MyClient
{
   private String serverName;
   private int port;

   public MyClient(String hostName, int port)
   {
      this.serverName = hostName;
      this.port = port;
   }

   public void makeConnections()
   {
      try
      {
         System.out.println("Connecting to " + serverName + " on port " + port);
         try (Socket client = new Socket(serverName, port))
         {
            System.out.println("Now connected to " + client.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(client.getInputStream());
            DataOutputStream out = new DataOutputStream(client.getOutputStream());

            out.writeUTF("SCENE DATA");

            System.out.println("Received from server: '" + in.readUTF() + "'");

            out.writeUTF("Rows 0 - 11");

            System.out.println("Received from server: '" + in.readUTF() + "'");
         }
      }
      catch (IOException e)
      {
         System.out.println("Error: " + e);
      }
   }
}
