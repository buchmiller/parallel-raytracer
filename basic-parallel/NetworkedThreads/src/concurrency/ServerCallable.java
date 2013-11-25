package concurrency;

import java.util.concurrent.Callable;

public class ServerCallable implements Callable
{
   private int row;

   public ServerCallable(int row)
   {
      this.row = row;
   }

   @Override
   public ResultData call() throws Exception
   {
      Thread.sleep(1000);
      return new ResultData(row);
   }

}
