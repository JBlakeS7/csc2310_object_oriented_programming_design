import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JPanel;

public class ImageLoader
{
   private static Toolkit toolkit = Toolkit.getDefaultToolkit();
   private static JPanel panel = new JPanel();
   private static MediaTracker mt = new MediaTracker(panel);
   private static Color white = new Color(0).white;

   public Image getImage(String file)
   {
      Image img = toolkit.getImage(getClass().getResource(file));
      int len = file.length();

      mt.addImage(img, 0);

      try
      {
         mt.waitForAll();
      }
      catch (InterruptedException ie)
      {
      }

      return img;
   }
}