package iterator;

import java.util.Hashtable;
import java.util.Iterator;

/**
 * The type SongsOfThe90s.
 */
class SongsOfThe90s implements SongIterator{

    // Create a Hashtable with an int as a key and SongInfo Objects
    private Hashtable<Integer, SongInfo> bestSongs = new Hashtable<>();

    private int hashKey = 0;    // Will increment the Hashtable key

    /**
     * Instantiates a new Songs of the 90 s.
     */
    SongsOfThe90s() {

        addSong("Losing My Religion", "REM", 1991);
        addSong("Creep", "Radiohead", 1993);
        addSong("Walk on the Ocean", "Toad The Wet Sprocket", 1991);
    }

    /**
     * Add a new SongInfo Object to the Hashtable and then increment the Hashtable key
     *
     * @param songName     the song name
     * @param bandName     the band name
     * @param yearReleased the year released
     */
    private void addSong(String songName, String bandName, int yearReleased){

        SongInfo songInfo = new SongInfo(songName, bandName, yearReleased);
        bestSongs.put(hashKey, songInfo);
        hashKey++;
    }

    // Get rid of this.
    // public Hashtable<Integer, SongInfo> getBestSongs(){ return bestSongs; }

    /**
     *  NEW By adding this method I'll be able to treat all collections the same
     */
    public Iterator createIterator() {

        return bestSongs.values().iterator();
    }
}
