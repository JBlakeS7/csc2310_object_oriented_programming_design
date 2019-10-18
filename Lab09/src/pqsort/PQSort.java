package pqsort;

import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

/**
	Sorts by inserting all of the items into a priority queue with min prioity. It then removes them from
	the priority queue and places the items in a List in the correct order. The sort method is determined 
	by the Comparator passed to the constructor and the original unsorted list is not affected.
*/
public class PQSort
{
	public static <E> List<E> pqSort(List<E> unsorted_items, Comparator<E> comp, PQType pq_type)
	{
		List<E> sorted_list = new ArrayList<E>();
		PQInterface<E> pq = PQFactory.createPQ(comp, pq_type);
		
		for (E item : unsorted_items)
		{
			pq.pqInsert(item);
		}
		
		while(!pq.pqIsEmpty())
		{
			E item = pq.pqRemove();
			sorted_list.add(item);
		}
		
		return sorted_list;
	}
}
