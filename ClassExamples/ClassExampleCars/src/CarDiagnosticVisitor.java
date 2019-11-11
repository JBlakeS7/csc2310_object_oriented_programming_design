import java.util.ArrayList;
public class CarDiagnosticVisitor extends CarPartVisitorWithReport
{
    private double tolerance_percentage;
    
    public CarDiagnosticVisitor(double tolerance_percentage)
    {
        super();
        setTolerancePercentage(tolerance_percentage);
    }
    
    public void setTolerancePercentage(double tolerance_percentage)
    {
        if (tolerance_percentage <= 0)
        {
            tolerance_percentage = 10;
        }
        this.tolerance_percentage = tolerance_percentage / 100;
    }
    
    public double getTolerancePercentage()
    {
        return tolerance_percentage;
    }
    
    public void visit(Car car)
    {
        report.add("\nDiagnosis for:\n" + car + "\nNo news is good news.");
    }
    
    public void visit(Wheel wheel)
    {
        double optimal = wheel.getOptimalTirePressure();
        double current = wheel.getTirePressure();
        double pressure_diff = current - optimal;
        if (Math.abs(pressure_diff)/optimal > tolerance_percentage)
        {
            String status = wheel.getWheelID() + ": tire pressure too ";
            if (pressure_diff > 0)
            {
                status += "high.";
            }
            else
            {
                status += "low.";
            }
            report.add(status);
        }
    }
    
    public void visit(Engine engine)
    {
        double optimal_oil = engine.getOptimalOilLevel();
        double oil = engine.getOilLevel();
        double oil_diff = oil - optimal_oil;
        double optimal_radiator = engine.getOptimalRadiatorLevel();
        double radiator = engine.getRadiatorLevel();
        double radiator_diff = radiator - optimal_radiator;
        if (Math.abs(oil_diff)/optimal_oil > tolerance_percentage)
        {
            String status = "Engine oil too ";
            if (oil_diff > 0)
            {
                status += "high.";
            }
            else
            {
                status += "low.";
            }
            report.add(status);
        }
        if (Math.abs(radiator_diff)/optimal_radiator > tolerance_percentage)
        {
            String status = "Radiator level too ";
            if (radiator_diff > 0)
            {
                status += "high.";
            }
            else
            {
                status += "low.";
            }
            report.add(status);
        }
    }
}