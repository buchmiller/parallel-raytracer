package networkedthreads;

import concurrency.MyServer;
import java.io.IOException;

public class Server
{
   public static void main(String[] args)
   {
      try
      {
         Thread t = new MyServer(3000);
         t.start();
      }
      catch (IOException e)
      {
         System.out.println("Error: " + e);
      }
   }
}
