import util.Command;
import java.util.Random;
public class SimulateCarTroubleCommand implements Command<Car>
{
    private static Random gen = new Random();
    
    public void execute(Car car)
    {
        String to_print = "VIN: " + car.getVIN();
        if (gen.nextBoolean())
        {
            car.leakOil();
            to_print += " oil leak";
        }
        if (gen.nextBoolean())
        {
            car.leakRadiator();
            to_print += " radiator leak";
        }
        if (gen.nextBoolean())
        {
            car.leakAllTires();
            to_print += " tire leak";
        }
        System.out.println(to_print);
    }
}
