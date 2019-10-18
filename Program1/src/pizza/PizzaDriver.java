package pizza;

import util.Keyboard;
import java.text.DecimalFormat;

public class PizzaDriver
{
	//show the menu choices, wait for and return the valid selection
	private static int menu()
	{
		Keyboard kb = Keyboard.getKeyboard();
		int input = 0;
		while(input<1 || input>4)
		{
			System.out.print("\n1. Meat Lover's\n2. Veggie Lover's\n3. Hawaiian\n4. Build Your Own\n");
			System.out.println("\nSelect from the above: ");
			input = kb.readInt(" ");
		}
		return input;
	}

	//request the crust size, wait for a valid response confirmation from PizzaBuilder
	private static void requestSize(PizzaBuilder pizza_builder)
	{
		Keyboard kb = Keyboard.getKeyboard();
		String string_input;
		do
		{
			System.out.println("What size pizza (S/M/L)? ");
			string_input = kb.readString(" ");
		}
		while(!pizza_builder.setSize(Character.toLowerCase(string_input.charAt(0))));
	}

	//request the crust type, wait for a valid response confirmation from PizzaBuilder
	private static void requestCrust(PizzaBuilder pizza_builder)
	{
		Keyboard kb = Keyboard.getKeyboard();
		String string_input;
		do
		{
			System.out.println("What type of crust (thin/hand/pan)? ");
			string_input = kb.readString(" ");
		}
		while(!pizza_builder.setCrust(string_input));
	}

	//ask for toppings until Done indicated (invalid toppings are ignored)
	private static void requestToppings(PizzaBuilder pizza_builder)
	{
		Keyboard kb = Keyboard.getKeyboard();
		String string_input = "empty";
		while(!string_input.equalsIgnoreCase("d"))
		{
			string_input = kb.readString("\n(P)epperoni,(O)nions,(G)reen Peppers,(S)ausage,(M)ushrooms,(D)one\n");
			pizza_builder.addTopping(string_input.charAt(0));
		}
	}

	//display the pizza and its total cost
	private static void showOrder(DecoratedPizza dec_pizza)
	{
		Keyboard kb = Keyboard.getKeyboard();
		DecimalFormat df = new DecimalFormat("#,###,##0.00");
		System.out.println("Your pizza:");
		System.out.print(dec_pizza.toString());

		//Calculate the cost of the pizza and the total order cost
		System.out.println("\nThe cost of your pizza is $" + df.format(dec_pizza.pizzaCost()));
	}

	//allow the user to order multiple pizzas if desired, call the other methods, track total cost and number of pizzas
	public static void main (String[] args)
	{
		Keyboard kb = Keyboard.getKeyboard();
		DecimalFormat df = new DecimalFormat("#,###,##0.00");
		DecoratedPizza finished_pizza;
		PizzaBuilder pb;
		int pizza_count = 0;
		double total_cost = 0;
		String string_input = "empty";

		//Check to see if user wants to build a pizza 
		do
		{
			System.out.println("Would you like to order a pizza (y/n)? ");
			string_input = kb.readString(" ");
		}
		while(!(string_input.equalsIgnoreCase("y") || string_input.equalsIgnoreCase("n")));

		//While loop lets the user make an indefinite number of pizzas
		while(string_input.equalsIgnoreCase("y"))
		{
			pb = new PizzaBuilder();
			pizza_count++;
			int int_input;
			int_input = menu();
			
			if(int_input == 1)
			{
				pb = new MeatLovers();
				requestSize(pb);
				requestCrust(pb);
				pb.buildPizza();
			}
			if(int_input == 2)
			{
				pb = new VeggieLovers();
				requestSize(pb);
				requestCrust(pb);
				pb.buildPizza();
			}
			if(int_input == 3)
			{
				pb = new Hawaiian();
				requestSize(pb);
				requestCrust(pb);
				pb.buildPizza();
			}
			if(int_input == 4)
			{
				requestSize(pb);
				requestCrust(pb);
				pb.buildPizza();
				requestToppings(pb);
			}

			//Check for senior discount
			do
			{
				System.out.println("Are you a senior citizen (y/n)? ");
				string_input = kb.readString(" ");
				if(string_input.equalsIgnoreCase("y"))
					pb.addDiscount("senior discount", 0.1);//needs parameters
			}
			while(!(string_input.equalsIgnoreCase("y") || string_input.equalsIgnoreCase("n")));

			//Check for delivery fee
			do
			{
				System.out.println("Do you need this pizza delivered (y/n)? ");
				string_input = kb.readString(" ");
				if(string_input.equalsIgnoreCase("y"))
					pb.addFee("delivery", 2.50);//needs parameters
			}
			while(!(string_input.equalsIgnoreCase("y") || string_input.equalsIgnoreCase("n")));

			showOrder(pb.pizzaDone());
			total_cost += pb.pizzaDone().pizzaCost();

			//Ask the user if he/she wants to order another pizza
			do
			{
				System.out.println("Would you like to order another pizza (y/n)? ");
				string_input = kb.readString(" ");
			}
			while(!(string_input.equalsIgnoreCase("y") || string_input.equalsIgnoreCase("n")));
		}
		
		System.out.println("You ordered " +pizza_count + " pizza(s) for a grand total of $" + df.format(total_cost));
	}
}