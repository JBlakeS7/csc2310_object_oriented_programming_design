package lsdn;

import java.util.Iterator;

class ListReferenceIterator<ListType> implements Iterator<ListType>
{
   /** The next reference to iterate over in the list. */
   private Node<ListType> ref;

   public ListReferenceIterator(Node<ListType> head)
   {
      ref = head;  //obtain the head reference
   }

   public void remove()
   {   
      throw new UnsupportedOperationException ("Remove not implemented.");
   }

   public boolean hasNext()
   {
      return ref != null;
   }

   public ListType next()
   {
      if (hasNext())  //should be used in conjunction with hasNext(), but just in case...
      {
         ListType temp = ref.getItem();
         ref = ref.getNext();
         return temp; 
      }
      else
      {
         throw new ListException("End of list.");
      }

   }

}