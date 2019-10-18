import java.util.Arrays;
import util.Keyboard;
import util.RandomPermutation;
import util.ReadTextFile;
import util.WriteTextFile;

public class CreateFilePermutation
{
	public static void main(String[] args)
	{
		//DO THIS
		//use the Keyboard class to obtain the upper integer value
		int valuesSize = 66;
		Keyboard kb = Keyboard.getKeyboard();

		int n = kb.readInt("Enter the upper limit "+"");
		String fileName = kb.readString(""+"Enter file name ");
		
		
		//DO THIS
		//obtain the random permutation using the upper integer value
		//write out the values to a text file (close the file)
		RandomPermutation rp = new RandomPermutation(66,66);
		WriteTextFile tf = new WriteTextFile("brass_deck_shuffle.txt");

		while(rp.hasNext())
		{
			tf.writeLine(rp.next() + "");
		}
		
		tf.close();

		
		
		//DO THIS
		//read the values in from the text file and store them in an integer array
		//it is easiest to read the first line outside of a while loop that tests for EOF
		

		int values[] = new int[66];;
		int count = 0;
		ReadTextFile rf = new ReadTextFile("brass_deck_shuffle.txt");
		String line = rf.readLine();
		while(!rf.EOF())
		{
			values[count] = Integer.parseInt(line);
			count++;
			line = rf.readLine();
		}
		rf.close();
		
		//DO THIS
		//sort the integers (use java.util.Arrays.sort)
		//print them out to make sure they are all there once
		Arrays.sort(values);

		for (int i = 0; i < values.length; i++)
		{
			System.out.println(values[i]);
		}
		
		
	}
}
