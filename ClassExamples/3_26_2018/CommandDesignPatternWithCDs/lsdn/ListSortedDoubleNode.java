package lsdn;

import java.util.Iterator;

//a doubly linked list of items stored in ascending order (a class invariant) 
//duplicate search keys are not allowed in this implementation
//ascending order from the head node (previous link is null)
//to the tail node (next link is null)

/**
 * An implementation of ListSortedInterface that uses an interior reference 
 * and doubly-linked nodes to capitalize on temporal and spatial locality of reference.
 */
public class ListSortedDoubleNode<T extends KeyedItem<S>, S extends Comparable<S>> implements ListSortedInterface<T, S>, Execute<T>, Iterable<T> 
{
   //interior reference to the doubly linked list of items
   //if the list is empty, the interior node should be null
   //otherwise, the interior node should point to an element in the list
   //preferably, an element at or near the last user requested operation
   //to take advantage of the principles of temporal and spatial locality of reference
   private DoubleNode<T> loc; 

   //represents the number of nodes in the list between public method calls, a class invariant 
   //as this is a doubly linked list, the size should be checked from head to tail and from tail to head
   //either next or previous links, or both, could be in error
   private int size;   

   public void execute(Command<T> command)
   {
//      Iterator<T> iter = iterator();
//      while (iter.hasNext())
//      {
//         command.execute(iter.next());
//      }

        for (T item: this) {
            command.execute(item);
        }
   } 

   public ListSortedDoubleNode() 
   {
      size = 0;
      loc = null;
   } 

   public boolean isEmpty() 
   {
      return size == 0;
   } 

   public int size() 
   {
      return size;
   }  

   //finds and returns the keyed item with the specified search key
   //work is abstracted using supporting methods
   //since an exact search key match is required, the remove supporting methods are appropriate
   //note that the removal behavior must be "adapted" to the get method signature
   //as the node must be located, get is O(n)
   //class invariants should be checked in case get inadvertantly makes changes to the list

   //the public methods will obtain external documentation from the interface
   public T get(S sk)
   {
      if (sk == null) throw new ListException("Search key is null.");

      DoubleNode<T> curr = null;
      try
      {
         curr = locateNodeRemove(sk);
      }
      catch (ListException le)
      {
         return null;
      }

      T item = curr.getItem();
      checkInvariants(sk);
      return item;
   }

   //locates the requested location in the list, starting from the interior entry point
   //this may require next references or prev references (a linear search)
   //the order notation is O(n), and since add, remove, and get rely on this method, all of the major public methods are O(n)
   //however, if the problem using the list exhibits locality of reference, there will be a significant performance gain

   //since the private methods have internal documentation and are not accessible outside the class, okay to omit external docs
   private DoubleNode<T> findLocation(S sk)
   {
      DoubleNode<T> curr = loc;
      int comp = sk.compareTo(curr.getItem().getKey());

      //use next links to find the interior location
      if (comp > 0)  
      {
         while (curr.getNext() != null && comp > 0)
         {
            curr = curr.getNext();
            comp = sk.compareTo(curr.getItem().getKey());
         }
      }
      //use prev links to find the interior location
      else if (comp < 0) 
      {
         while (curr.getPrev() != null && comp < 0)
         {
            curr = curr.getPrev();
            comp = sk.compareTo(curr.getItem().getKey());
         }
      }

      return curr;
   }

   //checks for the special cases particular to remove
   //1. removal from an empty list automatically fails
   //2. if a search key match is not found, the removal fails
   private DoubleNode<T> locateNodeRemove(S sk) throws ListException
   {
      //size = 0 special case
      if (size == 0)
      {
         throw new ListException("Item not found.");  //trying to remove from an empty list
      }

      DoubleNode<T> curr = findLocation(sk);
      int comp = sk.compareTo(curr.getItem().getKey());

      if (comp != 0)  //removing and didn't find a match
      { 
         throw new ListException("Item not found."); 
      }
 
      //return a direct reference to the node to be removed
      return curr; 
   }

