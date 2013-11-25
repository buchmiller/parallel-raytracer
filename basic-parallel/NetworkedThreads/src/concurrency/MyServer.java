package concurrency;

import java.net.Socket;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyServer
{
   private Socket client;
   private int poolSize = 12;

   public void start()
   {
      ExecutorService executorService = Executors.newFixedThreadPool(2);
      CompletionService<ResultData> completionService =
            new ExecutorCompletionService<>(executorService);

      for (int i = 0; i < poolSize; i++)
      {
         completionService.submit(new ServerCallable(i));
      }

      executorService.shutdown();

      for (int i = 0; i < poolSize; i++)
      {
         try
         {
            ResultData result = completionService.take().get();
            System.out.println("Completed row " + result.getRow());
         }
         catch (InterruptedException e)
         {
            System.out.println("Error: Interrupted exception\n" + e);
         }
         catch (ExecutionException e)
         {
            System.out.println("Error: get() threw exception\n" + e);
         }
      }
   }
}
