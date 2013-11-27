package networkedthreads;

import concurrency.Client;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClientDriver
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
         Client client = new Client(serverNames, 3000);
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
