public class CrapsException extends RuntimeException
{
    public CrapsException()
    {
        this("General craps problem");
    }
    
    public CrapsException(String problem)
    {
        super(problem);    
    }
}