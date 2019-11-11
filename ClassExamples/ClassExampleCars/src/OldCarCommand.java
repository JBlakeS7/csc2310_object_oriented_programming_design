import util.Command;
public class OldCarCommand implements Command<Car>
{
    private int num_old_cars;
    
    public OldCarCommand()
    {
        num_old_cars = 0;
    }
    
    public void execute(Car car)
    {
        if (car.getYear() < 2009)
        {
            num_old_cars++;
        }
    }
    
    public int getNumOldCars()
    {
        return num_old_cars;
    }
}