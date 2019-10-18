package pizza;

public class Onions extends DecoratedPizza
{
	public Onions(DecoratedPizza pizza)
	{
		super(pizza);
	}

	public double pizzaCost() 
    {
    	return super.pizzaCost() + 0.79;
    }

    public String toString()
    {
    	return super.toString() + "\nOnions";
    }

    public String getImage()
    {
    	return super.getImage() + "O";
    }
}