package structural.composite;

/**
 *  Class that compiles a list of songs a disc jockey will play.
 */
class DiscJockey{

    private SongComponent songList;

    /**
     *  Default constructor.
     *  @param newSongList contains every Song, SongGroup, and any Songs saved in SongGroups
     */
    DiscJockey(SongComponent newSongList){

        songList = newSongList;
    }

    /**
     *  Calls the displaySongInfo() on every Song or SongGroup stored in songList.
     */
    void getSongList(){

        songList.displaySongInfo();
    }
}