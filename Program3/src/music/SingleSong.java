package music;

import javax.swing.JList;
import java.awt.dnd.*;
import java.awt.datatransfer.*;

public class SingleSong extends JList implements MP3Listener, DropTargetListener
{
    private static String empty = new String("Drag a song here");
    private Thread song_thread;
    private MP3 mp3;

    public SingleSong()
    {
        super();
        setObject(empty);
        song_thread = new NullThread();
        song_thread.start();
    }

    public SingleSong(Object obj)
    {
        super();
        setObject(obj);
    }

    public void setObject(Object obj)
    {
        Object[] item = {obj};
        setListData(item);
    }

    public void clear()
    {
        setObject(empty);
    }

    public void mp3Done()
    {
        clear();
    }

    public void drop(DropTargetDropEvent dtde)
    {
        Transferable transfer = dtde.getTransferable();
        DataFlavor[] flavors = transfer.getTransferDataFlavors();
        Song dropSong;
        try
        {
            dropSong = (Song) transfer.getTransferData(flavors[0]);
        }
        catch(UnsupportedFlavorException ufe)
        {
            dtde.rejectDrop();
            return;
        }
        catch (java.io.IOException ioe)
        {
            dtde.rejectDrop();
            return;
        }

        dtde.acceptDrop(DnDConstants.ACTION_COPY);
        dtde.dropComplete(true);

        setObject(dropSong);

        if(song_thread.getState() != Thread.State.TERMINATED)
        {
            mp3.stopMP3();
        }

        mp3 = new MP3(dropSong, this);
        song_thread = new Thread(mp3);
        song_thread.start();
    }

    public void dragEnter(DropTargetDragEvent dtde){}

    public void dragOver(DropTargetDragEvent dropTargetDragEvent) {}

    public void dropActionChanged(DropTargetDragEvent dropTargetDragEvent) {}

    public void dragExit(DropTargetEvent dropTargetEvent) {}
}
