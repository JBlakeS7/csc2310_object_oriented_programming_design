package pqsort;

import java.util.Comparator;

/**
	Creates and returns a class that implements the priority queue interface.
	The priority of the items is determined by the Comparator passed to the 
	createPQ(Comparator<E> comp, PQType pq_type). The possible implementations 
	are PQType.TREE and PQType.LIST
*/
public class PQFactory
{
	public static <E> PQInterface<E> createPQ(Comparator<E> comp, PQType pq_type)
	{
		if (pq_type == PQType.TREE)
			return new PQBST<E>(comp);
		else
			return new PQSLL<E>(comp);
		
	}
}
