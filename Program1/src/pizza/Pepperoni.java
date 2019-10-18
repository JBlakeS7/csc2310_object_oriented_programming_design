package pizza;

public class Pepperoni extends DecoratedPizza
{
	public Pepperoni(DecoratedPizza pizza)
	{
		super(pizza);
	}

	public double pizzaCost() 
    {
    	return super.pizzaCost() + 0.99;
    }

    public String toString()
    {
    	return super.toString() + "\nPepperoni";
    }

    public String getImage()
    {
    	return super.getImage() + "P";
    }
}