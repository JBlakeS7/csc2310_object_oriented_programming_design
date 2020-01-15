import java.awt.Graphics;

public abstract class Season implements SeasonState, Visual
{
   private Forest forest;

   public Season(Forest forest)
   {
      this.forest = forest;
   }

   public abstract void nextSeason();
   public abstract void draw(Graphics g);

   protected Forest getForest()
   {
      return forest;
   }
}