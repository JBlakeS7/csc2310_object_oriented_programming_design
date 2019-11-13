//1.  when you see a class name, append <T> or <E> to it
//2.  when you see Object, replace it with T or E
//3.  not the constructor definition class name
//4.  generic arrays are special cases (warning that we can't get rid of)

public class Node
{

  private Object item;
  private Node next;  //reference to another node

  public Node(Object item) 
  {
    this.item = item;
    next = null;
  } 

  public Node(Object item, Node next) 
  {
    this.item = item;
    this.next = next;
  }

  public void setItem(Object item) 
  {
    this.item = item;
  }

  public Object getItem() 
  {
    return item;
  } 

  public void setNext(Node next) 
  {
    this.next = next;
  } 

  public Node getNext() 
  {
    return next;
  }
}
