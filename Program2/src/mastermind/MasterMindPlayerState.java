package mastermind;

public class MasterMindPlayerState implements MasterMindState
{
	private MasterMind mastermind;
	private int state;

	public MasterMindPlayerState(MasterMind mastermind)
	{
		this.mastermind = mastermind;
	}

	public void mouseClicked(int x_click, int y_click)
	{
		if(mastermind.isGameOver())
		{
			mastermind.changeState(mastermind.getGameOverState());
			return;
		}

		state = mastermind.changeAI(x_click,y_click);

		if(state > 0)
		{
			mastermind.changeState(mastermind.getAIState());
			((MasterMindAIState) mastermind.getAIState()).changeAI(state);
		}

		int color_selected = mastermind.isColorSelected(x_click,y_click);

		if(color_selected > 0)
		{
			mastermind.addGuess(color_selected);
		}
	}
}