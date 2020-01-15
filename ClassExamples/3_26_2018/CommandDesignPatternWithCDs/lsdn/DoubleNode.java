package lsdn;

public class DoubleNode<T> extends Node<T>
{
   private DoubleNode<T> prev;

   public DoubleNode(T item) 
   {
      super(item);
      prev = null;
   } 

   public void setPrev(DoubleNode<T> prev)
   {
      this.prev = prev;
   }

   public DoubleNode<T> getPrev()
   {
      return prev;
   }

   public DoubleNode<T> getNext()
   {
      return (DoubleNode<T>) super.getNext();
   }

   //inherited public void setNext(Node<T> next)
} 

