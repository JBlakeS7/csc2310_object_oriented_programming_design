package csc2310;

public class RationalAddCommand implements util.Command<RationalNumber>
{
	private RationalNumber rn;
	
	public RationalAddCommand()
	{
		rn = new RationalNumber(0, 1);
	}
	
	public RationalNumber getResult()
	{
		return rn;
	}
	
	public void execute(RationalNumber rn_temp)
	{
		rn = rn.add(rn_temp);
		System.out.println(rn);
	}
}

