package server;

import common.raytracer.TracerCallable;
import common.ResultData;
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
import common.scene.Scene;

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
         System.out.println("Error 0: " + e);
      }

      while (true)
      {
         try
         {
            System.out.println("\nWaiting for client on port " + serverSocket.getLocalPort() + "...");
            try (Socket server = serverSocket.accept())
            {
               System.out.println("Client has connected: " + server.getRemoteSocketAddress());

               while (true) //jumps out of loop when socket is closed
               {
                  ObjectInputStream inStream = new ObjectInputStream(server.getInputStream());

                  //read in scene
                  scene = (Scene) inStream.readObject();
                  System.out.println("Received scene");

                  //read in number of threads
                  int numThreads = inStream.readInt();
                  System.out.println("Number of threads to use: " + numThreads);

                  //read in row numbers
                  List<Integer> rowNumbers = (ArrayList<Integer>) inStream.readObject();
                  System.out.println("Row numbers received.");

                  //write out results
                  ObjectOutputStream outStream = new ObjectOutputStream(server.getOutputStream());
                  startTasks(numThreads, rowNumbers, outStream);
               }
            }
         }
         catch (SocketTimeoutException e)
         {
            System.out.println("Socket timed out!\n" + e);
         }
         catch (IOException e)
         {
            System.out.println("Error 1: " + e);
         }
         catch (ClassNotFoundException e)
         {
            System.out.println("Error 2: " + e);
         }
      }
   }

   public void startTasks(int numThreads, List<Integer> rowNumbers, ObjectOutputStream outStream)
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
            outStream.writeObject(result);
         }
         catch (InterruptedException e)
         {
            System.out.println("Error: Interrupted exception\n" + e);
         }
         catch (ExecutionException e)
         {
            System.out.println("Error: get() threw exception\n" + e);
         }
         catch (IOException e)
         {
            System.out.println("Error: outStream threw exception\n" + e);
         }
      }
   }
}
