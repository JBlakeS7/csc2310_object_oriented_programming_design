package util;

public class PolyException extends RuntimeException
{
   private int power;

   public PolyException(String error)
   {
      super(error);
      this.power = -1;
   }

   public PolyException(String error, int power)
   {
      super(error);
      this.power = power;
   }

   //override the getMessage() method
   public String getMessage()
   {
      String str = super.getMessage();
      if (power > -1)
      {
         str += "\r\nThe power " + power + " is out of bounds.";
      }
      return str;
   }
   
}

/*
   What are exceptions? NPE, divide by zero, etc.
   Situations that arise in which the program cannot continue normally.

   Topics:
   1. Exception Propagation
   2. Try-Catch / Throws (rethrowing exceptions)
   3. Exception Hierarchy
   4. Checked vs. Unchecked Exceptions
   5. Exceptions are Objects

   Important: in general, don't catch runtime exceptions!  You will hide your errors!
   This turns runtime errors into logic errors which are much harder to debug.
   Except: rethrowing, testing error handling

   Three ways to handle exceptional situations:
   1. fix it (what we have done so far and is not acceptable)
   2. special return value (error code) documented
   3. throw an exception documented and give good error messages
      allows user to determine (handle the exception) what should be done
*/
