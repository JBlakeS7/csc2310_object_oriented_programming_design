package csc2310;

import util.Random;  

import util.ReadTextFile;
import util.WriteTextFile;

import util.QueueLinked;

import util.Keyboard;  //Scanner  FACADE design pattern
import util.RandomPermutation;
//import util.*;

public class RationalDriver
{
   public static void main (String[] args)
   {
	    //public RationalNumber multiply(RationalNumber other_rational)
		RationalNumber rn1 = new RationalNumber(2, -3);
		// System.out.println(rn1.numerator);
		System.out.println(rn1.getNumerator());
		
		//System.out.println(rn.getNumerator());
		RationalNumber rn2 = new RationalNumber(5, 6);
		System.out.println(rn2.getDenominator());
		RationalNumber rn3 = rn1.add(rn2);
		rn3 = rn3.multiply(rn1); 
		//print out the "state" of the object
		System.out.println(rn3);  //rn3.toString()
		
		 
		//put the rational numbers on a queue
		QueueLinked<RationalNumber> q = new QueueLinked<RationalNumber>();
		
		ReadTextFile rf = new ReadTextFile("resources/rn_in.txt");
		String text = rf.readLine();  
		while(!rf.EOF())
		{
			System.out.println(text);
			
			RationalNumber rn = new RationalNumber(text);
			q.enqueue(rn);
			
			text = rf.readLine();
		}
		rf.close();
		
		WriteTextFile wf = new WriteTextFile("resources/rn_out.txt");
		while(!q.isEmpty())
		{
			RationalNumber rn = q.dequeue();
			wf.writeLine(rn.toString());
		}
		wf.close();
		
		// Math myMath = new Math();
		//Singleton design pattern
		//Keyboard kb = new Keyboard();
		Keyboard kb = Keyboard.getKeyboard();
		// only one Keyboard object is ever created - access is managed
		// Keyboard kb2 = Keyboard.getKeyboard();
		
	//	Random rand = new Random();
		 Random rand = Random.getRandomNumberGenerator();
		
		//when calling a method, it's object.method
		
		int rand_int = rand.randomInt(4, 16);
		double rand_float = rand.randomFloat(82, 93);
		
		System.out.println("The random int is " + rand_int);
		System.out.println("The random float is " + rand_float);
		
		
	
		RationalNumbers rats = new RationalNumbers();
		rats.add(rn1);
		rats.add(rn2);
		rats.add(rn3);
		System.out.println("The size of rats is " + rats.size());
		rats.displayRationalNumbers();
		RationalNumber sum = rats.sumUp();
		System.out.println(sum);
		
		RationalNumbers rats2 = new RationalNumbers();
		rats2.add(new RationalNumber(1, 4)); // anonymous object
		rats2.add(new RationalNumber(6, 8));
		System.out.println("The size of rats2 is " + rats2.size());
		rats2.displayRationalNumbers();
		RationalNumber sum2 = rats2.sumUp();
		System.out.println("sum2 = " + sum2);

		RationalNumbers rats3 = new RationalNumbers();
		rats3.add(new RationalNumber(3, 7));
		System.out.println("The size of rats3 is " + rats3.size());
		RationalNumber sum3 = rats3.sumUp();
		System.out.println("sum3 = " + sum3);
		
		RationalNumbers rats4 = new RationalNumbers();
		RationalNumber sum4 = rats4.sumUp();
		System.out.println("sum4 = " + sum4);
		
		
		
		
	
		
		int n = kb.readInt("Enter n for the permutation: ");
		System.out.println(n);
		int r = kb.readInt("Enter r for the permutation: ");
		System.out.println(r);
		
		//"shuffle"
		//r is the number of "shuffled" items to use
		//n is the total number of items
		util.RandomPermutation rp = new util.RandomPermutation(r, n);
		//hasNext and next
		while(rp.hasNext())
		{
			int next_num = rp.next();
			System.out.println(next_num);
		}
		
		util.RandomPermutation rp2 = new util.RandomPermutation(10, 10);
		System.out.println("rp2:");
		while (rp2.hasNext())
		{
			System.out.println(rp2.next());
		}
		
   }
}
