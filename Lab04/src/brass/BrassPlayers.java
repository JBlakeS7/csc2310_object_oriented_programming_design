package brass;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Image;

import gui.DrawImage;
import gui.DrawFont;
import gui.PixelPoint;
import gui.PixelDimension;
import gui.HotSpot;

import util.QueueLinked;
import util.PermutationFactory;
import util.Permutation;

class BrassPlayers
{
	private ArrayList<BrassPlayer> brass_players;
	//DO THIS
	//need a QueueLinked instance variable
	private QueueLinked<BrassPlayer> order;
	private int active_player_id;
	private int view_player_id;
	
	private List<HotSpot> display_player_hot_spots;
	private List<PixelPoint> turn_order_locations;
	
	public int getActivePlayerID()
	{
		return active_player_id;
	}
	
	public int getSelectedPlayer(int x, int y)
	{
		Iterator<HotSpot> display_player_iter = display_player_hot_spots.iterator();
		int count = 1;
		int selected_player = 0;
		while(display_player_iter.hasNext())
		{
			HotSpot display_player_spot = display_player_iter.next();
			if (display_player_spot.isSelected(x, y))
			{
				selected_player = count;
			}
			count++;
		}
		
		return selected_player;
	}
	
	public void displayPlayer(int selected_player_id)
	{
		view_player_id = selected_player_id;
	}
	
	public BrassPlayers(BrassDeck brass_deck, BrassXML brass_xml)
	{
		brass_players = new ArrayList<BrassPlayer>();
		
		List<PixelPoint> amount_spent_centers = brass_xml.getPixelCenters("amount_spent");
		BrassPlayer red = new BrassPlayer(1, brass_xml, "red", amount_spent_centers.get(0));
		brass_players.add(red);
		BrassPlayer purple = new BrassPlayer(2, brass_xml, "purple", amount_spent_centers.get(1));
		brass_players.add(purple);
		BrassPlayer green = new BrassPlayer(3, brass_xml, "green", amount_spent_centers.get(2));
		brass_players.add(green);
		BrassPlayer yellow = new BrassPlayer(4, brass_xml, "yellow", amount_spent_centers.get(3));
		brass_players.add(yellow);
		
		PixelDimension display_player_dimension = brass_xml.getPixelDimension("amount_spent");
		display_player_hot_spots = new ArrayList<HotSpot>();
		for (int i = 1; i <= 4; i++)
		{
			PixelPoint player_center = amount_spent_centers.get(i-1);
			HotSpot display_player_hot_spot = new HotSpot(i, player_center.getX() + 25, player_center.getY() - 15, display_player_dimension.getWidth(), display_player_dimension.getHeight());
			display_player_hot_spots.add(display_player_hot_spot);
		}
		
		turn_order_locations = brass_xml.getPixelCenters("turn_order");
		
		//DO THIS
		//put the players on a QueueLinked instance variable in turn order and deal the cards out in turn order
		//this will require cycling through the queue eight times
		
		//use the following line of code to display the player tokens indicating turn order
		//brass_player.setTurnOrderImageLoc(turn_order_locations.get(count-1).getX(),turn_order_locations.get(count-1).getY());
		//it needs to be placed in your loop to fill the turn order queue
		//the first turn order image location corresponds to the player first on your turn order queue
		//the player id is different from the turn order location, so a separate counter is required
		util.Permutation file = util.PermutationFactory.getPermutation("resources/brass_turn_order.txt", 4, 4);
		order = new QueueLinked<BrassPlayer>();
		int count = 1;
		while(file.hasNext())
		{
			int i = file.next();
			BrassPlayer brass_player = brass_players.get(i - 1);
			order.enqueue(brass_player);
			brass_player.setTurnOrderImageLoc(turn_order_locations.get(count-1).getX(),turn_order_locations.get(count-1).getY());
			count++;
		}

		for (int i = 1; i <= 8; i++)
		{
/*			red.addCardToHand(brass_deck.deal());
			purple.addCardToHand(brass_deck.deal());
			green.addCardToHand(brass_deck.deal());
			yellow.addCardToHand(brass_deck.deal()); */
			for (int j = 1; j <=4; j++)
			{
				BrassPlayer current = order.dequeue();
				current.addCardToHand(brass_deck.deal());
				order.enqueue(current);
			}
		}
		
		for (int i = 1; i <= 4; i++)
		{
			BrassPlayer brass_player = brass_players.get(i-1);
			brass_player.showHand();
		}
		
		//DO THIS
		//set the active player id to the player id at the front of the queue (and set the view player)
		BrassPlayer start_player = order.dequeue();
		active_player_id = start_player.getPlayerID();
		order.enqueue(start_player);
		
		view_player_id = active_player_id;
	}

	public int getSelectedCard(int player_id, int x, int y)
	{
		BrassPlayer brass_player = brass_players.get(player_id - 1);
		return brass_player.getSelectedCard(x, y);
	}
	
	public void advanceTurn(int clicked_card)
	{
		//DO THIS
		BrassPlayer current_player = brass_players.get(active_player_id - 1);
		BrassPlayer next_player = order.dequeue();

		current_player.validCardSelected(clicked_card);  
		active_player_id = next_player.getPlayerID();
		view_player_id = active_player_id;
		order.enqueue(next_player);

	}
	
	public void draw(Graphics g)
   {	
		int num_players = brass_players.size();
		for (int i = 1; i <= num_players; i++)
		{
			BrassPlayer brass_player = brass_players.get(i-1);
			brass_player.draw(g, active_player_id, view_player_id);
		}
   }
   
   public void payForDemandTrack(int demand_track_cost, int player_id)
	{
		BrassPlayer brass_player = brass_players.get(player_id - 1);
		brass_player.payForDemandTrack(demand_track_cost);
	}
	
	public boolean canPlayerBuyFromDemandTrack(int demand_track_cost, int player_id)
	{
		BrassPlayer brass_player = brass_players.get(player_id - 1);
		return brass_player.canPlayerBuyFromDemandTrack(demand_track_cost);
	}
}
