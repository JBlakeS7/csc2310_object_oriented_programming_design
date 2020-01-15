package csc2310;

/**
 *  Represents an employee that gets paid by the hour.
 */
//example of inheritance by specialization
public class Hourly extends Employee
{
   //Discuss shadowing of instance variables
   private double hours_worked;
   
   public double getHours()
   {
	   return hours_worked;
   }
   
   public void resetHours()
   {
	   hours_worked = 0;
   }

   //-----------------------------------------------------------------
   //  Sets up this hourly employee using the specified information.
   //-----------------------------------------------------------------
   public Hourly (String name, Address address, String phone, String ssn, double rate)
   {
      super (name, address, phone, ssn, rate);
      hours_worked = 0.0;
   }

   //-----------------------------------------------------------------
   //  Adds the specified number of hours to this employee's
   //  accumulated hours.
   //-----------------------------------------------------------------
   public void addHours (double more_hours)
   {
      if (more_hours > 0.0)
      {
         hours_worked += more_hours;
      }
   }

   //-----------------------------------------------------------------
   //  Computes and returns the pay for this hourly employee.
   //-----------------------------------------------------------------
   
   public double pay()
   {
      double payment = super.pay() * hours_worked; //alternative if payRate is not inherited
      //double payment = super.payRate * hours_worked;

      hours_worked = 0.0;  //reset the number of hours worked
      return payment;
   }

   //-----------------------------------------------------------------
   //  Returns information about this hourly employee as a string.
   //-----------------------------------------------------------------
   public String toString()
   {
      String str = super.toString();
      str += "Current hours: " + hours_worked + "\r\n";
      return str;
   }
   
   	/*
	public void accept(StaffVisitor sv)
	{
		sv.visit(this);
	}
 */

}
