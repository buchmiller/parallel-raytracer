package client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClientDriver
{
   public static void main(String[] args)
   {
      if (args.length < 1)
      {
         Client client = new Client();
         client.runLocally(2); //Default of 2 threads
      }
      else if (args.length == 1)
      {
         try
         {
            int arg1 = Integer.parseInt(args[0]);

            if (arg1 < 10) //reasonable number for numThreads
            {
               Client client = new Client();
               client.runLocally(arg1);
               client.saveImageToFile();
               return;
            }
         }
         catch (NumberFormatException e)
         {
            //Ignore non-number argument
         }
      }

      List<String> serverNames = new ArrayList<>();
      serverNames.addAll(Arrays.asList(args));

      try
      {
         Client client = new Client(serverNames, 3000);
         client.openConnections();
         client.startRunnables(4); //use 4 threads on servers
//         client.sendData();
//         client.getRenderData();
//         client.closeConnections();

         client.saveImageToFile();
      }
      catch (IOException e)
      {
         System.out.println("Error: " + e);
      }
   }
}
