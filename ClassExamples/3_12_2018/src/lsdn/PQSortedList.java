package lsdn;

public class PQSortedList<T extends KeyedItem<S>, S extends Comparable<S>> implements PQInterface<T, S>
{

   private ListSortedInterface<T, S> list;

   public PQSortedList() 
   {
      list = new ListSortedDoubleNode<T, S>();
   } 

   public boolean pqIsEmpty() 
   {
      return list.isEmpty();
   }  

   public void pqInsert(T item) throws PQException 
   {
      try 
      {
         list.add(item);
      } 
      catch (ListException le) 
      { 
         throw new PQException("Priority queue full.");
      } 
   } 

   public T pqDelete() 
   {
      try
      {
         return ((ListSortedDoubleNode<T, S>) list).remove();
      }
      catch (ListException le)
      {
         throw new PQException("Empty priority queue.");
      }
   }     
}  