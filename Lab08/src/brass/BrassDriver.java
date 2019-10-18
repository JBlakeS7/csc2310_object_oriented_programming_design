package brass;

public class BrassDriver
{
	
	public static void main(String[] args)
   {
	   int num_players;
	   
		//DO THIS
		//obtain the number of players from the args array
		//use try-catch as necessary (NumberFormatException)
		//the default value for number of players is 4 in the case of a problem
		//or if no arguments have been passed to main
	   	if (args.length == 0)
	   	{
			num_players = 4;
	   	}
	   	
	   	else (args.length == 1)
	   	{
		   	try
		   	{
				num_players = Integer.parseInt(args[0]);
		   	}
		   	catch (NumberFormatException nfe)
		   	{
				num_players = 4;
		   	}
		}
	
		BrassGame brass_game = new BrassGame(num_players);
   }
}
