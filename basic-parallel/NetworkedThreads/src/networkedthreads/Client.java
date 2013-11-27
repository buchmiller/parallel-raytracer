package networkedthreads;

import concurrency.MyClient;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Client
{
   public static void main(String[] args)
   {
      if (args.length < 1)
      {
         System.out.println("Must enter host names");
         return;
      }

      List<String> serverNames = new ArrayList<>();
      serverNames.addAll(Arrays.asList(args));

      try
      {
         MyClient client = new MyClient(serverNames, 3000);
         client.openConnections();
         Thread.sleep(1000); //Delay added for testing purposes only
         client.sendSceneData();
         Thread.sleep(1000); //Delay added for testing purposes only
         client.sendRowData();
         Thread.sleep(1000); //Delay added for testing purposes only
         client.getRenderData();
         Thread.sleep(1000); //Delay added for testing purposes only
         client.closeConnections();
      }
      catch (InterruptedException e)
      {
         System.out.println("Sleep Thread interrupted: " + e);
      }
   }
}
