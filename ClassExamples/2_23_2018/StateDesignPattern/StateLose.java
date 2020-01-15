
/**
 * Write a description of class StateLose here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StateLose implements CrapsState
{
    private CrapsGame game;
    
    public StateLose(CrapsGame game)
    {
        this.game = game;
    }
    
    public String processRoll(int roll) throws CrapsException
    {
        int bankRoll = game.subtractMoney();
        game.nextState(game.getInitial());
        return "You lost " + game.getBetAmount() +
               " and your bankroll is now $" + bankRoll;
    }
}
