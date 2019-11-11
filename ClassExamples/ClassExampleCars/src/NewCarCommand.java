import util.Command;
public class NewCarCommand implements Command<Car>
{
    private int num_new_cars;
    
    public NewCarCommand()
    {
        num_new_cars = 0;
    }
    
    public void execute(Car car)
    {
        if (car.getYear() == 2018)
        {
            num_new_cars++;
        }
    }
    
    public int getNumNewCars()
    {
        return num_new_cars;
    }
}