package pizza;

public class GreenPeppers extends DecoratedPizza
{
	public GreenPeppers(DecoratedPizza pizza)
	{
		super(pizza);
	}

	public double pizzaCost() 
    {
    	return super.pizzaCost() + 0.69;
    }

    public String toString()
    {
    	return super.toString() + "\nGreenPeppers";
    }

    public String getImage()
    {
    	return super.getImage() + "G";
    }
}