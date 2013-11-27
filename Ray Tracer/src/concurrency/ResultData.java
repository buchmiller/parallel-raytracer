package concurrency;

import java.io.Serializable;

public class ResultData implements Serializable
{
   private int row;

   public ResultData(int row)
   {
      this.row = row;
   }

   public int getRow()
   {
      return row;
   }
}
