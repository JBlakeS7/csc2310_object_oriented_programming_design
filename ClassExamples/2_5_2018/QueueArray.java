	//Class cls = unsorted_items.getClass().getComponentType();
	//E[] sorted_items = (E[]) java.lang.reflect.Array.newInstance(cls, num_items);
	
	//what about QueueList?
public class QueueArray
{
	private int max_queue;
	private Object[] items;
	
	private int front;
	private int back;
	private int size;
	
	public QueueArray()
	{
		max_queue = 2;
		items = new Object[max_queue];   //generic array
		
		front = 0;
		back = max_queue - 1;
		size = 0;
	}
	
	public boolean isEmpty() 
	{
		return (size == 0);
	}  
	
	public int size()
	{
		return size;
	}
	
	public Object peek()
	{
		Object item = null;
		if (!isEmpty()) 
		{  
			item = items[front];
		}
		return item; 
	} 
	
	public void enqueue(Object item)
	{
		if (size == max_queue)
		{
			arrayResize(2*max_queue);
		}

		//back = (back + 1) % (max_queue);
		back = back + 1;
		if (back == max_queue) back = 0;
		items[back] = item;
		size++;
	} 

	public Object dequeue() 
	{
		Object item = null;

		if (!isEmpty()) 
		{
			item = items[front];
			items[front] = null;
			
			//front = (front + 1) % (max_queue);
			front = front + 1;
			if (front == max_queue) front = 0;
			size--;
		}

		return item; 
	}

	private void arrayResize(int new_size)
	{
		Object[] temp = new Object[new_size];
		int j = front;

		for (int i = 0; i < size; i++)
		{
			temp[i] = items[j];
			j++;
			if (j == max_queue) j = 0;
		}

		front = 0;
		back = size - 1;
		max_queue = new_size;

		items = temp;
	}
	
	public void dequeueAll() 
	{
		max_queue = 2;
		items = new Object[max_queue];  
		front = 0;
		back = max_queue - 1;
		size = 0;
	} 
}
