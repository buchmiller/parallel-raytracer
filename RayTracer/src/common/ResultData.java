package common;

import common.raytracer.Color3;
import java.io.Serializable;

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
