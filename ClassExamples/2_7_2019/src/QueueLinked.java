//1.  when you see a class name, append <T> or <E> to it
//2.  when you see Object, replace it with T or E
//3.  not the constructor definition class name


//types of errors:
//1. syntax
//2. runtime
//3. logic

public class QueueLinked<T>
{

  // circular references
  protected Node<T> tail;
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

  public T peek()
  {
    if (!isEmpty()) 
    {  
      // queue is not empty; retrieve front
      Node<T> head = tail.getNext();
      return head.getItem();
    }
    else 
    {
      return null;
    }  
  }  
 
  public void enqueue(T item)
  {
    Node<T> node = new Node<T>(item);

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

  public T dequeue() 
  {
    if (!isEmpty()) 
    {
      // queue is not empty; remove front
      Node<T> head = tail.getNext();  //HERE
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
