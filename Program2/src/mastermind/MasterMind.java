package mastermind;

import java.awt.Graphics;
import java.awt.Image;

import gui.Drawable;
import util.Random;

class MasterMind implements Drawable
{
	private Image board_img;
	private Guesses player_guesses;
	private MasterMindState playerState;
	private MasterMindState AIState;
	private MasterMindState gameOverState;
	private MasterMindState currentState;
	
	public MasterMind()
   	{
	  board_img = gui.ImageLoader.getImageLoader().getImage("images/mastermind_board.jpg");
      player_guesses = new Guesses();

      gui.BasicGUI mm_gui = new gui.BasicGUI(457, 690, "Master Mind", this, null);
      mm_gui.setVisible(true);
   	}

   	public MasterMind(int game_state)
	{
		playerState = new MasterMindPlayerState(this);
		AIState = new MasterMindAIState(this);
		gameOverState = new MasterMindGameOverState(this);
		System.out.println(game_state);
		
		if(game_state == 0)
		{
			currentState = playerState;
		}	
		else
		{
			currentState = AIState;
		}
		
		board_img = gui.ImageLoader.getImageLoader().getImage("images/mastermind_board.jpg");
		player_guesses = new Guesses();

		gui.BasicGUI mm_gui = new gui.BasicGUI(457, 690, "Master Mind", this, null);
		mm_gui.setVisible(true);
	}

	public MasterMindState getPlayerState()
	{
		return playerState;
	}
	
	public MasterMindState getAIState()
	{
		return AIState;
	}
	
	public void changeState(MasterMindState state)
	{
		currentState = state;
	}	

	public MasterMindState getGameOverState()
	{
		return gameOverState;
	}
  
   public void mouseClicked(int x, int y) 
   {
	   /*
	   if (isGameOver()) return;
	   
		int is_color_selected = isColorSelected(x, y);
		if (is_color_selected > 0)
		{
			addGuess(is_color_selected);
		}
		*/
		currentState.mouseClicked(x,y);
	}
	
	public void draw(Graphics g, int width, int height)
   	{
		g.drawImage(board_img, 0, 0, null);
		player_guesses.draw(g);
   	}
   
   public boolean isPlayerGuessComplete()
   {
	   return player_guesses.isPlayerGuessComplete();
   }

   //report result when comparing two guesses to each other (first parameter tested against the second parameter)
   public int[] reportTestResult(Guess one, Guess two)
   {
		assert (one != null && two != null) : "Guess is null.";
		return one.reportResult(two);
   }
   
   public Guess getGuess(int guess_num)
   {
		assert guess_num >= 1 : "Invalid guess_num";
		return player_guesses.getGuess(guess_num);
   }
   
   public int getNumGuesses()
   {
	   return player_guesses.getNumGuesses();
   }
   
   public boolean isGameOver()
   {
	   return player_guesses.isGameOver();
   }
   
   public int isColorSelected(int x, int y)
   {
	   return player_guesses.isColorSelected(x, y);
   }
   
   public void addGuess(int color)
   {
	   player_guesses.addGuess(color);
   }
   
   public void addGuess(Guess ai_guess)
   {
	   player_guesses.addGuess(ai_guess);
   }
   
   public int changeAI(int x, int y)
   {
	   int w_half = 12;
	   int h_half = 13;
	   
	   int center_x = 430;
	   
	   int center_0_y = 542;
	   int center_1_y = 571;
	   int center_2_y = 602;
	   int center_3_y = 630;
	   
	   if (Math.abs(x-center_x) < w_half)
	   {
		   if(Math.abs(y-center_0_y) < h_half)
		   {
			   return 0;
		   }
		   
		   else if(Math.abs(y-center_1_y) < h_half)
		   {
			   return 1;
		   }
		   
		   else if(Math.abs(y-center_2_y) < h_half)
		   {
			   return 2;
		   }
		   
		   else if(Math.abs(y-center_3_y) < h_half)
		   {
			   return 3;
		   }
	   }
	   
	   return -1;
   }
 
	public void keyPressed(char key)
   {
   }
}
