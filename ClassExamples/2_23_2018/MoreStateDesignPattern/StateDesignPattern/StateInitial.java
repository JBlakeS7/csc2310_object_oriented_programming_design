
/**
 * The initial state for the craps game.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StateInitial implements CrapsState
{
    private CrapsGame game;
    
    public StateInitial(CrapsGame game)
    {
        this.game = game;
    }
    
    public String processRoll(int roll) throws CrapsException
    {
        String result = "";
        switch (roll) {
            case 7: case 11: 
                result = "You win!  Yay!!!";
                game.nextState(game.getWin());
                game.getWin().processRoll(roll);
                break;
            case 4: case 5: case 6: case 8: case 9: case 10:
                result = "The point is " + roll;
                StatePoint sp = (StatePoint) game.getPoint();
                game.nextState(sp);
                sp.setPoint(roll);
                break;
            case 2: case 3: case 12:
                result = "You lose!  Boo hoo!!!";
                game.nextState(game.getLose());
                game.getLose().processRoll(roll);
                break;
            default:
                result = "This shouldn't happen";
        }
        return result;
    }
}
