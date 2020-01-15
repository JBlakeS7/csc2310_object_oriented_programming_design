import java.util.ArrayList;
import lsdn.Command;

public class CopyRating implements Command<CD>
{
   private CD copy;
   public CopyRating(CD copy)
   {
     this.copy = copy;
   //     this.copy = new CD(copy.getKey(), ...); or clone
   // for mutable types
   }

   public void execute(CD cd)
   {
      cd.setRating(copy.getRating());
   }
}