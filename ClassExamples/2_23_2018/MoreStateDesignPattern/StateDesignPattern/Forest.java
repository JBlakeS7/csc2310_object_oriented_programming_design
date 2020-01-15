import java.util.Random;
import java.awt.Graphics;

public class Forest implements Visual
{   
   private Season summer;
   private Season winter;
   private Season autumn;
   private Season season;   //the current state

   private Tree[] forest;

   private static final Random rand = new Random();

   public Forest(int num, int minX, int maxX, int minY, int maxY, int minW, int maxW, int minH, int maxH, int minD, int maxD)
   {   
      //create a bunch of randomly sized and placed trees
      forest = new Tree[num];

      for (int i = 0; i < num; i++)
      {
         //note that the min and the max cannot be the same (how about some exception handling?)
         int horiz = rand.nextInt(maxX - minX) + minX;
         int vert = rand.nextInt(maxY - minY) + minY;
         int width = rand.nextInt(maxW - minW)  + minW;
         int height = rand.nextInt(maxH - minH) + minH;
         int degrees = rand.nextInt(maxD - minD) + minD;

         forest[i] = new Tree(horiz, vert, width, height, degrees);
      }

      summer = new Summer(this);  //two-way has-a relationship
      winter = new Winter(this);
      autumn = new Autumn(this);

      season = autumn;  //starting season
   }

   //the season is advanced through the GUI
   //this method will be called when the user interacts with the GUI
   //the seasons themselves know what the next season is
   public void nextSeason()
   {
      season.nextSeason();  //changes the current state using two-way association
   }

   Season getWinterState()
   {
      return winter;
   }

   Season getSummerState()
   {
      return summer;
   }

   Season getAutumnState()
   {
      return autumn;
   }

   void setState(Season state)
   {
      season = state;
   }

   public void draw(Graphics g)
   {
     // ((Visual) season).draw(g);
       season.draw(g);
   }

   void drawSummerTrees(Graphics g)
   {
      for (Tree tree : forest)
      {
         tree.drawSummer(g);
      }
   }

   void drawAutumnTrees(Graphics g)
   {
      for (Tree tree : forest)
      {
         tree.drawAutumn(g);
      }
   }

   void drawWinterTrees(Graphics g)
   {
      for (Tree tree : forest)
      {
         tree.drawWinter(g);
      }
   }
}