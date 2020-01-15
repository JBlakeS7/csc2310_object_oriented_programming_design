package csc2310;

//Section 3.3 (the stretch "surprise")
public class Rectangle /* extends Object */
{
   private int width, height;
   public static final int DEFAULT_WIDTH = 5;
   public static final int DEFAULT_HEIGHT = 5;

   public Rectangle(int w, int h)
   {
	   // super();
	  if (w > 0)
	  {
		width = w;
	  }
	  else
	  {
		width = DEFAULT_WIDTH;
	  }
	  if (h > 0)
	  {
		height = h;
	  }
	  else
	  { 
		height = DEFAULT_HEIGHT; 
	  }
   }

   public int getWidth()
   {
      return width;
   }

   public int getHeight()
   {
      return height;
   }

   public void setWidth(int w)
   {
      if (w > 0)
      {
         width = w;
      }
   }

   public void setHeight(int h)
   {
      if (h > 0)
      {
         height = h;
      }
   }
   
   //allows the width to be increased or decreased by a small amount
   public void stretch(int dx)
   {
      //surprise! square won't stretch (inconsistent behavior)
      this.setSize(getWidth() + dx, getHeight());  //square set size ignores the first parameter
   }

   public boolean isSquare()
   {
      return width == height;
   }
   
      public void setSize(int w, int h)
   {
//if implementation of setSize changes, width counter won't work in child class

       this.setWidth(w);  //suppose Rectangle impl. is this originally
      setHeight(h);

      //breaks child class width counter
      //suppose it is changed to this

  //   width = w;
 //     height = h;

   }
}
