package csc2310;

import org.junit.*;
import static org.junit.Assert.*;

public class RationalNumbersTest
{
	private RationalNumbers rats;
	
	@Before 
	public void setUp() 
	{
		//this code is executed for each test
		rats = new RationalNumbers();
    }
	
	//make sure to test border cases
	
	@Test
	public void simpleTest()
	{
		assertTrue("example 1", 3 > 2);
		assertEquals("example 2", 4, 4);
	}
	
	@Test
	public void stringTest()
	{
		String str1 = "ABC";
		String str2 = "ABC";
		//String str2 = new String("ABC");
		assertTrue("String .equals test", str1.equals(str2));  //always works
		//assertTrue("String == test", str1 == str2);  //sometimes works
	}
	
	@Test
	public void ratsTest1()
	{
		RationalNumber rat1 = new RationalNumber(6, 8);

		rats.add(rat1);
		RationalNumber add_up = rats.sumUp();
		assertTrue("3", rat1.getNumerator() == 3);
		assertEquals("4", 4, rat1.getDenominator());
	}
	
	@Test
	public void ratsTest2()
	{
		RationalNumber rat1 = new RationalNumber(6, 4);

		rats.add(rat1);
		RationalNumber add_up = rats.sumUp();
		assertTrue("6/4 + 0 = 1 1/2", add_up.toString().equals(rat1.toString()));
		
		assertEquals("6/4 + 0 = 1 1/2", add_up.toString(), rat1.toString());
		assertEquals("6", add_up.getNumerator(), rat1.getNumerator());
		assertEquals("4", add_up.getDenominator(), rat1.getDenominator());
	}
	
	@Test
	public void ratsTest3()
	{
		RationalNumber rat1 = new RationalNumber(4, 3);
		RationalNumber rat2 = new RationalNumber(3, 4);
		RationalNumber rat3 = new RationalNumber("25/12");
		
		rats.add(rat1);
		rats.add(rat2);
		RationalNumber add_up = rats.sumUp();
		
		assertEquals("4/3 + 3/4 = 2 1/12", add_up.toString(), rat3.toString());
		assertTrue("4/3 + 3/4 = 2 1/12", add_up.toString().equals(rat3.toString()));
	}
}
