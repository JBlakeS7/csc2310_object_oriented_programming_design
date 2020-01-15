public class CrapsGameDriver
{
    
    public static void main(String[] args)
    {
        int bankroll;
        
        do
        {
            bankroll = Keyboard.readInt("How much do you want to cash in for? ");
        }
        while (bankroll <= 0);
        
        CrapsGame theGame = new CrapsGame(bankroll);
        
        String wantToPlay = Keyboard.readString("Do you want to roll? (y/n)");
        try {
            while (wantToPlay.equalsIgnoreCase("y") || wantToPlay.equalsIgnoreCase("yes"))
            {
                int roll = theGame.roll();
                System.out.println("You rolled " + roll);
                String result = theGame.obtainRollResult(roll);
                System.out.println(result);
                wantToPlay = Keyboard.readString("Do you want to roll? (y/n)");            
            }
        }
        catch (CrapsException ce) {
            System.out.println(ce.getMessage());
        }
        System.out.println("Thanks for playing craps with us today.");
        int money = theGame.getMoney();
        if (money < bankroll)
        {
            System.out.println("You lost $" + (bankroll - money));
            System.out.println("Better luck next time!!!");
        }
        else if (money == bankroll)
        {
            System.out.println("You broke even!");
        }
        else
        {
            System.out.println("Congratulations on winning $" + (money - bankroll) + "!");
            System.out.println("Go home and invest!!!");
        }
    }
}