import lsdn.Command;

public class Display<T> implements Command<T> // genericized by MJK
{
   public void execute(T item)
   {
      System.out.println(item.toString());
   }
}