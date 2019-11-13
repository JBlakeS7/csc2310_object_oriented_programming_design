package csc2310;

/**
 *  Represents an executive staff member, who can earn a bonus.
 */
 //final keyword: can't be extended
public final class Executive extends Employee
{
   private double bonus;
   
   public double getBonus()
   {
	   return bonus;
   }
   
   public void resetBonus()
   {
	   bonus = 0;
   }

   //-----------------------------------------------------------------
   //  Sets up an executive with the specified information.
   //-----------------------------------------------------------------
   public Executive (String name, Address address, String phone, String ssn, double rate)
   {
      super (name, address, phone, ssn, rate);
      bonus = 0;  // bonus has yet to be awarded
   }

   //-----------------------------------------------------------------
   //  Awards the specified bonus to this executive.
   //-----------------------------------------------------------------
   public void awardBonus (double exec_bonus)
   {
      if (exec_bonus > 0)
      {
         bonus = exec_bonus;
      }
   }

   //-----------------------------------------------------------------
   //  Computes and returns the pay for an executive, which is the
   //  regular employee payment plus a one-time bonus.
   //-----------------------------------------------------------------
   
   public double pay()
   {
      double payment = super.pay() + bonus;

      bonus = 0;  //reset the bonus
      return payment;
   }
   
   	/*
	public void accept(StaffVisitor sv)
	{
		sv.visit(this);
	}
	*/
   
}
