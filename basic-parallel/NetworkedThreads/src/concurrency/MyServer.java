package concurrency;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyServer extends Thread
{
   private ServerSocket serverSocket;
   private Socket client;
   private int poolSize = 12;

   public MyServer(int port) throws IOException
   {
      serverSocket = new ServerSocket(port);
   }

   @Override
   public void run()
   {
      try
      {
         System.out.println("Server started with address: " + InetAddress.getLocalHost());
      }
      catch (Exception e)
      {
         System.out.println("Error: " + e);
      }

      while (true)
      {
         try
         {
            System.out.println("\nWaiting for client on port " + serverSocket.getLocalPort() + "...");
            try (Socket server = serverSocket.accept())
            {
               System.out.println("Just connected to " + server.getRemoteSocketAddress());

               DataInputStream in = new DataInputStream(server.getInputStream());
               System.out.println(in.readUTF());

               DataOutputStream out = new DataOutputStream(server.getOutputStream());

               out.writeUTF("Thank you for connecting to " + server.getLocalSocketAddress() + "\nGoodbye!");
            }
         }
         catch (SocketTimeoutException e)
         {
            System.out.println("Socket timed out!\n" + e);
         }
         catch (IOException e)
         {
            System.out.println("Error: " + e);
         }
      }
   }

   public void begin()
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
