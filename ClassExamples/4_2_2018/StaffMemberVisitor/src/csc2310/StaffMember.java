package csc2310;

/**
 * Represents a generic staff member.
 */
public abstract class StaffMember implements AcceptVisitor //extends Object 
{
	   public abstract void accept(StaffVisitor sv);
		
	//assume name is just the last name
	public int compareTo(StaffMember that)
	{
		return name.compareTo(that.getName());
	}
	
   /**  StaffMember name. */
   private String name;

   /**  StaffMember address. */
   private Address address;  //unless this is immutable, could be a problem

   /**  StaffMember phone number. */
   private String phone;

   /**
    * Sets up a staff member using the specified information.
    */
   public StaffMember (String name, Address address, String phone)
   {
      //super() automatically inserted here
	  
      this.name = name;
      this.address = new Address(address.getStreet(), address.getCity(), address.getState(), address.getZip());
      this.phone = phone;
   }
   
   /**
    * Derived classes must define the pay method for each type of employee.
    */
   public abstract double pay();
   /*
   public double pay()
   {
	   return 3.14; 
   }
   */
   public String getName()
   {
      return name;
   }

   public Address getAddress()
   {
      return new Address(address.getStreet(), address.getCity(), address.getState(), address.getZip());
   }

   public String getPhone()
   {
      return phone;
   }

   /**
    * Returns a string including the basic employee information.
    */
   public String toString()  //overriding
   {
      String str = "Name: " + name + "\r\n";
      str += "Address: " + address + "\r\n";
      str += "Phone: " + getPhone() + "\r\n";
      return str;
   }

   //When will the below method be called?
   //What if I leave this method out?
   //Overriding vs. overloading
   public boolean equals(Object other)  //not overriding this method will result in an equals method that checks for aliases only
   {
      if ( !(other instanceof StaffMember) )
      {
         return false;
      }
	  

      return equals((StaffMember) other);
   }

   //When will the below method be called?
   //Overloading
   public boolean equals(StaffMember staff)
   {
      boolean test = false;
      if ( getName().equals(staff.getName()) && getAddress().equals(staff.getAddress()) && getPhone().equals(staff.getPhone()) )
      {
         test = true;
      }
      return test;
   }

}
