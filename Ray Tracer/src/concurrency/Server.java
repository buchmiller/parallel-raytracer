package concurrency;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import scene.Scene;

public class Server extends Thread
{
   private ServerSocket serverSocket;
   private Socket client;
   private int poolSize = 12; //TODO: this will eventually come from Scene

   public Server(int port) throws IOException
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
               System.out.println("Client has connected: " + server.getRemoteSocketAddress());

               DataInputStream in = new DataInputStream(server.getInputStream());
               DataOutputStream out = new DataOutputStream(server.getOutputStream());

               ObjectInputStream ois = new ObjectInputStream(server.getInputStream());
               Scene scene = (Scene) ois.readObject();
               System.out.println("Scene background color: " + scene.getBackgroundColor());
//               System.out.println("Received from client: '" + in.readUTF() + "'");

               out.writeUTF("Scene received");

               System.out.println("Received from client: '" + in.readUTF() + "'");

               //begin();

               //out.writeUTF("RENDER DATA");
               ObjectOutputStream oos = new ObjectOutputStream(server.getOutputStream());
               oos.writeObject(new ResultData(5));

               //TODO: Put these in a finally statement
               in.close();
               out.close();
               oos.close();
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
         catch (ClassNotFoundException e)
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
