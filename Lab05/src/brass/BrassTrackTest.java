package brass;

import org.junit.*;
import static org.junit.Assert.*;

public class BrassTrackTest
{
	private BrassTrack bt;
	private int allowed_error;
	
	//DO THIS
	//declare a BrassCottonDemandTrack object
	
	
	
	@Before 
	public void setUp() 
	{
		BrassXML bx = new BrassXML("resources/brass_pixels.xml");
		bt = new BrassTrack(bx);
		allowed_error = 2;  //+- two pixels is the allowed error
		
		//DO THIS (do the cotton demand track part last)
		//create a BrassCottonDemandTrack object
		
		
    }
	
	
	/*
	@Test
	public void brassCottonDemand()
	{
		//moves the marker down and returns extra income
		int cotton_demand_extra_income = bcd.cottonTrackIncome();
		//make sure marker is in correct location
		int cotton_demand_index = bcd.getCottonDemandIndex();
		
		
	}
	*/
	
	//(x, y) for location 0 is specified in brass_pixels.xml
	//as it doesn't depend on the offsets, this test should certainly pass
	@Test
	public void brassLocTrackTest0()
	{
		int x_pos = bt.getXPixel(0);
		int y_pos = bt.getYPixel(0);
		assertTrue("Brass Track Loc X 0: TOO LOW", 322 <= (x_pos + allowed_error));
		assertTrue("Brass Track Loc X 0: TOO HIGH", 322 >= (x_pos - allowed_error));
		assertTrue("Brass Track Loc Y 0: TOO LOW", 642 <= (y_pos + allowed_error));
		assertTrue("Brass Track Loc Y 0: TOO HIGH", 642 >= (y_pos - allowed_error));
	}
	
	//(x, y) for location 1 is (302, 642)
	//(x, y) for location 5 is (226, 642)
	//(x, y) for location 10 is (132, 642)
	//(x, y) for location 16 is (20, 642)
	//(x, y) for location 17 is (20, 623)
	//(x, y) for location 18 is (20, 605)
	//(x, y) for location 32 is (245, 568)
	//(x, y) for location 46 is (19, 532)
	//(x, y) for location 55 is (151, 494)
	//(x, y) for location 64 is (19, 458)
	//(x, y) for location 70 is (94, 421)
	//(x, y) for location 76 is (19, 386)
	//(x, y) for location 82 is (94, 349)
	//(x, y) for location 88 is (18, 311)
	//(x, y) for location 93 is (74, 275)
	//(x, y) for location 98 is (18, 238)
	


}
