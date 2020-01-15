import java.awt.Graphics;

public class Winter extends Season
{
   public Winter(Forest forest)
   {
      super(forest);
   }
   
   //winter knows that the next season is summer
   public void nextSeason()
   {
      Forest forest = getForest();
      forest.setState(forest.getSummerState());
   }

   public void draw(Graphics g)
   {
      Forest forest = getForest();
      forest.drawWinterTrees(g);
   }
}

