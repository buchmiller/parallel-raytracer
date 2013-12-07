package server;

import java.io.IOException;

public class ServerDriver
{
   public static void main(String[] args)
   {
      try
      {
         Thread t = new Server(3000);
         t.start();
      }
      catch (IOException e)
      {
         System.out.println("Error: " + e);
      }
   }
}
