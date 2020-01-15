//Facade Design Pattern

/**
 * A class to return random numbers within a specified range and type. <br> 
 */
public class Random
{
   private final static java.util.Random rand = new java.util.Random();

   /** 
    *  Returns a floating point number between low and high.
    *  rand.nextDouble gives a number between 0.0 (inclusive) and 1.0 (exclusive)
    */
   public static double randomFloat(int low, int high)
   {
      return rand.nextDouble()*(high - low) + low;  //nextDouble first level of abstraction but still complex)
   }

   /** 
    *  Returns an integer between low and high (inclusive of both). 
    *  rand.nextInt(num) gives an integer between 0.0 (inclusive) and num - 1 (inclusive)
    *  Example--  what if I want a number between 3 and 7?
    */
   public static int randomInt(int low, int high)
   {
      return rand.nextInt(high - low + 1) + low;
   }
}
