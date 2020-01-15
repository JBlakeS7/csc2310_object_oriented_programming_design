
public class TwosComp
{
   private TwosCompState state1 = new State1();
   private TwosCompState state0 = new State0(this);
   private TwosCompState current = state0;

   /* public TwosComp() 
   {
       state1 = new State1();
       state0 = new State0(this);
       current = state0;
   } */
   
   public TwosCompState getState1()
   {
      return state1;
   }

   public TwosCompState getState0()
   {
      return state0;
   }

   public void nextState(TwosCompState state)
   {
      current = state;
   }

   public char obtainTwosComp(char input)
   {
      return current.twosComp(input);
   }
}