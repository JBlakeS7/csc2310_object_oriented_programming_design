public class StateWin implements CrapsState
{
    private CrapsGame game;
    
    public StateWin(CrapsGame game)
    {
        this.game = game;
    }
    
    public String processRoll(int roll) throws CrapsException
    {
        int bankRoll = game.addMoney();
        game.nextState(game.getInitial());
        return "You won " + game.getBetAmount() +
               " and your bankroll is now $" + bankRoll;
    }
}
