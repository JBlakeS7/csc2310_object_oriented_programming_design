import csc2310.RationalNumber;
public class QueueDriver
{
	public static void main(String[] args)
	{
		QueueLinked<RationalNumber> ql = new QueueLinked<RationalNumber>();
		QueueArray qa = new QueueArray();

		for (int i = 1; i <= 10; i++)
		{
			RationalNumber rn = new RationalNumber(1, i);
			ql.enqueue(rn);
			qa.enqueue(rn);
		}
//		ql.enqueue(5); // autoboxing between primitives and corresponding non-primitive classes
		// q1.enqueue (new Integer(5)):
		RationalNumber total = new RationalNumber(0, 1);
		while (!ql.isEmpty())
		{
			System.out.println("Dequeueing " + ql.peek());
			total = total.add((RationalNumber) ql.dequeue());
			System.out.println(total);
		}
		while (!qa.isEmpty())
		{
			System.out.println("Dequeuing " + qa.peek());
			total = total.subtract((RationalNumber) qa.dequeue());
			System.out.println(total);
		}  
		
		
	}
}
