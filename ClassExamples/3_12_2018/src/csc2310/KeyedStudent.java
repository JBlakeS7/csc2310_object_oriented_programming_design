package csc2310;
import lsdn.KeyedItem;
public class KeyedStudent extends KeyedItem<String> implements Comparable<KeyedStudent>
{
    private String student_name;
    
    public KeyedStudent(String T_number, String student_name) throws KeyedStudentException
    {
        super(T_number);
        if (student_name == null || student_name.equals(""))
        {
            throw new KeyedStudentException("student name is null or blank");
        }
        this.student_name = student_name;
        if (isTNumberInvalid(T_number))
        {
            throw new KeyedStudentException("Invalid T number");
        }
    }
    
    public String getTNumber()
    {
        return getKey();
    }
    
    public String getStudentName()
    {
        return student_name;
    }
    
    public String toString()
    {
        return "T Number: " + getKey() + " Name: " + student_name;
    }
    
    public int compareTo(KeyedStudent other) throws KeyedStudentException
    {
        if (other == null)
        {
            throw new KeyedStudentException("null passed to compareTo");
        }
        int result = getKey().compareTo(other.getKey());
        if (result == 0)
        {
            result = student_name.compareTo(other.student_name);
        }
        return result;
    }
    
    public static boolean isTNumberInvalid(String T_number)
    {
        boolean result = true;
        if (T_number != null)
        {
            if (T_number.length() == 9 && T_number.startsWith("T"))
            {
                int i;
                for (i = 1; i <= 8; i++)
                {
                    if (!Character.isDigit(T_number.charAt(i)))
                    {
                        break;
                    }
                }
                if (i == 9)
                {
                    result = false;
                }
            }
        }
        return result;
    }
}