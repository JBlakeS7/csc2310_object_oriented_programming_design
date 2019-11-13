//1.  when you see a class name, append <T> or <E> to it
//2.  when you see Object, replace it with T or E
//3.  not the constructor definition class name
//4.  generic arrays are special cases (warning that we can't get rid of)

public class Node<T>
{

  private T item;
  private Node<T> next;  //reference to another node

  public Node(T item) 
  {
    this.item = item;
    next = null;
  } 

  public Node(T item, Node<T> next) 
  {
    this.item = item;
    this.next = next;
  }

  public void setItem(T item) 
  {
    this.item = item;
  }

  public T getItem() 
  {
    return item;
  } 

  public void setNext(Node<T> next) 
  {
    this.next = next;
  } 

  public Node<T> getNext() 
  {
    return next;
  }
}
