import java.awt.Color;
import java.awt.Graphics;

public class Leaves extends Ellipse
{

   public Leaves(int centerX, int centerY, int width, int height)
   {
      super(centerX, centerY, width, height, Color.GREEN);
   }

   public Leaves(int centerX, int centerY, int width, int height, Color color)
   {
      super(centerX, centerY, width, height, color);
   }

}

