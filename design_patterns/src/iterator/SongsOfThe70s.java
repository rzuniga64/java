package iterator;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * The type SongsOfThe70s.
 */
class SongsOfThe70s implements SongIterator{

    private ArrayList<SongInfo> bestSongs;

    /**
     * Instantiates a new Songs of the 70 s.
     */
    SongsOfThe70s() {

        bestSongs = new ArrayList<>();

        addSong("Imagine", "John Lennon", 1971);
        addSong("American Pie", "Don McLean", 1971);
        addSong("I Will Survive", "Gloria Gaynor", 1979);
    }

    /**
     * Add a SongInfo object to the end of the ArrayList
     *
     * @param songName     the song name
     * @param bandName     the band name
     * @param yearReleased the year released
     */
    private void addSong(String songName, String bandName, int yearReleased){

        SongInfo songInfo = new SongInfo(songName, bandName, yearReleased);
        bestSongs.add(songInfo);
    }

    // Get rid of this
    //public ArrayList<SongInfo> getBestSongs(){ return bestSongs; }

    /**
     * NEW By adding this method I'll be able to treat all collections the same
     */
    public Iterator createIterator() {

        return bestSongs.iterator();
    }
}