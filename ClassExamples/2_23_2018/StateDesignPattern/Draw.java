import java.awt.Graphics;
import java.awt.Image;
import java.awt.Color;
import javax.swing.JPanel;
import java.util.ArrayList;
import java.awt.event.*;

public class Draw extends JPanel implements MouseListener, ActionListener
{
   private ArrayList<Drawable> pics;

   public Draw()
   {
      pics = new ArrayList<Drawable>();
      addMouseListener(this);
   }

   public void actionPerformed(ActionEvent ae)
   {
      repaint();
   }

   public void add(Drawable drawable)
   {
      pics.add(drawable);
   }

   /** Handles the complicated painting for the panel. <br> */
   public void paint(Graphics g)
   {
      int width = getSize().width;
      int height = getSize().height;

      //use double buffering
      Image offScreenBuffer = createImage(width, height);
      Graphics gOff = offScreenBuffer.getGraphics();

      gOff.setColor(Color.white);
      gOff.fillRect(0, 0, width, height);

      for (Drawable drawable : pics)
      {
         drawable.draw(gOff, width, height);
      }

      g.drawImage(offScreenBuffer, 0, 0, null);  //copy the offScreenImage to the panel
   }

   public void mousePressed (MouseEvent event) 
   {
      for(Drawable pic : pics)
      {
         pic.mouseClicked(event.getX(), event.getY());
      }

      repaint();
   }

   public void mouseClicked (MouseEvent event){}
   public void mouseReleased (MouseEvent event) {}
   public void mouseEntered (MouseEvent event) {}
   public void mouseExited (MouseEvent event) {}
}