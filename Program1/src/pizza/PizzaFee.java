package pizza;

public class PizzaFee extends DecoratedPizza
{
	String msg;
	double fee;

	public PizzaFee(DecoratedPizza pizza_component, String msg, double fee)
	{
		super(pizza_component);
		this.msg = msg;
		this.fee = fee;
	}

	public double pizzaCost() 
    {
    	return super.pizzaCost() + fee;
    }

    public String toString()
    {
    	return super.toString() + "\n" + msg;
    }
}