package csc2310;

import util.KeyedItem;

public class PQDriver
{
	public static void main(String[] args)
	{
		PQAL pq_al = new PQAL();
		pq_al.pqInsert(new KeyedItem("S"));  //first duplicate out
		pq_al.pqInsert(new KeyedItem("Z"));
		pq_al.pqInsert(new KeyedItem("B"));
		pq_al.pqInsert(new KeyedItem("S"));  //second duplicate out
		pq_al.pqInsert(new KeyedItem("M"));
		pq_al.pqInsert(new KeyedItem("H"));
		pq_al.pqInsert(new KeyedItem("S"));
		pq_al.pqInsert(new KeyedItem("S"));
		
		while(!pq_al.pqIsEmpty())
		{
			KeyedItem ki = pq_al.pqRemove();
			System.out.println(ki.getKey());
		}
	}
}

