package behavorial.iterator;

import java.util.Iterator;

/**
 * The type Disc jockey.
 */
class DiscJockey {

    SongsOfThe70s songs70s;
    SongsOfThe80s songs80s;
    SongsOfThe90s songs90s;

    // NEW Passing in song iterators
    private SongIterator iter70sSongs;
    private SongIterator iter80sSongs;
    private SongIterator iter90sSongs;

    /**
     * Instantiates a new Disc jockey. NEW WAY Initialize the iterators
     * @param newSongs70s the new songs 70 s
     * @param newSongs80s the new songs 80 s
     * @param newSongs90s the new songs 90 s
     */

    DiscJockey(SongIterator newSongs70s, SongIterator newSongs80s, SongIterator newSongs90s) {

        iter70sSongs = newSongs70s;
        iter80sSongs = newSongs80s;
        iter90sSongs = newSongs90s;
    }

    /**
     *  Show the songs 2. Now that I can treat everything as an Iterator it cleans up the code while allowing me to
     *  treat all collections as 1.
     */
    void showTheSongs(){

        System.out.println("NEW WAY WITH ITERATOR\n");

        Iterator Songs70s = iter70sSongs.createIterator();
        Iterator Songs80s = iter80sSongs.createIterator();
        Iterator Songs90s = iter90sSongs.createIterator();

        System.out.println("Songs of the 70s\n");
        printTheSongs(Songs70s);

        System.out.println("Songs of the 80s\n");
        printTheSongs(Songs80s);

        System.out.println("Songs of the 90s\n");
        printTheSongs(Songs90s);
    }

    /**
     * Print the songs.
     * @param iterator the behavorial.iterator
     */
    private void printTheSongs(Iterator iterator){

        while(iterator.hasNext()){

            SongInfo songInfo = (SongInfo) iterator.next();

            System.out.println(songInfo.getSongName());
            System.out.println(songInfo.getBandName());
            System.out.println(songInfo.getYearReleased() + "\n");

        }
    }
}