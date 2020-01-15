public class NewCarVisitor implements CarPartVisitor
{
    private int num_new_cars;
    
    public NewCarVisitor()
    {
        num_new_cars = 0;
    }
    
    public void visit(Car car)
    {
        if (car.getYear() == 2018)
        {
            num_new_cars++;
        }
    }
    
    public void visit(Engine engine)
    {
    }
    
    public void visit(Wheel wheel)
    {
    }
    
    public int getNumNewCars()
    {
        return num_new_cars;
    }
}