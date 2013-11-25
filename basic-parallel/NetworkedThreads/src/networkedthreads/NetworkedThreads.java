package networkedthreads;

import concurrency.MyServer;

public class NetworkedThreads
{
    public static void main(String[] args)
    {
        MyServer server = new MyServer();
        server.start();
    }
}
