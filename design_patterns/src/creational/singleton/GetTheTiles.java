package creational.singleton;

import java.util.LinkedList;

public class GetTheTiles implements Runnable {
    public void run() {

        Singleton newInstance = Singleton.getInstance();

        // Get unique id for instance object
        System.out.println("Instance ID: " + System.identityHashCode(newInstance));
        // Get all of the letters stored in the list
        System.out.println(newInstance.getLetterList());

        LinkedList<String> playerOneTiles = newInstance.getTiles(7);
        System.out.println("Player: " + playerOneTiles);
        //System.out.println("Got Tiles");
    }
}