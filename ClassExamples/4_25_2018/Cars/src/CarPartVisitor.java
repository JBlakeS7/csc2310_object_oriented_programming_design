public interface CarPartVisitor
{
    public void visit(Car car);
    public void visit(Wheel wheel);
    public void visit(Engine engine);
}
