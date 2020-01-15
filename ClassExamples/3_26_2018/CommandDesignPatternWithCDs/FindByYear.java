//import lsdn.Command;
import java.util.ArrayList;

public class FindByYear extends FindByField {
   private int year;
   
   public FindByYear(int year) {
       this.year = year;
   }
   
   public void execute(CD cd) {
       if (cd.getYear() == year) {
           cds.add(cd);
       }
   }

}