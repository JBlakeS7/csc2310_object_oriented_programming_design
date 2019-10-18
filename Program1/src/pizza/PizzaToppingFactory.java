package pizza;

public class PizzaToppingFactory
{
	//create a PizzaTopping with the Pepperoni values and add it to the passed DecoratedPizza, returning the result 
	public static DecoratedPizza addPepperoni(DecoratedPizza dec_pizza) 
	{
		return new PizzaTopping(dec_pizza, "\nPepperoni", "P", 0.99);
	}

	//create a PizzaTopping with the Sausage values and add it to the passed DecoratedPizza, returning the result 
	public static DecoratedPizza addSausage(DecoratedPizza dec_pizza) 
	{
		return new PizzaTopping(dec_pizza, "\nSausage", "S", 0.99);
	}

	//create a PizzaTopping with the Onions values and add it to the passed DecoratedPizza, returning the result 
	public static DecoratedPizza addOnions(DecoratedPizza dec_pizza) 
	{
		return new PizzaTopping(dec_pizza, "\nOnions", "O", 0.79);
	}

	//create a PizzaTopping with the GreenPeppers values and add it to the passed DecoratedPizza, returning the result 
	public static DecoratedPizza addGreenPeppers(DecoratedPizza dec_pizza) 
	{
		return new PizzaTopping(dec_pizza, "\nGreen Peppers", "G", 0.69);
	}

	//create a PizzaTopping with the Mushrooms values and add it to the passed DecoratedPizza, returning the result 
	public static DecoratedPizza addMushrooms(DecoratedPizza dec_pizza) 
	{
		return new PizzaTopping(dec_pizza, "\nMushrooms", "M", 0.79);
	}

	//create a PizzaTopping with the Ham values and add it to the passed DecoratedPizza, returning the result 
	public static DecoratedPizza addHam(DecoratedPizza dec_pizza) 
	{
		return new PizzaTopping(dec_pizza, "\nHam", "H", 0.89);
	}

	//create a PizzaTopping with the Pineapple values and add it to the passed DecoratedPizza, returning the result 
	public static DecoratedPizza addPineapple(DecoratedPizza dec_pizza) 
	{
		return new PizzaTopping(dec_pizza, "\nPineapple", "A", 0.89);
	}
}