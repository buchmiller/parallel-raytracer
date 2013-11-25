package concurrency;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class MyClient
{
   public MyClient()
   {
      String serverName = "Sam-PC";
      int port = 3000;
      
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
