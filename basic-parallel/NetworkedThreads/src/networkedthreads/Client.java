package networkedthreads;

import concurrency.MyClient;

public class Client
{
   public static void main(String[] args)
   {
      String hostName = "Sam-PC";
      if (args.length > 0)
      {
         hostName = args[0];
      }

      MyClient client = new MyClient(hostName, 3000);
      client.makeConnections();
   }
}
