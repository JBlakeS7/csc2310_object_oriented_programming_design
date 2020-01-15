import java.text.DecimalFormat;
public class CarFixVisitor extends CarPartVisitorWithReport
{
    private static DecimalFormat fmt1 = new DecimalFormat("0.0");
    private static DecimalFormat fmt3 = new DecimalFormat("0.000");
    
    public void visit(Car car)
    {
        report.add("\nFixing car with VIN " + car.getVIN() + " if needed. "); 
    }
    
    public void visit(Engine engine)
    {
        double diff = engine.getOptimalOilLevel() - engine.getOilLevel();
        if (diff > 0)
        {
            engine.addOil(diff);
            report.add("\nAdded " + fmt3.format(diff) + " quarts of oil.");
        }
        diff = engine.getOptimalRadiatorLevel() - engine.getRadiatorLevel();
        if (diff > 0)
        {
            engine.addRadiator(diff);
            report.add("\nAdded " + fmt3.format(diff) + " gallons of antifreeze/water to radiator.");
        }
    }
    
    public void visit(Wheel wheel)
    {
        double diff = wheel.getOptimalTirePressure() - wheel.getTirePressure();
        if (diff > 0)
        {
            wheel.addAirToTire(diff);
            report.add("\nAdded " + fmt1.format(diff) + " psi to " + wheel.getWheelID() + " tire.");
        }
    }
}