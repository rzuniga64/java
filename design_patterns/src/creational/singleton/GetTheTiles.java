package creational.singleton;

import java.util.LinkedList;

/**
 *  GetTheTiles class.
 */
public class GetTheTiles implements Runnable {

    /** run method. */
    public void run() {

        Singleton newInstance = Singleton.getInstance();

        // Get unique id for instance object
        System.out.println("Instance ID: "
                + System.identityHashCode(newInstance));
        // Get all of the letters stored in the list
        System.out.println(newInstance.getLetterList());

        LinkedList<String> playerOneTiles = newInstance.getTiles(7);
        System.out.println("Player: " + playerOneTiles);
    }
}
