package structural.composite;

/**
 *  This class acts as an interface for every Song(leaf) and SongGroup(composite) we create. We throw
 *  UnsupportedOperationException so that if it doesn't make sense for a song, or song group to inherit a method they
 *  can just inherit the default implementation.
 */
abstract class SongComponent {

    /**
     *  Adds a new Song Component.
     *  @param newSongComponent is a group of songs or a single song.
     */
    public void add(SongComponent newSongComponent) {

        throw new UnsupportedOperationException();
    }

    /**
     *  Removes a Song Component.
     *  @param newSongComponent is a group of songs or a single song.
     */
    public void remove(SongComponent newSongComponent) {

        throw new UnsupportedOperationException();
    }

    /**
     *  Gets a song component.
     *  @param componentIndex is the index of a song in a list.
     *  @return index of song component
     */
    public SongComponent getComponent(int componentIndex) {

        throw new UnsupportedOperationException();
    }

    /**
     *  Gets a song name
     * @return a song name.
     */
    public String getSongName() {

        throw new UnsupportedOperationException();
    }

    /**
     *  Gets the band name.
     * @return a band name.
     */
    public String getBandName() {

        throw new UnsupportedOperationException();
    }

    /**
     *  Get the year a song was released.
     *  @return the year a song was released.
     */
    public int getReleaseYear() {

        throw new UnsupportedOperationException();
    }

    /**
     *  When this is called by a class object that extends SongComponent it will print out information specific to the
     *  Song or SongGroup.
     */
    public void displaySongInfo() {

        throw new UnsupportedOperationException();
    }
}