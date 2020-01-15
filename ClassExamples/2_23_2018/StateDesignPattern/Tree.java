import java.awt.Graphics;
import java.awt.Color;

public class Tree
{
   //HAS-A
   private Branch branch1;
   private Branch branch2;
   private Trunk trunk;
   private Leaves summerLeaves;
   private Leaves autumnLeaves;

   public Tree(int centerX, int baseY, int width, int height, int degrees)
   {
      int trunkHeight = (int)(height*0.6);
      trunk = new Trunk(centerX, baseY, width, trunkHeight);

      branch1 = new Branch(centerX - (int)(width/2), baseY - trunkHeight + 10, (int)(width/4), (int)(height*0.25), -1*degrees);
      branch2 = new Branch(centerX + (int)(width/2), baseY - trunkHeight + 10, (int)(width/4), (int)(height*0.25), degrees);

      summerLeaves = new Leaves(centerX, baseY - trunkHeight - trunkHeight/5, width*3, (int)(height*.4));
      autumnLeaves = new Leaves(centerX, baseY - trunkHeight - trunkHeight/5, width*3, (int)(height*.4), new Color(200, 100, 0));
   }

   void drawWinter(Graphics g)
   {
      trunk.draw(g);
      branch1.draw(g);
      branch2.draw(g);
   }

   void drawSummer(Graphics g)
   {
      summerLeaves.draw(g);
      drawWinter(g);
   }

   void drawAutumn(Graphics g)
   {
      autumnLeaves.draw(g);
      drawWinter(g);
   }
}

