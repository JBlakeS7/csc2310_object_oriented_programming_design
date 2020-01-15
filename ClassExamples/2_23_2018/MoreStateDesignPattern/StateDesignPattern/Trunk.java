import java.awt.Color;
import java.awt.Graphics;

public class Trunk extends Rectangle
{

   public Trunk(int centerX, int baseY, int width, int height)
   {
      super(centerX, baseY - height/2, width, height, new Color(87,42,5));
   }

}

