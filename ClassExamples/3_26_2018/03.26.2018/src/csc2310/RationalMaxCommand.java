package csc2310;
import util.Command;
public class RationalMaxCommand implements Command<RationalNumber>
{
	private RationalNumber max;
	private boolean is_empty;
	private RationalComparator comparator;
	
	public RationalMaxCommand(RationalComparator comparator)
	{
		max = null;
		is_empty = true;
		this.comparator = comparator;
	}
	
	public void execute(RationalNumber rn)
	{
		if (is_empty)
		{
			max = rn;
			is_empty = false;
		}
		else
		{
			if (comparator.compare(rn, max) > 0)
			{
				max = rn;
			}
		}
	}
	
	public RationalNumber getMax()
	{
		return max;
	}
}