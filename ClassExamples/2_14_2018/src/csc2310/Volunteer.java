package csc2310;

/**
 *  Represents a staff member that works as a volunteer.
 */
//this class could be made final
public final class Volunteer extends StaffMember
{
	
   /**
    *  Sets up a volunteer using the specified information.
    */
   public Volunteer (String name, Address address, String phone)
   {
	   //call the parent class constructor
	   //call to super must be the first statement in the constructor
	   
       super (name, address, phone);
   }

   /**
    *  Returns a zero pay value for this volunteer.
    */
	//method overriding
   public double pay()
   {
      return 0.0;
   }
   

}
