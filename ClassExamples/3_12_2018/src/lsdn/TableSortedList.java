package lsdn;

import java.util.Iterator;

public class TableSortedList<T extends KeyedItem<S>, S extends Comparable<S>> implements TableInterface<T, S>
{
   private ListSortedInterface<T, S> list;
   private int size;               

   public TableSortedList() 
   {
      list = new ListSortedDoubleNode<T, S>();
   }  

   public boolean tableIsEmpty() 
   {
      return size == 0;
   }

   public int tableSize() 
   {
      return list.size();
   }  

   public T tableRetrieve(S searchKey) 
   {
      T temp = list.get(searchKey);
      return temp;
   }  

   public void tableInsert(T item) throws TableException 
   {
      try
      {
         list.add(item);
         size++;
      }
      catch (ListException e)
      {
         throw new TableException("Duplicate found.");
      }
   }  

   public boolean tableDelete(S searchKey) 
   {
      try
      {
         list.remove(searchKey);
         size--;
         return true;
      }
      catch (ListException e)
      {
         return false;
      }
   }  

   public Iterator<T> iterator()
   {
      return list.iterator();
   }
} 