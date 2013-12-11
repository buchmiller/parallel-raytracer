package server;

import java.io.IOException;

public class ServerDriver
{
   public static void main(String[] args)
   {
      if (args.length < 1)
      {
         System.out.println("Must enter port number");
         return;
      }

      try
      {
         int port = Integer.parseInt(args[0]);
         Thread t = new Server(port);
         t.start();
      }
      catch (NumberFormatException e)
      {
         System.out.println("Error: port must be an integer.\n" + e);
      }
      catch (IOException e)
      {
         System.out.println("Error: " + e);
      }
   }
}
