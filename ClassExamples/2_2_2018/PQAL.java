package csc2310;

import java.util.ArrayList;

import util.KeyedItem;

public class PQAL
{
	private ArrayList<KeyedItem> items;
	
	public PQAL()
	{
		items = new ArrayList<KeyedItem>();
	}

	public boolean pqIsEmpty()
	{
		return (items.size() == 0);
	}
	
   public void pqInsert(KeyedItem item)
   {
	   items.add(item);
   }
   
   public KeyedItem pqRemove() 
   {
	   int num_items = items.size();
	   if (num_items == 0) return null;
	   
	   int smallest_index = 0;
	   KeyedItem smallest_item = items.get(0);
	   String smallest_key = smallest_item.getKey();
	   
	   for (int i = 1;  i < num_items; i++)
	   {
		   KeyedItem test_item = items.get(i);
		   String test_key = test_item.getKey();
		   
		   //in order to generics enable PQAL
		   //will need to ensure that T has a compareTo method
		   //objects stored in PQAL need to be compared to one another
		   //we haven't covered this yet
		   if (test_key.compareTo(smallest_key) < 0)
		   {
			   smallest_index = i;
			   smallest_key = test_key;
		   }
	   }
	   
	   smallest_item = items.remove(smallest_index);
	   return smallest_item;
   }
}
