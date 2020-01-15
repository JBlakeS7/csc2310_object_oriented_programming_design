package util;

public class PolyFactory
{
   public static PolyInterface getPoly(String file_name)
   {
	   return new PolyArray(file_name);
   }
}
