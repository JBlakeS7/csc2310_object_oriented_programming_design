package mastermind;

import java.util.ArrayList;
import java.util.List;

class MasterMindAIConsistent implements MasterMindAI
{
	private MasterMind mm;
	private List<Guess> guesses;
	
	public MasterMindAIConsistent(MasterMind mastermind)
	{
		mm = mastermind;
		guesses = new ArrayList<Guess>();
	}
	
	public Guess nextGuess()
	{
		int count = mm.getNumGuesses();
		if(count != guesses.size())
		{
			int diff = count - guesses.size();
			for(int i = 0; i < diff; i++)
			{
				Guess guess = mm.getGuess((count-i));
				guesses.add(guess);
			}
		}
		
		Guess next_guess = getRandomGuess();
		
		if(count == 0)
		{
			guesses.add(next_guess);
			return next_guess;
		}
		
		int[] result = new int[2];
		Guess prev = guesses.get(count-1);

		while(result[0] != prev.getNumBlack() || result[1] != prev.getNumWhite())
		{
			Guess current = new Guess(count+1);
			current = getRandomGuess();
			for(int i = 0;i < count; i++)
			{
				prev = guesses.get(i);
				result= mm.reportTestResult(current, prev);
				if(result[0] != prev.getNumBlack() || result[1] != prev.getNumWhite())
					break;
			}
			next_guess = current;
		}
		guesses.add(next_guess);
		return next_guess;
	}
	
	private Guess getRandomGuess()
	{
		int index = mm.getNumGuesses();
		util.Random rand = util.Random.getRandomNumberGenerator();
		Guess random_guess = new Guess(index+1);
		
		for(int i = 0; i < 4; i++)
		{
			int random_int = rand.randomInt(1,7);
			random_guess.addColor(random_int);
		}
		return random_guess;
	}
}