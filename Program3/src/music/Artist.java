package music;

import java.util.Iterator;
import table.TableInterface;
import table.TableFactory;

public class Artist
{
	private TableInterface<CD, String> CDs;
	private String artist_name;

	public Artist(String name)
	{
		artist_name = name;
		CDs = TableFactory.createTable(new CompareCDTitles(true));
	}

	public void addCD(CD cd)throws MusicException
	{
		CDs.tableInsert(cd);
	}

	public Iterator<CD> iterator()
	{
		return CDs.iterator();
	}

	public String getArtist()
	{
		return artist_name;
	}

	public String toString()
	{
		return artist_name;
	}
}