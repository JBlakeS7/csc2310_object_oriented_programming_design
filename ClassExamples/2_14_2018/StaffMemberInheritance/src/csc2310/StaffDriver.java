package csc2310;

public class StaffDriver
{
   public static double payDay(StaffMember[] staff_list)
   {
	   /*
      StaffVisitor spd = new StaffPayDay();
	  for (StaffMember employee : staff_list)
	  {
		  employee.accept(spd);
		  
		  //spd.visit(employee);
	  }
	  */
	  
	  
	  double pay_roll = 0;

      for (StaffMember employee : staff_list)
      {
		  pay_roll += employee.pay();
      }

      //20059.05
      //double payroll = ((StaffPayDay) spd).getPayroll();
      return pay_roll;
	  
	  
	  		  //as long as each subclass overrides accept, will call the correct visit method
         //employee.accept(spd);  

		 //a visit method of type StaffMember does not exist
         //spd.visit(employee);  
   }
   
      public static void main(String[] args)
   {
      StaffMember[] staff_list = setUp();
      ((Hourly) staff_list[3]).addHours(165);  //pay day is monthly
      ((Hourly) staff_list[5]).addHours(120);  //part-time
      ((Executive) staff_list[0]).awardBonus(2000);

      //System.out.println(vacationDays(staff_list));  //compute this first
      System.out.println(payDay(staff_list));
   }

   /**
    *  Sets up the list of staff members.
    */
   public static StaffMember[] setUp()
   {
      StaffMember[] staff_list = new StaffMember[6];
      Address address = new Address("1 Main Street","Cookeville", "TN", 38501);

      staff_list[0] = new Executive ("Alexander the Great", address, "555-0469", "123-45-6789", 8000);
      staff_list[1] = new Employee ("Leonardo da Vinci", address, "555-0101", "987-65-4321", 3200);
      staff_list[2] = new Employee ("Queen Elizabeth I", address, "555-0000", "010-20-3040", 3750);
      staff_list[3] = new Hourly ("Joan of Arc", address, "555-0690", "958-47-3625", 11.17);
      staff_list[4] = new Volunteer ("George Washington", address, "555-8374");
      staff_list[5] = new Hourly ("Julius Caesar", address, "858-42-3125", "555-7282", 10.55);

      return staff_list;
   }

/*
   public static int vacationDays(StaffMember[] staffList)
   {
      StaffVisitor vacationDays = new StaffVacation();

      for (StaffMember employee : staffList)
      {
         employee.accept(vacationDays); 
      }

      int vacDays = ((StaffVacation) vacationDays).getVacationDays();
      return vacDays;
   }
*/
}
