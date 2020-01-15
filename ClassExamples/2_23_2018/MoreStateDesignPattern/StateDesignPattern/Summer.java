import java.awt.Graphics;

public class Summer extends Season
{
   public Summer(Forest forest)
   {
      super(forest);
   }
   
   //summer knows that the next season is autumn
   public void nextSeason()
   {
      Forest forest = getForest();
      forest.setState(forest.getAutumnState());
   }

   public void draw(Graphics g)
   {
      Forest forest = getForest();
      forest.drawSummerTrees(g);
   }
}

