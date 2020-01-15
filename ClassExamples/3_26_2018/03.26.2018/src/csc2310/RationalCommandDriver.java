package csc2310;

import util.ReadTextFile;
import util.PrintCommand;
import util.Command;

public class RationalCommandDriver
{
   public static void main (String[] args)
   {
		RationalNumbers rns = new RationalNumbers();
		
		ReadTextFile rf = new ReadTextFile("resources/rn_in.txt");
		String text = rf.readLine();  
		while(!rf.EOF())
		{
			System.out.println(text);
			
			RationalNumber rn = new RationalNumber(text);
			rns.add(rn);
			
			text = rf.readLine();
		}
		rf.close();

		System.out.println("Performing Print Command:");
		PrintCommand<RationalNumber> pc = new PrintCommand<RationalNumber>();
		rns.execute(pc);
		
		System.out.println("Performing Rational Multiply Command:");
		RationalMultiplyCommand rmc = new RationalMultiplyCommand();
		rns.execute(rmc);
		RationalNumber product = rmc.getResult();
		System.out.println(product);
		
		System.out.println("Performing Rational Max Command:");
		RationalComparator comparator = new RationalComparator(0.00001);
		RationalMaxCommand rxc = new RationalMaxCommand(comparator);
		rns.execute(rxc);
		RationalNumber max = rxc.getMax();
		if (max == null)
		{
			System.out.println("An empty collection has no maximum.");
		}
		else
		{
			System.out.println("The maximum rational number is " + max);
		}
		
		System.out.println("Performing Rational Add Command:");
		RationalAddCommand rac = new RationalAddCommand();
		rns.execute(rac);
		RationalNumber total = rac.getResult();
		System.out.println(total);
		
		System.out.println("Performing Rational Collect Reciprocals Command:");
		RationalCollectReciprocalsCommand rcrc = new RationalCollectReciprocalsCommand();
		rns.execute(rcrc);
		RationalNumbers reciprocals = rcrc.getReciprocals();
		System.out.println("Printing the reciprocals with the Print Command created earlier:");
		reciprocals.execute(pc);
		System.out.println("Finding the product of the reciprocals with the Multiply Command:");
		rmc = new RationalMultiplyCommand(); // need to start over
		reciprocals.execute(rmc);
		System.out.println(rmc.getResult());
		System.out.println("Finding the maximum of the reciprocals with the Max Command:");
		rxc = new RationalMaxCommand(comparator);
		reciprocals.execute(rxc);
		max = rxc.getMax();
		if (max == null)
		{
			System.out.println("An empty collection has no maximum.");
		}
		else
		{
			System.out.println("The maximum reciprocal is " + max);
		}
		System.out.println("Finding the sum of the reciprocals with the Add Command:");
		rac = new RationalAddCommand();
		reciprocals.execute(rac);
		System.out.println(rac.getResult());
   }
}
