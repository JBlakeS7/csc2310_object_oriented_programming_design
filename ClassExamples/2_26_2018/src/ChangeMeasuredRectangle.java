package csc2310;

public class ChangeMeasuredRectangle extends Rectangle
{
   private int width_changes;

   public ChangeMeasuredRectangle(int w, int h)
   {
      super(w, h);
      width_changes = 0;
   }

   public int getNumWidthChanges()
   {
      return width_changes;
   }

   public void setWidth(int w)
   {
      if (w > 0 && w != getWidth())
      {
         width_changes++;
      }

      super.setWidth(w);
   }

   //eliminate overridden setSize to make the width changes counter work correctly
   //assumes parent using original setSize implementation
  
   public void setSize(int w, int h)
   {
	   
      if (w > 0 && w != getWidth())
      {
         width_changes++;
      }

      super.setSize(w, h);  //code reuse
   }  

   //alternate overridden method to fix implementation dependence
   //don't call superclass setSize at all

 /*  public void setSize(int w, int h)
   {
      if (w > 0 && w != getWidth())
      {
         width_changes++;
      }

      super.setWidth(w);
      super.setHeight(h);
   } */


   public static void main(String[] args)
   {
      ChangeMeasuredRectangle r = new ChangeMeasuredRectangle(20, 50);
      r.setSize(21, 50);
      System.out.println(r.getNumWidthChanges());
   }
}

//1. include overridden method (double counting)
//2. eliminate overridden method (ok for now)
//3. change setSize implementation in parent (no counting when setSize is called)
//4. (Ex. 9) alternate overridden method eliminates problem in this example
