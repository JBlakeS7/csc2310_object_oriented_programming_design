package lsdn;

public interface Execute<T>
{
   public void execute(Command<T> command);
}
