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
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import math.Color3;
import scene.Scene;

public class Server extends Thread
{
   private ServerSocket serverSocket; //listening socket
   private Scene scene;

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

               //read in scene
               ObjectInputStream ois = new ObjectInputStream(server.getInputStream());
               scene = (Scene) ois.readObject();
               System.out.println("Scene background color: " + scene.getBackgroundColor());
               out.writeUTF("Scene received");

               //read in number of threads
               int numThreads = Integer.parseInt(in.readUTF());
               System.out.println("Number of threads to use: " + numThreads);

               //read in row numbers
               List rowNumbers = (ArrayList) ois.readObject();
               System.out.println("Row numbers received.");

               //write out results
               startTasks(numThreads, rowNumbers);

               ObjectOutputStream oos = new ObjectOutputStream(server.getOutputStream());
               Color3[] colors = new Color3[10];
               oos.writeObject(new ResultData(5, colors));

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

   public void startTasks(int numThreads, List<Integer> rowNumbers)
   {
      ExecutorService executorService = Executors.newFixedThreadPool(numThreads);
      CompletionService<ResultData> completionService =
            new ExecutorCompletionService<>(executorService);

      for (int rowNum : rowNumbers)
      {
         completionService.submit(new TracerCallable(scene, rowNum));
      }

      executorService.shutdown();

      for (int i = 0; i < rowNumbers.size(); i++)
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
