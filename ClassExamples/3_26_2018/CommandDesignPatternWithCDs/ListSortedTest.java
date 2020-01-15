import java.util.Iterator;
import java.util.ArrayList;
import lsdn.*;

public class ListSortedTest
{

   public static void main(String[] args) 
   {
      ListSortedInterface<CD, String> list = new ListSortedDoubleNode<CD, String>();
      
      readMusic("cds.txt", list);

      FindArtist findArtist = new FindArtist("Dark Tranquillity");
      list.execute(findArtist);
      ArrayList<CD> cds = findArtist.getCDs();
       for (CD cd : cds)
      {
         System.out.println(cd);
      }
//      System.out.println(cds);

      System.out.println("***");

      Command<CD> copy = new CopyRating(list.get("Sombre Gates"));

      list.execute(copy);
      System.out.println("***");
      
      Command<CD> display = new Display<CD>();
      list.execute(display);
      System.out.println("***");
      
      showList(list.iterator());
      System.out.println("***");
      
      FindByYear byYear = new FindByYear(2003);
      list.execute(byYear);
      
      for (CD cd : byYear.getCDs()) {
          System.out.println(cd);
      }
      System.out.println("***");
      
/*      Command<CD> increase = new IncreaseRating();
      list.execute(increase);
      list.execute(display);
      System.out.println("***");
      showList(list.iterator());
      System.out.println("***"); */
      
      FindTitle titleFinder = new FindTitle("Versus the World");
      list.execute(titleFinder);
      System.out.println(titleFinder.getCDs());
      System.out.println("***");
      
      Command<CD> macroCommand = new MacroCommand();
      list.execute(macroCommand);
     
      System.out.println("****");
      FindByYearRange byYearRange = new FindByYearRange(2008, 2011);
      list.execute(byYearRange);
      // System.out.println(byYearRange.getCDs());
      for (CD cd : byYearRange.getCDs())
      {
         System.out.println(cd);
      }
   }

   //external iterator design pattern to display all of the items
   public static void showList(Iterator<CD> iter)
   {
      System.out.println();
      while (iter.hasNext())
      {
         System.out.println(iter.next());
      }
      System.out.println();
   }

   private static void readMusic(String fileName, ListSortedInterface<CD, String> list)
   {
      FileIO file = new FileIO(fileName, FileIO.FOR_READING);
      String str = file.readLine();
      while (!file.EOF())
      {
         String title = file.readLine();
         int year = Integer.parseInt(file.readLine());
         int rating = Integer.parseInt(file.readLine());
         int numTracks = Integer.parseInt(file.readLine());
         CD cd = new CD(title, str, year, rating, numTracks);

         list.add(cd);
         int tracks = 1;

         while (tracks <= numTracks)
         {
            String temp = file.readLine();
            String[] line = temp.split(",");
            String len = line[0];
            String songTitle = line[1];
            Song song = new Song(songTitle, len);
            cd.addSong(song);
            tracks++;
         }

         str = file.readLine();
      }
   }

}