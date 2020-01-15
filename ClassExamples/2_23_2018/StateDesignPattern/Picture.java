import java.awt.*;
import java.io.IOException;
import java.io.File;

public class Picture implements Visual
{
   private static final ImageLoader il = new ImageLoader();
   private Image back;

   public Picture(String fileName)
   {
      back = il.getImage(fileName);
   }

   public void draw(Graphics g)  //x, y represent the upper left corner of the image
   {
      g.drawImage(back, 0, 0, null);
   }
}

