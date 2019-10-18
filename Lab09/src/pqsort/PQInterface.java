package pqsort;

/**
   The methods required for a priority queue
*/
public interface PQInterface<E>
{
	/**
	   Inserts an item into the priority queue
	   Preconditions: item is not null
	   Throws: PQException if the insertion cannot be done
	*/
	public void pqInsert(E item) throws PQException;
	
	/**
	   Removes the smallest item from the priority queue
	   Postconditions: there is at least one item in the priority queue
	   Throws: PQException if there are no items remaining
	*/
	public E pqRemove() throws PQException;
	
	/**
	   Indicates whether the priority queue is empty or not
	*/
	public boolean pqIsEmpty();
}
