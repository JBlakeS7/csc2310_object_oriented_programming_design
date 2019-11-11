package csc2310;

import java.util.ArrayList;

//composition vs. aggregation

//composition assumes that the objects used as instance variables do not make sense
//outside the class they are declared in
public class RationalNumbers implements util.Execute<RationalNumber>
{
	private ArrayList<RationalNumber> rats;  //encapsulation
	
	public void execute(util.Command<RationalNumber> cmd)
	{
		for (RationalNumber rn : rats)
		{
			cmd.execute(rn);
		}
	}
	
	public RationalNumbers()
	{
		rats = new ArrayList<RationalNumber>();
	}
	
	public void add(RationalNumber rat)
	{
		rats.add(rat);  //delegation
	}
	
	public int size()
	{
		return rats.size();   //delegation
	}

	//add up all the rational numbers in the list
	public RationalNumber sumUp()
	{
		RationalNumber total = new RationalNumber("0/1");
		// RationalNumber total = rats.get(0); crashes on empty list
		for (int i = 0; i < rats.size(); i++) // changed 1 to 0
		{
			// total.add(rats.get(i)); does a computation but the result is not stored
			total = total.add(rats.get(i));
		}
		return total;
	}
	
	public void displayRationalNumbers()
	{
		//print out all the numbers in the list
		// (for loop)
		// (iterator)
		// (for-each)

		/*
		for (int i = 1; i <= rats.size(); i++)
		{
			RationalNumber rat = rats.get(i-1);
			System.out.println(rat);
		}
		*/
		
		/*
		Iterator<RationalNumber> iter = rats.iterator();
		while(iter.hasNext())
		{
			RationalNumber rat = iter.next();
			System.out.println(rat);
		}
		*/
		
		for(RationalNumber rat : rats)
		{
			System.out.println(rat);
		}
		
	}
}
