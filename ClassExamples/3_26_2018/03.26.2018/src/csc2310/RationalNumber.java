package csc2310;

/**
 * This class is used to store numbers that can be represented by one integer divided by another.
 * This class is immutable.  The only way to set the numerator and denominator is through the constructor
 */
public class RationalNumber
{
   private int numerator;      //PIE encapsulation
   private int denominator;

   /**
    *  Sets up the rational number by ensuring a nonzero denominator
    *  and making only the numerator signed.
    */
   public RationalNumber(int numer, int denom)
   {
      if (denom == 0)
      {
         denom = 1;
      }

      // Make the numerator "store" the sign
      if (denom < 0)
      {
         numer = numer * -1;
         denom = denom * -1;
      }

      numerator = numer;
      denominator = denom;

      this.reduce();
   }

   public RationalNumber(RationalNumber to_copy)
   {
      //to_copy should already be reduced
      numerator = to_copy.getNumerator();
      denominator = to_copy.getDenominator();
   }
  
   public RationalNumber(String str)
   {
      String[] tokens = str.split("/");
      String numer = tokens[0];
      String denom = tokens[1];

      numerator = Integer.parseInt(numer);
      denominator = Integer.parseInt(denom);  //check for 0 here too

	  // Make the numerator "store" the sign
      if (denominator < 0)
      {
         numerator = numerator * -1;
         denominator = denominator * -1;
      }

      reduce();
   }

   /**
    *  Adds this rational number to the one passed as a parameter.
    *  A common denominator is found by multiplying the individual
    *  denominators.
    */
   public RationalNumber add(RationalNumber other_rational)
   {
	   //use get methods even though you can access the vars directly
      int common_denom = getDenominator() * other_rational.getDenominator();
	  
	  
      int numerator1 = getNumerator() * other_rational.getDenominator();
      int numerator2 = other_rational.getNumerator() * this.getDenominator();
      int sum = numerator1 + numerator2;

      return new RationalNumber(sum, common_denom);
   }

   public RationalNumber subtract(RationalNumber other_rational)
   {
      int common_denom = getDenominator() * other_rational.getDenominator();
      int numerator1 = getNumerator() * other_rational.getDenominator();
      int numerator2 = other_rational.getNumerator() * getDenominator();
      int difference = numerator1 - numerator2;

      return new RationalNumber(difference, common_denom);
   }

   /**
    *  Multiplies this rational number by the one passed as a
    *  parameter.
    */
   public RationalNumber multiply(RationalNumber other_rational)
   {
	   //this refers to the calling object
	   int numer = this.getNumerator() * other_rational.getNumerator();
      int denom = this.getDenominator() * other_rational.getDenominator();

      return new RationalNumber(numer, denom);
   }

   public RationalNumber divide(RationalNumber other_rational)
   {
      return multiply(other_rational.reciprocal());
   }

   public RationalNumber reciprocal()
   {
      return new RationalNumber(getDenominator(), getNumerator());
   }

   public int getNumerator() // getter / accessor methods
   {
      return numerator;
   }

   public int getDenominator()
   {
      return denominator;
   }

   /**
    *  Determines if this rational number is equal to the one passed
    *  as a parameter.  Assumes they are both reduced.
    */
   public boolean equals(RationalNumber other_rational)
   {
      return ( getNumerator() == other_rational.getNumerator() &&
               getDenominator() == other_rational.getDenominator() );
   }

   public String toString()
   {
      String result;
      int wholeNumber = 0;
      int numer;
      int denom;

      if (getNumerator() == 0)
      {
         result = "0";
      }
      else if (getDenominator() == 1)
      {
         result = getNumerator() + "";
      }
      else if (getNumerator() > getDenominator())
      {
         numer = getNumerator();
         denom = getDenominator();
         wholeNumber = numer/denom;
         numer = numer - wholeNumber*denom;
         result = wholeNumber + " " + numer + "/" + denom;
      }
      else
      {
         result = getNumerator() + "/" + getDenominator();
      }
    
      return result;
   }

   /**
    *  Reduces this rational number by dividing both the numerator
    *  and the denominator by their greatest common divisor.
    */
   private void reduce()
   {
      int common;

      if (numerator != 0)
      {
         common = gcd(Math.abs(getNumerator()), getDenominator());

         numerator = getNumerator() / common;
         denominator = getDenominator() / common;
      }
   }

   /**
    *  Computes and returns the greatest common divisor of the two
    *  positive parameters. Uses Euclid's algorithm.
    */
   private int gcd (int num1, int num2)
   {
      while (num1 != num2)
      {
         if (num1 > num2)
         {
            num1 = num1 - num2;
         }
         else
         {
            num2 = num2 - num1;
         }
      }

      return num1;
   }
}
