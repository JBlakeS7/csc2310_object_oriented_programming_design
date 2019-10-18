package pizza;

public class Pizza extends DecoratedPizza
{
	Crust pizza_crust;

	public Pizza(Crust crust)
	{
		super();
		pizza_crust = crust;
	}

	public double pizzaCost() 
    {
    	return pizza_crust.crustCost();
    }

    public String toString()
    {
    	return pizza_crust.toString();
    }

    public String getImage()
    {
    	Character char_size = pizza_crust.getSize();
    	return char_size.toString();
    }
}