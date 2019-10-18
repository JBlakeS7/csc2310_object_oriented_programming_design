package music;

public class ClearSingleSong implements Runnable
{
    private SingleSong single_song;

    public ClearSingleSong(SingleSong song)
    {
        single_song = song;
    }

    public void run()
    {
        single_song.clear();
    }
}
