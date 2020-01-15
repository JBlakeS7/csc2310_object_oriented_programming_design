package lsdn;

import java.util.Iterator;

/** 
 *  This interface describes the behavior that any type of sorted list should have. 
 *  Items in the list must extend KeyedItem so that they can be located by search key. 
 *  Search keys should be immutable but they must be at least Comparable to compare search keys. 
 *  T is the KeyedItem class, and T must be using S as its search key. 
 *  A given search key must be unique in the list.
 */
public interface ListSortedInterface<T extends KeyedItem<S>, S extends Comparable<S>> extends Iterable<T>
{
   /**
    *  Is the list empty or not?. <br>
    *  Preconditions: <br> none <br>
    *  Postconditions: <br> true is returned if the list contains no items, otherwise false is returned <br>
    *  Throws: none <br>
    */ 
   public boolean isEmpty();


   /**
    *  How many items are in the list?. <br>
    *  Preconditions: <br> none <br>
    *  Postconditions: <br> the number of items in the list is returned <br>
    *  Throws: none <br>
    */
   public int size();


   /**
    *  Add an item to the list in ascending order by search key. <br>
    *  Preconditions:  <br> item is the KeyedItem to be inserted into the list <br>
                       item is not null and has a search key that is not already present in the list <br>
    *  Postconditions: <br> the item is inserted into the list in ascending order by search key (if the preconditions are met) <br>
    *                  otherwise, item is unaffected <br>
    *  Throws: ListException if item is null or there is an item with search key sk already in the list <br>
    */
   public void add(T item) throws ListException;


   /**
    *  Removes the item with the provided search key from the list. <br>
    *  Preconditions:  <br> search key (sk) is not null <br>
                       a KeyedItem with the provided search key (sk) is present in the list <br>
    *  Postconditions: <br> the item with the provided search key is removed from the list <br>
    *                  the remaining items are in ascending order by search key <br>
    *                  otherwise, sk is unaffected <br>
    *  Throws: ListException if sk is null or an item with search key sk is not present in the list <br>
    */
   public void remove(S sk) throws ListException;


   /**
    *  Returns the KeyedItem with search key sk. <br>
    *  Preconditions:  <br> search key (sk) is not null <br>
    *  Postconditions: <br> the item with search key sk is returned if such an item is present <br>
    *                  null is returned if no items in the list have search key sk <br>
    *                  sk itself is unaffected <br>
    *  Throws: none <br>
    */
   public T get(S sk);


   /**
    *  Removes all of the items from the list. <br>
    *  Preconditions: <br> none <br>
    *  Postconditions: <br> the list contains no items <br>
    *  Throws: none <br>
    */
   public void removeAll(); 
} 