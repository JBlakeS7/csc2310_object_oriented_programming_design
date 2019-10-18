package pizza;

public class Hawaiian extends PizzaBuilder
{
	protected void buildPizza()
	{
		super.buildPizza();
		addTopping('a');
		addTopping('h');
	}
}