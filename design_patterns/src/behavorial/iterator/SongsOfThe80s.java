package behavorial.iterator;

import java.util.Arrays;
import java.util.Iterator;

/**
 * The type SongsOfThe80s.
 */
class SongsOfThe80s implements SongIterator{

    private SongInfo[] bestSongs;

    private int arrayValue = 0; // Used to increment to the next position in the array

    /**
     *  Instantiate new Songs of the 80s.
     */
    SongsOfThe80s() {

        bestSongs = new SongInfo[3];

        addSong("Roam", "B 52s", 1989);
        addSong("Cruel Summer", "Bananarama", 1984);
        addSong("Head Over Heels", "Tears For Fears", 1985);
    }

    /**
     *  Add song.
     *  @param songName     the song name
     *  @param bandName     the band name
     *  @param yearReleased the year released
     */
    private void addSong(String songName, String bandName, int yearReleased){

        SongInfo song = new SongInfo(songName, bandName, yearReleased);
        bestSongs[arrayValue] = song;
        arrayValue++;
    }

    // Get rid of this
    // public SongInfo[] getBestSongs(){ return bestSongs; }

    /**
     *  NEW By adding this method I'll be able to treat all collections the same.
     *  Create an Iterator.
     */
    public Iterator createIterator() {

        return Arrays.asList(bestSongs).iterator();
    }
}
