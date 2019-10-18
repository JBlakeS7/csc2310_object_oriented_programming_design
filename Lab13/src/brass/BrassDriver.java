package brass;

public class BrassDriver
{
	//DO THIS
	//process the save/load game file name parameter
	public static void main(String[] args)
   {
	   int num_players;
	   String brass_game_save_name;
	   
	   if (args.length == 0)
	   {
		   num_players = 4;
		   brass_game_save_name = "resources/brass_game_save.xml";
	   }
	   else if (args.length == 1)
	   {
		   brass_game_save_name = args[0];
		   num_players = 4;
	   }
	   else
	   {
	   		brass_game_save_name = args[0];
		   try
		   {
				num_players = Integer.parseInt(args[0]);
		   }
		   catch (NumberFormatException nfe)
		   {
				num_players = 4;
		   }
	   }
	   
		BrassGame brass_game = new BrassGame(brass_game_file_name, num_players);
   }
}
