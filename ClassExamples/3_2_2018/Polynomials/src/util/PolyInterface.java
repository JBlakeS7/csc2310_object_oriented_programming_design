package util;

//wrong comments is about the worst thing you can do
//Liskov Subst Principle  Rect r = RectFactory.getSquare();

//interface/class level comment
/**
	This interface defines methods that any class representing a polynomial
	should implement.  This includes an inherited evaluate method.
	It is assumed that the powers of x are all nonnegative integers.
	The degree of the polynomial is the largest power of x with a non-zero coefficient.
*/

//specify behavior before implementation
//separate what from how

//having javadoc comments with the code increases the chances that it
//will be changed if the code is changed (and that affects the comments)
public interface PolyInterface extends Function
{
	//method signature with well-named values provides a lot of relevant information, but not all
	//Preconditions: what parameters are and the allowed values
	//Postconditions: returned values, changes to parameters, major actions
	//Throws: exceptions thrown and the conditions under which they are thrown
	
	//essential (directly use instance variables)
	/**
	Preconditions: None. <br>
	Postconditions: Returns the degree of the polynomial. <br>
	If the polynomial only has zeroes for coefficients, 0 will be returned. <br>
	Throws: None.
	*/
   public int getDegree();
   
   /**
	Preconditions: power represents the power of x for which the coefficient is requested
							power must be a nonnegative integer
	Postconditions: Returns the coefficient of the requested power of x
	Throws: PolyException if the power of x is negative or exceeds some maximum power
	*/
   public double getCoefficient(int power)  throws PolyException;  //PE if power > MAXPOWER
   
   /**
	Preconditions: power represents the power of x for which the coefficient is to be changed
							power must be a nonnegative integer
							coeff is the new value for that coefficient<br>
	Postconditions: the coefficient of the specified power of x is changed to coeff <br>
	Throws: PolyException if the power of x is negative or exceeds some maximum power <br>
	*/
   public void changeCoefficient(double coeff, int power)  throws PolyException;  //PE if power > MAXPOWER
   
   //convenience (don't directly access instance variables)
   public PolyInterface multiply(PolyInterface other);  //method can be completed using other methods in the interface
}
//compare with public static PolyInterface multiply(PolyInterface one, PolyInterface two)




