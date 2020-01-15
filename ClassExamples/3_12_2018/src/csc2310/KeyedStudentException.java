package csc2310;
public class KeyedStudentException extends RuntimeException
{
    public KeyedStudentException()
    {
        this("Unspecified KeyedStudent problem");
    }
    
    public KeyedStudentException(String msg)
    {
        super(msg);
    }
}