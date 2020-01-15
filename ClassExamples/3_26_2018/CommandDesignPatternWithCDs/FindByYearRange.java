public class FindByYearRange extends FindByField
{
   private int start;
   private int end;

   public FindByYearRange(int start, int end)
   {
      if (end < start)
      {
         end = start;
      }
      this.start = start;
      this.end = end;
   }

   public void execute(CD cd)
   {
       if (cd.getYear() >= start && cd.getYear() <= end)
       {
          cds.add(cd);
       }
   }
}