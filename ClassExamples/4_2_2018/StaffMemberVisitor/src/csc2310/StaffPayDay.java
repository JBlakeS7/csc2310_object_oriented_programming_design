package csc2310;

public class StaffPayDay implements StaffVisitor
{
   private double payroll = 0;

   public double getPayroll()
   {
      return payroll;  //obtain the total payroll
   }

   public void visit(Employee emp)
   {
      payroll += emp.pay();
   }

   public void visit(Volunteer emp)
   {
      payroll += 0;
   }

   //works for Hourly only
   public void visit(Hourly emp)
   {
      double hours_worked = emp.getHours();
      payroll += emp.pay()*hours_worked;
      emp.resetHours();
   }

   //works for Executive only
   public void visit(Executive emp)
   {
      double bonus = emp.getBonus();
      payroll += emp.pay() + bonus;
      emp.resetBonus();
   }
}
