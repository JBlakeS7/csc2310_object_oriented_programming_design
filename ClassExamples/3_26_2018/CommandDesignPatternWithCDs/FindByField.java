import lsdn.Command;
import java.util.ArrayList;

public abstract class FindByField implements Command<CD>
{
    protected ArrayList<CD> cds;

    public FindByField()
    {
       cds = new ArrayList<CD>();
    }

    public abstract void execute(CD cd);

    public ArrayList<CD> getCDs() {
        ArrayList<CD> result = cds;
        cds = new ArrayList<CD>();
        return result;
    }
}
