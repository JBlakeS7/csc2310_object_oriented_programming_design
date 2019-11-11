import java.util.Random;
import java.text.DecimalFormat;
public class SimulateCarTroubleVisitor extends CarPartVisitorWithReport
{
    private static Random gen = new Random();
    private static DecimalFormat fmt1 = new DecimalFormat("0.0");
    private static DecimalFormat fmt3 = new DecimalFormat("0.0");
    private int bound;

    public SimulateCarTroubleVisitor()
    {
        super();
        reset();
    }
    
    public void reset()
    {
        bound = gen.nextInt(101); // between 0 and 100
    }
    
    public void visit(Car car)
    {
        report.add("\nSimulating car trouble for " + car.getVIN() + "\n");
    }
    
    public void visit(Engine engine)
    {
        int choice = gen.nextInt(bound + 1); // between 0 and bound
        if (choice % 4 == 0)
        {
            engine.leakOil();
            report.add("oil leak - level now: " + fmt3.format(engine.getOilLevel()) + " quarts");
        }
        reset();
        choice = gen.nextInt(bound + 1);
        if (choice % 5 == 0)
        {
            engine.leakRadiator();
            report.add("radiator leak - level now: " + fmt3.format(engine.getRadiatorLevel()) + " gallons");
        }
        reset();
    }
    
    public void visit(Wheel wheel)
    {
        int choice = gen.nextInt(bound + 1);
        if (choice % 3 == 0)
        {
            wheel.leakTire();
            report.add("tire leak for " + wheel.getWheelID() + " - tire pressure now: " + fmt1.format(wheel.getTirePressure()) + " psi");
        }
        reset();
    }
}
