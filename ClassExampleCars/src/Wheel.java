import java.util.Random;
import java.text.DecimalFormat;
public class Wheel implements CarPartAccept
{
    private String wheel_id;
    private static final String[] valid_wheel_ids = {"front left", "front right", "rear left", "rear right"};
    private double tire_pressure;
    private final double OPTIMAL_TIRE_PRESSURE;
    private Random gen = new Random();
    private DecimalFormat fmt = new DecimalFormat("0.0");
    
    public Wheel(String wheel_id, double tire_pressure) throws CarPartException
    {
        wheel_id = wheel_id.toLowerCase();
        if (tire_pressure < 0)
        {
            throw new CarPartException("Invalid tire_pressure for wheel");
        }
        if (wheel_id == null || !isValid(wheel_id))
        {
            throw new CarPartException("Invalid wheel id");
        }
        this.wheel_id = wheel_id;
        this.tire_pressure = tire_pressure;
        OPTIMAL_TIRE_PRESSURE = tire_pressure;
    }
    
    public static boolean isValid(String wheel_id)
    {
        return getWheelIDPosition(wheel_id) >= 0;
    }
    
    public void accept(CarPartVisitor visitor)
    {
        visitor.visit(this);
    }
    
    public double getTirePressure()
    {
        return tire_pressure;
    }
    
    public double getOptimalTirePressure()
    {
        return OPTIMAL_TIRE_PRESSURE;
    }
    
    public String getWheelID()
    {
        return wheel_id;
    }
    
    public static String[] getValidWheelIDs()
    {
        return valid_wheel_ids;
    }
    
    public static int getWheelIDPosition(String wheel_id)
    {
        int result = -1;
        if (wheel_id != null)
        {
            wheel_id = wheel_id.toLowerCase();
            for (int i = 0; i < valid_wheel_ids.length; i++)
            {
                if (valid_wheel_ids[i].equals(wheel_id))
                {
                    result = i;
                    break;
                }
            }
        }
        return result;
    }
    
    public String toString()
    {
        return "Wheel " + getWheelID() + "- Tire Pressure: " + fmt.format(getTirePressure()) + " psi, Optimal Tire Pressure: " +
                getOptimalTirePressure() + " psi";
    }
    
    public void leakTire()
    {
        double amount = gen.nextDouble() * gen.nextDouble() * gen.nextDouble() * tire_pressure;
        tire_pressure -= amount;
        if (tire_pressure < 0)
        {
            tire_pressure = 0;
        }
    }
    
    public void addAirToTire(double psi)
    {
        if (psi > 0)
        {
            tire_pressure = tire_pressure + psi;
            if (tire_pressure > OPTIMAL_TIRE_PRESSURE)
            {
                tire_pressure = OPTIMAL_TIRE_PRESSURE;
            }
        }
    }
}