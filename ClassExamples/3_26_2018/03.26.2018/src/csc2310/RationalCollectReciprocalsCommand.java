package csc2310;
import util.Command;
public class RationalCollectReciprocalsCommand implements Command<RationalNumber>
{
	private RationalNumbers reciprocals;
	
	public RationalCollectReciprocalsCommand()
	{
		reciprocals = new RationalNumbers();
	}
	
	public void execute(RationalNumber rn)
	{
		RationalNumber reciprocal = rn.reciprocal();
		System.out.println(reciprocal);
		reciprocals.add(reciprocal);
	}
	
	public RationalNumbers getReciprocals()
	{
		return reciprocals;
	}
}