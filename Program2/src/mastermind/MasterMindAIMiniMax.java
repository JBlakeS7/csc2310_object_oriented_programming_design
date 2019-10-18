package mastermind;

import java.util.ArrayList;
import java.util.List;

class MasterMindAIMiniMax implements MasterMindAI
{
	private MasterMind mm;
	private ArrayList<Guess> possible_guesses;
	private ArrayList<Guess> guesses;
	
	public MasterMindAIMiniMax(MasterMind mastermind)
	{
		mm = mastermind;
		int count = 1;
		possible_guesses = new ArrayList<Guess>();
		guesses = new ArrayList<Guess>();
		for(int i = 1; i <= 7; i++)
		{
			for(int j = 1; j<= 7; j++)
			{
				for(int k = 1; k <= 7; k++)
				{
					for(int l = 1; l<=7; l++)
					{
						Guess possible_answer = new Guess(count);
						possible_answer.addColor(i);
						possible_answer.addColor(j);
						possible_answer.addColor(k);
						possible_answer.addColor(l);
						guesses.add(possible_answer);
						possible_guesses.add(new Guess(possible_answer));
					}
				}
			}
		}
	}
	
	public Guess nextGuess()
	{
		int count = mm.getNumGuesses();
		Guess guess = new Guess(count+1);

		if(count == 0)
		{
			guess.addColor(1);
			guess.addColor(2);
			guess.addColor(3);
			guess.addColor(4);
			return guess;
		}
		int max = 0;
		int min = 2401;
		int index = 0;
		Guess prev = mm.getGuess(count);
		int prevBlack = prev.getNumBlack();
		int prevWhite = prev.getNumWhite();
		int comp[] = new int[2];
		for(int i = 0; i < possible_guesses.size(); i++)
		{
			Guess current_guess = possible_guesses.get(i);
			comp = mm.reportTestResult(current_guess, prev);
			
			if(comp[0] != prevBlack || comp[1] != prevWhite)
			{
				possible_guesses.remove(i);
				i--;
			}
		}
		
		for(int i = 0; i < 4; i++)
		{
			for(int j = 0; j < 4; j++)
			{
				for(int k = 0; k < guesses.size(); k++)
				{
					min = 2401;
					Guess test = guesses.get(k);
					for(int l = 0; l < possible_guesses.size(); l++)
					{
						Guess another_guess = possible_guesses.get(l);
						comp = mm.reportTestResult(another_guess, test);
						
						if(comp[0] != i || comp[1] != j)
							index++;
						
					}
					
					if(index < min)
						min = index;
					
					index = 0;
					if(min > max && k < possible_guesses.size())
					{
						max = min;
						guess = possible_guesses.get(k);
					}
				}
			}
		}
		
		Guess final_guess = new Guess(count+1);
		List<Integer> idList = guess.getGuessColorIDs();
		final_guess.addColor(idList.get(0));
		final_guess.addColor(idList.get(1));
		final_guess.addColor(idList.get(2));
		final_guess.addColor(idList.get(3));
		return final_guess;
	}
}