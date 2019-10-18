package pizza;

public class PizzaBuilder
{
	private DecoratedPizza top;
	private CrustSize crust_size;
	private CrustType crust_type;

	//create a Crust and a Pizza using that Crust based on the user's specifications 
	//(the Pizza is now ready for toppings)
	protected void buildPizza()
	{
		Crust crust = new Crust(crust_size, crust_type);
		top = new Pizza(crust);
	}

	//start with a small, thin pizza with no toppings as the default
	public PizzaBuilder()
	{
		Crust crust = new Crust(CrustSize.S, CrustType.THIN);
		top = new Pizza(crust);
	}

	//returns true if the input was valid ("S" or "small", etc., not case sensitive, 
	//use the String charAt method to get the first character)
	public boolean setSize(char try_size)
	{
		//char size = Character.toLowerCase(try_size.charAt(0));
		
		if(try_size == 's')
		{
			crust_size = CrustSize.S;
			return true;
		}
		if(try_size == 'm')
		{	
			crust_size = CrustSize.M;
			return true;
		}
		if(try_size == 'l')
		{		
			crust_size = CrustSize.L;
			return true;
		}
			
		return false;	
	}

	//("thin", "hand", or "pan", not case sensitive)
	public boolean setCrust(String try_crust)
	{
		if(try_crust.equalsIgnoreCase("thin"))
		{
			crust_type = CrustType.THIN;
			return true;
		}
		if(try_crust.equalsIgnoreCase("hand"))
		{
			crust_type = CrustType.HAND;
			return true;
		}
		if(try_crust.equalsIgnoreCase("pan"))
		{
			crust_type = CrustType.PAN;
			return true;
		}
		return false;
	}

	//compare the topping abbreviation to topping_char to determine which 
	//topping to add (using void here is convenient for the PizzaDriver, ignore invalid abbreviations)
	public void addTopping(char topping_char) 
	{
		Character topping = Character.toLowerCase(topping_char);
		if(top instanceof PizzaDiscount)
			return;
		if(topping.equals('p'))
		{
			//top = new Pepperoni(top);
			top = PizzaToppingFactory.addPepperoni(top);
		}
		if(topping.equals('s'))
		{
			//top = new Sausage(top);
			top = PizzaToppingFactory.addSausage(top);
		}
		if(topping.equals('o'))
		{
			//top = new Onions(top);
			top = PizzaToppingFactory.addOnions(top);
		}
		if(topping.equals('g'))
		{
			//top = new GreenPeppers(top);
			top = PizzaToppingFactory.addGreenPeppers(top);
		}
		if(topping.equals('m'))
		{
			//top = new Mushrooms(top);
			top = PizzaToppingFactory.addMushrooms(top);
		}
		if(topping.equals('h'))
		{
			//top = new Ham(top);
			top = PizzaToppingFactory.addHam(top);
		}
		if(topping.equals('a'))
		{
			//top = new Pineapple(top);
			top = PizzaToppingFactory.addPineapple(top);
		}
			
		return;
	}

	public void addDiscount(String msg, double discount)
	{
		top = new PizzaDiscount(top, msg, discount);
	}

	public void addFee(String msg, double fee)
	{
		top = new PizzaFee(top, msg, fee);
	}

	//return the final DecoratedPizza and reset to the default pizza if another pizza is desired
	public DecoratedPizza pizzaDone()
	{
		return top;
	}
}