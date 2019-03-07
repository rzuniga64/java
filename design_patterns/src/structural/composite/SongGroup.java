package structural.composite;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *  A class that can contain a group of songs or a single song.
 */
class SongGroup extends SongComponent {

    // Contains any Songs or SongGroups that are added to this ArrayList
    private ArrayList<SongComponent> songComponents = new ArrayList<>();

    private String groupName;
    private String groupDescription;

    SongGroup(String newGroupName, String newGroupDescription){

        groupName = newGroupName;
        groupDescription = newGroupDescription;
    }

    /**
     *  Get the group name for a list of songs.
     *  @return the group name
     */
    private String getGroupName() {

        return groupName;
    }

    /**
     *  Get the description for a group of songs.
     *  @return the description of a group of songs.
     */
    private String getGroupDescription() {

        return groupDescription;
    }

    /**
     *  A song to a group of songs.
     *  @param newSongComponent is a group of songs or a single song.
     */
    public void add(SongComponent newSongComponent) {

        songComponents.add(newSongComponent);
    }

    /**
     *  Remove a song from a group of songs.
     *  @param newSongComponent is a group of songs or a single song.
     */
    public void remove(SongComponent newSongComponent) {

        songComponents.remove(newSongComponent);
    }

    /**
     *  Get the index of a song in a group of songs.
     * @param componentIndex is a group of songs or a single song.
     * @return  the index.
     */
    public SongComponent getComponent(int componentIndex) {

        return songComponents.get(componentIndex);
    }

    /**
     *  Display a description for a group of songs or a song.
     */
    public void displaySongInfo(){

        System.out.println(getGroupName() + " " + getGroupDescription() + "\n");

        // Cycles through and prints any Song or SongGroups added to this SongGroups ArrayList songComponents
        Iterator songIterator = songComponents.iterator();

        while(songIterator.hasNext()) {

            SongComponent songInfo = (SongComponent) songIterator.next();
            songInfo.displaySongInfo();
        }
    }
}