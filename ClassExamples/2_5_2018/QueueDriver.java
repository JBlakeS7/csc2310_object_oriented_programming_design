import csc2310.RationalNumber;
public class QueueDriver
{
	public static void main(String[] args)
	{
		QueueLinked ql = new QueueLinked();
		QueueArray qa = new QueueArray();

		for (int i = 1; i <= 10; i++)
		{
			RationalNumber rn = new RationalNumber(1, i);
			ql.enqueue(rn);
			qa.enqueue(rn);
		}

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
