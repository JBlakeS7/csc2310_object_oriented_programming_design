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

class BrassCanals extends BrassConnections
{	
	//private ArrayList<BrassConnection> brass_canals;

	public BrassCanals(BrassXML brass_xml)
	{
		gui.ImageLoader il = gui.ImageLoader.getImageLoader();
		
		brass_connections = new ArrayList<BrassConnection>();
		
		brass_connection_dimension = brass_xml.getPixelDimension("canals");
		List<PixelPoint> canal_centers = brass_xml.getPixelCenters("canals");
		List<HotSpot> canal_hot_spots = new ArrayList<HotSpot>();
		
		int count = 1;
		Iterator<PixelPoint> canal_centers_iter = canal_centers.iterator();
		while(canal_centers_iter.hasNext())
		{
			PixelPoint canal_center = canal_centers_iter.next();
			HotSpot canal_hot_spot = new HotSpot(count, canal_center.getX(), canal_center.getY(), brass_connection_dimension.getWidth(), brass_connection_dimension.getHeight());
			canal_hot_spots.add(canal_hot_spot);
			count++;
		}
		
		Image connection_bw_img = il.getImage("images/canal_small.jpg");
		
		DrawImage brass_connection_bw_img = new DrawImage(connection_bw_img, "Brass Canal 1 Not Constructed", brass_connection_dimension.getWidth(), brass_connection_dimension.getHeight());
		BrassConnection brass_connection = new BrassConnection(1, canal_hot_spots.get(0), 3, 5, brass_connection_bw_img);
		brass_connections.add(brass_connection);
		
		brass_connection_bw_img = new DrawImage(connection_bw_img, "Brass Canal 2 Not Constructed", brass_connection_dimension.getWidth(), brass_connection_dimension.getHeight());
		brass_connection = new BrassConnection(2, canal_hot_spots.get(1), 3, 19, brass_connection_bw_img);
		brass_connections.add(brass_connection);
		
		brass_connection_bw_img = new DrawImage(connection_bw_img, "Brass Canal 3 Not Constructed", brass_connection_dimension.getWidth(), brass_connection_dimension.getHeight());
		brass_connection = new BrassConnection(3, canal_hot_spots.get(2), 5, 7, brass_connection_bw_img);
		brass_connections.add(brass_connection);
		
		brass_connection_bw_img = new DrawImage(connection_bw_img, "Brass Canal 4 Not Constructed", brass_connection_dimension.getWidth(), brass_connection_dimension.getHeight());
		brass_connection = new BrassConnection(4, canal_hot_spots.get(3), 4, 6, brass_connection_bw_img);
		brass_connections.add(brass_connection);
		
		brass_connection_bw_img = new DrawImage(connection_bw_img, "Brass Canal 5 Not Constructed", brass_connection_dimension.getWidth(), brass_connection_dimension.getHeight());
		brass_connection = new BrassConnection(5, canal_hot_spots.get(4), 4, 13, brass_connection_bw_img);
		brass_connections.add(brass_connection);
		
		brass_connection_bw_img = new DrawImage(connection_bw_img, "Brass Canal 6 Not Constructed", brass_connection_dimension.getWidth(), brass_connection_dimension.getHeight());
		brass_connection = new BrassConnection(6, canal_hot_spots.get(5), 6, 13, brass_connection_bw_img);
		brass_connections.add(brass_connection);
		
		brass_connection_bw_img = new DrawImage(connection_bw_img, "Brass Canal 7 Not Constructed", brass_connection_dimension.getWidth(), brass_connection_dimension.getHeight());
		brass_connection = new BrassConnection(7, canal_hot_spots.get(6), 10, 15, brass_connection_bw_img);
		brass_connections.add(brass_connection);
		
		brass_connection_bw_img = new DrawImage(connection_bw_img, "Brass Canal 8 Not Constructed", brass_connection_dimension.getWidth(), brass_connection_dimension.getHeight());
		brass_connection = new BrassConnection(8, canal_hot_spots.get(7), 9, 15, brass_connection_bw_img);
		brass_connections.add(brass_connection);
		
		brass_connection_bw_img = new DrawImage(connection_bw_img, "Brass Canal 9 Not Constructed", brass_connection_dimension.getWidth(), brass_connection_dimension.getHeight());
		brass_connection = new BrassConnection(9, canal_hot_spots.get(8), 15, 19, brass_connection_bw_img);
		brass_connections.add(brass_connection);
		
		brass_connection_bw_img = new DrawImage(connection_bw_img, "Brass Canal 10 Not Constructed", brass_connection_dimension.getWidth(), brass_connection_dimension.getHeight());
		brass_connection = new BrassConnection(10, canal_hot_spots.get(9), 13, 14, brass_connection_bw_img);
		brass_connections.add(brass_connection);
		
		brass_connection_bw_img = new DrawImage(connection_bw_img, "Brass Canal 11 Not Constructed", brass_connection_dimension.getWidth(), brass_connection_dimension.getHeight());
		brass_connection = new BrassConnection(11, canal_hot_spots.get(10), 13, 17, brass_connection_bw_img);
		brass_connections.add(brass_connection);
		
		brass_connection_bw_img = new DrawImage(connection_bw_img, "Brass Canal 12 Not Constructed", brass_connection_dimension.getWidth(), brass_connection_dimension.getHeight());
		brass_connection = new BrassConnection(12, canal_hot_spots.get(11), 13, 18, brass_connection_bw_img);
		brass_connections.add(brass_connection);
		
		brass_connection_bw_img = new DrawImage(connection_bw_img, "Brass Canal 13 Not Constructed", brass_connection_dimension.getWidth(), brass_connection_dimension.getHeight());
		brass_connection = new BrassConnection(13, canal_hot_spots.get(12), 11, 19, brass_connection_bw_img);
		brass_connections.add(brass_connection);
		
		brass_connection_bw_img = new DrawImage(connection_bw_img, "Brass Canal 14 Not Constructed", brass_connection_dimension.getWidth(), brass_connection_dimension.getHeight());
		brass_connection = new BrassConnection(14, canal_hot_spots.get(13), 8, 11, brass_connection_bw_img);
		brass_connections.add(brass_connection);
		
		brass_connection_bw_img = new DrawImage(connection_bw_img, "Brass Canal 15 Not Constructed", brass_connection_dimension.getWidth(), brass_connection_dimension.getHeight());
		brass_connection = new BrassConnection(15, canal_hot_spots.get(14), 8, 18, brass_connection_bw_img);
		brass_connections.add(brass_connection);
		
		brass_connection_bw_img = new DrawImage(connection_bw_img, "Brass Canal 16 Not Constructed", brass_connection_dimension.getWidth(), brass_connection_dimension.getHeight());
		brass_connection = new BrassConnection(16, canal_hot_spots.get(15), 14, 16, brass_connection_bw_img);
		brass_connections.add(brass_connection);
		
		brass_connection_bw_img = new DrawImage(connection_bw_img, "Brass Canal 17 Not Constructed", brass_connection_dimension.getWidth(), brass_connection_dimension.getHeight());
		brass_connection = new BrassConnection(17, canal_hot_spots.get(16), 18, 19, brass_connection_bw_img);
		brass_connections.add(brass_connection);
		
		brass_connection_bw_img = new DrawImage(connection_bw_img, "Brass Canal 18 Not Constructed", brass_connection_dimension.getWidth(), brass_connection_dimension.getHeight());
		brass_connection = new BrassConnection(18, canal_hot_spots.get(17), 12, 17, brass_connection_bw_img);
		brass_connections.add(brass_connection);
		
		brass_connection_bw_img = new DrawImage(connection_bw_img, "Brass Canal 19 Not Constructed", brass_connection_dimension.getWidth(), brass_connection_dimension.getHeight());
		brass_connection = new BrassConnection(19, canal_hot_spots.get(18), 7, 20, brass_connection_bw_img);
		brass_connections.add(brass_connection);
		
		brass_connection_bw_img = new DrawImage(connection_bw_img, "Brass Canal 20 Not Constructed", brass_connection_dimension.getWidth(), brass_connection_dimension.getHeight());
		brass_connection = new BrassConnection(20, canal_hot_spots.get(19), 16, 20, brass_connection_bw_img);
		brass_connections.add(brass_connection);
		
		brass_connection_bw_img = new DrawImage(connection_bw_img, "Brass Canal 21 Not Constructed", brass_connection_dimension.getWidth(), brass_connection_dimension.getHeight());
		brass_connection = new BrassConnection(21, canal_hot_spots.get(20), 8, 21, brass_connection_bw_img);
		brass_connections.add(brass_connection);
		
		brass_connection_bw_img = new DrawImage(connection_bw_img, "Brass Canal 22 Not Constructed", brass_connection_dimension.getWidth(), brass_connection_dimension.getHeight());
		brass_connection = new BrassConnection(22, canal_hot_spots.get(21), 21, 22, brass_connection_bw_img);
		brass_connections.add(brass_connection);
		
		brass_connection_bw_img = new DrawImage(connection_bw_img, "Brass Canal 23 Not Constructed", brass_connection_dimension.getWidth(), brass_connection_dimension.getHeight());
		brass_connection = new BrassConnection(23, canal_hot_spots.get(22), 12, 22, brass_connection_bw_img);
		brass_connections.add(brass_connection);
		
		brass_connection_images = new ArrayList<Image>();
		
		Image connection_img = il.getImage("images/red/red_canal_small.jpg");
		brass_connection_images.add(connection_img);
		
		connection_img = il.getImage("images/purple/purple_canal_small.jpg");
		brass_connection_images.add(connection_img);
		
		connection_img = il.getImage("images/green/green_canal_small.jpg");
		brass_connection_images.add(connection_img);
		
		connection_img = il.getImage("images/yellow/yellow_canal_small.jpg");
		brass_connection_images.add(connection_img);
	}

