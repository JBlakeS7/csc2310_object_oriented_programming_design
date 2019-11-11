public class CarPartException extends RuntimeException
{
    public CarPartException(String problem)
    {
        super(problem);
    }
    
    public CarPartException()
    {
        this("Unspecified CarPart problem");
    }
}