package pizza;

public class MeatLovers extends PizzaBuilder
{
	protected void buildPizza()
	{
		super.buildPizza();
		addTopping('p');
		addTopping('s');
		addTopping('h');
	}
}