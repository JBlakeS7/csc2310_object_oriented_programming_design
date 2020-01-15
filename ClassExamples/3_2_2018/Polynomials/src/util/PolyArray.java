package util;

import java.io.*;
import java.text.DecimalFormat;

class PolyArray implements PolyInterface
{
   private double[] poly;
   private int deg;
   private final int MAXPOWER;

   private final static double TOL = .00001;
   
   public PolyArray(int max_power) throws PolyException  
   {
      if (max_power < 0 || max_power > 100)
      {
         throw new PolyException("The maximum power for the polynomial must be between 0 and 100.");
      }
   
      MAXPOWER = max_power;  //max range is 0 to 100 (array size 101)
      poly = new double[MAXPOWER + 1];
      deg = 0;
	  
	  assert(MAXPOWER >= 0 && MAXPOWER <= 100);
   }

   //FileIO uses RTEs so external problems may not be caught
   //generally don't want to do this, but code is more readable this way
   //philosophy: unchecked exceptions are bugs and should "crash" and be fixed
   //            checked exceptions are "handled" as they are not bugs and can be anticipated
   //            like any general rule, there are "exceptions" to the rule about exceptions

   public PolyArray(String file_name) throws PolyException
   {
      this(100);
      ReadTextFile coeffs;

      try
      {
         coeffs = new ReadTextFile(file_name);
      }
      catch (FileIOException fioe)
      {
         throw new PolyException(fioe.getMessage());
      }

      int power = 0;
      String line = coeffs.readLine();

      while(!coeffs.EOF() && power <= MAXPOWER)
      {
         double coeff = Double.parseDouble(line);  //what if not a double? try-catch NFE
         if (Math.abs(coeff) > 0.0001)
         {
            changeCoefficient(coeff, power);
         }
         power++;
         line = coeffs.readLine();
      }

      coeffs.close();
   }

   public int getDegree()
   {
      return deg;
   }

   public double getCoefficient(int power) throws PolyException
   {
      if (power < 0 || power > MAXPOWER)
      {
         throw new PolyException("Power must be between 0 and " + MAXPOWER);//, power);
      }
	  
      return poly[power];
   }

   public void changeCoefficient(double coeff, int power) throws PolyException
   {

      if (power < 0 || power > MAXPOWER)
      {
         throw new PolyException("Power must be between 0 and " + MAXPOWER, power);
      }

      poly[power] = coeff;

      if (power > deg)
      {
         deg = power;
      }
   }

   public PolyInterface multiply(PolyInterface other)
   {
      PolyInterface result = new PolyArray(100);
      PolyInterface me = this;
      int n = me.getDegree();
      int m = other.getDegree();

      for (int y = 0; y <= n; y++) //loop over coeffs
      {
         for (int z = 0; z <= m; z++)  //loop over second coeffs
         {
            double coeff1 = me.getCoefficient(y);
            double coeff2 = other.getCoefficient(z);
            if (Math.abs(coeff1) > TOL && Math.abs(coeff2) > TOL)
            {
               double coeff3 = result.getCoefficient(y + z);
               result.changeCoefficient(coeff3 + (coeff1 * coeff2), y + z);
            }
         }
      }

      return result;
   }

   public double evaluate(double x)
   {
      double eval = 0.0;

      for (int power = deg; power >= 0; power--)
      {
         eval = poly[power] + eval*x;
      }

      return eval;
   }

   public double evaluateDerivative(double x)
   {
      double eval = 0.0;

      for (int power = deg; power >= 1; power--)
      {
         eval = poly[power]*power + eval*x;
      }

      return eval;
   }

   public String toString()
   {
      DecimalFormat fmt = new DecimalFormat("0.000");
      String temp = "";
      temp = fmt.format(poly[deg]) + "x^" + deg;

      for (int power = deg - 1; power >= 0; power--)
      {

         double coeff = poly[power];

         if (Math.abs(coeff) > TOL)
         {
            String strCoeff = fmt.format(Math.abs(coeff));

            if (coeff < 0)
            {
               temp += " - ";
            }
            else
            {
               temp += " + ";
            }

            if (power > 1)
            {
               temp += strCoeff + "x^" + power;
            }
            else if (power == 1)
            {
               temp += strCoeff + "x";
            }
            else
            {
               temp += strCoeff;
            }

         }
      }

      return temp;
   }
}