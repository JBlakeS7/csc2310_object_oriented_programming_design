package brass;

import java.util.Comparator;

class BrassCompareAmountSpent implements Comparator<BrassPlayer>
{
	private boolean ascending;

	public BrassCompareAmountSpent(boolean ascending)
	{
		this.ascending = ascending;
	}

	public int compare(BrassPlayer player1, BrassPlayer player2)
   	{
   		int amount1 = player1.getAmountSpent();
      	int amount2 = player2.getAmountSpent();
	  	int difference = 0;
	  
	  	if (ascending)
			difference = amount1 - amount2; 
		
	  	else
		  	difference = amount2 - amount1; 

      	return difference;
   	}
}