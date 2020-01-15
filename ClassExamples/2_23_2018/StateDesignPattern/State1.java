
public class State1 implements TwosCompState
{
   public char twosComp(char input)
   {
      System.out.println("twosComp in state 1");
      if (input == '1')
      {
         return '0';
      }
      else
      {
         return '1';
      }
   }
}