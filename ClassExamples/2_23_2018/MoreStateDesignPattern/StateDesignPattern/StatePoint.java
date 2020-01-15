
/**
 * Write a description of class StatePoint here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StatePoint implements CrapsState
{
    private CrapsGame game;
    private int point;
    
    public StatePoint(CrapsGame game)
    {
        this.game = game;
    }
    
    public void setPoint(int point) throws CrapsException
    {
        if (point >= 4 && point <= 10 && point != 7)
        {
            this.point = point;
        }
        else
        {
            throw new CrapsException("Invalid point - points must be between 4 and 10 and not equal to 7");
        }
    }
    
    public String processRoll(int roll) throws CrapsException
    {
        String result = "";
        if (roll == 7)
        {
            result = "Seven Out!  SORRY!!!";
            game.nextState(game.getLose());
            game.getLose().processRoll(roll);
        }
        else if (roll == point)
        {
            result = "You made your point! YAY!!!";
            game.nextState(game.getWin());
            game.getWin().processRoll(roll);
        }
        else if (roll >= 2 && roll <= 12)
        {
            result = "You're still in!  You rolled " + roll;
        }
        else {
            throw new CrapsException("Invalid roll in StatePoint");
        }
        return result;
    }
}
