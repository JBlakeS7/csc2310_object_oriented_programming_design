package util;
// keep generic because every object has a toString method
public class PrintCommand<E> implements Command<E>
{
	// default no-argument constructor
	public void execute (E element)
	{
		System.out.println(element);
	}
}