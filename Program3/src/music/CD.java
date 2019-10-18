package music;

import java.awt.*;

public class CD
{
	//pick one of these items to be the sort "key"
   private String title;
   private String artist;
   private int year;
   private int count;
   private int rating;
   private Song[] songs;
   
   private int x_loc, y_loc;
   private int image = 0;
   
   private java.awt.Image img0;
   private java.awt.Image img1;

   private final gui.ImageLoader il = gui.ImageLoader.getImageLoader();
   private static final int x_off = 100;  //the offset will change during a rotation
   private static final int y_off = 100;
   private static final java.awt.Font verdana_12 = new java.awt.Font("Verdana", java.awt.Font.BOLD, 14);

   private boolean filter = false;

   public CD (String title, String artist, int year, int rating, int tracks)
   {
	  this.title = title;
	  this.artist = artist;
      this.year = year;

	  String img_file = "resources/art/" + artist + " - " + title + ".jpg";
	  img0 = il.getImage(img_file);
	  img1 = il.getHighLightImage(img0);

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

   public Image getAlbumArt()
   {
      return img0;
   }

   public Image getAlbumFilter()
   {
      return img1;
   }
   
   public int getNumTracks()
   {
	   return songs.length;
   }
   
   public String getArtist()
   {
      return artist;
   }
   
   public String getTitle()
   {
      return title;
   }

   public int getYear()
   {
      return year;
   }

   public int getRating()
   {
      return rating;
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

   public void draw(Graphics g, int width, int height)
   {
      // Rating label
      g.setColor(Color.black);
      g.setFont(verdana_12);
      g.drawString("Rating: " +getRating(), width/2-45, height/7);
   }

   public String toString()
   {
      return title + "  " + year + "  " + rating + "  " + songs.length;
   }
}
