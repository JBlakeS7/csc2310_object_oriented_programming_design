package pizza;

public class VeggieLovers extends PizzaBuilder
{
	protected void buildPizza()
	{
		super.buildPizza();
		addTopping('o');
		addTopping('g');
		addTopping('m');
	}
}