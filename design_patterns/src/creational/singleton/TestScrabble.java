package creational.singleton;

import java.util.LinkedList;

/**
 *  Client to test the Scrabble class.
 */
public final class TestScrabble {

    private TestScrabble() { }
    /**
     * Units tests for Scrabble class.
     * @param args arguments
     */
    public static void main(final String[] args) {

        // create a new instance of Singleton
        Singleton instanceOne = Singleton.getInstance();

        // Get unique id for instance object
        System.out.println("Instance 1 ID: "
                + System.identityHashCode(instanceOne));

        // Get all of the letters stored in the list
        System.out.println(instanceOne.getLetterList());

        LinkedList<String> playerOneTiles = instanceOne.getTiles(7);
        System.out.println("\nPlayer 1: " + playerOneTiles + "\n");
        System.out.println(instanceOne.getLetterList());

        // Try to make another instance of Singleton
        Singleton instanceTwo = Singleton.getInstance();

        // Get unique id for instance object
        System.out.println("\nInstance 2 ID: "
                + System.identityHashCode(instanceOne));

        // THIS RETURNS THE VALUE OF THE FIRST INSTANCE CREATED. WRONG!
        System.out.println(instanceOne.getLetterList());

        // Player 2 draws 7 tiles
        LinkedList<String> playerTwoTiles = instanceOne.getTiles(7);
        System.out.println("\nPlayer 2: " + playerTwoTiles);
    }
}
