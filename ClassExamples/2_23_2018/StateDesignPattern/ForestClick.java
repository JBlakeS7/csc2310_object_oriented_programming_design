import java.awt.Color;
import java.awt.Graphics;

public class ForestClick implements Drawable
{
   private Visual[] visual;
   private Forest forest;

   public void draw(Graphics g, int width, int height)
   {   
      g.setColor(Color.black);
      g.fillRect(0, 0, width, height);

      for (Visual v : visual)
      {
         v.draw(g);
      }
   }

   public void mouseClicked(int x, int y)
   {
      forest.nextSeason();  //change state
   }

   public ForestClick()
   {      
      Visual back = new Picture("background.jpg");
      forest = new Forest(5, 20, 620, 350, 460, 60, 80, 200, 300, 35, 55);

      visual = new Visual[2];
      visual[0] = back;
      visual[1] = forest;

      ForestGUI p = new ForestGUI(640, 480, this);
   }

   public static void main(String[] args)
   {
      ForestClick fc = new ForestClick();
   }
}