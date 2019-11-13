//1.  when you see a class name, append <T> or <E> to it
//2.  when you see Object, replace it with T or E
//3.  not the constructor definition class name


//types of errors:
//1. syntax
//2. runtime
//3. logic

public class QueueLinked
{

  // circular references
  protected Node tail;
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

  public Object peek()
  {
    if (!isEmpty()) 
    {  
      // queue is not empty; retrieve front
      Node head = tail.getNext();
      return head.getItem();
    }
    else 
    {
      return null;
    }  
  }  
 
  public void enqueue(Object item)
  {
    Node node = new Node(item);

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

  public Object dequeue() 
  {
    if (!isEmpty()) 
    {
      // queue is not empty; remove front
      Node head = tail.getNext();  //HERE
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
