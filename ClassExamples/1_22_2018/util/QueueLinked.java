package util;

//1.  when you see a class name, append <T> or <E> to it
//2.  when you see Object, replace it with T or E
//3.  not the constructor definition class name
public class QueueLinked<E>
{

  // circular references
  protected Node<E> tail;
  protected int size;
  
  public QueueLinked() 
  {
    tail = null;  
    size = 0; 
  }  
  
  public boolean isEmpty() 
  {
    return tail == null;
  } 

  public int size()
  {
    return size;
  }

  public void dequeueAll() 
  {
    if (tail != null)
    {
       tail.setNext(null);
    }

    tail = null;
    size = 0;
  } 

  public E peek()
  {
    if (!isEmpty()) 
    {  
      // queue is not empty; retrieve front
      Node<E> head = tail.getNext();
      return head.getItem();
    }
    else 
    {
      return null;
    }  
  }  
 
  public void enqueue(E item)
  {
    Node<E> node = new Node<E>(item);

    // insert the new node
    if (isEmpty()) 
    {
      // insertion into empty queue
      node.setNext(node);
    }
    else 
    {
      // insertion into nonempty queue
      node.setNext(tail.getNext());
      tail.setNext(node);
    }  

    tail = node;  // new node is at back
    size++;
  }  

  public E dequeue() 
  {
    if (!isEmpty()) 
    {
      // queue is not empty; remove front
      Node<E> head = tail.getNext();  //HERE
      if (head == tail) 
      {  
        // one node in queue
        tail.setNext(null);  //otherwise, won't be garbage collected
        tail = null;           
      }
      else 
      {
        tail.setNext(head.getNext());
      } 
      size--;
      return head.getItem();
    }
    else 
    {
      return null;
    }  
  } 
   
} 
