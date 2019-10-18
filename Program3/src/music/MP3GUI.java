package music;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.dnd.*;
import java.util.Iterator;

import gui.*;

public class MP3GUI extends CenterFrame implements Drawable, ActionListener, MouseMotionListener
{
    private JComboBox<Artist> artists_combo;
    private JComboBox<CD> CDs_combo;
    private ManySongs songs;
    private SingleSong song;
    private Controller controller;
    private int width;
    private int height;

    boolean filter;

    public MP3GUI(int width, int height, java.util.Iterator<Artist> iter)
    {
        super(width, height, "Music Collection");
        setLayout(new BorderLayout());
        JPanel centerGrid = new JPanel();
        add(centerGrid, BorderLayout.CENTER);

        controller = new Controller();

        Dimension d = new Dimension(10, 17);
        song = new SingleSong();
        song.setPreferredSize(d);

        JPanel north_panel = new JPanel();
        north_panel.setLayout(new GridLayout(1,2));
        artists_combo = new JComboBox<Artist>();
        CDs_combo = new JComboBox<CD>();
        north_panel.add(artists_combo);
        north_panel.add(CDs_combo);
        add(north_panel, BorderLayout.NORTH);

        DrawPanel draw = new DrawPanel();
        draw.setDrawable(this);
        draw.addMouseMotionListener(this);

        songs = new ManySongs();
        songs.setFont(new Font("Courier New", Font.PLAIN, 12));
        songs.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane scrollSongs = new JScrollPane();
        scrollSongs.setPreferredSize(d);
        scrollSongs.getViewport().add(songs);

        JPanel scrollPanel = new JPanel();
        scrollPanel.setLayout(new BorderLayout());
        scrollPanel.add(scrollSongs, BorderLayout.CENTER);
        scrollPanel.add(song, BorderLayout.SOUTH);

        EasyGridBag easy = new EasyGridBag(1,4,centerGrid);
        centerGrid.setLayout(easy);

        easy.fillCellWithRowColSpan(1,2,1,4,GridBagConstraints.BOTH,draw);
        easy.fillCellWithRowColSpan(1,1,1,1,GridBagConstraints.BOTH,scrollPanel);

        controller.fillArtist(iter);

        artists_combo.setActionCommand("artist");
        artists_combo.addActionListener(this);
        artists_combo.setSelectedIndex(0);

        CDs_combo.setActionCommand("cds");
        CDs_combo.setSelectedIndex(0);

        DragSource dragSource = DragSource.getDefaultDragSource();
        DragGestureRecognizer dgr = dragSource.createDefaultDragGestureRecognizer(songs, DnDConstants.ACTION_COPY, songs);
        DropTarget dropTarget = new DropTarget(song, song);

        setVisible(true);
    }

    public void draw(Graphics g, int width, int height)
    {
        this.width = width;
        this.height = height;
        CD selectedCD = (CD) CDs_combo.getSelectedItem();
        selectedCD.draw(g, width,height);
        if(!filter)
        {
            DrawImage albumArt = new DrawImage(selectedCD.getAlbumArt(), selectedCD.getTitle(), width, height);
            albumArt.showImage(width - 100, height - 100);
            albumArt.draw(g);
        }
        else
        {
            DrawImage albumArt = new DrawImage(selectedCD.getAlbumFilter(), selectedCD.getTitle(), width, height);
            albumArt.showImage(width - 100, height - 100);
            albumArt.draw(g);
        }
    }

    public void mouseClicked(int x, int y)
    {}

    public void keyPressed(char key) {}

    public void actionPerformed(ActionEvent actionEvent)
    {
        if(actionEvent.getActionCommand().equals("artist"))
        {
            CDs_combo.removeActionListener(this);
            controller.changeArtist();
            CDs_combo.addActionListener(this);
        }
        if(actionEvent.getActionCommand().equals("cds"))
        {
            controller.changeCD();
            repaint();
        }
    }

    public void mouseDragged(MouseEvent mouseEvent) {}

    public void mouseMoved(MouseEvent mouseEvent)
    {
        if(mouseEvent.getX()< width/2+100 && mouseEvent.getX()>width/2-100 && mouseEvent.getY()< height/2+100 && mouseEvent.getY()>height/2-100)
            filter = true;
        else
        {
            filter=false;
            repaint();
        }
    }

    class Controller
    {
        public Controller(){}

        public void changeArtist()
        {
            Artist art = (Artist) artists_combo.getSelectedItem();
            fillCDs(art.iterator());
            CD selectedCD = (CD) CDs_combo.getSelectedItem();
            songs.setCD(selectedCD);
        }

        public void changeCD()
        {
            CD selectedCD = (CD) CDs_combo.getSelectedItem();
            songs.setCD(selectedCD);
        }

        public void fillArtist(java.util.Iterator<Artist> iter)
        {
            while(iter.hasNext())
            {
                artists_combo.addItem(iter.next());
            }
        }

        public void fillCDs(java.util.Iterator<CD> iter)
        {
            CDs_combo.removeAllItems();
            while(iter.hasNext())
            {
                CDs_combo.addItem(iter.next());
            }
        }
    }
}