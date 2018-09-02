package structural.composite;

/**
 *  A class that can contain data about a song.
 */
class Song extends SongComponent {

    private String songName;
    private String bandName;
    private int releaseYear;

    Song(String newSongName, String newBandName, int newReleaseYear){

        songName = newSongName;
        bandName = newBandName;
        releaseYear = newReleaseYear;
    }

    /**
     *  Get the song name.
     *  @return the song name.
     */
    public String getSongName() {

        return songName;
    }

    /**
     *  Get the band name who played the song.
     *  @return the band name.
     */
    public String getBandName() {

        return bandName;
    }

    /**
     *  Get the year a song was released.
     *  @return the year a song was released.
     */
    public int getReleaseYear() {

        return releaseYear;
    }

    /**
     *  Display data about a song.
     */
    public void displaySongInfo(){

        System.out.println(getSongName() + " was recorded by " + getBandName() + " in " + getReleaseYear());
    }
}