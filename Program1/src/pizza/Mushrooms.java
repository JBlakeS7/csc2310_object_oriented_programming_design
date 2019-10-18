package pizza;

public class Mushrooms extends DecoratedPizza
{
	public Mushrooms(DecoratedPizza pizza)
	{
		super(pizza);
	}

	public double pizzaCost() 
    {
    	return super.pizzaCost() + 0.79;
    }

    public String toString()
    {
    	return super.toString() + "\nMushrooms";
    }

    public String getImage()
    {
    	return super.getImage() + "M";
    }
}