import java.awt.BorderLayout;

public class ForestGUI extends FixFrame
{
   private Draw draw;

   public ForestGUI(int width, int height, Drawable d)
   {      
      super (width, height, "Seasons");

      setLayout(new BorderLayout());
      setSize(width, height);
      setResizable(false);

      draw = new Draw();

      draw.add(d);
      add(draw, BorderLayout.CENTER);

      setVisible(true);
   }

   public Draw getDraw()
   {
      return draw;
   }
}