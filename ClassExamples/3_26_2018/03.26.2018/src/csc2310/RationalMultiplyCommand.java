package csc2310;

public class RationalMultiplyCommand implements util.Command<RationalNumber>
{
	private RationalNumber rn;
	
	public RationalMultiplyCommand()
	{
		rn = new RationalNumber(1, 1);
	}
	
	public RationalNumber getResult()
	{
		return rn;
	}
	
	public void execute(RationalNumber rn_temp)
	{
		rn = rn.multiply(rn_temp);
		System.out.println(rn);
	}
}