   //checks for the special cases particular to add
   //1. insertion into an empty list is automatically valid
   //2. duplicate search keys are not allowed
   //3. after finding the vicinity of the insertion, adjust to point to the node before the insertion
   //   the above is necessary if next refs were used to find the insertion location
   //   as the entry point into the list can be anywhere
   //4. does not distinguish between insertions before the head (new head) or after, so add must check for this
   private DoubleNode<T> locateNodeAdd(S sk) throws ListException
   {
      //size = 0 special case
      if (size == 0)
      {
         return null;  //insert into an empty list
      }

      DoubleNode<T> curr = findLocation(sk);
      int comp = sk.compareTo(curr.getItem().getKey()); 

      if (comp == 0)  //adding and found the search key already in the list
      {
         throw new ListException("Duplicate found."); 
      }

      //need to move to the node before the insertion location (if the insert is not before the head)
      //that is, if next refs were used, back up one
      if (curr.getPrev() != null && comp < 0)
      {
         curr = curr.getPrev();  
      }

      return curr; 
   }

   //the public add method creates a new node, places the item in the node, and places the node in the correct ascending order position
   //the class invariants must be checked here
   //work is abstracted using supporting methods
   //the order notation is O(n)
   public void add(T item) throws ListException 
   {
      if (item == null) throw new ListException("Item is null.");

      addDN(item);
      checkInvariants(item.getKey());
   }

   //a non-public convenience method that returns a reference to the node containing the item added to the list
   //links are set to insert the new node into the list
   //special cases must be checked, in particular, adding to the top of the list
   //there is quite a bit of trust here as this method returns a direct reference to a node in the list  
   //this method is responsible for the actual link changes during an add

   /**
    *  After creating a new node and inserting item into it, returns a reference to that node. <br>
    *  Preconditions: see the public add method <br>
    *  Postconditions: if the insert is successful, a reference to the node containing item is returned <br>
    *                  this default visibility method trusts that the node returned will not be tampered with <br>
    *                  item is not otherwise affected <br>
    *  Throws: see the public add method <br>
    */
   DoubleNode<T> addDN(T item) throws ListException 
   {
      if (item == null) throw new ListException("Item is null.");

      S sk = item.getKey();

      //find the location right before where the new node should be inserted
      DoubleNode<T> prev = locateNodeAdd(sk);
      DoubleNode<T> node = new DoubleNode<T>(item);

      //inserting into an empty list (loc is null)
      if (prev == null) 
      {
         node.setNext(loc);
      } 

      //inserting at the top of a non-empty list
      //this is a special check as insertions at the head and right after the head are not distinguished by locateAdd
      else if (prev.getPrev() == null && sk.compareTo(prev.getItem().getKey()) < 0)  
      {
         prev.setPrev(node);
         node.setNext(prev);
      }

      //general case (the node right before the insertion location returned by locateNode for add)
      else 
      {
         DoubleNode<T> curr = prev.getNext();  //could be null (can't set a prev link)
         node.setNext(curr);
         node.setPrev(prev);

         prev.setNext(node);
         if (curr != null)  //check for end of list
         {
            curr.setPrev(node);
         }
      } 

      //reposition loc for locality of reference
      loc = node;
      size++;
      return node;
   } 

   //the public removal method that removes the node containing the specified search key
   //the class invariants must be checked here
   //work is abstracted using supporting methods
   //the order notation is O(n)
   public void remove(S sk) throws ListException 
   {
      if (sk == null) throw new ListException("Search key is null.");

      //identify the node to be removed
      DoubleNode<T> prev = locateNodeRemove(sk);
      remove(prev);
      checkInvariants(sk);
   }  

   //a non-public convenience method that allows the direct removal of a node in the list
   //links are simply set to bypass the node passed to the method
   //there is quite a bit of trust here in that the node must be a node in the list  
   //this allows O(1) node removals from the list
   //this method is responsible for the actual link changes during a removal

