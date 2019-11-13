package csc2310;

/**
 *  Represents a general paid employee.
 */
public class Employee extends StaffMember
{
	
	public int compareTo(StaffMember that)
	{
		int name_result = super.compareTo(that);
		if (name_result == 0)
		{
			double other_rate = that.pay();
			if (payRate < other_rate)
			{
				return -1;
			}
			else if (payRate > other_rate)
			{
				return 1;
			}
			else
			{
				return 0;
			}
		}
		
		return name_result;
	}
	
   private String ssn;
   private double payRate;  //later, make this private and use it indirectly
   
   //-----------------------------------------------------------------
   //  Sets up an employee with the specified information.
   //-----------------------------------------------------------------
   public Employee (String name, Address address, String phone, String ssn, double rate)
   {
      super (name, address, phone);

      this.ssn = ssn;
      payRate = rate;
   }

   public String getSSN()
   {
      return ssn;
   }

   //-----------------------------------------------------------------
   //  Returns the pay rate for this employee.
   //-----------------------------------------------------------------
   
   public double pay()
   {
      return payRate;
   }

   //-----------------------------------------------------------------
   //  Returns information about an employee as a string.
   //-----------------------------------------------------------------
   public String toString()
   {
      String str = super.toString();
      str += "Social Security Number: " + getSSN() + "\r\n";
      return str;
   }

   //based on SSN only
   public boolean equals(Object other)
   {
      if ( !(other instanceof Employee) )
      {
         return false;
      }

      return equals((Employee) other);
   }

   public boolean equals(StaffMember other)
   {
      if ( !(other instanceof Employee) )
      {
         return false;
      }

      return equals((Employee) other);
   }

   public boolean equals(Employee employee)
   {
      boolean test = false;

      if (getSSN().equals(employee.getSSN()))
      {
         test = true;
      }

      return test;
   }


	
}
