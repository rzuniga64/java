package behavorial.iterator;

/**
 *  The type Song info.
 *  Will hold all of the info needed for each song: song name, band name and year the song was released.
 */
class SongInfo{

    private String songName;
    private String bandName;
    private int yearReleased;

    /**
     * Instantiates a new Song info.
     *
     * @param newSongName     the new song name
     * @param newBandName     the new band name
     * @param newYearReleased the new year released
     */
    SongInfo(String newSongName, String newBandName, int newYearReleased){

        songName = newSongName;
        bandName = newBandName;
        yearReleased = newYearReleased;
    }

    /**
     * Get song name string.
     *
     * @return the song name as a string string
     */
    String getSongName(){ return songName; }

    /**
     * Get band name string.
     *
     * @return the band name as a string
     */
    String getBandName(){ return bandName; }

    /**
     * Get year released int.
     *
     * @return the year a song was released as aint
     */
    int getYearReleased(){ return yearReleased; }
}