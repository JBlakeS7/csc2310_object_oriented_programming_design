package pizza;

public class Sausage extends DecoratedPizza
{
	public Sausage(DecoratedPizza pizza)
	{
		super(pizza);
	}

	public double pizzaCost() 
    {
    	return super.pizzaCost() + 0.99;
    }

    public String toString()
    {
    	return super.toString() + "\nSausage";
    }

    public String getImage()
    {
    	return super.getImage() + "S";
    }
}