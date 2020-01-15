
public class State0 implements TwosCompState
{
   private TwosComp controller;

   public State0(TwosComp controller)
   {
      this.controller = controller;
   }

   public char twosComp(char input)
   {
      System.out.println("twosComp in state 0");
      if (input == '0')
      {
         return '0';
      }
      else
      {
         controller.nextState(controller.getState1()); 
         return '1';        
      }
   }
}