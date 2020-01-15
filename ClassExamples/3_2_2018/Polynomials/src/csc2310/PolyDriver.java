package csc2310;

import util.PolyInterface;
import util.PolyException;
import util.PolyFactory;

public class PolyDriver
{
   public static void main(String[] args)  //throws Exception //(you can throw a checked exception to O/S but shouldn't be)
   {
      PolyInterface poly1 = PolyFactory.getPoly("resources/poly1.txt");
      System.out.println(poly1);
      PolyInterface poly2 = PolyFactory.getPoly("resources/poly2.txt");
      System.out.println(poly2);
      PolyInterface poly3 = poly1.multiply(poly2);
      System.out.println(poly3);
      System.out.println(poly3.evaluate(2.6));

      try
      {
         poly3.changeCoefficient(5.0, 150);
      }
      catch (PolyException pe)   //what if not caught? propagates to O/S automatically (unchecked exception)
      {
         System.out.println(pe.getMessage());
      }

      PolyInterface poly = PolyFactory.getPoly("resources/xyz.txt");  //will crash
      System.out.println(poly);
   }
}
