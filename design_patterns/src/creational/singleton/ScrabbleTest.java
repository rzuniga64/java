package creational.singleton;

import java.util.LinkedList;

/**
 *  Client to test the Scrabble class.
 */
public final class ScrabbleTest {

<<<<<<< HEAD:design_patterns/src/creational/singleton/TestScrabble.java
=======
    private ScrabbleTest() { }
>>>>>>> e9d753301e8155e97ac564ee18f27399dcc56b58:design_patterns/src/creational/singleton/ScrabbleTest.java
    /**
     * Units tests for Scrabble class.
     * @param args arguments
     */
    public static void main(final String[] args) {

        // create a new instance of Singleton
        Singleton newInstance = Singleton.getInstance();

        // Get unique id for instance object
        System.out.println("Instance 1 ID: " + System.identityHashCode(newInstance));

        // Get all of the letters stored in the list
        System.out.println(newInstance.getLetterList());

        LinkedList<String> playerOneTiles = newInstance.getTiles(7);
        System.out.println("\nPlayer 1: " + playerOneTiles + "\n");
        System.out.println(newInstance.getLetterList());

        // Try to make another instance of Singleton
        Singleton instanceTwo = Singleton.getInstance();

        // Get unique id for instance object
        System.out.println("\nInstance 2 ID: " + System.identityHashCode(newInstance));

        // THIS RETURNS THE VALUE OF THE FIRST INSTANCE CREATED. WRONG!
        System.out.println(newInstance.getLetterList());

        // Player 2 draws 7 tiles
        LinkedList<String> playerTwoTiles = newInstance.getTiles(7);
        System.out.println("\nPlayer 2: " + playerTwoTiles);
    }
}
