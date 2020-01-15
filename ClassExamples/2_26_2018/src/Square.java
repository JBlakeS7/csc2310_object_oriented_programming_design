package csc2310;

public class Square extends Rectangle
{
	
   public Square(int side)  
   {
      super(side, side);
   }

   //have to override (this is a problem)
   //width cannot be set independently of height as a Rectangle can
   //so behavior has been removed
   public void setSize(int w, int h)
   {
	   //ignore width (or ignore height)
      setWidth(h);
      setHeight(h);
   }


   //surprise!!
   //overridden method caused the problem
   //we REMOVED behavior (should not do this!!)
   //only ADD new behavior
   //Liskov substitution principle
   
   
   
   
   public static void main(String[] args)
   {
      Rectangle s = new Square(50);  //subtype polymorphism
	  
      s.stretch(20);
      System.out.println(s.getWidth());
   }
}
