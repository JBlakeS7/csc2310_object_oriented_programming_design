package csc2310;

import java.util.Comparator;

/*
//provided Java interface
public interface Comparator<T>
{
	public int compare(T item_1, T item_2);
}
*/

public class RationalComparator implements Comparator<RationalNumber>
{
	private double TOL;
	
	public RationalComparator(double TOLERANCE)
	{
		TOL = TOLERANCE;
	}
	
	public int compare(RationalNumber rat1, RationalNumber rat2)
	{
		int n_1 = rat1.getNumerator();
		int n_2 = rat2.getNumerator();
		
		int d_1 = rat1.getDenominator();
		int d_2 = rat2.getDenominator();
		
		double rat1_decimal = ((double) n_1)/d_1;
		double rat2_decimal = ((double) n_2)/d_2;

		if (Math.abs(rat1_decimal - rat2_decimal) < TOL)
		{
			return 0;
		}
		else if (rat1_decimal < rat2_decimal) return -1;
		else return 1;
	}
}