	/*
	
	private List<Image> brass_connection_images;
	private PixelDimension brass_connection_dimension;
	
	public int getSelectedLink(int x, int y)
	{
		//DO THIS
		Iterator<BrassConnection> iter = brass_canals.iterator();
		int count = 1;
		while(iter.hasNext())
		{
			BrassCard brass_canals = iter.next();
			if (brass_canals.isSelected(x, y))
			{
				return count;
			}
			count++;
		}
		return 0;
	}
	
	public void draw(Graphics g)
	{
		//DO THIS
		Iterator<BrassConnection> iter = brass_canals.iterator();
		while(iter.hasNext())
		{
			BrassConnection brass_canal = iter.next();
			brass_canal.draw(g);
		}
	}
	
	public int getNumLinks()
	{
		return brass_canals.size();
	}
	
	public void constructLink(int link_id, int player_id)
	{
		if (isConstructed(link_id)) return;

		BrassConnection brass_connection = brass_canals.get(link_id - 1);
		DrawImage brass_connection_img = new DrawImage(brass_connection_images.get(player_id - 1), "Brass Canal " + link_id, brass_connection_dimension.getWidth(), brass_connection_dimension.getHeight());
		brass_connection.constructLink(player_id, brass_connection_img);
	}
	
	public boolean isConstructed(int link_id)
	{
		BrassConnection brass_connection = brass_canals.get(link_id - 1);
		return brass_connection.isConstructed();
	}
	
	public int[] getConnectedCities(int link_id)
	{
		BrassConnection brass_connection = brass_canals.get(link_id - 1);
		return brass_connection.getConnectedCities();
	}
	*/
}
