package csc2310;



import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class StaffMemberTest.
 *
 * @author  Martha Kosa
 * @version 02.16.2018
 */
public class StaffMemberTest
{
    private StaffMember[] staff_list; 

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
      System.out.println("setUp");
      Address address = new Address("1 Main Street","Cookeville", "TN", 38501);
      staff_list = new StaffMember[6];
      staff_list[0] = new Executive ("Alexander the Great", address, "555-0469", "123-45-6789", 8000);
      staff_list[1] = new Employee ("Leonardo da Vinci", address, "555-0101", "987-65-4321", 3200);
      staff_list[2] = new Employee ("Queen Elizabeth I", address, "555-0000", "010-20-3040", 3750);
      staff_list[3] = new Hourly ("Joan of Arc", address, "555-0690", "958-47-3625", 11.17);
      staff_list[4] = new Volunteer ("George Washington", address, "555-8374");
      staff_list[5] = new Hourly ("Julius Caesar", address, "858-42-3125", "555-7282", 10.55);
      ((Hourly) staff_list[3]).addHours(165);  //pay day is monthly
      ((Hourly) staff_list[5]).addHours(120);  //part-time
      ((Executive) staff_list[0]).awardBonus(2000);
    }

    /** For each test, write a method */
    @Test
    public void testAddressesForNonAliasing()
    {
        assertTrue("Addresses not aliases", staff_list[0].getAddress() != staff_list[1].getAddress());
    }
    
    @Test
    public void testPayDay()
    {
      double pay_roll = 0;

      for (StaffMember employee : staff_list)
      {
          pay_roll += employee.pay();
      }
      System.out.println(pay_roll);
      assertEquals("pay_roll == 20059.05", pay_roll, 20059.05, 0.001); // tolerance
    }
    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
        System.out.println("tearDown: Fill in code if needed.");
    }
}
