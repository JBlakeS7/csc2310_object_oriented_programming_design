import java.util.Random;
import java.text.DecimalFormat;

public class Engine implements CarPartAccept
{
    private double oil_level;
    private double radiator_level;
    private final double OPTIMAL_OIL_LEVEL;
    private final double OPTIMAL_RADIATOR_LEVEL;
    private static Random gen = new Random();
    private static DecimalFormat fmt = new DecimalFormat("0.000");
    
    public Engine(double oil_level, double radiator_level) throws CarPartException
    {
        if (oil_level < 4)
        {
            throw new CarPartException("Oil level should be at least 4 quarts.");
        }
        if (radiator_level < 0.5)
        {
            throw new CarPartException("Radiator level should be at least 0.5 gallons.");
        }
        this.oil_level = oil_level;
        this.OPTIMAL_OIL_LEVEL = oil_level;
        this.radiator_level = radiator_level;
        this.OPTIMAL_RADIATOR_LEVEL = radiator_level;
    }
    
    public double getOilLevel()
    {
        return oil_level;
    }
    
    public double getOptimalOilLevel()
    {
        return OPTIMAL_OIL_LEVEL;
    }
    
    public double getRadiatorLevel()
    {
        return radiator_level;
    }
    
    public double getOptimalRadiatorLevel()
    {
        return OPTIMAL_RADIATOR_LEVEL;
    }
    
    public void leakOil()
    {
        double amount = gen.nextDouble() * oil_level;
        oil_level -= amount;
        if (oil_level < 0)
        {
            oil_level = 0;
        }
    }
    
    public void addOil(double amount)
    {
        if (amount > 0)
        {
            oil_level += amount;
            if (oil_level > OPTIMAL_OIL_LEVEL)
            {
                oil_level = OPTIMAL_OIL_LEVEL;
            }
        }
    }
    
    public void leakRadiator()
    {
        double amount = gen.nextDouble() * radiator_level;
        radiator_level -= amount;
        if (radiator_level < 0)
        {
            radiator_level = 0;
        }
    }
    
    public void addRadiator(double amount)
    {
        if (amount > 0)
        {
            radiator_level += amount;
            if (radiator_level > OPTIMAL_RADIATOR_LEVEL)
            {
                radiator_level = OPTIMAL_RADIATOR_LEVEL;
            }
        }
    }
    
    
    public String toString()
    {
        return "Engine - oil level: " + fmt.format(oil_level) + " quarts, radiator level: " + fmt.format(radiator_level) + " gallons";
    }
    
    public void accept(CarPartVisitor visitor)
    {
        visitor.visit(this);
    }
}
