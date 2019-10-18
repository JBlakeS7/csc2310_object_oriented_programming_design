package pizza;

public class Crust
{
	private CrustSize crust_size;
	private CrustType crust_type;

	public Crust(CrustSize size, CrustType type)
	{
		crust_size = size;
		crust_type = type;
	}

	public double crustCost()
	{
		return (crust_size.getCost() + crust_type.getCost());
	}

	public String toString()
	{
		return "Size: " + crust_size + "\nCrust: " + crust_type;
	}

	public String getCrust()
	{
		return crust_type.getType();
	}

	public char getSize()
	{
		return crust_size.getSize();
	}
}