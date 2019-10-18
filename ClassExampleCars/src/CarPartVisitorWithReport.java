import java.util.ArrayList;
public abstract class CarPartVisitorWithReport implements CarPartVisitor
{
    protected ArrayList<String> report;
    
    public CarPartVisitorWithReport()
    {
        super();
        report = new ArrayList<String>();
    }
    
    public String getReport()
    {
        StringBuffer buffer=new StringBuffer();
        for (String s : report)
        {
            buffer.append(s);
            buffer.append("\n");
        }
        return buffer.toString();
    }
    
    public void resetReport()
    {
        report = new ArrayList<String>();
    }
}