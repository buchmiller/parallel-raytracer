package concurrency;

import java.io.Serializable;
import math.Color3;

public class ResultData implements Serializable
{
   private int row;
   Color3[] colors;

   public ResultData(int row, Color3[] colors)
   {
      this.row = row;
      this.colors = colors;
   }

   public int getRow()
   {
      return row;
   }

   public Color3[] getColors()
   {
      return colors;
   }
}
