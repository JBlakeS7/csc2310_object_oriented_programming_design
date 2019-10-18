package pizza;

public abstract class DecoratedPizza
{
	private DecoratedPizza next_pizza_item;

	public DecoratedPizza()
	{
		next_pizza_item = null;
	}

	public DecoratedPizza(DecoratedPizza pizza_item)
	{
		next_pizza_item = pizza_item;
	}

	//get the cost from the "next_pizza_item" DecoratedPizza
    public double pizzaCost() 
    {
    	return next_pizza_item.pizzaCost();
    }

    //get the state of the "next_pizza_item" DecoratedPizza
    public String toString()
    {
    	return next_pizza_item.toString();
    }

    //get the abbreviation of the "next_pizza_item" DecoratedPizza (the topping abbreviation is used to obtain the correct pizza image)
    public String getImage()
    {
    	return next_pizza_item.getImage();
    }
}