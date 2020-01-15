import java.awt.*;

public class Rectangle extends Shape
{

   public Rectangle(int centerX, int centerY, int width, int height, Color color)
   {
      super(centerX, centerY, width, height, color);
   }

   public void draw(Graphics g)
   {
      int width = getWidth();
      int height = getHeight();
      int xOffset = getCenterX() - width/2;
      int yOffset = getCenterY() - height/2;
      g.setColor(getColor());
      g.fillRect(xOffset, yOffset, width, height);  
   }

}

