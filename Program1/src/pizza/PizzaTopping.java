package pizza;

public class PizzaTopping extends DecoratedPizza
{
	//DecoratedPizza pizza_component;
	String topping_string;
	String topping_letter;
	double topping_cost;

	public PizzaTopping(DecoratedPizza pizza_component, String topping_string, String topping_letter, double topping_cost)
	{
		//this.pizza_component = pizza_component;
        super(pizza_component);
		this.topping_string = topping_string;
		this.topping_letter = topping_letter;
		this.topping_cost = topping_cost;
	}

	public double pizzaCost() 
    {
    	return super.pizzaCost() + topping_cost;
    }

    //get the state of the "next_pizza_item" DecoratedPizza
    public String toString()
    {
    	return super.toString() + topping_string;
    }

    //get the abbreviation of the "next_pizza_item" DecoratedPizza (the topping abbreviation is used to obtain the correct pizza image)
    public String getImage()
    {
    	return super.getImage() + topping_letter;
    }
}