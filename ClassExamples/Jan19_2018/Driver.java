package csc2310;

import util.Keyboard;

public class Driver
{
	
   public static void main (String[] args)
   {
		//do not use the Scanner class
		Keyboard kb = Keyboard.getKeyboard();
		
		int n = kb.readInt("Enter an integer: ");
		System.out.println(n);
		double x = kb.readDouble("Enter a floating point number: ");
		System.out.println(x);
   }
   
}
