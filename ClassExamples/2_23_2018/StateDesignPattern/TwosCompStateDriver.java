
public class TwosCompStateDriver // formerly StateQuiz
{
   public static void main(String[] args)
   {
      TwosComp tc = new TwosComp();

      String str = Keyboard.readString("Enter a string: ");
      int len = str.length();
      StringBuffer sb = new StringBuffer();
      for (int i = len - 1; i >= 0; i--)  // to reverse
      {
         char result = tc.obtainTwosComp(str.charAt(i));
         sb.insert(0, result);
         System.out.println(sb);
      }

      System.out.println(sb.toString());
   }
}