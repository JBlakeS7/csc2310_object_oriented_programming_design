package mastermind;

public class MasterMindDriver
{
	//entry point
   public static void main(String[] args)
   {
      	int state = 0;

      	if(args.length == 1)
      	{
      		try
			{
				String command_line = args[1];
				state = Integer.parseInt(command_line);
			}
			catch(NumberFormatException nfe)
			{
				System.out.println("Defaulted to player state.");
				state = 0;
			}
      	}

      	MasterMind mm = new MasterMind(state);
   }
}
   