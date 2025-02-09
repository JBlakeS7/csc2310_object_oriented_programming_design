package brass;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

import java.awt.Graphics;
import java.awt.Image;

import gui.HotSpot;
import gui.DrawImage;
import gui.ImageLoader;
import gui.PixelPoint;
import gui.PixelDimension;

import util.QueueLinked;

abstract class BrassConnections
{
	protected List<BrassConnection> brass_connections;
	protected List<Image> brass_connection_images;
	protected PixelDimension connection_dimension;
	
	//DO THIS
	//use an Iterator to look at all of the links to find one
	//connected to the city and constructed by the player
	/*
	public boolean doesPlayerHaveLinkIntoCity(int city_id, int player_id)
	{
		
		
	}
	*/
	
	public void buildLink(int link_id, int player_id)
	{
		//assert that the link has not already been constructed

		
		BrassConnection brass_connection = brass_connections.get(link_id - 1);
		DrawImage brass_connection_img = new DrawImage(brass_connection_images.get(player_id - 1), "Brass Canal " + link_id, connection_dimension.getWidth(), connection_dimension.getHeight());
		brass_connection.buildLink(player_id, brass_connection_img);
	}
	
	public boolean isLinkConstructed(int link_id)
	{
		BrassConnection brass_connection = brass_connections.get(link_id - 1);
		return brass_connection.isLinkConstructed();
	}
	
	public int getNumLinks()
	{
		return brass_connections.size();
	}
	
	public void draw(Graphics g)
	{
		Iterator<BrassConnection> connections_iter = brass_connections.iterator();
		while (connections_iter.hasNext())
		{
			BrassConnection brass_connection = connections_iter.next();
			brass_connection.draw(g);
		}
	}
	
	public boolean isConstructed(int link_id)
	{
		BrassConnection brass_connection = brass_connections.get(link_id - 1);
		return brass_connection.isConstructed();
	}
	
	public int[] getConnectedCities(int link_id)
	{
		BrassConnection brass_connection = brass_connections.get(link_id - 1);
		return brass_connection.getConnectedCities();
	}
	
	public int getSelectedLink(int x, int y)
	{
		Iterator<BrassConnection> brass_connections_iter = brass_connections.iterator();
		while(brass_connections_iter.hasNext())
		{
			BrassConnection brass_connection = brass_connections_iter.next();
			if (brass_connection.isSelected(x, y) && !brass_connection.isConstructed())
			{
				return brass_connection.getConnectionID();
			}
		}
		
		return 0;
	}
}
