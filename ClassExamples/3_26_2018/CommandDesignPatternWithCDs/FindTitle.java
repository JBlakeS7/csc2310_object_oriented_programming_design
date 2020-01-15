//import lsdn.Command;
import java.util.ArrayList;

public class FindTitle extends FindByField /* implements Command<CD> */{
    
    private String title;
    
    public FindTitle(String title) {
        super(); // not strictly needed, but done by default -- if you don't have a no-arg constructor, must do super(...) with parameters to be passed up to parent
        this.title = title;
    }
    
    public void execute(CD cd) {
        if (title.equalsIgnoreCase(cd.getKey())) {
            cds.add(cd);
        }
    }
}