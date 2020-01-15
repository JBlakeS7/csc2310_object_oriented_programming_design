
/**
 * This interface will be used for our game of craps.
 * 
 * @author CSC 2120 class
 * @version 04.03.2013
 */
public interface CrapsState
{
    /** Determine what action to take in the craps game based on
     *  current value of the rolled dice.  Returns a string
     *  corresponding to the result.
     * @param  roll    the value of the dice roll
     */
    public String processRoll(int roll) throws CrapsException;
}
