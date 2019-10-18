package mastermind;

class MasterMindAIState implements MasterMindState, MasterMindAI
{
	private MasterMind mm;
	private MasterMindAI[] AIArray;
	private MasterMindAI current;
	private int AI_int;
	
	public MasterMindAIState(MasterMind mastermind)
	{
		mm = mastermind;
		AIArray = new MasterMindAI[3];
		AIArray[0] = new MasterMindAIRandom(mm);
		AIArray[1] = new MasterMindAIConsistent(mm);
		AIArray[2] = new MasterMindAIMiniMax(mm);
		current = AIArray[0];
		AI_int = 0;
	}
	
	public void mouseClicked(int x_click, int y_click)
	{
		if(mm.isGameOver())
		{
			mm.changeState(mm.getGameOverState());
			return;
		}
		
		AI_int = mm.changeAI(x_click,y_click);
		if(AI_int == 1)
		{
			current = AIArray[0];
			return;
		}
		else if(AI_int == 2)
		{
			current = AIArray[1];
			return;
		}
		else if(AI_int == 3)
		{
			current = AIArray[2];
			return;
		}
		else if(AI_int == 0)
		{
			mm.changeState(mm.getPlayerState());
			return;
		}
		nextGuess();
	}
	
	public void changeAI(int AI_State)
	{
		AI_int = AI_State;
		current = AIArray[AI_State-1];
	}
	
	public Guess nextGuess()
	{
		Guess AI_Guess = current.nextGuess();
		mm.addGuess(AI_Guess);
		return AI_Guess;
	}
	
}