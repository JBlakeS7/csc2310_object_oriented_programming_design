package mastermind;

import util.Random;

public class MasterMindAIRandom implements MasterMindAI
{
	private MasterMind mm;

	public MasterMindAIRandom(MasterMind mastermind)
	{
		mm = mastermind;
	}

	public Guess nextGuess()
	{
		int index = mm.getNumGuesses();
		Random rand = Random.getRandomNumberGenerator();
		Guess guess = new Guess(mm.getNumGuesses()+1);

		for(int i = 0; i < 4; i++)
		{
			int random_int = rand.randomInt(1,7);
			guess.addColor(random_int);
		}
		return guess;
	}
}