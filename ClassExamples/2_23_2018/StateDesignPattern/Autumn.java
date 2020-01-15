import java.awt.Graphics;

public class Autumn extends Season
{
   public Autumn(Forest forest)
   {
      super(forest);
   }
   
   //autumn knows that the next season is winter
   public void nextSeason()
   {
      Forest forest = getForest();
      forest.setState(forest.getWinterState());
   }

   public void draw(Graphics g)
   {
      Forest forest = getForest();
      forest.drawAutumnTrees(g);
   }
}

