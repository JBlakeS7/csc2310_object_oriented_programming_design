public class CrapsGame
{
    private CrapsState initial = new StateInitial(this);
    private CrapsState lose = new StateLose(this);
    private CrapsState point = new StatePoint(this);
    private CrapsState win = new StateWin(this);
    private CrapsState current = initial;
    private CrapsDice dice = new CrapsDice();
    public static final int BET_AMOUNT = 1;
    private int amount = BET_AMOUNT;
    
    private int money;
    
    public CrapsGame() throws CrapsException
    {
        this(500);
    }
    
    public CrapsGame(int money) throws CrapsException
    {
        if (money <= 0)
        {
            throw new CrapsException("Need some $$$ to play");
        }
        this.money = money;
    }
    
    public CrapsState getInitial()
    {
        return initial;
    }
    
    public CrapsState getLose()
    {
        return lose;
    }
    
    public CrapsState getPoint()
    {
        return point;
    }
    
    public CrapsState getWin()
    {
        return win;
    }
    
    public void nextState(CrapsState state)
    {
        current = state;
    }

    public int roll()
    {
        return dice.roll();
    }
    
    public String obtainRollResult(int roll)
    {
        return current.processRoll(roll);
    }
    
    public int addMoney()
    {
        money += amount;
        return money;
    }

    public int subtractMoney()
    {
        money -= amount;
        if (money <= 0)
        {
            throw new CrapsException("Bank roll depleted to " + money);
        }
        return money;
    }
    
    public void changeBetAmount(int amount)
    {
        if (amount > 0)
        {
            this.amount = amount;
        }
    }
    
    public int getBetAmount()
    {
        return amount;
    }
    
    public int getMoney()
    {
        return money;
    }
}
