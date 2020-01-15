package csc2310;
import lsdn.ListSortedDoubleNode;
import lsdn.KeyedItem;
import util.Keyboard;
import util.ReadTextFile;
import util.FileIOException;
import java.util.Iterator;

public class LSDNDriver
{
    public static void main(String[] args)
    {
        Keyboard kb = Keyboard.getKeyboard();
        String file_name = kb.readString("Please enter the name of the file to process. ");
    
        ListSortedDoubleNode<KeyedStudent, String> my_list = readKeyedStudentsFromFile(file_name);
        
        System.out.println("The sorted list follows:");
        Iterator iter = my_list.iterator();
        while (iter.hasNext())
        {
            System.out.println(iter.next());
        }
    }
  
    private static ListSortedDoubleNode<KeyedStudent, String> readKeyedStudentsFromFile(String file_name)
    {
        ListSortedDoubleNode<KeyedStudent, String> keyed_student_list = new ListSortedDoubleNode<KeyedStudent, String>();
        ReadTextFile file_reader = new ReadTextFile(file_name);
        String line = file_reader.readLine();
        while (!file_reader.EOF())
        {
            String[] tokens = line.split(",");
            if (tokens.length == 2)
            {
                String t_number = tokens[0];
                String student_name = tokens[1];
                keyed_student_list.add(new KeyedStudent(t_number, student_name));
            }
            line = file_reader.readLine();
        }
        return keyed_student_list;
    }
}