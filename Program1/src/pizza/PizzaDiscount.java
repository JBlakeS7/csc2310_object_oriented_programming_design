package pizza;

public class PizzaDiscount extends DecoratedPizza
{
	private String msg;
	private double discount;

	//discount is assumed to be between 0.0 and 1.0
	public PizzaDiscount(DecoratedPizza pizza_component, String msg, double discount)
	{
		super(pizza_component);
		this.msg = msg;
		this.discount = discount;
	}

	public double pizzaCost() 
    {
    	return super.pizzaCost() - (super.pizzaCost() * discount);
    }

    public String toString()
    {
    	return super.toString() + "\n" + msg;
    }
}