import lsdn.KeyedItem;

public class CD extends KeyedItem<String>
{
   private String img;
   private String artist;
   private int year;
   private Song[] songs;
   private int count;
   private int rating;

   public CD (String title, String artist, int year, int rating, int tracks)
   {
      super(title);
      this.artist = artist;
      img = artist + " - " + title + ".jpg";
      this.year = year;
      count = 0;
      songs = new Song[tracks];

      if (rating > 0 && rating <= 10)
      {
         this.rating = rating;
      }
      else
      {
         this.rating = 5;
      }
   }

   public void setRating(int rating)
   {
      if (rating > 0 && rating <= 10)
      {
         this.rating = rating;
      }
      else
      {
         this.rating = 5;
      }
   }

   public int getRating()
   {
      return rating;
   }

   public String getArtist()
   {
      return artist;
   }

   public void writeCD(FileIO file)
   {
      if (rating == 10)
      {
         file.writeLine("         <li>" + "<b>" + getKey() + "</b>" + "</li>");
      }
      else
      {
         file.writeLine("         <li>" + getKey() + "</li>");
      }

      file.writeLine("         <center><img src = \"art\\" + img + "\"></center>");
      file.writeLine("         <ul>");
      file.writeLine("            <li>Year: " + year + "</li>");
      file.writeLine("            <li>Rating: " + rating + "</li>");
      file.writeLine("            <li>Tracks:</li>");

      file.writeLine("<table border = 0>");
      file.writeLine("<tr><td>Track&nbsp;&nbsp;&nbsp;</td><td>Title</td><td>Length&nbsp;&nbsp;</td></tr>");
      int count = 0;
      for (Song song : songs)
      {
         file.writeLine("<tr>");
         song.writeSong(file, ++count);
         file.writeLine("</tr>");
      }
      file.writeLine("</table>");

      file.writeLine("         </ul>");
   }

   public Song getSong(int index)
   {
      if (index >= 0 && index < songs.length)
      {
         return songs[index];
      }
      else
      {
         return null;
      }
   }

   public void addSong(Song song)
   {
      if (song != null && count < songs.length)
      {
         songs[count] = song;
         count++;
      }
   }

   public int getYear()
   {
      return year;
   }

   public String toString()
   {
      return getKey() + "," + artist + "  " + year + "  " + rating + "  " + songs.length;
   }
}

