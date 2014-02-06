package client;

import common.ResultData;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import common.raytracer.Color3;
import common.raytracer.Vector3;
import common.raytracer.Image;
import common.raytracer.TracerCallable;
import common.scene.Camera;
import common.scene.Scene;
import common.scene.Screen;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;

public class Client
{
   private List<String> serverNames;
   private int defaultPort;
   private List<Socket> servers = new ArrayList<>();
   private Scene testScene;
   private Image image;
   int numTasksEach;

   public Client(List<String> serverNames, int port)
   {
      this.serverNames = serverNames;
      this.defaultPort = port;
   }

   public Client(int port)
   {
      this(new ArrayList<String>(), port);
   }

   public Client()
   {
      this(new ArrayList<String>(), 3000);
   }

   public void chooseScene(Scene.Type type, int width, int height, int maxDepth)
   {
      //Data for a test scene
      image = new Image(width, height);
      Camera camera = new Camera(new Vector3(0, 0, 0), new Vector3(0, 0, 0));
      Screen screen = new Screen(width, height);
      Color3 bColor = new Color3(0, 0, 0);

      testScene = Scene.createScene(type, camera, screen, bColor, maxDepth);
   }

   public void openConnections() throws IOException
   {
      for (String serverName : serverNames)
      {
         System.out.println("Connecting to " + serverName + " on port " + defaultPort);
         Socket socket = new Socket(serverName, defaultPort);
         servers.add(socket);
         System.out.println("Now connected to " + socket.getRemoteSocketAddress());

      }
   }

   public void connectTo(String serverName, int portNum) throws IOException
   {
      Socket socket = new Socket(serverName, portNum);
      serverNames.add(serverName + ":" + portNum);
      servers.add(socket);
   }

   public void disconnectFrom(String hostName) throws IOException
   {
      int index = serverNames.indexOf(hostName);
      servers.get(index).close();
      servers.remove(index);
      serverNames.remove(index);
   }

   public void startRunnables(int numThreadsOnServer)
   {
      //TODO: make this use a specified number of threads
      ExecutorService executorService = Executors.newFixedThreadPool(servers.size());

      numTasksEach = testScene.getScreen().getHeight() / servers.size();
      System.out.println("NumtasksEach = " + numTasksEach);

      //create list of row numbers for partitioning
      List<Integer> rowNums = new ArrayList<>();
      for (int i = 0; i < testScene.getScreen().getHeight(); i++)
      {
         rowNums.add(i);
      }

      try
      {
         int i = 0;
         int serverNumber = 0;
         for (Socket socket : servers)
         {
            executorService.submit(new ClientRunnable(serverNumber, socket, testScene, image, numTasksEach,
                                                      rowNums.subList(i, i + Math.min(numTasksEach, rowNums.size() - i)),
                                                      numThreadsOnServer));
            i += numTasksEach;
            serverNumber++;
         }
      }
      finally
      {
         executorService.shutdown();
      }

      try
      {
         executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
         System.out.println("All image data received.");
      }
      catch (InterruptedException e)
      {
         System.out.println("Await termination interrupted: " + e);
      }

   }

   public void sendData()
   {
      System.out.println("Sending scene/thread/row data to servers...");
      numTasksEach = testScene.getScreen().getHeight() / servers.size();
      System.out.println("NumtasksEach = " + numTasksEach);

      //create list of row numbers for partitioning
      List<Integer> rowNums = new ArrayList<>();
      for (int i = 0; i < testScene.getScreen().getHeight(); i++)
      {
         rowNums.add(i);
      }

      int i = 0;
      for (Socket socket : servers)
      {
         try
         {
            ObjectOutputStream outStream = new ObjectOutputStream(socket.getOutputStream());

            //write out the scene
            outStream.writeObject(testScene);

            //write out number of threads to use
            outStream.writeInt(2);

            //write out row numbers to process
            outStream.writeObject(new ArrayList<>(rowNums.subList(i, i + Math.min(numTasksEach, rowNums.size() - i))));

         }
         catch (IOException e)
         {
            System.out.println("Error: " + e);
         }

         i += numTasksEach;
      }
   }

   public void getRenderData()
   {
      System.out.println("Getting render data from servers");

      for (Socket socket : servers)
      {
         try
         {
            ObjectInputStream inStream = new ObjectInputStream(socket.getInputStream());

            for (int i = 0; i < numTasksEach; i++)
            {
               ResultData result = (ResultData) inStream.readObject();
               System.out.println("Received data for row: " + result.getRow());
               image.setRow(result.getRow(), result.getColors());
            }
         }
         catch (IOException | ClassNotFoundException e)
         {
            System.out.println("Error: " + e);
         }
      }
   }

   public void closeConnections()
   {
      System.out.println("Closing socket connections to servers");

      for (Socket socket : servers)
      {
         try
         {
            socket.close();
         }
         catch (IOException e)
         {
            System.out.println("Error closing socket connections: " + e);
         }
      }
   }

   public void runLocally(int numThreads)
   {
      Scene scene = testScene;
      int numRows = scene.getScreen().getHeight();

      ExecutorService executorService = Executors.newFixedThreadPool(numThreads);
      CompletionService<ResultData> completionService =
            new ExecutorCompletionService<>(executorService);

      for (int row = 0; row < numRows; row++)
      {
         completionService.submit(new TracerCallable(scene, row));
      }

      executorService.shutdown();

      for (int i = 0; i < numRows; i++)
      {
         try
         {
            ResultData result = completionService.take().get();
//            System.out.println("Completed row " + result.getRow());
            image.setRow(result.getRow(), result.getColors());
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

   public void saveImageToFile(String fileName)
   {
      image.saveImageToFile(fileName);
   }

   public void saveImageToFile()
   {
      saveImageToFile("output");
   }

   public void displayImage()
   {
      image.displayImage();
   }
}
