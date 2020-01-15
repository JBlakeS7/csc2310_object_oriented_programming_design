package csc2310;

//weakness-- what if new types need to be added to the interface?
public interface StaffVisitor
{
   public void visit(Employee emp);
   public void visit(Volunteer emp);
   public void visit(Hourly emp);
   public void visit(Executive emp);
}

//you have elements of many different classes and the operations will
//vary in its actions depending on the class

//you have a data structure and you want to define new operations
//on the elements but you don't want to or can't modify the classes themselves

//use an Iterator to access all of the elements, calling their accept methods
