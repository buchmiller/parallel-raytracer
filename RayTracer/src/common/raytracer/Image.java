package common.raytracer;

import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;

public class Image
{
   private int width;
   private int height;
   private Color3[][] pixels;

   public Image(int width, int height)
   {
      this.width = width;
      this.height = height;
      pixels = new Color3[height][width];
   }

   public void setRow(int row, Color3[] colors)
   {
      pixels[row] = colors;
   }

   public void saveImageToFile(String fileName)
   {
      BufferedImage img = getBufferedImage();

      try
      {
         ImageIO.write(img, "bmp", new File(fileName + ".bmp"));
      }
      catch (IOException e)
      {
         System.out.println("Error writing image to file: " + e);
      }
   }

   public BufferedImage getBufferedImage()
   {
      BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

      for (int row = 0; row < height; row++)
      {
         for (int col = 0; col < width; col++)
         {
            Color3 color = pixels[row][col];

            int red = (int) color.getR();
            red = Math.max(red, 0);
            red = Math.min(255, red);

            int green = (int) color.getG();
            green = Math.max(green, 0);
            green = Math.min(255, green);

            int blue = (int) color.getB();
            blue = Math.max(blue, 0);
            blue = Math.min(255, blue);

            int rgb = (red << 16) | (green << 8) | blue;
            img.setRGB(col, row, rgb);
            //System.out.print(color.toString() + " | ");
         }
         //System.out.println();
      }

      return img;
   }

   public void displayImage()
   {
      BufferedImage img = getBufferedImage();
      ImageIcon icon = new ImageIcon(img);
      JDialog dialog = new JDialog();
      dialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
      dialog.setLayout(new FlowLayout());
      dialog.setSize(img.getWidth(), img.getHeight());
      JLabel lbl = new JLabel();
      lbl.setIcon(icon);
      dialog.add(lbl);
      dialog.setVisible(true);
   }
}
