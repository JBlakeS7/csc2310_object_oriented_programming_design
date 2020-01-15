
public class CDCollectionDriver
{
   public static void main(String[] args)
   {

      try
      {
 //        CDCollection cds = new CDCollection("cds.dat");
         CDCollection cds = new CDCollection("resources/cds.txt");
         System.out.println(cds);
         cds.sort();
         System.out.println(cds);

         cds.writeSerialCDs("resources/cds.dat");
         cds.writeCDs("resources/cds.txt");
      } 
      catch (ClassNotFoundException cnfe)
      {
         System.out.println("Could not read from the file.");
         System.out.println(cnfe.getMessage());
      }
      catch (java.io.IOException ioe)
      {
         System.out.println("Could not read/write from/to the file.");
         System.out.println(ioe.getMessage());
      }

   }

}