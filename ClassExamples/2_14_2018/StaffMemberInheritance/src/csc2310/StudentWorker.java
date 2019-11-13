package csc2310;


/**
 * Write a description of class StudentWorker here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class StudentWorker /* extends Object */
{
    // instance variables - replace the example below with your own
    private String name;
    private String dept;

    /**
     * Constructor for objects of class StudentWorker
     */
    public StudentWorker()
    {
        // initialise instance variables
        name = "Jane Doe";
        dept = "unknown";
    }

    public String toString()
    {
        return super.toString() + " Name: " + name + " Department: " + dept;
    }
}
