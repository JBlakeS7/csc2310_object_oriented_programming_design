public class Car implements CarPartAccept
{
    private String make;
    private String model;
    private int year;
    private String VIN;
    private double value;
    
    private CarPartAccept[] components;
    
    public Car(String make, String model, int year, String VIN, double value, double oil_level,
                double radiator_level, double tire_pressure) throws CarPartException
    {
        if (make == null || make.equals(""))
        {
            throw new CarPartException("Invalid make for car");
        }
        if (model == null || model.equals(""))
        {
            throw new CarPartException("Invalid model for car");
        }
        if (VIN == null || VIN.equals(""))
        {
            throw new CarPartException("Invalid VIN for car");
        }
        if (year < 1980 || year > 2019)
        {
            throw new CarPartException("Invalid year for car");
        }
        if (value < 0)
        {
            value = 0;
        }
        this.make = make;
        this.model = model;
        this.year = year;
        this.VIN = VIN;
        this.value = value;
        components = new CarPartAccept[5];
        components[0] = new Engine(oil_level, radiator_level);
        String[] valid_wheel_ids = Wheel.getValidWheelIDs();
        for (int i = 1; i <= 4; i++)
        {
            components[i] = new Wheel(valid_wheel_ids[i-1], tire_pressure);
        }
    }
    
    public String getMake()
    {
        return make;
    }
    
    public String getModel()
    {
        return model;
    }
    
    public String getVIN()
    {
        return VIN;
    }
    
    public int getYear()
    {
        return year;
    }
    
    public double getValue()
    {
        return value;
    }
    
    public String toString()
    {
        String result = "Make: " + make + " Model: " + model + " Year: " + year + " VIN: " + VIN + "\n";
        for (int i = 0; i < components.length; i++)
        {
            result += components[i] + "\n";
        }
        return result;
    }
    
    public String toLine()
    {
        String result = make + "," + model + "," + year + "," + VIN + "," + value + ",";
        Engine engine = (Engine) components[0];
        result += engine.getOptimalOilLevel() + "," + engine.getOptimalRadiatorLevel() + ",";
        result += ((Wheel) components[1]).getOptimalTirePressure();
        return result;
    }
    
    public void accept(CarPartVisitor visitor)
    {
//        System.out.println("Entering Car accept for " + this);
        visitor.visit(this);
        for (CarPartAccept part : components)
        {
            part.accept(visitor);
        }
//        System.out.println("Leaving Car accept for " + this);
    }
    
    public void leakOil()
    {
        Engine engine = (Engine) components[0];
        engine.leakOil();
    }
    
    public void leakRadiator()
    {
        Engine engine = (Engine) components[0];
        engine.leakRadiator();
    }
    
    public void leakTires(String wheel_id)
    {
        if (wheel_id != null)
        {
            int position = Wheel.getWheelIDPosition(wheel_id);
            if (position >= 0)
            {
                Wheel wheel = (Wheel) components[position + 1];
                wheel.leakTire();
            }
        }
    }
    
    public void leakAllTires()
    {
        for (int i = 1; i <= 4; i++)
        {
            Wheel wheel = (Wheel) components[i];
            wheel.leakTire();
        }
    }
}