   /**
    *  Removes the specified node from the list. <br>
    *  Preconditions: curr is not null and is a node in the list <br>
    *  Postconditions: curr is removed from the list, but otherwise unaltered <br>
    *                  remaining nodes in the list maintain ascending search key order <br>
    *  Throws: none (there will be unspecified behavior if the preconditions are not met) <br>
    */
   T remove(DoubleNode<T> curr)
   {
      T temp;
      DoubleNode<T> prev;
      DoubleNode<T> after;

      prev = curr.getPrev();
      after = curr.getNext();
      temp = curr.getItem();
      loc = after;  

      if (prev != null)
      {
         prev.setNext(after);
         loc = prev;  //move loc here if not removing the last item (locality of reference)
      }

      if (after != null)
      {
         after.setPrev(prev);
      }

      size--;
      return temp;
   }  

   //removes all of the nodes from the list
   //to avoid memory leaks, first all of the previous links are set to null
   //and then the interior reference (loc) is set to null and size to 0
   //this operation is, thus, O(n)
   public void removeAll() 
   {
      if (loc != null)
      {
         loc = findHead();
         loc = loc.getNext();

         // need to remove all previous links to prevent memory leak
         while (loc != null)
         {
            loc.setPrev(null);
            loc = loc.getNext();
         }

         loc = null;
         size = 0;
      }
   } 

   //locate the last node in the list (the head)
   //look for a node with a previous (prev) reference of null
   private DoubleNode<T> findHead()
   {
      DoubleNode<T> find = loc;  //entry point into the list

      if (find == null)
      {
         return find;
      }

      while (find.getPrev() != null)
      {
         find = find.getPrev();
      }

      return find;
   }

   //locate the last node in the list (the tail)
   //look for a node with a next reference of null
   private DoubleNode<T> findTail()
   {
      DoubleNode<T> find = loc;  //entry point into the list

      if (find == null)
      {
         return find;
      }

      while (find.getNext() != null)
      {
         find = find.getNext();
      }

      return find;
   }

   //removes the smallest item in the list
   //for this list implementation, this operation is O(n)
   //because the entry point in the list can be at any node in the list
   public T remove() throws ListException
   {
      if (!isEmpty())
      {
         DoubleNode<T> min = findHead();        //Node max = findTail() for max pq
         remove(min);   //remove the minimum node, reposition loc                  
         return min.getItem();  
      }
      else
      {
         throw new ListException("Empty list.");
      }
   }
    
   //iterates over all of the elements in the list in ascending order (from head to tail)

   /**
    *  Returns an Iterator for the list. <br>
    *  Preconditions: none <br>
    *  Postconditions: an iterator for the list is returned <br>
    *                  the iterator begins at the head and proceeds to the tail <br>
    *                  the iterator is forward, read only and assumes (but won't detect) that the list is not altered during iteration <br>
    *  Throws: none <br>
    */
   public Iterator<T> iterator()
   {
      //locate the head/first node for the iterator without moving the interior node (loc)
      return new ListReferenceIterator<T>(findHead());  
   } 

   //allows the user to easily identify the item that triggered the violation of a class invariant by search key
   private void checkInvariants(S sk)
   {
      assert checkSorted() : "not sorted after insertion of key: " + sk;
      assert checkSizeForward() : "forward size is not correct after insertion of key: " + sk;
      assert checkSizeBackward() : "backward size is not correct after insertion of key: " + sk;
   }

   //verifies ascending order from head to tail, no duplicate search keys
   private boolean checkSorted()
   {
      System.out.println("checking invariants");
      DoubleNode<T> curr = findHead();
      DoubleNode<T> prev = null;
      if (curr == null) return true;

      while (curr.getNext() != null)
      {
         prev = curr;
         S prev_key = prev.getItem().getKey();
         curr = curr.getNext();
         S curr_key = curr.getItem().getKey();
         if (prev_key.compareTo(curr_key) >= 0)
         {
            return false;
         }
      }
                    
      return true;
   }

   private boolean checkSizeForward()
   {
      int counter = 0;
      DoubleNode<T> curr = findHead();
      
      while (curr != null)
      {
         counter++;
         curr = curr.getNext();
      }

      return counter == size;
   }      

   private boolean checkSizeBackward()
   {
      int counter = 0;
      DoubleNode<T> curr = findTail();

      while (curr != null)
      {
         counter++;
         curr = curr.getPrev();
      }

      return counter == size;
   }
} 