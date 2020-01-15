import java.util.ArrayList;
//import lsdn.Command;

public class FindArtist extends FindByField
{
   private String artist;

   public FindArtist(String artist)
   {
      super(); // not absolutely needed because done by default
      this.artist = artist;
   }

   public void execute(CD cd)
   {
      if (artist.equalsIgnoreCase(cd.getArtist()))
      {
         cds.add(cd);
      }
   }

}