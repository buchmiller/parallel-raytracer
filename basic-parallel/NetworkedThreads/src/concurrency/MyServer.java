package concurrency;

import java.net.Socket;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MyServer
{
   private Socket client;
   Set<Callable<ResultData>> callables = new HashSet<>();

   public void start()
   {
      for (int i = 0; i < 10; i++)
      {
         callables.add(new ServerCallable(i));
      }

      try
      {
         ExecutorService executorService = Executors.newFixedThreadPool(4);

         List<Future<ResultData>> futures = executorService.invokeAll(callables);

         for (Future<ResultData> future : futures)
         {
            System.out.println("Row " + future.get().getRow());
         }

         executorService.shutdown();
      }
      catch (Exception e)
      {
         System.out.println("Error: " + e);
      }
   }
}
